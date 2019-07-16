package pojo;

import java.util.Date;

public class OperateLog {
    private Long id;

    private Date operateTime;

    private Integer operateUid;

    private String tableName;

    private String tableDisname;

    private Long dataId;

    private String operateDesc;

    private String uname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public Integer getOperateUid() {
        return operateUid;
    }

    public void setOperateUid(Integer operateUid) {
        this.operateUid = operateUid;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public String getTableDisname() {
        return tableDisname;
    }

    public void setTableDisname(String tableDisname) {
        this.tableDisname = tableDisname == null ? null : tableDisname.trim();
    }

    public Long getDataId() {
        return dataId;
    }

    public void setDataId(Long dataId) {
        this.dataId = dataId;
    }

    public String getOperateDesc() {
        return operateDesc;
    }

    public void setOperateDesc(String operateDesc) {
        this.operateDesc = operateDesc == null ? null : operateDesc.trim();
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public OperateLog(Integer operateUid, String tableName, String operateDesc) {
        this.operateUid = operateUid;
        this.tableName = tableName;
        this.operateDesc = operateDesc;
    }

    public OperateLog(Integer operateUid, String tableName, String operateDesc, String uname) {
        this.operateUid = operateUid;
        this.tableName = tableName;
        this.operateDesc = operateDesc;
        this.uname = uname;
    }

    public OperateLog(Date operateTime, Integer operateUid, String tableName, String operateDesc, String uname) {
        this.operateTime = operateTime;
        this.operateUid = operateUid;
        this.tableName = tableName;
        this.operateDesc = operateDesc;
        this.uname = uname;
    }

    public OperateLog(Long id, Date operateTime, Integer operateUid, String tableName, String tableDisname, Long dataId, String operateDesc, String uname) {
        this.id = id;
        this.operateTime = operateTime;
        this.operateUid = operateUid;
        this.tableName = tableName;
        this.tableDisname = tableDisname;
        this.dataId = dataId;
        this.operateDesc = operateDesc;
        this.uname = uname;
    }

    public OperateLog() {
    }
}