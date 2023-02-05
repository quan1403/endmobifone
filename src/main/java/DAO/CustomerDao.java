package DAO;

import connect.Connect_MySQL;
import model.Account;
import model.Customer;
import model.Login;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    private static final String INSERT_CUSTOMER_SQL = "insert into customer value (?,?,?,?,?,?);";
    public boolean create(Customer customer) {
        try (Connection connection = Connect_MySQL.getConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL);
            preparedStatement.setInt(1,customer.getIdCustomer());
            preparedStatement.setString(2, customer.getNameCompany());
            preparedStatement.setString(3, customer.getFullName());
            preparedStatement.setString(4, customer.getPhoneNumber());
            preparedStatement.setString(5,customer.getEmail());
            preparedStatement.setString(6,customer.getProduct());
            return preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
    public List<Customer> getAll() {
        String sql = "select * from customer";
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = Connect_MySQL.getConnect()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int idCustomer = resultSet.getInt("idCustomer");
                String nameCompany = resultSet.getString("nameCompany");
                String fullName = resultSet.getString("fullName");
                String phoneNumber = resultSet.getString("phoneNumber");
                String email = resultSet.getString("email");
                String product = resultSet.getString("product");
                customers.add(new Customer(idCustomer,nameCompany,fullName,phoneNumber,email,product));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customers;
    }
    public int getTotalCustomer() {
        String sql = "select count(*) from demo5.customer";
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
    public List<Customer> pagingCustomer(int index) {
        List<Customer> list = new ArrayList<>();
        String sql = "select * from demo5.customer limit 3 OFFSET ?;";
        try (Connection connection = Connect_MySQL.getConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, (index - 1) * 3);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idCustomer = resultSet.getInt("idCustomer");
                String nameCompany = resultSet.getString("nameCompany");
                String fullName = resultSet.getString("fullName");
                String phoneNumber = resultSet.getString("phoneNumber");
                String email = resultSet.getString("email");
                String product = resultSet.getString("product");
                list.add(new Customer(idCustomer, nameCompany, fullName, phoneNumber, email,product));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
}
