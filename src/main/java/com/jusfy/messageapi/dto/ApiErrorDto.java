package com.jusfy.messageapi.dto;

public record ApiErrorDto(
    String timestamp,
    int status,
    String error,
    String message) {
}
