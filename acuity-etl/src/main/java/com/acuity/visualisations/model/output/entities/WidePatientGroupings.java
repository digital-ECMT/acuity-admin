package com.acuity.visualisations.model.output.entities;

import com.acuity.visualisations.model.output.FieldDelegatingEntity;
import com.acuity.visualisations.model.output.SplitEntity;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class WidePatientGroupings extends TimestampedEntity implements FieldDelegatingEntity, SplitEntity<PatientGroup> {

    private String studyGuid;
    private String subject;
    private String part;
    private Map<String, Object> groupings = new LinkedHashMap<>();

    @Override
    public List<PatientGroup> split() {
        return groupings.entrySet().stream().map(entry -> {
            PatientGroup group = new PatientGroup();
            group.setStudyGuid(studyGuid);
            group.setSubject(subject);
            group.setPart(part);
            group.setGroupingName(entry.getKey());
            if (entry.getValue() != null) {
                group.setGroupName(entry.getValue().toString());
            }
            return group;
        }).collect(Collectors.toList());
    }

    public String getStudyGuid() {
        return studyGuid;
    }

    public void setStudyGuid(String studyGuid) {
        this.studyGuid = studyGuid;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    @Override
    public Set<String> getFieldNames() {
        return groupings.keySet();
    }

    @Override
    public void setField(String name, Object value) {
        groupings.put(name, value);
    }

    @Override
    public Object getField(String name) {
        return groupings.get(name);
    }
}
