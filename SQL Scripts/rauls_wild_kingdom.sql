
--Table for Raul and employees
CREATE TABLE employees (
	employee_id serial PRIMARY KEY,
	f_name TEXT,
	l_name TEXT,
	role_title TEXT,
	salary int
	);

--Table to have animals assigned to individual employees
CREATE TABLE animals (
	animal_id serial PRIMARY KEY,
	animal_type TEXT,
	animal_quantity int,	
	employee_id_fk int REFERENCES employees(employee_id)
	);
	
DROP TABLE IF EXISTS animals;
DROP TABLE IF EXISTS employees;

--Intro Values
INSERT INTO employees (f_name, l_name, role_title, salary)
VALUES ('Raul', 'Hernandez', 'Star', 100000),
	   ('Joe', 'Dirt', 'Delivery Driver', 75000);
	   
INSERT INTO animals (animal_type, animal_quantity, employee_id_fk)
VALUES ('Turtles', 1, 1),
	   ('Ants', 10000, 1),
	   ('Poodles', 5, 1),
	   ('Aardvarks', 1, 2),
	   ('Flamingos', 1, 2),
	   ('Porcupines', 4, 2),
	   ('Armadillos', 3, 2);
	   
