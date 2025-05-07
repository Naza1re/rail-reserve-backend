package org.rr.trainservice.exception.handler

import org.springframework.http.HttpStatus

data class AppError(
    val message: String,
    val status: HttpStatus
)
