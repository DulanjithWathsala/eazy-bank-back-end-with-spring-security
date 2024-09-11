package edu.eazybank.spring_security.repository;

import edu.eazybank.spring_security.entity.AccountTransactionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountTransactionRepository extends CrudRepository<AccountTransactionEntity, String> {

    List<AccountTransactionEntity> findByCustomerIdOrderByTransactionDtDesc(long customerId);
}
