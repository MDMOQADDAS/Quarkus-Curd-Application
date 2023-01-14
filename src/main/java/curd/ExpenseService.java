package curd;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

//this file responsible for the basic methods like , read, update, delete

//below annotation can publice the ExpenseService class, so that other method can use @Inject annotation to inject and use.

@ApplicationScoped
public class ExpenseService {


    //this is core data structure we'll use to store the our custome data strcture
    Set<Expense>  expenses = Collections.newSetFromMap(Collections.synchronizedMap(new HashMap<>()));

//all the curd operation derive here


    //Read

    //read
    public  Set<Expense> list(){
        return expenses;
    }

    //create
    public Expense create(Expense expense){
        expenses.add(expense);
        return expense;
    }

    //delete
    public boolean delete(UUID uuid){
        return expenses.removeIf(expense -> expense.getUuid().equals(uuid));
    }

    //update
    public  void update(Expense expense){
        delete(expense.getUuid());
        create(expense);
    }

}
