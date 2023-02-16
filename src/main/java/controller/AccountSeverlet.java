package controller;

import DAO.AccountDao;
import model.LDAccount;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/account")
public class AccountSeverlet extends HttpServlet {
    AccountDao accountDao = new AccountDao();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showCreate(req,resp);
                req.getRequestDispatcher("/html/admin.jsp");
                break;
            case "edit":
                showEditForm(req,resp);
                req.getRequestDispatcher("/html/admin.jsp");
                break;
            case "delete":
                showDelete(req,resp);
                req.getRequestDispatcher("/html/admin.jsp");
                break;

            case "lock":
                lockAccount(req,resp);
                break;

            default:
                showAccount(req,resp);
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
            case "create":
                createAccount(req, resp);
                break;
            case "edit":
                updateAccount(req, resp);
                break;
            case "delete":
                deleteAccount(req, resp);
                break;

            case "search":
                String searchName = req.getParameter("searchName");
                if (searchName==""){
                    showAccount(req, resp);
                }else {
                    List<LDAccount> accounts = accountDao.getSearch(searchName);
                    req.setAttribute("accounts", accounts);
                    RequestDispatcher dispatcher = req.getRequestDispatcher("/html/admin.jsp");
                    dispatcher.forward(req, resp);
                }
                break;
            default:
                break;
        }
    }

    public void showAccount(HttpServletRequest request, HttpServletResponse response) {
    String indexPage = request.getParameter("index");

      if (indexPage == null){
          indexPage = "1";

       }
     int index = Integer.parseInt(indexPage);
    AccountDao accountDao = new AccountDao();
      int count = accountDao.getTotalAccount();
      int endPage = count/3;
       if (count % 3 != 0){
            endPage++;
       }
       request.setAttribute("page",endPage);
        List<LDAccount> accounts = accountDao.pagingAccount(index);
//        List<LDAccount> accounts = accountDao.getAll();
        request.setAttribute("accounts", accounts);
       request.setAttribute("tag",index);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/html/admin.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void showCreate(HttpServletRequest request, HttpServletResponse response) {
        List<LDAccount> accounts = accountDao.getAll();
        request.setAttribute("accounts", accounts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/html/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        LDAccount account = accountDao.findById(id);
        RequestDispatcher dispatcher;
        if (account == null) {
            dispatcher = request.getRequestDispatcher("/html/error-404.jsp");
        } else {
            request.setAttribute("accounts", account);
            dispatcher = request.getRequestDispatcher("/html/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        LDAccount account = accountDao.findById(id);
        RequestDispatcher dispatcher;
        if (account == null) {
            dispatcher = request.getRequestDispatcher("/html/error-404.jsp");
        } else {
            request.setAttribute("accounts", account);
            dispatcher = request.getRequestDispatcher("/html/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createAccount(HttpServletRequest request, HttpServletResponse response) {
//       int id = Integer.parseInt(request.getParameter("id"));
        String userName = request.getParameter("userName");
        String pasWord = request.getParameter("pasWord");
        String role_acc = request.getParameter("role_acc");
        String status = request.getParameter("status");
        if (status == null){
            status = "normal";
        }
        LDAccount ac = new LDAccount( userName, pasWord,role_acc,status);
            accountDao.create(ac);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/html/create.jsp");
            request.setAttribute("message", "New account was created");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    public void updateAccount(HttpServletRequest request, HttpServletResponse response) {
       int id = Integer.parseInt(request.getParameter("id"));
        String userName = request.getParameter("userName");
        String pasWord = request.getParameter("pasWord");
        String role_acc = request.getParameter("role_acc");
        String status = request.getParameter("status");
        LDAccount account = new LDAccount(id, userName, pasWord, role_acc,status);
        RequestDispatcher dispatcher;
        if (account == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {

            accountDao.edit(id, account);
            request.setAttribute("accounts", account);
            request.setAttribute("message", "Account information was updated");
            dispatcher = request.getRequestDispatcher("/html/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteAccount(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));

        LDAccount account = accountDao.findById(id);
        if (account == null) {
            request.getRequestDispatcher("error-404.jsp");
        } else {
            accountDao.delete(id);
            try {
                response.sendRedirect("/account");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void lockAccount(HttpServletRequest request, HttpServletResponse response) {

        int id = Integer.parseInt(request.getParameter("id"));
        String status = request.getParameter("status");


        if (status.equals("normal") ) {
           status = "lock";
        }else if (status.equals("lock")){
            status = "normal";
        }
            accountDao.lock(id,status);

        try {
            response.sendRedirect("/account");
        } catch (IOException e) {
            e.printStackTrace();
        }
        }

}
