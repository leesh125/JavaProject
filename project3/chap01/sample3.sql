-- user1 계정(스키마) 가 가지고 있는 모든 테이블에 대한 조회
SELECT country_id AS 국가코드
     , country_name AS 국가명
     , region_id AS 지역코드
  FROM countries;

SELECT department_id AS 부서코드
     , department_name AS 부서명
     , manager_id AS 관리자코드
     , location_id AS 위치코드
  FROM departments;

SELECT employee_id AS 사원코드
     , first_name AS 이름
     , last_name AS 성
     , email AS 이메일
     , phone_number AS 전화번호
     , hire_date AS 고용일
     , job_id AS 직무코드
     , salary AS 급여
     , commission_pct AS 인센티브
     , manager_id AS 관리자코드
     , department_id AS 부서코드
  FROM employees;

SELECT job_id AS 업무코드
     , job_title AS 업무명
     , min_salary AS 최소급여
     , max_salary AS 최대급여
  FROM jobs;

SELECT employee_id AS 사원번호
     , start_date AS 직무시작일
     , end_date AS 직무종료일
     , job_id AS 직무코드
     , department_id AS 부서코드
  FROM job_history;

SELECT location_id AS 위치코드
     , street_address AS 도로주소
     , postal_code AS 우편번호
     , city AS 도시명
     , state_province AS 주
     , country_id AS 국가코드
  FROM locations;

SELECT region_id AS 지역코드
     , region_name AS 지역이름
  FROM regions;

-- departments 테이블에서 department_name 이 Marketing 인 데이터 조회
SELECT department_id AS 부서코드
     , department_name AS 부서명
     , manager_id AS 관리자코드
     , location_id AS 위치코드
  FROM departments
 WHERE department_name = 'Marketing';

-- departments 테이블에서 department_name 이 IT 가 포함된 데이터 조회
SELECT department_id AS 부서코드
     , department_name AS 부서명
     , manager_id AS 관리자코드
     , location_id AS 위치코드
  FROM departments
 WHERE department_name LIKE '%IT%';

-- locations 테이블에서 country_id 가 US 인 데이터 조회를 할 때 street_address
-- , postal_code, city 컬럼이 조회되도록 한다.
SELECT street_address AS 도로주소
     , postal_code AS 우편번호
     , city AS 도시명
  FROM locations
 WHERE country_id = 'US';

-- locations 테이블에서 postal_code 가 5자리인 데이터 조회
SELECT location_id AS 위치코드
     , street_address AS 도로주소
     , postal_code AS 우편번호
     , city AS 도시명
     , state_province AS 주
     , country_id AS 국가코드
  FROM locations
 WHERE postal_code LIKE '_____';

-- employees 테이블에서 manager_id 가 100 이고 department_id 가 50인 데이터 조회
SELECT employee_id AS 사원코드
     , first_name AS 이름
     , last_name AS 성
     , email AS 이메일
     , phone_number AS 전화번호
     , hire_date AS 고용일
     , job_id AS 직무코드
     , salary AS 급여
     , commission_pct AS 인센티브
     , manager_id AS 관리자코드
     , department_id AS 부서코드
  FROM employees
 WHERE manager_id = 100
   AND department_id = 50;

-- employees 테이블에서 commission_pct 가 NULL 이 아니면서 salary 가 10000 이상인
-- 데이터를 조회
SELECT employee_id AS 사원코드
     , first_name AS 이름
     , last_name AS 성
     , email AS 이메일
     , phone_number AS 전화번호
     , hire_date AS 고용일
     , job_id AS 직무코드
     , salary AS 급여
     , commission_pct AS 인센티브
     , manager_id AS 관리자코드
     , department_id AS 부서코드
  FROM employees
 WHERE commission_pct IS NOT NULL
   AND salary >= 10000;

-- 위에서 조회한 모든 영문 컬럼을 한글로 바꾸어 조회하시오.