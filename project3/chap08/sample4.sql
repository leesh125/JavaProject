SELECT * FROM EMPLOYEES;
SELECT * FROM DEPARTMENTS;
SELECT * FROM JOBS;

/*
    아직 부서 배정을 받지 못한 직원을 찾아서 적절한 부서로 배정받을 수 있는 프로시저를 생성한다.
        - 부서는 없지만 담당 관리직원이 있는 경우 관리직원의 부서로 배정한다.
        - 담당 관리직원도 없는 경우 직무코드에 맞는 부서로 배정한다.
        - 작업이 완료 된 후에는 배정이 완료된 인원 수를 알수 있도록 메시지를 출력한다.
*/
CREATE OR REPLACE PROCEDURE 부서배정(count OUT NUMBER)
IS
    DEPT_CODE   EMPLOYEES.DEPARTMENT_ID%TYPE;
    CNT         NUMBER := 0;
    no_data     EXCEPTION;  -- 사용자 정의 EXCEPTION
BEGIN
    FOR rec IN (SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID IS NULL) LOOP
        CNT := CNT + 1;

        IF rec.MANAGER_ID IS NOT NULL THEN
            SELECT DEPARTMENT_ID
              INTO DEPT_CODE
              FROM EMPLOYEES
             WHERE EMPLOYEE_ID = rec.MANAGER_ID;
        ELSE
            SELECT DISTINCT DEPARTMENT_ID
              INTO DEPT_CODE
              FROM EMPLOYEES
             WHERE JOB_ID = rec.JOB_ID
               AND DEPARTMENT_ID IS NOT NULL;
        END IF;

        IF DEPT_CODE IS NULL THEN
            RAISE no_data;  -- 강제로 에러 발생
        ELSE
            UPDATE EMPLOYEES
               SET DEPARTMENT_ID = DEPT_CODE
             WHERE EMPLOYEE_ID = rec.EMPLOYEE_ID;

            CNT := CNT + 1;
            DEPT_CODE := NULL;
        END IF;
    END LOOP;

    count := CNT;
    COMMIT;
    -- ROLLBACK;
EXCEPTION
    WHEN no_data THEN
        DBMS_OUTPUT.PUT_LINE('작업 중 문제가 발생하여 롤백하였습니다.');
        ROLLBACK;
END;
/

VARIABLE CNT NUMBER;
EXEC 부서배정(:CNT);
PRINT CNT;

SELECT * FROM EMPLOYEES  WHERE DEPARTMENT_ID IS NULL;
SELECT * FROM JOBS;
SELECT * FROM DEPARTMENTS;

/*
    KOR_DATE 함수를 만들어서 모든 날짜관련 데이터는 xxxx년 xx월 xx일로 변환될 수 있는
    함수를 생성한다.
*/
CREATE OR REPLACE FUNCTION KOR_DATE(mydate DATE) RETURN VARCHAR2
IS 
BEGIN 
    RETURN  TO_CHAR(mydate, 'yyyy"년" mm"월" dd"일"');
END;
/

SELECT KOR_DATE(HIRE_DATE) AS 날짜
  FROM EMPLOYEES;