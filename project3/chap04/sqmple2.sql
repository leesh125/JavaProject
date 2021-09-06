-- KEEP 을 사용하여 집계 대상의 컬럼 외의 추가 식별 컬럼 포함.
-- 부서별 급여가 가장 높은 사원을 조회.
SELECT DEPARTMENT_ID
     , MAX(FIRST_NAME) KEEP(DENSE_RANK FIRST ORDER BY SALARY DESC) AS FIRST_NAME
     --       A        KEEP                             B
     --       B 컬럼을 기준으로 정렬 후 A 컬럼의 값을 추출하여 SELECT 절에 사용
     --       ORDER BY 기준으로 정렬    FIRST 위치의 값을 추출
     --       DENSE_RANK : 조회 컬럼에 대한 랭킹을 부여하는 기능
     , MAX(SALARY)
  FROM EMPLOYEES
 GROUP BY DEPARTMENT_ID
 ORDER BY DEPARTMENT_ID;

-- 부서별 평균급여가 가장 높은 부서와 낮은 부서
WITH TEMP AS (  -- 임시 테이블을 만들어서 다음 쿼리에 사용하기 위해 쓰인다.
SELECT DEPARTMENT_ID AS 부서번호
     , AVG(SALARY) AS 평균급여
  FROM EMPLOYEES
 GROUP BY DEPARTMENT_ID
 ORDER BY DEPARTMENT_ID
)
SELECT MIN(평균급여) AS 최저급여
     , MIN(부서번호) KEEP(DENSE_RANK FIRST ORDER BY 평균급여) AS 부서번호
  FROM TEMP;

WITH TEMP AS (
SELECT DEPARTMENT_ID AS 부서번호
     , AVG(SALARY) AS 평균급여
  FROM EMPLOYEES
 GROUP BY DEPARTMENT_ID
 ORDER BY DEPARTMENT_ID
)
SELECT MAX(평균급여) AS 최고급여
     , MAX(부서번호) KEEP(DENSE_RANK FIRST ORDER BY 평균급여 DESC) AS 부서번호
  FROM TEMP;


-- HAVING 절 : GROUP BY 로 그룹별 집계에 대한 결과에 대해서 추가 조회 조건을 이용하여
-- 조회를 하기 위해 사용

-- 부서별 평균급여를 조회하고 그 결과에서 평균급여의 값이 5000 이상인 데이터만 조회
SELECT DEPARTMENT_ID
     , AVG(SALARY)
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IS NOT NULL
 GROUP BY DEPARTMENT_ID
HAVING AVG(SALARY) >= 5000
 ORDER BY DEPARTMENT_ID;

/*
    SQL 쿼리 동작 순서
        1. FROM 절(필수)
        2. WHERE 절
        3. GROUP BY 절
        4. HAVING 절
        5. SELECT 절(필수)
        6. ORDER BY 절
*/

-- ROLLUP : 그룹별 산출 결과의 집계를 계산하는 함수
--          2개 이상의 인자를 부여하는 경우 첫번째 인자로 그룹화하여 구한 집계와
--          두번째 인자를 추가로 그룹화하여 구한 집계, 전체 ROW 정보를 집계한 결과를 출력
SELECT DEPARTMENT_ID
     , AVG(SALARY)
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IS NOT NULL
 GROUP BY ROLLUP(DEPARTMENT_ID);

SELECT DEPARTMENT_ID
     , JOB_ID
     , AVG(SALARY)
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IS NOT NULL
 GROUP BY ROLLUP(DEPARTMENT_ID, JOB_ID);

-- CUBE : 그룹별 산출 결과의 집계를 계산하는 함수
--        인자로 지정한 컬럼에 대해 가능한 모든 조합별 집계 결과를 반환
SELECT DEPARTMENT_ID
     , AVG(SALARY)
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IS NOT NULL
 GROUP BY CUBE(DEPARTMENT_ID);

SELECT DEPARTMENT_ID
     , JOB_ID
     , AVG(SALARY)
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IS NOT NULL
 GROUP BY CUBE(DEPARTMENT_ID, JOB_ID)
 ORDER BY 1;

-- 학과별 과목구분별 등록과목수량을 구하기 위한 집계함수 사용
-- 등록된 과목의 전체수량과 학과별 등록과목수량도 구할 수 있게 ROLLUP 함수 적용.
-- 가능한 모든 조합의 집계를 구하기위해 CUBE 함수도 적용한다. -> 별도의 쿼리 사용하여.
SELECT DEPARTMENT_NO
     , CLASS_TYPE
     , COUNT(CLASS_NO)
  FROM TB_CLASS
 GROUP BY ROLLUP(DEPARTMENT_NO, CLASS_TYPE)
 ORDER BY DEPARTMENT_NO NULLS FIRST, CLASS_TYPE;

SELECT DEPARTMENT_NO
     , CLASS_TYPE
     , COUNT(CLASS_NO)
  FROM TB_CLASS
 GROUP BY CUBE(DEPARTMENT_NO, CLASS_TYPE);


-- GROUPING 함수 : ROLLUP 또는 CUBE에 의한 집계 산출이 어떤 컬럼에 대한 산출물인지
-- 확인하기위한 함수
-- GROUPING(컬럼명) : 결과가 0 이면 해당 컬럼의 산출물이다. 1이면 해당 컬럼의 산출물이 아니다.
SELECT DEPARTMENT_NO
     , CLASS_TYPE
     , COUNT(CLASS_NO)
     , GROUPING(DEPARTMENT_NO) AS 부서별집계
     , GROUPING(CLASS_TYPE) AS 과목구분별집계
  FROM TB_CLASS
 GROUP BY CUBE(DEPARTMENT_NO, CLASS_TYPE);

-- CASE WHEN 구문 : IF 문과 같이 동작하도록 구성된 ORACLE SQL 구문
SELECT DEPARTMENT_NO
     , CLASS_TYPE
     , COUNT(CLASS_NO)
     , CASE WHEN GROUPING(DEPARTMENT_NO) = 0 AND GROUPING(CLASS_TYPE) = 0 THEN '학과/과목구분별 집계'
            WHEN GROUPING(DEPARTMENT_NO) = 0 AND GROUPING(CLASS_TYPE) = 1 THEN '학과별 집계'
            WHEN GROUPING(DEPARTMENT_NO) = 1 AND GROUPING(CLASS_TYPE) = 0 THEN '과목구분별 집계'
            ELSE '전체집계'
        END AS 구분
  FROM TB_CLASS
 GROUP BY CUBE(DEPARTMENT_NO, CLASS_TYPE);

-- 집합 관련 연산자
-- 여러 쿼리 결과에 대한 집합을 구하기 위해 사용하는 연산자
-- 두 쿼리에 대한 컬럼 수는 동일해야 한다.
-- UNION, UNION ALL, MINUS, INTERSECT 가 있다.
SELECT DEPARTMENT_ID
     , DEPARTMENT_NAME
     , LOCATION_ID
  FROM DEPARTMENTS
 WHERE LOCATION_ID IN (1800, 2400)
UNION ALL
-- UNION -> 중복 결과에 대해서는 하나의 쿼리 결과만 반영한다.
SELECT DEPARTMENT_ID
     , DEPARTMENT_NAME
     , LOCATION_ID
  FROM DEPARTMENTS
 WHERE LOCATION_ID IN (2400, 2500);

-- INTERSECT : 교집합, 두 쿼리 결과의 공통 결과만 조회
SELECT DEPARTMENT_ID
     , DEPARTMENT_NAME
     , LOCATION_ID
  FROM DEPARTMENTS
 WHERE LOCATION_ID IN (1800, 2400)
INTERSECT
SELECT DEPARTMENT_ID
     , DEPARTMENT_NAME
     , LOCATION_ID
  FROM DEPARTMENTS
 WHERE LOCATION_ID IN (2400, 2500);

-- MINUS : 차집합, 두 쿼리 결과에서 공통된 부분과 두 번째 쿼리 결과를 뺀 나머지 결과를 조회
SELECT DEPARTMENT_ID
     , DEPARTMENT_NAME
     , LOCATION_ID
  FROM DEPARTMENTS
 WHERE LOCATION_ID IN (1800, 2400)
MINUS
SELECT DEPARTMENT_ID
     , DEPARTMENT_NAME
     , LOCATION_ID
  FROM DEPARTMENTS
 WHERE LOCATION_ID IN (2400, 2500);