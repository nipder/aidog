package com.sec.aidog.model;

import java.util.ArrayList;
import java.util.List;

public class DogownerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DogownerExample() {
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

        public Criteria andOwnerIdIsNull() {
            addCriterion("owner_id is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIsNotNull() {
            addCriterion("owner_id is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdEqualTo(Integer value) {
            addCriterion("owner_id =", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotEqualTo(Integer value) {
            addCriterion("owner_id <>", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdGreaterThan(Integer value) {
            addCriterion("owner_id >", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("owner_id >=", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLessThan(Integer value) {
            addCriterion("owner_id <", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLessThanOrEqualTo(Integer value) {
            addCriterion("owner_id <=", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIn(List<Integer> values) {
            addCriterion("owner_id in", values, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotIn(List<Integer> values) {
            addCriterion("owner_id not in", values, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdBetween(Integer value1, Integer value2) {
            addCriterion("owner_id between", value1, value2, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("owner_id not between", value1, value2, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerNameIsNull() {
            addCriterion("owner_name is null");
            return (Criteria) this;
        }

        public Criteria andOwnerNameIsNotNull() {
            addCriterion("owner_name is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerNameEqualTo(String value) {
            addCriterion("owner_name =", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameNotEqualTo(String value) {
            addCriterion("owner_name <>", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameGreaterThan(String value) {
            addCriterion("owner_name >", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameGreaterThanOrEqualTo(String value) {
            addCriterion("owner_name >=", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameLessThan(String value) {
            addCriterion("owner_name <", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameLessThanOrEqualTo(String value) {
            addCriterion("owner_name <=", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameLike(String value) {
            addCriterion("owner_name like", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameNotLike(String value) {
            addCriterion("owner_name not like", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameIn(List<String> values) {
            addCriterion("owner_name in", values, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameNotIn(List<String> values) {
            addCriterion("owner_name not in", values, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameBetween(String value1, String value2) {
            addCriterion("owner_name between", value1, value2, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameNotBetween(String value1, String value2) {
            addCriterion("owner_name not between", value1, value2, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerTelIsNull() {
            addCriterion("owner_tel is null");
            return (Criteria) this;
        }

        public Criteria andOwnerTelIsNotNull() {
            addCriterion("owner_tel is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerTelEqualTo(String value) {
            addCriterion("owner_tel =", value, "ownerTel");
            return (Criteria) this;
        }

        public Criteria andOwnerTelNotEqualTo(String value) {
            addCriterion("owner_tel <>", value, "ownerTel");
            return (Criteria) this;
        }

        public Criteria andOwnerTelGreaterThan(String value) {
            addCriterion("owner_tel >", value, "ownerTel");
            return (Criteria) this;
        }

        public Criteria andOwnerTelGreaterThanOrEqualTo(String value) {
            addCriterion("owner_tel >=", value, "ownerTel");
            return (Criteria) this;
        }

        public Criteria andOwnerTelLessThan(String value) {
            addCriterion("owner_tel <", value, "ownerTel");
            return (Criteria) this;
        }

        public Criteria andOwnerTelLessThanOrEqualTo(String value) {
            addCriterion("owner_tel <=", value, "ownerTel");
            return (Criteria) this;
        }

        public Criteria andOwnerTelLike(String value) {
            addCriterion("owner_tel like", value, "ownerTel");
            return (Criteria) this;
        }

        public Criteria andOwnerTelNotLike(String value) {
            addCriterion("owner_tel not like", value, "ownerTel");
            return (Criteria) this;
        }

        public Criteria andOwnerTelIn(List<String> values) {
            addCriterion("owner_tel in", values, "ownerTel");
            return (Criteria) this;
        }

        public Criteria andOwnerTelNotIn(List<String> values) {
            addCriterion("owner_tel not in", values, "ownerTel");
            return (Criteria) this;
        }

        public Criteria andOwnerTelBetween(String value1, String value2) {
            addCriterion("owner_tel between", value1, value2, "ownerTel");
            return (Criteria) this;
        }

        public Criteria andOwnerTelNotBetween(String value1, String value2) {
            addCriterion("owner_tel not between", value1, value2, "ownerTel");
            return (Criteria) this;
        }

        public Criteria andOwnerAddrIsNull() {
            addCriterion("owner_addr is null");
            return (Criteria) this;
        }

        public Criteria andOwnerAddrIsNotNull() {
            addCriterion("owner_addr is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerAddrEqualTo(String value) {
            addCriterion("owner_addr =", value, "ownerAddr");
            return (Criteria) this;
        }

        public Criteria andOwnerAddrNotEqualTo(String value) {
            addCriterion("owner_addr <>", value, "ownerAddr");
            return (Criteria) this;
        }

        public Criteria andOwnerAddrGreaterThan(String value) {
            addCriterion("owner_addr >", value, "ownerAddr");
            return (Criteria) this;
        }

        public Criteria andOwnerAddrGreaterThanOrEqualTo(String value) {
            addCriterion("owner_addr >=", value, "ownerAddr");
            return (Criteria) this;
        }

        public Criteria andOwnerAddrLessThan(String value) {
            addCriterion("owner_addr <", value, "ownerAddr");
            return (Criteria) this;
        }

        public Criteria andOwnerAddrLessThanOrEqualTo(String value) {
            addCriterion("owner_addr <=", value, "ownerAddr");
            return (Criteria) this;
        }

        public Criteria andOwnerAddrLike(String value) {
            addCriterion("owner_addr like", value, "ownerAddr");
            return (Criteria) this;
        }

        public Criteria andOwnerAddrNotLike(String value) {
            addCriterion("owner_addr not like", value, "ownerAddr");
            return (Criteria) this;
        }

        public Criteria andOwnerAddrIn(List<String> values) {
            addCriterion("owner_addr in", values, "ownerAddr");
            return (Criteria) this;
        }

        public Criteria andOwnerAddrNotIn(List<String> values) {
            addCriterion("owner_addr not in", values, "ownerAddr");
            return (Criteria) this;
        }

        public Criteria andOwnerAddrBetween(String value1, String value2) {
            addCriterion("owner_addr between", value1, value2, "ownerAddr");
            return (Criteria) this;
        }

        public Criteria andOwnerAddrNotBetween(String value1, String value2) {
            addCriterion("owner_addr not between", value1, value2, "ownerAddr");
            return (Criteria) this;
        }

        public Criteria andOwnerStatusIsNull() {
            addCriterion("owner_status is null");
            return (Criteria) this;
        }

        public Criteria andOwnerStatusIsNotNull() {
            addCriterion("owner_status is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerStatusEqualTo(Integer value) {
            addCriterion("owner_status =", value, "ownerStatus");
            return (Criteria) this;
        }

        public Criteria andOwnerStatusNotEqualTo(Integer value) {
            addCriterion("owner_status <>", value, "ownerStatus");
            return (Criteria) this;
        }

        public Criteria andOwnerStatusGreaterThan(Integer value) {
            addCriterion("owner_status >", value, "ownerStatus");
            return (Criteria) this;
        }

        public Criteria andOwnerStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("owner_status >=", value, "ownerStatus");
            return (Criteria) this;
        }

        public Criteria andOwnerStatusLessThan(Integer value) {
            addCriterion("owner_status <", value, "ownerStatus");
            return (Criteria) this;
        }

        public Criteria andOwnerStatusLessThanOrEqualTo(Integer value) {
            addCriterion("owner_status <=", value, "ownerStatus");
            return (Criteria) this;
        }

        public Criteria andOwnerStatusIn(List<Integer> values) {
            addCriterion("owner_status in", values, "ownerStatus");
            return (Criteria) this;
        }

        public Criteria andOwnerStatusNotIn(List<Integer> values) {
            addCriterion("owner_status not in", values, "ownerStatus");
            return (Criteria) this;
        }

        public Criteria andOwnerStatusBetween(Integer value1, Integer value2) {
            addCriterion("owner_status between", value1, value2, "ownerStatus");
            return (Criteria) this;
        }

        public Criteria andOwnerStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("owner_status not between", value1, value2, "ownerStatus");
            return (Criteria) this;
        }

        public Criteria andOwnerIdentityIsNull() {
            addCriterion("owner_identity is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdentityIsNotNull() {
            addCriterion("owner_identity is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdentityEqualTo(String value) {
            addCriterion("owner_identity =", value, "ownerIdentity");
            return (Criteria) this;
        }

        public Criteria andOwnerIdentityNotEqualTo(String value) {
            addCriterion("owner_identity <>", value, "ownerIdentity");
            return (Criteria) this;
        }

        public Criteria andOwnerIdentityGreaterThan(String value) {
            addCriterion("owner_identity >", value, "ownerIdentity");
            return (Criteria) this;
        }

        public Criteria andOwnerIdentityGreaterThanOrEqualTo(String value) {
            addCriterion("owner_identity >=", value, "ownerIdentity");
            return (Criteria) this;
        }

        public Criteria andOwnerIdentityLessThan(String value) {
            addCriterion("owner_identity <", value, "ownerIdentity");
            return (Criteria) this;
        }

        public Criteria andOwnerIdentityLessThanOrEqualTo(String value) {
            addCriterion("owner_identity <=", value, "ownerIdentity");
            return (Criteria) this;
        }

        public Criteria andOwnerIdentityLike(String value) {
            addCriterion("owner_identity like", value, "ownerIdentity");
            return (Criteria) this;
        }

        public Criteria andOwnerIdentityNotLike(String value) {
            addCriterion("owner_identity not like", value, "ownerIdentity");
            return (Criteria) this;
        }

        public Criteria andOwnerIdentityIn(List<String> values) {
            addCriterion("owner_identity in", values, "ownerIdentity");
            return (Criteria) this;
        }

        public Criteria andOwnerIdentityNotIn(List<String> values) {
            addCriterion("owner_identity not in", values, "ownerIdentity");
            return (Criteria) this;
        }

        public Criteria andOwnerIdentityBetween(String value1, String value2) {
            addCriterion("owner_identity between", value1, value2, "ownerIdentity");
            return (Criteria) this;
        }

        public Criteria andOwnerIdentityNotBetween(String value1, String value2) {
            addCriterion("owner_identity not between", value1, value2, "ownerIdentity");
            return (Criteria) this;
        }

        public Criteria andOwnerSexIsNull() {
            addCriterion("owner_sex is null");
            return (Criteria) this;
        }

        public Criteria andOwnerSexIsNotNull() {
            addCriterion("owner_sex is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerSexEqualTo(String value) {
            addCriterion("owner_sex =", value, "ownerSex");
            return (Criteria) this;
        }

        public Criteria andOwnerSexNotEqualTo(String value) {
            addCriterion("owner_sex <>", value, "ownerSex");
            return (Criteria) this;
        }

        public Criteria andOwnerSexGreaterThan(String value) {
            addCriterion("owner_sex >", value, "ownerSex");
            return (Criteria) this;
        }

        public Criteria andOwnerSexGreaterThanOrEqualTo(String value) {
            addCriterion("owner_sex >=", value, "ownerSex");
            return (Criteria) this;
        }

        public Criteria andOwnerSexLessThan(String value) {
            addCriterion("owner_sex <", value, "ownerSex");
            return (Criteria) this;
        }

        public Criteria andOwnerSexLessThanOrEqualTo(String value) {
            addCriterion("owner_sex <=", value, "ownerSex");
            return (Criteria) this;
        }

        public Criteria andOwnerSexLike(String value) {
            addCriterion("owner_sex like", value, "ownerSex");
            return (Criteria) this;
        }

        public Criteria andOwnerSexNotLike(String value) {
            addCriterion("owner_sex not like", value, "ownerSex");
            return (Criteria) this;
        }

        public Criteria andOwnerSexIn(List<String> values) {
            addCriterion("owner_sex in", values, "ownerSex");
            return (Criteria) this;
        }

        public Criteria andOwnerSexNotIn(List<String> values) {
            addCriterion("owner_sex not in", values, "ownerSex");
            return (Criteria) this;
        }

        public Criteria andOwnerSexBetween(String value1, String value2) {
            addCriterion("owner_sex between", value1, value2, "ownerSex");
            return (Criteria) this;
        }

        public Criteria andOwnerSexNotBetween(String value1, String value2) {
            addCriterion("owner_sex not between", value1, value2, "ownerSex");
            return (Criteria) this;
        }

        public Criteria andOwnerAgeIsNull() {
            addCriterion("owner_age is null");
            return (Criteria) this;
        }

        public Criteria andOwnerAgeIsNotNull() {
            addCriterion("owner_age is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerAgeEqualTo(Integer value) {
            addCriterion("owner_age =", value, "ownerAge");
            return (Criteria) this;
        }

        public Criteria andOwnerAgeNotEqualTo(Integer value) {
            addCriterion("owner_age <>", value, "ownerAge");
            return (Criteria) this;
        }

        public Criteria andOwnerAgeGreaterThan(Integer value) {
            addCriterion("owner_age >", value, "ownerAge");
            return (Criteria) this;
        }

        public Criteria andOwnerAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("owner_age >=", value, "ownerAge");
            return (Criteria) this;
        }

        public Criteria andOwnerAgeLessThan(Integer value) {
            addCriterion("owner_age <", value, "ownerAge");
            return (Criteria) this;
        }

        public Criteria andOwnerAgeLessThanOrEqualTo(Integer value) {
            addCriterion("owner_age <=", value, "ownerAge");
            return (Criteria) this;
        }

        public Criteria andOwnerAgeIn(List<Integer> values) {
            addCriterion("owner_age in", values, "ownerAge");
            return (Criteria) this;
        }

        public Criteria andOwnerAgeNotIn(List<Integer> values) {
            addCriterion("owner_age not in", values, "ownerAge");
            return (Criteria) this;
        }

        public Criteria andOwnerAgeBetween(Integer value1, Integer value2) {
            addCriterion("owner_age between", value1, value2, "ownerAge");
            return (Criteria) this;
        }

        public Criteria andOwnerAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("owner_age not between", value1, value2, "ownerAge");
            return (Criteria) this;
        }

        public Criteria andOwnerJobIsNull() {
            addCriterion("owner_job is null");
            return (Criteria) this;
        }

        public Criteria andOwnerJobIsNotNull() {
            addCriterion("owner_job is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerJobEqualTo(String value) {
            addCriterion("owner_job =", value, "ownerJob");
            return (Criteria) this;
        }

        public Criteria andOwnerJobNotEqualTo(String value) {
            addCriterion("owner_job <>", value, "ownerJob");
            return (Criteria) this;
        }

        public Criteria andOwnerJobGreaterThan(String value) {
            addCriterion("owner_job >", value, "ownerJob");
            return (Criteria) this;
        }

        public Criteria andOwnerJobGreaterThanOrEqualTo(String value) {
            addCriterion("owner_job >=", value, "ownerJob");
            return (Criteria) this;
        }

        public Criteria andOwnerJobLessThan(String value) {
            addCriterion("owner_job <", value, "ownerJob");
            return (Criteria) this;
        }

        public Criteria andOwnerJobLessThanOrEqualTo(String value) {
            addCriterion("owner_job <=", value, "ownerJob");
            return (Criteria) this;
        }

        public Criteria andOwnerJobLike(String value) {
            addCriterion("owner_job like", value, "ownerJob");
            return (Criteria) this;
        }

        public Criteria andOwnerJobNotLike(String value) {
            addCriterion("owner_job not like", value, "ownerJob");
            return (Criteria) this;
        }

        public Criteria andOwnerJobIn(List<String> values) {
            addCriterion("owner_job in", values, "ownerJob");
            return (Criteria) this;
        }

        public Criteria andOwnerJobNotIn(List<String> values) {
            addCriterion("owner_job not in", values, "ownerJob");
            return (Criteria) this;
        }

        public Criteria andOwnerJobBetween(String value1, String value2) {
            addCriterion("owner_job between", value1, value2, "ownerJob");
            return (Criteria) this;
        }

        public Criteria andOwnerJobNotBetween(String value1, String value2) {
            addCriterion("owner_job not between", value1, value2, "ownerJob");
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