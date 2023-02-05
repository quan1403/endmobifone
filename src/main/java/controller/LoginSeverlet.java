package controller;

import DAO.AccountDao;
import model.Account;
import model.Login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(urlPatterns = "/login")
public class LoginSeverlet  extends HttpServlet {
    AccountDao accountDAO = new AccountDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/html/login.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("userName");
        String password = req.getParameter("passWord");
        Account account = accountDAO.getAccount(username, password);
        if (account==null){
            Account ac = new Account("admin","admin","admin","normal");
            accountDAO.create(ac);
            Login.account = account;
            resp.sendRedirect("/account");
        }
        if ((account != null)&&(account.getStatus().equals("normal"))) {
            Login.account = account;
            if(account.getRole().equals("admin")) {
                resp.sendRedirect("/account");
            } else {
                resp.sendRedirect("/customer");
            }

        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/html/login.jsp");
            dispatcher.forward(req, resp);

        }
    }
}




