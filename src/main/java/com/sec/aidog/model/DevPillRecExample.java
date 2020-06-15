package com.sec.aidog.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DevPillRecExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DevPillRecExample() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMidIsNull() {
            addCriterion("mid is null");
            return (Criteria) this;
        }

        public Criteria andMidIsNotNull() {
            addCriterion("mid is not null");
            return (Criteria) this;
        }

        public Criteria andMidEqualTo(String value) {
            addCriterion("mid =", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotEqualTo(String value) {
            addCriterion("mid <>", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThan(String value) {
            addCriterion("mid >", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThanOrEqualTo(String value) {
            addCriterion("mid >=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThan(String value) {
            addCriterion("mid <", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThanOrEqualTo(String value) {
            addCriterion("mid <=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLike(String value) {
            addCriterion("mid like", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotLike(String value) {
            addCriterion("mid not like", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidIn(List<String> values) {
            addCriterion("mid in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotIn(List<String> values) {
            addCriterion("mid not in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidBetween(String value1, String value2) {
            addCriterion("mid between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotBetween(String value1, String value2) {
            addCriterion("mid not between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andPillCodeIsNull() {
            addCriterion("pill_code is null");
            return (Criteria) this;
        }

        public Criteria andPillCodeIsNotNull() {
            addCriterion("pill_code is not null");
            return (Criteria) this;
        }

        public Criteria andPillCodeEqualTo(String value) {
            addCriterion("pill_code =", value, "pillCode");
            return (Criteria) this;
        }

        public Criteria andPillCodeNotEqualTo(String value) {
            addCriterion("pill_code <>", value, "pillCode");
            return (Criteria) this;
        }

        public Criteria andPillCodeGreaterThan(String value) {
            addCriterion("pill_code >", value, "pillCode");
            return (Criteria) this;
        }

        public Criteria andPillCodeGreaterThanOrEqualTo(String value) {
            addCriterion("pill_code >=", value, "pillCode");
            return (Criteria) this;
        }

        public Criteria andPillCodeLessThan(String value) {
            addCriterion("pill_code <", value, "pillCode");
            return (Criteria) this;
        }

        public Criteria andPillCodeLessThanOrEqualTo(String value) {
            addCriterion("pill_code <=", value, "pillCode");
            return (Criteria) this;
        }

        public Criteria andPillCodeLike(String value) {
            addCriterion("pill_code like", value, "pillCode");
            return (Criteria) this;
        }

        public Criteria andPillCodeNotLike(String value) {
            addCriterion("pill_code not like", value, "pillCode");
            return (Criteria) this;
        }

        public Criteria andPillCodeIn(List<String> values) {
            addCriterion("pill_code in", values, "pillCode");
            return (Criteria) this;
        }

        public Criteria andPillCodeNotIn(List<String> values) {
            addCriterion("pill_code not in", values, "pillCode");
            return (Criteria) this;
        }

        public Criteria andPillCodeBetween(String value1, String value2) {
            addCriterion("pill_code between", value1, value2, "pillCode");
            return (Criteria) this;
        }

        public Criteria andPillCodeNotBetween(String value1, String value2) {
            addCriterion("pill_code not between", value1, value2, "pillCode");
            return (Criteria) this;
        }

        public Criteria andConfigTimeIsNull() {
            addCriterion("config_time is null");
            return (Criteria) this;
        }

        public Criteria andConfigTimeIsNotNull() {
            addCriterion("config_time is not null");
            return (Criteria) this;
        }

        public Criteria andConfigTimeEqualTo(Date value) {
            addCriterion("config_time =", value, "configTime");
            return (Criteria) this;
        }

        public Criteria andConfigTimeNotEqualTo(Date value) {
            addCriterion("config_time <>", value, "configTime");
            return (Criteria) this;
        }

        public Criteria andConfigTimeGreaterThan(Date value) {
            addCriterion("config_time >", value, "configTime");
            return (Criteria) this;
        }

        public Criteria andConfigTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("config_time >=", value, "configTime");
            return (Criteria) this;
        }

        public Criteria andConfigTimeLessThan(Date value) {
            addCriterion("config_time <", value, "configTime");
            return (Criteria) this;
        }

        public Criteria andConfigTimeLessThanOrEqualTo(Date value) {
            addCriterion("config_time <=", value, "configTime");
            return (Criteria) this;
        }

        public Criteria andConfigTimeIn(List<Date> values) {
            addCriterion("config_time in", values, "configTime");
            return (Criteria) this;
        }

        public Criteria andConfigTimeNotIn(List<Date> values) {
            addCriterion("config_time not in", values, "configTime");
            return (Criteria) this;
        }

        public Criteria andConfigTimeBetween(Date value1, Date value2) {
            addCriterion("config_time between", value1, value2, "configTime");
            return (Criteria) this;
        }

        public Criteria andConfigTimeNotBetween(Date value1, Date value2) {
            addCriterion("config_time not between", value1, value2, "configTime");
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