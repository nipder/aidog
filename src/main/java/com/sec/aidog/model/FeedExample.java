package com.sec.aidog.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FeedExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FeedExample() {
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

        public Criteria andProduceTimeIsNull() {
            addCriterion("produce_time is null");
            return (Criteria) this;
        }

        public Criteria andProduceTimeIsNotNull() {
            addCriterion("produce_time is not null");
            return (Criteria) this;
        }

        public Criteria andProduceTimeEqualTo(Date value) {
            addCriterion("produce_time =", value, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeNotEqualTo(Date value) {
            addCriterion("produce_time <>", value, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeGreaterThan(Date value) {
            addCriterion("produce_time >", value, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("produce_time >=", value, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeLessThan(Date value) {
            addCriterion("produce_time <", value, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeLessThanOrEqualTo(Date value) {
            addCriterion("produce_time <=", value, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeIn(List<Date> values) {
            addCriterion("produce_time in", values, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeNotIn(List<Date> values) {
            addCriterion("produce_time not in", values, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeBetween(Date value1, Date value2) {
            addCriterion("produce_time between", value1, value2, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeNotBetween(Date value1, Date value2) {
            addCriterion("produce_time not between", value1, value2, "produceTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIsNull() {
            addCriterion("register_time is null");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIsNotNull() {
            addCriterion("register_time is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeEqualTo(Date value) {
            addCriterion("register_time =", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotEqualTo(Date value) {
            addCriterion("register_time <>", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeGreaterThan(Date value) {
            addCriterion("register_time >", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("register_time >=", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeLessThan(Date value) {
            addCriterion("register_time <", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeLessThanOrEqualTo(Date value) {
            addCriterion("register_time <=", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIn(List<Date> values) {
            addCriterion("register_time in", values, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotIn(List<Date> values) {
            addCriterion("register_time not in", values, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeBetween(Date value1, Date value2) {
            addCriterion("register_time between", value1, value2, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotBetween(Date value1, Date value2) {
            addCriterion("register_time not between", value1, value2, "registerTime");
            return (Criteria) this;
        }

        public Criteria andDosingTotalIsNull() {
            addCriterion("dosing_total is null");
            return (Criteria) this;
        }

        public Criteria andDosingTotalIsNotNull() {
            addCriterion("dosing_total is not null");
            return (Criteria) this;
        }

        public Criteria andDosingTotalEqualTo(Integer value) {
            addCriterion("dosing_total =", value, "dosingTotal");
            return (Criteria) this;
        }

        public Criteria andDosingTotalNotEqualTo(Integer value) {
            addCriterion("dosing_total <>", value, "dosingTotal");
            return (Criteria) this;
        }

        public Criteria andDosingTotalGreaterThan(Integer value) {
            addCriterion("dosing_total >", value, "dosingTotal");
            return (Criteria) this;
        }

        public Criteria andDosingTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("dosing_total >=", value, "dosingTotal");
            return (Criteria) this;
        }

        public Criteria andDosingTotalLessThan(Integer value) {
            addCriterion("dosing_total <", value, "dosingTotal");
            return (Criteria) this;
        }

        public Criteria andDosingTotalLessThanOrEqualTo(Integer value) {
            addCriterion("dosing_total <=", value, "dosingTotal");
            return (Criteria) this;
        }

        public Criteria andDosingTotalIn(List<Integer> values) {
            addCriterion("dosing_total in", values, "dosingTotal");
            return (Criteria) this;
        }

        public Criteria andDosingTotalNotIn(List<Integer> values) {
            addCriterion("dosing_total not in", values, "dosingTotal");
            return (Criteria) this;
        }

        public Criteria andDosingTotalBetween(Integer value1, Integer value2) {
            addCriterion("dosing_total between", value1, value2, "dosingTotal");
            return (Criteria) this;
        }

        public Criteria andDosingTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("dosing_total not between", value1, value2, "dosingTotal");
            return (Criteria) this;
        }

        public Criteria andChangebatteryTimeIsNull() {
            addCriterion("changebattery_time is null");
            return (Criteria) this;
        }

        public Criteria andChangebatteryTimeIsNotNull() {
            addCriterion("changebattery_time is not null");
            return (Criteria) this;
        }

        public Criteria andChangebatteryTimeEqualTo(Date value) {
            addCriterion("changebattery_time =", value, "changebatteryTime");
            return (Criteria) this;
        }

        public Criteria andChangebatteryTimeNotEqualTo(Date value) {
            addCriterion("changebattery_time <>", value, "changebatteryTime");
            return (Criteria) this;
        }

        public Criteria andChangebatteryTimeGreaterThan(Date value) {
            addCriterion("changebattery_time >", value, "changebatteryTime");
            return (Criteria) this;
        }

        public Criteria andChangebatteryTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("changebattery_time >=", value, "changebatteryTime");
            return (Criteria) this;
        }

        public Criteria andChangebatteryTimeLessThan(Date value) {
            addCriterion("changebattery_time <", value, "changebatteryTime");
            return (Criteria) this;
        }

        public Criteria andChangebatteryTimeLessThanOrEqualTo(Date value) {
            addCriterion("changebattery_time <=", value, "changebatteryTime");
            return (Criteria) this;
        }

        public Criteria andChangebatteryTimeIn(List<Date> values) {
            addCriterion("changebattery_time in", values, "changebatteryTime");
            return (Criteria) this;
        }

        public Criteria andChangebatteryTimeNotIn(List<Date> values) {
            addCriterion("changebattery_time not in", values, "changebatteryTime");
            return (Criteria) this;
        }

        public Criteria andChangebatteryTimeBetween(Date value1, Date value2) {
            addCriterion("changebattery_time between", value1, value2, "changebatteryTime");
            return (Criteria) this;
        }

        public Criteria andChangebatteryTimeNotBetween(Date value1, Date value2) {
            addCriterion("changebattery_time not between", value1, value2, "changebatteryTime");
            return (Criteria) this;
        }

        public Criteria andChangepillTimeIsNull() {
            addCriterion("changepill_time is null");
            return (Criteria) this;
        }

        public Criteria andChangepillTimeIsNotNull() {
            addCriterion("changepill_time is not null");
            return (Criteria) this;
        }

        public Criteria andChangepillTimeEqualTo(Date value) {
            addCriterion("changepill_time =", value, "changepillTime");
            return (Criteria) this;
        }

        public Criteria andChangepillTimeNotEqualTo(Date value) {
            addCriterion("changepill_time <>", value, "changepillTime");
            return (Criteria) this;
        }

        public Criteria andChangepillTimeGreaterThan(Date value) {
            addCriterion("changepill_time >", value, "changepillTime");
            return (Criteria) this;
        }

        public Criteria andChangepillTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("changepill_time >=", value, "changepillTime");
            return (Criteria) this;
        }

        public Criteria andChangepillTimeLessThan(Date value) {
            addCriterion("changepill_time <", value, "changepillTime");
            return (Criteria) this;
        }

        public Criteria andChangepillTimeLessThanOrEqualTo(Date value) {
            addCriterion("changepill_time <=", value, "changepillTime");
            return (Criteria) this;
        }

        public Criteria andChangepillTimeIn(List<Date> values) {
            addCriterion("changepill_time in", values, "changepillTime");
            return (Criteria) this;
        }

        public Criteria andChangepillTimeNotIn(List<Date> values) {
            addCriterion("changepill_time not in", values, "changepillTime");
            return (Criteria) this;
        }

        public Criteria andChangepillTimeBetween(Date value1, Date value2) {
            addCriterion("changepill_time between", value1, value2, "changepillTime");
            return (Criteria) this;
        }

        public Criteria andChangepillTimeNotBetween(Date value1, Date value2) {
            addCriterion("changepill_time not between", value1, value2, "changepillTime");
            return (Criteria) this;
        }

        public Criteria andBindTimeIsNull() {
            addCriterion("bind_time is null");
            return (Criteria) this;
        }

        public Criteria andBindTimeIsNotNull() {
            addCriterion("bind_time is not null");
            return (Criteria) this;
        }

        public Criteria andBindTimeEqualTo(Date value) {
            addCriterion("bind_time =", value, "bindTime");
            return (Criteria) this;
        }

        public Criteria andBindTimeNotEqualTo(Date value) {
            addCriterion("bind_time <>", value, "bindTime");
            return (Criteria) this;
        }

        public Criteria andBindTimeGreaterThan(Date value) {
            addCriterion("bind_time >", value, "bindTime");
            return (Criteria) this;
        }

        public Criteria andBindTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("bind_time >=", value, "bindTime");
            return (Criteria) this;
        }

        public Criteria andBindTimeLessThan(Date value) {
            addCriterion("bind_time <", value, "bindTime");
            return (Criteria) this;
        }

        public Criteria andBindTimeLessThanOrEqualTo(Date value) {
            addCriterion("bind_time <=", value, "bindTime");
            return (Criteria) this;
        }

        public Criteria andBindTimeIn(List<Date> values) {
            addCriterion("bind_time in", values, "bindTime");
            return (Criteria) this;
        }

        public Criteria andBindTimeNotIn(List<Date> values) {
            addCriterion("bind_time not in", values, "bindTime");
            return (Criteria) this;
        }

        public Criteria andBindTimeBetween(Date value1, Date value2) {
            addCriterion("bind_time between", value1, value2, "bindTime");
            return (Criteria) this;
        }

        public Criteria andBindTimeNotBetween(Date value1, Date value2) {
            addCriterion("bind_time not between", value1, value2, "bindTime");
            return (Criteria) this;
        }

        public Criteria andHamletIsNull() {
            addCriterion("hamlet is null");
            return (Criteria) this;
        }

        public Criteria andHamletIsNotNull() {
            addCriterion("hamlet is not null");
            return (Criteria) this;
        }

        public Criteria andHamletEqualTo(String value) {
            addCriterion("hamlet =", value, "hamlet");
            return (Criteria) this;
        }

        public Criteria andHamletNotEqualTo(String value) {
            addCriterion("hamlet <>", value, "hamlet");
            return (Criteria) this;
        }

        public Criteria andHamletGreaterThan(String value) {
            addCriterion("hamlet >", value, "hamlet");
            return (Criteria) this;
        }

        public Criteria andHamletGreaterThanOrEqualTo(String value) {
            addCriterion("hamlet >=", value, "hamlet");
            return (Criteria) this;
        }

        public Criteria andHamletLessThan(String value) {
            addCriterion("hamlet <", value, "hamlet");
            return (Criteria) this;
        }

        public Criteria andHamletLessThanOrEqualTo(String value) {
            addCriterion("hamlet <=", value, "hamlet");
            return (Criteria) this;
        }

        public Criteria andHamletLike(String value) {
            addCriterion("hamlet like", value, "hamlet");
            return (Criteria) this;
        }

        public Criteria andHamletNotLike(String value) {
            addCriterion("hamlet not like", value, "hamlet");
            return (Criteria) this;
        }

        public Criteria andHamletIn(List<String> values) {
            addCriterion("hamlet in", values, "hamlet");
            return (Criteria) this;
        }

        public Criteria andHamletNotIn(List<String> values) {
            addCriterion("hamlet not in", values, "hamlet");
            return (Criteria) this;
        }

        public Criteria andHamletBetween(String value1, String value2) {
            addCriterion("hamlet between", value1, value2, "hamlet");
            return (Criteria) this;
        }

        public Criteria andHamletNotBetween(String value1, String value2) {
            addCriterion("hamlet not between", value1, value2, "hamlet");
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
