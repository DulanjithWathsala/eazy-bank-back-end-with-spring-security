package edu.eazybank.spring_security.repository;

import edu.eazybank.spring_security.entity.LoanEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends CrudRepository<LoanEntity, Long> {

    List<LoanEntity> findByCustomerIdOrderByStartDtDesc(long customerId);
}
