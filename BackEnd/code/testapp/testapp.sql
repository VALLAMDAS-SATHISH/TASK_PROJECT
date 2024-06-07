# 
create database testApp;
use testApp;
# 1.employees 
create table employees (name varchar(30),designation varchar(40),ctc double ,email varchar(30));

desc employees;

select * from employees;

# 2.vendor
create table vendor(name varchar(30),email varchar(30),upi varchar(30));
desc vendor;
select * from vendor;

# 3. sent_emails 
CREATE TABLE sent_emails (
    id SERIAL PRIMARY KEY,
    recipient_email VARCHAR(255),
    email_content TEXT,
    sent_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
DESC sent_emails;

select * from sent_emails;


