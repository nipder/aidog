package com.sec.aidog.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SystimeposExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystimeposExample() {
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

        public Criteria andOneIsNull() {
            addCriterion("one is null");
            return (Criteria) this;
        }

        public Criteria andOneIsNotNull() {
            addCriterion("one is not null");
            return (Criteria) this;
        }

        public Criteria andOneEqualTo(Date value) {
            addCriterion("one =", value, "one");
            return (Criteria) this;
        }

        public Criteria andOneNotEqualTo(Date value) {
            addCriterion("one <>", value, "one");
            return (Criteria) this;
        }

        public Criteria andOneGreaterThan(Date value) {
            addCriterion("one >", value, "one");
            return (Criteria) this;
        }

        public Criteria andOneGreaterThanOrEqualTo(Date value) {
            addCriterion("one >=", value, "one");
            return (Criteria) this;
        }

        public Criteria andOneLessThan(Date value) {
            addCriterion("one <", value, "one");
            return (Criteria) this;
        }

        public Criteria andOneLessThanOrEqualTo(Date value) {
            addCriterion("one <=", value, "one");
            return (Criteria) this;
        }

        public Criteria andOneIn(List<Date> values) {
            addCriterion("one in", values, "one");
            return (Criteria) this;
        }

        public Criteria andOneNotIn(List<Date> values) {
            addCriterion("one not in", values, "one");
            return (Criteria) this;
        }

        public Criteria andOneBetween(Date value1, Date value2) {
            addCriterion("one between", value1, value2, "one");
            return (Criteria) this;
        }

        public Criteria andOneNotBetween(Date value1, Date value2) {
            addCriterion("one not between", value1, value2, "one");
            return (Criteria) this;
        }

        public Criteria andOnelngIsNull() {
            addCriterion("onelng is null");
            return (Criteria) this;
        }

        public Criteria andOnelngIsNotNull() {
            addCriterion("onelng is not null");
            return (Criteria) this;
        }

        public Criteria andOnelngEqualTo(String value) {
            addCriterion("onelng =", value, "onelng");
            return (Criteria) this;
        }

        public Criteria andOnelngNotEqualTo(String value) {
            addCriterion("onelng <>", value, "onelng");
            return (Criteria) this;
        }

        public Criteria andOnelngGreaterThan(String value) {
            addCriterion("onelng >", value, "onelng");
            return (Criteria) this;
        }

        public Criteria andOnelngGreaterThanOrEqualTo(String value) {
            addCriterion("onelng >=", value, "onelng");
            return (Criteria) this;
        }

        public Criteria andOnelngLessThan(String value) {
            addCriterion("onelng <", value, "onelng");
            return (Criteria) this;
        }

        public Criteria andOnelngLessThanOrEqualTo(String value) {
            addCriterion("onelng <=", value, "onelng");
            return (Criteria) this;
        }

        public Criteria andOnelngLike(String value) {
            addCriterion("onelng like", value, "onelng");
            return (Criteria) this;
        }

        public Criteria andOnelngNotLike(String value) {
            addCriterion("onelng not like", value, "onelng");
            return (Criteria) this;
        }

        public Criteria andOnelngIn(List<String> values) {
            addCriterion("onelng in", values, "onelng");
            return (Criteria) this;
        }

        public Criteria andOnelngNotIn(List<String> values) {
            addCriterion("onelng not in", values, "onelng");
            return (Criteria) this;
        }

        public Criteria andOnelngBetween(String value1, String value2) {
            addCriterion("onelng between", value1, value2, "onelng");
            return (Criteria) this;
        }

        public Criteria andOnelngNotBetween(String value1, String value2) {
            addCriterion("onelng not between", value1, value2, "onelng");
            return (Criteria) this;
        }

        public Criteria andOnelatIsNull() {
            addCriterion("onelat is null");
            return (Criteria) this;
        }

        public Criteria andOnelatIsNotNull() {
            addCriterion("onelat is not null");
            return (Criteria) this;
        }

        public Criteria andOnelatEqualTo(String value) {
            addCriterion("onelat =", value, "onelat");
            return (Criteria) this;
        }

        public Criteria andOnelatNotEqualTo(String value) {
            addCriterion("onelat <>", value, "onelat");
            return (Criteria) this;
        }

        public Criteria andOnelatGreaterThan(String value) {
            addCriterion("onelat >", value, "onelat");
            return (Criteria) this;
        }

        public Criteria andOnelatGreaterThanOrEqualTo(String value) {
            addCriterion("onelat >=", value, "onelat");
            return (Criteria) this;
        }

        public Criteria andOnelatLessThan(String value) {
            addCriterion("onelat <", value, "onelat");
            return (Criteria) this;
        }

        public Criteria andOnelatLessThanOrEqualTo(String value) {
            addCriterion("onelat <=", value, "onelat");
            return (Criteria) this;
        }

        public Criteria andOnelatLike(String value) {
            addCriterion("onelat like", value, "onelat");
            return (Criteria) this;
        }

        public Criteria andOnelatNotLike(String value) {
            addCriterion("onelat not like", value, "onelat");
            return (Criteria) this;
        }

        public Criteria andOnelatIn(List<String> values) {
            addCriterion("onelat in", values, "onelat");
            return (Criteria) this;
        }

        public Criteria andOnelatNotIn(List<String> values) {
            addCriterion("onelat not in", values, "onelat");
            return (Criteria) this;
        }

        public Criteria andOnelatBetween(String value1, String value2) {
            addCriterion("onelat between", value1, value2, "onelat");
            return (Criteria) this;
        }

        public Criteria andOnelatNotBetween(String value1, String value2) {
            addCriterion("onelat not between", value1, value2, "onelat");
            return (Criteria) this;
        }

        public Criteria andTwoIsNull() {
            addCriterion("two is null");
            return (Criteria) this;
        }

        public Criteria andTwoIsNotNull() {
            addCriterion("two is not null");
            return (Criteria) this;
        }

        public Criteria andTwoEqualTo(Date value) {
            addCriterion("two =", value, "two");
            return (Criteria) this;
        }

        public Criteria andTwoNotEqualTo(Date value) {
            addCriterion("two <>", value, "two");
            return (Criteria) this;
        }

        public Criteria andTwoGreaterThan(Date value) {
            addCriterion("two >", value, "two");
            return (Criteria) this;
        }

        public Criteria andTwoGreaterThanOrEqualTo(Date value) {
            addCriterion("two >=", value, "two");
            return (Criteria) this;
        }

        public Criteria andTwoLessThan(Date value) {
            addCriterion("two <", value, "two");
            return (Criteria) this;
        }

        public Criteria andTwoLessThanOrEqualTo(Date value) {
            addCriterion("two <=", value, "two");
            return (Criteria) this;
        }

        public Criteria andTwoIn(List<Date> values) {
            addCriterion("two in", values, "two");
            return (Criteria) this;
        }

        public Criteria andTwoNotIn(List<Date> values) {
            addCriterion("two not in", values, "two");
            return (Criteria) this;
        }

        public Criteria andTwoBetween(Date value1, Date value2) {
            addCriterion("two between", value1, value2, "two");
            return (Criteria) this;
        }

        public Criteria andTwoNotBetween(Date value1, Date value2) {
            addCriterion("two not between", value1, value2, "two");
            return (Criteria) this;
        }

        public Criteria andTwolngIsNull() {
            addCriterion("twolng is null");
            return (Criteria) this;
        }

        public Criteria andTwolngIsNotNull() {
            addCriterion("twolng is not null");
            return (Criteria) this;
        }

        public Criteria andTwolngEqualTo(String value) {
            addCriterion("twolng =", value, "twolng");
            return (Criteria) this;
        }

        public Criteria andTwolngNotEqualTo(String value) {
            addCriterion("twolng <>", value, "twolng");
            return (Criteria) this;
        }

        public Criteria andTwolngGreaterThan(String value) {
            addCriterion("twolng >", value, "twolng");
            return (Criteria) this;
        }

        public Criteria andTwolngGreaterThanOrEqualTo(String value) {
            addCriterion("twolng >=", value, "twolng");
            return (Criteria) this;
        }

        public Criteria andTwolngLessThan(String value) {
            addCriterion("twolng <", value, "twolng");
            return (Criteria) this;
        }

        public Criteria andTwolngLessThanOrEqualTo(String value) {
            addCriterion("twolng <=", value, "twolng");
            return (Criteria) this;
        }

        public Criteria andTwolngLike(String value) {
            addCriterion("twolng like", value, "twolng");
            return (Criteria) this;
        }

        public Criteria andTwolngNotLike(String value) {
            addCriterion("twolng not like", value, "twolng");
            return (Criteria) this;
        }

        public Criteria andTwolngIn(List<String> values) {
            addCriterion("twolng in", values, "twolng");
            return (Criteria) this;
        }

        public Criteria andTwolngNotIn(List<String> values) {
            addCriterion("twolng not in", values, "twolng");
            return (Criteria) this;
        }

        public Criteria andTwolngBetween(String value1, String value2) {
            addCriterion("twolng between", value1, value2, "twolng");
            return (Criteria) this;
        }

        public Criteria andTwolngNotBetween(String value1, String value2) {
            addCriterion("twolng not between", value1, value2, "twolng");
            return (Criteria) this;
        }

        public Criteria andTwolatIsNull() {
            addCriterion("twolat is null");
            return (Criteria) this;
        }

        public Criteria andTwolatIsNotNull() {
            addCriterion("twolat is not null");
            return (Criteria) this;
        }

        public Criteria andTwolatEqualTo(String value) {
            addCriterion("twolat =", value, "twolat");
            return (Criteria) this;
        }

        public Criteria andTwolatNotEqualTo(String value) {
            addCriterion("twolat <>", value, "twolat");
            return (Criteria) this;
        }

        public Criteria andTwolatGreaterThan(String value) {
            addCriterion("twolat >", value, "twolat");
            return (Criteria) this;
        }

        public Criteria andTwolatGreaterThanOrEqualTo(String value) {
            addCriterion("twolat >=", value, "twolat");
            return (Criteria) this;
        }

        public Criteria andTwolatLessThan(String value) {
            addCriterion("twolat <", value, "twolat");
            return (Criteria) this;
        }

        public Criteria andTwolatLessThanOrEqualTo(String value) {
            addCriterion("twolat <=", value, "twolat");
            return (Criteria) this;
        }

        public Criteria andTwolatLike(String value) {
            addCriterion("twolat like", value, "twolat");
            return (Criteria) this;
        }

        public Criteria andTwolatNotLike(String value) {
            addCriterion("twolat not like", value, "twolat");
            return (Criteria) this;
        }

        public Criteria andTwolatIn(List<String> values) {
            addCriterion("twolat in", values, "twolat");
            return (Criteria) this;
        }

        public Criteria andTwolatNotIn(List<String> values) {
            addCriterion("twolat not in", values, "twolat");
            return (Criteria) this;
        }

        public Criteria andTwolatBetween(String value1, String value2) {
            addCriterion("twolat between", value1, value2, "twolat");
            return (Criteria) this;
        }

        public Criteria andTwolatNotBetween(String value1, String value2) {
            addCriterion("twolat not between", value1, value2, "twolat");
            return (Criteria) this;
        }

        public Criteria andThreeIsNull() {
            addCriterion("three is null");
            return (Criteria) this;
        }

        public Criteria andThreeIsNotNull() {
            addCriterion("three is not null");
            return (Criteria) this;
        }

        public Criteria andThreeEqualTo(Date value) {
            addCriterion("three =", value, "three");
            return (Criteria) this;
        }

        public Criteria andThreeNotEqualTo(Date value) {
            addCriterion("three <>", value, "three");
            return (Criteria) this;
        }

        public Criteria andThreeGreaterThan(Date value) {
            addCriterion("three >", value, "three");
            return (Criteria) this;
        }

        public Criteria andThreeGreaterThanOrEqualTo(Date value) {
            addCriterion("three >=", value, "three");
            return (Criteria) this;
        }

        public Criteria andThreeLessThan(Date value) {
            addCriterion("three <", value, "three");
            return (Criteria) this;
        }

        public Criteria andThreeLessThanOrEqualTo(Date value) {
            addCriterion("three <=", value, "three");
            return (Criteria) this;
        }

        public Criteria andThreeIn(List<Date> values) {
            addCriterion("three in", values, "three");
            return (Criteria) this;
        }

        public Criteria andThreeNotIn(List<Date> values) {
            addCriterion("three not in", values, "three");
            return (Criteria) this;
        }

        public Criteria andThreeBetween(Date value1, Date value2) {
            addCriterion("three between", value1, value2, "three");
            return (Criteria) this;
        }

        public Criteria andThreeNotBetween(Date value1, Date value2) {
            addCriterion("three not between", value1, value2, "three");
            return (Criteria) this;
        }

        public Criteria andThreelngIsNull() {
            addCriterion("threelng is null");
            return (Criteria) this;
        }

        public Criteria andThreelngIsNotNull() {
            addCriterion("threelng is not null");
            return (Criteria) this;
        }

        public Criteria andThreelngEqualTo(String value) {
            addCriterion("threelng =", value, "threelng");
            return (Criteria) this;
        }

        public Criteria andThreelngNotEqualTo(String value) {
            addCriterion("threelng <>", value, "threelng");
            return (Criteria) this;
        }

        public Criteria andThreelngGreaterThan(String value) {
            addCriterion("threelng >", value, "threelng");
            return (Criteria) this;
        }

        public Criteria andThreelngGreaterThanOrEqualTo(String value) {
            addCriterion("threelng >=", value, "threelng");
            return (Criteria) this;
        }

        public Criteria andThreelngLessThan(String value) {
            addCriterion("threelng <", value, "threelng");
            return (Criteria) this;
        }

        public Criteria andThreelngLessThanOrEqualTo(String value) {
            addCriterion("threelng <=", value, "threelng");
            return (Criteria) this;
        }

        public Criteria andThreelngLike(String value) {
            addCriterion("threelng like", value, "threelng");
            return (Criteria) this;
        }

        public Criteria andThreelngNotLike(String value) {
            addCriterion("threelng not like", value, "threelng");
            return (Criteria) this;
        }

        public Criteria andThreelngIn(List<String> values) {
            addCriterion("threelng in", values, "threelng");
            return (Criteria) this;
        }

        public Criteria andThreelngNotIn(List<String> values) {
            addCriterion("threelng not in", values, "threelng");
            return (Criteria) this;
        }

        public Criteria andThreelngBetween(String value1, String value2) {
            addCriterion("threelng between", value1, value2, "threelng");
            return (Criteria) this;
        }

        public Criteria andThreelngNotBetween(String value1, String value2) {
            addCriterion("threelng not between", value1, value2, "threelng");
            return (Criteria) this;
        }

        public Criteria andThreelatIsNull() {
            addCriterion("threelat is null");
            return (Criteria) this;
        }

        public Criteria andThreelatIsNotNull() {
            addCriterion("threelat is not null");
            return (Criteria) this;
        }

        public Criteria andThreelatEqualTo(String value) {
            addCriterion("threelat =", value, "threelat");
            return (Criteria) this;
        }

        public Criteria andThreelatNotEqualTo(String value) {
            addCriterion("threelat <>", value, "threelat");
            return (Criteria) this;
        }

        public Criteria andThreelatGreaterThan(String value) {
            addCriterion("threelat >", value, "threelat");
            return (Criteria) this;
        }

        public Criteria andThreelatGreaterThanOrEqualTo(String value) {
            addCriterion("threelat >=", value, "threelat");
            return (Criteria) this;
        }

        public Criteria andThreelatLessThan(String value) {
            addCriterion("threelat <", value, "threelat");
            return (Criteria) this;
        }

        public Criteria andThreelatLessThanOrEqualTo(String value) {
            addCriterion("threelat <=", value, "threelat");
            return (Criteria) this;
        }

        public Criteria andThreelatLike(String value) {
            addCriterion("threelat like", value, "threelat");
            return (Criteria) this;
        }

        public Criteria andThreelatNotLike(String value) {
            addCriterion("threelat not like", value, "threelat");
            return (Criteria) this;
        }

        public Criteria andThreelatIn(List<String> values) {
            addCriterion("threelat in", values, "threelat");
            return (Criteria) this;
        }

        public Criteria andThreelatNotIn(List<String> values) {
            addCriterion("threelat not in", values, "threelat");
            return (Criteria) this;
        }

        public Criteria andThreelatBetween(String value1, String value2) {
            addCriterion("threelat between", value1, value2, "threelat");
            return (Criteria) this;
        }

        public Criteria andThreelatNotBetween(String value1, String value2) {
            addCriterion("threelat not between", value1, value2, "threelat");
            return (Criteria) this;
        }

        public Criteria andFourIsNull() {
            addCriterion("four is null");
            return (Criteria) this;
        }

        public Criteria andFourIsNotNull() {
            addCriterion("four is not null");
            return (Criteria) this;
        }

        public Criteria andFourEqualTo(Date value) {
            addCriterion("four =", value, "four");
            return (Criteria) this;
        }

        public Criteria andFourNotEqualTo(Date value) {
            addCriterion("four <>", value, "four");
            return (Criteria) this;
        }

        public Criteria andFourGreaterThan(Date value) {
            addCriterion("four >", value, "four");
            return (Criteria) this;
        }

        public Criteria andFourGreaterThanOrEqualTo(Date value) {
            addCriterion("four >=", value, "four");
            return (Criteria) this;
        }

        public Criteria andFourLessThan(Date value) {
            addCriterion("four <", value, "four");
            return (Criteria) this;
        }

        public Criteria andFourLessThanOrEqualTo(Date value) {
            addCriterion("four <=", value, "four");
            return (Criteria) this;
        }

        public Criteria andFourIn(List<Date> values) {
            addCriterion("four in", values, "four");
            return (Criteria) this;
        }

        public Criteria andFourNotIn(List<Date> values) {
            addCriterion("four not in", values, "four");
            return (Criteria) this;
        }

        public Criteria andFourBetween(Date value1, Date value2) {
            addCriterion("four between", value1, value2, "four");
            return (Criteria) this;
        }

        public Criteria andFourNotBetween(Date value1, Date value2) {
            addCriterion("four not between", value1, value2, "four");
            return (Criteria) this;
        }

        public Criteria andFourlngIsNull() {
            addCriterion("fourlng is null");
            return (Criteria) this;
        }

        public Criteria andFourlngIsNotNull() {
            addCriterion("fourlng is not null");
            return (Criteria) this;
        }

        public Criteria andFourlngEqualTo(String value) {
            addCriterion("fourlng =", value, "fourlng");
            return (Criteria) this;
        }

        public Criteria andFourlngNotEqualTo(String value) {
            addCriterion("fourlng <>", value, "fourlng");
            return (Criteria) this;
        }

        public Criteria andFourlngGreaterThan(String value) {
            addCriterion("fourlng >", value, "fourlng");
            return (Criteria) this;
        }

        public Criteria andFourlngGreaterThanOrEqualTo(String value) {
            addCriterion("fourlng >=", value, "fourlng");
            return (Criteria) this;
        }

        public Criteria andFourlngLessThan(String value) {
            addCriterion("fourlng <", value, "fourlng");
            return (Criteria) this;
        }

        public Criteria andFourlngLessThanOrEqualTo(String value) {
            addCriterion("fourlng <=", value, "fourlng");
            return (Criteria) this;
        }

        public Criteria andFourlngLike(String value) {
            addCriterion("fourlng like", value, "fourlng");
            return (Criteria) this;
        }

        public Criteria andFourlngNotLike(String value) {
            addCriterion("fourlng not like", value, "fourlng");
            return (Criteria) this;
        }

        public Criteria andFourlngIn(List<String> values) {
            addCriterion("fourlng in", values, "fourlng");
            return (Criteria) this;
        }

        public Criteria andFourlngNotIn(List<String> values) {
            addCriterion("fourlng not in", values, "fourlng");
            return (Criteria) this;
        }

        public Criteria andFourlngBetween(String value1, String value2) {
            addCriterion("fourlng between", value1, value2, "fourlng");
            return (Criteria) this;
        }

        public Criteria andFourlngNotBetween(String value1, String value2) {
            addCriterion("fourlng not between", value1, value2, "fourlng");
            return (Criteria) this;
        }

        public Criteria andFourlatIsNull() {
            addCriterion("fourlat is null");
            return (Criteria) this;
        }

        public Criteria andFourlatIsNotNull() {
            addCriterion("fourlat is not null");
            return (Criteria) this;
        }

        public Criteria andFourlatEqualTo(String value) {
            addCriterion("fourlat =", value, "fourlat");
            return (Criteria) this;
        }

        public Criteria andFourlatNotEqualTo(String value) {
            addCriterion("fourlat <>", value, "fourlat");
            return (Criteria) this;
        }

        public Criteria andFourlatGreaterThan(String value) {
            addCriterion("fourlat >", value, "fourlat");
            return (Criteria) this;
        }

        public Criteria andFourlatGreaterThanOrEqualTo(String value) {
            addCriterion("fourlat >=", value, "fourlat");
            return (Criteria) this;
        }

        public Criteria andFourlatLessThan(String value) {
            addCriterion("fourlat <", value, "fourlat");
            return (Criteria) this;
        }

        public Criteria andFourlatLessThanOrEqualTo(String value) {
            addCriterion("fourlat <=", value, "fourlat");
            return (Criteria) this;
        }

        public Criteria andFourlatLike(String value) {
            addCriterion("fourlat like", value, "fourlat");
            return (Criteria) this;
        }

        public Criteria andFourlatNotLike(String value) {
            addCriterion("fourlat not like", value, "fourlat");
            return (Criteria) this;
        }

        public Criteria andFourlatIn(List<String> values) {
            addCriterion("fourlat in", values, "fourlat");
            return (Criteria) this;
        }

        public Criteria andFourlatNotIn(List<String> values) {
            addCriterion("fourlat not in", values, "fourlat");
            return (Criteria) this;
        }

        public Criteria andFourlatBetween(String value1, String value2) {
            addCriterion("fourlat between", value1, value2, "fourlat");
            return (Criteria) this;
        }

        public Criteria andFourlatNotBetween(String value1, String value2) {
            addCriterion("fourlat not between", value1, value2, "fourlat");
            return (Criteria) this;
        }

        public Criteria andFiveIsNull() {
            addCriterion("five is null");
            return (Criteria) this;
        }

        public Criteria andFiveIsNotNull() {
            addCriterion("five is not null");
            return (Criteria) this;
        }

        public Criteria andFiveEqualTo(Date value) {
            addCriterion("five =", value, "five");
            return (Criteria) this;
        }

        public Criteria andFiveNotEqualTo(Date value) {
            addCriterion("five <>", value, "five");
            return (Criteria) this;
        }

        public Criteria andFiveGreaterThan(Date value) {
            addCriterion("five >", value, "five");
            return (Criteria) this;
        }

        public Criteria andFiveGreaterThanOrEqualTo(Date value) {
            addCriterion("five >=", value, "five");
            return (Criteria) this;
        }

        public Criteria andFiveLessThan(Date value) {
            addCriterion("five <", value, "five");
            return (Criteria) this;
        }

        public Criteria andFiveLessThanOrEqualTo(Date value) {
            addCriterion("five <=", value, "five");
            return (Criteria) this;
        }

        public Criteria andFiveIn(List<Date> values) {
            addCriterion("five in", values, "five");
            return (Criteria) this;
        }

        public Criteria andFiveNotIn(List<Date> values) {
            addCriterion("five not in", values, "five");
            return (Criteria) this;
        }

        public Criteria andFiveBetween(Date value1, Date value2) {
            addCriterion("five between", value1, value2, "five");
            return (Criteria) this;
        }

        public Criteria andFiveNotBetween(Date value1, Date value2) {
            addCriterion("five not between", value1, value2, "five");
            return (Criteria) this;
        }

        public Criteria andFivelngIsNull() {
            addCriterion("fivelng is null");
            return (Criteria) this;
        }

        public Criteria andFivelngIsNotNull() {
            addCriterion("fivelng is not null");
            return (Criteria) this;
        }

        public Criteria andFivelngEqualTo(String value) {
            addCriterion("fivelng =", value, "fivelng");
            return (Criteria) this;
        }

        public Criteria andFivelngNotEqualTo(String value) {
            addCriterion("fivelng <>", value, "fivelng");
            return (Criteria) this;
        }

        public Criteria andFivelngGreaterThan(String value) {
            addCriterion("fivelng >", value, "fivelng");
            return (Criteria) this;
        }

        public Criteria andFivelngGreaterThanOrEqualTo(String value) {
            addCriterion("fivelng >=", value, "fivelng");
            return (Criteria) this;
        }

        public Criteria andFivelngLessThan(String value) {
            addCriterion("fivelng <", value, "fivelng");
            return (Criteria) this;
        }

        public Criteria andFivelngLessThanOrEqualTo(String value) {
            addCriterion("fivelng <=", value, "fivelng");
            return (Criteria) this;
        }

        public Criteria andFivelngLike(String value) {
            addCriterion("fivelng like", value, "fivelng");
            return (Criteria) this;
        }

        public Criteria andFivelngNotLike(String value) {
            addCriterion("fivelng not like", value, "fivelng");
            return (Criteria) this;
        }

        public Criteria andFivelngIn(List<String> values) {
            addCriterion("fivelng in", values, "fivelng");
            return (Criteria) this;
        }

        public Criteria andFivelngNotIn(List<String> values) {
            addCriterion("fivelng not in", values, "fivelng");
            return (Criteria) this;
        }

        public Criteria andFivelngBetween(String value1, String value2) {
            addCriterion("fivelng between", value1, value2, "fivelng");
            return (Criteria) this;
        }

        public Criteria andFivelngNotBetween(String value1, String value2) {
            addCriterion("fivelng not between", value1, value2, "fivelng");
            return (Criteria) this;
        }

        public Criteria andFivelatIsNull() {
            addCriterion("fivelat is null");
            return (Criteria) this;
        }

        public Criteria andFivelatIsNotNull() {
            addCriterion("fivelat is not null");
            return (Criteria) this;
        }

        public Criteria andFivelatEqualTo(String value) {
            addCriterion("fivelat =", value, "fivelat");
            return (Criteria) this;
        }

        public Criteria andFivelatNotEqualTo(String value) {
            addCriterion("fivelat <>", value, "fivelat");
            return (Criteria) this;
        }

        public Criteria andFivelatGreaterThan(String value) {
            addCriterion("fivelat >", value, "fivelat");
            return (Criteria) this;
        }

        public Criteria andFivelatGreaterThanOrEqualTo(String value) {
            addCriterion("fivelat >=", value, "fivelat");
            return (Criteria) this;
        }

        public Criteria andFivelatLessThan(String value) {
            addCriterion("fivelat <", value, "fivelat");
            return (Criteria) this;
        }

        public Criteria andFivelatLessThanOrEqualTo(String value) {
            addCriterion("fivelat <=", value, "fivelat");
            return (Criteria) this;
        }

        public Criteria andFivelatLike(String value) {
            addCriterion("fivelat like", value, "fivelat");
            return (Criteria) this;
        }

        public Criteria andFivelatNotLike(String value) {
            addCriterion("fivelat not like", value, "fivelat");
            return (Criteria) this;
        }

        public Criteria andFivelatIn(List<String> values) {
            addCriterion("fivelat in", values, "fivelat");
            return (Criteria) this;
        }

        public Criteria andFivelatNotIn(List<String> values) {
            addCriterion("fivelat not in", values, "fivelat");
            return (Criteria) this;
        }

        public Criteria andFivelatBetween(String value1, String value2) {
            addCriterion("fivelat between", value1, value2, "fivelat");
            return (Criteria) this;
        }

        public Criteria andFivelatNotBetween(String value1, String value2) {
            addCriterion("fivelat not between", value1, value2, "fivelat");
            return (Criteria) this;
        }

        public Criteria andSixIsNull() {
            addCriterion("six is null");
            return (Criteria) this;
        }

        public Criteria andSixIsNotNull() {
            addCriterion("six is not null");
            return (Criteria) this;
        }

        public Criteria andSixEqualTo(Date value) {
            addCriterion("six =", value, "six");
            return (Criteria) this;
        }

        public Criteria andSixNotEqualTo(Date value) {
            addCriterion("six <>", value, "six");
            return (Criteria) this;
        }

        public Criteria andSixGreaterThan(Date value) {
            addCriterion("six >", value, "six");
            return (Criteria) this;
        }

        public Criteria andSixGreaterThanOrEqualTo(Date value) {
            addCriterion("six >=", value, "six");
            return (Criteria) this;
        }

        public Criteria andSixLessThan(Date value) {
            addCriterion("six <", value, "six");
            return (Criteria) this;
        }

        public Criteria andSixLessThanOrEqualTo(Date value) {
            addCriterion("six <=", value, "six");
            return (Criteria) this;
        }

        public Criteria andSixIn(List<Date> values) {
            addCriterion("six in", values, "six");
            return (Criteria) this;
        }

        public Criteria andSixNotIn(List<Date> values) {
            addCriterion("six not in", values, "six");
            return (Criteria) this;
        }

        public Criteria andSixBetween(Date value1, Date value2) {
            addCriterion("six between", value1, value2, "six");
            return (Criteria) this;
        }

        public Criteria andSixNotBetween(Date value1, Date value2) {
            addCriterion("six not between", value1, value2, "six");
            return (Criteria) this;
        }

        public Criteria andSixlngIsNull() {
            addCriterion("sixlng is null");
            return (Criteria) this;
        }

        public Criteria andSixlngIsNotNull() {
            addCriterion("sixlng is not null");
            return (Criteria) this;
        }

        public Criteria andSixlngEqualTo(String value) {
            addCriterion("sixlng =", value, "sixlng");
            return (Criteria) this;
        }

        public Criteria andSixlngNotEqualTo(String value) {
            addCriterion("sixlng <>", value, "sixlng");
            return (Criteria) this;
        }

        public Criteria andSixlngGreaterThan(String value) {
            addCriterion("sixlng >", value, "sixlng");
            return (Criteria) this;
        }

        public Criteria andSixlngGreaterThanOrEqualTo(String value) {
            addCriterion("sixlng >=", value, "sixlng");
            return (Criteria) this;
        }

        public Criteria andSixlngLessThan(String value) {
            addCriterion("sixlng <", value, "sixlng");
            return (Criteria) this;
        }

        public Criteria andSixlngLessThanOrEqualTo(String value) {
            addCriterion("sixlng <=", value, "sixlng");
            return (Criteria) this;
        }

        public Criteria andSixlngLike(String value) {
            addCriterion("sixlng like", value, "sixlng");
            return (Criteria) this;
        }

        public Criteria andSixlngNotLike(String value) {
            addCriterion("sixlng not like", value, "sixlng");
            return (Criteria) this;
        }

        public Criteria andSixlngIn(List<String> values) {
            addCriterion("sixlng in", values, "sixlng");
            return (Criteria) this;
        }

        public Criteria andSixlngNotIn(List<String> values) {
            addCriterion("sixlng not in", values, "sixlng");
            return (Criteria) this;
        }

        public Criteria andSixlngBetween(String value1, String value2) {
            addCriterion("sixlng between", value1, value2, "sixlng");
            return (Criteria) this;
        }

        public Criteria andSixlngNotBetween(String value1, String value2) {
            addCriterion("sixlng not between", value1, value2, "sixlng");
            return (Criteria) this;
        }

        public Criteria andSixlatIsNull() {
            addCriterion("sixlat is null");
            return (Criteria) this;
        }

        public Criteria andSixlatIsNotNull() {
            addCriterion("sixlat is not null");
            return (Criteria) this;
        }

        public Criteria andSixlatEqualTo(String value) {
            addCriterion("sixlat =", value, "sixlat");
            return (Criteria) this;
        }

        public Criteria andSixlatNotEqualTo(String value) {
            addCriterion("sixlat <>", value, "sixlat");
            return (Criteria) this;
        }

        public Criteria andSixlatGreaterThan(String value) {
            addCriterion("sixlat >", value, "sixlat");
            return (Criteria) this;
        }

        public Criteria andSixlatGreaterThanOrEqualTo(String value) {
            addCriterion("sixlat >=", value, "sixlat");
            return (Criteria) this;
        }

        public Criteria andSixlatLessThan(String value) {
            addCriterion("sixlat <", value, "sixlat");
            return (Criteria) this;
        }

        public Criteria andSixlatLessThanOrEqualTo(String value) {
            addCriterion("sixlat <=", value, "sixlat");
            return (Criteria) this;
        }

        public Criteria andSixlatLike(String value) {
            addCriterion("sixlat like", value, "sixlat");
            return (Criteria) this;
        }

        public Criteria andSixlatNotLike(String value) {
            addCriterion("sixlat not like", value, "sixlat");
            return (Criteria) this;
        }

        public Criteria andSixlatIn(List<String> values) {
            addCriterion("sixlat in", values, "sixlat");
            return (Criteria) this;
        }

        public Criteria andSixlatNotIn(List<String> values) {
            addCriterion("sixlat not in", values, "sixlat");
            return (Criteria) this;
        }

        public Criteria andSixlatBetween(String value1, String value2) {
            addCriterion("sixlat between", value1, value2, "sixlat");
            return (Criteria) this;
        }

        public Criteria andSixlatNotBetween(String value1, String value2) {
            addCriterion("sixlat not between", value1, value2, "sixlat");
            return (Criteria) this;
        }

        public Criteria andSevenIsNull() {
            addCriterion("seven is null");
            return (Criteria) this;
        }

        public Criteria andSevenIsNotNull() {
            addCriterion("seven is not null");
            return (Criteria) this;
        }

        public Criteria andSevenEqualTo(Date value) {
            addCriterion("seven =", value, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenNotEqualTo(Date value) {
            addCriterion("seven <>", value, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenGreaterThan(Date value) {
            addCriterion("seven >", value, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenGreaterThanOrEqualTo(Date value) {
            addCriterion("seven >=", value, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenLessThan(Date value) {
            addCriterion("seven <", value, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenLessThanOrEqualTo(Date value) {
            addCriterion("seven <=", value, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenIn(List<Date> values) {
            addCriterion("seven in", values, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenNotIn(List<Date> values) {
            addCriterion("seven not in", values, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenBetween(Date value1, Date value2) {
            addCriterion("seven between", value1, value2, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenNotBetween(Date value1, Date value2) {
            addCriterion("seven not between", value1, value2, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenlngIsNull() {
            addCriterion("sevenlng is null");
            return (Criteria) this;
        }

        public Criteria andSevenlngIsNotNull() {
            addCriterion("sevenlng is not null");
            return (Criteria) this;
        }

        public Criteria andSevenlngEqualTo(String value) {
            addCriterion("sevenlng =", value, "sevenlng");
            return (Criteria) this;
        }

        public Criteria andSevenlngNotEqualTo(String value) {
            addCriterion("sevenlng <>", value, "sevenlng");
            return (Criteria) this;
        }

        public Criteria andSevenlngGreaterThan(String value) {
            addCriterion("sevenlng >", value, "sevenlng");
            return (Criteria) this;
        }

        public Criteria andSevenlngGreaterThanOrEqualTo(String value) {
            addCriterion("sevenlng >=", value, "sevenlng");
            return (Criteria) this;
        }

        public Criteria andSevenlngLessThan(String value) {
            addCriterion("sevenlng <", value, "sevenlng");
            return (Criteria) this;
        }

        public Criteria andSevenlngLessThanOrEqualTo(String value) {
            addCriterion("sevenlng <=", value, "sevenlng");
            return (Criteria) this;
        }

        public Criteria andSevenlngLike(String value) {
            addCriterion("sevenlng like", value, "sevenlng");
            return (Criteria) this;
        }

        public Criteria andSevenlngNotLike(String value) {
            addCriterion("sevenlng not like", value, "sevenlng");
            return (Criteria) this;
        }

        public Criteria andSevenlngIn(List<String> values) {
            addCriterion("sevenlng in", values, "sevenlng");
            return (Criteria) this;
        }

        public Criteria andSevenlngNotIn(List<String> values) {
            addCriterion("sevenlng not in", values, "sevenlng");
            return (Criteria) this;
        }

        public Criteria andSevenlngBetween(String value1, String value2) {
            addCriterion("sevenlng between", value1, value2, "sevenlng");
            return (Criteria) this;
        }

        public Criteria andSevenlngNotBetween(String value1, String value2) {
            addCriterion("sevenlng not between", value1, value2, "sevenlng");
            return (Criteria) this;
        }

        public Criteria andSevenlatIsNull() {
            addCriterion("sevenlat is null");
            return (Criteria) this;
        }

        public Criteria andSevenlatIsNotNull() {
            addCriterion("sevenlat is not null");
            return (Criteria) this;
        }

        public Criteria andSevenlatEqualTo(String value) {
            addCriterion("sevenlat =", value, "sevenlat");
            return (Criteria) this;
        }

        public Criteria andSevenlatNotEqualTo(String value) {
            addCriterion("sevenlat <>", value, "sevenlat");
            return (Criteria) this;
        }

        public Criteria andSevenlatGreaterThan(String value) {
            addCriterion("sevenlat >", value, "sevenlat");
            return (Criteria) this;
        }

        public Criteria andSevenlatGreaterThanOrEqualTo(String value) {
            addCriterion("sevenlat >=", value, "sevenlat");
            return (Criteria) this;
        }

        public Criteria andSevenlatLessThan(String value) {
            addCriterion("sevenlat <", value, "sevenlat");
            return (Criteria) this;
        }

        public Criteria andSevenlatLessThanOrEqualTo(String value) {
            addCriterion("sevenlat <=", value, "sevenlat");
            return (Criteria) this;
        }

        public Criteria andSevenlatLike(String value) {
            addCriterion("sevenlat like", value, "sevenlat");
            return (Criteria) this;
        }

        public Criteria andSevenlatNotLike(String value) {
            addCriterion("sevenlat not like", value, "sevenlat");
            return (Criteria) this;
        }

        public Criteria andSevenlatIn(List<String> values) {
            addCriterion("sevenlat in", values, "sevenlat");
            return (Criteria) this;
        }

        public Criteria andSevenlatNotIn(List<String> values) {
            addCriterion("sevenlat not in", values, "sevenlat");
            return (Criteria) this;
        }

        public Criteria andSevenlatBetween(String value1, String value2) {
            addCriterion("sevenlat between", value1, value2, "sevenlat");
            return (Criteria) this;
        }

        public Criteria andSevenlatNotBetween(String value1, String value2) {
            addCriterion("sevenlat not between", value1, value2, "sevenlat");
            return (Criteria) this;
        }

        public Criteria andEightIsNull() {
            addCriterion("eight is null");
            return (Criteria) this;
        }

        public Criteria andEightIsNotNull() {
            addCriterion("eight is not null");
            return (Criteria) this;
        }

        public Criteria andEightEqualTo(Date value) {
            addCriterion("eight =", value, "eight");
            return (Criteria) this;
        }

        public Criteria andEightNotEqualTo(Date value) {
            addCriterion("eight <>", value, "eight");
            return (Criteria) this;
        }

        public Criteria andEightGreaterThan(Date value) {
            addCriterion("eight >", value, "eight");
            return (Criteria) this;
        }

        public Criteria andEightGreaterThanOrEqualTo(Date value) {
            addCriterion("eight >=", value, "eight");
            return (Criteria) this;
        }

        public Criteria andEightLessThan(Date value) {
            addCriterion("eight <", value, "eight");
            return (Criteria) this;
        }

        public Criteria andEightLessThanOrEqualTo(Date value) {
            addCriterion("eight <=", value, "eight");
            return (Criteria) this;
        }

        public Criteria andEightIn(List<Date> values) {
            addCriterion("eight in", values, "eight");
            return (Criteria) this;
        }

        public Criteria andEightNotIn(List<Date> values) {
            addCriterion("eight not in", values, "eight");
            return (Criteria) this;
        }

        public Criteria andEightBetween(Date value1, Date value2) {
            addCriterion("eight between", value1, value2, "eight");
            return (Criteria) this;
        }

        public Criteria andEightNotBetween(Date value1, Date value2) {
            addCriterion("eight not between", value1, value2, "eight");
            return (Criteria) this;
        }

        public Criteria andEightlngIsNull() {
            addCriterion("eightlng is null");
            return (Criteria) this;
        }

        public Criteria andEightlngIsNotNull() {
            addCriterion("eightlng is not null");
            return (Criteria) this;
        }

        public Criteria andEightlngEqualTo(String value) {
            addCriterion("eightlng =", value, "eightlng");
            return (Criteria) this;
        }

        public Criteria andEightlngNotEqualTo(String value) {
            addCriterion("eightlng <>", value, "eightlng");
            return (Criteria) this;
        }

        public Criteria andEightlngGreaterThan(String value) {
            addCriterion("eightlng >", value, "eightlng");
            return (Criteria) this;
        }

        public Criteria andEightlngGreaterThanOrEqualTo(String value) {
            addCriterion("eightlng >=", value, "eightlng");
            return (Criteria) this;
        }

        public Criteria andEightlngLessThan(String value) {
            addCriterion("eightlng <", value, "eightlng");
            return (Criteria) this;
        }

        public Criteria andEightlngLessThanOrEqualTo(String value) {
            addCriterion("eightlng <=", value, "eightlng");
            return (Criteria) this;
        }

        public Criteria andEightlngLike(String value) {
            addCriterion("eightlng like", value, "eightlng");
            return (Criteria) this;
        }

        public Criteria andEightlngNotLike(String value) {
            addCriterion("eightlng not like", value, "eightlng");
            return (Criteria) this;
        }

        public Criteria andEightlngIn(List<String> values) {
            addCriterion("eightlng in", values, "eightlng");
            return (Criteria) this;
        }

        public Criteria andEightlngNotIn(List<String> values) {
            addCriterion("eightlng not in", values, "eightlng");
            return (Criteria) this;
        }

        public Criteria andEightlngBetween(String value1, String value2) {
            addCriterion("eightlng between", value1, value2, "eightlng");
            return (Criteria) this;
        }

        public Criteria andEightlngNotBetween(String value1, String value2) {
            addCriterion("eightlng not between", value1, value2, "eightlng");
            return (Criteria) this;
        }

        public Criteria andEightlatIsNull() {
            addCriterion("eightlat is null");
            return (Criteria) this;
        }

        public Criteria andEightlatIsNotNull() {
            addCriterion("eightlat is not null");
            return (Criteria) this;
        }

        public Criteria andEightlatEqualTo(String value) {
            addCriterion("eightlat =", value, "eightlat");
            return (Criteria) this;
        }

        public Criteria andEightlatNotEqualTo(String value) {
            addCriterion("eightlat <>", value, "eightlat");
            return (Criteria) this;
        }

        public Criteria andEightlatGreaterThan(String value) {
            addCriterion("eightlat >", value, "eightlat");
            return (Criteria) this;
        }

        public Criteria andEightlatGreaterThanOrEqualTo(String value) {
            addCriterion("eightlat >=", value, "eightlat");
            return (Criteria) this;
        }

        public Criteria andEightlatLessThan(String value) {
            addCriterion("eightlat <", value, "eightlat");
            return (Criteria) this;
        }

        public Criteria andEightlatLessThanOrEqualTo(String value) {
            addCriterion("eightlat <=", value, "eightlat");
            return (Criteria) this;
        }

        public Criteria andEightlatLike(String value) {
            addCriterion("eightlat like", value, "eightlat");
            return (Criteria) this;
        }

        public Criteria andEightlatNotLike(String value) {
            addCriterion("eightlat not like", value, "eightlat");
            return (Criteria) this;
        }

        public Criteria andEightlatIn(List<String> values) {
            addCriterion("eightlat in", values, "eightlat");
            return (Criteria) this;
        }

        public Criteria andEightlatNotIn(List<String> values) {
            addCriterion("eightlat not in", values, "eightlat");
            return (Criteria) this;
        }

        public Criteria andEightlatBetween(String value1, String value2) {
            addCriterion("eightlat between", value1, value2, "eightlat");
            return (Criteria) this;
        }

        public Criteria andEightlatNotBetween(String value1, String value2) {
            addCriterion("eightlat not between", value1, value2, "eightlat");
            return (Criteria) this;
        }

        public Criteria andNineIsNull() {
            addCriterion("nine is null");
            return (Criteria) this;
        }

        public Criteria andNineIsNotNull() {
            addCriterion("nine is not null");
            return (Criteria) this;
        }

        public Criteria andNineEqualTo(Date value) {
            addCriterion("nine =", value, "nine");
            return (Criteria) this;
        }

        public Criteria andNineNotEqualTo(Date value) {
            addCriterion("nine <>", value, "nine");
            return (Criteria) this;
        }

        public Criteria andNineGreaterThan(Date value) {
            addCriterion("nine >", value, "nine");
            return (Criteria) this;
        }

        public Criteria andNineGreaterThanOrEqualTo(Date value) {
            addCriterion("nine >=", value, "nine");
            return (Criteria) this;
        }

        public Criteria andNineLessThan(Date value) {
            addCriterion("nine <", value, "nine");
            return (Criteria) this;
        }

        public Criteria andNineLessThanOrEqualTo(Date value) {
            addCriterion("nine <=", value, "nine");
            return (Criteria) this;
        }

        public Criteria andNineIn(List<Date> values) {
            addCriterion("nine in", values, "nine");
            return (Criteria) this;
        }

        public Criteria andNineNotIn(List<Date> values) {
            addCriterion("nine not in", values, "nine");
            return (Criteria) this;
        }

        public Criteria andNineBetween(Date value1, Date value2) {
            addCriterion("nine between", value1, value2, "nine");
            return (Criteria) this;
        }

        public Criteria andNineNotBetween(Date value1, Date value2) {
            addCriterion("nine not between", value1, value2, "nine");
            return (Criteria) this;
        }

        public Criteria andNinelngIsNull() {
            addCriterion("ninelng is null");
            return (Criteria) this;
        }

        public Criteria andNinelngIsNotNull() {
            addCriterion("ninelng is not null");
            return (Criteria) this;
        }

        public Criteria andNinelngEqualTo(String value) {
            addCriterion("ninelng =", value, "ninelng");
            return (Criteria) this;
        }

        public Criteria andNinelngNotEqualTo(String value) {
            addCriterion("ninelng <>", value, "ninelng");
            return (Criteria) this;
        }

        public Criteria andNinelngGreaterThan(String value) {
            addCriterion("ninelng >", value, "ninelng");
            return (Criteria) this;
        }

        public Criteria andNinelngGreaterThanOrEqualTo(String value) {
            addCriterion("ninelng >=", value, "ninelng");
            return (Criteria) this;
        }

        public Criteria andNinelngLessThan(String value) {
            addCriterion("ninelng <", value, "ninelng");
            return (Criteria) this;
        }

        public Criteria andNinelngLessThanOrEqualTo(String value) {
            addCriterion("ninelng <=", value, "ninelng");
            return (Criteria) this;
        }

        public Criteria andNinelngLike(String value) {
            addCriterion("ninelng like", value, "ninelng");
            return (Criteria) this;
        }

        public Criteria andNinelngNotLike(String value) {
            addCriterion("ninelng not like", value, "ninelng");
            return (Criteria) this;
        }

        public Criteria andNinelngIn(List<String> values) {
            addCriterion("ninelng in", values, "ninelng");
            return (Criteria) this;
        }

        public Criteria andNinelngNotIn(List<String> values) {
            addCriterion("ninelng not in", values, "ninelng");
            return (Criteria) this;
        }

        public Criteria andNinelngBetween(String value1, String value2) {
            addCriterion("ninelng between", value1, value2, "ninelng");
            return (Criteria) this;
        }

        public Criteria andNinelngNotBetween(String value1, String value2) {
            addCriterion("ninelng not between", value1, value2, "ninelng");
            return (Criteria) this;
        }

        public Criteria andNinelatIsNull() {
            addCriterion("ninelat is null");
            return (Criteria) this;
        }

        public Criteria andNinelatIsNotNull() {
            addCriterion("ninelat is not null");
            return (Criteria) this;
        }

        public Criteria andNinelatEqualTo(String value) {
            addCriterion("ninelat =", value, "ninelat");
            return (Criteria) this;
        }

        public Criteria andNinelatNotEqualTo(String value) {
            addCriterion("ninelat <>", value, "ninelat");
            return (Criteria) this;
        }

        public Criteria andNinelatGreaterThan(String value) {
            addCriterion("ninelat >", value, "ninelat");
            return (Criteria) this;
        }

        public Criteria andNinelatGreaterThanOrEqualTo(String value) {
            addCriterion("ninelat >=", value, "ninelat");
            return (Criteria) this;
        }

        public Criteria andNinelatLessThan(String value) {
            addCriterion("ninelat <", value, "ninelat");
            return (Criteria) this;
        }

        public Criteria andNinelatLessThanOrEqualTo(String value) {
            addCriterion("ninelat <=", value, "ninelat");
            return (Criteria) this;
        }

        public Criteria andNinelatLike(String value) {
            addCriterion("ninelat like", value, "ninelat");
            return (Criteria) this;
        }

        public Criteria andNinelatNotLike(String value) {
            addCriterion("ninelat not like", value, "ninelat");
            return (Criteria) this;
        }

        public Criteria andNinelatIn(List<String> values) {
            addCriterion("ninelat in", values, "ninelat");
            return (Criteria) this;
        }

        public Criteria andNinelatNotIn(List<String> values) {
            addCriterion("ninelat not in", values, "ninelat");
            return (Criteria) this;
        }

        public Criteria andNinelatBetween(String value1, String value2) {
            addCriterion("ninelat between", value1, value2, "ninelat");
            return (Criteria) this;
        }

        public Criteria andNinelatNotBetween(String value1, String value2) {
            addCriterion("ninelat not between", value1, value2, "ninelat");
            return (Criteria) this;
        }

        public Criteria andTenIsNull() {
            addCriterion("ten is null");
            return (Criteria) this;
        }

        public Criteria andTenIsNotNull() {
            addCriterion("ten is not null");
            return (Criteria) this;
        }

        public Criteria andTenEqualTo(Date value) {
            addCriterion("ten =", value, "ten");
            return (Criteria) this;
        }

        public Criteria andTenNotEqualTo(Date value) {
            addCriterion("ten <>", value, "ten");
            return (Criteria) this;
        }

        public Criteria andTenGreaterThan(Date value) {
            addCriterion("ten >", value, "ten");
            return (Criteria) this;
        }

        public Criteria andTenGreaterThanOrEqualTo(Date value) {
            addCriterion("ten >=", value, "ten");
            return (Criteria) this;
        }

        public Criteria andTenLessThan(Date value) {
            addCriterion("ten <", value, "ten");
            return (Criteria) this;
        }

        public Criteria andTenLessThanOrEqualTo(Date value) {
            addCriterion("ten <=", value, "ten");
            return (Criteria) this;
        }

        public Criteria andTenIn(List<Date> values) {
            addCriterion("ten in", values, "ten");
            return (Criteria) this;
        }

        public Criteria andTenNotIn(List<Date> values) {
            addCriterion("ten not in", values, "ten");
            return (Criteria) this;
        }

        public Criteria andTenBetween(Date value1, Date value2) {
            addCriterion("ten between", value1, value2, "ten");
            return (Criteria) this;
        }

        public Criteria andTenNotBetween(Date value1, Date value2) {
            addCriterion("ten not between", value1, value2, "ten");
            return (Criteria) this;
        }

        public Criteria andTenlngIsNull() {
            addCriterion("tenlng is null");
            return (Criteria) this;
        }

        public Criteria andTenlngIsNotNull() {
            addCriterion("tenlng is not null");
            return (Criteria) this;
        }

        public Criteria andTenlngEqualTo(String value) {
            addCriterion("tenlng =", value, "tenlng");
            return (Criteria) this;
        }

        public Criteria andTenlngNotEqualTo(String value) {
            addCriterion("tenlng <>", value, "tenlng");
            return (Criteria) this;
        }

        public Criteria andTenlngGreaterThan(String value) {
            addCriterion("tenlng >", value, "tenlng");
            return (Criteria) this;
        }

        public Criteria andTenlngGreaterThanOrEqualTo(String value) {
            addCriterion("tenlng >=", value, "tenlng");
            return (Criteria) this;
        }

        public Criteria andTenlngLessThan(String value) {
            addCriterion("tenlng <", value, "tenlng");
            return (Criteria) this;
        }

        public Criteria andTenlngLessThanOrEqualTo(String value) {
            addCriterion("tenlng <=", value, "tenlng");
            return (Criteria) this;
        }

        public Criteria andTenlngLike(String value) {
            addCriterion("tenlng like", value, "tenlng");
            return (Criteria) this;
        }

        public Criteria andTenlngNotLike(String value) {
            addCriterion("tenlng not like", value, "tenlng");
            return (Criteria) this;
        }

        public Criteria andTenlngIn(List<String> values) {
            addCriterion("tenlng in", values, "tenlng");
            return (Criteria) this;
        }

        public Criteria andTenlngNotIn(List<String> values) {
            addCriterion("tenlng not in", values, "tenlng");
            return (Criteria) this;
        }

        public Criteria andTenlngBetween(String value1, String value2) {
            addCriterion("tenlng between", value1, value2, "tenlng");
            return (Criteria) this;
        }

        public Criteria andTenlngNotBetween(String value1, String value2) {
            addCriterion("tenlng not between", value1, value2, "tenlng");
            return (Criteria) this;
        }

        public Criteria andTenlatIsNull() {
            addCriterion("tenlat is null");
            return (Criteria) this;
        }

        public Criteria andTenlatIsNotNull() {
            addCriterion("tenlat is not null");
            return (Criteria) this;
        }

        public Criteria andTenlatEqualTo(String value) {
            addCriterion("tenlat =", value, "tenlat");
            return (Criteria) this;
        }

        public Criteria andTenlatNotEqualTo(String value) {
            addCriterion("tenlat <>", value, "tenlat");
            return (Criteria) this;
        }

        public Criteria andTenlatGreaterThan(String value) {
            addCriterion("tenlat >", value, "tenlat");
            return (Criteria) this;
        }

        public Criteria andTenlatGreaterThanOrEqualTo(String value) {
            addCriterion("tenlat >=", value, "tenlat");
            return (Criteria) this;
        }

        public Criteria andTenlatLessThan(String value) {
            addCriterion("tenlat <", value, "tenlat");
            return (Criteria) this;
        }

        public Criteria andTenlatLessThanOrEqualTo(String value) {
            addCriterion("tenlat <=", value, "tenlat");
            return (Criteria) this;
        }

        public Criteria andTenlatLike(String value) {
            addCriterion("tenlat like", value, "tenlat");
            return (Criteria) this;
        }

        public Criteria andTenlatNotLike(String value) {
            addCriterion("tenlat not like", value, "tenlat");
            return (Criteria) this;
        }

        public Criteria andTenlatIn(List<String> values) {
            addCriterion("tenlat in", values, "tenlat");
            return (Criteria) this;
        }

        public Criteria andTenlatNotIn(List<String> values) {
            addCriterion("tenlat not in", values, "tenlat");
            return (Criteria) this;
        }

        public Criteria andTenlatBetween(String value1, String value2) {
            addCriterion("tenlat between", value1, value2, "tenlat");
            return (Criteria) this;
        }

        public Criteria andTenlatNotBetween(String value1, String value2) {
            addCriterion("tenlat not between", value1, value2, "tenlat");
            return (Criteria) this;
        }

        public Criteria andElevenIsNull() {
            addCriterion("eleven is null");
            return (Criteria) this;
        }

        public Criteria andElevenIsNotNull() {
            addCriterion("eleven is not null");
            return (Criteria) this;
        }

        public Criteria andElevenEqualTo(Date value) {
            addCriterion("eleven =", value, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenNotEqualTo(Date value) {
            addCriterion("eleven <>", value, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenGreaterThan(Date value) {
            addCriterion("eleven >", value, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenGreaterThanOrEqualTo(Date value) {
            addCriterion("eleven >=", value, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenLessThan(Date value) {
            addCriterion("eleven <", value, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenLessThanOrEqualTo(Date value) {
            addCriterion("eleven <=", value, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenIn(List<Date> values) {
            addCriterion("eleven in", values, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenNotIn(List<Date> values) {
            addCriterion("eleven not in", values, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenBetween(Date value1, Date value2) {
            addCriterion("eleven between", value1, value2, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenNotBetween(Date value1, Date value2) {
            addCriterion("eleven not between", value1, value2, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenlngIsNull() {
            addCriterion("elevenlng is null");
            return (Criteria) this;
        }

        public Criteria andElevenlngIsNotNull() {
            addCriterion("elevenlng is not null");
            return (Criteria) this;
        }

        public Criteria andElevenlngEqualTo(String value) {
            addCriterion("elevenlng =", value, "elevenlng");
            return (Criteria) this;
        }

        public Criteria andElevenlngNotEqualTo(String value) {
            addCriterion("elevenlng <>", value, "elevenlng");
            return (Criteria) this;
        }

        public Criteria andElevenlngGreaterThan(String value) {
            addCriterion("elevenlng >", value, "elevenlng");
            return (Criteria) this;
        }

        public Criteria andElevenlngGreaterThanOrEqualTo(String value) {
            addCriterion("elevenlng >=", value, "elevenlng");
            return (Criteria) this;
        }

        public Criteria andElevenlngLessThan(String value) {
            addCriterion("elevenlng <", value, "elevenlng");
            return (Criteria) this;
        }

        public Criteria andElevenlngLessThanOrEqualTo(String value) {
            addCriterion("elevenlng <=", value, "elevenlng");
            return (Criteria) this;
        }

        public Criteria andElevenlngLike(String value) {
            addCriterion("elevenlng like", value, "elevenlng");
            return (Criteria) this;
        }

        public Criteria andElevenlngNotLike(String value) {
            addCriterion("elevenlng not like", value, "elevenlng");
            return (Criteria) this;
        }

        public Criteria andElevenlngIn(List<String> values) {
            addCriterion("elevenlng in", values, "elevenlng");
            return (Criteria) this;
        }

        public Criteria andElevenlngNotIn(List<String> values) {
            addCriterion("elevenlng not in", values, "elevenlng");
            return (Criteria) this;
        }

        public Criteria andElevenlngBetween(String value1, String value2) {
            addCriterion("elevenlng between", value1, value2, "elevenlng");
            return (Criteria) this;
        }

        public Criteria andElevenlngNotBetween(String value1, String value2) {
            addCriterion("elevenlng not between", value1, value2, "elevenlng");
            return (Criteria) this;
        }

        public Criteria andElevenlatIsNull() {
            addCriterion("elevenlat is null");
            return (Criteria) this;
        }

        public Criteria andElevenlatIsNotNull() {
            addCriterion("elevenlat is not null");
            return (Criteria) this;
        }

        public Criteria andElevenlatEqualTo(String value) {
            addCriterion("elevenlat =", value, "elevenlat");
            return (Criteria) this;
        }

        public Criteria andElevenlatNotEqualTo(String value) {
            addCriterion("elevenlat <>", value, "elevenlat");
            return (Criteria) this;
        }

        public Criteria andElevenlatGreaterThan(String value) {
            addCriterion("elevenlat >", value, "elevenlat");
            return (Criteria) this;
        }

        public Criteria andElevenlatGreaterThanOrEqualTo(String value) {
            addCriterion("elevenlat >=", value, "elevenlat");
            return (Criteria) this;
        }

        public Criteria andElevenlatLessThan(String value) {
            addCriterion("elevenlat <", value, "elevenlat");
            return (Criteria) this;
        }

        public Criteria andElevenlatLessThanOrEqualTo(String value) {
            addCriterion("elevenlat <=", value, "elevenlat");
            return (Criteria) this;
        }

        public Criteria andElevenlatLike(String value) {
            addCriterion("elevenlat like", value, "elevenlat");
            return (Criteria) this;
        }

        public Criteria andElevenlatNotLike(String value) {
            addCriterion("elevenlat not like", value, "elevenlat");
            return (Criteria) this;
        }

        public Criteria andElevenlatIn(List<String> values) {
            addCriterion("elevenlat in", values, "elevenlat");
            return (Criteria) this;
        }

        public Criteria andElevenlatNotIn(List<String> values) {
            addCriterion("elevenlat not in", values, "elevenlat");
            return (Criteria) this;
        }

        public Criteria andElevenlatBetween(String value1, String value2) {
            addCriterion("elevenlat between", value1, value2, "elevenlat");
            return (Criteria) this;
        }

        public Criteria andElevenlatNotBetween(String value1, String value2) {
            addCriterion("elevenlat not between", value1, value2, "elevenlat");
            return (Criteria) this;
        }

        public Criteria andTwelveIsNull() {
            addCriterion("twelve is null");
            return (Criteria) this;
        }

        public Criteria andTwelveIsNotNull() {
            addCriterion("twelve is not null");
            return (Criteria) this;
        }

        public Criteria andTwelveEqualTo(Date value) {
            addCriterion("twelve =", value, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveNotEqualTo(Date value) {
            addCriterion("twelve <>", value, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveGreaterThan(Date value) {
            addCriterion("twelve >", value, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveGreaterThanOrEqualTo(Date value) {
            addCriterion("twelve >=", value, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveLessThan(Date value) {
            addCriterion("twelve <", value, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveLessThanOrEqualTo(Date value) {
            addCriterion("twelve <=", value, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveIn(List<Date> values) {
            addCriterion("twelve in", values, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveNotIn(List<Date> values) {
            addCriterion("twelve not in", values, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveBetween(Date value1, Date value2) {
            addCriterion("twelve between", value1, value2, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveNotBetween(Date value1, Date value2) {
            addCriterion("twelve not between", value1, value2, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelvelngIsNull() {
            addCriterion("twelvelng is null");
            return (Criteria) this;
        }

        public Criteria andTwelvelngIsNotNull() {
            addCriterion("twelvelng is not null");
            return (Criteria) this;
        }

        public Criteria andTwelvelngEqualTo(String value) {
            addCriterion("twelvelng =", value, "twelvelng");
            return (Criteria) this;
        }

        public Criteria andTwelvelngNotEqualTo(String value) {
            addCriterion("twelvelng <>", value, "twelvelng");
            return (Criteria) this;
        }

        public Criteria andTwelvelngGreaterThan(String value) {
            addCriterion("twelvelng >", value, "twelvelng");
            return (Criteria) this;
        }

        public Criteria andTwelvelngGreaterThanOrEqualTo(String value) {
            addCriterion("twelvelng >=", value, "twelvelng");
            return (Criteria) this;
        }

        public Criteria andTwelvelngLessThan(String value) {
            addCriterion("twelvelng <", value, "twelvelng");
            return (Criteria) this;
        }

        public Criteria andTwelvelngLessThanOrEqualTo(String value) {
            addCriterion("twelvelng <=", value, "twelvelng");
            return (Criteria) this;
        }

        public Criteria andTwelvelngLike(String value) {
            addCriterion("twelvelng like", value, "twelvelng");
            return (Criteria) this;
        }

        public Criteria andTwelvelngNotLike(String value) {
            addCriterion("twelvelng not like", value, "twelvelng");
            return (Criteria) this;
        }

        public Criteria andTwelvelngIn(List<String> values) {
            addCriterion("twelvelng in", values, "twelvelng");
            return (Criteria) this;
        }

        public Criteria andTwelvelngNotIn(List<String> values) {
            addCriterion("twelvelng not in", values, "twelvelng");
            return (Criteria) this;
        }

        public Criteria andTwelvelngBetween(String value1, String value2) {
            addCriterion("twelvelng between", value1, value2, "twelvelng");
            return (Criteria) this;
        }

        public Criteria andTwelvelngNotBetween(String value1, String value2) {
            addCriterion("twelvelng not between", value1, value2, "twelvelng");
            return (Criteria) this;
        }

        public Criteria andTwelvelatIsNull() {
            addCriterion("twelvelat is null");
            return (Criteria) this;
        }

        public Criteria andTwelvelatIsNotNull() {
            addCriterion("twelvelat is not null");
            return (Criteria) this;
        }

        public Criteria andTwelvelatEqualTo(String value) {
            addCriterion("twelvelat =", value, "twelvelat");
            return (Criteria) this;
        }

        public Criteria andTwelvelatNotEqualTo(String value) {
            addCriterion("twelvelat <>", value, "twelvelat");
            return (Criteria) this;
        }

        public Criteria andTwelvelatGreaterThan(String value) {
            addCriterion("twelvelat >", value, "twelvelat");
            return (Criteria) this;
        }

        public Criteria andTwelvelatGreaterThanOrEqualTo(String value) {
            addCriterion("twelvelat >=", value, "twelvelat");
            return (Criteria) this;
        }

        public Criteria andTwelvelatLessThan(String value) {
            addCriterion("twelvelat <", value, "twelvelat");
            return (Criteria) this;
        }

        public Criteria andTwelvelatLessThanOrEqualTo(String value) {
            addCriterion("twelvelat <=", value, "twelvelat");
            return (Criteria) this;
        }

        public Criteria andTwelvelatLike(String value) {
            addCriterion("twelvelat like", value, "twelvelat");
            return (Criteria) this;
        }

        public Criteria andTwelvelatNotLike(String value) {
            addCriterion("twelvelat not like", value, "twelvelat");
            return (Criteria) this;
        }

        public Criteria andTwelvelatIn(List<String> values) {
            addCriterion("twelvelat in", values, "twelvelat");
            return (Criteria) this;
        }

        public Criteria andTwelvelatNotIn(List<String> values) {
            addCriterion("twelvelat not in", values, "twelvelat");
            return (Criteria) this;
        }

        public Criteria andTwelvelatBetween(String value1, String value2) {
            addCriterion("twelvelat between", value1, value2, "twelvelat");
            return (Criteria) this;
        }

        public Criteria andTwelvelatNotBetween(String value1, String value2) {
            addCriterion("twelvelat not between", value1, value2, "twelvelat");
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