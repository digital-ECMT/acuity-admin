package com.acuity.visualisations.model.output.entities;

import com.acuity.visualisations.model.acuityfield.AcuityField;
import com.acuity.visualisations.model.acuityfield.AcuityFieldTransformation;
import com.acuity.visualisations.data.util.Util;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Setter
public class StackedPkResults extends TimestampedEntity {
    private String patientGuid;
    private String subject;
    private String part;
    private BigDecimal visitNumber;

    @AcuityField(transform = AcuityFieldTransformation.MEASUREMENT_EVENT_12_00_00)
    private LocalDateTime visitDate;

    private String analyte;
    private String parameter;
    private BigDecimal parameterValue;
    private String parameterValueUnit;
    private String treatment;
    private String treatmentSchedule;
    private String treatmentCycle;
    private String protocolSchedule;
    private String protocolScheduleStartDay;
    private Integer protocolScheduleStartHour;
    private Integer protocolScheduleStartMinute;
    private String protocolScheduleEnd;
    private String protocolScheduleEndDay;
    private Integer protocolScheduleEndHour;
    private Integer protocolScheduleEndMinute;
    private String comment;
    private String visit; //e.g: Cycle 0 Day 0
    private String actualDose;

    @Override
    public String uniqueFieldsToString() {
        return new ToStringBuilder(this, Util.getToStringStyle())
                .append("patientGuid", patientGuid)
                .append("analyte", analyte)
                .append("parameter", parameter)
                .append("treatment", treatment)
                .append("treatmentSchedule", treatmentSchedule)
                .append("treatmentCycle", treatmentCycle)
                .append("protocolSchedule", protocolSchedule)
                .append("visitNumber", visitNumber)
                .append("visitDate", visitDate)
                .append("protocolScheduleStartDay", protocolScheduleStartDay)
                .append("protocolScheduleStartHour", protocolScheduleStartHour)
                .append("protocolScheduleStartMinute", protocolScheduleStartMinute)
                .append("protocolScheduleEnd", protocolScheduleEnd)
                .append("protocolScheduleEndDay", protocolScheduleEndDay)
                .append("protocolScheduleEndHour", protocolScheduleEndHour)
                .append("protocolScheduleEndMinute", protocolScheduleEndMinute)
                .append("visit", visit)
                .append("actualDose", actualDose)
                .toString();
    }

    @Override
    public String allFieldsToString() {
        return new ToStringBuilder(this, Util.getToStringStyle())
                .append("patientGuid", patientGuid)
                .append("analyte", analyte)
                .append("parameter", parameter)
                .append("treatment", treatment)
                .append("treatmentSchedule", treatmentSchedule)
                .append("treatmentCycle", treatmentCycle)
                .append("protocolSchedule", protocolSchedule)
                .append("visitNumber", visitNumber)
                .append("visitDate", visitDate)
                .append("protocolScheduleStartDay", protocolScheduleStartDay)
                .append("protocolScheduleStartHour", protocolScheduleStartHour)
                .append("protocolScheduleStartMinute", protocolScheduleStartMinute)
                .append("protocolScheduleEnd", protocolScheduleEnd)
                .append("protocolScheduleEndDay", protocolScheduleEndDay)
                .append("protocolScheduleEndHour", protocolScheduleEndHour)
                .append("protocolScheduleEndMinute", protocolScheduleEndMinute)
                .append("parameterValue", protocolScheduleEndMinute)
                .append("parameterValueUnit", parameterValueUnit)
                .append("comment", comment)
                .append("visit", visit)
                .append("actualDose", actualDose)
                .toString();
    }

}
