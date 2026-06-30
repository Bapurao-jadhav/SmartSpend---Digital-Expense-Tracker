package com.smartSpend.service;

import java.util.List;

import com.smartSpend.entity.Budget;

public interface BudgetService {
	void saveBudget(Budget budget, String email);
	List<Budget> getBudgetsByUser(String email);
	void deleteBudget(Long id);
}
