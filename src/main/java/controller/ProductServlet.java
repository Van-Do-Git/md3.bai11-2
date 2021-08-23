package controller;

import model.Products;
import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import sevice.ProductsManager;
import sevice.ProductsManagerImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet(name = "products", value = "/Products")
public class ProductServlet extends HttpServlet {
    private ProductsManager productsManager = new ProductsManagerImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "creat":
                showFromCreat(req, resp);
                break;
            case "update":
                showUpdateForm(req, resp);
                break;
            case "delete":
                break;
            case "view":
                break;
            case "search":
                showFormSearch(req, resp);
                break;
            default:
                showAllProduct(req, resp);
        }
    }

    private void showUpdateForm(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        Products products = productsManager.findById(Integer.parseInt(id));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/products/update.jsp");
        req.setAttribute("product", products);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormSearch(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/products/search.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchByID(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        Products products = productsManager.findById(Integer.parseInt(id));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/products/search.jsp");
        if (products == null) {
            req.setAttribute("message", "Not found");
        } else {
            req.setAttribute("message", null);
            req.setAttribute("product", products);
        }
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showFromCreat(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/products/creat.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAllProduct(HttpServletRequest req, HttpServletResponse resp) {
        List<Products> list = productsManager.getlistProduct();
        req.setAttribute("productlist", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/products/listProduct.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "creat":
                creatProduct(req, resp);
                break;
            case "update":
                update(req, resp);
                break;
            case "delete":
                break;
            case "view":
                break;
            case "search":
                searchByID(req, resp);
                break;
            default:
                showAllProduct(req, resp);
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String url = req.getParameter("url");
        int price = Integer.parseInt(req.getParameter("price"));
        int id = Integer.parseInt(req.getParameter("id"));
        Products products = productsManager.findById(id);
        products.setName(name);
        products.setUrl(url);
        products.setPrice(price);
        productsManager.update(products.getId(), products);
        req.setAttribute("message", "Update successful");
        req.setAttribute("product", products);
        RequestDispatcher dispatcher = req.getRequestDispatcher("products/update.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void creatProduct(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String url = req.getParameter("url");
        int price = Integer.parseInt(req.getParameter("price"));
        Products products = new Products(name, url, price);
        productsManager.save(products);
        req.setAttribute("message", "Created successful");
        RequestDispatcher dispatcher = req.getRequestDispatcher("products/creat.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
