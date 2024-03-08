package com.app.vetcare.exception;

import org.springframework.http.HttpStatus;

/**
 * Interface for Recipe Exception
 */
public interface CustomRecipeException {
    HttpStatus getStatus();
}