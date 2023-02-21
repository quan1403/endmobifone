package DAO;

import connect.Connect_MySQL;
import connect.Connect_Oracle;
import model.LDAccount;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDao implements CRUD<LDAccount> {


    public LDAccount getAccount(String username, String pasword) {
        String sql = "select * from LDAccount where userName = ? and pasWord =? ";
        try (Connection connection = Connect_Oracle.getConnectOracle()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, pasword);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();
            int id = resultSet.getInt("id");
            String userName = resultSet.getString("userName");
            String passWord = resultSet.getString("pasWord");
            String role_acc = resultSet.getString("role_acc");
           String status = resultSet.getString("status");

            return new LDAccount(id, userName, passWord, role_acc, status);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean create(LDAccount account) {
        String sql = "insert into mfsoft.LDAccount values (?,?,?,?,?)";
        try (Connection connection = Connect_Oracle.getConnectOracle()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, account.getId());
            preparedStatement.setString(2, account.getUserName());
            preparedStatement.setString(3, account.getPasWord());
            preparedStatement.setString(4, account.getRole_acc());
            preparedStatement.setString(5,account.getStatus());
            return preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public LDAccount findById(int id) {
        String sql = "select * from LDAccount where id = " + id;
        try (Connection connection = Connect_Oracle.getConnectOracle()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();
           int idS = resultSet.getInt("id");
            String userName = resultSet.getString("userName");
            String passWord = resultSet.getString("pasWord");
            String role = resultSet.getString("role_acc");
            String status = resultSet.getString("status");
            return new LDAccount(idS, userName, passWord, role, status);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<LDAccount> getAll() {
        String sql = "select * from LDAccount order by rownum desc";
        List<LDAccount> accounts = new ArrayList<>();
        try (Connection connection = Connect_Oracle.getConnectOracle()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("userName");
                String passWord = resultSet.getString("pasWord");
                String role_acc = resultSet.getString("role_acc");
                String status = resultSet.getString("status");
                accounts.add(new LDAccount(id, userName, passWord, role_acc, status));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return accounts;
    }

    @Override
    public boolean edit(int id, LDAccount account) {
        String sql = "update LDAccount set userName = ?, pasWord =  ? , role_acc  = ? WHERE ( id  = ? ) ";
        try (Connection connection = Connect_Oracle.getConnectOracle()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(4, account.getId());
            preparedStatement.setString(1, account.getUserName());
            preparedStatement.setString(2, account.getPasWord());
            preparedStatement.setString(3, account.getRole_acc());
            return preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String sql = "delete from LDAccount WHERE id = ?";
        try (Connection connection = Connect_Oracle.getConnectOracle()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            return preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public List<LDAccount> getSearch(String searchName) {
        String sql = "select * from LDAccount where userName like ? ";
        List<LDAccount> accountList = new ArrayList<>();
        try (Connection connection = Connect_Oracle.getConnectOracle()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%"+ searchName + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("userName");
                String pasWord = resultSet.getString("pasWord");
                String role_acc = resultSet.getString("role_acc");
                String status = resultSet.getString("status");
                accountList.add(new LDAccount(id, userName, pasWord, role_acc, status));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return accountList;
    }

    public int getTotalAccount() {
        String sql = "select count(*) from LDAccount";
        try (Connection connection = Connect_Oracle.getConnectOracle()) {
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
    public List<LDAccount> pagingAccount(int index) {
        List<LDAccount> list = new ArrayList<>();
        String sql = "SELECT * FROM (\n" +
                "         SELECT ldaccount.*,\n" +
                "                row_number() over (partition by 1 order by 1) as rnum\n" +
                "         from ldaccount\n order by id desc" +
                "     )\n" +
                "where  rnum <= ?--limit\n" +
                "  and rnum > ? --offset ";
        try (Connection connection = Connect_Oracle.getConnectOracle()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, (index *10));
            preparedStatement.setInt(2, (index - 1) * 10);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("userName");
                String pasWord = resultSet.getString("pasWord");
                String role_acc = resultSet.getString("role_acc");
                String status = resultSet.getString("status");
                list.add(new LDAccount(id, userName, pasWord, role_acc, status));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public boolean lock(int id ,String status) {
        String sql = "UPDATE LDAccount SET status = ? WHERE (id = ?) ";
        try (Connection connection = Connect_Oracle.getConnectOracle()) {
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
