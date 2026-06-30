package com.smartSpend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartSpend.entity.Budget;
import com.smartSpend.entity.Category;
import com.smartSpend.entity.User;

import java.util.List;
import java.util.Optional;


@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {
	List<Budget> findByUser(User user);
	Optional<Budget> findByUserAndCategoryAndMonthAndYear(User u, Category c, int m, int y);
}
