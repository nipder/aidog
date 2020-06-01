package com.sec.aidog.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LastfeeddosingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LastfeeddosingExample() {
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

        public Criteria andFeedIdIsNull() {
            addCriterion("feed_id is null");
            return (Criteria) this;
        }

        public Criteria andFeedIdIsNotNull() {
            addCriterion("feed_id is not null");
            return (Criteria) this;
        }

        public Criteria andFeedIdEqualTo(String value) {
            addCriterion("feed_id =", value, "feedId");
            return (Criteria) this;
        }

        public Criteria andFeedIdNotEqualTo(String value) {
            addCriterion("feed_id <>", value, "feedId");
            return (Criteria) this;
        }

        public Criteria andFeedIdGreaterThan(String value) {
            addCriterion("feed_id >", value, "feedId");
            return (Criteria) this;
        }

        public Criteria andFeedIdGreaterThanOrEqualTo(String value) {
            addCriterion("feed_id >=", value, "feedId");
            return (Criteria) this;
        }

        public Criteria andFeedIdLessThan(String value) {
            addCriterion("feed_id <", value, "feedId");
            return (Criteria) this;
        }

        public Criteria andFeedIdLessThanOrEqualTo(String value) {
            addCriterion("feed_id <=", value, "feedId");
            return (Criteria) this;
        }

        public Criteria andFeedIdLike(String value) {
            addCriterion("feed_id like", value, "feedId");
            return (Criteria) this;
        }

        public Criteria andFeedIdNotLike(String value) {
            addCriterion("feed_id not like", value, "feedId");
            return (Criteria) this;
        }

        public Criteria andFeedIdIn(List<String> values) {
            addCriterion("feed_id in", values, "feedId");
            return (Criteria) this;
        }

        public Criteria andFeedIdNotIn(List<String> values) {
            addCriterion("feed_id not in", values, "feedId");
            return (Criteria) this;
        }

        public Criteria andFeedIdBetween(String value1, String value2) {
            addCriterion("feed_id between", value1, value2, "feedId");
            return (Criteria) this;
        }

        public Criteria andFeedIdNotBetween(String value1, String value2) {
            addCriterion("feed_id not between", value1, value2, "feedId");
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

        public Criteria andLastdosingTimeIsNull() {
            addCriterion("lastdosing_time is null");
            return (Criteria) this;
        }

        public Criteria andLastdosingTimeIsNotNull() {
            addCriterion("lastdosing_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastdosingTimeEqualTo(Date value) {
            addCriterion("lastdosing_time =", value, "lastdosingTime");
            return (Criteria) this;
        }

        public Criteria andLastdosingTimeNotEqualTo(Date value) {
            addCriterion("lastdosing_time <>", value, "lastdosingTime");
            return (Criteria) this;
        }

        public Criteria andLastdosingTimeGreaterThan(Date value) {
            addCriterion("lastdosing_time >", value, "lastdosingTime");
            return (Criteria) this;
        }

        public Criteria andLastdosingTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lastdosing_time >=", value, "lastdosingTime");
            return (Criteria) this;
        }

        public Criteria andLastdosingTimeLessThan(Date value) {
            addCriterion("lastdosing_time <", value, "lastdosingTime");
            return (Criteria) this;
        }

        public Criteria andLastdosingTimeLessThanOrEqualTo(Date value) {
            addCriterion("lastdosing_time <=", value, "lastdosingTime");
            return (Criteria) this;
        }

        public Criteria andLastdosingTimeIn(List<Date> values) {
            addCriterion("lastdosing_time in", values, "lastdosingTime");
            return (Criteria) this;
        }

        public Criteria andLastdosingTimeNotIn(List<Date> values) {
            addCriterion("lastdosing_time not in", values, "lastdosingTime");
            return (Criteria) this;
        }

        public Criteria andLastdosingTimeBetween(Date value1, Date value2) {
            addCriterion("lastdosing_time between", value1, value2, "lastdosingTime");
            return (Criteria) this;
        }

        public Criteria andLastdosingTimeNotBetween(Date value1, Date value2) {
            addCriterion("lastdosing_time not between", value1, value2, "lastdosingTime");
            return (Criteria) this;
        }

        public Criteria andNextdosingTimeIsNull() {
            addCriterion("nextdosing_time is null");
            return (Criteria) this;
        }

        public Criteria andNextdosingTimeIsNotNull() {
            addCriterion("nextdosing_time is not null");
            return (Criteria) this;
        }

        public Criteria andNextdosingTimeEqualTo(Date value) {
            addCriterion("nextdosing_time =", value, "nextdosingTime");
            return (Criteria) this;
        }

        public Criteria andNextdosingTimeNotEqualTo(Date value) {
            addCriterion("nextdosing_time <>", value, "nextdosingTime");
            return (Criteria) this;
        }

        public Criteria andNextdosingTimeGreaterThan(Date value) {
            addCriterion("nextdosing_time >", value, "nextdosingTime");
            return (Criteria) this;
        }

        public Criteria andNextdosingTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("nextdosing_time >=", value, "nextdosingTime");
            return (Criteria) this;
        }

        public Criteria andNextdosingTimeLessThan(Date value) {
            addCriterion("nextdosing_time <", value, "nextdosingTime");
            return (Criteria) this;
        }

        public Criteria andNextdosingTimeLessThanOrEqualTo(Date value) {
            addCriterion("nextdosing_time <=", value, "nextdosingTime");
            return (Criteria) this;
        }

        public Criteria andNextdosingTimeIn(List<Date> values) {
            addCriterion("nextdosing_time in", values, "nextdosingTime");
            return (Criteria) this;
        }

        public Criteria andNextdosingTimeNotIn(List<Date> values) {
            addCriterion("nextdosing_time not in", values, "nextdosingTime");
            return (Criteria) this;
        }

        public Criteria andNextdosingTimeBetween(Date value1, Date value2) {
            addCriterion("nextdosing_time between", value1, value2, "nextdosingTime");
            return (Criteria) this;
        }

        public Criteria andNextdosingTimeNotBetween(Date value1, Date value2) {
            addCriterion("nextdosing_time not between", value1, value2, "nextdosingTime");
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

        public Criteria andLeftNumIsNull() {
            addCriterion("left_num is null");
            return (Criteria) this;
        }

        public Criteria andLeftNumIsNotNull() {
            addCriterion("left_num is not null");
            return (Criteria) this;
        }

        public Criteria andLeftNumEqualTo(Integer value) {
            addCriterion("left_num =", value, "leftNum");
            return (Criteria) this;
        }

        public Criteria andLeftNumNotEqualTo(Integer value) {
            addCriterion("left_num <>", value, "leftNum");
            return (Criteria) this;
        }

        public Criteria andLeftNumGreaterThan(Integer value) {
            addCriterion("left_num >", value, "leftNum");
            return (Criteria) this;
        }

        public Criteria andLeftNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("left_num >=", value, "leftNum");
            return (Criteria) this;
        }

        public Criteria andLeftNumLessThan(Integer value) {
            addCriterion("left_num <", value, "leftNum");
            return (Criteria) this;
        }

        public Criteria andLeftNumLessThanOrEqualTo(Integer value) {
            addCriterion("left_num <=", value, "leftNum");
            return (Criteria) this;
        }

        public Criteria andLeftNumIn(List<Integer> values) {
            addCriterion("left_num in", values, "leftNum");
            return (Criteria) this;
        }

        public Criteria andLeftNumNotIn(List<Integer> values) {
            addCriterion("left_num not in", values, "leftNum");
            return (Criteria) this;
        }

        public Criteria andLeftNumBetween(Integer value1, Integer value2) {
            addCriterion("left_num between", value1, value2, "leftNum");
            return (Criteria) this;
        }

        public Criteria andLeftNumNotBetween(Integer value1, Integer value2) {
            addCriterion("left_num not between", value1, value2, "leftNum");
            return (Criteria) this;
        }

        public Criteria andDosingMethodIsNull() {
            addCriterion("dosing_method is null");
            return (Criteria) this;
        }

        public Criteria andDosingMethodIsNotNull() {
            addCriterion("dosing_method is not null");
            return (Criteria) this;
        }

        public Criteria andDosingMethodEqualTo(String value) {
            addCriterion("dosing_method =", value, "dosingMethod");
            return (Criteria) this;
        }

        public Criteria andDosingMethodNotEqualTo(String value) {
            addCriterion("dosing_method <>", value, "dosingMethod");
            return (Criteria) this;
        }

        public Criteria andDosingMethodGreaterThan(String value) {
            addCriterion("dosing_method >", value, "dosingMethod");
            return (Criteria) this;
        }

        public Criteria andDosingMethodGreaterThanOrEqualTo(String value) {
            addCriterion("dosing_method >=", value, "dosingMethod");
            return (Criteria) this;
        }

        public Criteria andDosingMethodLessThan(String value) {
            addCriterion("dosing_method <", value, "dosingMethod");
            return (Criteria) this;
        }

        public Criteria andDosingMethodLessThanOrEqualTo(String value) {
            addCriterion("dosing_method <=", value, "dosingMethod");
            return (Criteria) this;
        }

        public Criteria andDosingMethodLike(String value) {
            addCriterion("dosing_method like", value, "dosingMethod");
            return (Criteria) this;
        }

        public Criteria andDosingMethodNotLike(String value) {
            addCriterion("dosing_method not like", value, "dosingMethod");
            return (Criteria) this;
        }

        public Criteria andDosingMethodIn(List<String> values) {
            addCriterion("dosing_method in", values, "dosingMethod");
            return (Criteria) this;
        }

        public Criteria andDosingMethodNotIn(List<String> values) {
            addCriterion("dosing_method not in", values, "dosingMethod");
            return (Criteria) this;
        }

        public Criteria andDosingMethodBetween(String value1, String value2) {
            addCriterion("dosing_method between", value1, value2, "dosingMethod");
            return (Criteria) this;
        }

        public Criteria andDosingMethodNotBetween(String value1, String value2) {
            addCriterion("dosing_method not between", value1, value2, "dosingMethod");
            return (Criteria) this;
        }

        public Criteria andFeedStatusIsNull() {
            addCriterion("feed_status is null");
            return (Criteria) this;
        }

        public Criteria andFeedStatusIsNotNull() {
            addCriterion("feed_status is not null");
            return (Criteria) this;
        }

        public Criteria andFeedStatusEqualTo(String value) {
            addCriterion("feed_status =", value, "feedStatus");
            return (Criteria) this;
        }

        public Criteria andFeedStatusNotEqualTo(String value) {
            addCriterion("feed_status <>", value, "feedStatus");
            return (Criteria) this;
        }

        public Criteria andFeedStatusGreaterThan(String value) {
            addCriterion("feed_status >", value, "feedStatus");
            return (Criteria) this;
        }

        public Criteria andFeedStatusGreaterThanOrEqualTo(String value) {
            addCriterion("feed_status >=", value, "feedStatus");
            return (Criteria) this;
        }

        public Criteria andFeedStatusLessThan(String value) {
            addCriterion("feed_status <", value, "feedStatus");
            return (Criteria) this;
        }

        public Criteria andFeedStatusLessThanOrEqualTo(String value) {
            addCriterion("feed_status <=", value, "feedStatus");
            return (Criteria) this;
        }

        public Criteria andFeedStatusLike(String value) {
            addCriterion("feed_status like", value, "feedStatus");
            return (Criteria) this;
        }

        public Criteria andFeedStatusNotLike(String value) {
            addCriterion("feed_status not like", value, "feedStatus");
            return (Criteria) this;
        }

        public Criteria andFeedStatusIn(List<String> values) {
            addCriterion("feed_status in", values, "feedStatus");
            return (Criteria) this;
        }

        public Criteria andFeedStatusNotIn(List<String> values) {
            addCriterion("feed_status not in", values, "feedStatus");
            return (Criteria) this;
        }

        public Criteria andFeedStatusBetween(String value1, String value2) {
            addCriterion("feed_status between", value1, value2, "feedStatus");
            return (Criteria) this;
        }

        public Criteria andFeedStatusNotBetween(String value1, String value2) {
            addCriterion("feed_status not between", value1, value2, "feedStatus");
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

        public Criteria andPowerIsNull() {
            addCriterion("power is null");
            return (Criteria) this;
        }

        public Criteria andPowerIsNotNull() {
            addCriterion("power is not null");
            return (Criteria) this;
        }

        public Criteria andPowerEqualTo(String value) {
            addCriterion("power =", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerNotEqualTo(String value) {
            addCriterion("power <>", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerGreaterThan(String value) {
            addCriterion("power >", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerGreaterThanOrEqualTo(String value) {
            addCriterion("power >=", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerLessThan(String value) {
            addCriterion("power <", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerLessThanOrEqualTo(String value) {
            addCriterion("power <=", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerLike(String value) {
            addCriterion("power like", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerNotLike(String value) {
            addCriterion("power not like", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerIn(List<String> values) {
            addCriterion("power in", values, "power");
            return (Criteria) this;
        }

        public Criteria andPowerNotIn(List<String> values) {
            addCriterion("power not in", values, "power");
            return (Criteria) this;
        }

        public Criteria andPowerBetween(String value1, String value2) {
            addCriterion("power between", value1, value2, "power");
            return (Criteria) this;
        }

        public Criteria andPowerNotBetween(String value1, String value2) {
            addCriterion("power not between", value1, value2, "power");
            return (Criteria) this;
        }

        public Criteria andTemperatureIsNull() {
            addCriterion("temperature is null");
            return (Criteria) this;
        }

        public Criteria andTemperatureIsNotNull() {
            addCriterion("temperature is not null");
            return (Criteria) this;
        }

        public Criteria andTemperatureEqualTo(String value) {
            addCriterion("temperature =", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotEqualTo(String value) {
            addCriterion("temperature <>", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureGreaterThan(String value) {
            addCriterion("temperature >", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureGreaterThanOrEqualTo(String value) {
            addCriterion("temperature >=", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLessThan(String value) {
            addCriterion("temperature <", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLessThanOrEqualTo(String value) {
            addCriterion("temperature <=", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLike(String value) {
            addCriterion("temperature like", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotLike(String value) {
            addCriterion("temperature not like", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureIn(List<String> values) {
            addCriterion("temperature in", values, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotIn(List<String> values) {
            addCriterion("temperature not in", values, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureBetween(String value1, String value2) {
            addCriterion("temperature between", value1, value2, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotBetween(String value1, String value2) {
            addCriterion("temperature not between", value1, value2, "temperature");
            return (Criteria) this;
        }

        public Criteria andRealtimeIsNull() {
            addCriterion("realtime is null");
            return (Criteria) this;
        }

        public Criteria andRealtimeIsNotNull() {
            addCriterion("realtime is not null");
            return (Criteria) this;
        }

        public Criteria andRealtimeEqualTo(Date value) {
            addCriterion("realtime =", value, "realtime");
            return (Criteria) this;
        }

        public Criteria andRealtimeNotEqualTo(Date value) {
            addCriterion("realtime <>", value, "realtime");
            return (Criteria) this;
        }

        public Criteria andRealtimeGreaterThan(Date value) {
            addCriterion("realtime >", value, "realtime");
            return (Criteria) this;
        }

        public Criteria andRealtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("realtime >=", value, "realtime");
            return (Criteria) this;
        }

        public Criteria andRealtimeLessThan(Date value) {
            addCriterion("realtime <", value, "realtime");
            return (Criteria) this;
        }

        public Criteria andRealtimeLessThanOrEqualTo(Date value) {
            addCriterion("realtime <=", value, "realtime");
            return (Criteria) this;
        }

        public Criteria andRealtimeIn(List<Date> values) {
            addCriterion("realtime in", values, "realtime");
            return (Criteria) this;
        }

        public Criteria andRealtimeNotIn(List<Date> values) {
            addCriterion("realtime not in", values, "realtime");
            return (Criteria) this;
        }

        public Criteria andRealtimeBetween(Date value1, Date value2) {
            addCriterion("realtime between", value1, value2, "realtime");
            return (Criteria) this;
        }

        public Criteria andRealtimeNotBetween(Date value1, Date value2) {
            addCriterion("realtime not between", value1, value2, "realtime");
            return (Criteria) this;
        }

        public Criteria andLngIsNull() {
            addCriterion("lng is null");
            return (Criteria) this;
        }

        public Criteria andLngIsNotNull() {
            addCriterion("lng is not null");
            return (Criteria) this;
        }

        public Criteria andLngEqualTo(String value) {
            addCriterion("lng =", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotEqualTo(String value) {
            addCriterion("lng <>", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThan(String value) {
            addCriterion("lng >", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThanOrEqualTo(String value) {
            addCriterion("lng >=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThan(String value) {
            addCriterion("lng <", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThanOrEqualTo(String value) {
            addCriterion("lng <=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLike(String value) {
            addCriterion("lng like", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotLike(String value) {
            addCriterion("lng not like", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngIn(List<String> values) {
            addCriterion("lng in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotIn(List<String> values) {
            addCriterion("lng not in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngBetween(String value1, String value2) {
            addCriterion("lng between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotBetween(String value1, String value2) {
            addCriterion("lng not between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andLatIsNull() {
            addCriterion("lat is null");
            return (Criteria) this;
        }

        public Criteria andLatIsNotNull() {
            addCriterion("lat is not null");
            return (Criteria) this;
        }

        public Criteria andLatEqualTo(String value) {
            addCriterion("lat =", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotEqualTo(String value) {
            addCriterion("lat <>", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThan(String value) {
            addCriterion("lat >", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThanOrEqualTo(String value) {
            addCriterion("lat >=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThan(String value) {
            addCriterion("lat <", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThanOrEqualTo(String value) {
            addCriterion("lat <=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLike(String value) {
            addCriterion("lat like", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotLike(String value) {
            addCriterion("lat not like", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatIn(List<String> values) {
            addCriterion("lat in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotIn(List<String> values) {
            addCriterion("lat not in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatBetween(String value1, String value2) {
            addCriterion("lat between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotBetween(String value1, String value2) {
            addCriterion("lat not between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andDistrictcodeIsNull() {
            addCriterion("districtcode is null");
            return (Criteria) this;
        }

        public Criteria andDistrictcodeIsNotNull() {
            addCriterion("districtcode is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictcodeEqualTo(String value) {
            addCriterion("districtcode =", value, "districtcode");
            return (Criteria) this;
        }

        public Criteria andDistrictcodeNotEqualTo(String value) {
            addCriterion("districtcode <>", value, "districtcode");
            return (Criteria) this;
        }

        public Criteria andDistrictcodeGreaterThan(String value) {
            addCriterion("districtcode >", value, "districtcode");
            return (Criteria) this;
        }

        public Criteria andDistrictcodeGreaterThanOrEqualTo(String value) {
            addCriterion("districtcode >=", value, "districtcode");
            return (Criteria) this;
        }

        public Criteria andDistrictcodeLessThan(String value) {
            addCriterion("districtcode <", value, "districtcode");
            return (Criteria) this;
        }

        public Criteria andDistrictcodeLessThanOrEqualTo(String value) {
            addCriterion("districtcode <=", value, "districtcode");
            return (Criteria) this;
        }

        public Criteria andDistrictcodeLike(String value) {
            addCriterion("districtcode like", value, "districtcode");
            return (Criteria) this;
        }

        public Criteria andDistrictcodeNotLike(String value) {
            addCriterion("districtcode not like", value, "districtcode");
            return (Criteria) this;
        }

        public Criteria andDistrictcodeIn(List<String> values) {
            addCriterion("districtcode in", values, "districtcode");
            return (Criteria) this;
        }

        public Criteria andDistrictcodeNotIn(List<String> values) {
            addCriterion("districtcode not in", values, "districtcode");
            return (Criteria) this;
        }

        public Criteria andDistrictcodeBetween(String value1, String value2) {
            addCriterion("districtcode between", value1, value2, "districtcode");
            return (Criteria) this;
        }

        public Criteria andDistrictcodeNotBetween(String value1, String value2) {
            addCriterion("districtcode not between", value1, value2, "districtcode");
            return (Criteria) this;
        }

        public Criteria andPositioncycleIsNull() {
            addCriterion("positioncycle is null");
            return (Criteria) this;
        }

        public Criteria andPositioncycleIsNotNull() {
            addCriterion("positioncycle is not null");
            return (Criteria) this;
        }

        public Criteria andPositioncycleEqualTo(Integer value) {
            addCriterion("positioncycle =", value, "positioncycle");
            return (Criteria) this;
        }

        public Criteria andPositioncycleNotEqualTo(Integer value) {
            addCriterion("positioncycle <>", value, "positioncycle");
            return (Criteria) this;
        }

        public Criteria andPositioncycleGreaterThan(Integer value) {
            addCriterion("positioncycle >", value, "positioncycle");
            return (Criteria) this;
        }

        public Criteria andPositioncycleGreaterThanOrEqualTo(Integer value) {
            addCriterion("positioncycle >=", value, "positioncycle");
            return (Criteria) this;
        }

        public Criteria andPositioncycleLessThan(Integer value) {
            addCriterion("positioncycle <", value, "positioncycle");
            return (Criteria) this;
        }

        public Criteria andPositioncycleLessThanOrEqualTo(Integer value) {
            addCriterion("positioncycle <=", value, "positioncycle");
            return (Criteria) this;
        }

        public Criteria andPositioncycleIn(List<Integer> values) {
            addCriterion("positioncycle in", values, "positioncycle");
            return (Criteria) this;
        }

        public Criteria andPositioncycleNotIn(List<Integer> values) {
            addCriterion("positioncycle not in", values, "positioncycle");
            return (Criteria) this;
        }

        public Criteria andPositioncycleBetween(Integer value1, Integer value2) {
            addCriterion("positioncycle between", value1, value2, "positioncycle");
            return (Criteria) this;
        }

        public Criteria andPositioncycleNotBetween(Integer value1, Integer value2) {
            addCriterion("positioncycle not between", value1, value2, "positioncycle");
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

        public Criteria andErrTimeIsNull() {
            addCriterion("err_time is null");
            return (Criteria) this;
        }

        public Criteria andErrTimeIsNotNull() {
            addCriterion("err_time is not null");
            return (Criteria) this;
        }

        public Criteria andErrTimeEqualTo(Date value) {
            addCriterion("err_time =", value, "errTime");
            return (Criteria) this;
        }

        public Criteria andErrTimeNotEqualTo(Date value) {
            addCriterion("err_time <>", value, "errTime");
            return (Criteria) this;
        }

        public Criteria andErrTimeGreaterThan(Date value) {
            addCriterion("err_time >", value, "errTime");
            return (Criteria) this;
        }

        public Criteria andErrTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("err_time >=", value, "errTime");
            return (Criteria) this;
        }

        public Criteria andErrTimeLessThan(Date value) {
            addCriterion("err_time <", value, "errTime");
            return (Criteria) this;
        }

        public Criteria andErrTimeLessThanOrEqualTo(Date value) {
            addCriterion("err_time <=", value, "errTime");
            return (Criteria) this;
        }

        public Criteria andErrTimeIn(List<Date> values) {
            addCriterion("err_time in", values, "errTime");
            return (Criteria) this;
        }

        public Criteria andErrTimeNotIn(List<Date> values) {
            addCriterion("err_time not in", values, "errTime");
            return (Criteria) this;
        }

        public Criteria andErrTimeBetween(Date value1, Date value2) {
            addCriterion("err_time between", value1, value2, "errTime");
            return (Criteria) this;
        }

        public Criteria andErrTimeNotBetween(Date value1, Date value2) {
            addCriterion("err_time not between", value1, value2, "errTime");
            return (Criteria) this;
        }

        public Criteria andErrNumIsNull() {
            addCriterion("err_num is null");
            return (Criteria) this;
        }

        public Criteria andErrNumIsNotNull() {
            addCriterion("err_num is not null");
            return (Criteria) this;
        }

        public Criteria andErrNumEqualTo(Integer value) {
            addCriterion("err_num =", value, "errNum");
            return (Criteria) this;
        }

        public Criteria andErrNumNotEqualTo(Integer value) {
            addCriterion("err_num <>", value, "errNum");
            return (Criteria) this;
        }

        public Criteria andErrNumGreaterThan(Integer value) {
            addCriterion("err_num >", value, "errNum");
            return (Criteria) this;
        }

        public Criteria andErrNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("err_num >=", value, "errNum");
            return (Criteria) this;
        }

        public Criteria andErrNumLessThan(Integer value) {
            addCriterion("err_num <", value, "errNum");
            return (Criteria) this;
        }

        public Criteria andErrNumLessThanOrEqualTo(Integer value) {
            addCriterion("err_num <=", value, "errNum");
            return (Criteria) this;
        }

        public Criteria andErrNumIn(List<Integer> values) {
            addCriterion("err_num in", values, "errNum");
            return (Criteria) this;
        }

        public Criteria andErrNumNotIn(List<Integer> values) {
            addCriterion("err_num not in", values, "errNum");
            return (Criteria) this;
        }

        public Criteria andErrNumBetween(Integer value1, Integer value2) {
            addCriterion("err_num between", value1, value2, "errNum");
            return (Criteria) this;
        }

        public Criteria andErrNumNotBetween(Integer value1, Integer value2) {
            addCriterion("err_num not between", value1, value2, "errNum");
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