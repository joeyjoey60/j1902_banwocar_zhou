package pojo;

public class AdminPermission {
    private Integer permissionId;

    private String perName;

    private String menuName;

    private String menuType;

    private String menuUrl;

    private String menuCode;

    private String parentCode;

    private String perDesc;

    private Byte ifVilid;

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getPerName() {
        return perName;
    }

    public void setPerName(String perName) {
        this.perName = perName == null ? null : perName.trim();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType == null ? null : menuType.trim();
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode == null ? null : menuCode.trim();
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

    public String getPerDesc() {
        return perDesc;
    }

    public void setPerDesc(String perDesc) {
        this.perDesc = perDesc == null ? null : perDesc.trim();
    }

    public Byte getIfVilid() {
        return ifVilid;
    }

    public void setIfVilid(Byte ifVilid) {
        this.ifVilid = ifVilid;
    }

    @Override
    public String toString() {
        return "AdminPermission{" +
                "permissionId=" + permissionId +
                ", perName='" + perName + '\'' +
                ", menuName='" + menuName + '\'' +
                ", menuType='" + menuType + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", menuCode='" + menuCode + '\'' +
                ", parentCode='" + parentCode + '\'' +
                ", perDesc='" + perDesc + '\'' +
                ", ifVilid=" + ifVilid +
                '}';
    }
}