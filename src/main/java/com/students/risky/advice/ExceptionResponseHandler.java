package com.students.risky.advice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExceptionResponseHandler {

    private LocalDateTime timeStamp;
    private String message;
    private String code;
}
