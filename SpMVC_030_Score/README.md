# 성적처리 프로젝트
* SpMVS_030_Score
* base-package : com.callor.score

## DB 연결
* MySQL 의 schoolDB

## table
* tbl_student, tbl_score, tbl_subject

## DB 연결을 위한 Dependency 설정
* Spring-jdbc
* commons-dbcp2
* mybatis
* mybatis-spring
* mysql-connector/j
* spring-framework : 5.2.22 REL
* lombok
* logback-classic

## package 설정
* model, persistance package

## mapper folder 생성
* /WEB-INF/spring/mapper


## vo 클래스
* tabl_student, tbl_score, tbl_subject 를
참조하여 각각 studentVO, ScoreVO, subjectVO를 model package 에 생성

## Dao 인터페이스
* persistance.GenericDao interface
SelectAll() method 선언

## Student 정보 요청
* http:// localhost:8080/score/student 로 요청을 하면 학생데이터 전체를 JSON 웹 화면에 보여주는 코드 작성
* StudentController 에 @ResponseBody 부착된 home() method 선언
* StudentService.selectAll()
* StudnetDao.selectAll()
* Student-mapper.xml.selectAll()