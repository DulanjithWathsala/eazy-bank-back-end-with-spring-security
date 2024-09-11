package edu.eazybank.spring_security.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Date;


@Entity
@Data
@Table(name = "account_transactions")
public class AccountTransactionEntity {


    @Id
    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name="account_number")
    private long accountNumber;

    @Column(name = "customer_id")
    private long customerId;

    @Column(name="transaction_dt")
    private Date transactionDt;

    @Column(name = "transaction_summary")
    private String transactionSummary;

    @Column(name="transaction_type")
    private String transactionType;

    @Column(name = "transaction_amt")
    private int transactionAmt;

    @Column(name = "closing_balance")
    private int closingBalance;

    @Column(name = "create_dt")
    private Date createDt;
}
