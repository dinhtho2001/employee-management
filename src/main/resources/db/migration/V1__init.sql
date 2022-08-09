CREATE TABLE employee(
    emp_id bigint AUTO_INCREMENT,
    fname nvarchar(150) not null,
    lname nvarchar(150) not null,
    gender bit not null,
    age date null, 
    contact_add varchar(13) not null,
    emp_email varchar(255) not null,
    emp_pass varchar(255) not null,
    PRIMARY KEY(emp_id)
);

CREATE TABLE role(
    id bigint AUTO_INCREMENT,
    name varchar(50) not null,
    PRIMARY KEY(id)
);

CREATE TABLE employee_roles(
    emp_id bigint,
    role_id bigint,
    PRIMARY KEY(emp_id, role_id),
   CONSTRAINT emp_id FOREIGN KEY (emp_id) REFERENCES employee(emp_id),
   CONSTRAINT role_id FOREIGN KEY (role_id) REFERENCES role(id)
); 

CREATE TABLE qualification(
    qual_id bigint AUTO_INCREMENT,
    emp_id bigint not null,
    position nvarchar(255) not null,
    requirements nvarchar(255) null,
    date_in  date,
    PRIMARY KEY(qual_id),
    CONSTRAINT qual_emp_id FOREIGN KEY (emp_id) REFERENCES employee(emp_id) on update cascade on delete cascade
);

CREATE TABLE emp_leave(
    leave_id bigint AUTO_INCREMENT,
    emp_id bigint not null,
    date date  not null,
    reason nvarchar(255) not null,
    PRIMARY KEY(leave_id),
	CONSTRAINT leave_emp_id FOREIGN KEY (emp_id) REFERENCES employee(emp_id) on update cascade on delete cascade
);

CREATE TABLE job_department(
    job_id bigint AUTO_INCREMENT,
    job_dept varchar(255) not null,
    name nvarchar(255) not null,
    description nvarchar(255) null,
    salary_range  float not null,
    PRIMARY KEY(job_id)
);

CREATE TABLE salary(
    salary_id bigint AUTO_INCREMENT,
    job_id bigint not null,
    amount int not null,
    anual int not null,
    bonus  float,
    PRIMARY KEY(salary_id),
    CONSTRAINT salary_job_id FOREIGN KEY (job_id) REFERENCES job_department(job_id) on update cascade on delete cascade
);

CREATE TABLE payroll(
    payroll_id bigint AUTO_INCREMENT,
    emp_id bigint null,
    job_id bigint null,
    salary_id bigint null,
    leave_id  bigint null,
    date date not null,
    report nvarchar(255) not null,
    total_amount float not null,
    PRIMARY KEY(payroll_id),
    CONSTRAINT payroll_emp_id FOREIGN KEY (emp_id) REFERENCES employee(emp_id) on update cascade on delete cascade,
    CONSTRAINT payroll_job_id FOREIGN KEY (job_id) REFERENCES job_department(job_id) on update cascade on delete cascade,
    CONSTRAINT payroll_salary_id FOREIGN KEY (salary_id) REFERENCES salary(salary_id) on update cascade on delete cascade,
    CONSTRAINT payroll_leave_id FOREIGN KEY (leave_id) REFERENCES emp_leave(leave_id) on update cascade on delete cascade
 );   
   