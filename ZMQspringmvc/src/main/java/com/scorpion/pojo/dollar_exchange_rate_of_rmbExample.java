package com.scorpion.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class dollar_exchange_rate_of_rmbExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dollar_exchange_rate_of_rmb
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dollar_exchange_rate_of_rmb
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dollar_exchange_rate_of_rmb
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dollar_exchange_rate_of_rmb
     *
     * @mbggenerated
     */
    public dollar_exchange_rate_of_rmbExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dollar_exchange_rate_of_rmb
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dollar_exchange_rate_of_rmb
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dollar_exchange_rate_of_rmb
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dollar_exchange_rate_of_rmb
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dollar_exchange_rate_of_rmb
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dollar_exchange_rate_of_rmb
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dollar_exchange_rate_of_rmb
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dollar_exchange_rate_of_rmb
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dollar_exchange_rate_of_rmb
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dollar_exchange_rate_of_rmb
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table dollar_exchange_rate_of_rmb
     *
     * @mbggenerated
     */
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andOpeningIsNull() {
            addCriterion("opening is null");
            return (Criteria) this;
        }

        public Criteria andOpeningIsNotNull() {
            addCriterion("opening is not null");
            return (Criteria) this;
        }

        public Criteria andOpeningEqualTo(Float value) {
            addCriterion("opening =", value, "opening");
            return (Criteria) this;
        }

        public Criteria andOpeningNotEqualTo(Float value) {
            addCriterion("opening <>", value, "opening");
            return (Criteria) this;
        }

        public Criteria andOpeningGreaterThan(Float value) {
            addCriterion("opening >", value, "opening");
            return (Criteria) this;
        }

        public Criteria andOpeningGreaterThanOrEqualTo(Float value) {
            addCriterion("opening >=", value, "opening");
            return (Criteria) this;
        }

        public Criteria andOpeningLessThan(Float value) {
            addCriterion("opening <", value, "opening");
            return (Criteria) this;
        }

        public Criteria andOpeningLessThanOrEqualTo(Float value) {
            addCriterion("opening <=", value, "opening");
            return (Criteria) this;
        }

        public Criteria andOpeningIn(List<Float> values) {
            addCriterion("opening in", values, "opening");
            return (Criteria) this;
        }

        public Criteria andOpeningNotIn(List<Float> values) {
            addCriterion("opening not in", values, "opening");
            return (Criteria) this;
        }

        public Criteria andOpeningBetween(Float value1, Float value2) {
            addCriterion("opening between", value1, value2, "opening");
            return (Criteria) this;
        }

        public Criteria andOpeningNotBetween(Float value1, Float value2) {
            addCriterion("opening not between", value1, value2, "opening");
            return (Criteria) this;
        }

        public Criteria andPeakIsNull() {
            addCriterion("peak is null");
            return (Criteria) this;
        }

        public Criteria andPeakIsNotNull() {
            addCriterion("peak is not null");
            return (Criteria) this;
        }

        public Criteria andPeakEqualTo(Float value) {
            addCriterion("peak =", value, "peak");
            return (Criteria) this;
        }

        public Criteria andPeakNotEqualTo(Float value) {
            addCriterion("peak <>", value, "peak");
            return (Criteria) this;
        }

        public Criteria andPeakGreaterThan(Float value) {
            addCriterion("peak >", value, "peak");
            return (Criteria) this;
        }

        public Criteria andPeakGreaterThanOrEqualTo(Float value) {
            addCriterion("peak >=", value, "peak");
            return (Criteria) this;
        }

        public Criteria andPeakLessThan(Float value) {
            addCriterion("peak <", value, "peak");
            return (Criteria) this;
        }

        public Criteria andPeakLessThanOrEqualTo(Float value) {
            addCriterion("peak <=", value, "peak");
            return (Criteria) this;
        }

        public Criteria andPeakIn(List<Float> values) {
            addCriterion("peak in", values, "peak");
            return (Criteria) this;
        }

        public Criteria andPeakNotIn(List<Float> values) {
            addCriterion("peak not in", values, "peak");
            return (Criteria) this;
        }

        public Criteria andPeakBetween(Float value1, Float value2) {
            addCriterion("peak between", value1, value2, "peak");
            return (Criteria) this;
        }

        public Criteria andPeakNotBetween(Float value1, Float value2) {
            addCriterion("peak not between", value1, value2, "peak");
            return (Criteria) this;
        }

        public Criteria andLowestIsNull() {
            addCriterion("lowest is null");
            return (Criteria) this;
        }

        public Criteria andLowestIsNotNull() {
            addCriterion("lowest is not null");
            return (Criteria) this;
        }

        public Criteria andLowestEqualTo(Float value) {
            addCriterion("lowest =", value, "lowest");
            return (Criteria) this;
        }

        public Criteria andLowestNotEqualTo(Float value) {
            addCriterion("lowest <>", value, "lowest");
            return (Criteria) this;
        }

        public Criteria andLowestGreaterThan(Float value) {
            addCriterion("lowest >", value, "lowest");
            return (Criteria) this;
        }

        public Criteria andLowestGreaterThanOrEqualTo(Float value) {
            addCriterion("lowest >=", value, "lowest");
            return (Criteria) this;
        }

        public Criteria andLowestLessThan(Float value) {
            addCriterion("lowest <", value, "lowest");
            return (Criteria) this;
        }

        public Criteria andLowestLessThanOrEqualTo(Float value) {
            addCriterion("lowest <=", value, "lowest");
            return (Criteria) this;
        }

        public Criteria andLowestIn(List<Float> values) {
            addCriterion("lowest in", values, "lowest");
            return (Criteria) this;
        }

        public Criteria andLowestNotIn(List<Float> values) {
            addCriterion("lowest not in", values, "lowest");
            return (Criteria) this;
        }

        public Criteria andLowestBetween(Float value1, Float value2) {
            addCriterion("lowest between", value1, value2, "lowest");
            return (Criteria) this;
        }

        public Criteria andLowestNotBetween(Float value1, Float value2) {
            addCriterion("lowest not between", value1, value2, "lowest");
            return (Criteria) this;
        }

        public Criteria andSettlementIsNull() {
            addCriterion("settlement is null");
            return (Criteria) this;
        }

        public Criteria andSettlementIsNotNull() {
            addCriterion("settlement is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementEqualTo(Float value) {
            addCriterion("settlement =", value, "settlement");
            return (Criteria) this;
        }

        public Criteria andSettlementNotEqualTo(Float value) {
            addCriterion("settlement <>", value, "settlement");
            return (Criteria) this;
        }

        public Criteria andSettlementGreaterThan(Float value) {
            addCriterion("settlement >", value, "settlement");
            return (Criteria) this;
        }

        public Criteria andSettlementGreaterThanOrEqualTo(Float value) {
            addCriterion("settlement >=", value, "settlement");
            return (Criteria) this;
        }

        public Criteria andSettlementLessThan(Float value) {
            addCriterion("settlement <", value, "settlement");
            return (Criteria) this;
        }

        public Criteria andSettlementLessThanOrEqualTo(Float value) {
            addCriterion("settlement <=", value, "settlement");
            return (Criteria) this;
        }

        public Criteria andSettlementIn(List<Float> values) {
            addCriterion("settlement in", values, "settlement");
            return (Criteria) this;
        }

        public Criteria andSettlementNotIn(List<Float> values) {
            addCriterion("settlement not in", values, "settlement");
            return (Criteria) this;
        }

        public Criteria andSettlementBetween(Float value1, Float value2) {
            addCriterion("settlement between", value1, value2, "settlement");
            return (Criteria) this;
        }

        public Criteria andSettlementNotBetween(Float value1, Float value2) {
            addCriterion("settlement not between", value1, value2, "settlement");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterionForJDBCDate("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterionForJDBCDate("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterionForJDBCDate("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterionForJDBCDate("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date not between", value1, value2, "date");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table dollar_exchange_rate_of_rmb
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table dollar_exchange_rate_of_rmb
     *
     * @mbggenerated
     */
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