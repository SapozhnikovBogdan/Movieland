package com.sapozhnikov.movielandentity.common;

public enum SortDirection {
    ASC("asc"),
    DESC("desc");

    private String value;

    SortDirection(String value) {
        this.value = value;
    }

    public static SortDirection getByName(String value){
        for (SortDirection sortDirection : values()) {
            if (sortDirection.value.equalsIgnoreCase(value.trim())){
                return sortDirection;
            }
        }
        throw new IllegalArgumentException("Invalid sort direction: " + value);
    }
}
