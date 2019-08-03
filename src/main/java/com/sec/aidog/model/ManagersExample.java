package com.sec.aidog.model;

import java.util.ArrayList;
import java.util.List;

public class ManagersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ManagersExample() {
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

        public Criteria andManageridIsNull() {
            addCriterion("managerid is null");
            return (Criteria) this;
        }

        public Criteria andManageridIsNotNull() {
            addCriterion("managerid is not null");
            return (Criteria) this;
        }

        public Criteria andManageridEqualTo(Integer value) {
            addCriterion("managerid =", value, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridNotEqualTo(Integer value) {
            addCriterion("managerid <>", value, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridGreaterThan(Integer value) {
            addCriterion("managerid >", value, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridGreaterThanOrEqualTo(Integer value) {
            addCriterion("managerid >=", value, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridLessThan(Integer value) {
            addCriterion("managerid <", value, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridLessThanOrEqualTo(Integer value) {
            addCriterion("managerid <=", value, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridIn(List<Integer> values) {
            addCriterion("managerid in", values, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridNotIn(List<Integer> values) {
            addCriterion("managerid not in", values, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridBetween(Integer value1, Integer value2) {
            addCriterion("managerid between", value1, value2, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridNotBetween(Integer value1, Integer value2) {
            addCriterion("managerid not between", value1, value2, "managerid");
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

        public Criteria andManagernameIsNull() {
            addCriterion("managername is null");
            return (Criteria) this;
        }

        public Criteria andManagernameIsNotNull() {
            addCriterion("managername is not null");
            return (Criteria) this;
        }

        public Criteria andManagernameEqualTo(String value) {
            addCriterion("managername =", value, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameNotEqualTo(String value) {
            addCriterion("managername <>", value, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameGreaterThan(String value) {
            addCriterion("managername >", value, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameGreaterThanOrEqualTo(String value) {
            addCriterion("managername >=", value, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameLessThan(String value) {
            addCriterion("managername <", value, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameLessThanOrEqualTo(String value) {
            addCriterion("managername <=", value, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameLike(String value) {
            addCriterion("managername like", value, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameNotLike(String value) {
            addCriterion("managername not like", value, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameIn(List<String> values) {
            addCriterion("managername in", values, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameNotIn(List<String> values) {
            addCriterion("managername not in", values, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameBetween(String value1, String value2) {
            addCriterion("managername between", value1, value2, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameNotBetween(String value1, String value2) {
            addCriterion("managername not between", value1, value2, "managername");
            return (Criteria) this;
        }

        public Criteria andLogintimeIsNull() {
            addCriterion("logintime is null");
            return (Criteria) this;
        }

        public Criteria andLogintimeIsNotNull() {
            addCriterion("logintime is not null");
            return (Criteria) this;
        }

        public Criteria andLogintimeEqualTo(String value) {
            addCriterion("logintime =", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeNotEqualTo(String value) {
            addCriterion("logintime <>", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeGreaterThan(String value) {
            addCriterion("logintime >", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeGreaterThanOrEqualTo(String value) {
            addCriterion("logintime >=", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeLessThan(String value) {
            addCriterion("logintime <", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeLessThanOrEqualTo(String value) {
            addCriterion("logintime <=", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeLike(String value) {
            addCriterion("logintime like", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeNotLike(String value) {
            addCriterion("logintime not like", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeIn(List<String> values) {
            addCriterion("logintime in", values, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeNotIn(List<String> values) {
            addCriterion("logintime not in", values, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeBetween(String value1, String value2) {
            addCriterion("logintime between", value1, value2, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeNotBetween(String value1, String value2) {
            addCriterion("logintime not between", value1, value2, "logintime");
            return (Criteria) this;
        }

        public Criteria andManagertelIsNull() {
            addCriterion("managertel is null");
            return (Criteria) this;
        }

        public Criteria andManagertelIsNotNull() {
            addCriterion("managertel is not null");
            return (Criteria) this;
        }

        public Criteria andManagertelEqualTo(String value) {
            addCriterion("managertel =", value, "managertel");
            return (Criteria) this;
        }

        public Criteria andManagertelNotEqualTo(String value) {
            addCriterion("managertel <>", value, "managertel");
            return (Criteria) this;
        }

        public Criteria andManagertelGreaterThan(String value) {
            addCriterion("managertel >", value, "managertel");
            return (Criteria) this;
        }

        public Criteria andManagertelGreaterThanOrEqualTo(String value) {
            addCriterion("managertel >=", value, "managertel");
            return (Criteria) this;
        }

        public Criteria andManagertelLessThan(String value) {
            addCriterion("managertel <", value, "managertel");
            return (Criteria) this;
        }

        public Criteria andManagertelLessThanOrEqualTo(String value) {
            addCriterion("managertel <=", value, "managertel");
            return (Criteria) this;
        }

        public Criteria andManagertelLike(String value) {
            addCriterion("managertel like", value, "managertel");
            return (Criteria) this;
        }

        public Criteria andManagertelNotLike(String value) {
            addCriterion("managertel not like", value, "managertel");
            return (Criteria) this;
        }

        public Criteria andManagertelIn(List<String> values) {
            addCriterion("managertel in", values, "managertel");
            return (Criteria) this;
        }

        public Criteria andManagertelNotIn(List<String> values) {
            addCriterion("managertel not in", values, "managertel");
            return (Criteria) this;
        }

        public Criteria andManagertelBetween(String value1, String value2) {
            addCriterion("managertel between", value1, value2, "managertel");
            return (Criteria) this;
        }

        public Criteria andManagertelNotBetween(String value1, String value2) {
            addCriterion("managertel not between", value1, value2, "managertel");
            return (Criteria) this;
        }

        public Criteria andManagerphoneIsNull() {
            addCriterion("managerphone is null");
            return (Criteria) this;
        }

        public Criteria andManagerphoneIsNotNull() {
            addCriterion("managerphone is not null");
            return (Criteria) this;
        }

        public Criteria andManagerphoneEqualTo(String value) {
            addCriterion("managerphone =", value, "managerphone");
            return (Criteria) this;
        }

        public Criteria andManagerphoneNotEqualTo(String value) {
            addCriterion("managerphone <>", value, "managerphone");
            return (Criteria) this;
        }

        public Criteria andManagerphoneGreaterThan(String value) {
            addCriterion("managerphone >", value, "managerphone");
            return (Criteria) this;
        }

        public Criteria andManagerphoneGreaterThanOrEqualTo(String value) {
            addCriterion("managerphone >=", value, "managerphone");
            return (Criteria) this;
        }

        public Criteria andManagerphoneLessThan(String value) {
            addCriterion("managerphone <", value, "managerphone");
            return (Criteria) this;
        }

        public Criteria andManagerphoneLessThanOrEqualTo(String value) {
            addCriterion("managerphone <=", value, "managerphone");
            return (Criteria) this;
        }

        public Criteria andManagerphoneLike(String value) {
            addCriterion("managerphone like", value, "managerphone");
            return (Criteria) this;
        }

        public Criteria andManagerphoneNotLike(String value) {
            addCriterion("managerphone not like", value, "managerphone");
            return (Criteria) this;
        }

        public Criteria andManagerphoneIn(List<String> values) {
            addCriterion("managerphone in", values, "managerphone");
            return (Criteria) this;
        }

        public Criteria andManagerphoneNotIn(List<String> values) {
            addCriterion("managerphone not in", values, "managerphone");
            return (Criteria) this;
        }

        public Criteria andManagerphoneBetween(String value1, String value2) {
            addCriterion("managerphone between", value1, value2, "managerphone");
            return (Criteria) this;
        }

        public Criteria andManagerphoneNotBetween(String value1, String value2) {
            addCriterion("managerphone not between", value1, value2, "managerphone");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPrivilegelevelIsNull() {
            addCriterion("privilegelevel is null");
            return (Criteria) this;
        }

        public Criteria andPrivilegelevelIsNotNull() {
            addCriterion("privilegelevel is not null");
            return (Criteria) this;
        }

        public Criteria andPrivilegelevelEqualTo(Integer value) {
            addCriterion("privilegelevel =", value, "privilegelevel");
            return (Criteria) this;
        }

        public Criteria andPrivilegelevelNotEqualTo(Integer value) {
            addCriterion("privilegelevel <>", value, "privilegelevel");
            return (Criteria) this;
        }

        public Criteria andPrivilegelevelGreaterThan(Integer value) {
            addCriterion("privilegelevel >", value, "privilegelevel");
            return (Criteria) this;
        }

        public Criteria andPrivilegelevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("privilegelevel >=", value, "privilegelevel");
            return (Criteria) this;
        }

        public Criteria andPrivilegelevelLessThan(Integer value) {
            addCriterion("privilegelevel <", value, "privilegelevel");
            return (Criteria) this;
        }

        public Criteria andPrivilegelevelLessThanOrEqualTo(Integer value) {
            addCriterion("privilegelevel <=", value, "privilegelevel");
            return (Criteria) this;
        }

        public Criteria andPrivilegelevelIn(List<Integer> values) {
            addCriterion("privilegelevel in", values, "privilegelevel");
            return (Criteria) this;
        }

        public Criteria andPrivilegelevelNotIn(List<Integer> values) {
            addCriterion("privilegelevel not in", values, "privilegelevel");
            return (Criteria) this;
        }

        public Criteria andPrivilegelevelBetween(Integer value1, Integer value2) {
            addCriterion("privilegelevel between", value1, value2, "privilegelevel");
            return (Criteria) this;
        }

        public Criteria andPrivilegelevelNotBetween(Integer value1, Integer value2) {
            addCriterion("privilegelevel not between", value1, value2, "privilegelevel");
            return (Criteria) this;
        }

        public Criteria andPrivilegedetailIsNull() {
            addCriterion("privilegedetail is null");
            return (Criteria) this;
        }

        public Criteria andPrivilegedetailIsNotNull() {
            addCriterion("privilegedetail is not null");
            return (Criteria) this;
        }

        public Criteria andPrivilegedetailEqualTo(String value) {
            addCriterion("privilegedetail =", value, "privilegedetail");
            return (Criteria) this;
        }

        public Criteria andPrivilegedetailNotEqualTo(String value) {
            addCriterion("privilegedetail <>", value, "privilegedetail");
            return (Criteria) this;
        }

        public Criteria andPrivilegedetailGreaterThan(String value) {
            addCriterion("privilegedetail >", value, "privilegedetail");
            return (Criteria) this;
        }

        public Criteria andPrivilegedetailGreaterThanOrEqualTo(String value) {
            addCriterion("privilegedetail >=", value, "privilegedetail");
            return (Criteria) this;
        }

        public Criteria andPrivilegedetailLessThan(String value) {
            addCriterion("privilegedetail <", value, "privilegedetail");
            return (Criteria) this;
        }

        public Criteria andPrivilegedetailLessThanOrEqualTo(String value) {
            addCriterion("privilegedetail <=", value, "privilegedetail");
            return (Criteria) this;
        }

        public Criteria andPrivilegedetailLike(String value) {
            addCriterion("privilegedetail like", value, "privilegedetail");
            return (Criteria) this;
        }

        public Criteria andPrivilegedetailNotLike(String value) {
            addCriterion("privilegedetail not like", value, "privilegedetail");
            return (Criteria) this;
        }

        public Criteria andPrivilegedetailIn(List<String> values) {
            addCriterion("privilegedetail in", values, "privilegedetail");
            return (Criteria) this;
        }

        public Criteria andPrivilegedetailNotIn(List<String> values) {
            addCriterion("privilegedetail not in", values, "privilegedetail");
            return (Criteria) this;
        }

        public Criteria andPrivilegedetailBetween(String value1, String value2) {
            addCriterion("privilegedetail between", value1, value2, "privilegedetail");
            return (Criteria) this;
        }

        public Criteria andPrivilegedetailNotBetween(String value1, String value2) {
            addCriterion("privilegedetail not between", value1, value2, "privilegedetail");
            return (Criteria) this;
        }

        public Criteria andManagerstatusIsNull() {
            addCriterion("managerstatus is null");
            return (Criteria) this;
        }

        public Criteria andManagerstatusIsNotNull() {
            addCriterion("managerstatus is not null");
            return (Criteria) this;
        }

        public Criteria andManagerstatusEqualTo(Integer value) {
            addCriterion("managerstatus =", value, "managerstatus");
            return (Criteria) this;
        }

        public Criteria andManagerstatusNotEqualTo(Integer value) {
            addCriterion("managerstatus <>", value, "managerstatus");
            return (Criteria) this;
        }

        public Criteria andManagerstatusGreaterThan(Integer value) {
            addCriterion("managerstatus >", value, "managerstatus");
            return (Criteria) this;
        }

        public Criteria andManagerstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("managerstatus >=", value, "managerstatus");
            return (Criteria) this;
        }

        public Criteria andManagerstatusLessThan(Integer value) {
            addCriterion("managerstatus <", value, "managerstatus");
            return (Criteria) this;
        }

        public Criteria andManagerstatusLessThanOrEqualTo(Integer value) {
            addCriterion("managerstatus <=", value, "managerstatus");
            return (Criteria) this;
        }

        public Criteria andManagerstatusIn(List<Integer> values) {
            addCriterion("managerstatus in", values, "managerstatus");
            return (Criteria) this;
        }

        public Criteria andManagerstatusNotIn(List<Integer> values) {
            addCriterion("managerstatus not in", values, "managerstatus");
            return (Criteria) this;
        }

        public Criteria andManagerstatusBetween(Integer value1, Integer value2) {
            addCriterion("managerstatus between", value1, value2, "managerstatus");
            return (Criteria) this;
        }

        public Criteria andManagerstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("managerstatus not between", value1, value2, "managerstatus");
            return (Criteria) this;
        }

        public Criteria andManagerretirtimeIsNull() {
            addCriterion("managerretirtime is null");
            return (Criteria) this;
        }

        public Criteria andManagerretirtimeIsNotNull() {
            addCriterion("managerretirtime is not null");
            return (Criteria) this;
        }

        public Criteria andManagerretirtimeEqualTo(String value) {
            addCriterion("managerretirtime =", value, "managerretirtime");
            return (Criteria) this;
        }

        public Criteria andManagerretirtimeNotEqualTo(String value) {
            addCriterion("managerretirtime <>", value, "managerretirtime");
            return (Criteria) this;
        }

        public Criteria andManagerretirtimeGreaterThan(String value) {
            addCriterion("managerretirtime >", value, "managerretirtime");
            return (Criteria) this;
        }

        public Criteria andManagerretirtimeGreaterThanOrEqualTo(String value) {
            addCriterion("managerretirtime >=", value, "managerretirtime");
            return (Criteria) this;
        }

        public Criteria andManagerretirtimeLessThan(String value) {
            addCriterion("managerretirtime <", value, "managerretirtime");
            return (Criteria) this;
        }

        public Criteria andManagerretirtimeLessThanOrEqualTo(String value) {
            addCriterion("managerretirtime <=", value, "managerretirtime");
            return (Criteria) this;
        }

        public Criteria andManagerretirtimeLike(String value) {
            addCriterion("managerretirtime like", value, "managerretirtime");
            return (Criteria) this;
        }

        public Criteria andManagerretirtimeNotLike(String value) {
            addCriterion("managerretirtime not like", value, "managerretirtime");
            return (Criteria) this;
        }

        public Criteria andManagerretirtimeIn(List<String> values) {
            addCriterion("managerretirtime in", values, "managerretirtime");
            return (Criteria) this;
        }

        public Criteria andManagerretirtimeNotIn(List<String> values) {
            addCriterion("managerretirtime not in", values, "managerretirtime");
            return (Criteria) this;
        }

        public Criteria andManagerretirtimeBetween(String value1, String value2) {
            addCriterion("managerretirtime between", value1, value2, "managerretirtime");
            return (Criteria) this;
        }

        public Criteria andManagerretirtimeNotBetween(String value1, String value2) {
            addCriterion("managerretirtime not between", value1, value2, "managerretirtime");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCountyIsNull() {
            addCriterion("county is null");
            return (Criteria) this;
        }

        public Criteria andCountyIsNotNull() {
            addCriterion("county is not null");
            return (Criteria) this;
        }

        public Criteria andCountyEqualTo(String value) {
            addCriterion("county =", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotEqualTo(String value) {
            addCriterion("county <>", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyGreaterThan(String value) {
            addCriterion("county >", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyGreaterThanOrEqualTo(String value) {
            addCriterion("county >=", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLessThan(String value) {
            addCriterion("county <", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLessThanOrEqualTo(String value) {
            addCriterion("county <=", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLike(String value) {
            addCriterion("county like", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotLike(String value) {
            addCriterion("county not like", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyIn(List<String> values) {
            addCriterion("county in", values, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotIn(List<String> values) {
            addCriterion("county not in", values, "county");
            return (Criteria) this;
        }

        public Criteria andCountyBetween(String value1, String value2) {
            addCriterion("county between", value1, value2, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotBetween(String value1, String value2) {
            addCriterion("county not between", value1, value2, "county");
            return (Criteria) this;
        }

        public Criteria andOfficecallIsNull() {
            addCriterion("officecall is null");
            return (Criteria) this;
        }

        public Criteria andOfficecallIsNotNull() {
            addCriterion("officecall is not null");
            return (Criteria) this;
        }

        public Criteria andOfficecallEqualTo(String value) {
            addCriterion("officecall =", value, "officecall");
            return (Criteria) this;
        }

        public Criteria andOfficecallNotEqualTo(String value) {
            addCriterion("officecall <>", value, "officecall");
            return (Criteria) this;
        }

        public Criteria andOfficecallGreaterThan(String value) {
            addCriterion("officecall >", value, "officecall");
            return (Criteria) this;
        }

        public Criteria andOfficecallGreaterThanOrEqualTo(String value) {
            addCriterion("officecall >=", value, "officecall");
            return (Criteria) this;
        }

        public Criteria andOfficecallLessThan(String value) {
            addCriterion("officecall <", value, "officecall");
            return (Criteria) this;
        }

        public Criteria andOfficecallLessThanOrEqualTo(String value) {
            addCriterion("officecall <=", value, "officecall");
            return (Criteria) this;
        }

        public Criteria andOfficecallLike(String value) {
            addCriterion("officecall like", value, "officecall");
            return (Criteria) this;
        }

        public Criteria andOfficecallNotLike(String value) {
            addCriterion("officecall not like", value, "officecall");
            return (Criteria) this;
        }

        public Criteria andOfficecallIn(List<String> values) {
            addCriterion("officecall in", values, "officecall");
            return (Criteria) this;
        }

        public Criteria andOfficecallNotIn(List<String> values) {
            addCriterion("officecall not in", values, "officecall");
            return (Criteria) this;
        }

        public Criteria andOfficecallBetween(String value1, String value2) {
            addCriterion("officecall between", value1, value2, "officecall");
            return (Criteria) this;
        }

        public Criteria andOfficecallNotBetween(String value1, String value2) {
            addCriterion("officecall not between", value1, value2, "officecall");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andUpusernameIsNull() {
            addCriterion("upusername is null");
            return (Criteria) this;
        }

        public Criteria andUpusernameIsNotNull() {
            addCriterion("upusername is not null");
            return (Criteria) this;
        }

        public Criteria andUpusernameEqualTo(String value) {
            addCriterion("upusername =", value, "upusername");
            return (Criteria) this;
        }

        public Criteria andUpusernameNotEqualTo(String value) {
            addCriterion("upusername <>", value, "upusername");
            return (Criteria) this;
        }

        public Criteria andUpusernameGreaterThan(String value) {
            addCriterion("upusername >", value, "upusername");
            return (Criteria) this;
        }

        public Criteria andUpusernameGreaterThanOrEqualTo(String value) {
            addCriterion("upusername >=", value, "upusername");
            return (Criteria) this;
        }

        public Criteria andUpusernameLessThan(String value) {
            addCriterion("upusername <", value, "upusername");
            return (Criteria) this;
        }

        public Criteria andUpusernameLessThanOrEqualTo(String value) {
            addCriterion("upusername <=", value, "upusername");
            return (Criteria) this;
        }

        public Criteria andUpusernameLike(String value) {
            addCriterion("upusername like", value, "upusername");
            return (Criteria) this;
        }

        public Criteria andUpusernameNotLike(String value) {
            addCriterion("upusername not like", value, "upusername");
            return (Criteria) this;
        }

        public Criteria andUpusernameIn(List<String> values) {
            addCriterion("upusername in", values, "upusername");
            return (Criteria) this;
        }

        public Criteria andUpusernameNotIn(List<String> values) {
            addCriterion("upusername not in", values, "upusername");
            return (Criteria) this;
        }

        public Criteria andUpusernameBetween(String value1, String value2) {
            addCriterion("upusername between", value1, value2, "upusername");
            return (Criteria) this;
        }

        public Criteria andUpusernameNotBetween(String value1, String value2) {
            addCriterion("upusername not between", value1, value2, "upusername");
            return (Criteria) this;
        }

        public Criteria andVillageIsNull() {
            addCriterion("village is null");
            return (Criteria) this;
        }

        public Criteria andVillageIsNotNull() {
            addCriterion("village is not null");
            return (Criteria) this;
        }

        public Criteria andVillageEqualTo(String value) {
            addCriterion("village =", value, "village");
            return (Criteria) this;
        }

        public Criteria andVillageNotEqualTo(String value) {
            addCriterion("village <>", value, "village");
            return (Criteria) this;
        }

        public Criteria andVillageGreaterThan(String value) {
            addCriterion("village >", value, "village");
            return (Criteria) this;
        }

        public Criteria andVillageGreaterThanOrEqualTo(String value) {
            addCriterion("village >=", value, "village");
            return (Criteria) this;
        }

        public Criteria andVillageLessThan(String value) {
            addCriterion("village <", value, "village");
            return (Criteria) this;
        }

        public Criteria andVillageLessThanOrEqualTo(String value) {
            addCriterion("village <=", value, "village");
            return (Criteria) this;
        }

        public Criteria andVillageLike(String value) {
            addCriterion("village like", value, "village");
            return (Criteria) this;
        }

        public Criteria andVillageNotLike(String value) {
            addCriterion("village not like", value, "village");
            return (Criteria) this;
        }

        public Criteria andVillageIn(List<String> values) {
            addCriterion("village in", values, "village");
            return (Criteria) this;
        }

        public Criteria andVillageNotIn(List<String> values) {
            addCriterion("village not in", values, "village");
            return (Criteria) this;
        }

        public Criteria andVillageBetween(String value1, String value2) {
            addCriterion("village between", value1, value2, "village");
            return (Criteria) this;
        }

        public Criteria andVillageNotBetween(String value1, String value2) {
            addCriterion("village not between", value1, value2, "village");
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

        public Criteria andWorkplaceIsNull() {
            addCriterion("workplace is null");
            return (Criteria) this;
        }

        public Criteria andWorkplaceIsNotNull() {
            addCriterion("workplace is not null");
            return (Criteria) this;
        }

        public Criteria andWorkplaceEqualTo(String value) {
            addCriterion("workplace =", value, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceNotEqualTo(String value) {
            addCriterion("workplace <>", value, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceGreaterThan(String value) {
            addCriterion("workplace >", value, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceGreaterThanOrEqualTo(String value) {
            addCriterion("workplace >=", value, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceLessThan(String value) {
            addCriterion("workplace <", value, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceLessThanOrEqualTo(String value) {
            addCriterion("workplace <=", value, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceLike(String value) {
            addCriterion("workplace like", value, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceNotLike(String value) {
            addCriterion("workplace not like", value, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceIn(List<String> values) {
            addCriterion("workplace in", values, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceNotIn(List<String> values) {
            addCriterion("workplace not in", values, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceBetween(String value1, String value2) {
            addCriterion("workplace between", value1, value2, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceNotBetween(String value1, String value2) {
            addCriterion("workplace not between", value1, value2, "workplace");
            return (Criteria) this;
        }

        public Criteria andChargehamletIsNull() {
            addCriterion("chargehamlet is null");
            return (Criteria) this;
        }

        public Criteria andChargehamletIsNotNull() {
            addCriterion("chargehamlet is not null");
            return (Criteria) this;
        }

        public Criteria andChargehamletEqualTo(String value) {
            addCriterion("chargehamlet =", value, "chargehamlet");
            return (Criteria) this;
        }

        public Criteria andChargehamletNotEqualTo(String value) {
            addCriterion("chargehamlet <>", value, "chargehamlet");
            return (Criteria) this;
        }

        public Criteria andChargehamletGreaterThan(String value) {
            addCriterion("chargehamlet >", value, "chargehamlet");
            return (Criteria) this;
        }

        public Criteria andChargehamletGreaterThanOrEqualTo(String value) {
            addCriterion("chargehamlet >=", value, "chargehamlet");
            return (Criteria) this;
        }

        public Criteria andChargehamletLessThan(String value) {
            addCriterion("chargehamlet <", value, "chargehamlet");
            return (Criteria) this;
        }

        public Criteria andChargehamletLessThanOrEqualTo(String value) {
            addCriterion("chargehamlet <=", value, "chargehamlet");
            return (Criteria) this;
        }

        public Criteria andChargehamletLike(String value) {
            addCriterion("chargehamlet like", value, "chargehamlet");
            return (Criteria) this;
        }

        public Criteria andChargehamletNotLike(String value) {
            addCriterion("chargehamlet not like", value, "chargehamlet");
            return (Criteria) this;
        }

        public Criteria andChargehamletIn(List<String> values) {
            addCriterion("chargehamlet in", values, "chargehamlet");
            return (Criteria) this;
        }

        public Criteria andChargehamletNotIn(List<String> values) {
            addCriterion("chargehamlet not in", values, "chargehamlet");
            return (Criteria) this;
        }

        public Criteria andChargehamletBetween(String value1, String value2) {
            addCriterion("chargehamlet between", value1, value2, "chargehamlet");
            return (Criteria) this;
        }

        public Criteria andChargehamletNotBetween(String value1, String value2) {
            addCriterion("chargehamlet not between", value1, value2, "chargehamlet");
            return (Criteria) this;
        }

        public Criteria andManageridentityIsNull() {
            addCriterion("manageridentity is null");
            return (Criteria) this;
        }

        public Criteria andManageridentityIsNotNull() {
            addCriterion("manageridentity is not null");
            return (Criteria) this;
        }

        public Criteria andManageridentityEqualTo(String value) {
            addCriterion("manageridentity =", value, "manageridentity");
            return (Criteria) this;
        }

        public Criteria andManageridentityNotEqualTo(String value) {
            addCriterion("manageridentity <>", value, "manageridentity");
            return (Criteria) this;
        }

        public Criteria andManageridentityGreaterThan(String value) {
            addCriterion("manageridentity >", value, "manageridentity");
            return (Criteria) this;
        }

        public Criteria andManageridentityGreaterThanOrEqualTo(String value) {
            addCriterion("manageridentity >=", value, "manageridentity");
            return (Criteria) this;
        }

        public Criteria andManageridentityLessThan(String value) {
            addCriterion("manageridentity <", value, "manageridentity");
            return (Criteria) this;
        }

        public Criteria andManageridentityLessThanOrEqualTo(String value) {
            addCriterion("manageridentity <=", value, "manageridentity");
            return (Criteria) this;
        }

        public Criteria andManageridentityLike(String value) {
            addCriterion("manageridentity like", value, "manageridentity");
            return (Criteria) this;
        }

        public Criteria andManageridentityNotLike(String value) {
            addCriterion("manageridentity not like", value, "manageridentity");
            return (Criteria) this;
        }

        public Criteria andManageridentityIn(List<String> values) {
            addCriterion("manageridentity in", values, "manageridentity");
            return (Criteria) this;
        }

        public Criteria andManageridentityNotIn(List<String> values) {
            addCriterion("manageridentity not in", values, "manageridentity");
            return (Criteria) this;
        }

        public Criteria andManageridentityBetween(String value1, String value2) {
            addCriterion("manageridentity between", value1, value2, "manageridentity");
            return (Criteria) this;
        }

        public Criteria andManageridentityNotBetween(String value1, String value2) {
            addCriterion("manageridentity not between", value1, value2, "manageridentity");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
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

        public Criteria andDistrictcodeEqualTo(Long value) {
            addCriterion("districtcode =", value, "districtcode");
            return (Criteria) this;
        }

        public Criteria andDistrictcodeNotEqualTo(Long value) {
            addCriterion("districtcode <>", value, "districtcode");
            return (Criteria) this;
        }

        public Criteria andDistrictcodeGreaterThan(Long value) {
            addCriterion("districtcode >", value, "districtcode");
            return (Criteria) this;
        }

        public Criteria andDistrictcodeGreaterThanOrEqualTo(Long value) {
            addCriterion("districtcode >=", value, "districtcode");
            return (Criteria) this;
        }

        public Criteria andDistrictcodeLessThan(Long value) {
            addCriterion("districtcode <", value, "districtcode");
            return (Criteria) this;
        }

        public Criteria andDistrictcodeLessThanOrEqualTo(Long value) {
            addCriterion("districtcode <=", value, "districtcode");
            return (Criteria) this;
        }

        public Criteria andDistrictcodeIn(List<Long> values) {
            addCriterion("districtcode in", values, "districtcode");
            return (Criteria) this;
        }

        public Criteria andDistrictcodeNotIn(List<Long> values) {
            addCriterion("districtcode not in", values, "districtcode");
            return (Criteria) this;
        }

        public Criteria andDistrictcodeBetween(Long value1, Long value2) {
            addCriterion("districtcode between", value1, value2, "districtcode");
            return (Criteria) this;
        }

        public Criteria andDistrictcodeNotBetween(Long value1, Long value2) {
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