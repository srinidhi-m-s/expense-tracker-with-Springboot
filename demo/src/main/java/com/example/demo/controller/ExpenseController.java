package com.example.demo.controller;
import com.example.demo.model.Expense;
import com.example.demo.service.ExpenseService;
import java.util.Map;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @GetMapping
    public List<Expense> getAllExpenses() {
        return service.getAllExpenses();
    }

    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable Long id) {
        return service.getExpenseById(id);
    }

    @PostMapping
    public Expense createExpense(@RequestBody Expense expense) {
        return service.createExpense(expense);
    }

    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
        return service.updateExpense(id, expense);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id) {
        service.deleteExpense(id);
    }
    @PatchMapping("/{id}")
    public Expense partiallyUpdateExpense(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        Expense expense = service.getExpenseById(id);
        if (expense != null) {
            updates.forEach((key, value) -> {
                switch (key) {
                    case "title" -> expense.setTitle((String) value);
                    case "amount" -> expense.setAmount(Double.valueOf(value.toString()));
                    case "category" -> expense.setCategory((String) value);
                    case "date" -> expense.setDate(LocalDate.parse((String) value));
                }
            });
            return service.createExpense(expense); 
        }
        return null;
    }
}
