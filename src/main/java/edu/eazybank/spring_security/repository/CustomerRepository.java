package edu.eazybank.spring_security.repository;

import edu.eazybank.spring_security.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {

    Optional<CustomerEntity> findByEmail(String email);
}
