/*
    1. 재고관리를 위한 테이블 생성
        테이블 명 : PRODUCTS
        컬럼명  데이터타입      제약조건        비고
           PID  VARCHAR2(6)     Primary Key     문자와 숫자의 조합으로 만들어진 코드를 사용한다.
         PNAME  VARCHAR2(30)    NOT NULL        제품 이름
        AMOUNT  NUMBER          NOT NULL        제품의 단가
           CNT  NUMBER          NOT NULL        제품의 수량
    
        테이블 명 : PROD_INOUT
        컬럼명  데이터타입      제약조건        비고
            ID  NUMBER          Primary Key     제품 입고 출고내역을 식별하기 위한 번호, 자동증가 기능을 활용한다.
        IN_OUT  CHAR(1)         CHECK           I:입고, O:출고 임을 구분하는 컬럼
           PID  VARCHAR2(6)     Foreign Key     PRODUCTS 테이블을 참조하는 외래키로 입출고된 제품을 구분한다.
        AMOUNT  NUMBER          NOT NULL        입출고 시점의 제품 단가
           CNT  NUMBER          NOT NULL        입출고된 제품의 수량, DEFAULT(1)
         PRICE  NUMBER          NOT NULL        입출고 시점의 제품 전체 금액(단가 x 수량)
                                                입고 제품에는 10% 할인된 금액으로 기록되어야 한다.
                                                출고 제품에는 10% 부가세가 포함된 금액으로 기록되어야 한다.
                                                소수점은 절삭한다.
    INOUT_DATE  DATE                            입출고 날짜, DEFAULT(SYSDATE)       
*/
CREATE TABLE PRODUCTS(
    PID VARCHAR2(6) PRIMARY KEY,
    PNAME VARCHAR2(30) NOT NULL,
    AMOUNT NUMBER NOT NULL,
    CNT NUMBER NOT NULL
);

COMMENT ON COLUMN PRODUCTS.PID IS 'PRODUCTS 테이블을 식별하는 코드로 문자와 숫자의 조합으로 만들어진 컬럼';
COMMENT ON COLUMN PRODUCTS.PNAME IS '제품이름을 나타내는 컬럼';
COMMENT ON COLUMN PRODUCTS.AMOUNT IS '제품의 단가를 나타내는 컬럼';
COMMENT ON COLUMN PRODUCTS.CNT IS '제품의 수량을 나타내는 컬럼';

CREATE SEQUENCE PROD_INOUT_SEQ;
CREATE TABLE PROD_INOUT(
    ID NUMBER PRIMARY KEY,
    IN_OUT CHAR(1) CHECK(IN_OUT IN ('I','O')),
    PID VARCHAR2(6),
    AMOUNT NUMBER NOT NULL,
    CNT NUMBER DEFAULT(1),
    PRICE NUMBER NOT NULL AS (AMOUNT * CNT) PERSISTED,
    INOUT_DATE DATE DEFAULT(SYSDATE)
);
ALTER TABLE PROD_INOUT ADD CONSTRAINT PROD_INOUT_PID_FK FOREIGN KEY(PID) REFERENCES PRODUCTS(PID);
ALTER TABLE PROD_INOUT MODIFY CNT CONSTRAINT PROD_INOUT_CNT_NN NOT NULL;

COMMENT ON COLUMN PROD_INOUT.ID IS 'PROD_INOUT 테이블을 식별하는 코드로 제품 입고 출고내역을 식별하기 위한 번호, 자동증가 기능 활용';
COMMENT ON COLUMN PROD_INOUT.IN_OUT IS 'I:입고, O:출고 임을 구분하는 컬럼';
COMMENT ON COLUMN PROD_INOUT.PID IS 'PRODUCTS 테이블을 참조하는 외래키로 입출고된 제품을 구분한다.';
COMMENT ON COLUMN PROD_INOUT.AMOUNT IS '입출고 시점의 제품 단가';
COMMENT ON COLUMN PROD_INOUT.CNT IS '입출고된 제품의 수량, DEFAULT(1)';
COMMENT ON COLUMN PROD_INOUT.PRICE IS '입출고 시점의 제품 전체 금액(단가 X 수량)';
                                    /* 입고 제품에는 10% 할인된 금액으로 기록되어야 한다.
                                       출고 제품에는 10% 부가세가 포함된 금액으로 기록되어야 한다.
                                       소수점은 절삭한다. */
COMMENT ON COLUMN PROD_INOUT.INOUT_DATE IS '입출고 날짜, DEFAULT(SYSDATE)';


/*
    2. 1번에서 만든 테이블의 기본 데이터를 추가한다.
        - PRODUCTS 테이블에는 다음의 데이터를 추가한다.
            PID:A00001  PNAME:투명박스       AMOUNT:15,000   CNT:10
            PID:A00002  PNAME:텀블러         AMOUNT:10,000   CNT:15
            PID:A00003  PNAME:마스크(10개입) AMOUNT:5,000    CNT:20
            PID:A00004  PNAME:투명테이프     AMOUNT:1,000    CNT:30
            PID:A00005  PNAME:종이컵(355ml)  AMOUNT:2,000    CNT:40

         - PROD_INOUT과 PRODUCTS 테이블에는 다음 설명에 맞게 데이터가 추가 및 변경될 수 있게 한다.
            투명박스 2개를 2021년 01월 02일에 출고하였다.
            텀블러 1개를 2021년 01월 03일에 출고하였다.
            마스크 10개를 2021년 01월 05일에 출고하였다.
            종이컵 5개를 2021년 01월 12일에 출고하였다.
            마스크 20개를 2021년 01월 15일에 입고하였다.
            투명테이프 2개를 2021년 01월 17일에 출고하였다.
            종이컵 10개를 2021년 01월 21일에 출고하였다.
            투명박스 7개를 2021년 01월 25일에 입고하였다.
*/

INSERT INTO PRODUCTS VALUES('A00001', '투명박스', 15000, 10);
INSERT INTO PRODUCTS VALUES('A00002', '텀블러', 10000, 15);
INSERT INTO PRODUCTS VALUES('A00003', '마스크(10개입)', 5000, 20);
INSERT INTO PRODUCTS VALUES('A00004', '투명테이프', 1000, 30);
INSERT INTO PRODUCTS VALUES('A00005', '종이컵(355ml)', 2000, 40);

INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'O', 'A00001', 15000, 2, 33000, TO_DATE('20210102', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'O', 'A00002', 10000, 1, 11000, TO_DATE('20210103', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'O', 'A00003', 5000, 1, 5500, TO_DATE('20210105', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'O', 'A00005', 2000, 5, 11000, TO_DATE('20210112', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'I', 'A00003', 5000, 2, 9000, TO_DATE('20210115', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'O', 'A00004', 1000, 2, 2200, TO_DATE('20210117', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'O', 'A00005', 2000, 10, 22000, TO_DATE('20210121', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'I', 'A00001', 15000, 7, 94500, TO_DATE('20210125', 'yyyymmdd'));


INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'O'
                            , (SELECT PID FROM PRODUCTS WHERE PNAME = '투명박스')
                            , (SELECT AMOUNT FROM PRODUCTS WHERE PNAME = '투명박스')
                            , 2, 0, TO_DATE('20210102', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'O'
                            , (SELECT PID FROM PRODUCTS WHERE PNAME = '텀블러')
                            , (SELECT AMOUNT FROM PRODUCTS WHERE PNAME = '텀블러')
                            , 1, 0, TO_DATE('20210103', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'O'
                            , (SELECT PID FROM PRODUCTS WHERE PNAME = '마스크(10개입)')
                            , (SELECT AMOUNT FROM PRODUCTS WHERE PNAME = '마스크(10개입)')
                            , 10, 0, TO_DATE('20210105', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'O'
                            , (SELECT PID FROM PRODUCTS WHERE PNAME = '종이컵(355ml)')
                            , (SELECT AMOUNT FROM PRODUCTS WHERE PNAME = '종이컵(355ml)')
                            , 5, 0, TO_DATE('20210112', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'I'
                            , (SELECT PID FROM PRODUCTS WHERE PNAME = '마스크(10개입)')
                            , (SELECT AMOUNT FROM PRODUCTS WHERE PNAME = '마스크(10개입)')
                            , 20, 0, TO_DATE('20210115', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'O'
                            , (SELECT PID FROM PRODUCTS WHERE PNAME = '투명테이프')
                            , (SELECT AMOUNT FROM PRODUCTS WHERE PNAME = '투명테이프')
                            , 2, 0, TO_DATE('20210117', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'O'
                            , (SELECT PID FROM PRODUCTS WHERE PNAME = '종이컵(355ml)')
                            , (SELECT AMOUNT FROM PRODUCTS WHERE PNAME = '종이컵(355ml)')
                            , 10, 0, TO_DATE('20210121', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'I'
                            , (SELECT PID FROM PRODUCTS WHERE PNAME = '투명박스')
                            , (SELECT AMOUNT FROM PRODUCTS WHERE PNAME = '투명박스')
                            , 7, 0, TO_DATE('20210125', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'I'
                            , (SELECT PID FROM PRODUCTS WHERE PNAME = '투명박스')
                            , (SELECT AMOUNT FROM PRODUCTS WHERE PNAME = '투명박스')
                            , 3, 0, TO_DATE('20210204', 'yyyymmdd'));
UPDATE PROD_INOUT
   SET PRICE = (CASE WHEN IN_OUT = 'I' THEN
                        (AMOUNT * CNT) - FLOOR((AMOUNT * CNT) * 0.1)
                     WHEN IN_OUT = 'O' THEN
                        (AMOUNT * CNT) + FLOOR((AMOUNT * CNT) * 0.1)
                 END);

/*
    3. 1월 1달간 출고 내역을 조회하시오.
        제품코드    제품명      단가        수량        금액
        A00001      투명박스    15,000      2           33,000
        A00002      텀블러      10,000      1           11,000
        A00003      마스크      5,000       10          55,000
        ....
*/
DESC PRODUCTS;
SELECT I.PID AS 제품코드,
       P.PNAME AS 제품명,
       I.AMOUNT AS 단가,
       SUM(I.CNT) AS 수량,
       SUM(I.PRICE) AS 금액
  FROM PRODUCTS P JOIN PROD_INOUT I
    ON P.PID = I.PID
 WHERE I.IN_OUT = 'O'
 GROUP BY I.PID,P.PNAME,I.AMOUNT
 ORDER BY I.PID;

/*
    4. 1월 1달간의 입/출고 내역을 다음과 같이 나오도록 조회하시오.
        제품코드    제품명      입고량      출고량
        A00001      투명박스    7           2
        A00002      텀블러      0           1
        A00003      마스크      20          10
        총합                    xx          xx
*/

SELECT DECODE(P.PID, NULL, '총합', P.PID) AS 제품코드,
       P.PNAME AS 제품명, 
       SUM(DECODE(I.IN_OUT, 'I', I.CNT, 0)) AS 입고량,
       SUM(DECODE(I.IN_OUT, 'O', I.CNT, 0)) AS 출고량
  FROM PRODUCTS P JOIN PROD_INOUT I
    ON P.PID = I.PID
 WHERE TO_CHAR(I.INOUT_DATE, 'yyyymm') = '202101'
 GROUP BY ROLLUP((DECODE(P.PID, NULL, '총합', P.PID), P.PNAME))
 ORDER BY 제품코드;


/*
    5. 3번, 4번 조회 쿼리를 VIEW 로 만들어본다.
*/
CREATE OR REPLACE VIEW V_PROD_OUT AS
    SELECT EXTRACT(YEAR FROM INOUT_DATE) AS y,
        EXTRACT(MONTH FROM INOUT_DATE) AS m,
        I.PID AS 제품코드,
        P.PNAME AS 제품명,
        I.AMOUNT AS 단가,
        SUM(I.CNT) AS 수량,
        SUM(I.PRICE) AS 금액
    FROM PRODUCTS P JOIN PROD_INOUT I
        ON P.PID = I.PID
    WHERE I.IN_OUT = 'O'
    GROUP BY EXTRACT(YEAR FROM INOUT_DATE), EXTRACT(MONTH FROM INOUT_DATE),I.PID,P.PNAME,I.AMOUNT
    ORDER BY y,m,I.PID;



CREATE OR REPLACE VIEW V_PROD_IN AS
    SELECT EXTRACT(YEAR FROM INOUT_DATE) AS y,
        EXTRACT(MONTH FROM INOUT_DATE) AS m,
        I.PID AS 제품코드,
        P.PNAME AS 제품명,
        I.AMOUNT AS 단가,
        SUM(I.CNT) AS 수량,
        SUM(I.PRICE) AS 금액
    FROM PRODUCTS P JOIN PROD_INOUT I
        ON P.PID = I.PID
    WHERE I.IN_OUT = 'I'
    GROUP BY EXTRACT(YEAR FROM INOUT_DATE), EXTRACT(MONTH FROM INOUT_DATE),I.PID,P.PNAME,I.AMOUNT
    ORDER BY y,m,I.PID;


CREATE OR REPLACE VIEW V_PROD_OUT AS
    SELECT EXTRACT(YEAR FROM INOUT_DATE) AS y,
        EXTRACT(MONTH FROM INOUT_DATE) AS m,
        DECODE(P.PID, NULL, '총합', P.PID) AS 제품코드,
        P.PNAME AS 제품명, 
        SUM(DECODE(I.IN_OUT, 'I', I.CNT, 0)) AS 입고량,
        SUM(DECODE(I.IN_OUT, 'O', I.CNT, 0)) AS 출고량
    FROM PRODUCTS P JOIN PROD_INOUT I
        ON P.PID = I.PID
    GROUP BY EXTRACT(YEAR FROM INOUT_DATE), EXTRACT(MONTH FROM INOUT_DATE),ROLLUP((DECODE(P.PID, NULL, '총합', P.PID), P.PNAME));
 /*
    6. 5번에서 생성한 VIEW 를 프로시져로 만들어서 월별 또는 년도별로도 조회할 수 있게 만들어본다.
*/

CREATE OR REPLACE PROCEDURE PROC_TYPE_BY_IN_OUT(i_type IN CHAR, i_year IN NUMBER, i_month IN NUMBER)
IS
    type_err    EXCEPTION;
BEGIN
    IF i_type IN ('i','I','in','IN') THEN
        FOR rec IN (SELECT 제품코드, 제품명, 단가, 수량, 금액 FROM V_PROD_IN WHERE y=i_year AND m=i_month) LOOP
                DBMS_OUTPUT.PUT_LINE(rec.제품코드 || ' | ' || rec.제품명 || ' | ' || rec.단가 || ' | ' || rec.수량 || ' | ' || rec.금액);
        END LOOP;
    ELSIF i_type IN ('o','O','out','OUT') THEN
        FOR rec IN (SELECT 제품코드, 제품명, 입고량, 출고량 FROM V_PROD_OUT WHERE y=i_year AND m=i_month) LOOP
            IF rec.제품코드 IS NULL THEN
                rec.제품코드 := '총합';
                DBMS_OUTPUT.PUT_LINE(rec.제품코드 || ' | ' || rec.제품명 || ' | ' || rec.입고량 || ' | ' || rec.출고량 );
            ELSE
                DBMS_OUTPUT.PUT_LINE(rec.제품코드 || ' | ' || rec.제품명 || ' | ' || rec.입고량 || ' | ' || rec.출고량 );
            END IF;  
        END LOOP;
    ELSE
        RAISE type_err;
    END IF;
EXCEPTION
    WHEN type_err THEN
        DBMS_OUTPUT.PUT_LINE('타입은 반드시 i, o, in, out 중 하나를 사용해야 합니다.');
END;
/
EXEC PROC_TYPE_BY_IN_OUT('O', 2021, 1);
/*
    7. 제품을 출고할 때 PRODUCTS 에 기록된 수량도 같이 반영이 될 수 있도록 프로시저를 만들어 동작시킨다.
       단 수량이 부족하면 출고 작업이 이루어지지 않게 ROLLBACK 을 동작시키는 것으로 한다.
*/
CREATE OR REPLACE PROCEDURE PROC_TYPE_BY_OUT_CNT(i_code IN CHAR, i_out IN NUMBER)
IS
    num_err     EXCEPTION;
    minus_err   EXCEPTION;
    check_err   NUMBER:=0;
BEGIN    
    FOR rec IN (SELECT PID,CNT FROM PRODUCTS) LOOP
        IF rec.PID = i_code THEN
            IF i_out > rec.CNT THEN
                RAISE minus_err;
            END IF;
        -- rec.출고량 := i_out;
            UPDATE PRODUCTS SET CNT = (CNT - i_out) WHERE PID=i_code;
            check_err := 1;
        END IF;    
    END LOOP;
    IF check_err != 1 THEN
        RAISE num_err;
    END IF;    
EXCEPTION
    WHEN num_err THEN
        DBMS_OUTPUT.PUT_LINE('올바른 제품코드를 입력하세요');    
    WHEN minus_err THEN
        DBMS_OUTPUT.PUT_LINE('수량이 출고하는 숫자보다 적게 남아있습니다.');    
        ROLLBACK;
END;
/
EXEC PROC_TYPE_BY_OUT_CNT('A00007', 5);
SELECT * FROM PRODUCTS;
SHOW ERROR;

IF rec.제품코드 = i_code THEN
                INP := &INP_NUM;
                rec.수량 := rec.수량 + INP;
                rec.금액 := (rec.수량 * rec.단가) * 0.9;
FOR rec2 IN (SELECT 제품코드, 제품명, 입고량, 출고량 FROM V_PROD_OUT) LOOP
                    IF rec2.제품코드 = i_code THEN
                        rec2.출고량 := rec2.출고량 + i_out;
                    END IF;
                    IF rec2.제품코드 IS NULL THEN
                        rec2.제품코드 := '총합';
                        DBMS_OUTPUT.PUT_LINE(rec2.제품코드 || ' | ' || rec2.제품명 || ' | ' || rec2.입고량 || ' | ' || rec2.출고량 );
                    ELSE
                        DBMS_OUTPUT.PUT_LINE(rec2.제품코드 || ' | ' || rec2.제품명 || ' | ' || rec2.입고량 || ' | ' || rec2.출고량 );
                    END IF;  
                END LOOP;
/*
    8. 제품 출고 단가는 PRODUCTS 테이블의 금액을 기준으로 사용하지만 입고의 경우 별도의 입고 단가액을 작성하면
       PRODUCTS 테이블의 금액이 변경되게 할 것이다. 그리고 기존에 존재하지 않은 제품을 입고하는 경우에도 자동
       적으로 PRODUCT 테이블에 새로운 제품 정보가 저장되도록 할 것이다.
       위에서 설명하는 내용대로 동작할 수 있는 프로서저를 만들어 제고관리가 이루어 질 수 있도록 하시오.
       PROC_PROD_IN('제품코드', '제품명', 수량, 단가) 형식으로 사용
            A. 기존에 존재하는 제품코드, 제품명의 경우 해당 제품에 대한 수량을 입력한 수량만큼 증가시킨다.
            B. 기존에 존재하는 제품코드, 제품명이나 단가가 입력된 단가와 다른 경우 입력된 단가로 수정한다.
            C. 기존에 존재하지 않는 제품코드인 경우 새로운 제품으로 추가한다.
            D. 기존에 존재하는 제품코드이나 제품명이 다른 경우 어떠한 작업도 수행하지 않는다.

            
*/ 
SET SERVEROUTPUT ON;
CREATE OR REPLACE PROCEDURE PROC_PROD_IN(i_code IN CHAR, i_name IN CHAR , i_price IN NUMBER, i_cnt IN NUMBER)
IS
    name_err     EXCEPTION;
    check_other   NUMBER:=0;
BEGIN    

    FOR rec IN (SELECT * FROM PRODUCTS) LOOP
        IF rec.PID = i_code THEN
            IF rec.PNAME = i_name THEN
                UPDATE PRODUCTS SET AMOUNT = i_price WHERE PID=i_code AND PNAME=i_name;
                UPDATE PRODUCTS SET CNT = (CNT + i_cnt) WHERE PID=i_code AND PNAME=i_name;
                DBMS_OUTPUT.PUT_LINE('제품 내역이 수정되었습니다.');
                check_other := 1;    
                INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'I', i_code, i_price, i_cnt, i_price*i_cnt, SYSDATE);
            ELSE
                RAISE name_err;            
            END IF;
            
             
        END IF;            
    END LOOP;
    IF check_other != 1 THEN
        INSERT INTO PRODUCTS VALUES(i_code, i_name, i_price, i_cnt);
        INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'I', i_code, i_price, i_cnt, i_price*i_cnt, SYSDATE);
    END IF;    
EXCEPTION 
    WHEN name_err THEN
        DBMS_OUTPUT.PUT_LINE('올바른 제품명를 입력하세요');    
END;
/


EXEC PROC_PROD_IN('A00001', '투명박스', 1000, 12);
SELECT * FROM PRODUCTS ORDER BY PID;
SELECT * FROM PROD_INOUT WHERE PID='A00001';
SHOW ERROR;


-- 금액 합계 함수도 만들어보기
UPDATE PROD_INOUT
   SET PRICE = (CASE WHEN IN_OUT = 'I' THEN
                        (AMOUNT * CNT) - FLOOR((AMOUNT * CNT) * 0.1)
                     WHEN IN_OUT = 'O' THEN
                        (AMOUNT * CNT) + FLOOR((AMOUNT * CNT) * 0.1)
                 END);

INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'I', i_code, i_price, i_cnt, i_price*i_cnt, SYSDATE);
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'I', 'A00001', 15000, 7, 94500, TO_DATE('20210125', 'yyyymmdd'));




/* 중간 시험용
SELECT * FROM EMPLOYEES;
SELECT * FROM DEPARTMENTS;
CREATE VIEW TEST_EMP AS
    SELECT EMPLOYEE_ID, FIRST_NAME, DEPARTMENT_ID AS DEPT_CODE
      FROM EMPLOYEES;

SELECT EMPLOYEE_ID, FIRST_NAME, DEPARTMENT_ID, DEPARTMENT_NAME
  FROM TEST_EMP 
  JOIN DEPARTMENTS ON DEPT_CODE = DEPARTMENT_ID;

ALTER TABLE TEST_EMP RENAME COLUMN DEPT_CODE TO DEPT_CODE_2;

CREATE TABLE TTEST(
    DEPT_CODE VARCHAR2(50),
    DEPT_NAME VARCHAR2(50)
);



CREATE TABLE DEPARTMENT_TEST(
    DEPTCODE NUMBER PRIMARY KEY,
    DEPTNAME NVARCHAR2(10) NOT NULL
);

CREATE TABLE EMPLOYEE_TEST(
    EMPNO NUMBER PRIMARY KEY,
    EMPNAME VARCHAR2(10) NOT NULL,
    DEPTNO NUMBER REFERENCES DEPARTMENT_TEST(DEPTCODE)
);

ALTER TABLE DEPARTMENT_TEST RENAME COLUMN DEPTCODE TO DEPTNO;

DESC DEPARTMENT_TEST;

SELECT EMPNO, EMPNAME, DEPTNO, DEPTNAME
  FROM EMPLOYEE_TEST
  JOIN DEPARTMENT_TEST USING(DEPTNO);

INSERT INTO DEPARTMENT_TEST VALUES(1, '국어국문학과');
INSERT INTO DEPARTMENT_TEST VALUES(2, '컴퓨터공학과');
INSERT INTO DEPARTMENT_TEST VALUES(3, '기계공학과');
INSERT INTO DEPARTMENT_TEST VALUES(4, '영어영문학과');

INSERT INTO EMPLOYEE_TEST VALUES(100, '하문철', 3);
INSERT INTO EMPLOYEE_TEST VALUES(101, '공서얻', 4);
INSERT INTO EMPLOYEE_TEST VALUES(102, '김녀고', 4);
INSERT INTO EMPLOYEE_TEST VALUES(103, '학민다', 1);
INSERT INTO EMPLOYEE_TEST VALUES(104, '읻거리', 1);
INSERT INTO EMPLOYEE_TEST VALUES(105, '김호궁', 2);

DROP TABLE DEPARTMENT_TEST;

*/