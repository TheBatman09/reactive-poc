package com.decathlon.onepay.reactivepoc;

import java.net.URI;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class PspMock implements IPSP {

  @Override
  public PspRequest getRequest(TransactionEntity transactionEntity) {
    return PspRequest.builder()
        .httpMethod(HttpMethod.GET)
        .uri(URI.create("https://b78b6758e6f8cc537a507bf7df0f64e5.m.pipedream.net"))
        .build();
  }

  @Override
  public PspResponse interpret(String body, HttpStatus status, HttpHeaders headers) {
    return PspResponse.builder()
        .action("ACTION")
        .status(status.is2xxSuccessful()?"SUCCESS":"ERROR")
        .build();
  }
}
