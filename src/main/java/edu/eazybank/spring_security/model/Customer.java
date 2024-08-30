package edu.eazybank.spring_security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private Long id;
    private String email;
    private String password;
    private String role;
}
