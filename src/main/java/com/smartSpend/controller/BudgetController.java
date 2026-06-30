package com.smartSpend.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smartSpend.entity.Budget;
import com.smartSpend.enums.CategoryType;
import com.smartSpend.repository.CategoryRepository;
import com.smartSpend.service.BudgetService;

@Controller
public class BudgetController {
	
	@Autowired
	private BudgetService budgetService;
	@Autowired
	private CategoryRepository categoryRepo;
	
	@GetMapping("/budget")
	public String goToAddBudgetPage(Model model,Principal principal) {
		 model.addAttribute("budget", new Budget());
		 model.addAttribute("categories", categoryRepo.findByType(CategoryType.EXPENSE));
		 List<Budget> existingBudgets = budgetService.getBudgetsByUser(principal.getName());
		 model.addAttribute("existingbudgets", existingBudgets);
		return "budget";
	}
	
	@PostMapping("/saveBudget")
	public String  addBudget(@ModelAttribute Budget budget, Principal principal) {
		budgetService.saveBudget(budget, principal.getName());
		return "redirect:/showBudget";
	}
	
	@GetMapping("/showBudget")
	public String showBudgetByUser(Model model,Principal principle) {
		List<Budget> list = budgetService.getBudgetsByUser(principle.getName());
		model.addAttribute("budgets", list);
		return "budget-list";
	}
	
	@GetMapping("/budget/delete/{id}")
	public String deleteBudgetById(@PathVariable long id) {
		budgetService.deleteBudget(id);
		return "redirect:/showBudget";
	}
}
