-- 오라클 제공 함수
SELECT ROUND(1.1234, 2), ROUND(1.4567, 3),  -- 반올림
       TRUNC(1.1234, 2), TRUNC(1.4567, 3),  -- 버림
       POWER(2,2), POWER(3,2),              -- 제곱
       MOD(5,2), MOD(7,5)                   -- 나머지
  FROM DUAL;


SELECT LOWER('ABCD'), UPPER('abcd'),        -- 대소문자 변환
       CONCAT('abcd', 'efgh'),              -- 문자열 결합
       LTRIM('  abcd'), RTRIM('abcd  '),    -- 왼쪽/오른쪽 공백제거
       LTRIM('---abcd---', '-'),            -- 왼쪽/오른쪽에 있는 문자를 제거(지정한 문자에 대해 제거)
       RTRIM('---abcd---', '-'),
       TRIM('   abcd    '), TRIM('-' FROM '---abcd---')
  FROM DUAL;

SELECT SUBSTR('substr', 4, 3),
       SUBSTR('문자열자르기', 4, 3),
       REPLACE('str_replace', 'replace', '바꾸기'),
       LENGTH('문자열길이'), LENGTHB('문자열길이')
  FROM DUAL;

SELECT NVL(NULL, 1), NVL('널아님', 1),
       NVL2(NULL, 1, 2), NVL2('널아님', 1, 2)
  FROM DUAL;

SELECT DECODE('val1','val2','val3','val4'),
       DECODE('val2','val2','val3','val4'),
       DECODE('val1','val2','val3','val4','val5','val6'),
       DECODE('val2','val2','val3','val4','val3','val4'),
       DECODE('val4','val2','val3','val4','val5','val6')
  FROM DUAL;

SELECT SYSDATE, TO_CHAR(SYSDATE, 'yyyy-mm-dd'),
       TO_CHAR(SYSDATE, 'yyyy-mm-dd hh:mi:ss'),
       SYSTIMESTAMP, TO_CHAR(SYSTIMESTAMP, 'yyyy-mm-dd'),
       TO_CHAR(SYSTIMESTAMP, 'yyyy-mm-dd hh:mi:ss')
  FROM DUAL;

SELECT TO_DATE('210505', 'yy-mm-dd'),
       TO_TIMESTAMP('2021-09-01', 'yyyy-mm-dd')
  FROM DUAL;

SELECT EXTRACT(YEAR FROM TO_DATE('210505', 'yy-mm-dd')) || '년 ' ||
       EXTRACT(MONTH FROM TO_DATE('210505', 'yy-mm-dd')) || '월 ' ||
       EXTRACT(DAY FROM TO_DATE('210505', 'yy-mm-dd')) || '일'
  FROM DUAL;
SELECT EXTRACT(YEAR FROM TO_DATE('210505', 'yy-mm-dd')) || '년 ' ||
       EXTRACT(MONTH FROM TO_DATE('210505', 'yy-mm-dd')) || '월 ' ||
       EXTRACT(DAY FROM TO_DATE('210505', 'yy-mm-dd')) || '일',
       EXTRACT(HOUR FROM SYSTIMESTAMP),
       EXTRACT(MINUTE FROM SYSTIMESTAMP),
       EXTRACT(SECOND FROM SYSTIMESTAMP)
  FROM DUAL;

SELECT TO_NUMBER('10'), TO_CHAR(10),
       TO_NUMBER('10.5'), TO_CHAR(10.5)
  FROM DUAL;

SELECT NVL(COMMISSION_PCT, 0)
  FROM EMPLOYEES;



-- EMPLOYEES 테이블의 내용을 조회 할 때 다음의 조건을 만족하도록 조회하시오.
--     1. first_name 과 last_name 은 하나로 합쳐서 name 이라는 이름으로 조회한다.
--     2. email 에 @employee.com 을 붙여서 조회한다. 그리고 소문자로 출력되어야 한다.
--     3. hire_date 컬럼은 년-월-일 형식으로 조회되도록 한다.
--     4. commission_pct 에서 널값을 0.0 으로 대체하도록 한다.
--     5. phone_number에서 전화번호에 사용한 구분자를 . 이 아닌 - 으로 변경하여 조회한다.
--     6. commission_pct 에 값이 있는 직원에 대해 salary * (1 + commission_pct) 한 결과를
--        추가급여 항목으로 출력하시오.
SELECT * FROM EMPLOYEES;

SELECT FIRST_NAME, HIRE_DATE, FLOOR((SYSDATE - HIRE_DATE) / (365 / 12)) AS 근속개월
  FROM EMPLOYEES;
SELECT EMPLOYEE_ID,
       CONCAT(first_name, ' ' || last_name) AS name,
       CONCAT(LOWER(email), '@employee.com') AS Email,
       REPLACE(phone_number, '.', '-') AS "Phone Number",
       TO_CHAR(HIRE_DATE, 'yyyy-mm-dd') AS HIRE_DATE,
       FLOOR((SYSDATE - HIRE_DATE) / 365) AS 근속년,
 --    TRUNC((SYSDATE - HIRE_DATE)/ 365,0) AS 근속년,
       JOB_ID,
       SALARY,
       NVL(COMMISSION_PCT, 0.0) AS COMMISSION_PCT,
       SALARY * (1 + NVL(COMMISSION_PCT, 0)) AS 추가급여,
       MANAGER_ID,
       DEPARTMENT_ID
  FROM EMPLOYEES
 WHERE HIRE_DATE >= TO_DATE('1989-12-31', 'yyyy-mm-dd');
 -- WHERE HIRE_DATE BETWEEN TO_DATE('1987-01-01', 'yyyy-mm-dd')
 --                  AND TO_DATE('1989-12-31', 'yyyy-mm-dd');

SELECT INSTR(EMAIL, '-', -1, 1)
  FROM EMPLOYEES;

SELECT EMAIL
  FROM EMPLOYEES
 WHERE EMAIL LIKE '___#_%' ESCAPE '#';

UPDATE EMPLOYEES
SET EMAIL= 'abc_user_1@gma_s.com'
WHERE EMPLOYEE_ID = 204;
SELECT *
FROM EMPLOYEES
WHERE INSTR(EMAIL, '_', -1, 1) = 4;​

SELECT PHONE_NUMBER
  FROM EMPLOYEES
 WHERE PHONE_NUMBER LIKE '%-1%';




SELECT FIRST_NAME, HIRE_DATE, FLOOR((SYSDATE - HIRE_DATE) / (365 / 12))
  FROM EMPLOYEES;

SELECT NVL(COMMISSION_PCT, 0)

  FROM EMPLOYEES;

SELECT FIRST_NAME AS 이름, SALARY AS 월급,
               COMMISSION_PCT AS 보너스, HIRE_DATE AS 고용일, FLOOR((SYSDATE - HIRE_DATE) /(365/12))

  FROM EMPLOYEES

 WHERE FLOOR((SYSDATE - HIRE_DATE) /365)>= 30;

SELECT EMAIL
FROM EMPLOYEES
WHERE INSTR(EMAIL, '@', -1, 1) = 9;​

SELECT * FROM EMPLOYEES WHERE COMMISSION_PCT IS NULL AND EMPLOYEE_ID IS NOT NULL;


-- Sample

SELECT *
  FROM EMPLOYEES;

SELECT *
  FROM EMPLOYEES
 WHERE COMMISSION_PCT IS NOT NULL;

SELECT *
  FROM EMPLOYEES
 WHERE COMMISSION_PCT IS NULL;

SELECT *
  FROM EMPLOYEES
 WHERE MANAGER_ID IS NULL;

SELECT EMPLOYEE_ID, SALARY
  FROM EMPLOYEES
 WHERE SALARY >= 10000;

SELECT EMPLOYEE_ID, SALARY*1161.49 AS "SALARY(원)"
  FROM EMPLOYEES
 WHERE SALARY*1161.49 <= 5000000; 

SELECT EMPLOYEE_ID, 
       CONCAT(first_name, ' ' || last_name) AS name,
       JOB_ID, 
       TO_CHAR(HIRE_DATE, 'yyyy') || '년 ' ||
       TO_CHAR(HIRE_DATE, 'mm') || '월 ' ||
       TO_CHAR(HIRE_DATE, 'dd') || '일' AS HIRE_DATE
  FROM EMPLOYEES;

SELECT EMPLOYEE_ID, 
       CONCAT(first_name, ' ' || last_name) AS name,
       SALARY,
       SALARY * 12 AS YEAR_SALARY
  FROM EMPLOYEES;

SELECT EMPLOYEE_ID, 
       CONCAT(first_name, ' ' || last_name) AS name,
       SALARY,
       COMMISSION_PCT,
       SALARY * (1+NVL(COMMISSION_PCT, 0)) * 12 AS YEAR_SALARY
  FROM EMPLOYEES;
 
SELECT EMPLOYEE_ID, HIRE_DATE
  FROM EMPLOYEES
 WHERE TO_CHAR(HIRE_DATE, 'MMDD') BETWEEN '0101' AND '0331';

SELECT EMPLOYEE_ID, HIRE_DATE
  FROM EMPLOYEES
 WHERE TO_CHAR(HIRE_DATE, 'YYYYMMDD') > '19891231';

SELECT EMPLOYEE_ID, HIRE_DATE
  FROM EMPLOYEES
 WHERE FLOOR((SYSDATE - HIRE_DATE) / 365) > 30; 