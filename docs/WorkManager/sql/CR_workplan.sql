CREATE TABLE Role (
    r_id INT NOT NULL
        CONSTRAINT ROLE_PK PRIMARY KEY
        GENERATED ALWAYS AS IDENTITY,
    r_rolename VARCHAR(12) NOT NULL
);

CREATE TABLE Employee (
    emp_id INT NOT NULL
        CONSTRAINT EMPLOYEE_PK PRIMARY KEY
        GENERATED ALWAYS AS IDENTITY,
    emp_r_id INT NOT NULL CONSTRAINT EMP_R_FK REFERENCES role(r_id),
    emp_firstname VARCHAR(32),
    emp_lastname VARCHAR(32),
    emp_phone_number VARCHAR(11)
);

CREATE TABLE Schedule (
    s_id INT NOT NULL
        CONSTRAINT SCHEDULE_PK PRIMARY KEY
        GENERATED ALWAYS AS IDENTITY,
    s_start_time TIME NOT NULL,
    s_end_time TIME NOT NULL,
    s_calendar_week SMALLINT NOT NULL
);

CREATE TABLE Member (
    m_id INT NOT NULL
        CONSTRAINT MEMBER_PK PRIMARY KEY
        GENERATED ALWAYS AS IDENTITY,
    m_s_id INT NOT NULL CONSTRAINT M_S_FK REFERENCES schedule(s_id),
    m_emp_id INT NOT NULL CONSTRAINT M_EMP_FK REFERENCES employee(emp_id),
    m_member_firstname VARCHAR(32),
    m_member_lastname VARCHAR(32),
    m_phone_number VARCHAR(11),
    m_r_id INT NOT NULL CONSTRAINT M_R_FK REFERENCES role(r_id)
);