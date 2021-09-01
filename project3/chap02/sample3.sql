-- 테이블의 정보를 간략히 보여줌 : not null 제약조건 확인 할 수 있음.
DESC SUBJECT_T;

SELECT * FROM USER_CONSTRAINTS;
SELECT * FROM USER_CONSTRAINTS WHERE table_name = 'SUBJECT_T';

DROP TABLE SUBJECT_T;

/*
CREATE TABLE subject_t(
    s_id NUMBER PRIMARY KEY,  -- 컬럼 레벨로 작성
    s_name VARCHAR2(30) UNIQUE,
    s_teacher VARCHAR2(30) NOT NULL
);

CREATE TABLE subject_t(
    s_id NUMBER,
    s_name VARCHAR2(30),
    s_teacher VARCHAR2(30) NOT NULL,
    -- 테이블 레벨
    PRIMARY KEY(s_id),
    UNIQUE(s_name)
);
*/
CREATE TABLE subject_t(
    s_id NUMBER,
    s_name VARCHAR2(30),
    s_teacher VARCHAR2(30)
);
ALTER TABLE subject_t ADD CONSTRAINT SUBJECT_T_S_ID_PK PRIMARY KEY(s_id);
ALTER TABLE subject_t ADD CONSTRAINT SUBJECT_T_S_NAME_UK UNIQUE(s_name);
ALTER TABLE subject_t MODIFY s_teacher CONSTRAINT SUBJECT_T_S_TEACHER_NN NOT NULL;

COMMENT ON COLUMN subject_t.s_id IS '과목번호(코드)';
COMMENT ON COLUMN subject_t.s_name IS '과목명';
COMMENT ON COLUMN subject_t.s_teacher IS '해당 과목 담당 선생님';

INSERT INTO subject_t VALUES(1, '국어', '박수현');
-- NOT NULL 제약조건 위반
-- INSERT INTO subject_t(s_id, s_name) VALUES(2, '영어');

INSERT INTO subject_t VALUES(2, '영어', '김장훈');
-- UNIQUE 제약조건 위반
-- INSERT INTO subject_t VALUES(2, '영어', '박조원');

INSERT INTO subject_t VALUES(3, '수학', '이창훈');

SELECT * FROM subject_t;

-- 학생 정보를 저장하기 위한 데이터베이스 테이블을 생성해보시오.
-- 학생 정보에는 학생코드(PK), 학생이름(NN), 반, 성별, 담임 이 있다.

DROP TABLE student_t;
CREATE TABLE student_t(
    s_id NUMBER,
    s_name VARCHAR2(30),
    s_class NUMBER,
    gender CHAR(1), -- CHECK(gender IN ('m', 'w')),
    s_teacher VARCHAR(30)
    -- CHECK(gender IN ('m', 'w'))
);
ALTER TABLE student_t ADD CONSTRAINT STUDENT_S_ID_PK PRIMARY KEY(s_id);
ALTER TABLE student_t MODIFY s_name CONSTRAINT STUDENT_S_NAME_NN NOT NULL;
ALTER TABLE student_t ADD CONSTRAINT STUDENT_GENDER_CK CHECK(gender IN ('m', 'w'));

INSERT INTO student_t VALUES(1, '홍길동', 1, 'm', '박수현');

COMMENT ON COLUMN student_t.s_id IS '학생번호(코드)';
COMMENT ON COLUMN student_t.s_name IS '학생이름';
COMMENT ON COLUMN student_t.s_class IS '소속 반';
COMMENT ON COLUMN student_t.gender IS '성별';
COMMENT ON COLUMN student_t.s_teacher IS '담당 선생님';

SELECT * FROM USER_CONSTRAINTS WHERE table_name = 'STUDENT_T';


-- 교사 정보를 관리하기 위한 teacher_t 테이블을 생성한다.
-- 이 테이블에는 t_id, t_name, t_type, s_part 컬럼이 사용된다.
-- t_id : 교사코드, 정수코드, PK
-- t_name : 교사명, 문자열(50자), NN
-- t_type : 교사구분(담임교사:m, 일반교사:n, 시간교사:t)
-- s_part : 담당과목, 정수코드, NN
DROP TABLE teacher_t;
CREATE TABLE teacher_t(
    t_id NUMBER,
    t_name VARCHAR2(150),
    t_type CHAR(1),
    s_part NUMBER
);
ALTER TABLE teacher_t ADD CONSTRAINT TEACHER_T_ID_PK PRIMARY KEY(t_id);
ALTER TABLE teacher_t MODIFY t_name CONSTRAINT TEACHER_T_NAME_NN NOT NULL;
ALTER TABLE teacher_t ADD CONSTRAINT TEACHER_T_TYPE CHECK(t_type IN ('m', 'n', 't'));
ALTER TABLE teacher_t MODIFY s_part CONSTRAINT TEACHER_S_PART_NN NOT NULL;

COMMENT ON COLUMN teacher_t.t_id IS '교사코드';
COMMENT ON COLUMN teacher_t.t_name IS '교사명';
COMMENT ON COLUMN teacher_t.t_type IS '교사구분(담임교사:m, 일반교사:n, 시간교사:t)';
COMMENT ON COLUMN teacher_t.s_part IS '담당과목';

SELECT * FROM ALL_ALL_TABLES WHERE table_name = 'TEACHER_T';
SELECT * FROM ALL_TAB_COLUMNS WHERE table_name = 'TEACHER_T';
SELECT * FROM ALL_COL_COMMENTS WHERE table_name = 'TEACHER_T';
SELECT * FROM USER_CONSTRAINTS WHERE table_name = 'TEACHER_T';



-- 학과 테이블
DROP TABLE tb_department;
CREATE TABLE tb_department(
    department_no VARCHAR2(10),
    department_name VARCHAR2(20),
    category VARCHAR2(20),
    open_yn CHAR(1),
    capacity NUMBER
);
ALTER TABLE tb_department ADD CONSTRAINT TB_DEPARTMENT_NO_PK PRIMARY KEY(department_no);
ALTER TABLE tb_department MODIFY department_name CONSTRAINT TB_DEPARTMENT_NAME_NN NOT NULL;
ALTER TABLE tb_department ADD CONSTRAINT TB_DEPARTMENT_CATEGORY CHECK(category IN ('y', 'n'));

COMMENT ON COLUMN tb_department.department_no IS '학과 번호';
COMMENT ON COLUMN tb_department.department_name IS '학과 이름';
COMMENT ON COLUMN tb_department.category IS '계열';
COMMENT ON COLUMN tb_department.open_yn IS '개설 여부';
COMMENT ON COLUMN tb_department.capacity IS '정원';

SELECT * FROM ALL_ALL_TABLES WHERE table_name = 'TB_DEPARTMENT';
SELECT * FROM ALL_TAB_COLUMNS WHERE table_name = 'TB_DEPARTMENT';
SELECT * FROM ALL_COL_COMMENTS WHERE table_name = 'TB_DEPARTMENT';
SELECT * FROM USER_CONSTRAINTS WHERE table_name = 'TB_DEPARTMENT';



-- 학생 테이블
DROP TABLE tb_student;
CREATE TABLE tb_student(
    student_no VARCHAR2(10),
    department_no VARCHAR2(10),
    student_name VARCHAR2(30),
    student_ssn VARCHAR2(14),
    student_address VARCHAR2(100),
    entrance_date DATE,
    absence_yn CHAR(1),
    coach_professor_no VARCHAR2(10)
);
ALTER TABLE tb_student ADD CONSTRAINT TB_STUDENT_NO_PK PRIMARY KEY(student_no);
ALTER TABLE tb_student ADD CONSTRAINT TB_STUDENT_DEPARTMENT_NO_FK FOREIGN KEY(department_no) REFERENCES tb_department(department_no);
ALTER TABLE tb_student MODIFY student_name CONSTRAINT TB_STUDENT_NAME_NN NOT NULL;
ALTER TABLE tb_student ADD CONSTRAINT TB_STUDENT_ABSENCE_YN CHECK(absence_yn IN ('y', 'n'));
ALTER TABLE tb_student ADD CONSTRAINT TB_STUDENT_COACH_PROFESSOR_NO_FK FOREIGN KEY(coach_professor_no) REFERENCES tb_professor(professor_no);

COMMENT ON COLUMN tb_student.student_no IS '학생 번호';
COMMENT ON COLUMN tb_student.department_no IS '학과 번호';
COMMENT ON COLUMN tb_student.student_name IS '학생 이름';
COMMENT ON COLUMN tb_student.student_ssn IS '학생 주민번호 ';
COMMENT ON COLUMN tb_student.student_address IS '학생 주소';
COMMENT ON COLUMN tb_student.entrance_date IS '입학 일자';
COMMENT ON COLUMN tb_student.absence_yn IS '휴학 여부';
COMMENT ON COLUMN tb_student.coach_professor_no IS '지도 교수 번호';

SELECT * FROM ALL_ALL_TABLES WHERE table_name = 'TB_STUDENT';
SELECT * FROM ALL_TAB_COLUMNS WHERE table_name = 'TB_STUDENT';
SELECT * FROM ALL_COL_COMMENTS WHERE table_name = 'TB_STUDENT';
SELECT * FROM USER_CONSTRAINTS WHERE table_name = 'TB_STUDENT';




-- 과목 테이블
DROP TABLE tb_class;
CREATE TABLE tb_class(
    class_no VARCHAR2(10),
    department_no VARCHAR2(10),
    preattending_class_no VARCHAR2(10),
    class_name VARCHAR2(30),
    class_type VARCHAR2(10)
);
ALTER TABLE tb_class ADD CONSTRAINT TB_CLASS_NO_PK PRIMARY KEY(class_no);
ALTER TABLE tb_class ADD CONSTRAINT TB_CLASS_PRETD_CLASS_NO_FK FOREIGN KEY(preattending_class_no) REFERENCES tb_class(class_no);
ALTER TABLE tb_class MODIFY DEPARTMENT_NO CONSTRAINT TB_CLASS_DEPARTMENT_NO_NN NOT NULL;
ALTER TABLE tb_class ADD CONSTRAINT TB_CLASS_DEPARTMENT_NO_FK FOREIGN KEY(department_no) REFERENCES tb_department(department_no);
ALTER TABLE tb_class MODIFY CLASS_NAME CONSTRAINT TB_CLASS_NAME_NN NOT NULL;

COMMENT ON COLUMN tb_class.class_no IS '과목 번호';
COMMENT ON COLUMN tb_class.department_no IS '학과 번호';
COMMENT ON COLUMN tb_class.preattending_class_no IS '선수 과목 번호';
COMMENT ON COLUMN tb_class.class_name IS '과목 이름';
COMMENT ON COLUMN tb_class.class_type IS '과목 구분';

SELECT * FROM ALL_ALL_TABLES WHERE table_name = 'TB_CLASS';
SELECT * FROM ALL_TAB_COLUMNS WHERE table_name = 'TB_CLASS';
SELECT * FROM ALL_COL_COMMENTS WHERE table_name = 'TB_CLASS';
SELECT * FROM USER_CONSTRAINTS WHERE table_name = 'TB_CLASS';





-- 과목 교수 테이블
DROP TABLE tb_class_professor;
CREATE TABLE tb_class_professor(
    class_no VARCHAR2(10),
    professor_no VARCHAR2(10)
);

ALTER TABLE tb_class_professor ADD CONSTRAINT TB_CLASS_PROFESSOR_PK PRIMARY KEY(class_no, professor_no);
ALTER TABLE tb_class_professor ADD CONSTRAINT TB_CLASS_PROFESSOR_CLASS_NO_FK FOREIGN KEY(class_no) REFERENCES tb_class(class_no);
ALTER TABLE tb_class_professor ADD CONSTRAINT TB_CLASS_PROFESSOR_PROFESSOR_NO_FK FOREIGN KEY(professor_no) REFERENCES tb_professor(professor_no);

COMMENT ON COLUMN tb_class_professor.class_no IS '과목 번호';
COMMENT ON COLUMN tb_class_professor.professor_no IS '교수 번호';

SELECT * FROM ALL_ALL_TABLES WHERE table_name = 'TB_CLASS_PROFESSOR';
SELECT * FROM ALL_TAB_COLUMNS WHERE table_name = 'TB_CLASS_PROFESSOR';
SELECT * FROM ALL_COL_COMMENTS WHERE table_name = 'TB_CLASS_PROFESSOR';
SELECT * FROM USER_CONSTRAINTS WHERE table_name = 'TB_CLASS_PROFESSOR';





-- 교수 테이블
DROP TABLE tb_professor;
CREATE TABLE tb_professor(
    professor_no VARCHAR2(10),
    professor_name VARCHAR2(30),
    professor_ssn VARCHAR2(14),
    professor_address VARCHAR2(100),
    department_no VARCHAR2(10)
);
ALTER TABLE tb_professor ADD CONSTRAINT TB_PROFESSOR_NO_PK PRIMARY KEY(professor_no);
ALTER TABLE tb_professor MODIFY professor_name CONSTRAINT TB_PROFESSOR_NAME_NN NOT NULL;
ALTER TABLE tb_professor ADD CONSTRAINT TB_PROFESSOR_DEPARTMENT_NO_FK FOREIGN KEY(department_no) REFERENCES tb_department(department_no);


COMMENT ON COLUMN tb_professor.professor_no IS '교수 번호';
COMMENT ON COLUMN tb_professor.professor_name IS '교수 이름';
COMMENT ON COLUMN tb_professor.professor_ssn IS '교수 주민번호';
COMMENT ON COLUMN tb_professor.professor_address IS '교수 주소';
COMMENT ON COLUMN tb_professor.department_no IS '학과 번호';

SELECT * FROM ALL_ALL_TABLES WHERE table_name = 'TB_PROFESSOR';
SELECT * FROM ALL_TAB_COLUMNS WHERE table_name = 'TB_PROFESSOR';
SELECT * FROM ALL_COL_COMMENTS WHERE table_name = 'TB_PROFESSOR';
SELECT * FROM USER_CONSTRAINTS WHERE table_name = 'TB_PROFESSOR';




-- 성적 테이블
DROP TABLE tb_grade;
CREATE TABLE tb_grade(
    term_no VARCHAR2(10),
    class_no VARCHAR2(30),
    student_no VARCHAR2(14),
    point NUMBER
);
ALTER TABLE tb_grade ADD CONSTRAINT TB_GRADE_TERM_NO_PK PRIMARY KEY(term_no);
ALTER TABLE tb_grade ADD CONSTRAINT TB_GRADE_CLASS_NO_FK FOREIGN KEY(class_no) REFERENCES tb_class(class_no);
ALTER TABLE tb_grade ADD CONSTRAINT TB_GRADE_STUDNET_NO_FK FOREIGN KEY(student_no) REFERENCES tb_student(student_no);
ALTER TABLE tb_grade ADD CONSTRAINT TB_GRADE_POINT CHECK(point IN (3,2));

COMMENT ON COLUMN tb_grade.term_no IS '학기 번호';
COMMENT ON COLUMN tb_grade.class_no IS '과목 번호';
COMMENT ON COLUMN tb_grade.student_no IS '학생 번호';
COMMENT ON COLUMN tb_grade.point IS '학점';

SELECT * FROM ALL_ALL_TABLES WHERE table_name = 'TB_GRADE';
SELECT * FROM ALL_TAB_COLUMNS WHERE table_name = 'TB_GRADE';
SELECT * FROM ALL_COL_COMMENTS WHERE table_name = 'TB_GRADE';
SELECT * FROM USER_CONSTRAINTS WHERE table_name = 'TB_GRADE';

SELECT * FROM ALL_ALL_TABLES WHERE table_name LIKE 'TB%';

DROP TABLE TB_GRADE;
DROP TABLE TB_CLASS_PROFESSOR;
DROP TABLE TB_CLASS;
DROP TABLE TB_STUDENT;
DROP TABLE TB_PROFESSOR;
DROP TABLE TB_DEPARTMENT;