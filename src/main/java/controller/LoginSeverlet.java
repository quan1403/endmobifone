package controller;

import DAO.AccountDao;
import model.LDAccount;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
        String pasword = req.getParameter("pasWord");
        LDAccount account = accountDAO.getAccount(username, pasword);
        HttpSession session = req.getSession();
        String name = req.getParameter("userName");
        session.setAttribute("user",name);
        if ((account != null)&&(account.getStatus().equals("normal"))) {
            if(account.getRole_acc().equals("admin")) {
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




