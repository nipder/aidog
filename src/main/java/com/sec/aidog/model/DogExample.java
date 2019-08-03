package com.sec.aidog.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DogExample() {
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

        public Criteria andDogIdIsNull() {
            addCriterion("dog_id is null");
            return (Criteria) this;
        }

        public Criteria andDogIdIsNotNull() {
            addCriterion("dog_id is not null");
            return (Criteria) this;
        }

        public Criteria andDogIdEqualTo(Integer value) {
            addCriterion("dog_id =", value, "dogId");
            return (Criteria) this;
        }

        public Criteria andDogIdNotEqualTo(Integer value) {
            addCriterion("dog_id <>", value, "dogId");
            return (Criteria) this;
        }

        public Criteria andDogIdGreaterThan(Integer value) {
            addCriterion("dog_id >", value, "dogId");
            return (Criteria) this;
        }

        public Criteria andDogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dog_id >=", value, "dogId");
            return (Criteria) this;
        }

        public Criteria andDogIdLessThan(Integer value) {
            addCriterion("dog_id <", value, "dogId");
            return (Criteria) this;
        }

        public Criteria andDogIdLessThanOrEqualTo(Integer value) {
            addCriterion("dog_id <=", value, "dogId");
            return (Criteria) this;
        }

        public Criteria andDogIdIn(List<Integer> values) {
            addCriterion("dog_id in", values, "dogId");
            return (Criteria) this;
        }

        public Criteria andDogIdNotIn(List<Integer> values) {
            addCriterion("dog_id not in", values, "dogId");
            return (Criteria) this;
        }

        public Criteria andDogIdBetween(Integer value1, Integer value2) {
            addCriterion("dog_id between", value1, value2, "dogId");
            return (Criteria) this;
        }

        public Criteria andDogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dog_id not between", value1, value2, "dogId");
            return (Criteria) this;
        }

        public Criteria andDogNameIsNull() {
            addCriterion("dog_name is null");
            return (Criteria) this;
        }

        public Criteria andDogNameIsNotNull() {
            addCriterion("dog_name is not null");
            return (Criteria) this;
        }

        public Criteria andDogNameEqualTo(String value) {
            addCriterion("dog_name =", value, "dogName");
            return (Criteria) this;
        }

        public Criteria andDogNameNotEqualTo(String value) {
            addCriterion("dog_name <>", value, "dogName");
            return (Criteria) this;
        }

        public Criteria andDogNameGreaterThan(String value) {
            addCriterion("dog_name >", value, "dogName");
            return (Criteria) this;
        }

        public Criteria andDogNameGreaterThanOrEqualTo(String value) {
            addCriterion("dog_name >=", value, "dogName");
            return (Criteria) this;
        }

        public Criteria andDogNameLessThan(String value) {
            addCriterion("dog_name <", value, "dogName");
            return (Criteria) this;
        }

        public Criteria andDogNameLessThanOrEqualTo(String value) {
            addCriterion("dog_name <=", value, "dogName");
            return (Criteria) this;
        }

        public Criteria andDogNameLike(String value) {
            addCriterion("dog_name like", value, "dogName");
            return (Criteria) this;
        }

        public Criteria andDogNameNotLike(String value) {
            addCriterion("dog_name not like", value, "dogName");
            return (Criteria) this;
        }

        public Criteria andDogNameIn(List<String> values) {
            addCriterion("dog_name in", values, "dogName");
            return (Criteria) this;
        }

        public Criteria andDogNameNotIn(List<String> values) {
            addCriterion("dog_name not in", values, "dogName");
            return (Criteria) this;
        }

        public Criteria andDogNameBetween(String value1, String value2) {
            addCriterion("dog_name between", value1, value2, "dogName");
            return (Criteria) this;
        }

        public Criteria andDogNameNotBetween(String value1, String value2) {
            addCriterion("dog_name not between", value1, value2, "dogName");
            return (Criteria) this;
        }

        public Criteria andNecIdIsNull() {
            addCriterion("nec_id is null");
            return (Criteria) this;
        }

        public Criteria andNecIdIsNotNull() {
            addCriterion("nec_id is not null");
            return (Criteria) this;
        }

        public Criteria andNecIdEqualTo(String value) {
            addCriterion("nec_id =", value, "necId");
            return (Criteria) this;
        }

        public Criteria andNecIdNotEqualTo(String value) {
            addCriterion("nec_id <>", value, "necId");
            return (Criteria) this;
        }

        public Criteria andNecIdGreaterThan(String value) {
            addCriterion("nec_id >", value, "necId");
            return (Criteria) this;
        }

        public Criteria andNecIdGreaterThanOrEqualTo(String value) {
            addCriterion("nec_id >=", value, "necId");
            return (Criteria) this;
        }

        public Criteria andNecIdLessThan(String value) {
            addCriterion("nec_id <", value, "necId");
            return (Criteria) this;
        }

        public Criteria andNecIdLessThanOrEqualTo(String value) {
            addCriterion("nec_id <=", value, "necId");
            return (Criteria) this;
        }

        public Criteria andNecIdLike(String value) {
            addCriterion("nec_id like", value, "necId");
            return (Criteria) this;
        }

        public Criteria andNecIdNotLike(String value) {
            addCriterion("nec_id not like", value, "necId");
            return (Criteria) this;
        }

        public Criteria andNecIdIn(List<String> values) {
            addCriterion("nec_id in", values, "necId");
            return (Criteria) this;
        }

        public Criteria andNecIdNotIn(List<String> values) {
            addCriterion("nec_id not in", values, "necId");
            return (Criteria) this;
        }

        public Criteria andNecIdBetween(String value1, String value2) {
            addCriterion("nec_id between", value1, value2, "necId");
            return (Criteria) this;
        }

        public Criteria andNecIdNotBetween(String value1, String value2) {
            addCriterion("nec_id not between", value1, value2, "necId");
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

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andManagerNameIsNull() {
            addCriterion("manager_name is null");
            return (Criteria) this;
        }

        public Criteria andManagerNameIsNotNull() {
            addCriterion("manager_name is not null");
            return (Criteria) this;
        }

        public Criteria andManagerNameEqualTo(String value) {
            addCriterion("manager_name =", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameNotEqualTo(String value) {
            addCriterion("manager_name <>", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameGreaterThan(String value) {
            addCriterion("manager_name >", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameGreaterThanOrEqualTo(String value) {
            addCriterion("manager_name >=", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameLessThan(String value) {
            addCriterion("manager_name <", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameLessThanOrEqualTo(String value) {
            addCriterion("manager_name <=", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameLike(String value) {
            addCriterion("manager_name like", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameNotLike(String value) {
            addCriterion("manager_name not like", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameIn(List<String> values) {
            addCriterion("manager_name in", values, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameNotIn(List<String> values) {
            addCriterion("manager_name not in", values, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameBetween(String value1, String value2) {
            addCriterion("manager_name between", value1, value2, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameNotBetween(String value1, String value2) {
            addCriterion("manager_name not between", value1, value2, "managerName");
            return (Criteria) this;
        }

        public Criteria andDogownerIdIsNull() {
            addCriterion("dogowner_id is null");
            return (Criteria) this;
        }

        public Criteria andDogownerIdIsNotNull() {
            addCriterion("dogowner_id is not null");
            return (Criteria) this;
        }

        public Criteria andDogownerIdEqualTo(Integer value) {
            addCriterion("dogowner_id =", value, "dogownerId");
            return (Criteria) this;
        }

        public Criteria andDogownerIdNotEqualTo(Integer value) {
            addCriterion("dogowner_id <>", value, "dogownerId");
            return (Criteria) this;
        }

        public Criteria andDogownerIdGreaterThan(Integer value) {
            addCriterion("dogowner_id >", value, "dogownerId");
            return (Criteria) this;
        }

        public Criteria andDogownerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dogowner_id >=", value, "dogownerId");
            return (Criteria) this;
        }

        public Criteria andDogownerIdLessThan(Integer value) {
            addCriterion("dogowner_id <", value, "dogownerId");
            return (Criteria) this;
        }

        public Criteria andDogownerIdLessThanOrEqualTo(Integer value) {
            addCriterion("dogowner_id <=", value, "dogownerId");
            return (Criteria) this;
        }

        public Criteria andDogownerIdIn(List<Integer> values) {
            addCriterion("dogowner_id in", values, "dogownerId");
            return (Criteria) this;
        }

        public Criteria andDogownerIdNotIn(List<Integer> values) {
            addCriterion("dogowner_id not in", values, "dogownerId");
            return (Criteria) this;
        }

        public Criteria andDogownerIdBetween(Integer value1, Integer value2) {
            addCriterion("dogowner_id between", value1, value2, "dogownerId");
            return (Criteria) this;
        }

        public Criteria andDogownerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dogowner_id not between", value1, value2, "dogownerId");
            return (Criteria) this;
        }

        public Criteria andDogWeightIsNull() {
            addCriterion("dog_weight is null");
            return (Criteria) this;
        }

        public Criteria andDogWeightIsNotNull() {
            addCriterion("dog_weight is not null");
            return (Criteria) this;
        }

        public Criteria andDogWeightEqualTo(String value) {
            addCriterion("dog_weight =", value, "dogWeight");
            return (Criteria) this;
        }

        public Criteria andDogWeightNotEqualTo(String value) {
            addCriterion("dog_weight <>", value, "dogWeight");
            return (Criteria) this;
        }

        public Criteria andDogWeightGreaterThan(String value) {
            addCriterion("dog_weight >", value, "dogWeight");
            return (Criteria) this;
        }

        public Criteria andDogWeightGreaterThanOrEqualTo(String value) {
            addCriterion("dog_weight >=", value, "dogWeight");
            return (Criteria) this;
        }

        public Criteria andDogWeightLessThan(String value) {
            addCriterion("dog_weight <", value, "dogWeight");
            return (Criteria) this;
        }

        public Criteria andDogWeightLessThanOrEqualTo(String value) {
            addCriterion("dog_weight <=", value, "dogWeight");
            return (Criteria) this;
        }

        public Criteria andDogWeightLike(String value) {
            addCriterion("dog_weight like", value, "dogWeight");
            return (Criteria) this;
        }

        public Criteria andDogWeightNotLike(String value) {
            addCriterion("dog_weight not like", value, "dogWeight");
            return (Criteria) this;
        }

        public Criteria andDogWeightIn(List<String> values) {
            addCriterion("dog_weight in", values, "dogWeight");
            return (Criteria) this;
        }

        public Criteria andDogWeightNotIn(List<String> values) {
            addCriterion("dog_weight not in", values, "dogWeight");
            return (Criteria) this;
        }

        public Criteria andDogWeightBetween(String value1, String value2) {
            addCriterion("dog_weight between", value1, value2, "dogWeight");
            return (Criteria) this;
        }

        public Criteria andDogWeightNotBetween(String value1, String value2) {
            addCriterion("dog_weight not between", value1, value2, "dogWeight");
            return (Criteria) this;
        }

        public Criteria andDogColorIsNull() {
            addCriterion("dog_color is null");
            return (Criteria) this;
        }

        public Criteria andDogColorIsNotNull() {
            addCriterion("dog_color is not null");
            return (Criteria) this;
        }

        public Criteria andDogColorEqualTo(String value) {
            addCriterion("dog_color =", value, "dogColor");
            return (Criteria) this;
        }

        public Criteria andDogColorNotEqualTo(String value) {
            addCriterion("dog_color <>", value, "dogColor");
            return (Criteria) this;
        }

        public Criteria andDogColorGreaterThan(String value) {
            addCriterion("dog_color >", value, "dogColor");
            return (Criteria) this;
        }

        public Criteria andDogColorGreaterThanOrEqualTo(String value) {
            addCriterion("dog_color >=", value, "dogColor");
            return (Criteria) this;
        }

        public Criteria andDogColorLessThan(String value) {
            addCriterion("dog_color <", value, "dogColor");
            return (Criteria) this;
        }

        public Criteria andDogColorLessThanOrEqualTo(String value) {
            addCriterion("dog_color <=", value, "dogColor");
            return (Criteria) this;
        }

        public Criteria andDogColorLike(String value) {
            addCriterion("dog_color like", value, "dogColor");
            return (Criteria) this;
        }

        public Criteria andDogColorNotLike(String value) {
            addCriterion("dog_color not like", value, "dogColor");
            return (Criteria) this;
        }

        public Criteria andDogColorIn(List<String> values) {
            addCriterion("dog_color in", values, "dogColor");
            return (Criteria) this;
        }

        public Criteria andDogColorNotIn(List<String> values) {
            addCriterion("dog_color not in", values, "dogColor");
            return (Criteria) this;
        }

        public Criteria andDogColorBetween(String value1, String value2) {
            addCriterion("dog_color between", value1, value2, "dogColor");
            return (Criteria) this;
        }

        public Criteria andDogColorNotBetween(String value1, String value2) {
            addCriterion("dog_color not between", value1, value2, "dogColor");
            return (Criteria) this;
        }

        public Criteria andDogAgeIsNull() {
            addCriterion("dog_age is null");
            return (Criteria) this;
        }

        public Criteria andDogAgeIsNotNull() {
            addCriterion("dog_age is not null");
            return (Criteria) this;
        }

        public Criteria andDogAgeEqualTo(Integer value) {
            addCriterion("dog_age =", value, "dogAge");
            return (Criteria) this;
        }

        public Criteria andDogAgeNotEqualTo(Integer value) {
            addCriterion("dog_age <>", value, "dogAge");
            return (Criteria) this;
        }

        public Criteria andDogAgeGreaterThan(Integer value) {
            addCriterion("dog_age >", value, "dogAge");
            return (Criteria) this;
        }

        public Criteria andDogAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("dog_age >=", value, "dogAge");
            return (Criteria) this;
        }

        public Criteria andDogAgeLessThan(Integer value) {
            addCriterion("dog_age <", value, "dogAge");
            return (Criteria) this;
        }

        public Criteria andDogAgeLessThanOrEqualTo(Integer value) {
            addCriterion("dog_age <=", value, "dogAge");
            return (Criteria) this;
        }

        public Criteria andDogAgeIn(List<Integer> values) {
            addCriterion("dog_age in", values, "dogAge");
            return (Criteria) this;
        }

        public Criteria andDogAgeNotIn(List<Integer> values) {
            addCriterion("dog_age not in", values, "dogAge");
            return (Criteria) this;
        }

        public Criteria andDogAgeBetween(Integer value1, Integer value2) {
            addCriterion("dog_age between", value1, value2, "dogAge");
            return (Criteria) this;
        }

        public Criteria andDogAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("dog_age not between", value1, value2, "dogAge");
            return (Criteria) this;
        }

        public Criteria andDogInfoIsNull() {
            addCriterion("dog_info is null");
            return (Criteria) this;
        }

        public Criteria andDogInfoIsNotNull() {
            addCriterion("dog_info is not null");
            return (Criteria) this;
        }

        public Criteria andDogInfoEqualTo(String value) {
            addCriterion("dog_info =", value, "dogInfo");
            return (Criteria) this;
        }

        public Criteria andDogInfoNotEqualTo(String value) {
            addCriterion("dog_info <>", value, "dogInfo");
            return (Criteria) this;
        }

        public Criteria andDogInfoGreaterThan(String value) {
            addCriterion("dog_info >", value, "dogInfo");
            return (Criteria) this;
        }

        public Criteria andDogInfoGreaterThanOrEqualTo(String value) {
            addCriterion("dog_info >=", value, "dogInfo");
            return (Criteria) this;
        }

        public Criteria andDogInfoLessThan(String value) {
            addCriterion("dog_info <", value, "dogInfo");
            return (Criteria) this;
        }

        public Criteria andDogInfoLessThanOrEqualTo(String value) {
            addCriterion("dog_info <=", value, "dogInfo");
            return (Criteria) this;
        }

        public Criteria andDogInfoLike(String value) {
            addCriterion("dog_info like", value, "dogInfo");
            return (Criteria) this;
        }

        public Criteria andDogInfoNotLike(String value) {
            addCriterion("dog_info not like", value, "dogInfo");
            return (Criteria) this;
        }

        public Criteria andDogInfoIn(List<String> values) {
            addCriterion("dog_info in", values, "dogInfo");
            return (Criteria) this;
        }

        public Criteria andDogInfoNotIn(List<String> values) {
            addCriterion("dog_info not in", values, "dogInfo");
            return (Criteria) this;
        }

        public Criteria andDogInfoBetween(String value1, String value2) {
            addCriterion("dog_info between", value1, value2, "dogInfo");
            return (Criteria) this;
        }

        public Criteria andDogInfoNotBetween(String value1, String value2) {
            addCriterion("dog_info not between", value1, value2, "dogInfo");
            return (Criteria) this;
        }

        public Criteria andDogStatusIsNull() {
            addCriterion("dog_status is null");
            return (Criteria) this;
        }

        public Criteria andDogStatusIsNotNull() {
            addCriterion("dog_status is not null");
            return (Criteria) this;
        }

        public Criteria andDogStatusEqualTo(String value) {
            addCriterion("dog_status =", value, "dogStatus");
            return (Criteria) this;
        }

        public Criteria andDogStatusNotEqualTo(String value) {
            addCriterion("dog_status <>", value, "dogStatus");
            return (Criteria) this;
        }

        public Criteria andDogStatusGreaterThan(String value) {
            addCriterion("dog_status >", value, "dogStatus");
            return (Criteria) this;
        }

        public Criteria andDogStatusGreaterThanOrEqualTo(String value) {
            addCriterion("dog_status >=", value, "dogStatus");
            return (Criteria) this;
        }

        public Criteria andDogStatusLessThan(String value) {
            addCriterion("dog_status <", value, "dogStatus");
            return (Criteria) this;
        }

        public Criteria andDogStatusLessThanOrEqualTo(String value) {
            addCriterion("dog_status <=", value, "dogStatus");
            return (Criteria) this;
        }

        public Criteria andDogStatusLike(String value) {
            addCriterion("dog_status like", value, "dogStatus");
            return (Criteria) this;
        }

        public Criteria andDogStatusNotLike(String value) {
            addCriterion("dog_status not like", value, "dogStatus");
            return (Criteria) this;
        }

        public Criteria andDogStatusIn(List<String> values) {
            addCriterion("dog_status in", values, "dogStatus");
            return (Criteria) this;
        }

        public Criteria andDogStatusNotIn(List<String> values) {
            addCriterion("dog_status not in", values, "dogStatus");
            return (Criteria) this;
        }

        public Criteria andDogStatusBetween(String value1, String value2) {
            addCriterion("dog_status between", value1, value2, "dogStatus");
            return (Criteria) this;
        }

        public Criteria andDogStatusNotBetween(String value1, String value2) {
            addCriterion("dog_status not between", value1, value2, "dogStatus");
            return (Criteria) this;
        }

        public Criteria andDogRegistertimeIsNull() {
            addCriterion("dog_registertime is null");
            return (Criteria) this;
        }

        public Criteria andDogRegistertimeIsNotNull() {
            addCriterion("dog_registertime is not null");
            return (Criteria) this;
        }

        public Criteria andDogRegistertimeEqualTo(Date value) {
            addCriterion("dog_registertime =", value, "dogRegistertime");
            return (Criteria) this;
        }

        public Criteria andDogRegistertimeNotEqualTo(Date value) {
            addCriterion("dog_registertime <>", value, "dogRegistertime");
            return (Criteria) this;
        }

        public Criteria andDogRegistertimeGreaterThan(Date value) {
            addCriterion("dog_registertime >", value, "dogRegistertime");
            return (Criteria) this;
        }

        public Criteria andDogRegistertimeGreaterThanOrEqualTo(Date value) {
            addCriterion("dog_registertime >=", value, "dogRegistertime");
            return (Criteria) this;
        }

        public Criteria andDogRegistertimeLessThan(Date value) {
            addCriterion("dog_registertime <", value, "dogRegistertime");
            return (Criteria) this;
        }

        public Criteria andDogRegistertimeLessThanOrEqualTo(Date value) {
            addCriterion("dog_registertime <=", value, "dogRegistertime");
            return (Criteria) this;
        }

        public Criteria andDogRegistertimeIn(List<Date> values) {
            addCriterion("dog_registertime in", values, "dogRegistertime");
            return (Criteria) this;
        }

        public Criteria andDogRegistertimeNotIn(List<Date> values) {
            addCriterion("dog_registertime not in", values, "dogRegistertime");
            return (Criteria) this;
        }

        public Criteria andDogRegistertimeBetween(Date value1, Date value2) {
            addCriterion("dog_registertime between", value1, value2, "dogRegistertime");
            return (Criteria) this;
        }

        public Criteria andDogRegistertimeNotBetween(Date value1, Date value2) {
            addCriterion("dog_registertime not between", value1, value2, "dogRegistertime");
            return (Criteria) this;
        }

        public Criteria andDogSexIsNull() {
            addCriterion("dog_sex is null");
            return (Criteria) this;
        }

        public Criteria andDogSexIsNotNull() {
            addCriterion("dog_sex is not null");
            return (Criteria) this;
        }

        public Criteria andDogSexEqualTo(String value) {
            addCriterion("dog_sex =", value, "dogSex");
            return (Criteria) this;
        }

        public Criteria andDogSexNotEqualTo(String value) {
            addCriterion("dog_sex <>", value, "dogSex");
            return (Criteria) this;
        }

        public Criteria andDogSexGreaterThan(String value) {
            addCriterion("dog_sex >", value, "dogSex");
            return (Criteria) this;
        }

        public Criteria andDogSexGreaterThanOrEqualTo(String value) {
            addCriterion("dog_sex >=", value, "dogSex");
            return (Criteria) this;
        }

        public Criteria andDogSexLessThan(String value) {
            addCriterion("dog_sex <", value, "dogSex");
            return (Criteria) this;
        }

        public Criteria andDogSexLessThanOrEqualTo(String value) {
            addCriterion("dog_sex <=", value, "dogSex");
            return (Criteria) this;
        }

        public Criteria andDogSexLike(String value) {
            addCriterion("dog_sex like", value, "dogSex");
            return (Criteria) this;
        }

        public Criteria andDogSexNotLike(String value) {
            addCriterion("dog_sex not like", value, "dogSex");
            return (Criteria) this;
        }

        public Criteria andDogSexIn(List<String> values) {
            addCriterion("dog_sex in", values, "dogSex");
            return (Criteria) this;
        }

        public Criteria andDogSexNotIn(List<String> values) {
            addCriterion("dog_sex not in", values, "dogSex");
            return (Criteria) this;
        }

        public Criteria andDogSexBetween(String value1, String value2) {
            addCriterion("dog_sex between", value1, value2, "dogSex");
            return (Criteria) this;
        }

        public Criteria andDogSexNotBetween(String value1, String value2) {
            addCriterion("dog_sex not between", value1, value2, "dogSex");
            return (Criteria) this;
        }

        public Criteria andDogGovcodeIsNull() {
            addCriterion("dog_govcode is null");
            return (Criteria) this;
        }

        public Criteria andDogGovcodeIsNotNull() {
            addCriterion("dog_govcode is not null");
            return (Criteria) this;
        }

        public Criteria andDogGovcodeEqualTo(String value) {
            addCriterion("dog_govcode =", value, "dogGovcode");
            return (Criteria) this;
        }

        public Criteria andDogGovcodeNotEqualTo(String value) {
            addCriterion("dog_govcode <>", value, "dogGovcode");
            return (Criteria) this;
        }

        public Criteria andDogGovcodeGreaterThan(String value) {
            addCriterion("dog_govcode >", value, "dogGovcode");
            return (Criteria) this;
        }

        public Criteria andDogGovcodeGreaterThanOrEqualTo(String value) {
            addCriterion("dog_govcode >=", value, "dogGovcode");
            return (Criteria) this;
        }

        public Criteria andDogGovcodeLessThan(String value) {
            addCriterion("dog_govcode <", value, "dogGovcode");
            return (Criteria) this;
        }

        public Criteria andDogGovcodeLessThanOrEqualTo(String value) {
            addCriterion("dog_govcode <=", value, "dogGovcode");
            return (Criteria) this;
        }

        public Criteria andDogGovcodeLike(String value) {
            addCriterion("dog_govcode like", value, "dogGovcode");
            return (Criteria) this;
        }

        public Criteria andDogGovcodeNotLike(String value) {
            addCriterion("dog_govcode not like", value, "dogGovcode");
            return (Criteria) this;
        }

        public Criteria andDogGovcodeIn(List<String> values) {
            addCriterion("dog_govcode in", values, "dogGovcode");
            return (Criteria) this;
        }

        public Criteria andDogGovcodeNotIn(List<String> values) {
            addCriterion("dog_govcode not in", values, "dogGovcode");
            return (Criteria) this;
        }

        public Criteria andDogGovcodeBetween(String value1, String value2) {
            addCriterion("dog_govcode between", value1, value2, "dogGovcode");
            return (Criteria) this;
        }

        public Criteria andDogGovcodeNotBetween(String value1, String value2) {
            addCriterion("dog_govcode not between", value1, value2, "dogGovcode");
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