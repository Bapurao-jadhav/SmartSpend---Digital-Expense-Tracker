package com.smartSpend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartSpend.entity.Category;
import java.util.List;
import com.smartSpend.enums.CategoryType;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	List<Category> findByType(CategoryType type);
}
