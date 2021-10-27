package com.acuity.visualisations.mapping.entity;

/**
 * Created by knml167 on 27/03/14.
 */
public class ExcludingValue extends MappingEntity {
    private Long studyRuleId;
    private Long fieldRuleId;
    private String value;

    public Long getStudyRuleId() {
        return studyRuleId;
    }

    public void setStudyRuleId(Long studyRuleId) {
        this.studyRuleId = studyRuleId;
    }

    public Long getFieldRuleId() {
        return fieldRuleId;
    }

    public void setFieldRuleId(Long fieldRuleId) {
        this.fieldRuleId = fieldRuleId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ExcludingValue value1 = (ExcludingValue) o;

        return (fieldRuleId != null ? fieldRuleId.equals(value1.fieldRuleId) : value1.fieldRuleId == null)
                && (studyRuleId != null ? studyRuleId.equals(value1.studyRuleId) : value1.studyRuleId == null)
                && (value != null ? value.equals(value1.value) : value1.value == null);
    }

    @Override
    public int hashCode() {
        int result = studyRuleId != null ? studyRuleId.hashCode() : 0;
        result = 31 * result + (fieldRuleId != null ? fieldRuleId.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
