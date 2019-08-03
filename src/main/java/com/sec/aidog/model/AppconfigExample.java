package com.sec.aidog.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppconfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppconfigExample() {
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

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("app_id like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("app_id not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("app_id not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andDosingcycleIsNull() {
            addCriterion("dosingcycle is null");
            return (Criteria) this;
        }

        public Criteria andDosingcycleIsNotNull() {
            addCriterion("dosingcycle is not null");
            return (Criteria) this;
        }

        public Criteria andDosingcycleEqualTo(Integer value) {
            addCriterion("dosingcycle =", value, "dosingcycle");
            return (Criteria) this;
        }

        public Criteria andDosingcycleNotEqualTo(Integer value) {
            addCriterion("dosingcycle <>", value, "dosingcycle");
            return (Criteria) this;
        }

        public Criteria andDosingcycleGreaterThan(Integer value) {
            addCriterion("dosingcycle >", value, "dosingcycle");
            return (Criteria) this;
        }

        public Criteria andDosingcycleGreaterThanOrEqualTo(Integer value) {
            addCriterion("dosingcycle >=", value, "dosingcycle");
            return (Criteria) this;
        }

        public Criteria andDosingcycleLessThan(Integer value) {
            addCriterion("dosingcycle <", value, "dosingcycle");
            return (Criteria) this;
        }

        public Criteria andDosingcycleLessThanOrEqualTo(Integer value) {
            addCriterion("dosingcycle <=", value, "dosingcycle");
            return (Criteria) this;
        }

        public Criteria andDosingcycleIn(List<Integer> values) {
            addCriterion("dosingcycle in", values, "dosingcycle");
            return (Criteria) this;
        }

        public Criteria andDosingcycleNotIn(List<Integer> values) {
            addCriterion("dosingcycle not in", values, "dosingcycle");
            return (Criteria) this;
        }

        public Criteria andDosingcycleBetween(Integer value1, Integer value2) {
            addCriterion("dosingcycle between", value1, value2, "dosingcycle");
            return (Criteria) this;
        }

        public Criteria andDosingcycleNotBetween(Integer value1, Integer value2) {
            addCriterion("dosingcycle not between", value1, value2, "dosingcycle");
            return (Criteria) this;
        }

        public Criteria andAreacycleIsNull() {
            addCriterion("areacycle is null");
            return (Criteria) this;
        }

        public Criteria andAreacycleIsNotNull() {
            addCriterion("areacycle is not null");
            return (Criteria) this;
        }

        public Criteria andAreacycleEqualTo(Integer value) {
            addCriterion("areacycle =", value, "areacycle");
            return (Criteria) this;
        }

        public Criteria andAreacycleNotEqualTo(Integer value) {
            addCriterion("areacycle <>", value, "areacycle");
            return (Criteria) this;
        }

        public Criteria andAreacycleGreaterThan(Integer value) {
            addCriterion("areacycle >", value, "areacycle");
            return (Criteria) this;
        }

        public Criteria andAreacycleGreaterThanOrEqualTo(Integer value) {
            addCriterion("areacycle >=", value, "areacycle");
            return (Criteria) this;
        }

        public Criteria andAreacycleLessThan(Integer value) {
            addCriterion("areacycle <", value, "areacycle");
            return (Criteria) this;
        }

        public Criteria andAreacycleLessThanOrEqualTo(Integer value) {
            addCriterion("areacycle <=", value, "areacycle");
            return (Criteria) this;
        }

        public Criteria andAreacycleIn(List<Integer> values) {
            addCriterion("areacycle in", values, "areacycle");
            return (Criteria) this;
        }

        public Criteria andAreacycleNotIn(List<Integer> values) {
            addCriterion("areacycle not in", values, "areacycle");
            return (Criteria) this;
        }

        public Criteria andAreacycleBetween(Integer value1, Integer value2) {
            addCriterion("areacycle between", value1, value2, "areacycle");
            return (Criteria) this;
        }

        public Criteria andAreacycleNotBetween(Integer value1, Integer value2) {
            addCriterion("areacycle not between", value1, value2, "areacycle");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updatetime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andDosingtotalIsNull() {
            addCriterion("dosingtotal is null");
            return (Criteria) this;
        }

        public Criteria andDosingtotalIsNotNull() {
            addCriterion("dosingtotal is not null");
            return (Criteria) this;
        }

        public Criteria andDosingtotalEqualTo(Integer value) {
            addCriterion("dosingtotal =", value, "dosingtotal");
            return (Criteria) this;
        }

        public Criteria andDosingtotalNotEqualTo(Integer value) {
            addCriterion("dosingtotal <>", value, "dosingtotal");
            return (Criteria) this;
        }

        public Criteria andDosingtotalGreaterThan(Integer value) {
            addCriterion("dosingtotal >", value, "dosingtotal");
            return (Criteria) this;
        }

        public Criteria andDosingtotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("dosingtotal >=", value, "dosingtotal");
            return (Criteria) this;
        }

        public Criteria andDosingtotalLessThan(Integer value) {
            addCriterion("dosingtotal <", value, "dosingtotal");
            return (Criteria) this;
        }

        public Criteria andDosingtotalLessThanOrEqualTo(Integer value) {
            addCriterion("dosingtotal <=", value, "dosingtotal");
            return (Criteria) this;
        }

        public Criteria andDosingtotalIn(List<Integer> values) {
            addCriterion("dosingtotal in", values, "dosingtotal");
            return (Criteria) this;
        }

        public Criteria andDosingtotalNotIn(List<Integer> values) {
            addCriterion("dosingtotal not in", values, "dosingtotal");
            return (Criteria) this;
        }

        public Criteria andDosingtotalBetween(Integer value1, Integer value2) {
            addCriterion("dosingtotal between", value1, value2, "dosingtotal");
            return (Criteria) this;
        }

        public Criteria andDosingtotalNotBetween(Integer value1, Integer value2) {
            addCriterion("dosingtotal not between", value1, value2, "dosingtotal");
            return (Criteria) this;
        }

        public Criteria andFirstdosingTimeIsNull() {
            addCriterion("firstdosing_time is null");
            return (Criteria) this;
        }

        public Criteria andFirstdosingTimeIsNotNull() {
            addCriterion("firstdosing_time is not null");
            return (Criteria) this;
        }

        public Criteria andFirstdosingTimeEqualTo(Date value) {
            addCriterion("firstdosing_time =", value, "firstdosingTime");
            return (Criteria) this;
        }

        public Criteria andFirstdosingTimeNotEqualTo(Date value) {
            addCriterion("firstdosing_time <>", value, "firstdosingTime");
            return (Criteria) this;
        }

        public Criteria andFirstdosingTimeGreaterThan(Date value) {
            addCriterion("firstdosing_time >", value, "firstdosingTime");
            return (Criteria) this;
        }

        public Criteria andFirstdosingTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("firstdosing_time >=", value, "firstdosingTime");
            return (Criteria) this;
        }

        public Criteria andFirstdosingTimeLessThan(Date value) {
            addCriterion("firstdosing_time <", value, "firstdosingTime");
            return (Criteria) this;
        }

        public Criteria andFirstdosingTimeLessThanOrEqualTo(Date value) {
            addCriterion("firstdosing_time <=", value, "firstdosingTime");
            return (Criteria) this;
        }

        public Criteria andFirstdosingTimeIn(List<Date> values) {
            addCriterion("firstdosing_time in", values, "firstdosingTime");
            return (Criteria) this;
        }

        public Criteria andFirstdosingTimeNotIn(List<Date> values) {
            addCriterion("firstdosing_time not in", values, "firstdosingTime");
            return (Criteria) this;
        }

        public Criteria andFirstdosingTimeBetween(Date value1, Date value2) {
            addCriterion("firstdosing_time between", value1, value2, "firstdosingTime");
            return (Criteria) this;
        }

        public Criteria andFirstdosingTimeNotBetween(Date value1, Date value2) {
            addCriterion("firstdosing_time not between", value1, value2, "firstdosingTime");
            return (Criteria) this;
        }

        public Criteria andEnddosingTimeIsNull() {
            addCriterion("enddosing_time is null");
            return (Criteria) this;
        }

        public Criteria andEnddosingTimeIsNotNull() {
            addCriterion("enddosing_time is not null");
            return (Criteria) this;
        }

        public Criteria andEnddosingTimeEqualTo(Date value) {
            addCriterion("enddosing_time =", value, "enddosingTime");
            return (Criteria) this;
        }

        public Criteria andEnddosingTimeNotEqualTo(Date value) {
            addCriterion("enddosing_time <>", value, "enddosingTime");
            return (Criteria) this;
        }

        public Criteria andEnddosingTimeGreaterThan(Date value) {
            addCriterion("enddosing_time >", value, "enddosingTime");
            return (Criteria) this;
        }

        public Criteria andEnddosingTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("enddosing_time >=", value, "enddosingTime");
            return (Criteria) this;
        }

        public Criteria andEnddosingTimeLessThan(Date value) {
            addCriterion("enddosing_time <", value, "enddosingTime");
            return (Criteria) this;
        }

        public Criteria andEnddosingTimeLessThanOrEqualTo(Date value) {
            addCriterion("enddosing_time <=", value, "enddosingTime");
            return (Criteria) this;
        }

        public Criteria andEnddosingTimeIn(List<Date> values) {
            addCriterion("enddosing_time in", values, "enddosingTime");
            return (Criteria) this;
        }

        public Criteria andEnddosingTimeNotIn(List<Date> values) {
            addCriterion("enddosing_time not in", values, "enddosingTime");
            return (Criteria) this;
        }

        public Criteria andEnddosingTimeBetween(Date value1, Date value2) {
            addCriterion("enddosing_time between", value1, value2, "enddosingTime");
            return (Criteria) this;
        }

        public Criteria andEnddosingTimeNotBetween(Date value1, Date value2) {
            addCriterion("enddosing_time not between", value1, value2, "enddosingTime");
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