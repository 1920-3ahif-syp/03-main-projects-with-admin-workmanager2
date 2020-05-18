INSERT INTO ROLE(r_id,r_rolename) VALUES(1,'Manager');
INSERT INTO ROLE(r_id,r_rolename) VALUES(2,'Worker');

INSERT INTO EMPLOYEE(emp_id,emp_r_id,emp_name,emp_phone_number) VALUES(1,1,'Günther Mustermann','06602917371');
INSERT INTO MEMBER(emp_id,emp_r_id,emp_name,emp_phone_number) VALUES(1,2,'Max Mustermann','06601943824');
INSERT INTO MEMBER(emp_id,emp_r_id,emp_name,emp_phone_number) VALUES(1,2,'Anna Gruber','06605926301');

INSERT INTO SCHEDULE(s_id,s_start_time,s_end_time,s_calendar_week) VALUES(1,TIME('08:00:00'),TIME('16:00:00'),22);
INSERT INTO SCHEDULE(s_id,s_start_time,s_end_time,s_calendar_week) VALUES(1,TIME('10:00:00'),TIME('18:00:00'),23);
