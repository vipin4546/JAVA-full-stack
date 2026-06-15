package com.vipin.expense_tracker.service;

import com.vipin.expense_tracker.entity.Expenses;
import com.vipin.expense_tracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    private final ExpenseRepository repository;

    public ExpenseService(ExpenseRepository repository) {
        this.repository = repository;
    }

    public Expenses saveExpense(Expenses expense) {
        return repository.save(expense);
    }

    public List<Expenses> getAllExpense() {
        return repository.findAll();

    }

    public Optional<Expenses> getExpensesById(Long id) {
        return repository.findById(id);

    }

    public Expenses updateExpense(Long id, Expenses updatedExpense) {
        Optional<Expenses> expense = repository.findById(id);
        if (expense.isPresent()) {
            expense.get().setTitle(updatedExpense.getTitle());

            expense.get().setAmount(updatedExpense.getAmount());

            expense.get().setCategory(updatedExpense.getCategory());

            expense.get().setExpenseDate(updatedExpense.getExpenseDate());
            return repository.save(expense.get());


        }
        return null;


    }

    public void deleteExpense(Long id) {
        repository.deleteById(id);

    }

    public List<Expenses> getExpensesByCategory(String category) {
        return repository.findByCategory(category);
    }


}
