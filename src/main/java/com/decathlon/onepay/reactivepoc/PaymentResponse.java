package com.decathlon.onepay.reactivepoc;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PaymentResponse {

  private BigDecimal amount;
  private String orderId;
  private Long transactionId;
  private String status;
}
