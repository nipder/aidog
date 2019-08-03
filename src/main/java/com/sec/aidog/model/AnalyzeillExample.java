package com.sec.aidog.model;

import java.util.ArrayList;
import java.util.List;

public class AnalyzeillExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AnalyzeillExample() {
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

        public Criteria andPersonnumIsNull() {
            addCriterion("personnum is null");
            return (Criteria) this;
        }

        public Criteria andPersonnumIsNotNull() {
            addCriterion("personnum is not null");
            return (Criteria) this;
        }

        public Criteria andPersonnumEqualTo(Integer value) {
            addCriterion("personnum =", value, "personnum");
            return (Criteria) this;
        }

        public Criteria andPersonnumNotEqualTo(Integer value) {
            addCriterion("personnum <>", value, "personnum");
            return (Criteria) this;
        }

        public Criteria andPersonnumGreaterThan(Integer value) {
            addCriterion("personnum >", value, "personnum");
            return (Criteria) this;
        }

        public Criteria andPersonnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("personnum >=", value, "personnum");
            return (Criteria) this;
        }

        public Criteria andPersonnumLessThan(Integer value) {
            addCriterion("personnum <", value, "personnum");
            return (Criteria) this;
        }

        public Criteria andPersonnumLessThanOrEqualTo(Integer value) {
            addCriterion("personnum <=", value, "personnum");
            return (Criteria) this;
        }

        public Criteria andPersonnumIn(List<Integer> values) {
            addCriterion("personnum in", values, "personnum");
            return (Criteria) this;
        }

        public Criteria andPersonnumNotIn(List<Integer> values) {
            addCriterion("personnum not in", values, "personnum");
            return (Criteria) this;
        }

        public Criteria andPersonnumBetween(Integer value1, Integer value2) {
            addCriterion("personnum between", value1, value2, "personnum");
            return (Criteria) this;
        }

        public Criteria andPersonnumNotBetween(Integer value1, Integer value2) {
            addCriterion("personnum not between", value1, value2, "personnum");
            return (Criteria) this;
        }

        public Criteria andPersonillnumIsNull() {
            addCriterion("personillnum is null");
            return (Criteria) this;
        }

        public Criteria andPersonillnumIsNotNull() {
            addCriterion("personillnum is not null");
            return (Criteria) this;
        }

        public Criteria andPersonillnumEqualTo(Integer value) {
            addCriterion("personillnum =", value, "personillnum");
            return (Criteria) this;
        }

        public Criteria andPersonillnumNotEqualTo(Integer value) {
            addCriterion("personillnum <>", value, "personillnum");
            return (Criteria) this;
        }

        public Criteria andPersonillnumGreaterThan(Integer value) {
            addCriterion("personillnum >", value, "personillnum");
            return (Criteria) this;
        }

        public Criteria andPersonillnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("personillnum >=", value, "personillnum");
            return (Criteria) this;
        }

        public Criteria andPersonillnumLessThan(Integer value) {
            addCriterion("personillnum <", value, "personillnum");
            return (Criteria) this;
        }

        public Criteria andPersonillnumLessThanOrEqualTo(Integer value) {
            addCriterion("personillnum <=", value, "personillnum");
            return (Criteria) this;
        }

        public Criteria andPersonillnumIn(List<Integer> values) {
            addCriterion("personillnum in", values, "personillnum");
            return (Criteria) this;
        }

        public Criteria andPersonillnumNotIn(List<Integer> values) {
            addCriterion("personillnum not in", values, "personillnum");
            return (Criteria) this;
        }

        public Criteria andPersonillnumBetween(Integer value1, Integer value2) {
            addCriterion("personillnum between", value1, value2, "personillnum");
            return (Criteria) this;
        }

        public Criteria andPersonillnumNotBetween(Integer value1, Integer value2) {
            addCriterion("personillnum not between", value1, value2, "personillnum");
            return (Criteria) this;
        }

        public Criteria andPersonilllevelIsNull() {
            addCriterion("personilllevel is null");
            return (Criteria) this;
        }

        public Criteria andPersonilllevelIsNotNull() {
            addCriterion("personilllevel is not null");
            return (Criteria) this;
        }

        public Criteria andPersonilllevelEqualTo(Double value) {
            addCriterion("personilllevel =", value, "personilllevel");
            return (Criteria) this;
        }

        public Criteria andPersonilllevelNotEqualTo(Double value) {
            addCriterion("personilllevel <>", value, "personilllevel");
            return (Criteria) this;
        }

        public Criteria andPersonilllevelGreaterThan(Double value) {
            addCriterion("personilllevel >", value, "personilllevel");
            return (Criteria) this;
        }

        public Criteria andPersonilllevelGreaterThanOrEqualTo(Double value) {
            addCriterion("personilllevel >=", value, "personilllevel");
            return (Criteria) this;
        }

        public Criteria andPersonilllevelLessThan(Double value) {
            addCriterion("personilllevel <", value, "personilllevel");
            return (Criteria) this;
        }

        public Criteria andPersonilllevelLessThanOrEqualTo(Double value) {
            addCriterion("personilllevel <=", value, "personilllevel");
            return (Criteria) this;
        }

        public Criteria andPersonilllevelIn(List<Double> values) {
            addCriterion("personilllevel in", values, "personilllevel");
            return (Criteria) this;
        }

        public Criteria andPersonilllevelNotIn(List<Double> values) {
            addCriterion("personilllevel not in", values, "personilllevel");
            return (Criteria) this;
        }

        public Criteria andPersonilllevelBetween(Double value1, Double value2) {
            addCriterion("personilllevel between", value1, value2, "personilllevel");
            return (Criteria) this;
        }

        public Criteria andPersonilllevelNotBetween(Double value1, Double value2) {
            addCriterion("personilllevel not between", value1, value2, "personilllevel");
            return (Criteria) this;
        }

        public Criteria andDognumIsNull() {
            addCriterion("dognum is null");
            return (Criteria) this;
        }

        public Criteria andDognumIsNotNull() {
            addCriterion("dognum is not null");
            return (Criteria) this;
        }

        public Criteria andDognumEqualTo(Integer value) {
            addCriterion("dognum =", value, "dognum");
            return (Criteria) this;
        }

        public Criteria andDognumNotEqualTo(Integer value) {
            addCriterion("dognum <>", value, "dognum");
            return (Criteria) this;
        }

        public Criteria andDognumGreaterThan(Integer value) {
            addCriterion("dognum >", value, "dognum");
            return (Criteria) this;
        }

        public Criteria andDognumGreaterThanOrEqualTo(Integer value) {
            addCriterion("dognum >=", value, "dognum");
            return (Criteria) this;
        }

        public Criteria andDognumLessThan(Integer value) {
            addCriterion("dognum <", value, "dognum");
            return (Criteria) this;
        }

        public Criteria andDognumLessThanOrEqualTo(Integer value) {
            addCriterion("dognum <=", value, "dognum");
            return (Criteria) this;
        }

        public Criteria andDognumIn(List<Integer> values) {
            addCriterion("dognum in", values, "dognum");
            return (Criteria) this;
        }

        public Criteria andDognumNotIn(List<Integer> values) {
            addCriterion("dognum not in", values, "dognum");
            return (Criteria) this;
        }

        public Criteria andDognumBetween(Integer value1, Integer value2) {
            addCriterion("dognum between", value1, value2, "dognum");
            return (Criteria) this;
        }

        public Criteria andDognumNotBetween(Integer value1, Integer value2) {
            addCriterion("dognum not between", value1, value2, "dognum");
            return (Criteria) this;
        }

        public Criteria andDogillnumIsNull() {
            addCriterion("dogillnum is null");
            return (Criteria) this;
        }

        public Criteria andDogillnumIsNotNull() {
            addCriterion("dogillnum is not null");
            return (Criteria) this;
        }

        public Criteria andDogillnumEqualTo(Integer value) {
            addCriterion("dogillnum =", value, "dogillnum");
            return (Criteria) this;
        }

        public Criteria andDogillnumNotEqualTo(Integer value) {
            addCriterion("dogillnum <>", value, "dogillnum");
            return (Criteria) this;
        }

        public Criteria andDogillnumGreaterThan(Integer value) {
            addCriterion("dogillnum >", value, "dogillnum");
            return (Criteria) this;
        }

        public Criteria andDogillnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("dogillnum >=", value, "dogillnum");
            return (Criteria) this;
        }

        public Criteria andDogillnumLessThan(Integer value) {
            addCriterion("dogillnum <", value, "dogillnum");
            return (Criteria) this;
        }

        public Criteria andDogillnumLessThanOrEqualTo(Integer value) {
            addCriterion("dogillnum <=", value, "dogillnum");
            return (Criteria) this;
        }

        public Criteria andDogillnumIn(List<Integer> values) {
            addCriterion("dogillnum in", values, "dogillnum");
            return (Criteria) this;
        }

        public Criteria andDogillnumNotIn(List<Integer> values) {
            addCriterion("dogillnum not in", values, "dogillnum");
            return (Criteria) this;
        }

        public Criteria andDogillnumBetween(Integer value1, Integer value2) {
            addCriterion("dogillnum between", value1, value2, "dogillnum");
            return (Criteria) this;
        }

        public Criteria andDogillnumNotBetween(Integer value1, Integer value2) {
            addCriterion("dogillnum not between", value1, value2, "dogillnum");
            return (Criteria) this;
        }

        public Criteria andDogilllevelIsNull() {
            addCriterion("dogilllevel is null");
            return (Criteria) this;
        }

        public Criteria andDogilllevelIsNotNull() {
            addCriterion("dogilllevel is not null");
            return (Criteria) this;
        }

        public Criteria andDogilllevelEqualTo(Double value) {
            addCriterion("dogilllevel =", value, "dogilllevel");
            return (Criteria) this;
        }

        public Criteria andDogilllevelNotEqualTo(Double value) {
            addCriterion("dogilllevel <>", value, "dogilllevel");
            return (Criteria) this;
        }

        public Criteria andDogilllevelGreaterThan(Double value) {
            addCriterion("dogilllevel >", value, "dogilllevel");
            return (Criteria) this;
        }

        public Criteria andDogilllevelGreaterThanOrEqualTo(Double value) {
            addCriterion("dogilllevel >=", value, "dogilllevel");
            return (Criteria) this;
        }

        public Criteria andDogilllevelLessThan(Double value) {
            addCriterion("dogilllevel <", value, "dogilllevel");
            return (Criteria) this;
        }

        public Criteria andDogilllevelLessThanOrEqualTo(Double value) {
            addCriterion("dogilllevel <=", value, "dogilllevel");
            return (Criteria) this;
        }

        public Criteria andDogilllevelIn(List<Double> values) {
            addCriterion("dogilllevel in", values, "dogilllevel");
            return (Criteria) this;
        }

        public Criteria andDogilllevelNotIn(List<Double> values) {
            addCriterion("dogilllevel not in", values, "dogilllevel");
            return (Criteria) this;
        }

        public Criteria andDogilllevelBetween(Double value1, Double value2) {
            addCriterion("dogilllevel between", value1, value2, "dogilllevel");
            return (Criteria) this;
        }

        public Criteria andDogilllevelNotBetween(Double value1, Double value2) {
            addCriterion("dogilllevel not between", value1, value2, "dogilllevel");
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