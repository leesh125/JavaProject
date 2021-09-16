SET SERVEROUTPUT ON;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Hello PL/SQL');
END;
/
DECLARE
    ID NUMBER;
    NAME VARCHAR2(10);
BEGIN
    ID := 5;
    NAME := '홍길동';
    DBMS_OUTPUT.PUT_LINE('번호 : ' || ID);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || NAME);
END;
/
DECLARE
    ID NUMBER := 5;
    NAME VARCHAR2(10) := '홍길동';
BEGIN
    DBMS_OUTPUT.PUT_LINE('번호 : ' || ID);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || NAME);
END;
/
DECLARE
    ID NUMBER := 5;
    NAME VARCHAR2(10) := '홍길동';
BEGIN
    ID := ID + 1;
    DBMS_OUTPUT.PUT_LINE('번호 : ' || ID);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || NAME);
END;
/
DECLARE
    INPUT_NUM NUMBER;
    VAL NUMBER;
BEGIN
    VAL := &INPUT_NUM;
    DBMS_OUTPUT.PUT_LINE('입력한 정수값 : ' || VAL);
END;
/
DECLARE
    INPUT_NUM NUMBER;
    VAL NUMBER;
BEGIN
    VAL := &INPUT_NUM;
    IF(MOD(VAL, 2) = 0) THEN
        DBMS_OUTPUT.PUT_LINE('짝수를 입력했습니다.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('홀수를 입력했습니다.');
    END IF;
END;
/
DECLARE
    INPUT_NUM NUMBER;
    VAL NUMBER;
BEGIN
    VAL := &INPUT_NUM;
    IF (MOD(VAL, 2) = 0) THEN
        DBMS_OUTPUT.PUT_LINE('짝수를 입력했습니다.');
    ELSIF (MOD(VAL, 2) = 1) THEN
        DBMS_OUTPUT.PUT_LINE('홀수를 입력했습니다.');
    END IF;
END;
/
DECLARE
    INPUT_NUM NUMBER;
    VAL NUMBER;
BEGIN
    VAL := &INPUT_NUM;
    LOOP    -- 무한 반복 가능
        DBMS_OUTPUT.PUT_LINE('반복문 입니다. : ' || VAL);
        VAL := VAL - 1;
        IF VAL = 0 THEN EXIT;
        END IF;
    END LOOP;
END;
/
BEGIN
    FOR I IN 0..3 LOOP
        DBMS_OUTPUT.PUT_LINE('반복문 입니다. : ' || I);
    END LOOP;
END;
/
BEGIN
    FOR I IN REVERSE 0..3 LOOP
        DBMS_OUTPUT.PUT_LINE('반복문 입니다. : ' || I);
    END LOOP;
END;
/
DECLARE
    VAL NUMBER;
BEGIN
    VAL := 0;
    WHILE VAL < 3 LOOP
        DBMS_OUTPUT.PUT_LINE('WHILE 반복문 입니다. : ' || VAL);
        VAL := VAL + 1;
    END LOOP;
END;
/
DECLARE
    FNAME VARCHAR2(20);
    LNAME VARCHAR2(25);
    SALARY NUMBER(8, 2);
BEGIN
    SELECT FIRST_NAME
         , LAST_NAME
         , SALARY
      INTO FNAME, LNAME, SALARY
      FROM EMPLOYEES
     WHERE EMPLOYEE_ID = 100;
    
    DBMS_OUTPUT.PUT_LINE('성 : ' || LNAME);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || FNAME);
    DBMS_OUTPUT.PUT_LINE('급여액 : ' || SALARY);
END;
/
DECLARE
    FNAME EMPLOYEES.FIRST_NAME%TYPE;
    LNAME EMPLOYEES.LAST_NAME%TYPE;
    SALARY EMPLOYEES.SALARY%TYPE;
BEGIN
    SELECT FIRST_NAME
         , LAST_NAME
         , SALARY
      INTO FNAME, LNAME, SALARY
      FROM EMPLOYEES
     WHERE EMPLOYEE_ID = 100;
    
    DBMS_OUTPUT.PUT_LINE('성 : ' || LNAME);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || FNAME);
    DBMS_OUTPUT.PUT_LINE('급여액 : ' || SALARY);
END;
/
DECLARE
    EMP EMPLOYEES%ROWTYPE;
BEGIN
    SELECT *
      INTO EMP
      FROM EMPLOYEES
     WHERE EMPLOYEE_ID = 100;
    
    DBMS_OUTPUT.PUT_LINE('성 : ' || EMP.LAST_NAME);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || EMP.FIRST_NAME);
    DBMS_OUTPUT.PUT_LINE('급여액 : ' || EMP.SALARY);
END;
/
CREATE VIEW V_DEPT_INFO AS
    SELECT A.DEPARTMENT_NO AS 학과코드
         , A.DEPARTMENT_NAME AS 학과명
         , A.CATEGORY AS 분류
         , A.OPEN_YN AS 개설여부
         , A.CAPACITY AS 정원
         , COUNT(*) AS 현재인원
      FROM TB_DEPARTMENT A JOIN TB_STUDENT B
        ON A.DEPARTMENT_NO = B.DEPARTMENT_NO
     GROUP BY A.DEPARTMENT_NO, A.DEPARTMENT_NAME
            , A.CATEGORY, A.OPEN_YN, A.CAPACITY;
DECLARE
    R V_DEPT_INFO%ROWTYPE;
    DEPT_CODE NUMBER;
BEGIN
    SELECT *
      INTO R
      FROM V_DEPT_INFO
     WHERE 학과코드 = TRIM(TO_CHAR(&DEPT_CODE, '000'));
    DBMS_OUTPUT.PUT_LINE(R.학과명 || ' | ' || R.분류 || ' | ' || R.개설여부 || ' | ' || R.정원  || ' | ' || R.현재인원);
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('해당 데이터가 존재하지 않습니다.');
    WHEN TOO_MANY_ROWS THEN
        DBMS_OUTPUT.PUT_LINE('너무 많은 행 데이터가 있습니다.');
END;
/

BEGIN
    FOR R IN (SELECT * FROM V_DEPT_INFO) LOOP
        DBMS_OUTPUT.PUT_LINE(R.학과명 || ' | ' || R.분류 || ' | ' || R.개설여부 || ' | ' || R.정원  || ' | ' || R.현재인원);
    END LOOP;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('해당 데이터가 존재하지 않습니다.');
END;
/

DECLARE
    TYPE NAME_ARRAY IS TABLE OF V_DEPT_INFO.학과명%TYPE INDEX BY BINARY_INTEGER;
    ARR_NAME NAME_ARRAY;
    IDX BINARY_INTEGER := 1;
BEGIN
    FOR R IN (SELECT * FROM V_DEPT_INFO) LOOP
        ARR_NAME(IDX) := R.학과명;
        IDX := IDX + 1;
    END LOOP;

    FOR I IN 1..IDX-1 LOOP
        DBMS_OUTPUT.PUT_LINE(ARR_NAME(I));
    END LOOP;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('해당 데이터가 존재하지 않습니다.');
END;
/ 

SELECT * FROM V_DEPT_INFO;


-- TB_PROFESSOR, TB_STUDENT 의 이름, 주민번호, 주소 를 출력하는 PL/SQL 작성
-- 주민번호의 경우 마지막 7자리에 대해 ******* 로 처리될 수 있도록 한다.
-- 사용자 입력으로 숨김이라는 입력을 받으면 ******* 로 처리되게 한다.
CREATE VIEW TB_PRO_STU_INFO AS
    SELECT P.PROFESSOR_NAME AS 교수이름,
           P.PROFESSOR_SSN AS 교수주민번호,
           P.PROFESSOR_ADDRESS AS 교수주소,
           S.STUDENT_NAME AS 학생이름,
           S.STUDENT_SSN AS 학생주민번호,
           S.STUDENT_ADDRESS AS 학생주소
     FROM TB_PROFESSOR P, TB_STUDENT S
    WHERE P.PROFESSOR_NO = S.COACH_PROFESSOR_NO
      AND S.DEPARTMENT_NO IN ('050');


CREATE VIEW TB_PRO_STU_INFO_HIDE AS
    SELECT P.PROFESSOR_NAME AS 교수이름,
           CONCAT(SUBSTR(P.PROFESSOR_SSN, 1, 8), '*******') AS 교수주민번호,
           P.PROFESSOR_ADDRESS AS 교수주소,
           S.STUDENT_NAME AS 학생이름,
           CONCAT(SUBSTR(S.STUDENT_SSN, 1, 8), '*******') AS 학생주민번호,
           S.STUDENT_ADDRESS AS 학생주소
      FROM TB_PROFESSOR P, TB_STUDENT S
     WHERE P.PROFESSOR_NO = S.COACH_PROFESSOR_NO
       AND S.DEPARTMENT_NO IN ('050');



DECLARE
    HIDE VARCHAR2(7);
    VAL VARCHAR2(7);
BEGIN
    VAL := '&HIDE';
    IF (VAL LIKE '숨김') THEN
        FOR R IN (SELECT * FROM TB_PRO_STU_INFO_HIDE) LOOP
            DBMS_OUTPUT.PUT_LINE(R.교수이름 || ' | ' || R.교수주민번호 || ' | ' || R.교수주소 || ' | ' || R.학생이름  || ' | ' || R.학생주민번호 || ' | ' || R.학생주소);
        END LOOP;
    ELSE
        FOR R IN (SELECT * FROM TB_PRO_STU_INFO) LOOP
            DBMS_OUTPUT.PUT_LINE(R.교수이름 || ' | ' || R.교수주민번호 || ' | ' || R.교수주소 || ' | ' || R.학생이름  || ' | ' || R.학생주민번호 || ' | ' || R.학생주소);
        END LOOP;
    END IF;

    
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('해당 데이터가 존재하지 않습니다.');
    WHEN TOO_MANY_ROWS THEN
        DBMS_OUTPUT.PUT_LINE('너무 많은 행 데이터가 있습니다.');
END;
/


SELECT * FROM TB_PRO_STU_INFO;

SELECT * FROM TB_PROFESSOR;
SELECT * FROM TB_STUDENT;


-- 구구단을 출력하는 PL/SQL 작성
BEGIN
    FOR X IN 1..9 LOOP
        FOR Y IN 1..9 LOOP
            DBMS_OUTPUT.PUT(X || 'x' || Y || '=' || X * Y || '    ');
        END LOOP;
        DBMS_OUTPUT.PUT_LINE('');
    END LOOP;
END;
/

DECLARE
    X   NUMBER := 1;
    Y   NUMBER := 1;
BEGIN
    WHILE X <= 9 LOOP
        WHILE Y <= 9 LOOP
            DBMS_OUTPUT.PUT(X || 'x' || Y || '=' || X * Y || '    ');
            Y := Y + 1;
        END LOOP;
        DBMS_OUTPUT.PUT_LINE('');
        X := X + 1;
        Y := 1;
    END LOOP;
END;
/

DECLARE
    TYPE NUM_ARRY IS TABLE OF NUMBER INDEX BY BINARY_INTEGER;
    RESULTS NUM_ARRY;
    IDX BINARY_INTEGER := 1;
BEGIN
    FOR X IN 1..9 LOOP
        FOR Y IN 1..9 LOOP
            RESULTS(IDX) := X * Y;
            IDX := IDX + 1;
        END LOOP;
    END LOOP;

    FOR I IN 1..IDX-1 LOOP
        DBMS_OUTPUT.PUT_LINE(RESULTS(I) || ' ');
    END LOOP;
END;
/

-- EMPLOYEES 테이블에서 직원들의 급여와 직원이름을 출력할 때 커미션이 있는 직원은
-- 커미션을 포함하여 계산하여 출력 할 때 "(커미션 포함)" 이라는 내용과 같이
-- 출력되도록 PL/SQL 작성

CREATE VIEW EMP_SAL AS
    SELECT FIRST_NAME || ' ' || LAST_NAME AS 이름,
        SALARY AS 급여
      FROM EMPLOYEES;



SELECT * FROM EMP_SAL;



BEGIN
    DBMS_OUTPUT.PUT_LINE('  이름    ' || '           급여 ');
    FOR R IN (SELECT * FROM EMP_SAL) LOOP
        IF(R.커미션 IS NULL) THEN
            DBMS_OUTPUT.PUT_LINE(R.이름 || ' | ' || R.급여);
        ELSE
            DBMS_OUTPUT.PUT_LINE(R.이름 || ' | ' || (1+R.커미션)*R.급여 || '(커미션포함)');    
        END IF;
    END LOOP;
END;
/