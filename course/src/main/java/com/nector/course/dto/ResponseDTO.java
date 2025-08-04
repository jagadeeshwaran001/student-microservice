package com.nector.course.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO<T>{
    private String message;
    private String shortMessage;
    private T data;

    public ResponseDTO(T data) {this.data = data;}

    public ResponseDTO(String message) {
        this.message = message;
    }

    public ResponseDTO(String message, String shortMessage) {
        this.message = message;
        this.shortMessage = message;
    }
}
