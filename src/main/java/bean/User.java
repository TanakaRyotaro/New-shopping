package bean;

public class User implements java.io.Serializable {
    
    private int userid;
    private String name;
    private String password;

    public int getUserid() {
        return userid;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }

    public void setUserid(int userid) {
        this.userid=userid;
    }
    public void setName(String name) {
        this.name=name;
    }
    public void setPassword(String password) {
        this.password=password;
    }
}