package com.sec.aidog.model;

import java.util.ArrayList;
import java.util.List;

public class CheckresExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CheckresExample() {
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

        public Criteria andEyeIllplaceIsNull() {
            addCriterion("eye_illplace is null");
            return (Criteria) this;
        }

        public Criteria andEyeIllplaceIsNotNull() {
            addCriterion("eye_illplace is not null");
            return (Criteria) this;
        }

        public Criteria andEyeIllplaceEqualTo(String value) {
            addCriterion("eye_illplace =", value, "eyeIllplace");
            return (Criteria) this;
        }

        public Criteria andEyeIllplaceNotEqualTo(String value) {
            addCriterion("eye_illplace <>", value, "eyeIllplace");
            return (Criteria) this;
        }

        public Criteria andEyeIllplaceGreaterThan(String value) {
            addCriterion("eye_illplace >", value, "eyeIllplace");
            return (Criteria) this;
        }

        public Criteria andEyeIllplaceGreaterThanOrEqualTo(String value) {
            addCriterion("eye_illplace >=", value, "eyeIllplace");
            return (Criteria) this;
        }

        public Criteria andEyeIllplaceLessThan(String value) {
            addCriterion("eye_illplace <", value, "eyeIllplace");
            return (Criteria) this;
        }

        public Criteria andEyeIllplaceLessThanOrEqualTo(String value) {
            addCriterion("eye_illplace <=", value, "eyeIllplace");
            return (Criteria) this;
        }

        public Criteria andEyeIllplaceLike(String value) {
            addCriterion("eye_illplace like", value, "eyeIllplace");
            return (Criteria) this;
        }

        public Criteria andEyeIllplaceNotLike(String value) {
            addCriterion("eye_illplace not like", value, "eyeIllplace");
            return (Criteria) this;
        }

        public Criteria andEyeIllplaceIn(List<String> values) {
            addCriterion("eye_illplace in", values, "eyeIllplace");
            return (Criteria) this;
        }

        public Criteria andEyeIllplaceNotIn(List<String> values) {
            addCriterion("eye_illplace not in", values, "eyeIllplace");
            return (Criteria) this;
        }

        public Criteria andEyeIllplaceBetween(String value1, String value2) {
            addCriterion("eye_illplace between", value1, value2, "eyeIllplace");
            return (Criteria) this;
        }

        public Criteria andEyeIllplaceNotBetween(String value1, String value2) {
            addCriterion("eye_illplace not between", value1, value2, "eyeIllplace");
            return (Criteria) this;
        }

        public Criteria andEyeSizeIsNull() {
            addCriterion("eye_size is null");
            return (Criteria) this;
        }

        public Criteria andEyeSizeIsNotNull() {
            addCriterion("eye_size is not null");
            return (Criteria) this;
        }

        public Criteria andEyeSizeEqualTo(String value) {
            addCriterion("eye_size =", value, "eyeSize");
            return (Criteria) this;
        }

        public Criteria andEyeSizeNotEqualTo(String value) {
            addCriterion("eye_size <>", value, "eyeSize");
            return (Criteria) this;
        }

        public Criteria andEyeSizeGreaterThan(String value) {
            addCriterion("eye_size >", value, "eyeSize");
            return (Criteria) this;
        }

        public Criteria andEyeSizeGreaterThanOrEqualTo(String value) {
            addCriterion("eye_size >=", value, "eyeSize");
            return (Criteria) this;
        }

        public Criteria andEyeSizeLessThan(String value) {
            addCriterion("eye_size <", value, "eyeSize");
            return (Criteria) this;
        }

        public Criteria andEyeSizeLessThanOrEqualTo(String value) {
            addCriterion("eye_size <=", value, "eyeSize");
            return (Criteria) this;
        }

        public Criteria andEyeSizeLike(String value) {
            addCriterion("eye_size like", value, "eyeSize");
            return (Criteria) this;
        }

        public Criteria andEyeSizeNotLike(String value) {
            addCriterion("eye_size not like", value, "eyeSize");
            return (Criteria) this;
        }

        public Criteria andEyeSizeIn(List<String> values) {
            addCriterion("eye_size in", values, "eyeSize");
            return (Criteria) this;
        }

        public Criteria andEyeSizeNotIn(List<String> values) {
            addCriterion("eye_size not in", values, "eyeSize");
            return (Criteria) this;
        }

        public Criteria andEyeSizeBetween(String value1, String value2) {
            addCriterion("eye_size between", value1, value2, "eyeSize");
            return (Criteria) this;
        }

        public Criteria andEyeSizeNotBetween(String value1, String value2) {
            addCriterion("eye_size not between", value1, value2, "eyeSize");
            return (Criteria) this;
        }

        public Criteria andPcrNumIsNull() {
            addCriterion("pcr_num is null");
            return (Criteria) this;
        }

        public Criteria andPcrNumIsNotNull() {
            addCriterion("pcr_num is not null");
            return (Criteria) this;
        }

        public Criteria andPcrNumEqualTo(Integer value) {
            addCriterion("pcr_num =", value, "pcrNum");
            return (Criteria) this;
        }

        public Criteria andPcrNumNotEqualTo(Integer value) {
            addCriterion("pcr_num <>", value, "pcrNum");
            return (Criteria) this;
        }

        public Criteria andPcrNumGreaterThan(Integer value) {
            addCriterion("pcr_num >", value, "pcrNum");
            return (Criteria) this;
        }

        public Criteria andPcrNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("pcr_num >=", value, "pcrNum");
            return (Criteria) this;
        }

        public Criteria andPcrNumLessThan(Integer value) {
            addCriterion("pcr_num <", value, "pcrNum");
            return (Criteria) this;
        }

        public Criteria andPcrNumLessThanOrEqualTo(Integer value) {
            addCriterion("pcr_num <=", value, "pcrNum");
            return (Criteria) this;
        }

        public Criteria andPcrNumIn(List<Integer> values) {
            addCriterion("pcr_num in", values, "pcrNum");
            return (Criteria) this;
        }

        public Criteria andPcrNumNotIn(List<Integer> values) {
            addCriterion("pcr_num not in", values, "pcrNum");
            return (Criteria) this;
        }

        public Criteria andPcrNumBetween(Integer value1, Integer value2) {
            addCriterion("pcr_num between", value1, value2, "pcrNum");
            return (Criteria) this;
        }

        public Criteria andPcrNumNotBetween(Integer value1, Integer value2) {
            addCriterion("pcr_num not between", value1, value2, "pcrNum");
            return (Criteria) this;
        }

        public Criteria andPcrSqjqdcIsNull() {
            addCriterion("pcr_sqjqdc is null");
            return (Criteria) this;
        }

        public Criteria andPcrSqjqdcIsNotNull() {
            addCriterion("pcr_sqjqdc is not null");
            return (Criteria) this;
        }

        public Criteria andPcrSqjqdcEqualTo(String value) {
            addCriterion("pcr_sqjqdc =", value, "pcrSqjqdc");
            return (Criteria) this;
        }

        public Criteria andPcrSqjqdcNotEqualTo(String value) {
            addCriterion("pcr_sqjqdc <>", value, "pcrSqjqdc");
            return (Criteria) this;
        }

        public Criteria andPcrSqjqdcGreaterThan(String value) {
            addCriterion("pcr_sqjqdc >", value, "pcrSqjqdc");
            return (Criteria) this;
        }

        public Criteria andPcrSqjqdcGreaterThanOrEqualTo(String value) {
            addCriterion("pcr_sqjqdc >=", value, "pcrSqjqdc");
            return (Criteria) this;
        }

        public Criteria andPcrSqjqdcLessThan(String value) {
            addCriterion("pcr_sqjqdc <", value, "pcrSqjqdc");
            return (Criteria) this;
        }

        public Criteria andPcrSqjqdcLessThanOrEqualTo(String value) {
            addCriterion("pcr_sqjqdc <=", value, "pcrSqjqdc");
            return (Criteria) this;
        }

        public Criteria andPcrSqjqdcLike(String value) {
            addCriterion("pcr_sqjqdc like", value, "pcrSqjqdc");
            return (Criteria) this;
        }

        public Criteria andPcrSqjqdcNotLike(String value) {
            addCriterion("pcr_sqjqdc not like", value, "pcrSqjqdc");
            return (Criteria) this;
        }

        public Criteria andPcrSqjqdcIn(List<String> values) {
            addCriterion("pcr_sqjqdc in", values, "pcrSqjqdc");
            return (Criteria) this;
        }

        public Criteria andPcrSqjqdcNotIn(List<String> values) {
            addCriterion("pcr_sqjqdc not in", values, "pcrSqjqdc");
            return (Criteria) this;
        }

        public Criteria andPcrSqjqdcBetween(String value1, String value2) {
            addCriterion("pcr_sqjqdc between", value1, value2, "pcrSqjqdc");
            return (Criteria) this;
        }

        public Criteria andPcrSqjqdcNotBetween(String value1, String value2) {
            addCriterion("pcr_sqjqdc not between", value1, value2, "pcrSqjqdc");
            return (Criteria) this;
        }

        public Criteria andPcrDfjqdcIsNull() {
            addCriterion("pcr_dfjqdc is null");
            return (Criteria) this;
        }

        public Criteria andPcrDfjqdcIsNotNull() {
            addCriterion("pcr_dfjqdc is not null");
            return (Criteria) this;
        }

        public Criteria andPcrDfjqdcEqualTo(String value) {
            addCriterion("pcr_dfjqdc =", value, "pcrDfjqdc");
            return (Criteria) this;
        }

        public Criteria andPcrDfjqdcNotEqualTo(String value) {
            addCriterion("pcr_dfjqdc <>", value, "pcrDfjqdc");
            return (Criteria) this;
        }

        public Criteria andPcrDfjqdcGreaterThan(String value) {
            addCriterion("pcr_dfjqdc >", value, "pcrDfjqdc");
            return (Criteria) this;
        }

        public Criteria andPcrDfjqdcGreaterThanOrEqualTo(String value) {
            addCriterion("pcr_dfjqdc >=", value, "pcrDfjqdc");
            return (Criteria) this;
        }

        public Criteria andPcrDfjqdcLessThan(String value) {
            addCriterion("pcr_dfjqdc <", value, "pcrDfjqdc");
            return (Criteria) this;
        }

        public Criteria andPcrDfjqdcLessThanOrEqualTo(String value) {
            addCriterion("pcr_dfjqdc <=", value, "pcrDfjqdc");
            return (Criteria) this;
        }

        public Criteria andPcrDfjqdcLike(String value) {
            addCriterion("pcr_dfjqdc like", value, "pcrDfjqdc");
            return (Criteria) this;
        }

        public Criteria andPcrDfjqdcNotLike(String value) {
            addCriterion("pcr_dfjqdc not like", value, "pcrDfjqdc");
            return (Criteria) this;
        }

        public Criteria andPcrDfjqdcIn(List<String> values) {
            addCriterion("pcr_dfjqdc in", values, "pcrDfjqdc");
            return (Criteria) this;
        }

        public Criteria andPcrDfjqdcNotIn(List<String> values) {
            addCriterion("pcr_dfjqdc not in", values, "pcrDfjqdc");
            return (Criteria) this;
        }

        public Criteria andPcrDfjqdcBetween(String value1, String value2) {
            addCriterion("pcr_dfjqdc between", value1, value2, "pcrDfjqdc");
            return (Criteria) this;
        }

        public Criteria andPcrDfjqdcNotBetween(String value1, String value2) {
            addCriterion("pcr_dfjqdc not between", value1, value2, "pcrDfjqdc");
            return (Criteria) this;
        }

        public Criteria andPcrXljqdcIsNull() {
            addCriterion("pcr_xljqdc is null");
            return (Criteria) this;
        }

        public Criteria andPcrXljqdcIsNotNull() {
            addCriterion("pcr_xljqdc is not null");
            return (Criteria) this;
        }

        public Criteria andPcrXljqdcEqualTo(String value) {
            addCriterion("pcr_xljqdc =", value, "pcrXljqdc");
            return (Criteria) this;
        }

        public Criteria andPcrXljqdcNotEqualTo(String value) {
            addCriterion("pcr_xljqdc <>", value, "pcrXljqdc");
            return (Criteria) this;
        }

        public Criteria andPcrXljqdcGreaterThan(String value) {
            addCriterion("pcr_xljqdc >", value, "pcrXljqdc");
            return (Criteria) this;
        }

        public Criteria andPcrXljqdcGreaterThanOrEqualTo(String value) {
            addCriterion("pcr_xljqdc >=", value, "pcrXljqdc");
            return (Criteria) this;
        }

        public Criteria andPcrXljqdcLessThan(String value) {
            addCriterion("pcr_xljqdc <", value, "pcrXljqdc");
            return (Criteria) this;
        }

        public Criteria andPcrXljqdcLessThanOrEqualTo(String value) {
            addCriterion("pcr_xljqdc <=", value, "pcrXljqdc");
            return (Criteria) this;
        }

        public Criteria andPcrXljqdcLike(String value) {
            addCriterion("pcr_xljqdc like", value, "pcrXljqdc");
            return (Criteria) this;
        }

        public Criteria andPcrXljqdcNotLike(String value) {
            addCriterion("pcr_xljqdc not like", value, "pcrXljqdc");
            return (Criteria) this;
        }

        public Criteria andPcrXljqdcIn(List<String> values) {
            addCriterion("pcr_xljqdc in", values, "pcrXljqdc");
            return (Criteria) this;
        }

        public Criteria andPcrXljqdcNotIn(List<String> values) {
            addCriterion("pcr_xljqdc not in", values, "pcrXljqdc");
            return (Criteria) this;
        }

        public Criteria andPcrXljqdcBetween(String value1, String value2) {
            addCriterion("pcr_xljqdc between", value1, value2, "pcrXljqdc");
            return (Criteria) this;
        }

        public Criteria andPcrXljqdcNotBetween(String value1, String value2) {
            addCriterion("pcr_xljqdc not between", value1, value2, "pcrXljqdc");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
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