package model;

public class Account  {


    private int id;
    private String userName;
    private String passWord;
    private String role;
    private String status;

    public Account(String userName, String passWord, String role, String status) {
        this.userName = userName;
        this.passWord = passWord;
        this.role = role;
        this.status = status;
    }

    public Account(int id, String userName, String passWord, String role, String status) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.role = role;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
