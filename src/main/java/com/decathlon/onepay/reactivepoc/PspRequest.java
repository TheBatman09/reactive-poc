package com.decathlon.onepay.reactivepoc;

import io.vavr.control.Option;
import java.net.URI;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.NonNull;
import lombok.Value;
import org.springframework.http.HttpMethod;

@Value
@Builder
public class PspRequest {

  @NonNull
  private HttpMethod httpMethod;
  @NonNull
  private URI uri;
  @NonNull
  @Default
  private Option<String> body = Option.none();
}
