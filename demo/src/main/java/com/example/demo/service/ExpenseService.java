package com.example.demo.service;


import com.example.demo.model.Expense;
import com.example.demo.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository repository;

    public ExpenseService(ExpenseRepository repository) {
        this.repository = repository;
    }

    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }

    public Expense getExpenseById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Expense createExpense(Expense expense) {
        return repository.save(expense);
    }

    public Expense updateExpense(Long id, Expense updated) {
        return repository.findById(id).map(expense -> {
            expense.setTitle(updated.getTitle());
            expense.setAmount(updated.getAmount());
            expense.setCategory(updated.getCategory());
            expense.setDate(updated.getDate());
            return repository.save(expense);
        }).orElse(null);
    }

    public void deleteExpense(Long id) {
        repository.deleteById(id);
    }
}
