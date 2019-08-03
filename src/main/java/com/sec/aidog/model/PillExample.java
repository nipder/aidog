package com.sec.aidog.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PillExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PillExample() {
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

        public Criteria andPillNameIsNull() {
            addCriterion("pill_name is null");
            return (Criteria) this;
        }

        public Criteria andPillNameIsNotNull() {
            addCriterion("pill_name is not null");
            return (Criteria) this;
        }

        public Criteria andPillNameEqualTo(String value) {
            addCriterion("pill_name =", value, "pillName");
            return (Criteria) this;
        }

        public Criteria andPillNameNotEqualTo(String value) {
            addCriterion("pill_name <>", value, "pillName");
            return (Criteria) this;
        }

        public Criteria andPillNameGreaterThan(String value) {
            addCriterion("pill_name >", value, "pillName");
            return (Criteria) this;
        }

        public Criteria andPillNameGreaterThanOrEqualTo(String value) {
            addCriterion("pill_name >=", value, "pillName");
            return (Criteria) this;
        }

        public Criteria andPillNameLessThan(String value) {
            addCriterion("pill_name <", value, "pillName");
            return (Criteria) this;
        }

        public Criteria andPillNameLessThanOrEqualTo(String value) {
            addCriterion("pill_name <=", value, "pillName");
            return (Criteria) this;
        }

        public Criteria andPillNameLike(String value) {
            addCriterion("pill_name like", value, "pillName");
            return (Criteria) this;
        }

        public Criteria andPillNameNotLike(String value) {
            addCriterion("pill_name not like", value, "pillName");
            return (Criteria) this;
        }

        public Criteria andPillNameIn(List<String> values) {
            addCriterion("pill_name in", values, "pillName");
            return (Criteria) this;
        }

        public Criteria andPillNameNotIn(List<String> values) {
            addCriterion("pill_name not in", values, "pillName");
            return (Criteria) this;
        }

        public Criteria andPillNameBetween(String value1, String value2) {
            addCriterion("pill_name between", value1, value2, "pillName");
            return (Criteria) this;
        }

        public Criteria andPillNameNotBetween(String value1, String value2) {
            addCriterion("pill_name not between", value1, value2, "pillName");
            return (Criteria) this;
        }

        public Criteria andPillFactoryIsNull() {
            addCriterion("pill_factory is null");
            return (Criteria) this;
        }

        public Criteria andPillFactoryIsNotNull() {
            addCriterion("pill_factory is not null");
            return (Criteria) this;
        }

        public Criteria andPillFactoryEqualTo(String value) {
            addCriterion("pill_factory =", value, "pillFactory");
            return (Criteria) this;
        }

        public Criteria andPillFactoryNotEqualTo(String value) {
            addCriterion("pill_factory <>", value, "pillFactory");
            return (Criteria) this;
        }

        public Criteria andPillFactoryGreaterThan(String value) {
            addCriterion("pill_factory >", value, "pillFactory");
            return (Criteria) this;
        }

        public Criteria andPillFactoryGreaterThanOrEqualTo(String value) {
            addCriterion("pill_factory >=", value, "pillFactory");
            return (Criteria) this;
        }

        public Criteria andPillFactoryLessThan(String value) {
            addCriterion("pill_factory <", value, "pillFactory");
            return (Criteria) this;
        }

        public Criteria andPillFactoryLessThanOrEqualTo(String value) {
            addCriterion("pill_factory <=", value, "pillFactory");
            return (Criteria) this;
        }

        public Criteria andPillFactoryLike(String value) {
            addCriterion("pill_factory like", value, "pillFactory");
            return (Criteria) this;
        }

        public Criteria andPillFactoryNotLike(String value) {
            addCriterion("pill_factory not like", value, "pillFactory");
            return (Criteria) this;
        }

        public Criteria andPillFactoryIn(List<String> values) {
            addCriterion("pill_factory in", values, "pillFactory");
            return (Criteria) this;
        }

        public Criteria andPillFactoryNotIn(List<String> values) {
            addCriterion("pill_factory not in", values, "pillFactory");
            return (Criteria) this;
        }

        public Criteria andPillFactoryBetween(String value1, String value2) {
            addCriterion("pill_factory between", value1, value2, "pillFactory");
            return (Criteria) this;
        }

        public Criteria andPillFactoryNotBetween(String value1, String value2) {
            addCriterion("pill_factory not between", value1, value2, "pillFactory");
            return (Criteria) this;
        }

        public Criteria andPillSpecIsNull() {
            addCriterion("pill_spec is null");
            return (Criteria) this;
        }

        public Criteria andPillSpecIsNotNull() {
            addCriterion("pill_spec is not null");
            return (Criteria) this;
        }

        public Criteria andPillSpecEqualTo(String value) {
            addCriterion("pill_spec =", value, "pillSpec");
            return (Criteria) this;
        }

        public Criteria andPillSpecNotEqualTo(String value) {
            addCriterion("pill_spec <>", value, "pillSpec");
            return (Criteria) this;
        }

        public Criteria andPillSpecGreaterThan(String value) {
            addCriterion("pill_spec >", value, "pillSpec");
            return (Criteria) this;
        }

        public Criteria andPillSpecGreaterThanOrEqualTo(String value) {
            addCriterion("pill_spec >=", value, "pillSpec");
            return (Criteria) this;
        }

        public Criteria andPillSpecLessThan(String value) {
            addCriterion("pill_spec <", value, "pillSpec");
            return (Criteria) this;
        }

        public Criteria andPillSpecLessThanOrEqualTo(String value) {
            addCriterion("pill_spec <=", value, "pillSpec");
            return (Criteria) this;
        }

        public Criteria andPillSpecLike(String value) {
            addCriterion("pill_spec like", value, "pillSpec");
            return (Criteria) this;
        }

        public Criteria andPillSpecNotLike(String value) {
            addCriterion("pill_spec not like", value, "pillSpec");
            return (Criteria) this;
        }

        public Criteria andPillSpecIn(List<String> values) {
            addCriterion("pill_spec in", values, "pillSpec");
            return (Criteria) this;
        }

        public Criteria andPillSpecNotIn(List<String> values) {
            addCriterion("pill_spec not in", values, "pillSpec");
            return (Criteria) this;
        }

        public Criteria andPillSpecBetween(String value1, String value2) {
            addCriterion("pill_spec between", value1, value2, "pillSpec");
            return (Criteria) this;
        }

        public Criteria andPillSpecNotBetween(String value1, String value2) {
            addCriterion("pill_spec not between", value1, value2, "pillSpec");
            return (Criteria) this;
        }

        public Criteria andPillBatchnumIsNull() {
            addCriterion("pill_batchnum is null");
            return (Criteria) this;
        }

        public Criteria andPillBatchnumIsNotNull() {
            addCriterion("pill_batchnum is not null");
            return (Criteria) this;
        }

        public Criteria andPillBatchnumEqualTo(String value) {
            addCriterion("pill_batchnum =", value, "pillBatchnum");
            return (Criteria) this;
        }

        public Criteria andPillBatchnumNotEqualTo(String value) {
            addCriterion("pill_batchnum <>", value, "pillBatchnum");
            return (Criteria) this;
        }

        public Criteria andPillBatchnumGreaterThan(String value) {
            addCriterion("pill_batchnum >", value, "pillBatchnum");
            return (Criteria) this;
        }

        public Criteria andPillBatchnumGreaterThanOrEqualTo(String value) {
            addCriterion("pill_batchnum >=", value, "pillBatchnum");
            return (Criteria) this;
        }

        public Criteria andPillBatchnumLessThan(String value) {
            addCriterion("pill_batchnum <", value, "pillBatchnum");
            return (Criteria) this;
        }

        public Criteria andPillBatchnumLessThanOrEqualTo(String value) {
            addCriterion("pill_batchnum <=", value, "pillBatchnum");
            return (Criteria) this;
        }

        public Criteria andPillBatchnumLike(String value) {
            addCriterion("pill_batchnum like", value, "pillBatchnum");
            return (Criteria) this;
        }

        public Criteria andPillBatchnumNotLike(String value) {
            addCriterion("pill_batchnum not like", value, "pillBatchnum");
            return (Criteria) this;
        }

        public Criteria andPillBatchnumIn(List<String> values) {
            addCriterion("pill_batchnum in", values, "pillBatchnum");
            return (Criteria) this;
        }

        public Criteria andPillBatchnumNotIn(List<String> values) {
            addCriterion("pill_batchnum not in", values, "pillBatchnum");
            return (Criteria) this;
        }

        public Criteria andPillBatchnumBetween(String value1, String value2) {
            addCriterion("pill_batchnum between", value1, value2, "pillBatchnum");
            return (Criteria) this;
        }

        public Criteria andPillBatchnumNotBetween(String value1, String value2) {
            addCriterion("pill_batchnum not between", value1, value2, "pillBatchnum");
            return (Criteria) this;
        }

        public Criteria andPillExpdateIsNull() {
            addCriterion("pill_expdate is null");
            return (Criteria) this;
        }

        public Criteria andPillExpdateIsNotNull() {
            addCriterion("pill_expdate is not null");
            return (Criteria) this;
        }

        public Criteria andPillExpdateEqualTo(Date value) {
            addCriterion("pill_expdate =", value, "pillExpdate");
            return (Criteria) this;
        }

        public Criteria andPillExpdateNotEqualTo(Date value) {
            addCriterion("pill_expdate <>", value, "pillExpdate");
            return (Criteria) this;
        }

        public Criteria andPillExpdateGreaterThan(Date value) {
            addCriterion("pill_expdate >", value, "pillExpdate");
            return (Criteria) this;
        }

        public Criteria andPillExpdateGreaterThanOrEqualTo(Date value) {
            addCriterion("pill_expdate >=", value, "pillExpdate");
            return (Criteria) this;
        }

        public Criteria andPillExpdateLessThan(Date value) {
            addCriterion("pill_expdate <", value, "pillExpdate");
            return (Criteria) this;
        }

        public Criteria andPillExpdateLessThanOrEqualTo(Date value) {
            addCriterion("pill_expdate <=", value, "pillExpdate");
            return (Criteria) this;
        }

        public Criteria andPillExpdateIn(List<Date> values) {
            addCriterion("pill_expdate in", values, "pillExpdate");
            return (Criteria) this;
        }

        public Criteria andPillExpdateNotIn(List<Date> values) {
            addCriterion("pill_expdate not in", values, "pillExpdate");
            return (Criteria) this;
        }

        public Criteria andPillExpdateBetween(Date value1, Date value2) {
            addCriterion("pill_expdate between", value1, value2, "pillExpdate");
            return (Criteria) this;
        }

        public Criteria andPillExpdateNotBetween(Date value1, Date value2) {
            addCriterion("pill_expdate not between", value1, value2, "pillExpdate");
            return (Criteria) this;
        }

        public Criteria andPillBuydateIsNull() {
            addCriterion("pill_buydate is null");
            return (Criteria) this;
        }

        public Criteria andPillBuydateIsNotNull() {
            addCriterion("pill_buydate is not null");
            return (Criteria) this;
        }

        public Criteria andPillBuydateEqualTo(Date value) {
            addCriterion("pill_buydate =", value, "pillBuydate");
            return (Criteria) this;
        }

        public Criteria andPillBuydateNotEqualTo(Date value) {
            addCriterion("pill_buydate <>", value, "pillBuydate");
            return (Criteria) this;
        }

        public Criteria andPillBuydateGreaterThan(Date value) {
            addCriterion("pill_buydate >", value, "pillBuydate");
            return (Criteria) this;
        }

        public Criteria andPillBuydateGreaterThanOrEqualTo(Date value) {
            addCriterion("pill_buydate >=", value, "pillBuydate");
            return (Criteria) this;
        }

        public Criteria andPillBuydateLessThan(Date value) {
            addCriterion("pill_buydate <", value, "pillBuydate");
            return (Criteria) this;
        }

        public Criteria andPillBuydateLessThanOrEqualTo(Date value) {
            addCriterion("pill_buydate <=", value, "pillBuydate");
            return (Criteria) this;
        }

        public Criteria andPillBuydateIn(List<Date> values) {
            addCriterion("pill_buydate in", values, "pillBuydate");
            return (Criteria) this;
        }

        public Criteria andPillBuydateNotIn(List<Date> values) {
            addCriterion("pill_buydate not in", values, "pillBuydate");
            return (Criteria) this;
        }

        public Criteria andPillBuydateBetween(Date value1, Date value2) {
            addCriterion("pill_buydate between", value1, value2, "pillBuydate");
            return (Criteria) this;
        }

        public Criteria andPillBuydateNotBetween(Date value1, Date value2) {
            addCriterion("pill_buydate not between", value1, value2, "pillBuydate");
            return (Criteria) this;
        }

        public Criteria andPillBuyerIsNull() {
            addCriterion("pill_buyer is null");
            return (Criteria) this;
        }

        public Criteria andPillBuyerIsNotNull() {
            addCriterion("pill_buyer is not null");
            return (Criteria) this;
        }

        public Criteria andPillBuyerEqualTo(String value) {
            addCriterion("pill_buyer =", value, "pillBuyer");
            return (Criteria) this;
        }

        public Criteria andPillBuyerNotEqualTo(String value) {
            addCriterion("pill_buyer <>", value, "pillBuyer");
            return (Criteria) this;
        }

        public Criteria andPillBuyerGreaterThan(String value) {
            addCriterion("pill_buyer >", value, "pillBuyer");
            return (Criteria) this;
        }

        public Criteria andPillBuyerGreaterThanOrEqualTo(String value) {
            addCriterion("pill_buyer >=", value, "pillBuyer");
            return (Criteria) this;
        }

        public Criteria andPillBuyerLessThan(String value) {
            addCriterion("pill_buyer <", value, "pillBuyer");
            return (Criteria) this;
        }

        public Criteria andPillBuyerLessThanOrEqualTo(String value) {
            addCriterion("pill_buyer <=", value, "pillBuyer");
            return (Criteria) this;
        }

        public Criteria andPillBuyerLike(String value) {
            addCriterion("pill_buyer like", value, "pillBuyer");
            return (Criteria) this;
        }

        public Criteria andPillBuyerNotLike(String value) {
            addCriterion("pill_buyer not like", value, "pillBuyer");
            return (Criteria) this;
        }

        public Criteria andPillBuyerIn(List<String> values) {
            addCriterion("pill_buyer in", values, "pillBuyer");
            return (Criteria) this;
        }

        public Criteria andPillBuyerNotIn(List<String> values) {
            addCriterion("pill_buyer not in", values, "pillBuyer");
            return (Criteria) this;
        }

        public Criteria andPillBuyerBetween(String value1, String value2) {
            addCriterion("pill_buyer between", value1, value2, "pillBuyer");
            return (Criteria) this;
        }

        public Criteria andPillBuyerNotBetween(String value1, String value2) {
            addCriterion("pill_buyer not between", value1, value2, "pillBuyer");
            return (Criteria) this;
        }

        public Criteria andPillBuyertelIsNull() {
            addCriterion("pill_buyertel is null");
            return (Criteria) this;
        }

        public Criteria andPillBuyertelIsNotNull() {
            addCriterion("pill_buyertel is not null");
            return (Criteria) this;
        }

        public Criteria andPillBuyertelEqualTo(String value) {
            addCriterion("pill_buyertel =", value, "pillBuyertel");
            return (Criteria) this;
        }

        public Criteria andPillBuyertelNotEqualTo(String value) {
            addCriterion("pill_buyertel <>", value, "pillBuyertel");
            return (Criteria) this;
        }

        public Criteria andPillBuyertelGreaterThan(String value) {
            addCriterion("pill_buyertel >", value, "pillBuyertel");
            return (Criteria) this;
        }

        public Criteria andPillBuyertelGreaterThanOrEqualTo(String value) {
            addCriterion("pill_buyertel >=", value, "pillBuyertel");
            return (Criteria) this;
        }

        public Criteria andPillBuyertelLessThan(String value) {
            addCriterion("pill_buyertel <", value, "pillBuyertel");
            return (Criteria) this;
        }

        public Criteria andPillBuyertelLessThanOrEqualTo(String value) {
            addCriterion("pill_buyertel <=", value, "pillBuyertel");
            return (Criteria) this;
        }

        public Criteria andPillBuyertelLike(String value) {
            addCriterion("pill_buyertel like", value, "pillBuyertel");
            return (Criteria) this;
        }

        public Criteria andPillBuyertelNotLike(String value) {
            addCriterion("pill_buyertel not like", value, "pillBuyertel");
            return (Criteria) this;
        }

        public Criteria andPillBuyertelIn(List<String> values) {
            addCriterion("pill_buyertel in", values, "pillBuyertel");
            return (Criteria) this;
        }

        public Criteria andPillBuyertelNotIn(List<String> values) {
            addCriterion("pill_buyertel not in", values, "pillBuyertel");
            return (Criteria) this;
        }

        public Criteria andPillBuyertelBetween(String value1, String value2) {
            addCriterion("pill_buyertel between", value1, value2, "pillBuyertel");
            return (Criteria) this;
        }

        public Criteria andPillBuyertelNotBetween(String value1, String value2) {
            addCriterion("pill_buyertel not between", value1, value2, "pillBuyertel");
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