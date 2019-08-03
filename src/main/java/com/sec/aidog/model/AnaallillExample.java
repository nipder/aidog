package com.sec.aidog.model;

import java.util.ArrayList;
import java.util.List;

public class AnaallillExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AnaallillExample() {
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

        public Criteria andDistrictLevelIsNull() {
            addCriterion("district_level is null");
            return (Criteria) this;
        }

        public Criteria andDistrictLevelIsNotNull() {
            addCriterion("district_level is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictLevelEqualTo(Integer value) {
            addCriterion("district_level =", value, "districtLevel");
            return (Criteria) this;
        }

        public Criteria andDistrictLevelNotEqualTo(Integer value) {
            addCriterion("district_level <>", value, "districtLevel");
            return (Criteria) this;
        }

        public Criteria andDistrictLevelGreaterThan(Integer value) {
            addCriterion("district_level >", value, "districtLevel");
            return (Criteria) this;
        }

        public Criteria andDistrictLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("district_level >=", value, "districtLevel");
            return (Criteria) this;
        }

        public Criteria andDistrictLevelLessThan(Integer value) {
            addCriterion("district_level <", value, "districtLevel");
            return (Criteria) this;
        }

        public Criteria andDistrictLevelLessThanOrEqualTo(Integer value) {
            addCriterion("district_level <=", value, "districtLevel");
            return (Criteria) this;
        }

        public Criteria andDistrictLevelIn(List<Integer> values) {
            addCriterion("district_level in", values, "districtLevel");
            return (Criteria) this;
        }

        public Criteria andDistrictLevelNotIn(List<Integer> values) {
            addCriterion("district_level not in", values, "districtLevel");
            return (Criteria) this;
        }

        public Criteria andDistrictLevelBetween(Integer value1, Integer value2) {
            addCriterion("district_level between", value1, value2, "districtLevel");
            return (Criteria) this;
        }

        public Criteria andDistrictLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("district_level not between", value1, value2, "districtLevel");
            return (Criteria) this;
        }

        public Criteria andDistrictNameIsNull() {
            addCriterion("district_name is null");
            return (Criteria) this;
        }

        public Criteria andDistrictNameIsNotNull() {
            addCriterion("district_name is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictNameEqualTo(String value) {
            addCriterion("district_name =", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameNotEqualTo(String value) {
            addCriterion("district_name <>", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameGreaterThan(String value) {
            addCriterion("district_name >", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameGreaterThanOrEqualTo(String value) {
            addCriterion("district_name >=", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameLessThan(String value) {
            addCriterion("district_name <", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameLessThanOrEqualTo(String value) {
            addCriterion("district_name <=", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameLike(String value) {
            addCriterion("district_name like", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameNotLike(String value) {
            addCriterion("district_name not like", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameIn(List<String> values) {
            addCriterion("district_name in", values, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameNotIn(List<String> values) {
            addCriterion("district_name not in", values, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameBetween(String value1, String value2) {
            addCriterion("district_name between", value1, value2, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameNotBetween(String value1, String value2) {
            addCriterion("district_name not between", value1, value2, "districtName");
            return (Criteria) this;
        }

        public Criteria andEpidemicIsNull() {
            addCriterion("epidemic is null");
            return (Criteria) this;
        }

        public Criteria andEpidemicIsNotNull() {
            addCriterion("epidemic is not null");
            return (Criteria) this;
        }

        public Criteria andEpidemicEqualTo(Integer value) {
            addCriterion("epidemic =", value, "epidemic");
            return (Criteria) this;
        }

        public Criteria andEpidemicNotEqualTo(Integer value) {
            addCriterion("epidemic <>", value, "epidemic");
            return (Criteria) this;
        }

        public Criteria andEpidemicGreaterThan(Integer value) {
            addCriterion("epidemic >", value, "epidemic");
            return (Criteria) this;
        }

        public Criteria andEpidemicGreaterThanOrEqualTo(Integer value) {
            addCriterion("epidemic >=", value, "epidemic");
            return (Criteria) this;
        }

        public Criteria andEpidemicLessThan(Integer value) {
            addCriterion("epidemic <", value, "epidemic");
            return (Criteria) this;
        }

        public Criteria andEpidemicLessThanOrEqualTo(Integer value) {
            addCriterion("epidemic <=", value, "epidemic");
            return (Criteria) this;
        }

        public Criteria andEpidemicIn(List<Integer> values) {
            addCriterion("epidemic in", values, "epidemic");
            return (Criteria) this;
        }

        public Criteria andEpidemicNotIn(List<Integer> values) {
            addCriterion("epidemic not in", values, "epidemic");
            return (Criteria) this;
        }

        public Criteria andEpidemicBetween(Integer value1, Integer value2) {
            addCriterion("epidemic between", value1, value2, "epidemic");
            return (Criteria) this;
        }

        public Criteria andEpidemicNotBetween(Integer value1, Integer value2) {
            addCriterion("epidemic not between", value1, value2, "epidemic");
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

        public Criteria andEchartnameIsNull() {
            addCriterion("echartname is null");
            return (Criteria) this;
        }

        public Criteria andEchartnameIsNotNull() {
            addCriterion("echartname is not null");
            return (Criteria) this;
        }

        public Criteria andEchartnameEqualTo(String value) {
            addCriterion("echartname =", value, "echartname");
            return (Criteria) this;
        }

        public Criteria andEchartnameNotEqualTo(String value) {
            addCriterion("echartname <>", value, "echartname");
            return (Criteria) this;
        }

        public Criteria andEchartnameGreaterThan(String value) {
            addCriterion("echartname >", value, "echartname");
            return (Criteria) this;
        }

        public Criteria andEchartnameGreaterThanOrEqualTo(String value) {
            addCriterion("echartname >=", value, "echartname");
            return (Criteria) this;
        }

        public Criteria andEchartnameLessThan(String value) {
            addCriterion("echartname <", value, "echartname");
            return (Criteria) this;
        }

        public Criteria andEchartnameLessThanOrEqualTo(String value) {
            addCriterion("echartname <=", value, "echartname");
            return (Criteria) this;
        }

        public Criteria andEchartnameLike(String value) {
            addCriterion("echartname like", value, "echartname");
            return (Criteria) this;
        }

        public Criteria andEchartnameNotLike(String value) {
            addCriterion("echartname not like", value, "echartname");
            return (Criteria) this;
        }

        public Criteria andEchartnameIn(List<String> values) {
            addCriterion("echartname in", values, "echartname");
            return (Criteria) this;
        }

        public Criteria andEchartnameNotIn(List<String> values) {
            addCriterion("echartname not in", values, "echartname");
            return (Criteria) this;
        }

        public Criteria andEchartnameBetween(String value1, String value2) {
            addCriterion("echartname between", value1, value2, "echartname");
            return (Criteria) this;
        }

        public Criteria andEchartnameNotBetween(String value1, String value2) {
            addCriterion("echartname not between", value1, value2, "echartname");
            return (Criteria) this;
        }

        public Criteria andBcheckpnumIsNull() {
            addCriterion("bcheckpnum is null");
            return (Criteria) this;
        }

        public Criteria andBcheckpnumIsNotNull() {
            addCriterion("bcheckpnum is not null");
            return (Criteria) this;
        }

        public Criteria andBcheckpnumEqualTo(Integer value) {
            addCriterion("bcheckpnum =", value, "bcheckpnum");
            return (Criteria) this;
        }

        public Criteria andBcheckpnumNotEqualTo(Integer value) {
            addCriterion("bcheckpnum <>", value, "bcheckpnum");
            return (Criteria) this;
        }

        public Criteria andBcheckpnumGreaterThan(Integer value) {
            addCriterion("bcheckpnum >", value, "bcheckpnum");
            return (Criteria) this;
        }

        public Criteria andBcheckpnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("bcheckpnum >=", value, "bcheckpnum");
            return (Criteria) this;
        }

        public Criteria andBcheckpnumLessThan(Integer value) {
            addCriterion("bcheckpnum <", value, "bcheckpnum");
            return (Criteria) this;
        }

        public Criteria andBcheckpnumLessThanOrEqualTo(Integer value) {
            addCriterion("bcheckpnum <=", value, "bcheckpnum");
            return (Criteria) this;
        }

        public Criteria andBcheckpnumIn(List<Integer> values) {
            addCriterion("bcheckpnum in", values, "bcheckpnum");
            return (Criteria) this;
        }

        public Criteria andBcheckpnumNotIn(List<Integer> values) {
            addCriterion("bcheckpnum not in", values, "bcheckpnum");
            return (Criteria) this;
        }

        public Criteria andBcheckpnumBetween(Integer value1, Integer value2) {
            addCriterion("bcheckpnum between", value1, value2, "bcheckpnum");
            return (Criteria) this;
        }

        public Criteria andBcheckpnumNotBetween(Integer value1, Integer value2) {
            addCriterion("bcheckpnum not between", value1, value2, "bcheckpnum");
            return (Criteria) this;
        }

        public Criteria andPillnumIsNull() {
            addCriterion("pillnum is null");
            return (Criteria) this;
        }

        public Criteria andPillnumIsNotNull() {
            addCriterion("pillnum is not null");
            return (Criteria) this;
        }

        public Criteria andPillnumEqualTo(Integer value) {
            addCriterion("pillnum =", value, "pillnum");
            return (Criteria) this;
        }

        public Criteria andPillnumNotEqualTo(Integer value) {
            addCriterion("pillnum <>", value, "pillnum");
            return (Criteria) this;
        }

        public Criteria andPillnumGreaterThan(Integer value) {
            addCriterion("pillnum >", value, "pillnum");
            return (Criteria) this;
        }

        public Criteria andPillnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("pillnum >=", value, "pillnum");
            return (Criteria) this;
        }

        public Criteria andPillnumLessThan(Integer value) {
            addCriterion("pillnum <", value, "pillnum");
            return (Criteria) this;
        }

        public Criteria andPillnumLessThanOrEqualTo(Integer value) {
            addCriterion("pillnum <=", value, "pillnum");
            return (Criteria) this;
        }

        public Criteria andPillnumIn(List<Integer> values) {
            addCriterion("pillnum in", values, "pillnum");
            return (Criteria) this;
        }

        public Criteria andPillnumNotIn(List<Integer> values) {
            addCriterion("pillnum not in", values, "pillnum");
            return (Criteria) this;
        }

        public Criteria andPillnumBetween(Integer value1, Integer value2) {
            addCriterion("pillnum between", value1, value2, "pillnum");
            return (Criteria) this;
        }

        public Criteria andPillnumNotBetween(Integer value1, Integer value2) {
            addCriterion("pillnum not between", value1, value2, "pillnum");
            return (Criteria) this;
        }

        public Criteria andPcheckoutlvIsNull() {
            addCriterion("pcheckoutlv is null");
            return (Criteria) this;
        }

        public Criteria andPcheckoutlvIsNotNull() {
            addCriterion("pcheckoutlv is not null");
            return (Criteria) this;
        }

        public Criteria andPcheckoutlvEqualTo(String value) {
            addCriterion("pcheckoutlv =", value, "pcheckoutlv");
            return (Criteria) this;
        }

        public Criteria andPcheckoutlvNotEqualTo(String value) {
            addCriterion("pcheckoutlv <>", value, "pcheckoutlv");
            return (Criteria) this;
        }

        public Criteria andPcheckoutlvGreaterThan(String value) {
            addCriterion("pcheckoutlv >", value, "pcheckoutlv");
            return (Criteria) this;
        }

        public Criteria andPcheckoutlvGreaterThanOrEqualTo(String value) {
            addCriterion("pcheckoutlv >=", value, "pcheckoutlv");
            return (Criteria) this;
        }

        public Criteria andPcheckoutlvLessThan(String value) {
            addCriterion("pcheckoutlv <", value, "pcheckoutlv");
            return (Criteria) this;
        }

        public Criteria andPcheckoutlvLessThanOrEqualTo(String value) {
            addCriterion("pcheckoutlv <=", value, "pcheckoutlv");
            return (Criteria) this;
        }

        public Criteria andPcheckoutlvLike(String value) {
            addCriterion("pcheckoutlv like", value, "pcheckoutlv");
            return (Criteria) this;
        }

        public Criteria andPcheckoutlvNotLike(String value) {
            addCriterion("pcheckoutlv not like", value, "pcheckoutlv");
            return (Criteria) this;
        }

        public Criteria andPcheckoutlvIn(List<String> values) {
            addCriterion("pcheckoutlv in", values, "pcheckoutlv");
            return (Criteria) this;
        }

        public Criteria andPcheckoutlvNotIn(List<String> values) {
            addCriterion("pcheckoutlv not in", values, "pcheckoutlv");
            return (Criteria) this;
        }

        public Criteria andPcheckoutlvBetween(String value1, String value2) {
            addCriterion("pcheckoutlv between", value1, value2, "pcheckoutlv");
            return (Criteria) this;
        }

        public Criteria andPcheckoutlvNotBetween(String value1, String value2) {
            addCriterion("pcheckoutlv not between", value1, value2, "pcheckoutlv");
            return (Criteria) this;
        }

        public Criteria andPilllvIsNull() {
            addCriterion("pilllv is null");
            return (Criteria) this;
        }

        public Criteria andPilllvIsNotNull() {
            addCriterion("pilllv is not null");
            return (Criteria) this;
        }

        public Criteria andPilllvEqualTo(String value) {
            addCriterion("pilllv =", value, "pilllv");
            return (Criteria) this;
        }

        public Criteria andPilllvNotEqualTo(String value) {
            addCriterion("pilllv <>", value, "pilllv");
            return (Criteria) this;
        }

        public Criteria andPilllvGreaterThan(String value) {
            addCriterion("pilllv >", value, "pilllv");
            return (Criteria) this;
        }

        public Criteria andPilllvGreaterThanOrEqualTo(String value) {
            addCriterion("pilllv >=", value, "pilllv");
            return (Criteria) this;
        }

        public Criteria andPilllvLessThan(String value) {
            addCriterion("pilllv <", value, "pilllv");
            return (Criteria) this;
        }

        public Criteria andPilllvLessThanOrEqualTo(String value) {
            addCriterion("pilllv <=", value, "pilllv");
            return (Criteria) this;
        }

        public Criteria andPilllvLike(String value) {
            addCriterion("pilllv like", value, "pilllv");
            return (Criteria) this;
        }

        public Criteria andPilllvNotLike(String value) {
            addCriterion("pilllv not like", value, "pilllv");
            return (Criteria) this;
        }

        public Criteria andPilllvIn(List<String> values) {
            addCriterion("pilllv in", values, "pilllv");
            return (Criteria) this;
        }

        public Criteria andPilllvNotIn(List<String> values) {
            addCriterion("pilllv not in", values, "pilllv");
            return (Criteria) this;
        }

        public Criteria andPilllvBetween(String value1, String value2) {
            addCriterion("pilllv between", value1, value2, "pilllv");
            return (Criteria) this;
        }

        public Criteria andPilllvNotBetween(String value1, String value2) {
            addCriterion("pilllv not between", value1, value2, "pilllv");
            return (Criteria) this;
        }

        public Criteria andPchechyearIsNull() {
            addCriterion("pchechyear is null");
            return (Criteria) this;
        }

        public Criteria andPchechyearIsNotNull() {
            addCriterion("pchechyear is not null");
            return (Criteria) this;
        }

        public Criteria andPchechyearEqualTo(String value) {
            addCriterion("pchechyear =", value, "pchechyear");
            return (Criteria) this;
        }

        public Criteria andPchechyearNotEqualTo(String value) {
            addCriterion("pchechyear <>", value, "pchechyear");
            return (Criteria) this;
        }

        public Criteria andPchechyearGreaterThan(String value) {
            addCriterion("pchechyear >", value, "pchechyear");
            return (Criteria) this;
        }

        public Criteria andPchechyearGreaterThanOrEqualTo(String value) {
            addCriterion("pchechyear >=", value, "pchechyear");
            return (Criteria) this;
        }

        public Criteria andPchechyearLessThan(String value) {
            addCriterion("pchechyear <", value, "pchechyear");
            return (Criteria) this;
        }

        public Criteria andPchechyearLessThanOrEqualTo(String value) {
            addCriterion("pchechyear <=", value, "pchechyear");
            return (Criteria) this;
        }

        public Criteria andPchechyearLike(String value) {
            addCriterion("pchechyear like", value, "pchechyear");
            return (Criteria) this;
        }

        public Criteria andPchechyearNotLike(String value) {
            addCriterion("pchechyear not like", value, "pchechyear");
            return (Criteria) this;
        }

        public Criteria andPchechyearIn(List<String> values) {
            addCriterion("pchechyear in", values, "pchechyear");
            return (Criteria) this;
        }

        public Criteria andPchechyearNotIn(List<String> values) {
            addCriterion("pchechyear not in", values, "pchechyear");
            return (Criteria) this;
        }

        public Criteria andPchechyearBetween(String value1, String value2) {
            addCriterion("pchechyear between", value1, value2, "pchechyear");
            return (Criteria) this;
        }

        public Criteria andPchechyearNotBetween(String value1, String value2) {
            addCriterion("pchechyear not between", value1, value2, "pchechyear");
            return (Criteria) this;
        }

        public Criteria andBcheckcnumIsNull() {
            addCriterion("bcheckcnum is null");
            return (Criteria) this;
        }

        public Criteria andBcheckcnumIsNotNull() {
            addCriterion("bcheckcnum is not null");
            return (Criteria) this;
        }

        public Criteria andBcheckcnumEqualTo(Integer value) {
            addCriterion("bcheckcnum =", value, "bcheckcnum");
            return (Criteria) this;
        }

        public Criteria andBcheckcnumNotEqualTo(Integer value) {
            addCriterion("bcheckcnum <>", value, "bcheckcnum");
            return (Criteria) this;
        }

        public Criteria andBcheckcnumGreaterThan(Integer value) {
            addCriterion("bcheckcnum >", value, "bcheckcnum");
            return (Criteria) this;
        }

        public Criteria andBcheckcnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("bcheckcnum >=", value, "bcheckcnum");
            return (Criteria) this;
        }

        public Criteria andBcheckcnumLessThan(Integer value) {
            addCriterion("bcheckcnum <", value, "bcheckcnum");
            return (Criteria) this;
        }

        public Criteria andBcheckcnumLessThanOrEqualTo(Integer value) {
            addCriterion("bcheckcnum <=", value, "bcheckcnum");
            return (Criteria) this;
        }

        public Criteria andBcheckcnumIn(List<Integer> values) {
            addCriterion("bcheckcnum in", values, "bcheckcnum");
            return (Criteria) this;
        }

        public Criteria andBcheckcnumNotIn(List<Integer> values) {
            addCriterion("bcheckcnum not in", values, "bcheckcnum");
            return (Criteria) this;
        }

        public Criteria andBcheckcnumBetween(Integer value1, Integer value2) {
            addCriterion("bcheckcnum between", value1, value2, "bcheckcnum");
            return (Criteria) this;
        }

        public Criteria andBcheckcnumNotBetween(Integer value1, Integer value2) {
            addCriterion("bcheckcnum not between", value1, value2, "bcheckcnum");
            return (Criteria) this;
        }

        public Criteria andCillnumIsNull() {
            addCriterion("cillnum is null");
            return (Criteria) this;
        }

        public Criteria andCillnumIsNotNull() {
            addCriterion("cillnum is not null");
            return (Criteria) this;
        }

        public Criteria andCillnumEqualTo(Integer value) {
            addCriterion("cillnum =", value, "cillnum");
            return (Criteria) this;
        }

        public Criteria andCillnumNotEqualTo(Integer value) {
            addCriterion("cillnum <>", value, "cillnum");
            return (Criteria) this;
        }

        public Criteria andCillnumGreaterThan(Integer value) {
            addCriterion("cillnum >", value, "cillnum");
            return (Criteria) this;
        }

        public Criteria andCillnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("cillnum >=", value, "cillnum");
            return (Criteria) this;
        }

        public Criteria andCillnumLessThan(Integer value) {
            addCriterion("cillnum <", value, "cillnum");
            return (Criteria) this;
        }

        public Criteria andCillnumLessThanOrEqualTo(Integer value) {
            addCriterion("cillnum <=", value, "cillnum");
            return (Criteria) this;
        }

        public Criteria andCillnumIn(List<Integer> values) {
            addCriterion("cillnum in", values, "cillnum");
            return (Criteria) this;
        }

        public Criteria andCillnumNotIn(List<Integer> values) {
            addCriterion("cillnum not in", values, "cillnum");
            return (Criteria) this;
        }

        public Criteria andCillnumBetween(Integer value1, Integer value2) {
            addCriterion("cillnum between", value1, value2, "cillnum");
            return (Criteria) this;
        }

        public Criteria andCillnumNotBetween(Integer value1, Integer value2) {
            addCriterion("cillnum not between", value1, value2, "cillnum");
            return (Criteria) this;
        }

        public Criteria andCcheckoutlvIsNull() {
            addCriterion("ccheckoutlv is null");
            return (Criteria) this;
        }

        public Criteria andCcheckoutlvIsNotNull() {
            addCriterion("ccheckoutlv is not null");
            return (Criteria) this;
        }

        public Criteria andCcheckoutlvEqualTo(String value) {
            addCriterion("ccheckoutlv =", value, "ccheckoutlv");
            return (Criteria) this;
        }

        public Criteria andCcheckoutlvNotEqualTo(String value) {
            addCriterion("ccheckoutlv <>", value, "ccheckoutlv");
            return (Criteria) this;
        }

        public Criteria andCcheckoutlvGreaterThan(String value) {
            addCriterion("ccheckoutlv >", value, "ccheckoutlv");
            return (Criteria) this;
        }

        public Criteria andCcheckoutlvGreaterThanOrEqualTo(String value) {
            addCriterion("ccheckoutlv >=", value, "ccheckoutlv");
            return (Criteria) this;
        }

        public Criteria andCcheckoutlvLessThan(String value) {
            addCriterion("ccheckoutlv <", value, "ccheckoutlv");
            return (Criteria) this;
        }

        public Criteria andCcheckoutlvLessThanOrEqualTo(String value) {
            addCriterion("ccheckoutlv <=", value, "ccheckoutlv");
            return (Criteria) this;
        }

        public Criteria andCcheckoutlvLike(String value) {
            addCriterion("ccheckoutlv like", value, "ccheckoutlv");
            return (Criteria) this;
        }

        public Criteria andCcheckoutlvNotLike(String value) {
            addCriterion("ccheckoutlv not like", value, "ccheckoutlv");
            return (Criteria) this;
        }

        public Criteria andCcheckoutlvIn(List<String> values) {
            addCriterion("ccheckoutlv in", values, "ccheckoutlv");
            return (Criteria) this;
        }

        public Criteria andCcheckoutlvNotIn(List<String> values) {
            addCriterion("ccheckoutlv not in", values, "ccheckoutlv");
            return (Criteria) this;
        }

        public Criteria andCcheckoutlvBetween(String value1, String value2) {
            addCriterion("ccheckoutlv between", value1, value2, "ccheckoutlv");
            return (Criteria) this;
        }

        public Criteria andCcheckoutlvNotBetween(String value1, String value2) {
            addCriterion("ccheckoutlv not between", value1, value2, "ccheckoutlv");
            return (Criteria) this;
        }

        public Criteria andCcheckyearIsNull() {
            addCriterion("ccheckyear is null");
            return (Criteria) this;
        }

        public Criteria andCcheckyearIsNotNull() {
            addCriterion("ccheckyear is not null");
            return (Criteria) this;
        }

        public Criteria andCcheckyearEqualTo(String value) {
            addCriterion("ccheckyear =", value, "ccheckyear");
            return (Criteria) this;
        }

        public Criteria andCcheckyearNotEqualTo(String value) {
            addCriterion("ccheckyear <>", value, "ccheckyear");
            return (Criteria) this;
        }

        public Criteria andCcheckyearGreaterThan(String value) {
            addCriterion("ccheckyear >", value, "ccheckyear");
            return (Criteria) this;
        }

        public Criteria andCcheckyearGreaterThanOrEqualTo(String value) {
            addCriterion("ccheckyear >=", value, "ccheckyear");
            return (Criteria) this;
        }

        public Criteria andCcheckyearLessThan(String value) {
            addCriterion("ccheckyear <", value, "ccheckyear");
            return (Criteria) this;
        }

        public Criteria andCcheckyearLessThanOrEqualTo(String value) {
            addCriterion("ccheckyear <=", value, "ccheckyear");
            return (Criteria) this;
        }

        public Criteria andCcheckyearLike(String value) {
            addCriterion("ccheckyear like", value, "ccheckyear");
            return (Criteria) this;
        }

        public Criteria andCcheckyearNotLike(String value) {
            addCriterion("ccheckyear not like", value, "ccheckyear");
            return (Criteria) this;
        }

        public Criteria andCcheckyearIn(List<String> values) {
            addCriterion("ccheckyear in", values, "ccheckyear");
            return (Criteria) this;
        }

        public Criteria andCcheckyearNotIn(List<String> values) {
            addCriterion("ccheckyear not in", values, "ccheckyear");
            return (Criteria) this;
        }

        public Criteria andCcheckyearBetween(String value1, String value2) {
            addCriterion("ccheckyear between", value1, value2, "ccheckyear");
            return (Criteria) this;
        }

        public Criteria andCcheckyearNotBetween(String value1, String value2) {
            addCriterion("ccheckyear not between", value1, value2, "ccheckyear");
            return (Criteria) this;
        }

        public Criteria andBchecknumIsNull() {
            addCriterion("bchecknum is null");
            return (Criteria) this;
        }

        public Criteria andBchecknumIsNotNull() {
            addCriterion("bchecknum is not null");
            return (Criteria) this;
        }

        public Criteria andBchecknumEqualTo(Integer value) {
            addCriterion("bchecknum =", value, "bchecknum");
            return (Criteria) this;
        }

        public Criteria andBchecknumNotEqualTo(Integer value) {
            addCriterion("bchecknum <>", value, "bchecknum");
            return (Criteria) this;
        }

        public Criteria andBchecknumGreaterThan(Integer value) {
            addCriterion("bchecknum >", value, "bchecknum");
            return (Criteria) this;
        }

        public Criteria andBchecknumGreaterThanOrEqualTo(Integer value) {
            addCriterion("bchecknum >=", value, "bchecknum");
            return (Criteria) this;
        }

        public Criteria andBchecknumLessThan(Integer value) {
            addCriterion("bchecknum <", value, "bchecknum");
            return (Criteria) this;
        }

        public Criteria andBchecknumLessThanOrEqualTo(Integer value) {
            addCriterion("bchecknum <=", value, "bchecknum");
            return (Criteria) this;
        }

        public Criteria andBchecknumIn(List<Integer> values) {
            addCriterion("bchecknum in", values, "bchecknum");
            return (Criteria) this;
        }

        public Criteria andBchecknumNotIn(List<Integer> values) {
            addCriterion("bchecknum not in", values, "bchecknum");
            return (Criteria) this;
        }

        public Criteria andBchecknumBetween(Integer value1, Integer value2) {
            addCriterion("bchecknum between", value1, value2, "bchecknum");
            return (Criteria) this;
        }

        public Criteria andBchecknumNotBetween(Integer value1, Integer value2) {
            addCriterion("bchecknum not between", value1, value2, "bchecknum");
            return (Criteria) this;
        }

        public Criteria andByangnumIsNull() {
            addCriterion("byangnum is null");
            return (Criteria) this;
        }

        public Criteria andByangnumIsNotNull() {
            addCriterion("byangnum is not null");
            return (Criteria) this;
        }

        public Criteria andByangnumEqualTo(Integer value) {
            addCriterion("byangnum =", value, "byangnum");
            return (Criteria) this;
        }

        public Criteria andByangnumNotEqualTo(Integer value) {
            addCriterion("byangnum <>", value, "byangnum");
            return (Criteria) this;
        }

        public Criteria andByangnumGreaterThan(Integer value) {
            addCriterion("byangnum >", value, "byangnum");
            return (Criteria) this;
        }

        public Criteria andByangnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("byangnum >=", value, "byangnum");
            return (Criteria) this;
        }

        public Criteria andByangnumLessThan(Integer value) {
            addCriterion("byangnum <", value, "byangnum");
            return (Criteria) this;
        }

        public Criteria andByangnumLessThanOrEqualTo(Integer value) {
            addCriterion("byangnum <=", value, "byangnum");
            return (Criteria) this;
        }

        public Criteria andByangnumIn(List<Integer> values) {
            addCriterion("byangnum in", values, "byangnum");
            return (Criteria) this;
        }

        public Criteria andByangnumNotIn(List<Integer> values) {
            addCriterion("byangnum not in", values, "byangnum");
            return (Criteria) this;
        }

        public Criteria andByangnumBetween(Integer value1, Integer value2) {
            addCriterion("byangnum between", value1, value2, "byangnum");
            return (Criteria) this;
        }

        public Criteria andByangnumNotBetween(Integer value1, Integer value2) {
            addCriterion("byangnum not between", value1, value2, "byangnum");
            return (Criteria) this;
        }

        public Criteria andBcheckoutlvIsNull() {
            addCriterion("bcheckoutlv is null");
            return (Criteria) this;
        }

        public Criteria andBcheckoutlvIsNotNull() {
            addCriterion("bcheckoutlv is not null");
            return (Criteria) this;
        }

        public Criteria andBcheckoutlvEqualTo(String value) {
            addCriterion("bcheckoutlv =", value, "bcheckoutlv");
            return (Criteria) this;
        }

        public Criteria andBcheckoutlvNotEqualTo(String value) {
            addCriterion("bcheckoutlv <>", value, "bcheckoutlv");
            return (Criteria) this;
        }

        public Criteria andBcheckoutlvGreaterThan(String value) {
            addCriterion("bcheckoutlv >", value, "bcheckoutlv");
            return (Criteria) this;
        }

        public Criteria andBcheckoutlvGreaterThanOrEqualTo(String value) {
            addCriterion("bcheckoutlv >=", value, "bcheckoutlv");
            return (Criteria) this;
        }

        public Criteria andBcheckoutlvLessThan(String value) {
            addCriterion("bcheckoutlv <", value, "bcheckoutlv");
            return (Criteria) this;
        }

        public Criteria andBcheckoutlvLessThanOrEqualTo(String value) {
            addCriterion("bcheckoutlv <=", value, "bcheckoutlv");
            return (Criteria) this;
        }

        public Criteria andBcheckoutlvLike(String value) {
            addCriterion("bcheckoutlv like", value, "bcheckoutlv");
            return (Criteria) this;
        }

        public Criteria andBcheckoutlvNotLike(String value) {
            addCriterion("bcheckoutlv not like", value, "bcheckoutlv");
            return (Criteria) this;
        }

        public Criteria andBcheckoutlvIn(List<String> values) {
            addCriterion("bcheckoutlv in", values, "bcheckoutlv");
            return (Criteria) this;
        }

        public Criteria andBcheckoutlvNotIn(List<String> values) {
            addCriterion("bcheckoutlv not in", values, "bcheckoutlv");
            return (Criteria) this;
        }

        public Criteria andBcheckoutlvBetween(String value1, String value2) {
            addCriterion("bcheckoutlv between", value1, value2, "bcheckoutlv");
            return (Criteria) this;
        }

        public Criteria andBcheckoutlvNotBetween(String value1, String value2) {
            addCriterion("bcheckoutlv not between", value1, value2, "bcheckoutlv");
            return (Criteria) this;
        }

        public Criteria andBcheckyearIsNull() {
            addCriterion("bcheckyear is null");
            return (Criteria) this;
        }

        public Criteria andBcheckyearIsNotNull() {
            addCriterion("bcheckyear is not null");
            return (Criteria) this;
        }

        public Criteria andBcheckyearEqualTo(String value) {
            addCriterion("bcheckyear =", value, "bcheckyear");
            return (Criteria) this;
        }

        public Criteria andBcheckyearNotEqualTo(String value) {
            addCriterion("bcheckyear <>", value, "bcheckyear");
            return (Criteria) this;
        }

        public Criteria andBcheckyearGreaterThan(String value) {
            addCriterion("bcheckyear >", value, "bcheckyear");
            return (Criteria) this;
        }

        public Criteria andBcheckyearGreaterThanOrEqualTo(String value) {
            addCriterion("bcheckyear >=", value, "bcheckyear");
            return (Criteria) this;
        }

        public Criteria andBcheckyearLessThan(String value) {
            addCriterion("bcheckyear <", value, "bcheckyear");
            return (Criteria) this;
        }

        public Criteria andBcheckyearLessThanOrEqualTo(String value) {
            addCriterion("bcheckyear <=", value, "bcheckyear");
            return (Criteria) this;
        }

        public Criteria andBcheckyearLike(String value) {
            addCriterion("bcheckyear like", value, "bcheckyear");
            return (Criteria) this;
        }

        public Criteria andBcheckyearNotLike(String value) {
            addCriterion("bcheckyear not like", value, "bcheckyear");
            return (Criteria) this;
        }

        public Criteria andBcheckyearIn(List<String> values) {
            addCriterion("bcheckyear in", values, "bcheckyear");
            return (Criteria) this;
        }

        public Criteria andBcheckyearNotIn(List<String> values) {
            addCriterion("bcheckyear not in", values, "bcheckyear");
            return (Criteria) this;
        }

        public Criteria andBcheckyearBetween(String value1, String value2) {
            addCriterion("bcheckyear between", value1, value2, "bcheckyear");
            return (Criteria) this;
        }

        public Criteria andBcheckyearNotBetween(String value1, String value2) {
            addCriterion("bcheckyear not between", value1, value2, "bcheckyear");
            return (Criteria) this;
        }

        public Criteria andAchecknumIsNull() {
            addCriterion("achecknum is null");
            return (Criteria) this;
        }

        public Criteria andAchecknumIsNotNull() {
            addCriterion("achecknum is not null");
            return (Criteria) this;
        }

        public Criteria andAchecknumEqualTo(Integer value) {
            addCriterion("achecknum =", value, "achecknum");
            return (Criteria) this;
        }

        public Criteria andAchecknumNotEqualTo(Integer value) {
            addCriterion("achecknum <>", value, "achecknum");
            return (Criteria) this;
        }

        public Criteria andAchecknumGreaterThan(Integer value) {
            addCriterion("achecknum >", value, "achecknum");
            return (Criteria) this;
        }

        public Criteria andAchecknumGreaterThanOrEqualTo(Integer value) {
            addCriterion("achecknum >=", value, "achecknum");
            return (Criteria) this;
        }

        public Criteria andAchecknumLessThan(Integer value) {
            addCriterion("achecknum <", value, "achecknum");
            return (Criteria) this;
        }

        public Criteria andAchecknumLessThanOrEqualTo(Integer value) {
            addCriterion("achecknum <=", value, "achecknum");
            return (Criteria) this;
        }

        public Criteria andAchecknumIn(List<Integer> values) {
            addCriterion("achecknum in", values, "achecknum");
            return (Criteria) this;
        }

        public Criteria andAchecknumNotIn(List<Integer> values) {
            addCriterion("achecknum not in", values, "achecknum");
            return (Criteria) this;
        }

        public Criteria andAchecknumBetween(Integer value1, Integer value2) {
            addCriterion("achecknum between", value1, value2, "achecknum");
            return (Criteria) this;
        }

        public Criteria andAchecknumNotBetween(Integer value1, Integer value2) {
            addCriterion("achecknum not between", value1, value2, "achecknum");
            return (Criteria) this;
        }

        public Criteria andAillnumIsNull() {
            addCriterion("aillnum is null");
            return (Criteria) this;
        }

        public Criteria andAillnumIsNotNull() {
            addCriterion("aillnum is not null");
            return (Criteria) this;
        }

        public Criteria andAillnumEqualTo(Integer value) {
            addCriterion("aillnum =", value, "aillnum");
            return (Criteria) this;
        }

        public Criteria andAillnumNotEqualTo(Integer value) {
            addCriterion("aillnum <>", value, "aillnum");
            return (Criteria) this;
        }

        public Criteria andAillnumGreaterThan(Integer value) {
            addCriterion("aillnum >", value, "aillnum");
            return (Criteria) this;
        }

        public Criteria andAillnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("aillnum >=", value, "aillnum");
            return (Criteria) this;
        }

        public Criteria andAillnumLessThan(Integer value) {
            addCriterion("aillnum <", value, "aillnum");
            return (Criteria) this;
        }

        public Criteria andAillnumLessThanOrEqualTo(Integer value) {
            addCriterion("aillnum <=", value, "aillnum");
            return (Criteria) this;
        }

        public Criteria andAillnumIn(List<Integer> values) {
            addCriterion("aillnum in", values, "aillnum");
            return (Criteria) this;
        }

        public Criteria andAillnumNotIn(List<Integer> values) {
            addCriterion("aillnum not in", values, "aillnum");
            return (Criteria) this;
        }

        public Criteria andAillnumBetween(Integer value1, Integer value2) {
            addCriterion("aillnum between", value1, value2, "aillnum");
            return (Criteria) this;
        }

        public Criteria andAillnumNotBetween(Integer value1, Integer value2) {
            addCriterion("aillnum not between", value1, value2, "aillnum");
            return (Criteria) this;
        }

        public Criteria andAilllvIsNull() {
            addCriterion("ailllv is null");
            return (Criteria) this;
        }

        public Criteria andAilllvIsNotNull() {
            addCriterion("ailllv is not null");
            return (Criteria) this;
        }

        public Criteria andAilllvEqualTo(String value) {
            addCriterion("ailllv =", value, "ailllv");
            return (Criteria) this;
        }

        public Criteria andAilllvNotEqualTo(String value) {
            addCriterion("ailllv <>", value, "ailllv");
            return (Criteria) this;
        }

        public Criteria andAilllvGreaterThan(String value) {
            addCriterion("ailllv >", value, "ailllv");
            return (Criteria) this;
        }

        public Criteria andAilllvGreaterThanOrEqualTo(String value) {
            addCriterion("ailllv >=", value, "ailllv");
            return (Criteria) this;
        }

        public Criteria andAilllvLessThan(String value) {
            addCriterion("ailllv <", value, "ailllv");
            return (Criteria) this;
        }

        public Criteria andAilllvLessThanOrEqualTo(String value) {
            addCriterion("ailllv <=", value, "ailllv");
            return (Criteria) this;
        }

        public Criteria andAilllvLike(String value) {
            addCriterion("ailllv like", value, "ailllv");
            return (Criteria) this;
        }

        public Criteria andAilllvNotLike(String value) {
            addCriterion("ailllv not like", value, "ailllv");
            return (Criteria) this;
        }

        public Criteria andAilllvIn(List<String> values) {
            addCriterion("ailllv in", values, "ailllv");
            return (Criteria) this;
        }

        public Criteria andAilllvNotIn(List<String> values) {
            addCriterion("ailllv not in", values, "ailllv");
            return (Criteria) this;
        }

        public Criteria andAilllvBetween(String value1, String value2) {
            addCriterion("ailllv between", value1, value2, "ailllv");
            return (Criteria) this;
        }

        public Criteria andAilllvNotBetween(String value1, String value2) {
            addCriterion("ailllv not between", value1, value2, "ailllv");
            return (Criteria) this;
        }

        public Criteria andAcheckyearIsNull() {
            addCriterion("acheckyear is null");
            return (Criteria) this;
        }

        public Criteria andAcheckyearIsNotNull() {
            addCriterion("acheckyear is not null");
            return (Criteria) this;
        }

        public Criteria andAcheckyearEqualTo(String value) {
            addCriterion("acheckyear =", value, "acheckyear");
            return (Criteria) this;
        }

        public Criteria andAcheckyearNotEqualTo(String value) {
            addCriterion("acheckyear <>", value, "acheckyear");
            return (Criteria) this;
        }

        public Criteria andAcheckyearGreaterThan(String value) {
            addCriterion("acheckyear >", value, "acheckyear");
            return (Criteria) this;
        }

        public Criteria andAcheckyearGreaterThanOrEqualTo(String value) {
            addCriterion("acheckyear >=", value, "acheckyear");
            return (Criteria) this;
        }

        public Criteria andAcheckyearLessThan(String value) {
            addCriterion("acheckyear <", value, "acheckyear");
            return (Criteria) this;
        }

        public Criteria andAcheckyearLessThanOrEqualTo(String value) {
            addCriterion("acheckyear <=", value, "acheckyear");
            return (Criteria) this;
        }

        public Criteria andAcheckyearLike(String value) {
            addCriterion("acheckyear like", value, "acheckyear");
            return (Criteria) this;
        }

        public Criteria andAcheckyearNotLike(String value) {
            addCriterion("acheckyear not like", value, "acheckyear");
            return (Criteria) this;
        }

        public Criteria andAcheckyearIn(List<String> values) {
            addCriterion("acheckyear in", values, "acheckyear");
            return (Criteria) this;
        }

        public Criteria andAcheckyearNotIn(List<String> values) {
            addCriterion("acheckyear not in", values, "acheckyear");
            return (Criteria) this;
        }

        public Criteria andAcheckyearBetween(String value1, String value2) {
            addCriterion("acheckyear between", value1, value2, "acheckyear");
            return (Criteria) this;
        }

        public Criteria andAcheckyearNotBetween(String value1, String value2) {
            addCriterion("acheckyear not between", value1, value2, "acheckyear");
            return (Criteria) this;
        }

        public Criteria andMchecknumIsNull() {
            addCriterion("mchecknum is null");
            return (Criteria) this;
        }

        public Criteria andMchecknumIsNotNull() {
            addCriterion("mchecknum is not null");
            return (Criteria) this;
        }

        public Criteria andMchecknumEqualTo(Integer value) {
            addCriterion("mchecknum =", value, "mchecknum");
            return (Criteria) this;
        }

        public Criteria andMchecknumNotEqualTo(Integer value) {
            addCriterion("mchecknum <>", value, "mchecknum");
            return (Criteria) this;
        }

        public Criteria andMchecknumGreaterThan(Integer value) {
            addCriterion("mchecknum >", value, "mchecknum");
            return (Criteria) this;
        }

        public Criteria andMchecknumGreaterThanOrEqualTo(Integer value) {
            addCriterion("mchecknum >=", value, "mchecknum");
            return (Criteria) this;
        }

        public Criteria andMchecknumLessThan(Integer value) {
            addCriterion("mchecknum <", value, "mchecknum");
            return (Criteria) this;
        }

        public Criteria andMchecknumLessThanOrEqualTo(Integer value) {
            addCriterion("mchecknum <=", value, "mchecknum");
            return (Criteria) this;
        }

        public Criteria andMchecknumIn(List<Integer> values) {
            addCriterion("mchecknum in", values, "mchecknum");
            return (Criteria) this;
        }

        public Criteria andMchecknumNotIn(List<Integer> values) {
            addCriterion("mchecknum not in", values, "mchecknum");
            return (Criteria) this;
        }

        public Criteria andMchecknumBetween(Integer value1, Integer value2) {
            addCriterion("mchecknum between", value1, value2, "mchecknum");
            return (Criteria) this;
        }

        public Criteria andMchecknumNotBetween(Integer value1, Integer value2) {
            addCriterion("mchecknum not between", value1, value2, "mchecknum");
            return (Criteria) this;
        }

        public Criteria andMyangnumIsNull() {
            addCriterion("myangnum is null");
            return (Criteria) this;
        }

        public Criteria andMyangnumIsNotNull() {
            addCriterion("myangnum is not null");
            return (Criteria) this;
        }

        public Criteria andMyangnumEqualTo(Integer value) {
            addCriterion("myangnum =", value, "myangnum");
            return (Criteria) this;
        }

        public Criteria andMyangnumNotEqualTo(Integer value) {
            addCriterion("myangnum <>", value, "myangnum");
            return (Criteria) this;
        }

        public Criteria andMyangnumGreaterThan(Integer value) {
            addCriterion("myangnum >", value, "myangnum");
            return (Criteria) this;
        }

        public Criteria andMyangnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("myangnum >=", value, "myangnum");
            return (Criteria) this;
        }

        public Criteria andMyangnumLessThan(Integer value) {
            addCriterion("myangnum <", value, "myangnum");
            return (Criteria) this;
        }

        public Criteria andMyangnumLessThanOrEqualTo(Integer value) {
            addCriterion("myangnum <=", value, "myangnum");
            return (Criteria) this;
        }

        public Criteria andMyangnumIn(List<Integer> values) {
            addCriterion("myangnum in", values, "myangnum");
            return (Criteria) this;
        }

        public Criteria andMyangnumNotIn(List<Integer> values) {
            addCriterion("myangnum not in", values, "myangnum");
            return (Criteria) this;
        }

        public Criteria andMyangnumBetween(Integer value1, Integer value2) {
            addCriterion("myangnum between", value1, value2, "myangnum");
            return (Criteria) this;
        }

        public Criteria andMyangnumNotBetween(Integer value1, Integer value2) {
            addCriterion("myangnum not between", value1, value2, "myangnum");
            return (Criteria) this;
        }

        public Criteria andMyanglvIsNull() {
            addCriterion("myanglv is null");
            return (Criteria) this;
        }

        public Criteria andMyanglvIsNotNull() {
            addCriterion("myanglv is not null");
            return (Criteria) this;
        }

        public Criteria andMyanglvEqualTo(String value) {
            addCriterion("myanglv =", value, "myanglv");
            return (Criteria) this;
        }

        public Criteria andMyanglvNotEqualTo(String value) {
            addCriterion("myanglv <>", value, "myanglv");
            return (Criteria) this;
        }

        public Criteria andMyanglvGreaterThan(String value) {
            addCriterion("myanglv >", value, "myanglv");
            return (Criteria) this;
        }

        public Criteria andMyanglvGreaterThanOrEqualTo(String value) {
            addCriterion("myanglv >=", value, "myanglv");
            return (Criteria) this;
        }

        public Criteria andMyanglvLessThan(String value) {
            addCriterion("myanglv <", value, "myanglv");
            return (Criteria) this;
        }

        public Criteria andMyanglvLessThanOrEqualTo(String value) {
            addCriterion("myanglv <=", value, "myanglv");
            return (Criteria) this;
        }

        public Criteria andMyanglvLike(String value) {
            addCriterion("myanglv like", value, "myanglv");
            return (Criteria) this;
        }

        public Criteria andMyanglvNotLike(String value) {
            addCriterion("myanglv not like", value, "myanglv");
            return (Criteria) this;
        }

        public Criteria andMyanglvIn(List<String> values) {
            addCriterion("myanglv in", values, "myanglv");
            return (Criteria) this;
        }

        public Criteria andMyanglvNotIn(List<String> values) {
            addCriterion("myanglv not in", values, "myanglv");
            return (Criteria) this;
        }

        public Criteria andMyanglvBetween(String value1, String value2) {
            addCriterion("myanglv between", value1, value2, "myanglv");
            return (Criteria) this;
        }

        public Criteria andMyanglvNotBetween(String value1, String value2) {
            addCriterion("myanglv not between", value1, value2, "myanglv");
            return (Criteria) this;
        }

        public Criteria andMcheckyearIsNull() {
            addCriterion("mcheckyear is null");
            return (Criteria) this;
        }

        public Criteria andMcheckyearIsNotNull() {
            addCriterion("mcheckyear is not null");
            return (Criteria) this;
        }

        public Criteria andMcheckyearEqualTo(String value) {
            addCriterion("mcheckyear =", value, "mcheckyear");
            return (Criteria) this;
        }

        public Criteria andMcheckyearNotEqualTo(String value) {
            addCriterion("mcheckyear <>", value, "mcheckyear");
            return (Criteria) this;
        }

        public Criteria andMcheckyearGreaterThan(String value) {
            addCriterion("mcheckyear >", value, "mcheckyear");
            return (Criteria) this;
        }

        public Criteria andMcheckyearGreaterThanOrEqualTo(String value) {
            addCriterion("mcheckyear >=", value, "mcheckyear");
            return (Criteria) this;
        }

        public Criteria andMcheckyearLessThan(String value) {
            addCriterion("mcheckyear <", value, "mcheckyear");
            return (Criteria) this;
        }

        public Criteria andMcheckyearLessThanOrEqualTo(String value) {
            addCriterion("mcheckyear <=", value, "mcheckyear");
            return (Criteria) this;
        }

        public Criteria andMcheckyearLike(String value) {
            addCriterion("mcheckyear like", value, "mcheckyear");
            return (Criteria) this;
        }

        public Criteria andMcheckyearNotLike(String value) {
            addCriterion("mcheckyear not like", value, "mcheckyear");
            return (Criteria) this;
        }

        public Criteria andMcheckyearIn(List<String> values) {
            addCriterion("mcheckyear in", values, "mcheckyear");
            return (Criteria) this;
        }

        public Criteria andMcheckyearNotIn(List<String> values) {
            addCriterion("mcheckyear not in", values, "mcheckyear");
            return (Criteria) this;
        }

        public Criteria andMcheckyearBetween(String value1, String value2) {
            addCriterion("mcheckyear between", value1, value2, "mcheckyear");
            return (Criteria) this;
        }

        public Criteria andMcheckyearNotBetween(String value1, String value2) {
            addCriterion("mcheckyear not between", value1, value2, "mcheckyear");
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