CREATE TABLE TB_DEPARTMENT (
    DEPARTMENT_NO   VARCHAR2(10),
    DEPARTMENT_NAME VARCHAR2(50),
    CATEGORY        VARCHAR2(20),
    OPEN_YN         CHAR(1),
    CAPACITY        NUMBER
);
ALTER TABLE TB_DEPARTMENT ADD CONSTRAINT DEPARTMENT_DEPARTMENT_NO_PK PRIMARY KEY(DEPARTMENT_NO);
ALTER TABLE TB_DEPARTMENT MODIFY DEPARTMENT_NAME CONSTRAINT DEPARTMENT_DEPARTMENT_NAME_NN NOT NULL;
COMMENT ON COLUMN TB_DEPARTMENT.DEPARTMENT_NO IS '학과 번호';
COMMENT ON COLUMN TB_DEPARTMENT.DEPARTMENT_NAME IS '학과 이름';
COMMENT ON COLUMN TB_DEPARTMENT.CATEGORY IS '계열';
COMMENT ON COLUMN TB_DEPARTMENT.OPEN_YN IS '개설 여부';
COMMENT ON COLUMN TB_DEPARTMENT.CAPACITY IS '정원';

CREATE TABLE TB_CLASS (
    CLASS_NO                VARCHAR2(10),
    DEPARTMENT_NO           VARCHAR2(10),
    PREATTENDING_CLASS_NO   VARCHAR2(10),
    CLASS_NAME              VARCHAR2(50),
    CLASS_TYPE              VARCHAR2(30)
);
ALTER TABLE TB_CLASS ADD CONSTRAINT CLASS_CLASS_NO_PK PRIMARY KEY(CLASS_NO);
ALTER TABLE TB_CLASS ADD CONSTRAINT CLS_CLS_CLASS_NO_FK FOREIGN KEY(PREATTENDING_CLASS_NO)
                           REFERENCES TB_CLASS(CLASS_NO);
ALTER TABLE TB_CLASS MODIFY CLASS_NAME CONSTRAINT CLASS_CLASS_NAME_NN NOT NULL;
COMMENT ON COLUMN TB_CLASS.CLASS_NO IS '과목 번호';
COMMENT ON COLUMN TB_CLASS.DEPARTMENT_NO IS '학과 번호';
COMMENT ON COLUMN TB_CLASS.PREATTENDING_CLASS_NO IS '선수 과목 번호';
COMMENT ON COLUMN TB_CLASS.CLASS_NAME IS '과목 이름';
COMMENT ON COLUMN TB_CLASS.CLASS_TYPE IS '과목 구분';

CREATE TABLE TB_PROFESSOR (
    PROFESSOR_NO        VARCHAR2(10),
    PROFESSOR_NAME      VARCHAR2(50),
    PROFESSOR_SSN       VARCHAR2(14),
    PROFESSOR_ADDRESS   VARCHAR2(100),
    DEPARTMENT_NO       VARCHAR2(10)
);
ALTER TABLE TB_PROFESSOR ADD CONSTRAINT PROFESSOR_PROFESSOR_NO_PK PRIMARY KEY(PROFESSOR_NO);
ALTER TABLE TB_PROFESSOR MODIFY PROFESSOR_NAME CONSTRAINT PROFESSOR_PROFESSOR_NAME_NN NOT NULL;
ALTER TABLE TB_PROFESSOR ADD CONSTRAINT PROP_DEPT_DEPARTMENT_NO_FK FOREIGN KEY(DEPARTMENT_NO)
                           REFERENCES TB_DEPARTMENT(DEPARTMENT_NO);
COMMENT ON COLUMN TB_PROFESSOR.PROFESSOR_NO IS '교수 번호';
COMMENT ON COLUMN TB_PROFESSOR.PROFESSOR_NAME IS '교수 이름';
COMMENT ON COLUMN TB_PROFESSOR.PROFESSOR_SSN IS '교수 주민번호';
COMMENT ON COLUMN TB_PROFESSOR.PROFESSOR_ADDRESS IS '교수 주소';
COMMENT ON COLUMN TB_PROFESSOR.DEPARTMENT_NO IS '학과 번호';

CREATE TABLE TB_CLASS_PROFESSOR (
    CLASS_NO        VARCHAR2(10),
    PROFESSOR_NO    VARCHAR2(10)
);
ALTER TABLE TB_CLASS_PROFESSOR ADD CONSTRAINT CLS_PROP_CLS_PROP_NO_PK PRIMARY KEY(CLASS_NO, PROFESSOR_NO);
ALTER TABLE TB_CLASS_PROFESSOR ADD CONSTRAINT CLS_PROP_CLS_CLASS_NO_FK FOREIGN KEY(CLASS_NO)
                           REFERENCES TB_CLASS(CLASS_NO);
ALTER TABLE TB_CLASS_PROFESSOR ADD CONSTRAINT CLS_PROP_PROP_PROFESSOR_NO_FK FOREIGN KEY(PROFESSOR_NO)
                           REFERENCES TB_PROFESSOR(PROFESSOR_NO);
COMMENT ON COLUMN TB_CLASS_PROFESSOR.CLASS_NO IS '과목 번호';
COMMENT ON COLUMN TB_CLASS_PROFESSOR.PROFESSOR_NO IS '교수 번호';

CREATE TABLE TB_STUDENT (
    STUDENT_NO          VARCHAR2(10),
    DEPARTMENT_NO       VARCHAR2(10),
    STUDENT_NAME        VARCHAR2(50),
    STUDENT_SSN         VARCHAR2(14),
    STUDENT_ADDRESS     VARCHAR2(100),
    ENTRANCE_DATE       DATE,
    ABSENCE_YN          CHAR(1),
    COACH_PROFESSOR_NO  VARCHAR2(10)
);
ALTER TABLE TB_STUDENT ADD CONSTRAINT STUDENT_STUDENT_NO_PK PRIMARY KEY(STUDENT_NO);
ALTER TABLE TB_STUDENT ADD CONSTRAINT STD_DEPT_DEPARTMENT_NO_FK FOREIGN KEY(DEPARTMENT_NO)
                           REFERENCES TB_DEPARTMENT(DEPARTMENT_NO);
ALTER TABLE TB_STUDENT MODIFY DEPARTMENT_NO CONSTRAINT STUDENT_DEPARTMENT_NO_NN NOT NULL;
ALTER TABLE TB_STUDENT MODIFY STUDENT_NAME CONSTRAINT STUDENT_STUDENT_NAME_NN NOT NULL;
ALTER TABLE TB_STUDENT ADD CONSTRAINT STD_PROF_PROFESSOR_NO_FK FOREIGN KEY(COACH_PROFESSOR_NO)
                           REFERENCES TB_PROFESSOR(PROFESSOR_NO);
COMMENT ON COLUMN TB_STUDENT.STUDENT_NO IS '학생 번호';
COMMENT ON COLUMN TB_STUDENT.DEPARTMENT_NO IS '학과 번호';
COMMENT ON COLUMN TB_STUDENT.STUDENT_NAME IS '학생 이름';
COMMENT ON COLUMN TB_STUDENT.STUDENT_SSN IS '학생 주민번호';
COMMENT ON COLUMN TB_STUDENT.STUDENT_ADDRESS IS '학생 주소';
COMMENT ON COLUMN TB_STUDENT.ENTRANCE_DATE IS '입학 일자';
COMMENT ON COLUMN TB_STUDENT.ABSENCE_YN IS '휴학 여부';
COMMENT ON COLUMN TB_STUDENT.COACH_PROFESSOR_NO IS '지도 교수 번호';

CREATE TABLE TB_GRADE (
    TERM_NO     VARCHAR(10),
    CLASS_NO    VARCHAR(10),
    STUDENT_NO  VARCHAR(10),
    POINT       NUMBER(3,2)
);
ALTER TABLE TB_GRADE ADD CONSTRAINT GRADE_TERM_CLASS_STUDENT_NO_PK PRIMARY KEY(TERM_NO, CLASS_NO, STUDENT_NO);
ALTER TABLE TB_GRADE ADD CONSTRAINT GRD_CLS_CLASS_NO_FK FOREIGN KEY(CLASS_NO)
                           REFERENCES TB_CLASS(CLASS_NO);
ALTER TABLE TB_GRADE ADD CONSTRAINT GRD_STD_STUDENT_NO_FK FOREIGN KEY(STUDENT_NO)
                           REFERENCES TB_STUDENT(STUDENT_NO);
COMMENT ON COLUMN TB_GRADE.TERM_NO IS '학기 번호';
COMMENT ON COLUMN TB_GRADE.CLASS_NO IS '과목 번호';
COMMENT ON COLUMN TB_GRADE.STUDENT_NO IS '학생 번호';
COMMENT ON COLUMN TB_GRADE.POINT IS '학점';


-- 실행 테스트
SELECT * FROM TB_STUDENT;

SELECT * FROM TB_CLASS;
SELECT * FROM TB_CLASS WHERE preattending_class_no IS NOT NULL;

SELECT * FROM TB_DEPARTMENT;

SELECT * FROM TB_PROFESSOR;

SELECT * FROM TB_CLASS_PROFESSOR;

SELECT * FROM TB_GRADE;
/*
DROP TABLE TB_GRADE;
DROP TABLE TB_CLASS_PROFESSOR;
DROP TABLE TB_CLASS;
DROP TABLE TB_STUDENT;
DROP TABLE TB_PROFESSOR;
DROP TABLE TB_DEPARTMENT;
*/