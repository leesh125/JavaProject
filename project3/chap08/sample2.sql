CREATE OR REPLACE PROCEDURE PROC_EMPLOYEES IS
BEGIN
    FOR R IN (SELECT * FROM EMPLOYEES WHERE ROWNUM <= 3) LOOP
        DBMS_OUTPUT.PUT_LINE(R.EMPLOYEE_ID || ' | ' || CONCAT(R.FIRST_NAME, R.LAST_NAME));
    END LOOP;
END;
/

EXEC PROC_EMPLOYEES;

CREATE OR REPLACE
PROCEDURE PROC_EMPLOYEES(top_n IN NUMBER := 3) IS
BEGIN
    FOR R IN (SELECT * FROM EMPLOYEES WHERE ROWNUM <= top_n) LOOP
        DBMS_OUTPUT.PUT_LINE(R.EMPLOYEE_ID || ' | ' || CONCAT(R.FIRST_NAME, R.LAST_NAME));
    END LOOP;
END;
/
EXEC PROC_EMPLOYEES;
EXEC PROC_EMPLOYEES(5);

CREATE OR REPLACE
PROCEDURE PROC_EMPLOYEES(top_n IN NUMBER := 3, job IN VARCHAR2 := '') IS
BEGIN
    FOR R IN (SELECT * FROM (SELECT * 
                               FROM EMPLOYEES 
                              WHERE JOB_ID LIKE '%' || job || '%')
               WHERE ROWNUM <= top_n) LOOP
        DBMS_OUTPUT.PUT_LINE(R.EMPLOYEE_ID || ' | ' || CONCAT(R.FIRST_NAME, R.LAST_NAME));
    END LOOP;
END;
/
EXEC PROC_EMPLOYEES;
EXEC PROC_EMPLOYEES(5);
EXEC PROC_EMPLOYEES(5, 'IT');

SELECT * FROM USER_SOURCE WHERE NAME = 'PROC_EMPLOYEES';


CREATE OR REPLACE
PROCEDURE PROC_STD_PRO_INFO(hidden IN BOOLEAN := TRUE) IS
    HIDDEN_YN   BOOLEAN;
BEGIN
    HIDDEN_YN := hidden;
    FOR R IN (SELECT * FROM V_STD_PROF_INFO WHERE ROWNUM <= 10) LOOP
        DBMS_OUTPUT.PUT(R.NAME || ' | ');

        IF HIDDEN_YN THEN
            DBMS_OUTPUT.PUT(SUBSTR(R.SSN, 1, 8) || '******' || ' | ');
        ELSE
            DBMS_OUTPUT.PUT(R.SSN);
        END IF;

        DBMS_OUTPUT.PUT(R.ADDR);
        DBMS_OUTPUT.PUT_LINE('');
    END LOOP;
END;
/

EXEC PROC_STD_PRO_INFO;
EXEC PROC_STD_PRO_INFO(FALSE);


CREATE OR REPLACE
PROCEDURE PROC_EMPLOYEES(top_n IN NUMBER := 3, total OUT NUMBER) IS
BEGIN
    total := 0;
    FOR R IN (SELECT * FROM EMPLOYEES WHERE ROWNUM <= top_n) LOOP
        DBMS_OUTPUT.PUT_LINE(R.EMPLOYEE_ID || ' | ' || CONCAT(R.FIRST_NAME, R.LAST_NAME));
        total :=  total + R.SALARY;
    END LOOP;
END;
/

-- 전역 변수
VARIABLE ret_val NUMBER;
EXEC PROC_EMPLOYEES(5, :ret_val);
PRINT ret_val;

DECLARE
    ret_val NUMBER;
BEGIN
    PROC_EMPLOYEES(5, ret_val);
    DBMS_OUTPUT.PUT_LINE(ret_val);
END;