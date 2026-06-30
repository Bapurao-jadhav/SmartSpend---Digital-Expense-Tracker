INSERT INTO categories (name, type)
SELECT 'Food', 'EXPENSE' WHERE NOT EXISTS (SELECT 1 FROM categories WHERE name = 'Food');

INSERT INTO categories (name, type)
SELECT 'Rent', 'EXPENSE' WHERE NOT EXISTS (SELECT 1 FROM categories WHERE name = 'Rent');

INSERT INTO categories (name, type)
SELECT 'Travel', 'EXPENSE' WHERE NOT EXISTS (SELECT 1 FROM categories WHERE name = 'Travel');

INSERT INTO categories (name, type)
SELECT 'Entertainment', 'EXPENSE' WHERE NOT EXISTS (SELECT 1 FROM categories WHERE name = 'Entertainment');

INSERT INTO categories (name, type)
SELECT 'Recharge', 'EXPENSE' WHERE NOT EXISTS (SELECT 1 FROM categories WHERE name = 'Recharge');

INSERT INTO categories (name, type)
SELECT 'EMI', 'EXPENSE' WHERE NOT EXISTS (SELECT 1 FROM categories WHERE name = 'EMI');

INSERT INTO categories (name, type)
SELECT 'Medical', 'EXPENSE' WHERE NOT EXISTS (SELECT 1 FROM categories WHERE name = 'Medical');

INSERT INTO categories (name, type)
SELECT 'Other', 'EXPENSE' WHERE NOT EXISTS (SELECT 1 FROM categories WHERE name = 'Other');

INSERT INTO categories (name, type)
SELECT 'Freelance', 'INCOME' WHERE NOT EXISTS (SELECT 1 FROM categories WHERE name = 'Freelance');

INSERT INTO categories (name, type)
SELECT 'Salary', 'INCOME' WHERE NOT EXISTS (SELECT 1 FROM categories WHERE name = 'Salary');

INSERT INTO categories (name, type)
SELECT 'Loan', 'INCOME' WHERE NOT EXISTS (SELECT 1 FROM categories WHERE name = 'Loan');

INSERT INTO categories (name, type)
SELECT 'Pocket Money', 'INCOME' WHERE NOT EXISTS (SELECT 1 FROM categories WHERE name = 'Pocket Money');