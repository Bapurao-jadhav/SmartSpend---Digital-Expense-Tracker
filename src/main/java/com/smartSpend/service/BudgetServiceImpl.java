package com.smartSpend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartSpend.entity.Budget;
import com.smartSpend.entity.User;
import com.smartSpend.repository.BudgetRepository;
import com.smartSpend.repository.UserRepository;

@Service
public class BudgetServiceImpl implements BudgetService {
	@Autowired
	private BudgetRepository budgetRepo;

	@Autowired
	private UserRepository userRepo;

	@Override
	public void saveBudget(Budget budget, String email) {
		User user = userRepo.findByEmail(email).orElse(null);
		budget.setUser(user);
		Budget existing = budgetRepo
				.findByUserAndCategoryAndMonthAndYear(user, budget.getCategory(), budget.getMonth(), budget.getYear())
				.orElse(null);

		if (existing != null) {

			existing.setMonthlyBudget(budget.getMonthlyBudget());
			budgetRepo.save(existing);
		} else {
			budgetRepo.save(budget);
		}

	}

	@Override
	public List<Budget> getBudgetsByUser(String email) {
		User user = userRepo.findByEmail(email).orElse(null);
		return budgetRepo.findByUser(user);
	}

	@Override
	public void deleteBudget(Long id) {
		budgetRepo.deleteById(id);
	}

}
