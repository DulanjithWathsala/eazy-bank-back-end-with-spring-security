package edu.eazybank.spring_security.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.eazybank.spring_security.entity.CustomerEntity;
import edu.eazybank.spring_security.model.Customer;
import edu.eazybank.spring_security.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final CustomerRepository customerRepository;

    private final PasswordEncoder passwordEncoder;

    private final ObjectMapper mapper;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
        try {
            customer.setPassword(passwordEncoder.encode(customer.getPassword()));
            CustomerEntity savedCustomer =
                    customerRepository.save(mapper.convertValue(customer, CustomerEntity.class));

            if (savedCustomer.getId() > 0) {
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body("Given user details are successfully created");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("User registration failed");
            }
        }catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ex.getMessage());
        }
    }
}
