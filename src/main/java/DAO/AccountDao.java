package DAO;

import connect.Connect_MySQL;
import model.Account;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AccountDao implements CRUD<Account> {
    String sql = "select * from account where userName = ? and passWord =? ";
    private static final String INSERT_ACCOUNT_SQL = "insert into account value (?,?,?,?,?);";

    public Account getAccount(String username, String password) {
        try (Connection connection = Connect_MySQL.getConnect()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();
            int id = resultSet.getInt("id");
            String userName = resultSet.getString("userName");
            String passWord = resultSet.getString("passWord");
            String role = resultSet.getString("role");
           String status = resultSet.getString("status");

            return new Account(id, userName, passWord, role, status);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean create(Account account) {
        try (Connection connection = Connect_MySQL.getConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACCOUNT_SQL);
            preparedStatement.setInt(1, account.getId());
            preparedStatement.setString(2, account.getUserName());
            preparedStatement.setString(3, account.getPassWord());
            preparedStatement.setString(4, account.getRole());
            preparedStatement.setString(5,account.getStatus());
            return preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public Account findById(int id) {
        String sql = "select * from account where id = " + id;
        try (Connection connection = Connect_MySQL.getConnect()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();
           int idS = resultSet.getInt("id");
            String userName = resultSet.getString("userName");
            String passWord = resultSet.getString("passWord");
            String role = resultSet.getString("role");
            String status = resultSet.getString("status");
            return new Account(idS, userName, passWord, role, status);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Account> getAll() {
        String sql = "select * from account";
        List<Account> accounts = new ArrayList<>();
        try (Connection connection = Connect_MySQL.getConnect()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("userName");
                String passWord = resultSet.getString("passWord");
                String role = resultSet.getString("role");
                String status = resultSet.getString("status");
                accounts.add(new Account(id, userName, passWord, role, status));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return accounts;
    }

    @Override
    public boolean edit(int id, Account account) {
        String sql = "UPDATE `demo5`.`account` SET `userName` = ?, `passWord`= ?,`role`  = ? WHERE (`id` = ?); ";
        try (Connection connection = Connect_MySQL.getConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(4, account.getId());
            preparedStatement.setString(1, account.getUserName());
            preparedStatement.setString(2, account.getPassWord());
            preparedStatement.setString(3, account.getRole());
            return preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String sql = "delete from account WHERE id = ?";
        try (Connection connection = Connect_MySQL.getConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            return preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public List<Account> getSearch(String searchName) {
        String sql = "select * from account where userName like concat('%',?,'%')";
        List<Account> accountList = new ArrayList<>();
        try (Connection connection = Connect_MySQL.getConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, searchName);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("userName");
                String passWord = resultSet.getString("passWord");
                String role = resultSet.getString("role");
                String status = resultSet.getString("status");
                accountList.add(new Account(id, userName, passWord, role, status));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return accountList;
    }

    public int getTotalAccount() {
        String sql = "select count(*) from demo5.account";
        try (Connection connection = Connect_MySQL.getConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getInt(1);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 0;

    }

    @Override
    public List<Account> pagingAccount(int index) {
        List<Account> list = new ArrayList<>();
        String sql = "select * from demo5.account limit 3 OFFSET ?;";
        try (Connection connection = Connect_MySQL.getConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, (index - 1) * 3);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("userName");
                String passWord = resultSet.getString("passWord");
                String role = resultSet.getString("role");
                String status = resultSet.getString("status");
                list.add(new Account(id, userName, passWord, role, status));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    @Override
    public boolean lock(int id ,String status) {
        String sql = "UPDATE `demo5`.`account` SET `status` = ? WHERE (`id` = ?); ";
        try (Connection connection = Connect_MySQL.getConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, id);
            preparedStatement.setInt(2, id);
            preparedStatement.setString(1,status);


            return preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }
}
