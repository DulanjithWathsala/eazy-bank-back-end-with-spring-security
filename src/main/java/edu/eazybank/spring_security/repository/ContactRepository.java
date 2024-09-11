package edu.eazybank.spring_security.repository;

import edu.eazybank.spring_security.entity.ContactEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<ContactEntity, String> {
}
