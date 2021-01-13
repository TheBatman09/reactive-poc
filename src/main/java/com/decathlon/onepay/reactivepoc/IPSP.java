package com.decathlon.onepay.reactivepoc;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

public interface IPSP {

  PspRequest getRequest(TransactionEntity transactionEntity);

  PspResponse interpret(String body, HttpStatus status, HttpHeaders headers);
}
