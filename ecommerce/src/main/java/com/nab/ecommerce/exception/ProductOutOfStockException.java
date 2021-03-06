package com.nab.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProductOutOfStockException extends RuntimeException {

  public ProductOutOfStockException(String message) {
    super(String.format("Product is out of stock: %s", message));
  }

  public ProductOutOfStockException(String message, Throwable cause) {
    super(message, cause);
  }
}
