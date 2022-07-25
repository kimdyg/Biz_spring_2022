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
