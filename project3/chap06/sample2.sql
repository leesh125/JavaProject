-- 다음 작업을 위한 테이블 생성
CREATE TABLE EMP_TEMP1 AS
    SELECT A.EMPLOYEE_ID AS EMP_ID
         , A.FIRST_NAME || ' ' || A.LAST_NAME AS NAME
         , A.SALARY AS SALARY
         , B.DEPARTMENT_NAME AS DEPT_NAME
      FROM EMPLOYEES A JOIN DEPARTMENTS B
        ON A.DEPARTMENT_ID = B.DEPARTMENT_ID;

-- 업데이트를 할 때 서브쿼리를 이용
UPDATE EMP_TEMP1
   SET SALARY = (SELECT SALARY FROM EMP_TEMP1 WHERE EMP_ID = 202)
 WHERE EMP_ID = 200;

UPDATE EMP_TEMP1
   SET (SALARY, DEPT_NAME) = (SELECT SALARY, DEPT_NAME FROM EMP_TEMP1 WHERE EMP_ID = 202)
 WHERE EMP_ID = 200;

SELECT * FROM EMP_TEMP1 WHERE EMP_ID = 200;

-- EMPLOYEES 테이블의 정보를 보면 커미션이 있는 사원이 있다.
-- 커미션이 있는 사원의 경우 급여항목이 커미션이 포함된 급여로 저장될 수 있게
-- EMP_TEMP1 테이블의 SALARY 를 업데이트

SELECT * FROM EMP_TEMP1 WHERE EMP_ID BETWEEN 170 AND 179;
SELECT * FROM EMPLOYEES WHERE COMMISSION_PCT IS NOT NULL;


/*
    1. UPDATE 는 ROW 단위로 반복 처리 된다.
    2. SET에 사용되는 값은 단일 갑스 단일 ROW로 사용해야 한다.
*/
UPDATE EMP_TEMP1
   SET SALARY = (SELECT (1+ COMMISSION_PCT)*SALARY AS SALARY 
                   FROM EMPLOYEES 
                  WHERE EMP_TEMP1.EMP_ID = EMPLOYEE_ID)
 WHERE EMP_ID IN (SELECT EMPLOYEE_ID FROM EMPLOYEES WHERE COMMISSION_PCT IS NOT NULL);


SELECT * FROM EMP_TEMP1
 WHERE EMP_ID IN(SELECT EMPLOYEE_ID FROM EMPLOYEES WHERE COMMISSION_PCT IS NOT NULL);


SELECT * FROM EMP_TEMP1;
DROP TABLE EMP_TEMP;



DELETE
  FROM EMP_TEMP1
 WHERE EMP_ID IN (SELECT EMPLOYEE_ID
                    FROM EMPLOYEES
                   WHERE COMMISSION_PCT IS NULL);


CREATE TABLE P_TAB(
      ID NUMBER,
      NAME VARCHAR2(30)
);
ALTER TABLE P_TAB ADD CONSTRAINT P_TAB_ID_PK PRIMARY KEY(ID);
INSERT ALL INTO P_TAB VALUES(ID, NAME)
SELECT EMPLOYEE_ID AS ID,
       LAST_NAME NAME
  FROM EMPLOYEES;

-- 자식 테이블 생성
CREATE TABLE C_TAB(
    ID NUMBER,
    F_ID NUMBER,
    NAME VARCHAR2(30)
);
ALTER TABLE C_TAB ADD CONSTRAINT C_TAB_ID_PK PRIMARY KEY(ID);
ALTER TABLE C_TAB ADD CONSTRAINT C_TAB_P_TAB_F_ID_FK FOREIGN KEY(F_ID) REFERENCES P_TAB(ID);

INSERT INTO C_TAB VALUES(1, 100, 'aaaa');
INSERT INTO C_TAB VALUES(2, 101, 'bbbb');
INSERT INTO C_TAB VALUES(3, 102, 'cccc');

-- 제약조건으로 삭제 안됨
SELECT * FROM P_TAB WHERE ID IN (100, 101, 102);
SELECT * FROM C_TAB WHERE F_ID IN (100, 101, 102);
DELETE FROM P_TAB WHERE ID IN (100, 101, 102);

-- 제약조건으로 삭제가 안되는 경우 일시적으로 해당 제약조건을 비활성화 시킴
ALTER TABLE C_TAB DISABLE CONSTRAINT C_TAB_P_TAB_F_ID_FK;
DELETE FROM P_TAB WHERE ID IN (100, 101, 102);

-- 비활성화한 제약조건을 활성화
-- NOVALIDATE 옵션을 같이 사용해야 부모 테이블의 키를 참조할 수 있는지 검사를 안함.
ALTER TABLE C_TAB ENABLE NOVALIDATE CONSTRAINT C_TAB_P_TAB_F_ID_FK;

/*
    트랜잭션 : 어떠한 작업을 완전히 처리하기 까지의 과정(단위)
        - COMMIT : 현재 세션에서 작업한 모든 내용을 완전히 반영하기 위해 사용하는 명령어
        - ROLLBACK : 현재 세션에서 작업한 모든 내용을 이전 상태로 되돌리기 위해 사용하는 명령어
    예)
        쇼핑몰에서 사용자가 상품을 최종 결제하기 까지의 일련의 과정에서 중간에 문제가 발샐
        하였을 때 현재까지의 처리 내용을 다시 이전상태로 되돌리거나 완전히 반영하기 위해 사용
        트랜잭션 시작                                                     트랜잭션 끝      
            상품 선택 -> 수량 설정 -> 쇼핑몰에서의 결제 진행 -> 카드사의 결제 진행
                                                                             COMMIT -> 반영
                                     ROLLBACK -> 이전까지의 작업 무효                                                                                
*/
-- 자동 커밋기능 비활성화
SET AUTOCOMMIT OFF;

-- 자동 커밋기능 활성화
SET AUTOCOMMIT ON;

SELECT * FROM C_TAB;
DELETE FROM C_TAB;
ROLLBACK;
COMMIT;


SELECT * FROM TB_STUDENT;
SELECT * FROM TB_GRADE;

CREATE TABLE TB_STU_TEMP2009 AS
    SELECT A.EMPLOYEE_ID AS EMP_ID
         , A.FIRST_NAME || ' ' || A.LAST_NAME AS NAME
         , A.SALARY AS SALARY
         , B.DEPARTMENT_NAME AS DEPT_NAME
      FROM TB_STUDENT S JOIN TB_GRADE G
        ON S.STUDENT_NO = G.STUDENT_NO;