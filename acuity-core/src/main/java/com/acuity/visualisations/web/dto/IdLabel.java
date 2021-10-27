package com.acuity.visualisations.web.dto;

public class IdLabel<T> {
    private T id;
    private String label;

    public IdLabel(T id, String label) {
        this.id = id;
        this.label = label;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
