package com.decathlon.onepay.reactivepoc;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PspResponse {

  private String action;
  private String status;
}
