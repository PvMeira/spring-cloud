package com.kenai.br.hades.model.domain;

public enum StatusType {
    ACTIVE("A", "Active"),
    INACTIVE("I", "Inactive");

    private String value;
    private String description;


    StatusType(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public static StatusType getEnumValue(String value) {
        for (StatusType statusType : StatusType.values()) {
            if (statusType.getValue().equals(value))
                return statusType;
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
