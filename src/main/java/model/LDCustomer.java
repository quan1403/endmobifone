package model;

import java.sql.Date;

public class LDCustomer implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
   private int idCustomer;
   private String nameCompany;
   private String fullName;
   private String phoneNumber;
   private String email;
   private String product;
   private Date datedk;




    public LDCustomer(String nameCompany, String fullName, String phoneNumber, String email, String product, Date datedk) {
        this.nameCompany = nameCompany;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.product = product;
        this.datedk = datedk;



    }

    public LDCustomer(int idCustomer, String nameCompany, String fullName, String phoneNumber, String email, String product, Date datedk) {
        this.idCustomer = idCustomer;
        this.nameCompany = nameCompany;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.product = product;
        this.datedk = datedk;

    }



    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public LDCustomer() {
    }

    public Date getDatedk() {
        return datedk;
    }

    public void setDatedk(Date datedk) {
        this.datedk = datedk;
    }
}
