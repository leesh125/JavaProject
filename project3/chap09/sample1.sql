/*
    1. 가계부 작성을 위한 테이블 생성
        테이블 명 : ACCOUNTS
        컬럼명   데이터타입      제약조건       비고
            ID   NUMBER          Primary Key    Sequence를 사용하여 1씩 자동증가 되도록 한다.
        AMOUNT   NUMBER          NOT NULL       DEFAULT 를 사용하여 기본값으로 0 이 사용되게 한다.
      ACC_TYPE   CHAR(1)         CHECK          I 는 입금, O 는 출금 내역으로 구분한다.
      ACC_DATE   DATE            NOT NULL       입출금 날짜를 기록하기 위한 컬럼이다.
       HISTORY   CHAR(3)         Foreign Key    입출금 내역을 위한 컬럼으로 HISTORYS 테이블을 참조한다.

       
        테이블 명 : HISTORYS
        컬럼명   데이터타입      제약조건        비고
            ID   CHAR(3)         Primary Key     문자와 숫자의 조합으로 만들어진 입출금 코드를 사용한다.
        H_TYPE   VARCHAR2(150)   NOT NULL        입출금 내역을 한글 기준 50자 내로 작성

*/
CREATE SEQUENCE ACC_SEQ;
DESC ACCOUNTS;
CREATE TABLE ACCOUNTS(
    ID NUMBER PRIMARY KEY,
    AMOUNT NUMBER NOT NULL DEFAULT 0,
    ACC_TYPE CHAR(1) CHECK(ACC_TYPE IN ('I','O')),
    ACC_DATE DATE NOT NULL DEFAULT(SYSDATE),
    HISTORY CHAR(3)
);
ALTER TABLE ACCOUNTS ADD CONSTRAINT HIST_FK FOREIGN KEY(HISTORY) REFERENCES HISTORIES(ID);

CREATE TABLE HISTORIES(
    ID CHAR(3),
    H_TYPE VARCHAR2(150) NOT NULL
);
ALTER TABLE HISTORIES ADD CONSTRAINT H_ID_PK PRIMARY KEY(ID);

/*
    2. 1번에서 만든 테이블의 기본 데이터를 추가한다.
        - HISTORYS 테이블에는 다음의 데이터를 추가한다.
            ID:A01,     H_TYPE:급여   | ID:A02,     H_TYPE:불로소득
            ID:A03,     H_TYPE:통신비 | ID:A04,     H_TYPE:교통비
            ID:A05,     H_TYPE:주유비 | ID:A06,     H_TYPE:식비
            ID:A07,     H_TYPE:여가비 | ID:A08,     H_TYPE:의류구입
        - ACCOUNTS 테이블에는 다음의 데이터를 추가한다.
            2021년 01월 05일에 급여 3,000,000 원이 들어왔다.
            2021년 01월 16일에 여가비로 150,000 원을 사용하였다.
            2021년 01월 25일에 통신비로 125,000 원 지출되었다.
            2021년 01월 25일에 교통비로 85,200 원이 지출되었다.
            2021년 01월 한달간 매 주일(5일) 식비로 6,500원이 지출되었다.
*/


INSERT INTO HISTORIES VALUES('A01', '급여');
INSERT INTO HISTORIES VALUES('A02', '불로소득');
INSERT INTO HISTORIES VALUES('A03', '통신비');
INSERT INTO HISTORIES VALUES('A04', '교통비');
INSERT INTO HISTORIES VALUES('A05', '주유비');
INSERT INTO HISTORIES VALUES('A06', '식비');
INSERT INTO HISTORIES VALUES('A07', '여가비');
INSERT INTO HISTORIES VALUES('A08', '의류구입');

INSERT INTO ACCOUNTS VALUES(ACC_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210101', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACC_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210104', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACC_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210105', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACC_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210106', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACC_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210107', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACC_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210108', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACC_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210111', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACC_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210112', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACC_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210113', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACC_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210114', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACC_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210115', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACC_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210118', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACC_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210119', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACC_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210120', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACC_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210121', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACC_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210122', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACC_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210125', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACC_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210126', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACC_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210127', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACC_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210128', 'yyyymmdd'), 'A06');
INSERT INTO ACCOUNTS VALUES(ACC_SEQ.NEXTVAL, 6500, 'O', TO_DATE('20210129', 'yyyymmdd'), 'A06');

-- 2021년 1월의 주말을 제외한 평일을 구하는 PL/SQL
DECLARE
    vardate     VARCHAR2(6) := '202101';    -- 2021년 1월 임을 나타내기 위해 사용.
    lastday     NUMBER := EXTRACT(DAY FROM LAST_DAY(TO_DATE(vardate, 'yyyymm')));   -- 해당월의 마지막 일자
    week        NUMBER; -- 요일값을 저장하기 위한 변수(1:일요일, 7:토요일)
    weekdate    DATE;
BEGIN
    FOR days IN 1..lastday LOOP -- 1일 부터 해당월의 마지막 일자 까지 반복
        weekdate := TO_DATE(vardate || TO_CHAR(days, '00'), 'yyyymmdd');    -- 년월과 일을 결합
        week := TO_CHAR(weekdate, 'D'); -- 요일값을 구함(1:일요일, 7:토요일)
        IF week NOT IN (1, 7) THEN  -- 일요일, 토요일을 제외한 요일에 대해 실행
            INSERT INTO ACCOUNTS VALUES(ACCOUNTS_ID_SEQ.NEXTVAL, 6500, 'O', weekdate, 'A06');
            -- DBMS_OUTPUT.PUT_LINE(weekdate);
        END IF;
    END LOOP;
END;
/

/*
    3. 1월 1달간 지출내역을 조회하시오.(항목별 지출내역과 총합계가 같이 조회되도록 한다.)
*/
SELECT A.HISTORY AS 지출코드,
       H.H_TYPE AS 지출항목,
       SUM(AMOUNT) AS 지출내역
  FROM ACCOUNTS A JOIN HISTORIES H
    ON A.HISTORY = H.ID
 WHERE ACC_TYPE='O'
   AND A.ACC_DATE BETWEEN TO_DATE('20210101', 'yyyymmdd')
                      AND TO_DATE('20210131', 'yyyymmdd')
 GROUP BY ROLLUP(HISTORY, H_TYPE);


/*
    4. 1월 1달간의 입/출금 내역을 다음과 같이 나오도록 조회하시오.
        내역        입금액      출금액
        급여        3,000,000
        통신비                  125,000
        교통바                  85,200
        여가비                  150,000
        ...
        총합        3,000,000   xxx,xxx
*/ 
CREATE OR REPLACE
PROCEDURE ACCOUNTS_INFO 
IS
    SUMINP     NUMBER:=0;
    SUMOUP     NUMBER:=0;
BEGIN
    DBMS_OUTPUT.PUT_LINE( '내역' || '       ' || '입금액' || '       ' || '출금액');
    FOR R IN (SELECT * FROM V_ACC_INFO WHERE ROWNUM<=10) LOOP
        IF R.입출금타입 = 'I' THEN
            DBMS_OUTPUT.PUT((RPAD(R.내역, 6, ' ')) || LPAD( R.입출금액, 12, ' '));
            SUMINP := SUMINP + R.입출금액;
        ELSE
            DBMS_OUTPUT.PUT((RPAD(R.내역, 6, ' '))|| LPAD( R.입출금액, 27, ' '));
            SUMOUP := SUMOUP + R.입출금액;
        END IF;
        DBMS_OUTPUT.PUT_LINE('');
    END LOOP;
    DBMS_OUTPUT.PUT_LINE((RPAD('총합', 11, ' ')) || RPAD(SUMINP, 11, ' ') || SUMOUP);
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('해당 데이터가 존재하지 않습니다.');
    WHEN TOO_MANY_ROWS THEN
        DBMS_OUTPUT.PUT_LINE('너무 많은 행 데이터가 있습니다.');
END;
/
SHOW ERROR;
EXEC ACCOUNTS_INFO;

CREATE VIEW V_ACC_INFO AS
SELECT H.H_TYPE AS 내역,
       A.AMOUNT AS 입출금액,
       A.ACC_TYPE AS 입출금타입
  FROM ACCOUNTS A JOIN HISTORIES H
    ON A.HISTORY = H.ID
 ORDER BY A.ACC_DATE;

SELECT * FROM V_ACC_INFO;



SELECT DECODE(H_TYPE, NULL, '총합', H_TYPE) AS 내역
     , TO_CHAR(SUM(DECODE(ACC_TYPE, 'I', AMOUNT, NULL)), '999,999,999') AS 입금액
     , TO_CHAR(SUM(DECODE(ACC_TYPE, 'O', AMOUNT, NULL)), '999,999') AS 출금액
  FROM ACCOUNTS A JOIN HISTORIES H
    ON A.HISTORY = H.ID
 WHERE TO_CHAR(ACC_DATE, 'yyyymm') = '202101'
 GROUP BY ROLLUP(H_TYPE);


/*
    5. 3번, 4번 조회 쿼리를 VIEW 로 만들어본다.
*/
CREATE OR REPLACE VIEW V_TYPE_BY_ACCOUNT_OUT AS
    SELECT EXTRACT(YEAR FROM ACC_DATE) AS y
         , EXTRACT(MONTH FROM ACC_DATE) AS m
         , DECODE(H_TYPE, NULL, '합계', H_TYPE) AS 항목
         , TO_CHAR(SUM(AMOUNT), '999,999,999') AS 내역
      FROM ACCOUNTS A JOIN HISTORIES B
        ON A.HISTORY = B.ID
     WHERE ACC_TYPE = 'O'
     GROUP BY EXTRACT(YEAR FROM ACC_DATE), EXTRACT(MONTH FROM ACC_DATE), ROLLUP(H_TYPE);

SELECT 항목, 내역 FROM V_TYPE_BY_ACCOUNT_OUT WHERE y = 2021 AND m = 1;  -- 2021년 1월 집계 내역만 조회
SELECT 항목, 내역 FROM V_TYPE_BY_ACCOUNT_OUT WHERE y = 2021 AND m = 2;  -- 2021년 2월 집계 내역만 조회

CREATE OR REPLACE VIEW V_TYPE_BY_ACCOUNT_IN AS
    SELECT EXTRACT(YEAR FROM ACC_DATE) AS y
         , EXTRACT(MONTH FROM ACC_DATE) AS m
         , DECODE(H_TYPE, NULL, '합계', H_TYPE) AS 항목
         , TO_CHAR(SUM(AMOUNT), '999,999,999') AS 내역
      FROM ACCOUNTS A JOIN HISTORIES B
        ON A.HISTORY = B.ID
     WHERE ACC_TYPE = 'I'
     GROUP BY EXTRACT(YEAR FROM ACC_DATE), EXTRACT(MONTH FROM ACC_DATE), ROLLUP(H_TYPE);
     
SELECT 항목, 내역 FROM V_TYPE_BY_ACCOUNT_IN WHERE y = 2021 AND m = 1;  -- 2021년 1월 집계 내역만 조회

CREATE OR REPLACE VIEW V_TYPE_BY_ACCOUNT_INOUT AS
    SELECT EXTRACT(YEAR FROM ACC_DATE) AS y
         , EXTRACT(MONTH FROM ACC_DATE) AS m
         , DECODE(H_TYPE, NULL, '총합', H_TYPE) AS 항목
         , TO_CHAR(SUM(DECODE(ACC_TYPE, 'I', AMOUNT, NULL)), '999,999,999') AS 입금액
         , TO_CHAR(SUM(DECODE(ACC_TYPE, 'O', AMOUNT, NULL)), '999,999,999') AS 출금액
      FROM ACCOUNTS A JOIN HISTORIES B
        ON A.HISTORY = B.ID
     GROUP BY EXTRACT(YEAR FROM ACC_DATE), EXTRACT(MONTH FROM ACC_DATE), ROLLUP(H_TYPE);
SELECT 항목, 입금액, 출금액 FROM V_TYPE_BY_ACCOUNT_INOUT WHERE y = 2021 AND m = 2;
/*
    6. 5번에서 생성한 VIEW 를 프로시져로 만들어서 월별 또는 년도별로도 조회할 수 있게 만들어본다.
*/
CREATE OR REPLACE PROCEDURE PROC_TYPE_BY_ACCOUNT(i_type IN CHAR, i_year IN NUMBER, i_month IN NUMBER)
IS
    type_err    EXCEPTION;
BEGIN
    IF i_type IN ('i', 'I', 'in', 'IN') THEN
        FOR rec IN (SELECT 항목, 내역 FROM V_TYPE_BY_ACCOUNT_IN WHERE y = i_year AND m = i_month) LOOP
            DBMS_OUTPUT.PUT_LINE(rec.항목 || ' | ' || rec.내역);
        END LOOP;
    ELSIF i_type IN ('o', 'O', 'out', 'OUT') THEN
        FOR rec IN (SELECT 항목, 내역 FROM V_TYPE_BY_ACCOUNT_OUT WHERE y = i_year AND m = i_month) LOOP
            DBMS_OUTPUT.PUT_LINE(rec.항목 || ' | ' || rec.내역);
        END LOOP;
    ELSE
        RAISE type_err;
    END IF;
EXCEPTION
    WHEN type_err THEN
        DBMS_OUTPUT.PUT_LINE('타입은 반드시 i, o, in, out 중 하나를 사용해야 합니다.');
END;
/
EXEC PROC_TYPE_BY_ACCOUNT('out', 2021, 1);