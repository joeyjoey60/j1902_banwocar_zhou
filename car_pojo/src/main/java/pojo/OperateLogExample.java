package pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperateLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OperateLogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOperateTimeIsNull() {
            addCriterion("OPERATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andOperateTimeIsNotNull() {
            addCriterion("OPERATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andOperateTimeEqualTo(Date value) {
            addCriterion("OPERATE_TIME =", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeNotEqualTo(Date value) {
            addCriterion("OPERATE_TIME <>", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeGreaterThan(Date value) {
            addCriterion("OPERATE_TIME >", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("OPERATE_TIME >=", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeLessThan(Date value) {
            addCriterion("OPERATE_TIME <", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeLessThanOrEqualTo(Date value) {
            addCriterion("OPERATE_TIME <=", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeIn(List<Date> values) {
            addCriterion("OPERATE_TIME in", values, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeNotIn(List<Date> values) {
            addCriterion("OPERATE_TIME not in", values, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeBetween(Date value1, Date value2) {
            addCriterion("OPERATE_TIME between", value1, value2, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeNotBetween(Date value1, Date value2) {
            addCriterion("OPERATE_TIME not between", value1, value2, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateUidIsNull() {
            addCriterion("OPERATE_UID is null");
            return (Criteria) this;
        }

        public Criteria andOperateUidIsNotNull() {
            addCriterion("OPERATE_UID is not null");
            return (Criteria) this;
        }

        public Criteria andOperateUidEqualTo(Integer value) {
            addCriterion("OPERATE_UID =", value, "operateUid");
            return (Criteria) this;
        }

        public Criteria andOperateUidNotEqualTo(Integer value) {
            addCriterion("OPERATE_UID <>", value, "operateUid");
            return (Criteria) this;
        }

        public Criteria andOperateUidGreaterThan(Integer value) {
            addCriterion("OPERATE_UID >", value, "operateUid");
            return (Criteria) this;
        }

        public Criteria andOperateUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("OPERATE_UID >=", value, "operateUid");
            return (Criteria) this;
        }

        public Criteria andOperateUidLessThan(Integer value) {
            addCriterion("OPERATE_UID <", value, "operateUid");
            return (Criteria) this;
        }

        public Criteria andOperateUidLessThanOrEqualTo(Integer value) {
            addCriterion("OPERATE_UID <=", value, "operateUid");
            return (Criteria) this;
        }

        public Criteria andOperateUidIn(List<Integer> values) {
            addCriterion("OPERATE_UID in", values, "operateUid");
            return (Criteria) this;
        }

        public Criteria andOperateUidNotIn(List<Integer> values) {
            addCriterion("OPERATE_UID not in", values, "operateUid");
            return (Criteria) this;
        }

        public Criteria andOperateUidBetween(Integer value1, Integer value2) {
            addCriterion("OPERATE_UID between", value1, value2, "operateUid");
            return (Criteria) this;
        }

        public Criteria andOperateUidNotBetween(Integer value1, Integer value2) {
            addCriterion("OPERATE_UID not between", value1, value2, "operateUid");
            return (Criteria) this;
        }

        public Criteria andTableNameIsNull() {
            addCriterion("TABLE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTableNameIsNotNull() {
            addCriterion("TABLE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTableNameEqualTo(String value) {
            addCriterion("TABLE_NAME =", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotEqualTo(String value) {
            addCriterion("TABLE_NAME <>", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameGreaterThan(String value) {
            addCriterion("TABLE_NAME >", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameGreaterThanOrEqualTo(String value) {
            addCriterion("TABLE_NAME >=", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLessThan(String value) {
            addCriterion("TABLE_NAME <", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLessThanOrEqualTo(String value) {
            addCriterion("TABLE_NAME <=", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLike(String value) {
            addCriterion("TABLE_NAME like", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotLike(String value) {
            addCriterion("TABLE_NAME not like", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameIn(List<String> values) {
            addCriterion("TABLE_NAME in", values, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotIn(List<String> values) {
            addCriterion("TABLE_NAME not in", values, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameBetween(String value1, String value2) {
            addCriterion("TABLE_NAME between", value1, value2, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotBetween(String value1, String value2) {
            addCriterion("TABLE_NAME not between", value1, value2, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableDisnameIsNull() {
            addCriterion("TABLE_DISNAME is null");
            return (Criteria) this;
        }

        public Criteria andTableDisnameIsNotNull() {
            addCriterion("TABLE_DISNAME is not null");
            return (Criteria) this;
        }

        public Criteria andTableDisnameEqualTo(String value) {
            addCriterion("TABLE_DISNAME =", value, "tableDisname");
            return (Criteria) this;
        }

        public Criteria andTableDisnameNotEqualTo(String value) {
            addCriterion("TABLE_DISNAME <>", value, "tableDisname");
            return (Criteria) this;
        }

        public Criteria andTableDisnameGreaterThan(String value) {
            addCriterion("TABLE_DISNAME >", value, "tableDisname");
            return (Criteria) this;
        }

        public Criteria andTableDisnameGreaterThanOrEqualTo(String value) {
            addCriterion("TABLE_DISNAME >=", value, "tableDisname");
            return (Criteria) this;
        }

        public Criteria andTableDisnameLessThan(String value) {
            addCriterion("TABLE_DISNAME <", value, "tableDisname");
            return (Criteria) this;
        }

        public Criteria andTableDisnameLessThanOrEqualTo(String value) {
            addCriterion("TABLE_DISNAME <=", value, "tableDisname");
            return (Criteria) this;
        }

        public Criteria andTableDisnameLike(String value) {
            addCriterion("TABLE_DISNAME like", value, "tableDisname");
            return (Criteria) this;
        }

        public Criteria andTableDisnameNotLike(String value) {
            addCriterion("TABLE_DISNAME not like", value, "tableDisname");
            return (Criteria) this;
        }

        public Criteria andTableDisnameIn(List<String> values) {
            addCriterion("TABLE_DISNAME in", values, "tableDisname");
            return (Criteria) this;
        }

        public Criteria andTableDisnameNotIn(List<String> values) {
            addCriterion("TABLE_DISNAME not in", values, "tableDisname");
            return (Criteria) this;
        }

        public Criteria andTableDisnameBetween(String value1, String value2) {
            addCriterion("TABLE_DISNAME between", value1, value2, "tableDisname");
            return (Criteria) this;
        }

        public Criteria andTableDisnameNotBetween(String value1, String value2) {
            addCriterion("TABLE_DISNAME not between", value1, value2, "tableDisname");
            return (Criteria) this;
        }

        public Criteria andDataIdIsNull() {
            addCriterion("DATA_ID is null");
            return (Criteria) this;
        }

        public Criteria andDataIdIsNotNull() {
            addCriterion("DATA_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDataIdEqualTo(Long value) {
            addCriterion("DATA_ID =", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotEqualTo(Long value) {
            addCriterion("DATA_ID <>", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdGreaterThan(Long value) {
            addCriterion("DATA_ID >", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdGreaterThanOrEqualTo(Long value) {
            addCriterion("DATA_ID >=", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdLessThan(Long value) {
            addCriterion("DATA_ID <", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdLessThanOrEqualTo(Long value) {
            addCriterion("DATA_ID <=", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdIn(List<Long> values) {
            addCriterion("DATA_ID in", values, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotIn(List<Long> values) {
            addCriterion("DATA_ID not in", values, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdBetween(Long value1, Long value2) {
            addCriterion("DATA_ID between", value1, value2, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotBetween(Long value1, Long value2) {
            addCriterion("DATA_ID not between", value1, value2, "dataId");
            return (Criteria) this;
        }

        public Criteria andOperateDescIsNull() {
            addCriterion("OPERATE_DESC is null");
            return (Criteria) this;
        }

        public Criteria andOperateDescIsNotNull() {
            addCriterion("OPERATE_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andOperateDescEqualTo(String value) {
            addCriterion("OPERATE_DESC =", value, "operateDesc");
            return (Criteria) this;
        }

        public Criteria andOperateDescNotEqualTo(String value) {
            addCriterion("OPERATE_DESC <>", value, "operateDesc");
            return (Criteria) this;
        }

        public Criteria andOperateDescGreaterThan(String value) {
            addCriterion("OPERATE_DESC >", value, "operateDesc");
            return (Criteria) this;
        }

        public Criteria andOperateDescGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATE_DESC >=", value, "operateDesc");
            return (Criteria) this;
        }

        public Criteria andOperateDescLessThan(String value) {
            addCriterion("OPERATE_DESC <", value, "operateDesc");
            return (Criteria) this;
        }

        public Criteria andOperateDescLessThanOrEqualTo(String value) {
            addCriterion("OPERATE_DESC <=", value, "operateDesc");
            return (Criteria) this;
        }

        public Criteria andOperateDescLike(String value) {
            addCriterion("OPERATE_DESC like", value, "operateDesc");
            return (Criteria) this;
        }

        public Criteria andOperateDescNotLike(String value) {
            addCriterion("OPERATE_DESC not like", value, "operateDesc");
            return (Criteria) this;
        }

        public Criteria andOperateDescIn(List<String> values) {
            addCriterion("OPERATE_DESC in", values, "operateDesc");
            return (Criteria) this;
        }

        public Criteria andOperateDescNotIn(List<String> values) {
            addCriterion("OPERATE_DESC not in", values, "operateDesc");
            return (Criteria) this;
        }

        public Criteria andOperateDescBetween(String value1, String value2) {
            addCriterion("OPERATE_DESC between", value1, value2, "operateDesc");
            return (Criteria) this;
        }

        public Criteria andOperateDescNotBetween(String value1, String value2) {
            addCriterion("OPERATE_DESC not between", value1, value2, "operateDesc");
            return (Criteria) this;
        }

        public Criteria andUnameIsNull() {
            addCriterion("uname is null");
            return (Criteria) this;
        }

        public Criteria andUnameIsNotNull() {
            addCriterion("uname is not null");
            return (Criteria) this;
        }

        public Criteria andUnameEqualTo(String value) {
            addCriterion("uname =", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotEqualTo(String value) {
            addCriterion("uname <>", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameGreaterThan(String value) {
            addCriterion("uname >", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameGreaterThanOrEqualTo(String value) {
            addCriterion("uname >=", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLessThan(String value) {
            addCriterion("uname <", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLessThanOrEqualTo(String value) {
            addCriterion("uname <=", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLike(String value) {
            addCriterion("uname like", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotLike(String value) {
            addCriterion("uname not like", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameIn(List<String> values) {
            addCriterion("uname in", values, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotIn(List<String> values) {
            addCriterion("uname not in", values, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameBetween(String value1, String value2) {
            addCriterion("uname between", value1, value2, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotBetween(String value1, String value2) {
            addCriterion("uname not between", value1, value2, "uname");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}