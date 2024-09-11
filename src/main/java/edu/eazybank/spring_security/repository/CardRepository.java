package edu.eazybank.spring_security.repository;

import edu.eazybank.spring_security.entity.CardEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends CrudRepository<CardEntity, Long> {

    List<CardEntity> findByCustomerId(long customerId);
}
