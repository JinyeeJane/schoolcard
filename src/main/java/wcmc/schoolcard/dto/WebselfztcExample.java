package wcmc.schoolcard.dto;

import java.util.ArrayList;
import java.util.List;

public class WebselfztcExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WebselfztcExample() {
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

        public Criteria andReaderidIsNull() {
            addCriterion("READERID is null");
            return (Criteria) this;
        }

        public Criteria andReaderidIsNotNull() {
            addCriterion("READERID is not null");
            return (Criteria) this;
        }

        public Criteria andReaderidEqualTo(String value) {
            addCriterion("READERID =", value, "readerid");
            return (Criteria) this;
        }

        public Criteria andReaderidNotEqualTo(String value) {
            addCriterion("READERID <>", value, "readerid");
            return (Criteria) this;
        }

        public Criteria andReaderidGreaterThan(String value) {
            addCriterion("READERID >", value, "readerid");
            return (Criteria) this;
        }

        public Criteria andReaderidGreaterThanOrEqualTo(String value) {
            addCriterion("READERID >=", value, "readerid");
            return (Criteria) this;
        }

        public Criteria andReaderidLessThan(String value) {
            addCriterion("READERID <", value, "readerid");
            return (Criteria) this;
        }

        public Criteria andReaderidLessThanOrEqualTo(String value) {
            addCriterion("READERID <=", value, "readerid");
            return (Criteria) this;
        }

        public Criteria andReaderidLike(String value) {
            addCriterion("READERID like", value, "readerid");
            return (Criteria) this;
        }

        public Criteria andReaderidNotLike(String value) {
            addCriterion("READERID not like", value, "readerid");
            return (Criteria) this;
        }

        public Criteria andReaderidIn(List<String> values) {
            addCriterion("READERID in", values, "readerid");
            return (Criteria) this;
        }

        public Criteria andReaderidNotIn(List<String> values) {
            addCriterion("READERID not in", values, "readerid");
            return (Criteria) this;
        }

        public Criteria andReaderidBetween(String value1, String value2) {
            addCriterion("READERID between", value1, value2, "readerid");
            return (Criteria) this;
        }

        public Criteria andReaderidNotBetween(String value1, String value2) {
            addCriterion("READERID not between", value1, value2, "readerid");
            return (Criteria) this;
        }

        public Criteria andZtcidIsNull() {
            addCriterion("ZTCID is null");
            return (Criteria) this;
        }

        public Criteria andZtcidIsNotNull() {
            addCriterion("ZTCID is not null");
            return (Criteria) this;
        }

        public Criteria andZtcidEqualTo(String value) {
            addCriterion("ZTCID =", value, "ztcid");
            return (Criteria) this;
        }

        public Criteria andZtcidNotEqualTo(String value) {
            addCriterion("ZTCID <>", value, "ztcid");
            return (Criteria) this;
        }

        public Criteria andZtcidGreaterThan(String value) {
            addCriterion("ZTCID >", value, "ztcid");
            return (Criteria) this;
        }

        public Criteria andZtcidGreaterThanOrEqualTo(String value) {
            addCriterion("ZTCID >=", value, "ztcid");
            return (Criteria) this;
        }

        public Criteria andZtcidLessThan(String value) {
            addCriterion("ZTCID <", value, "ztcid");
            return (Criteria) this;
        }

        public Criteria andZtcidLessThanOrEqualTo(String value) {
            addCriterion("ZTCID <=", value, "ztcid");
            return (Criteria) this;
        }

        public Criteria andZtcidLike(String value) {
            addCriterion("ZTCID like", value, "ztcid");
            return (Criteria) this;
        }

        public Criteria andZtcidNotLike(String value) {
            addCriterion("ZTCID not like", value, "ztcid");
            return (Criteria) this;
        }

        public Criteria andZtcidIn(List<String> values) {
            addCriterion("ZTCID in", values, "ztcid");
            return (Criteria) this;
        }

        public Criteria andZtcidNotIn(List<String> values) {
            addCriterion("ZTCID not in", values, "ztcid");
            return (Criteria) this;
        }

        public Criteria andZtcidBetween(String value1, String value2) {
            addCriterion("ZTCID between", value1, value2, "ztcid");
            return (Criteria) this;
        }

        public Criteria andZtcidNotBetween(String value1, String value2) {
            addCriterion("ZTCID not between", value1, value2, "ztcid");
            return (Criteria) this;
        }

        public Criteria andZtcIsNull() {
            addCriterion("ZTC is null");
            return (Criteria) this;
        }

        public Criteria andZtcIsNotNull() {
            addCriterion("ZTC is not null");
            return (Criteria) this;
        }

        public Criteria andZtcEqualTo(String value) {
            addCriterion("ZTC =", value, "ztc");
            return (Criteria) this;
        }

        public Criteria andZtcNotEqualTo(String value) {
            addCriterion("ZTC <>", value, "ztc");
            return (Criteria) this;
        }

        public Criteria andZtcGreaterThan(String value) {
            addCriterion("ZTC >", value, "ztc");
            return (Criteria) this;
        }

        public Criteria andZtcGreaterThanOrEqualTo(String value) {
            addCriterion("ZTC >=", value, "ztc");
            return (Criteria) this;
        }

        public Criteria andZtcLessThan(String value) {
            addCriterion("ZTC <", value, "ztc");
            return (Criteria) this;
        }

        public Criteria andZtcLessThanOrEqualTo(String value) {
            addCriterion("ZTC <=", value, "ztc");
            return (Criteria) this;
        }

        public Criteria andZtcLike(String value) {
            addCriterion("ZTC like", value, "ztc");
            return (Criteria) this;
        }

        public Criteria andZtcNotLike(String value) {
            addCriterion("ZTC not like", value, "ztc");
            return (Criteria) this;
        }

        public Criteria andZtcIn(List<String> values) {
            addCriterion("ZTC in", values, "ztc");
            return (Criteria) this;
        }

        public Criteria andZtcNotIn(List<String> values) {
            addCriterion("ZTC not in", values, "ztc");
            return (Criteria) this;
        }

        public Criteria andZtcBetween(String value1, String value2) {
            addCriterion("ZTC between", value1, value2, "ztc");
            return (Criteria) this;
        }

        public Criteria andZtcNotBetween(String value1, String value2) {
            addCriterion("ZTC not between", value1, value2, "ztc");
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