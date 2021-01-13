package com.decathlon.onepay.reactivepoc;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * This is the principal object in OnePay. <br /> <br /> This represents a fund transfer, associated to its {@link
 * AppClientEntity}, some {@link TransactionDetailEntity}, as well as its {@link PaymentEntity}.
 */
@Table("TRANSACTION")
@EqualsAndHashCode(of = {"id", "externalId", "token", "orderId"})
@ToString(of = {"id", "externalId", "token", "orderId"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class TransactionEntity implements Serializable {

  @Id
  @Column("TRANSACT_ID")
  private Long id;

  @Column("EXTERNAL_ID")
  private String externalId;

  @Column("TOKEN")
  private String token;

  @Column("ORDER_ID")
  private String orderId;

  @Column("HOOK_URL")
  private String hookUrl;

  @Column("PAYMENT_VERSION")
  private Long paymentVersion;

  @Column
  private Long acId;

  @Column
  private Long pmntId;

  @Column
  private Long tsId;

  @Column("CREATION_DATE")
  private LocalDateTime creationDate;

  @Column("UPDATE_DATE")
  private LocalDateTime updateDate;

  @Column
  private Long lastTransactionDetailTdId;

  @Column
  private Long ctId;

  @Column
  private String  ttName;

}
