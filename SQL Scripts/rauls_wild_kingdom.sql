
--Create tables for jobs, employees, animals, habitats, and enclosures
CREATE TABLE jobs (
	job_id serial PRIMARY KEY,
	job_title TEXT,
	salary int
);

CREATE TABLE employees (
	employee_id serial PRIMARY KEY,
	f_name TEXT,
	l_name TEXT,
	job_id_fk int REFERENCES jobs(job_id)
);

CREATE TABLE habitats (
	habitat_id serial PRIMARY KEY,
	habitat_type TEXT
);

CREATE TABLE enclosures (
	enclosure_id serial PRIMARY KEY,
	enclosure_type TEXT
);

CREATE TABLE animals (
	animal_id serial PRIMARY KEY,
	animal_type TEXT,
	animal_quantity int,
	feed_required int,
	been_fed boolean DEFAULT FALSE,
	employee_id_fk int REFERENCES employees(employee_id),
	habitat_id_fk int REFERENCES habitats(habitat_id),
	enclosure_id_fk int REFERENCES enclosures(enclosure_id)
);

DROP TABLE IF EXISTS animals;
DROP TABLE IF EXISTS enclosures;
DROP TABLE IF EXISTS habitats;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS jobs;

--Intro Values
INSERT INTO jobs (job_title, salary)
VALUES ('Manager', 100000),
	   ('Wildlife Presenter', 80000),
	   ('Feeder', 60000);

INSERT INTO employees (f_name, l_name, job_id_fk)
VALUES ('Raul', 'Hernandez', 2),
	   ('George', 'Newman', 1),
	   ('Stanley', 'Spudowski', 3);

INSERT INTO habitats (habitat_type)
VALUES ('City'),
	   ('Ocean'),
	   ('Rivers'),
	   ('Desert'),
	   ('Mountain'),
	   ('Great White North'),
	   ('Forest');

INSERT INTO enclosures (enclosure_type)
VALUES ('Glass Cage'),
	   ('Medium Inside'),
	   ('Large Inside'),
	   ('Medium Outside'),
	   ('Large Outside');

INSERT INTO animals (animal_type, animal_quantity, feed_required, employee_id_fk, habitat_id_fk, enclosure_id_fk)
VALUES ('Poodle', 12, 12, 1, 1, 4),
	   ('Turtle', 1, 1, 1, 2, 2),
	   ('Hippo', 3, 12, 3, 3, 5),
	   ('Ant', 1000, 1, 3, 4, 1);
