package com.wtf.service.entity.po;import java.util.ArrayList;import java.util.Date;import java.util.List;public class RepairStatusExample {	protected String orderByClause;	protected boolean distinct;	protected List<Criteria> oredCriteria;	public RepairStatusExample() {		oredCriteria = new ArrayList<Criteria>();	}	public void setOrderByClause(String orderByClause) {		this.orderByClause = orderByClause;	}	public String getOrderByClause() {		return orderByClause;	}	public void setDistinct(boolean distinct) {		this.distinct = distinct;	}	public boolean isDistinct() {		return distinct;	}	public List<Criteria> getOredCriteria() {		return oredCriteria;	}	public void or(Criteria criteria) {		oredCriteria.add(criteria);	}	public Criteria or() {		Criteria criteria = createCriteriaInternal();		oredCriteria.add(criteria);		return criteria;	}	public Criteria createCriteria() {		Criteria criteria = createCriteriaInternal();		if (oredCriteria.size() == 0) {			oredCriteria.add(criteria);		}		return criteria;	}	protected Criteria createCriteriaInternal() {		Criteria criteria = new Criteria();		return criteria;	}	public void clear() {		oredCriteria.clear();		orderByClause = null;		distinct = false;	}	protected abstract static class GeneratedCriteria {		protected List<Criterion> criteria;		protected GeneratedCriteria() {			super();			criteria = new ArrayList<Criterion>();		}		public boolean isValid() {			return criteria.size() > 0;		}		public List<Criterion> getAllCriteria() {			return criteria;		}		public List<Criterion> getCriteria() {			return criteria;		}		protected void addCriterion(String condition) {			if (condition == null) {				throw new RuntimeException("Value for condition cannot be null");			}			criteria.add(new Criterion(condition));		}		protected void addCriterion(String condition, Object value, String property) {			if (value == null) {				throw new RuntimeException("Value for " + property + " cannot be null");			}			criteria.add(new Criterion(condition, value));		}		protected void addCriterion(String condition, Object value1, Object value2, String property) {			if (value1 == null || value2 == null) {				throw new RuntimeException("Between values for " + property + " cannot be null");			}			criteria.add(new Criterion(condition, value1, value2));		}		public Criteria andIdIsNull() {			addCriterion("id is null");			return (Criteria) this;		}		public Criteria andIdIsNotNull() {			addCriterion("id is not null");			return (Criteria) this;		}		public Criteria andIdEqualTo(Integer value) {			addCriterion("id =", value, "id");			return (Criteria) this;		}		public Criteria andIdNotEqualTo(Integer value) {			addCriterion("id <>", value, "id");			return (Criteria) this;		}		public Criteria andIdGreaterThan(Integer value) {			addCriterion("id >", value, "id");			return (Criteria) this;		}		public Criteria andIdGreaterThanOrEqualTo(Integer value) {			addCriterion("id >=", value, "id");			return (Criteria) this;		}		public Criteria andIdLessThan(Integer value) {			addCriterion("id <", value, "id");			return (Criteria) this;		}		public Criteria andIdLessThanOrEqualTo(Integer value) {			addCriterion("id <=", value, "id");			return (Criteria) this;		}		public Criteria andIdIn(List<Integer> values) {			addCriterion("id in", values, "id");			return (Criteria) this;		}		public Criteria andIdNotIn(List<Integer> values) {			addCriterion("id not in", values, "id");			return (Criteria) this;		}		public Criteria andIdBetween(Integer value1, Integer value2) {			addCriterion("id between", value1, value2, "id");			return (Criteria) this;		}		public Criteria andIdNotBetween(Integer value1, Integer value2) {			addCriterion("id not between", value1, value2, "id");			return (Criteria) this;		}		public Criteria andRepairOrderIsNull() {			addCriterion("repair_order is null");			return (Criteria) this;		}		public Criteria andRepairOrderIsNotNull() {			addCriterion("repair_order is not null");			return (Criteria) this;		}		public Criteria andRepairOrderEqualTo(String value) {			addCriterion("repair_order =", value, "repairOrder");			return (Criteria) this;		}		public Criteria andRepairOrderNotEqualTo(String value) {			addCriterion("repair_order <>", value, "repairOrder");			return (Criteria) this;		}		public Criteria andRepairOrderGreaterThan(String value) {			addCriterion("repair_order >", value, "repairOrder");			return (Criteria) this;		}		public Criteria andRepairOrderGreaterThanOrEqualTo(String value) {			addCriterion("repair_order >=", value, "repairOrder");			return (Criteria) this;		}		public Criteria andRepairOrderLessThan(String value) {			addCriterion("repair_order <", value, "repairOrder");			return (Criteria) this;		}		public Criteria andRepairOrderLessThanOrEqualTo(String value) {			addCriterion("repair_order <=", value, "repairOrder");			return (Criteria) this;		}		public Criteria andRepairOrderLike(String value) {			addCriterion("repair_order like", value, "repairOrder");			return (Criteria) this;		}		public Criteria andRepairOrderNotLike(String value) {			addCriterion("repair_order not like", value, "repairOrder");			return (Criteria) this;		}		public Criteria andRepairOrderIn(List<String> values) {			addCriterion("repair_order in", values, "repairOrder");			return (Criteria) this;		}		public Criteria andRepairOrderNotIn(List<String> values) {			addCriterion("repair_order not in", values, "repairOrder");			return (Criteria) this;		}		public Criteria andRepairOrderBetween(String value1, String value2) {			addCriterion("repair_order between", value1, value2, "repairOrder");			return (Criteria) this;		}		public Criteria andRepairOrderNotBetween(String value1, String value2) {			addCriterion("repair_order not between", value1, value2, "repairOrder");			return (Criteria) this;		}		public Criteria andServicemanAccountIsNull() {			addCriterion("serviceman_account is null");			return (Criteria) this;		}		public Criteria andServicemanAccountIsNotNull() {			addCriterion("serviceman_account is not null");			return (Criteria) this;		}		public Criteria andServicemanAccountEqualTo(String value) {			addCriterion("serviceman_account =", value, "servicemanAccount");			return (Criteria) this;		}		public Criteria andServicemanAccountNotEqualTo(String value) {			addCriterion("serviceman_account <>", value, "servicemanAccount");			return (Criteria) this;		}		public Criteria andServicemanAccountGreaterThan(String value) {			addCriterion("serviceman_account >", value, "servicemanAccount");			return (Criteria) this;		}		public Criteria andServicemanAccountGreaterThanOrEqualTo(String value) {			addCriterion("serviceman_account >=", value, "servicemanAccount");			return (Criteria) this;		}		public Criteria andServicemanAccountLessThan(String value) {			addCriterion("serviceman_account <", value, "servicemanAccount");			return (Criteria) this;		}		public Criteria andServicemanAccountLessThanOrEqualTo(String value) {			addCriterion("serviceman_account <=", value, "servicemanAccount");			return (Criteria) this;		}		public Criteria andServicemanAccountLike(String value) {			addCriterion("serviceman_account like", value, "servicemanAccount");			return (Criteria) this;		}		public Criteria andServicemanAccountNotLike(String value) {			addCriterion("serviceman_account not like", value, "servicemanAccount");			return (Criteria) this;		}		public Criteria andServicemanAccountIn(List<String> values) {			addCriterion("serviceman_account in", values, "servicemanAccount");			return (Criteria) this;		}		public Criteria andServicemanAccountNotIn(List<String> values) {			addCriterion("serviceman_account not in", values, "servicemanAccount");			return (Criteria) this;		}		public Criteria andServicemanAccountBetween(String value1, String value2) {			addCriterion("serviceman_account between", value1, value2, "servicemanAccount");			return (Criteria) this;		}		public Criteria andServicemanAccountNotBetween(String value1, String value2) {			addCriterion("serviceman_account not between", value1, value2, "servicemanAccount");			return (Criteria) this;		}		public Criteria andPresentTimeIsNull() {			addCriterion("present_time is null");			return (Criteria) this;		}		public Criteria andPresentTimeIsNotNull() {			addCriterion("present_time is not null");			return (Criteria) this;		}		public Criteria andPresentTimeEqualTo(Date value) {			addCriterion("present_time =", value, "presentTime");			return (Criteria) this;		}		public Criteria andPresentTimeNotEqualTo(Date value) {			addCriterion("present_time <>", value, "presentTime");			return (Criteria) this;		}		public Criteria andPresentTimeGreaterThan(Date value) {			addCriterion("present_time >", value, "presentTime");			return (Criteria) this;		}		public Criteria andPresentTimeGreaterThanOrEqualTo(Date value) {			addCriterion("present_time >=", value, "presentTime");			return (Criteria) this;		}		public Criteria andPresentTimeLessThan(Date value) {			addCriterion("present_time <", value, "presentTime");			return (Criteria) this;		}		public Criteria andPresentTimeLessThanOrEqualTo(Date value) {			addCriterion("present_time <=", value, "presentTime");			return (Criteria) this;		}		public Criteria andPresentTimeIn(List<Date> values) {			addCriterion("present_time in", values, "presentTime");			return (Criteria) this;		}		public Criteria andPresentTimeNotIn(List<Date> values) {			addCriterion("present_time not in", values, "presentTime");			return (Criteria) this;		}		public Criteria andPresentTimeBetween(Date value1, Date value2) {			addCriterion("present_time between", value1, value2, "presentTime");			return (Criteria) this;		}		public Criteria andPresentTimeNotBetween(Date value1, Date value2) {			addCriterion("present_time not between", value1, value2, "presentTime");			return (Criteria) this;		}		public Criteria andRepairDurationIsNull() {			addCriterion("repair_duration is null");			return (Criteria) this;		}		public Criteria andRepairDurationIsNotNull() {			addCriterion("repair_duration is not null");			return (Criteria) this;		}		public Criteria andRepairDurationEqualTo(String value) {			addCriterion("repair_duration =", value, "repairDuration");			return (Criteria) this;		}		public Criteria andRepairDurationNotEqualTo(String value) {			addCriterion("repair_duration <>", value, "repairDuration");			return (Criteria) this;		}		public Criteria andRepairDurationGreaterThan(String value) {			addCriterion("repair_duration >", value, "repairDuration");			return (Criteria) this;		}		public Criteria andRepairDurationGreaterThanOrEqualTo(String value) {			addCriterion("repair_duration >=", value, "repairDuration");			return (Criteria) this;		}		public Criteria andRepairDurationLessThan(String value) {			addCriterion("repair_duration <", value, "repairDuration");			return (Criteria) this;		}		public Criteria andRepairDurationLessThanOrEqualTo(String value) {			addCriterion("repair_duration <=", value, "repairDuration");			return (Criteria) this;		}		public Criteria andRepairDurationLike(String value) {			addCriterion("repair_duration like", value, "repairDuration");			return (Criteria) this;		}		public Criteria andRepairDurationNotLike(String value) {			addCriterion("repair_duration not like", value, "repairDuration");			return (Criteria) this;		}		public Criteria andRepairDurationIn(List<String> values) {			addCriterion("repair_duration in", values, "repairDuration");			return (Criteria) this;		}		public Criteria andRepairDurationNotIn(List<String> values) {			addCriterion("repair_duration not in", values, "repairDuration");			return (Criteria) this;		}		public Criteria andRepairDurationBetween(String value1, String value2) {			addCriterion("repair_duration between", value1, value2, "repairDuration");			return (Criteria) this;		}		public Criteria andRepairDurationNotBetween(String value1, String value2) {			addCriterion("repair_duration not between", value1, value2, "repairDuration");			return (Criteria) this;		}		public Criteria andRepairDescIsNull() {			addCriterion("repair_desc is null");			return (Criteria) this;		}		public Criteria andRepairDescIsNotNull() {			addCriterion("repair_desc is not null");			return (Criteria) this;		}		public Criteria andRepairDescEqualTo(String value) {			addCriterion("repair_desc =", value, "repairDesc");			return (Criteria) this;		}		public Criteria andRepairDescNotEqualTo(String value) {			addCriterion("repair_desc <>", value, "repairDesc");			return (Criteria) this;		}		public Criteria andRepairDescGreaterThan(String value) {			addCriterion("repair_desc >", value, "repairDesc");			return (Criteria) this;		}		public Criteria andRepairDescGreaterThanOrEqualTo(String value) {			addCriterion("repair_desc >=", value, "repairDesc");			return (Criteria) this;		}		public Criteria andRepairDescLessThan(String value) {			addCriterion("repair_desc <", value, "repairDesc");			return (Criteria) this;		}		public Criteria andRepairDescLessThanOrEqualTo(String value) {			addCriterion("repair_desc <=", value, "repairDesc");			return (Criteria) this;		}		public Criteria andRepairDescLike(String value) {			addCriterion("repair_desc like", value, "repairDesc");			return (Criteria) this;		}		public Criteria andRepairDescNotLike(String value) {			addCriterion("repair_desc not like", value, "repairDesc");			return (Criteria) this;		}		public Criteria andRepairDescIn(List<String> values) {			addCriterion("repair_desc in", values, "repairDesc");			return (Criteria) this;		}		public Criteria andRepairDescNotIn(List<String> values) {			addCriterion("repair_desc not in", values, "repairDesc");			return (Criteria) this;		}		public Criteria andRepairDescBetween(String value1, String value2) {			addCriterion("repair_desc between", value1, value2, "repairDesc");			return (Criteria) this;		}		public Criteria andRepairDescNotBetween(String value1, String value2) {			addCriterion("repair_desc not between", value1, value2, "repairDesc");			return (Criteria) this;		}		public Criteria andRepairStatusIsNull() {			addCriterion("repair_status is null");			return (Criteria) this;		}		public Criteria andRepairStatusIsNotNull() {			addCriterion("repair_status is not null");			return (Criteria) this;		}		public Criteria andRepairStatusEqualTo(Integer value) {			addCriterion("repair_status =", value, "repairStatus");			return (Criteria) this;		}		public Criteria andRepairStatusNotEqualTo(Integer value) {			addCriterion("repair_status <>", value, "repairStatus");			return (Criteria) this;		}		public Criteria andRepairStatusGreaterThan(Integer value) {			addCriterion("repair_status >", value, "repairStatus");			return (Criteria) this;		}		public Criteria andRepairStatusGreaterThanOrEqualTo(Integer value) {			addCriterion("repair_status >=", value, "repairStatus");			return (Criteria) this;		}		public Criteria andRepairStatusLessThan(Integer value) {			addCriterion("repair_status <", value, "repairStatus");			return (Criteria) this;		}		public Criteria andRepairStatusLessThanOrEqualTo(Integer value) {			addCriterion("repair_status <=", value, "repairStatus");			return (Criteria) this;		}		public Criteria andRepairStatusIn(List<Integer> values) {			addCriterion("repair_status in", values, "repairStatus");			return (Criteria) this;		}		public Criteria andRepairStatusNotIn(List<Integer> values) {			addCriterion("repair_status not in", values, "repairStatus");			return (Criteria) this;		}		public Criteria andRepairStatusBetween(Integer value1, Integer value2) {			addCriterion("repair_status between", value1, value2, "repairStatus");			return (Criteria) this;		}		public Criteria andRepairStatusNotBetween(Integer value1, Integer value2) {			addCriterion("repair_status not between", value1, value2, "repairStatus");			return (Criteria) this;		}		public Criteria andCreateTimeIsNull() {			addCriterion("create_time is null");			return (Criteria) this;		}		public Criteria andCreateTimeIsNotNull() {			addCriterion("create_time is not null");			return (Criteria) this;		}		public Criteria andCreateTimeEqualTo(Date value) {			addCriterion("create_time =", value, "createTime");			return (Criteria) this;		}		public Criteria andCreateTimeNotEqualTo(Date value) {			addCriterion("create_time <>", value, "createTime");			return (Criteria) this;		}		public Criteria andCreateTimeGreaterThan(Date value) {			addCriterion("create_time >", value, "createTime");			return (Criteria) this;		}		public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {			addCriterion("create_time >=", value, "createTime");			return (Criteria) this;		}		public Criteria andCreateTimeLessThan(Date value) {			addCriterion("create_time <", value, "createTime");			return (Criteria) this;		}		public Criteria andCreateTimeLessThanOrEqualTo(Date value) {			addCriterion("create_time <=", value, "createTime");			return (Criteria) this;		}		public Criteria andCreateTimeIn(List<Date> values) {			addCriterion("create_time in", values, "createTime");			return (Criteria) this;		}		public Criteria andCreateTimeNotIn(List<Date> values) {			addCriterion("create_time not in", values, "createTime");			return (Criteria) this;		}		public Criteria andCreateTimeBetween(Date value1, Date value2) {			addCriterion("create_time between", value1, value2, "createTime");			return (Criteria) this;		}		public Criteria andCreateTimeNotBetween(Date value1, Date value2) {			addCriterion("create_time not between", value1, value2, "createTime");			return (Criteria) this;		}		public Criteria andCreateByIsNull() {			addCriterion("create_by is null");			return (Criteria) this;		}		public Criteria andCreateByIsNotNull() {			addCriterion("create_by is not null");			return (Criteria) this;		}		public Criteria andCreateByEqualTo(String value) {			addCriterion("create_by =", value, "createBy");			return (Criteria) this;		}		public Criteria andCreateByNotEqualTo(String value) {			addCriterion("create_by <>", value, "createBy");			return (Criteria) this;		}		public Criteria andCreateByGreaterThan(String value) {			addCriterion("create_by >", value, "createBy");			return (Criteria) this;		}		public Criteria andCreateByGreaterThanOrEqualTo(String value) {			addCriterion("create_by >=", value, "createBy");			return (Criteria) this;		}		public Criteria andCreateByLessThan(String value) {			addCriterion("create_by <", value, "createBy");			return (Criteria) this;		}		public Criteria andCreateByLessThanOrEqualTo(String value) {			addCriterion("create_by <=", value, "createBy");			return (Criteria) this;		}		public Criteria andCreateByLike(String value) {			addCriterion("create_by like", value, "createBy");			return (Criteria) this;		}		public Criteria andCreateByNotLike(String value) {			addCriterion("create_by not like", value, "createBy");			return (Criteria) this;		}		public Criteria andCreateByIn(List<String> values) {			addCriterion("create_by in", values, "createBy");			return (Criteria) this;		}		public Criteria andCreateByNotIn(List<String> values) {			addCriterion("create_by not in", values, "createBy");			return (Criteria) this;		}		public Criteria andCreateByBetween(String value1, String value2) {			addCriterion("create_by between", value1, value2, "createBy");			return (Criteria) this;		}		public Criteria andCreateByNotBetween(String value1, String value2) {			addCriterion("create_by not between", value1, value2, "createBy");			return (Criteria) this;		}		public Criteria andUpdateTimeIsNull() {			addCriterion("update_time is null");			return (Criteria) this;		}		public Criteria andUpdateTimeIsNotNull() {			addCriterion("update_time is not null");			return (Criteria) this;		}		public Criteria andUpdateTimeEqualTo(Date value) {			addCriterion("update_time =", value, "updateTime");			return (Criteria) this;		}		public Criteria andUpdateTimeNotEqualTo(Date value) {			addCriterion("update_time <>", value, "updateTime");			return (Criteria) this;		}		public Criteria andUpdateTimeGreaterThan(Date value) {			addCriterion("update_time >", value, "updateTime");			return (Criteria) this;		}		public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {			addCriterion("update_time >=", value, "updateTime");			return (Criteria) this;		}		public Criteria andUpdateTimeLessThan(Date value) {			addCriterion("update_time <", value, "updateTime");			return (Criteria) this;		}		public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {			addCriterion("update_time <=", value, "updateTime");			return (Criteria) this;		}		public Criteria andUpdateTimeIn(List<Date> values) {			addCriterion("update_time in", values, "updateTime");			return (Criteria) this;		}		public Criteria andUpdateTimeNotIn(List<Date> values) {			addCriterion("update_time not in", values, "updateTime");			return (Criteria) this;		}		public Criteria andUpdateTimeBetween(Date value1, Date value2) {			addCriterion("update_time between", value1, value2, "updateTime");			return (Criteria) this;		}		public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {			addCriterion("update_time not between", value1, value2, "updateTime");			return (Criteria) this;		}		public Criteria andUpdateByIsNull() {			addCriterion("update_by is null");			return (Criteria) this;		}		public Criteria andUpdateByIsNotNull() {			addCriterion("update_by is not null");			return (Criteria) this;		}		public Criteria andUpdateByEqualTo(String value) {			addCriterion("update_by =", value, "updateBy");			return (Criteria) this;		}		public Criteria andUpdateByNotEqualTo(String value) {			addCriterion("update_by <>", value, "updateBy");			return (Criteria) this;		}		public Criteria andUpdateByGreaterThan(String value) {			addCriterion("update_by >", value, "updateBy");			return (Criteria) this;		}		public Criteria andUpdateByGreaterThanOrEqualTo(String value) {			addCriterion("update_by >=", value, "updateBy");			return (Criteria) this;		}		public Criteria andUpdateByLessThan(String value) {			addCriterion("update_by <", value, "updateBy");			return (Criteria) this;		}		public Criteria andUpdateByLessThanOrEqualTo(String value) {			addCriterion("update_by <=", value, "updateBy");			return (Criteria) this;		}		public Criteria andUpdateByLike(String value) {			addCriterion("update_by like", value, "updateBy");			return (Criteria) this;		}		public Criteria andUpdateByNotLike(String value) {			addCriterion("update_by not like", value, "updateBy");			return (Criteria) this;		}		public Criteria andUpdateByIn(List<String> values) {			addCriterion("update_by in", values, "updateBy");			return (Criteria) this;		}		public Criteria andUpdateByNotIn(List<String> values) {			addCriterion("update_by not in", values, "updateBy");			return (Criteria) this;		}		public Criteria andUpdateByBetween(String value1, String value2) {			addCriterion("update_by between", value1, value2, "updateBy");			return (Criteria) this;		}		public Criteria andUpdateByNotBetween(String value1, String value2) {			addCriterion("update_by not between", value1, value2, "updateBy");			return (Criteria) this;		}	}	public static class Criteria extends GeneratedCriteria {		protected Criteria() {			super();		}	}	public static class Criterion {		private String condition;		private Object value;		private Object secondValue;		private boolean noValue;		private boolean singleValue;		private boolean betweenValue;		private boolean listValue;		private String typeHandler;		public String getCondition() {			return condition;		}		public Object getValue() {			return value;		}		public Object getSecondValue() {			return secondValue;		}		public boolean isNoValue() {			return noValue;		}		public boolean isSingleValue() {			return singleValue;		}		public boolean isBetweenValue() {			return betweenValue;		}		public boolean isListValue() {			return listValue;		}		public String getTypeHandler() {			return typeHandler;		}		protected Criterion(String condition) {			super();			this.condition = condition;			this.typeHandler = null;			this.noValue = true;		}		protected Criterion(String condition, Object value, String typeHandler) {			super();			this.condition = condition;			this.value = value;			this.typeHandler = typeHandler;			if (value instanceof List<?>) {				this.listValue = true;			} else {				this.singleValue = true;			}		}		protected Criterion(String condition, Object value) {			this(condition, value, null);		}		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {			super();			this.condition = condition;			this.value = value;			this.secondValue = secondValue;			this.typeHandler = typeHandler;			this.betweenValue = true;		}		protected Criterion(String condition, Object value, Object secondValue) {			this(condition, value, secondValue, null);		}	}}