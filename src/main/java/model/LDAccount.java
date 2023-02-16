package model;

public class LDAccount {


    private int id;
    private String userName;
    private String pasWord;
    private String role_acc;
    private String status;

    public LDAccount(String userName, String pasWord, String role_acc, String status) {
        this.userName = userName;
        this.pasWord = pasWord;
        this.role_acc = role_acc;
        this.status = status;
    }

    public LDAccount(int id, String userName, String pasWord, String role_acc, String status) {
        this.id = id;
        this.userName = userName;
        this.pasWord = pasWord;
        this.role_acc = role_acc;
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

    public String getPasWord() {
        return pasWord;
    }

    public void setPasWord(String pasWord) {
        this.pasWord = pasWord;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole_acc() {
        return role_acc;
    }

    public void setRole_acc(String role_acc) {
        this.role_acc = role_acc;
    }
}
