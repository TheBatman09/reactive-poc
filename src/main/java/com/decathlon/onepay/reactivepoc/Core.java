package com.decathlon.onepay.reactivepoc;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Core {

  private final IPSP pspPlugin;

  public Mono<PaymentResponse> processTransaction(TransactionEntity transactionEntity, PaymentRequest request) {
    val result = pspPlugin.getRequest(transactionEntity);
    WebClient client = WebClient.builder().build();

    val response = client
        .method(result.getHttpMethod())
        .uri(result.getUri())
        .body(BodyInserters.fromValue(result.getBody().getOrElse("")))
        .retrieve();

    val body = response.bodyToMono(String.class);
    val entity = response.toBodilessEntity();

    val pspResponse = body.flatMap(bodyready -> entity
        .map(entityReady -> pspPlugin.interpret(bodyready, entityReady.getStatusCode(), entityReady.getHeaders())));

    return pspResponse.map(responseReady -> PaymentResponse.builder()
        .amount(request.getAmount())
        .orderId(request.getOrderId())
        .transactionId(transactionEntity.getId())
        .status(String.format("%s_%s", responseReady.getAction(), responseReady.getStatus()))
        .build());
  }
}
