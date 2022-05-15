package com.macro.mall.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActActExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ActActExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andClubIdIsNull() {
            addCriterion("club_id is null");
            return (Criteria) this;
        }

        public Criteria andClubIdIsNotNull() {
            addCriterion("club_id is not null");
            return (Criteria) this;
        }

        public Criteria andClubIdEqualTo(Long value) {
            addCriterion("club_id =", value, "clubId");
            return (Criteria) this;
        }

        public Criteria andClubIdNotEqualTo(Long value) {
            addCriterion("club_id <>", value, "clubId");
            return (Criteria) this;
        }

        public Criteria andClubIdGreaterThan(Long value) {
            addCriterion("club_id >", value, "clubId");
            return (Criteria) this;
        }

        public Criteria andClubIdGreaterThanOrEqualTo(Long value) {
            addCriterion("club_id >=", value, "clubId");
            return (Criteria) this;
        }

        public Criteria andClubIdLessThan(Long value) {
            addCriterion("club_id <", value, "clubId");
            return (Criteria) this;
        }

        public Criteria andClubIdLessThanOrEqualTo(Long value) {
            addCriterion("club_id <=", value, "clubId");
            return (Criteria) this;
        }

        public Criteria andClubIdIn(List<Long> values) {
            addCriterion("club_id in", values, "clubId");
            return (Criteria) this;
        }

        public Criteria andClubIdNotIn(List<Long> values) {
            addCriterion("club_id not in", values, "clubId");
            return (Criteria) this;
        }

        public Criteria andClubIdBetween(Long value1, Long value2) {
            addCriterion("club_id between", value1, value2, "clubId");
            return (Criteria) this;
        }

        public Criteria andClubIdNotBetween(Long value1, Long value2) {
            addCriterion("club_id not between", value1, value2, "clubId");
            return (Criteria) this;
        }

        public Criteria andActNameIsNull() {
            addCriterion("act_name is null");
            return (Criteria) this;
        }

        public Criteria andActNameIsNotNull() {
            addCriterion("act_name is not null");
            return (Criteria) this;
        }

        public Criteria andActNameEqualTo(String value) {
            addCriterion("act_name =", value, "actName");
            return (Criteria) this;
        }

        public Criteria andActNameNotEqualTo(String value) {
            addCriterion("act_name <>", value, "actName");
            return (Criteria) this;
        }

        public Criteria andActNameGreaterThan(String value) {
            addCriterion("act_name >", value, "actName");
            return (Criteria) this;
        }

        public Criteria andActNameGreaterThanOrEqualTo(String value) {
            addCriterion("act_name >=", value, "actName");
            return (Criteria) this;
        }

        public Criteria andActNameLessThan(String value) {
            addCriterion("act_name <", value, "actName");
            return (Criteria) this;
        }

        public Criteria andActNameLessThanOrEqualTo(String value) {
            addCriterion("act_name <=", value, "actName");
            return (Criteria) this;
        }

        public Criteria andActNameLike(String value) {
            addCriterion("act_name like", value, "actName");
            return (Criteria) this;
        }

        public Criteria andActNameNotLike(String value) {
            addCriterion("act_name not like", value, "actName");
            return (Criteria) this;
        }

        public Criteria andActNameIn(List<String> values) {
            addCriterion("act_name in", values, "actName");
            return (Criteria) this;
        }

        public Criteria andActNameNotIn(List<String> values) {
            addCriterion("act_name not in", values, "actName");
            return (Criteria) this;
        }

        public Criteria andActNameBetween(String value1, String value2) {
            addCriterion("act_name between", value1, value2, "actName");
            return (Criteria) this;
        }

        public Criteria andActNameNotBetween(String value1, String value2) {
            addCriterion("act_name not between", value1, value2, "actName");
            return (Criteria) this;
        }

        public Criteria andActTypeIdIsNull() {
            addCriterion("act_type_id is null");
            return (Criteria) this;
        }

        public Criteria andActTypeIdIsNotNull() {
            addCriterion("act_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andActTypeIdEqualTo(Long value) {
            addCriterion("act_type_id =", value, "actTypeId");
            return (Criteria) this;
        }

        public Criteria andActTypeIdNotEqualTo(Long value) {
            addCriterion("act_type_id <>", value, "actTypeId");
            return (Criteria) this;
        }

        public Criteria andActTypeIdGreaterThan(Long value) {
            addCriterion("act_type_id >", value, "actTypeId");
            return (Criteria) this;
        }

        public Criteria andActTypeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("act_type_id >=", value, "actTypeId");
            return (Criteria) this;
        }

        public Criteria andActTypeIdLessThan(Long value) {
            addCriterion("act_type_id <", value, "actTypeId");
            return (Criteria) this;
        }

        public Criteria andActTypeIdLessThanOrEqualTo(Long value) {
            addCriterion("act_type_id <=", value, "actTypeId");
            return (Criteria) this;
        }

        public Criteria andActTypeIdIn(List<Long> values) {
            addCriterion("act_type_id in", values, "actTypeId");
            return (Criteria) this;
        }

        public Criteria andActTypeIdNotIn(List<Long> values) {
            addCriterion("act_type_id not in", values, "actTypeId");
            return (Criteria) this;
        }

        public Criteria andActTypeIdBetween(Long value1, Long value2) {
            addCriterion("act_type_id between", value1, value2, "actTypeId");
            return (Criteria) this;
        }

        public Criteria andActTypeIdNotBetween(Long value1, Long value2) {
            addCriterion("act_type_id not between", value1, value2, "actTypeId");
            return (Criteria) this;
        }

        public Criteria andActTypeNameIsNull() {
            addCriterion("act_type_name is null");
            return (Criteria) this;
        }

        public Criteria andActTypeNameIsNotNull() {
            addCriterion("act_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andActTypeNameEqualTo(String value) {
            addCriterion("act_type_name =", value, "actTypeName");
            return (Criteria) this;
        }

        public Criteria andActTypeNameNotEqualTo(String value) {
            addCriterion("act_type_name <>", value, "actTypeName");
            return (Criteria) this;
        }

        public Criteria andActTypeNameGreaterThan(String value) {
            addCriterion("act_type_name >", value, "actTypeName");
            return (Criteria) this;
        }

        public Criteria andActTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("act_type_name >=", value, "actTypeName");
            return (Criteria) this;
        }

        public Criteria andActTypeNameLessThan(String value) {
            addCriterion("act_type_name <", value, "actTypeName");
            return (Criteria) this;
        }

        public Criteria andActTypeNameLessThanOrEqualTo(String value) {
            addCriterion("act_type_name <=", value, "actTypeName");
            return (Criteria) this;
        }

        public Criteria andActTypeNameLike(String value) {
            addCriterion("act_type_name like", value, "actTypeName");
            return (Criteria) this;
        }

        public Criteria andActTypeNameNotLike(String value) {
            addCriterion("act_type_name not like", value, "actTypeName");
            return (Criteria) this;
        }

        public Criteria andActTypeNameIn(List<String> values) {
            addCriterion("act_type_name in", values, "actTypeName");
            return (Criteria) this;
        }

        public Criteria andActTypeNameNotIn(List<String> values) {
            addCriterion("act_type_name not in", values, "actTypeName");
            return (Criteria) this;
        }

        public Criteria andActTypeNameBetween(String value1, String value2) {
            addCriterion("act_type_name between", value1, value2, "actTypeName");
            return (Criteria) this;
        }

        public Criteria andActTypeNameNotBetween(String value1, String value2) {
            addCriterion("act_type_name not between", value1, value2, "actTypeName");
            return (Criteria) this;
        }

        public Criteria andActPicsIsNull() {
            addCriterion("act_pics is null");
            return (Criteria) this;
        }

        public Criteria andActPicsIsNotNull() {
            addCriterion("act_pics is not null");
            return (Criteria) this;
        }

        public Criteria andActPicsEqualTo(String value) {
            addCriterion("act_pics =", value, "actPics");
            return (Criteria) this;
        }

        public Criteria andActPicsNotEqualTo(String value) {
            addCriterion("act_pics <>", value, "actPics");
            return (Criteria) this;
        }

        public Criteria andActPicsGreaterThan(String value) {
            addCriterion("act_pics >", value, "actPics");
            return (Criteria) this;
        }

        public Criteria andActPicsGreaterThanOrEqualTo(String value) {
            addCriterion("act_pics >=", value, "actPics");
            return (Criteria) this;
        }

        public Criteria andActPicsLessThan(String value) {
            addCriterion("act_pics <", value, "actPics");
            return (Criteria) this;
        }

        public Criteria andActPicsLessThanOrEqualTo(String value) {
            addCriterion("act_pics <=", value, "actPics");
            return (Criteria) this;
        }

        public Criteria andActPicsLike(String value) {
            addCriterion("act_pics like", value, "actPics");
            return (Criteria) this;
        }

        public Criteria andActPicsNotLike(String value) {
            addCriterion("act_pics not like", value, "actPics");
            return (Criteria) this;
        }

        public Criteria andActPicsIn(List<String> values) {
            addCriterion("act_pics in", values, "actPics");
            return (Criteria) this;
        }

        public Criteria andActPicsNotIn(List<String> values) {
            addCriterion("act_pics not in", values, "actPics");
            return (Criteria) this;
        }

        public Criteria andActPicsBetween(String value1, String value2) {
            addCriterion("act_pics between", value1, value2, "actPics");
            return (Criteria) this;
        }

        public Criteria andActPicsNotBetween(String value1, String value2) {
            addCriterion("act_pics not between", value1, value2, "actPics");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
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

        public Criteria andAddressDetailIsNull() {
            addCriterion("address_detail is null");
            return (Criteria) this;
        }

        public Criteria andAddressDetailIsNotNull() {
            addCriterion("address_detail is not null");
            return (Criteria) this;
        }

        public Criteria andAddressDetailEqualTo(String value) {
            addCriterion("address_detail =", value, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailNotEqualTo(String value) {
            addCriterion("address_detail <>", value, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailGreaterThan(String value) {
            addCriterion("address_detail >", value, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailGreaterThanOrEqualTo(String value) {
            addCriterion("address_detail >=", value, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailLessThan(String value) {
            addCriterion("address_detail <", value, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailLessThanOrEqualTo(String value) {
            addCriterion("address_detail <=", value, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailLike(String value) {
            addCriterion("address_detail like", value, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailNotLike(String value) {
            addCriterion("address_detail not like", value, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailIn(List<String> values) {
            addCriterion("address_detail in", values, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailNotIn(List<String> values) {
            addCriterion("address_detail not in", values, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailBetween(String value1, String value2) {
            addCriterion("address_detail between", value1, value2, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailNotBetween(String value1, String value2) {
            addCriterion("address_detail not between", value1, value2, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andProvideServiceIsNull() {
            addCriterion("provide_service is null");
            return (Criteria) this;
        }

        public Criteria andProvideServiceIsNotNull() {
            addCriterion("provide_service is not null");
            return (Criteria) this;
        }

        public Criteria andProvideServiceEqualTo(String value) {
            addCriterion("provide_service =", value, "provideService");
            return (Criteria) this;
        }

        public Criteria andProvideServiceNotEqualTo(String value) {
            addCriterion("provide_service <>", value, "provideService");
            return (Criteria) this;
        }

        public Criteria andProvideServiceGreaterThan(String value) {
            addCriterion("provide_service >", value, "provideService");
            return (Criteria) this;
        }

        public Criteria andProvideServiceGreaterThanOrEqualTo(String value) {
            addCriterion("provide_service >=", value, "provideService");
            return (Criteria) this;
        }

        public Criteria andProvideServiceLessThan(String value) {
            addCriterion("provide_service <", value, "provideService");
            return (Criteria) this;
        }

        public Criteria andProvideServiceLessThanOrEqualTo(String value) {
            addCriterion("provide_service <=", value, "provideService");
            return (Criteria) this;
        }

        public Criteria andProvideServiceLike(String value) {
            addCriterion("provide_service like", value, "provideService");
            return (Criteria) this;
        }

        public Criteria andProvideServiceNotLike(String value) {
            addCriterion("provide_service not like", value, "provideService");
            return (Criteria) this;
        }

        public Criteria andProvideServiceIn(List<String> values) {
            addCriterion("provide_service in", values, "provideService");
            return (Criteria) this;
        }

        public Criteria andProvideServiceNotIn(List<String> values) {
            addCriterion("provide_service not in", values, "provideService");
            return (Criteria) this;
        }

        public Criteria andProvideServiceBetween(String value1, String value2) {
            addCriterion("provide_service between", value1, value2, "provideService");
            return (Criteria) this;
        }

        public Criteria andProvideServiceNotBetween(String value1, String value2) {
            addCriterion("provide_service not between", value1, value2, "provideService");
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

        public Criteria andLatitudeEqualTo(BigDecimal value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(BigDecimal value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(BigDecimal value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(BigDecimal value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<BigDecimal> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<BigDecimal> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(BigDecimal value1, BigDecimal value2) {
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

        public Criteria andLongitudeEqualTo(BigDecimal value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(BigDecimal value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(BigDecimal value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(BigDecimal value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<BigDecimal> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<BigDecimal> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceIsNull() {
            addCriterion("original_price is null");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceIsNotNull() {
            addCriterion("original_price is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceEqualTo(BigDecimal value) {
            addCriterion("original_price =", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotEqualTo(BigDecimal value) {
            addCriterion("original_price <>", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceGreaterThan(BigDecimal value) {
            addCriterion("original_price >", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("original_price >=", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceLessThan(BigDecimal value) {
            addCriterion("original_price <", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("original_price <=", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceIn(List<BigDecimal> values) {
            addCriterion("original_price in", values, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotIn(List<BigDecimal> values) {
            addCriterion("original_price not in", values, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("original_price between", value1, value2, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("original_price not between", value1, value2, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andPromotionPriceIsNull() {
            addCriterion("promotion_price is null");
            return (Criteria) this;
        }

        public Criteria andPromotionPriceIsNotNull() {
            addCriterion("promotion_price is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionPriceEqualTo(BigDecimal value) {
            addCriterion("promotion_price =", value, "promotionPrice");
            return (Criteria) this;
        }

        public Criteria andPromotionPriceNotEqualTo(BigDecimal value) {
            addCriterion("promotion_price <>", value, "promotionPrice");
            return (Criteria) this;
        }

        public Criteria andPromotionPriceGreaterThan(BigDecimal value) {
            addCriterion("promotion_price >", value, "promotionPrice");
            return (Criteria) this;
        }

        public Criteria andPromotionPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("promotion_price >=", value, "promotionPrice");
            return (Criteria) this;
        }

        public Criteria andPromotionPriceLessThan(BigDecimal value) {
            addCriterion("promotion_price <", value, "promotionPrice");
            return (Criteria) this;
        }

        public Criteria andPromotionPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("promotion_price <=", value, "promotionPrice");
            return (Criteria) this;
        }

        public Criteria andPromotionPriceIn(List<BigDecimal> values) {
            addCriterion("promotion_price in", values, "promotionPrice");
            return (Criteria) this;
        }

        public Criteria andPromotionPriceNotIn(List<BigDecimal> values) {
            addCriterion("promotion_price not in", values, "promotionPrice");
            return (Criteria) this;
        }

        public Criteria andPromotionPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotion_price between", value1, value2, "promotionPrice");
            return (Criteria) this;
        }

        public Criteria andPromotionPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotion_price not between", value1, value2, "promotionPrice");
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