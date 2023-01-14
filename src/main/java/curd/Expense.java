package curd;

import javax.json.bind.annotation.JsonbCreator;
import java.time.LocalDateTime;
import java.util.UUID;

//this is the core data structure file, where we created schema of the class, in which form we'll take the data
//we created class in public so that it can be accessbile form outside the class

public class Expense{
    enum PaymentMethod {
        CASH,CREDIT_CARD,DEBIT_CARD;
    }
    private String name;
    private double amount;
    private LocalDateTime creationDate;
    private PaymentMethod paymentMethod;
    private UUID uuid;

    //this constructure handel the all parameter if client will give
    public Expense(String name, double amount, LocalDateTime creationDate, PaymentMethod paymentMethod, UUID uuid) {
        this.name = name;
        this.amount = amount;
        this.creationDate = creationDate;
        this.paymentMethod = paymentMethod;
        this.uuid = uuid;
    }

    //this constructure can handle only 3 parameter also
    public Expense(String name, double amount, PaymentMethod paymentMethod) {
        this.name = name;
        this.amount = amount;
        this.creationDate = LocalDateTime.now();
        this.paymentMethod = paymentMethod;
        this.uuid = UUID.randomUUID();
    }



    //this annotation is used to validate the input in json format
    //i'm going to take the input in json format for this constructor
    @JsonbCreator
    public  static   Expense of(String name, double amount, PaymentMethod paymentMethod){
        return new Expense(name, amount, paymentMethod);
    }


//below we describe all the getter and setter for each private member of the class
    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}