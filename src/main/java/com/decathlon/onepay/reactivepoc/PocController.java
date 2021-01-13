package com.decathlon.onepay.reactivepoc;

import static reactor.core.publisher.Mono.just;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
public class PocController {

  private final TransactionRepository transactionRepository;

  private final Core core;

  @PostMapping("/{pmntId}/process")
  Mono<PaymentResponse> processPayment(@RequestBody PaymentRequest request, @PathVariable("pmntId") Long pmntId) {
    val error = PaymentResponse.builder()
        .status("error")
        .orderId(request.getOrderId())
        .transactionId(request.getTransactionId())
        .amount(request.getAmount())
        .build();
    if (pmntId.equals(1L)) {
      Mono<TransactionEntity> maybeTransactionEntity = transactionRepository.findById(request.getTransactionId());
      return maybeTransactionEntity.flatMap(transactionEntity -> core.processTransaction(transactionEntity, request)).defaultIfEmpty(error);
    } else {
      return just(error);
    }
  }

}
