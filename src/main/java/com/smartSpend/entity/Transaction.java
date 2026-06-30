package com.smartSpend.entity;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.smartSpend.enums.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "transactions")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long trId;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;   
	private Double amount;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	private String note;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	
	
	
}
