package com.todolist.demo.web.rest.errors;

public class DuplicateRecordException extends RuntimeException {
    public DuplicateRecordException() {super();}
    public DuplicateRecordException(String message) {
        super(message);
    }
}
