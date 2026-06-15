package com.vipin.expense_tracker.controller;

import com.vipin.expense_tracker.entity.Expenses;
import com.vipin.expense_tracker.service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Expenses> createExpense(@RequestBody Expenses expense) {
        Expenses savedExpense = service.saveExpense(expense);
        return ResponseEntity.status(201).body(savedExpense);
    }

    @GetMapping
    public ResponseEntity<List<Expenses>> getExpenses() {
        return ResponseEntity.status(200).body(service.getAllExpense());
    }

    @GetMapping("/{id}")
    public Optional<Expenses> getExpenseById(@PathVariable Long id) {
        return service.getExpensesById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Expenses> updateExpense(@PathVariable Long id, @RequestBody Expenses expense) {
        Expenses updatedExpense = service.updateExpense(id, expense);
        return ResponseEntity.status(200).body(updatedExpense);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpenses(@PathVariable Long id) {
        service.deleteExpense(id);
        return ResponseEntity.ok("Expense deleted successfully");

    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Expenses>> getByCategory(@PathVariable String category) {
        return ResponseEntity.status(200).body(service.getExpensesByCategory(category));

    }
}
