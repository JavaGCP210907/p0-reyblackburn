

CREATE TABLE employees (
	employee_id serial PRIMARY KEY,
	f_name TEXT,
	l_name TEXT,
	role_title TEXT,
	salary int
	);
	
CREATE TABLE animals (
	animal_id serial PRIMARY KEY,
	animal_type TEXT,
	animal_quantity int,	
	employee_id_fk int REFERENCES employees(employee_id)
	);
	
DROP TABLE IF EXISTS animals;
DROP TABLE IF EXISTS employees;
