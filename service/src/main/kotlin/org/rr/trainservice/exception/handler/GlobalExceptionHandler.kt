package org.rr.trainservice.exception.handler

import org.rr.trainservice.exception.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(TrainNotFoundException::class,
                      WagonNotFoundException::class,
                      RouteNotFoundException::class,
                      StationNotFoundException::class)
    fun handlerNotFoundException(runtimeException: RuntimeException): ResponseEntity<AppError> {
        val message: String = runtimeException.message.toString()

        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(AppError(message, HttpStatus.NOT_FOUND))
    }

    @ExceptionHandler(WagonAlreadyAssignedOrNotFoundException::class)
    fun handlerConflictException(runtimeException: RuntimeException): ResponseEntity<AppError> {
        val message: String = runtimeException.message.toString()

        return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(AppError(message, HttpStatus.CONFLICT))
    }
}