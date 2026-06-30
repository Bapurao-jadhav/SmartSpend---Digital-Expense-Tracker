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

import com.smartSpend.entity.Transaction;
import com.smartSpend.repository.CategoryRepository;
import com.smartSpend.service.TransactionService;


@Controller
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	@Autowired
	private CategoryRepository categoryRepo;
	
	@GetMapping("/transaction")
	public String goToTransactionPage(Model model) {
	    model.addAttribute("transaction", new Transaction());
	    model.addAttribute("categories", categoryRepo.findAll());
	    return "transaction-add";
	}
	
	@PostMapping("/savetransaction")
	public String saveTransaction(@ModelAttribute Transaction transaction, Principal principal) {
		transactionService.addTransaction(transaction, principal.getName());
		return "redirect:/transaction/list";
	}
	
	@GetMapping("/transaction/list")
	public String transactionList(Model model, Principal principal) {
	    List<Transaction> transactions = transactionService.getTransactionsByUser(principal.getName());
	    model.addAttribute("transactions", transactions);
	    return "transaction-list";
	}
	@GetMapping("/transaction/update/{id}")
	public String goToEditTransaction(@PathVariable Long id,Model model) {
		Transaction transactions = transactionService.getTransactionById(id);
		model.addAttribute("transaction", transactions);
		model.addAttribute("categories", categoryRepo.findAll());
		return "transaction-edit";
	}
	
	@GetMapping("/transaction/delete/{id}")
	public String deleteTransaction(@PathVariable Long id) {
	    transactionService.deleteTransaction(id);
	    return "redirect:/transaction/list";
	}
	
	@PostMapping("/transaction/update")
	public String updateTransaction(@ModelAttribute Transaction transaction, Principal principal) {
	    transactionService.updateTransaction(transaction, principal.getName());
	    return "redirect:/transaction/list";
	}
}
