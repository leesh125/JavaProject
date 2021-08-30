SELECT * FROM employees;

SELECT * FROM employees;

SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME FROM employees;

-- 가독성이 좋은 형태를 만든다.
SELECT EMPLOYEE_ID,
       FIRST_NAME,
       LAST_NAME
  FROM EMPLOYEES;

-- SELECT 절에서 산술 연산 사용
SELECT first_name || ' ' || last_name
     , salary * 12
  FROM employees;

-- AS 키워드로 커럼에 별칭 부여
SELECT first_name || ' ' || last_name AS 이름
     , salary * 12 AS 연봉
  FROM employees;

-- 중복 데이터를 제거하고 조회
SELECT DISTINCT department_id AS 부서ID, 
       manager_id AS 관리자ID
  FROM employees;

-- WHERE 절을 사용하여 조건 검색
SELECT department_id,
       first_name,
       last_name
  FROM employees
 WHERE department_id != 30;

SELECT department_id,
       first_name,
       last_name,
       salary
  FROM employees
 WHERE salary >= 10000
   AND department_id = 30;

SELECT department_id,
       first_name,
       last_name,
       salary
  FROM employees
 WHERE salary >= 10000;

SELECT *
  FROM employees
 WHERE commission_pct != NULL;

SELECT *
  FROM employees
 WHERE commission_pct IS NULL;

 SELECT *
  FROM employees
 WHERE commission_pct IS NOT NULL;

SELECT *
  FROM EMPLOYEES
 WHERE NULL = NULL
   AND department_id = 30;

SELECT *
  FROM employees
 WHERE phone_number LIKE '___.127.____';

SELECT *
  FROM employees
 WHERE phone_number LIKE '%127%';

-- 연산 우선순위는 () 소괄호로 조정해서 사용할 수 있다.
SELECT employee_id,
       salary,
       department_id
  FROM employees
 WHERE (department_id = 50 OR department_id = 60)
   AND salary >= 5000;

SELECT employee_id,
       salary,
       department_id
  FROM employees
 WHERE (department_id = 50 OR department_id = 60)
   AND salary >= 5000;



-- 임시 테이블을 사용하여 연산 테스트
SELECT 1 + 1 FROM DUAL;



