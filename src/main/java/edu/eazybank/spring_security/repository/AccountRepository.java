package edu.eazybank.spring_security.repository;

import edu.eazybank.spring_security.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<AccountEntity, Long> {

    AccountEntity findByCustomerId(long customerId);
}
