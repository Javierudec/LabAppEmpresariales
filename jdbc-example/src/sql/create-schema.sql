-- All tables are dropped before creating them again
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS department;

-- Department
DROP SEQUENCE IF EXISTS department_id_seq;
CREATE SEQUENCE department_id_seq;

CREATE TABLE department (
	id INTEGER DEFAULT NEXTVAL('department_id_seq'),
	name VARCHAR(20),
	location VARCHAR(20),
	CONSTRAINT department_pk PRIMARY KEY (id)
);

-- Employee
DROP SEQUENCE IF EXISTS employee_id_seq;
CREATE SEQUENCE employee_id_seq;

CREATE TABLE employee (
	id INTEGER DEFAULT NEXTVAL('employee_id_seq'),
	name VARCHAR(20),
	job VARCHAR(20),
	salary DOUBLE PRECISION,
	departmentId INTEGER,
	CONSTRAINT employee_pk PRIMARY KEY (id),
	CONSTRAINT employee_fk FOREIGN KEY (departmentId) REFERENCES department(id)
);