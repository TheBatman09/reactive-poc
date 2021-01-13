package com.decathlon.onepay.reactivepoc;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface TransactionRepository extends ReactiveCrudRepository<TransactionEntity, Long> {
}
