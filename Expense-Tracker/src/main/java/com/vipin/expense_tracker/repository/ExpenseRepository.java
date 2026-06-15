package com.vipin.expense_tracker.repository;

import com.vipin.expense_tracker.entity.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expenses, Long> {
    List<Expenses> findByCategory(String category);

}
