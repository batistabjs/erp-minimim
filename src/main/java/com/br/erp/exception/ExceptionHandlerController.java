package com.br.erp.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import feign.FeignException;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
        .getFieldErrors()
        .stream()
        .map(FieldError::getDefaultMessage)
        .toList();

        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(errors);
        
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        return ResponseEntity.status(status).body(errorResponseDTO);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleCepNotFound(NotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<String> handleFeignException(FeignException ex) {
        HttpStatus status = HttpStatus.BAD_GATEWAY;
        try { 
            status = HttpStatus.valueOf(ex.status()); 
        } catch (Exception ignore) {}
        
        String message = "Erro ao acessar serviço externo: " + ex.getMessage();
        
        if (ex.contentUTF8() != null && !ex.contentUTF8().isBlank()) {
            message += " Detalhes: " + ex.contentUTF8();
        }

        return ResponseEntity.status(status).body(message);
    }
}
