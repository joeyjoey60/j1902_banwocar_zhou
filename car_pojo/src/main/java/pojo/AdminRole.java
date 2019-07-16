package pojo;

import java.io.Serializable;

public class AdminRole implements Serializable {
    @Override
    public String toString() {
        return "AdminRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deleted=" + deleted +
                '}';
    }

    public AdminRole(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public AdminRole() {
    }

    public AdminRole(Integer id, String name, Byte deleted) {
        this.id = id;
        this.name = name;
        this.deleted = deleted;
    }

    private Integer id;

    private String name;

    private Byte deleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }
}