package com.kenai.br.library.register.exception.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Error {
    private String code;
    private String detail;
    private String title;

    public Error(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public Error(String code, String title, String detail) {
        this.code = code;
        this.detail = detail;
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public String getDetail() {
        return detail;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Error{" +
                "code='" + code + '\'' +
                ", detail='" + detail + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
