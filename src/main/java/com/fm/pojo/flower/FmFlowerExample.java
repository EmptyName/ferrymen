package com.fm.pojo.flower;

import java.util.ArrayList;
import java.util.List;

public class FmFlowerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FmFlowerExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGrowthIsNull() {
            addCriterion("growth is null");
            return (Criteria) this;
        }

        public Criteria andGrowthIsNotNull() {
            addCriterion("growth is not null");
            return (Criteria) this;
        }

        public Criteria andGrowthEqualTo(Integer value) {
            addCriterion("growth =", value, "growth");
            return (Criteria) this;
        }

        public Criteria andGrowthNotEqualTo(Integer value) {
            addCriterion("growth <>", value, "growth");
            return (Criteria) this;
        }

        public Criteria andGrowthGreaterThan(Integer value) {
            addCriterion("growth >", value, "growth");
            return (Criteria) this;
        }

        public Criteria andGrowthGreaterThanOrEqualTo(Integer value) {
            addCriterion("growth >=", value, "growth");
            return (Criteria) this;
        }

        public Criteria andGrowthLessThan(Integer value) {
            addCriterion("growth <", value, "growth");
            return (Criteria) this;
        }

        public Criteria andGrowthLessThanOrEqualTo(Integer value) {
            addCriterion("growth <=", value, "growth");
            return (Criteria) this;
        }

        public Criteria andGrowthIn(List<Integer> values) {
            addCriterion("growth in", values, "growth");
            return (Criteria) this;
        }

        public Criteria andGrowthNotIn(List<Integer> values) {
            addCriterion("growth not in", values, "growth");
            return (Criteria) this;
        }

        public Criteria andGrowthBetween(Integer value1, Integer value2) {
            addCriterion("growth between", value1, value2, "growth");
            return (Criteria) this;
        }

        public Criteria andGrowthNotBetween(Integer value1, Integer value2) {
            addCriterion("growth not between", value1, value2, "growth");
            return (Criteria) this;
        }

        public Criteria andQualityIsNull() {
            addCriterion("quality is null");
            return (Criteria) this;
        }

        public Criteria andQualityIsNotNull() {
            addCriterion("quality is not null");
            return (Criteria) this;
        }

        public Criteria andQualityEqualTo(Integer value) {
            addCriterion("quality =", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotEqualTo(Integer value) {
            addCriterion("quality <>", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityGreaterThan(Integer value) {
            addCriterion("quality >", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityGreaterThanOrEqualTo(Integer value) {
            addCriterion("quality >=", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityLessThan(Integer value) {
            addCriterion("quality <", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityLessThanOrEqualTo(Integer value) {
            addCriterion("quality <=", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityIn(List<Integer> values) {
            addCriterion("quality in", values, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotIn(List<Integer> values) {
            addCriterion("quality not in", values, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityBetween(Integer value1, Integer value2) {
            addCriterion("quality between", value1, value2, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotBetween(Integer value1, Integer value2) {
            addCriterion("quality not between", value1, value2, "quality");
            return (Criteria) this;
        }

        public Criteria andThrivingIsNull() {
            addCriterion("thriving is null");
            return (Criteria) this;
        }

        public Criteria andThrivingIsNotNull() {
            addCriterion("thriving is not null");
            return (Criteria) this;
        }

        public Criteria andThrivingEqualTo(Integer value) {
            addCriterion("thriving =", value, "thriving");
            return (Criteria) this;
        }

        public Criteria andThrivingNotEqualTo(Integer value) {
            addCriterion("thriving <>", value, "thriving");
            return (Criteria) this;
        }

        public Criteria andThrivingGreaterThan(Integer value) {
            addCriterion("thriving >", value, "thriving");
            return (Criteria) this;
        }

        public Criteria andThrivingGreaterThanOrEqualTo(Integer value) {
            addCriterion("thriving >=", value, "thriving");
            return (Criteria) this;
        }

        public Criteria andThrivingLessThan(Integer value) {
            addCriterion("thriving <", value, "thriving");
            return (Criteria) this;
        }

        public Criteria andThrivingLessThanOrEqualTo(Integer value) {
            addCriterion("thriving <=", value, "thriving");
            return (Criteria) this;
        }

        public Criteria andThrivingIn(List<Integer> values) {
            addCriterion("thriving in", values, "thriving");
            return (Criteria) this;
        }

        public Criteria andThrivingNotIn(List<Integer> values) {
            addCriterion("thriving not in", values, "thriving");
            return (Criteria) this;
        }

        public Criteria andThrivingBetween(Integer value1, Integer value2) {
            addCriterion("thriving between", value1, value2, "thriving");
            return (Criteria) this;
        }

        public Criteria andThrivingNotBetween(Integer value1, Integer value2) {
            addCriterion("thriving not between", value1, value2, "thriving");
            return (Criteria) this;
        }

        public Criteria andSunshineIsNull() {
            addCriterion("sunshine is null");
            return (Criteria) this;
        }

        public Criteria andSunshineIsNotNull() {
            addCriterion("sunshine is not null");
            return (Criteria) this;
        }

        public Criteria andSunshineEqualTo(Integer value) {
            addCriterion("sunshine =", value, "sunshine");
            return (Criteria) this;
        }

        public Criteria andSunshineNotEqualTo(Integer value) {
            addCriterion("sunshine <>", value, "sunshine");
            return (Criteria) this;
        }

        public Criteria andSunshineGreaterThan(Integer value) {
            addCriterion("sunshine >", value, "sunshine");
            return (Criteria) this;
        }

        public Criteria andSunshineGreaterThanOrEqualTo(Integer value) {
            addCriterion("sunshine >=", value, "sunshine");
            return (Criteria) this;
        }

        public Criteria andSunshineLessThan(Integer value) {
            addCriterion("sunshine <", value, "sunshine");
            return (Criteria) this;
        }

        public Criteria andSunshineLessThanOrEqualTo(Integer value) {
            addCriterion("sunshine <=", value, "sunshine");
            return (Criteria) this;
        }

        public Criteria andSunshineIn(List<Integer> values) {
            addCriterion("sunshine in", values, "sunshine");
            return (Criteria) this;
        }

        public Criteria andSunshineNotIn(List<Integer> values) {
            addCriterion("sunshine not in", values, "sunshine");
            return (Criteria) this;
        }

        public Criteria andSunshineBetween(Integer value1, Integer value2) {
            addCriterion("sunshine between", value1, value2, "sunshine");
            return (Criteria) this;
        }

        public Criteria andSunshineNotBetween(Integer value1, Integer value2) {
            addCriterion("sunshine not between", value1, value2, "sunshine");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andFlowerIdIsNull() {
            addCriterion("flower_id is null");
            return (Criteria) this;
        }

        public Criteria andFlowerIdIsNotNull() {
            addCriterion("flower_id is not null");
            return (Criteria) this;
        }

        public Criteria andFlowerIdEqualTo(Long value) {
            addCriterion("flower_id =", value, "flowerId");
            return (Criteria) this;
        }

        public Criteria andFlowerIdNotEqualTo(Long value) {
            addCriterion("flower_id <>", value, "flowerId");
            return (Criteria) this;
        }

        public Criteria andFlowerIdGreaterThan(Long value) {
            addCriterion("flower_id >", value, "flowerId");
            return (Criteria) this;
        }

        public Criteria andFlowerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("flower_id >=", value, "flowerId");
            return (Criteria) this;
        }

        public Criteria andFlowerIdLessThan(Long value) {
            addCriterion("flower_id <", value, "flowerId");
            return (Criteria) this;
        }

        public Criteria andFlowerIdLessThanOrEqualTo(Long value) {
            addCriterion("flower_id <=", value, "flowerId");
            return (Criteria) this;
        }

        public Criteria andFlowerIdIn(List<Long> values) {
            addCriterion("flower_id in", values, "flowerId");
            return (Criteria) this;
        }

        public Criteria andFlowerIdNotIn(List<Long> values) {
            addCriterion("flower_id not in", values, "flowerId");
            return (Criteria) this;
        }

        public Criteria andFlowerIdBetween(Long value1, Long value2) {
            addCriterion("flower_id between", value1, value2, "flowerId");
            return (Criteria) this;
        }

        public Criteria andFlowerIdNotBetween(Long value1, Long value2) {
            addCriterion("flower_id not between", value1, value2, "flowerId");
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