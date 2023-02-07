package controller;

import DAO.CustomerDao;
import model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@WebServlet(urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {

    CustomerDao customerDao = new CustomerDao();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            default:
                showCustomer(req,resp);
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "show":
                showCustomer(req,resp);
                break;
            case "register":
                createCustome(req, resp);
                break;
            case "search":
                String searchName = req.getParameter("searchName");
                if (searchName==""){
                    showCustomer(req, resp);
                }else {
                    List<Customer> customers = customerDao.getSearch(searchName);
                    req.setAttribute("customers", customers);
                    RequestDispatcher dispatcher = req.getRequestDispatcher("/html/customer.jsp");
                    dispatcher.forward(req, resp);
                }
                break;
            default:
                break;
        }
    }

    public void createCustome(HttpServletRequest request, HttpServletResponse response) {
//        int idCustomer = Integer.parseInt(request.getParameter("idCustomer"));
        String nameCompany = request.getParameter("nameCompany");
        String fullName = request.getParameter("fullName");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String product = request.getParameter("product");
        Date date = new Date();
        Customer cus = new Customer(nameCompany, fullName, phoneNumber, email, product,date);
        customerDao.create(cus);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/html/thanks.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void showCustomer(HttpServletRequest request, HttpServletResponse response) {
        String indexPage = request.getParameter("index");

        if (indexPage == null){
            indexPage = "1";

        }
        int index = Integer.parseInt(indexPage);
        CustomerDao customerDao = new CustomerDao();
        int count = customerDao.getTotalCustomer();
        int endPage = count/3;
        if (count % 3 != 0){
            endPage++;
        }
        request.setAttribute("page",endPage);
        List<Customer> customers = customerDao.pagingCustomer(index);
        request.setAttribute("customers", customers);
        request.setAttribute("tag",index);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/html/customer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

