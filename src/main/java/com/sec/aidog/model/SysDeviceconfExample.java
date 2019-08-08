package com.sec.aidog.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysDeviceconfExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysDeviceconfExample() {
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andSimccidIsNull() {
            addCriterion("simccid is null");
            return (Criteria) this;
        }

        public Criteria andSimccidIsNotNull() {
            addCriterion("simccid is not null");
            return (Criteria) this;
        }

        public Criteria andSimccidEqualTo(String value) {
            addCriterion("simccid =", value, "simccid");
            return (Criteria) this;
        }

        public Criteria andSimccidNotEqualTo(String value) {
            addCriterion("simccid <>", value, "simccid");
            return (Criteria) this;
        }

        public Criteria andSimccidGreaterThan(String value) {
            addCriterion("simccid >", value, "simccid");
            return (Criteria) this;
        }

        public Criteria andSimccidGreaterThanOrEqualTo(String value) {
            addCriterion("simccid >=", value, "simccid");
            return (Criteria) this;
        }

        public Criteria andSimccidLessThan(String value) {
            addCriterion("simccid <", value, "simccid");
            return (Criteria) this;
        }

        public Criteria andSimccidLessThanOrEqualTo(String value) {
            addCriterion("simccid <=", value, "simccid");
            return (Criteria) this;
        }

        public Criteria andSimccidLike(String value) {
            addCriterion("simccid like", value, "simccid");
            return (Criteria) this;
        }

        public Criteria andSimccidNotLike(String value) {
            addCriterion("simccid not like", value, "simccid");
            return (Criteria) this;
        }

        public Criteria andSimccidIn(List<String> values) {
            addCriterion("simccid in", values, "simccid");
            return (Criteria) this;
        }

        public Criteria andSimccidNotIn(List<String> values) {
            addCriterion("simccid not in", values, "simccid");
            return (Criteria) this;
        }

        public Criteria andSimccidBetween(String value1, String value2) {
            addCriterion("simccid between", value1, value2, "simccid");
            return (Criteria) this;
        }

        public Criteria andSimccidNotBetween(String value1, String value2) {
            addCriterion("simccid not between", value1, value2, "simccid");
            return (Criteria) this;
        }

        public Criteria andSwverIsNull() {
            addCriterion("swver is null");
            return (Criteria) this;
        }

        public Criteria andSwverIsNotNull() {
            addCriterion("swver is not null");
            return (Criteria) this;
        }

        public Criteria andSwverEqualTo(String value) {
            addCriterion("swver =", value, "swver");
            return (Criteria) this;
        }

        public Criteria andSwverNotEqualTo(String value) {
            addCriterion("swver <>", value, "swver");
            return (Criteria) this;
        }

        public Criteria andSwverGreaterThan(String value) {
            addCriterion("swver >", value, "swver");
            return (Criteria) this;
        }

        public Criteria andSwverGreaterThanOrEqualTo(String value) {
            addCriterion("swver >=", value, "swver");
            return (Criteria) this;
        }

        public Criteria andSwverLessThan(String value) {
            addCriterion("swver <", value, "swver");
            return (Criteria) this;
        }

        public Criteria andSwverLessThanOrEqualTo(String value) {
            addCriterion("swver <=", value, "swver");
            return (Criteria) this;
        }

        public Criteria andSwverLike(String value) {
            addCriterion("swver like", value, "swver");
            return (Criteria) this;
        }

        public Criteria andSwverNotLike(String value) {
            addCriterion("swver not like", value, "swver");
            return (Criteria) this;
        }

        public Criteria andSwverIn(List<String> values) {
            addCriterion("swver in", values, "swver");
            return (Criteria) this;
        }

        public Criteria andSwverNotIn(List<String> values) {
            addCriterion("swver not in", values, "swver");
            return (Criteria) this;
        }

        public Criteria andSwverBetween(String value1, String value2) {
            addCriterion("swver between", value1, value2, "swver");
            return (Criteria) this;
        }

        public Criteria andSwverNotBetween(String value1, String value2) {
            addCriterion("swver not between", value1, value2, "swver");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andPortIsNull() {
            addCriterion("port is null");
            return (Criteria) this;
        }

        public Criteria andPortIsNotNull() {
            addCriterion("port is not null");
            return (Criteria) this;
        }

        public Criteria andPortEqualTo(Integer value) {
            addCriterion("port =", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotEqualTo(Integer value) {
            addCriterion("port <>", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThan(Integer value) {
            addCriterion("port >", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThanOrEqualTo(Integer value) {
            addCriterion("port >=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThan(Integer value) {
            addCriterion("port <", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThanOrEqualTo(Integer value) {
            addCriterion("port <=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortIn(List<Integer> values) {
            addCriterion("port in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotIn(List<Integer> values) {
            addCriterion("port not in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortBetween(Integer value1, Integer value2) {
            addCriterion("port between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotBetween(Integer value1, Integer value2) {
            addCriterion("port not between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andInfoupdatecycleIsNull() {
            addCriterion("infoupdatecycle is null");
            return (Criteria) this;
        }

        public Criteria andInfoupdatecycleIsNotNull() {
            addCriterion("infoupdatecycle is not null");
            return (Criteria) this;
        }

        public Criteria andInfoupdatecycleEqualTo(Integer value) {
            addCriterion("infoupdatecycle =", value, "infoupdatecycle");
            return (Criteria) this;
        }

        public Criteria andInfoupdatecycleNotEqualTo(Integer value) {
            addCriterion("infoupdatecycle <>", value, "infoupdatecycle");
            return (Criteria) this;
        }

        public Criteria andInfoupdatecycleGreaterThan(Integer value) {
            addCriterion("infoupdatecycle >", value, "infoupdatecycle");
            return (Criteria) this;
        }

        public Criteria andInfoupdatecycleGreaterThanOrEqualTo(Integer value) {
            addCriterion("infoupdatecycle >=", value, "infoupdatecycle");
            return (Criteria) this;
        }

        public Criteria andInfoupdatecycleLessThan(Integer value) {
            addCriterion("infoupdatecycle <", value, "infoupdatecycle");
            return (Criteria) this;
        }

        public Criteria andInfoupdatecycleLessThanOrEqualTo(Integer value) {
            addCriterion("infoupdatecycle <=", value, "infoupdatecycle");
            return (Criteria) this;
        }

        public Criteria andInfoupdatecycleIn(List<Integer> values) {
            addCriterion("infoupdatecycle in", values, "infoupdatecycle");
            return (Criteria) this;
        }

        public Criteria andInfoupdatecycleNotIn(List<Integer> values) {
            addCriterion("infoupdatecycle not in", values, "infoupdatecycle");
            return (Criteria) this;
        }

        public Criteria andInfoupdatecycleBetween(Integer value1, Integer value2) {
            addCriterion("infoupdatecycle between", value1, value2, "infoupdatecycle");
            return (Criteria) this;
        }

        public Criteria andInfoupdatecycleNotBetween(Integer value1, Integer value2) {
            addCriterion("infoupdatecycle not between", value1, value2, "infoupdatecycle");
            return (Criteria) this;
        }

        public Criteria andTickcycleIsNull() {
            addCriterion("tickcycle is null");
            return (Criteria) this;
        }

        public Criteria andTickcycleIsNotNull() {
            addCriterion("tickcycle is not null");
            return (Criteria) this;
        }

        public Criteria andTickcycleEqualTo(Integer value) {
            addCriterion("tickcycle =", value, "tickcycle");
            return (Criteria) this;
        }

        public Criteria andTickcycleNotEqualTo(Integer value) {
            addCriterion("tickcycle <>", value, "tickcycle");
            return (Criteria) this;
        }

        public Criteria andTickcycleGreaterThan(Integer value) {
            addCriterion("tickcycle >", value, "tickcycle");
            return (Criteria) this;
        }

        public Criteria andTickcycleGreaterThanOrEqualTo(Integer value) {
            addCriterion("tickcycle >=", value, "tickcycle");
            return (Criteria) this;
        }

        public Criteria andTickcycleLessThan(Integer value) {
            addCriterion("tickcycle <", value, "tickcycle");
            return (Criteria) this;
        }

        public Criteria andTickcycleLessThanOrEqualTo(Integer value) {
            addCriterion("tickcycle <=", value, "tickcycle");
            return (Criteria) this;
        }

        public Criteria andTickcycleIn(List<Integer> values) {
            addCriterion("tickcycle in", values, "tickcycle");
            return (Criteria) this;
        }

        public Criteria andTickcycleNotIn(List<Integer> values) {
            addCriterion("tickcycle not in", values, "tickcycle");
            return (Criteria) this;
        }

        public Criteria andTickcycleBetween(Integer value1, Integer value2) {
            addCriterion("tickcycle between", value1, value2, "tickcycle");
            return (Criteria) this;
        }

        public Criteria andTickcycleNotBetween(Integer value1, Integer value2) {
            addCriterion("tickcycle not between", value1, value2, "tickcycle");
            return (Criteria) this;
        }

        public Criteria andBastimesIsNull() {
            addCriterion("bastimes is null");
            return (Criteria) this;
        }

        public Criteria andBastimesIsNotNull() {
            addCriterion("bastimes is not null");
            return (Criteria) this;
        }

        public Criteria andBastimesEqualTo(Byte value) {
            addCriterion("bastimes =", value, "bastimes");
            return (Criteria) this;
        }

        public Criteria andBastimesNotEqualTo(Byte value) {
            addCriterion("bastimes <>", value, "bastimes");
            return (Criteria) this;
        }

        public Criteria andBastimesGreaterThan(Byte value) {
            addCriterion("bastimes >", value, "bastimes");
            return (Criteria) this;
        }

        public Criteria andBastimesGreaterThanOrEqualTo(Byte value) {
            addCriterion("bastimes >=", value, "bastimes");
            return (Criteria) this;
        }

        public Criteria andBastimesLessThan(Byte value) {
            addCriterion("bastimes <", value, "bastimes");
            return (Criteria) this;
        }

        public Criteria andBastimesLessThanOrEqualTo(Byte value) {
            addCriterion("bastimes <=", value, "bastimes");
            return (Criteria) this;
        }

        public Criteria andBastimesIn(List<Byte> values) {
            addCriterion("bastimes in", values, "bastimes");
            return (Criteria) this;
        }

        public Criteria andBastimesNotIn(List<Byte> values) {
            addCriterion("bastimes not in", values, "bastimes");
            return (Criteria) this;
        }

        public Criteria andBastimesBetween(Byte value1, Byte value2) {
            addCriterion("bastimes between", value1, value2, "bastimes");
            return (Criteria) this;
        }

        public Criteria andBastimesNotBetween(Byte value1, Byte value2) {
            addCriterion("bastimes not between", value1, value2, "bastimes");
            return (Criteria) this;
        }

        public Criteria andGpstimesIsNull() {
            addCriterion("gpstimes is null");
            return (Criteria) this;
        }

        public Criteria andGpstimesIsNotNull() {
            addCriterion("gpstimes is not null");
            return (Criteria) this;
        }

        public Criteria andGpstimesEqualTo(Byte value) {
            addCriterion("gpstimes =", value, "gpstimes");
            return (Criteria) this;
        }

        public Criteria andGpstimesNotEqualTo(Byte value) {
            addCriterion("gpstimes <>", value, "gpstimes");
            return (Criteria) this;
        }

        public Criteria andGpstimesGreaterThan(Byte value) {
            addCriterion("gpstimes >", value, "gpstimes");
            return (Criteria) this;
        }

        public Criteria andGpstimesGreaterThanOrEqualTo(Byte value) {
            addCriterion("gpstimes >=", value, "gpstimes");
            return (Criteria) this;
        }

        public Criteria andGpstimesLessThan(Byte value) {
            addCriterion("gpstimes <", value, "gpstimes");
            return (Criteria) this;
        }

        public Criteria andGpstimesLessThanOrEqualTo(Byte value) {
            addCriterion("gpstimes <=", value, "gpstimes");
            return (Criteria) this;
        }

        public Criteria andGpstimesIn(List<Byte> values) {
            addCriterion("gpstimes in", values, "gpstimes");
            return (Criteria) this;
        }

        public Criteria andGpstimesNotIn(List<Byte> values) {
            addCriterion("gpstimes not in", values, "gpstimes");
            return (Criteria) this;
        }

        public Criteria andGpstimesBetween(Byte value1, Byte value2) {
            addCriterion("gpstimes between", value1, value2, "gpstimes");
            return (Criteria) this;
        }

        public Criteria andGpstimesNotBetween(Byte value1, Byte value2) {
            addCriterion("gpstimes not between", value1, value2, "gpstimes");
            return (Criteria) this;
        }

        public Criteria andLedenableIsNull() {
            addCriterion("ledenable is null");
            return (Criteria) this;
        }

        public Criteria andLedenableIsNotNull() {
            addCriterion("ledenable is not null");
            return (Criteria) this;
        }

        public Criteria andLedenableEqualTo(Byte value) {
            addCriterion("ledenable =", value, "ledenable");
            return (Criteria) this;
        }

        public Criteria andLedenableNotEqualTo(Byte value) {
            addCriterion("ledenable <>", value, "ledenable");
            return (Criteria) this;
        }

        public Criteria andLedenableGreaterThan(Byte value) {
            addCriterion("ledenable >", value, "ledenable");
            return (Criteria) this;
        }

        public Criteria andLedenableGreaterThanOrEqualTo(Byte value) {
            addCriterion("ledenable >=", value, "ledenable");
            return (Criteria) this;
        }

        public Criteria andLedenableLessThan(Byte value) {
            addCriterion("ledenable <", value, "ledenable");
            return (Criteria) this;
        }

        public Criteria andLedenableLessThanOrEqualTo(Byte value) {
            addCriterion("ledenable <=", value, "ledenable");
            return (Criteria) this;
        }

        public Criteria andLedenableIn(List<Byte> values) {
            addCriterion("ledenable in", values, "ledenable");
            return (Criteria) this;
        }

        public Criteria andLedenableNotIn(List<Byte> values) {
            addCriterion("ledenable not in", values, "ledenable");
            return (Criteria) this;
        }

        public Criteria andLedenableBetween(Byte value1, Byte value2) {
            addCriterion("ledenable between", value1, value2, "ledenable");
            return (Criteria) this;
        }

        public Criteria andLedenableNotBetween(Byte value1, Byte value2) {
            addCriterion("ledenable not between", value1, value2, "ledenable");
            return (Criteria) this;
        }

        public Criteria andTemporaryflagIsNull() {
            addCriterion("temporaryflag is null");
            return (Criteria) this;
        }

        public Criteria andTemporaryflagIsNotNull() {
            addCriterion("temporaryflag is not null");
            return (Criteria) this;
        }

        public Criteria andTemporaryflagEqualTo(Byte value) {
            addCriterion("temporaryflag =", value, "temporaryflag");
            return (Criteria) this;
        }

        public Criteria andTemporaryflagNotEqualTo(Byte value) {
            addCriterion("temporaryflag <>", value, "temporaryflag");
            return (Criteria) this;
        }

        public Criteria andTemporaryflagGreaterThan(Byte value) {
            addCriterion("temporaryflag >", value, "temporaryflag");
            return (Criteria) this;
        }

        public Criteria andTemporaryflagGreaterThanOrEqualTo(Byte value) {
            addCriterion("temporaryflag >=", value, "temporaryflag");
            return (Criteria) this;
        }

        public Criteria andTemporaryflagLessThan(Byte value) {
            addCriterion("temporaryflag <", value, "temporaryflag");
            return (Criteria) this;
        }

        public Criteria andTemporaryflagLessThanOrEqualTo(Byte value) {
            addCriterion("temporaryflag <=", value, "temporaryflag");
            return (Criteria) this;
        }

        public Criteria andTemporaryflagIn(List<Byte> values) {
            addCriterion("temporaryflag in", values, "temporaryflag");
            return (Criteria) this;
        }

        public Criteria andTemporaryflagNotIn(List<Byte> values) {
            addCriterion("temporaryflag not in", values, "temporaryflag");
            return (Criteria) this;
        }

        public Criteria andTemporaryflagBetween(Byte value1, Byte value2) {
            addCriterion("temporaryflag between", value1, value2, "temporaryflag");
            return (Criteria) this;
        }

        public Criteria andTemporaryflagNotBetween(Byte value1, Byte value2) {
            addCriterion("temporaryflag not between", value1, value2, "temporaryflag");
            return (Criteria) this;
        }

        public Criteria andTemporarygmtIsNull() {
            addCriterion("temporarygmt is null");
            return (Criteria) this;
        }

        public Criteria andTemporarygmtIsNotNull() {
            addCriterion("temporarygmt is not null");
            return (Criteria) this;
        }

        public Criteria andTemporarygmtEqualTo(Date value) {
            addCriterion("temporarygmt =", value, "temporarygmt");
            return (Criteria) this;
        }

        public Criteria andTemporarygmtNotEqualTo(Date value) {
            addCriterion("temporarygmt <>", value, "temporarygmt");
            return (Criteria) this;
        }

        public Criteria andTemporarygmtGreaterThan(Date value) {
            addCriterion("temporarygmt >", value, "temporarygmt");
            return (Criteria) this;
        }

        public Criteria andTemporarygmtGreaterThanOrEqualTo(Date value) {
            addCriterion("temporarygmt >=", value, "temporarygmt");
            return (Criteria) this;
        }

        public Criteria andTemporarygmtLessThan(Date value) {
            addCriterion("temporarygmt <", value, "temporarygmt");
            return (Criteria) this;
        }

        public Criteria andTemporarygmtLessThanOrEqualTo(Date value) {
            addCriterion("temporarygmt <=", value, "temporarygmt");
            return (Criteria) this;
        }

        public Criteria andTemporarygmtIn(List<Date> values) {
            addCriterion("temporarygmt in", values, "temporarygmt");
            return (Criteria) this;
        }

        public Criteria andTemporarygmtNotIn(List<Date> values) {
            addCriterion("temporarygmt not in", values, "temporarygmt");
            return (Criteria) this;
        }

        public Criteria andTemporarygmtBetween(Date value1, Date value2) {
            addCriterion("temporarygmt between", value1, value2, "temporarygmt");
            return (Criteria) this;
        }

        public Criteria andTemporarygmtNotBetween(Date value1, Date value2) {
            addCriterion("temporarygmt not between", value1, value2, "temporarygmt");
            return (Criteria) this;
        }

        public Criteria andClearerrIsNull() {
            addCriterion("clearerr is null");
            return (Criteria) this;
        }

        public Criteria andClearerrIsNotNull() {
            addCriterion("clearerr is not null");
            return (Criteria) this;
        }

        public Criteria andClearerrEqualTo(Byte value) {
            addCriterion("clearerr =", value, "clearerr");
            return (Criteria) this;
        }

        public Criteria andClearerrNotEqualTo(Byte value) {
            addCriterion("clearerr <>", value, "clearerr");
            return (Criteria) this;
        }

        public Criteria andClearerrGreaterThan(Byte value) {
            addCriterion("clearerr >", value, "clearerr");
            return (Criteria) this;
        }

        public Criteria andClearerrGreaterThanOrEqualTo(Byte value) {
            addCriterion("clearerr >=", value, "clearerr");
            return (Criteria) this;
        }

        public Criteria andClearerrLessThan(Byte value) {
            addCriterion("clearerr <", value, "clearerr");
            return (Criteria) this;
        }

        public Criteria andClearerrLessThanOrEqualTo(Byte value) {
            addCriterion("clearerr <=", value, "clearerr");
            return (Criteria) this;
        }

        public Criteria andClearerrIn(List<Byte> values) {
            addCriterion("clearerr in", values, "clearerr");
            return (Criteria) this;
        }

        public Criteria andClearerrNotIn(List<Byte> values) {
            addCriterion("clearerr not in", values, "clearerr");
            return (Criteria) this;
        }

        public Criteria andClearerrBetween(Byte value1, Byte value2) {
            addCriterion("clearerr between", value1, value2, "clearerr");
            return (Criteria) this;
        }

        public Criteria andClearerrNotBetween(Byte value1, Byte value2) {
            addCriterion("clearerr not between", value1, value2, "clearerr");
            return (Criteria) this;
        }

        public Criteria andFactoryIsNull() {
            addCriterion("factory is null");
            return (Criteria) this;
        }

        public Criteria andFactoryIsNotNull() {
            addCriterion("factory is not null");
            return (Criteria) this;
        }

        public Criteria andFactoryEqualTo(Byte value) {
            addCriterion("factory =", value, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryNotEqualTo(Byte value) {
            addCriterion("factory <>", value, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryGreaterThan(Byte value) {
            addCriterion("factory >", value, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryGreaterThanOrEqualTo(Byte value) {
            addCriterion("factory >=", value, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryLessThan(Byte value) {
            addCriterion("factory <", value, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryLessThanOrEqualTo(Byte value) {
            addCriterion("factory <=", value, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryIn(List<Byte> values) {
            addCriterion("factory in", values, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryNotIn(List<Byte> values) {
            addCriterion("factory not in", values, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryBetween(Byte value1, Byte value2) {
            addCriterion("factory between", value1, value2, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryNotBetween(Byte value1, Byte value2) {
            addCriterion("factory not between", value1, value2, "factory");
            return (Criteria) this;
        }

        public Criteria andUimodifyflagIsNull() {
            addCriterion("uimodifyflag is null");
            return (Criteria) this;
        }

        public Criteria andUimodifyflagIsNotNull() {
            addCriterion("uimodifyflag is not null");
            return (Criteria) this;
        }

        public Criteria andUimodifyflagEqualTo(Byte value) {
            addCriterion("uimodifyflag =", value, "uimodifyflag");
            return (Criteria) this;
        }

        public Criteria andUimodifyflagNotEqualTo(Byte value) {
            addCriterion("uimodifyflag <>", value, "uimodifyflag");
            return (Criteria) this;
        }

        public Criteria andUimodifyflagGreaterThan(Byte value) {
            addCriterion("uimodifyflag >", value, "uimodifyflag");
            return (Criteria) this;
        }

        public Criteria andUimodifyflagGreaterThanOrEqualTo(Byte value) {
            addCriterion("uimodifyflag >=", value, "uimodifyflag");
            return (Criteria) this;
        }

        public Criteria andUimodifyflagLessThan(Byte value) {
            addCriterion("uimodifyflag <", value, "uimodifyflag");
            return (Criteria) this;
        }

        public Criteria andUimodifyflagLessThanOrEqualTo(Byte value) {
            addCriterion("uimodifyflag <=", value, "uimodifyflag");
            return (Criteria) this;
        }

        public Criteria andUimodifyflagIn(List<Byte> values) {
            addCriterion("uimodifyflag in", values, "uimodifyflag");
            return (Criteria) this;
        }

        public Criteria andUimodifyflagNotIn(List<Byte> values) {
            addCriterion("uimodifyflag not in", values, "uimodifyflag");
            return (Criteria) this;
        }

        public Criteria andUimodifyflagBetween(Byte value1, Byte value2) {
            addCriterion("uimodifyflag between", value1, value2, "uimodifyflag");
            return (Criteria) this;
        }

        public Criteria andUimodifyflagNotBetween(Byte value1, Byte value2) {
            addCriterion("uimodifyflag not between", value1, value2, "uimodifyflag");
            return (Criteria) this;
        }

        public Criteria andHardmodifyflagIsNull() {
            addCriterion("hardmodifyflag is null");
            return (Criteria) this;
        }

        public Criteria andHardmodifyflagIsNotNull() {
            addCriterion("hardmodifyflag is not null");
            return (Criteria) this;
        }

        public Criteria andHardmodifyflagEqualTo(Byte value) {
            addCriterion("hardmodifyflag =", value, "hardmodifyflag");
            return (Criteria) this;
        }

        public Criteria andHardmodifyflagNotEqualTo(Byte value) {
            addCriterion("hardmodifyflag <>", value, "hardmodifyflag");
            return (Criteria) this;
        }

        public Criteria andHardmodifyflagGreaterThan(Byte value) {
            addCriterion("hardmodifyflag >", value, "hardmodifyflag");
            return (Criteria) this;
        }

        public Criteria andHardmodifyflagGreaterThanOrEqualTo(Byte value) {
            addCriterion("hardmodifyflag >=", value, "hardmodifyflag");
            return (Criteria) this;
        }

        public Criteria andHardmodifyflagLessThan(Byte value) {
            addCriterion("hardmodifyflag <", value, "hardmodifyflag");
            return (Criteria) this;
        }

        public Criteria andHardmodifyflagLessThanOrEqualTo(Byte value) {
            addCriterion("hardmodifyflag <=", value, "hardmodifyflag");
            return (Criteria) this;
        }

        public Criteria andHardmodifyflagIn(List<Byte> values) {
            addCriterion("hardmodifyflag in", values, "hardmodifyflag");
            return (Criteria) this;
        }

        public Criteria andHardmodifyflagNotIn(List<Byte> values) {
            addCriterion("hardmodifyflag not in", values, "hardmodifyflag");
            return (Criteria) this;
        }

        public Criteria andHardmodifyflagBetween(Byte value1, Byte value2) {
            addCriterion("hardmodifyflag between", value1, value2, "hardmodifyflag");
            return (Criteria) this;
        }

        public Criteria andHardmodifyflagNotBetween(Byte value1, Byte value2) {
            addCriterion("hardmodifyflag not between", value1, value2, "hardmodifyflag");
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