package com.sec.aidog.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysLaytimeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysLaytimeExample() {
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

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(String value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(String value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(String value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(String value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(String value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLike(String value) {
            addCriterion("latitude like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotLike(String value) {
            addCriterion("latitude not like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<String> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<String> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(String value1, String value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(String value1, String value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(String value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(String value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(String value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(String value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(String value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLike(String value) {
            addCriterion("longitude like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotLike(String value) {
            addCriterion("longitude not like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<String> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<String> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(String value1, String value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(String value1, String value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andGrantgmtIsNull() {
            addCriterion("grantgmt is null");
            return (Criteria) this;
        }

        public Criteria andGrantgmtIsNotNull() {
            addCriterion("grantgmt is not null");
            return (Criteria) this;
        }

        public Criteria andGrantgmtEqualTo(Date value) {
            addCriterion("grantgmt =", value, "grantgmt");
            return (Criteria) this;
        }

        public Criteria andGrantgmtNotEqualTo(Date value) {
            addCriterion("grantgmt <>", value, "grantgmt");
            return (Criteria) this;
        }

        public Criteria andGrantgmtGreaterThan(Date value) {
            addCriterion("grantgmt >", value, "grantgmt");
            return (Criteria) this;
        }

        public Criteria andGrantgmtGreaterThanOrEqualTo(Date value) {
            addCriterion("grantgmt >=", value, "grantgmt");
            return (Criteria) this;
        }

        public Criteria andGrantgmtLessThan(Date value) {
            addCriterion("grantgmt <", value, "grantgmt");
            return (Criteria) this;
        }

        public Criteria andGrantgmtLessThanOrEqualTo(Date value) {
            addCriterion("grantgmt <=", value, "grantgmt");
            return (Criteria) this;
        }

        public Criteria andGrantgmtIn(List<Date> values) {
            addCriterion("grantgmt in", values, "grantgmt");
            return (Criteria) this;
        }

        public Criteria andGrantgmtNotIn(List<Date> values) {
            addCriterion("grantgmt not in", values, "grantgmt");
            return (Criteria) this;
        }

        public Criteria andGrantgmtBetween(Date value1, Date value2) {
            addCriterion("grantgmt between", value1, value2, "grantgmt");
            return (Criteria) this;
        }

        public Criteria andGrantgmtNotBetween(Date value1, Date value2) {
            addCriterion("grantgmt not between", value1, value2, "grantgmt");
            return (Criteria) this;
        }

        public Criteria andErrIsNull() {
            addCriterion("err is null");
            return (Criteria) this;
        }

        public Criteria andErrIsNotNull() {
            addCriterion("err is not null");
            return (Criteria) this;
        }

        public Criteria andErrEqualTo(String value) {
            addCriterion("err =", value, "err");
            return (Criteria) this;
        }

        public Criteria andErrNotEqualTo(String value) {
            addCriterion("err <>", value, "err");
            return (Criteria) this;
        }

        public Criteria andErrGreaterThan(String value) {
            addCriterion("err >", value, "err");
            return (Criteria) this;
        }

        public Criteria andErrGreaterThanOrEqualTo(String value) {
            addCriterion("err >=", value, "err");
            return (Criteria) this;
        }

        public Criteria andErrLessThan(String value) {
            addCriterion("err <", value, "err");
            return (Criteria) this;
        }

        public Criteria andErrLessThanOrEqualTo(String value) {
            addCriterion("err <=", value, "err");
            return (Criteria) this;
        }

        public Criteria andErrLike(String value) {
            addCriterion("err like", value, "err");
            return (Criteria) this;
        }

        public Criteria andErrNotLike(String value) {
            addCriterion("err not like", value, "err");
            return (Criteria) this;
        }

        public Criteria andErrIn(List<String> values) {
            addCriterion("err in", values, "err");
            return (Criteria) this;
        }

        public Criteria andErrNotIn(List<String> values) {
            addCriterion("err not in", values, "err");
            return (Criteria) this;
        }

        public Criteria andErrBetween(String value1, String value2) {
            addCriterion("err between", value1, value2, "err");
            return (Criteria) this;
        }

        public Criteria andErrNotBetween(String value1, String value2) {
            addCriterion("err not between", value1, value2, "err");
            return (Criteria) this;
        }

        public Criteria andVoltageIsNull() {
            addCriterion("voltage is null");
            return (Criteria) this;
        }

        public Criteria andVoltageIsNotNull() {
            addCriterion("voltage is not null");
            return (Criteria) this;
        }

        public Criteria andVoltageEqualTo(Double value) {
            addCriterion("voltage =", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageNotEqualTo(Double value) {
            addCriterion("voltage <>", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageGreaterThan(Double value) {
            addCriterion("voltage >", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageGreaterThanOrEqualTo(Double value) {
            addCriterion("voltage >=", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageLessThan(Double value) {
            addCriterion("voltage <", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageLessThanOrEqualTo(Double value) {
            addCriterion("voltage <=", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageIn(List<Double> values) {
            addCriterion("voltage in", values, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageNotIn(List<Double> values) {
            addCriterion("voltage not in", values, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageBetween(Double value1, Double value2) {
            addCriterion("voltage between", value1, value2, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageNotBetween(Double value1, Double value2) {
            addCriterion("voltage not between", value1, value2, "voltage");
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

        public Criteria andTemperatureEqualTo(Byte value) {
            addCriterion("temperature =", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotEqualTo(Byte value) {
            addCriterion("temperature <>", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureGreaterThan(Byte value) {
            addCriterion("temperature >", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureGreaterThanOrEqualTo(Byte value) {
            addCriterion("temperature >=", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLessThan(Byte value) {
            addCriterion("temperature <", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLessThanOrEqualTo(Byte value) {
            addCriterion("temperature <=", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureIn(List<Byte> values) {
            addCriterion("temperature in", values, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotIn(List<Byte> values) {
            addCriterion("temperature not in", values, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureBetween(Byte value1, Byte value2) {
            addCriterion("temperature between", value1, value2, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotBetween(Byte value1, Byte value2) {
            addCriterion("temperature not between", value1, value2, "temperature");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Byte value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Byte value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Byte value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Byte value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Byte value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Byte> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Byte> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Byte value1, Byte value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTimegmtIsNull() {
            addCriterion("timegmt is null");
            return (Criteria) this;
        }

        public Criteria andTimegmtIsNotNull() {
            addCriterion("timegmt is not null");
            return (Criteria) this;
        }

        public Criteria andTimegmtEqualTo(Date value) {
            addCriterion("timegmt =", value, "timegmt");
            return (Criteria) this;
        }

        public Criteria andTimegmtNotEqualTo(Date value) {
            addCriterion("timegmt <>", value, "timegmt");
            return (Criteria) this;
        }

        public Criteria andTimegmtGreaterThan(Date value) {
            addCriterion("timegmt >", value, "timegmt");
            return (Criteria) this;
        }

        public Criteria andTimegmtGreaterThanOrEqualTo(Date value) {
            addCriterion("timegmt >=", value, "timegmt");
            return (Criteria) this;
        }

        public Criteria andTimegmtLessThan(Date value) {
            addCriterion("timegmt <", value, "timegmt");
            return (Criteria) this;
        }

        public Criteria andTimegmtLessThanOrEqualTo(Date value) {
            addCriterion("timegmt <=", value, "timegmt");
            return (Criteria) this;
        }

        public Criteria andTimegmtIn(List<Date> values) {
            addCriterion("timegmt in", values, "timegmt");
            return (Criteria) this;
        }

        public Criteria andTimegmtNotIn(List<Date> values) {
            addCriterion("timegmt not in", values, "timegmt");
            return (Criteria) this;
        }

        public Criteria andTimegmtBetween(Date value1, Date value2) {
            addCriterion("timegmt between", value1, value2, "timegmt");
            return (Criteria) this;
        }

        public Criteria andTimegmtNotBetween(Date value1, Date value2) {
            addCriterion("timegmt not between", value1, value2, "timegmt");
            return (Criteria) this;
        }

        public Criteria andIslayIsNull() {
            addCriterion("islay is null");
            return (Criteria) this;
        }

        public Criteria andIslayIsNotNull() {
            addCriterion("islay is not null");
            return (Criteria) this;
        }

        public Criteria andIslayEqualTo(Byte value) {
            addCriterion("islay =", value, "islay");
            return (Criteria) this;
        }

        public Criteria andIslayNotEqualTo(Byte value) {
            addCriterion("islay <>", value, "islay");
            return (Criteria) this;
        }

        public Criteria andIslayGreaterThan(Byte value) {
            addCriterion("islay >", value, "islay");
            return (Criteria) this;
        }

        public Criteria andIslayGreaterThanOrEqualTo(Byte value) {
            addCriterion("islay >=", value, "islay");
            return (Criteria) this;
        }

        public Criteria andIslayLessThan(Byte value) {
            addCriterion("islay <", value, "islay");
            return (Criteria) this;
        }

        public Criteria andIslayLessThanOrEqualTo(Byte value) {
            addCriterion("islay <=", value, "islay");
            return (Criteria) this;
        }

        public Criteria andIslayIn(List<Byte> values) {
            addCriterion("islay in", values, "islay");
            return (Criteria) this;
        }

        public Criteria andIslayNotIn(List<Byte> values) {
            addCriterion("islay not in", values, "islay");
            return (Criteria) this;
        }

        public Criteria andIslayBetween(Byte value1, Byte value2) {
            addCriterion("islay between", value1, value2, "islay");
            return (Criteria) this;
        }

        public Criteria andIslayNotBetween(Byte value1, Byte value2) {
            addCriterion("islay not between", value1, value2, "islay");
            return (Criteria) this;
        }

        public Criteria andSignallevelIsNull() {
            addCriterion("signallevel is null");
            return (Criteria) this;
        }

        public Criteria andSignallevelIsNotNull() {
            addCriterion("signallevel is not null");
            return (Criteria) this;
        }

        public Criteria andSignallevelEqualTo(Byte value) {
            addCriterion("signallevel =", value, "signallevel");
            return (Criteria) this;
        }

        public Criteria andSignallevelNotEqualTo(Byte value) {
            addCriterion("signallevel <>", value, "signallevel");
            return (Criteria) this;
        }

        public Criteria andSignallevelGreaterThan(Byte value) {
            addCriterion("signallevel >", value, "signallevel");
            return (Criteria) this;
        }

        public Criteria andSignallevelGreaterThanOrEqualTo(Byte value) {
            addCriterion("signallevel >=", value, "signallevel");
            return (Criteria) this;
        }

        public Criteria andSignallevelLessThan(Byte value) {
            addCriterion("signallevel <", value, "signallevel");
            return (Criteria) this;
        }

        public Criteria andSignallevelLessThanOrEqualTo(Byte value) {
            addCriterion("signallevel <=", value, "signallevel");
            return (Criteria) this;
        }

        public Criteria andSignallevelIn(List<Byte> values) {
            addCriterion("signallevel in", values, "signallevel");
            return (Criteria) this;
        }

        public Criteria andSignallevelNotIn(List<Byte> values) {
            addCriterion("signallevel not in", values, "signallevel");
            return (Criteria) this;
        }

        public Criteria andSignallevelBetween(Byte value1, Byte value2) {
            addCriterion("signallevel between", value1, value2, "signallevel");
            return (Criteria) this;
        }

        public Criteria andSignallevelNotBetween(Byte value1, Byte value2) {
            addCriterion("signallevel not between", value1, value2, "signallevel");
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