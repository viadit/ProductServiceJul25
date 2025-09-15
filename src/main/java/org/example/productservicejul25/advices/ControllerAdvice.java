package org.example.productservicejul25.advices;

import org.example.productservicejul25.dtos.ErrorDTO;
import org.example.productservicejul25.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleProductNotFoundException(ProductNotFoundException exception) {
        ErrorDTO errorDTO = new ErrorDTO();

        errorDTO.setMessage(exception.getMessage());
        ResponseEntity<ErrorDTO> errorResponseEntity = new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
        return errorResponseEntity;
    }
}
