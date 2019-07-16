package pojo;

public class AdminUserLogin {
    private Integer id;

    private String uname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public AdminUserLogin(Integer id, String uname) {
        this.id = id;
        this.uname = uname;
    }

    @Override
    public String toString() {
        return "AdminUserLogin{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                '}';
    }

    public AdminUserLogin() {
    }
}