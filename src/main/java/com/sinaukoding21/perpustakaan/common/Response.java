package com.sinaukoding21.perpustakaan.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter
public class Response {
    private Object data;
    private String message;
    private Integer row;
    private HttpStatus status;

    public Response(Object data, String message, Integer row, HttpStatus status) {
        this.data = data;
        this.message = message;
        this.row = row;
        this.status = status;
    }

    public Response(Object data, String message, HttpStatus status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public Response( String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public Response(Object data, Integer row, HttpStatus status) {
        this.data = data;
        this.row = row;
        this.status = status;
    }
}
