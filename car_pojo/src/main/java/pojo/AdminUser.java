package pojo;

import java.util.Date;

public class AdminUser {
    private Integer id;

    private String username;

    private String password;

    private String name;

    private String salt;

    private String phone;

    private String email;

    private Byte status;

    private Date createTime;

    private Byte isSuper;

    private String consumer;

    private String remark;

    private String dept;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getIsSuper() {
        return isSuper;
    }

    public void setIsSuper(Byte isSuper) {
        this.isSuper = isSuper;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer == null ? null : consumer.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept == null ? null : dept.trim();
    }

    public AdminUser() {
    }

    public AdminUser(String username, String password, String name, String phone, String email, Byte isSuper, String remark, String dept) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.isSuper = isSuper;
        this.remark = remark;
        this.dept = dept;
    }

    public AdminUser(Integer id, String username, String password, String name, String phone, String email, Byte isSuper, String remark, String dept) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.isSuper = isSuper;
        this.remark = remark;
        this.dept = dept;
    }

    public AdminUser(Integer id, String username, String password, String name, String salt, String phone, String email, Byte status, Date createTime, Byte isSuper, String consumer, String remark, String dept) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.salt = salt;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.createTime = createTime;
        this.isSuper = isSuper;
        this.consumer = consumer;
        this.remark = remark;
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "AdminUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", salt='" + salt + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", isSuper=" + isSuper +
                ", consumer='" + consumer + '\'' +
                ", remark='" + remark + '\'' +
                ", dept='" + dept + '\'' +
                '}';
    }
}