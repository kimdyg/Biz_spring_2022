# Spring CRUD 구현

## VO 클래스 디자인(추상화, 클래스 선언)

## 입력 Form 화면을 디자인
## Form에서 데이터를 입력하고 전송
* Form에서 입력한 데이터를 유효성 검사를 수행하는 것은 서버로 데이터를 보내기 전에 입력한 사용자에게 데이터가 잘 입력되었나 확인시키는 절차
* Client Side Validation 이라고 하는데, 보통 이때JS 코드로 수행한다
* 데이터를 입력하고 저장(전송) button click 하면 Form에 담긴 데이터는 무조건 서버로 전송이된다
* 이러한 상황이 되면 JS 코드를 사용하여 Client Side Validation을 수행할 수 없다.
* Form에 포함된 모든 버튼의 기본 속성을 무력화 하여 무조건 데이터가 서버로 전송되는것을 방지시켜야한다
* Form에 포함된 버튼의 기본속성이란 버튼을 클릭했을때 submit event 가 자동으로 수행되는 것을 말한다.
* 아래와 같이 form tag 로 감싸진 button 은 클릭했을때 무조건 form tag action 주소로 서버에 요청하도록 사전에 정의 되어있
* form tag 내의 button에는 submit 이라는 default event 가 자동으로 설정된다.
* 이러한 상황에서는 JS 코드를 사용하여 데이터 유효성 검사를 할 수 없다.
* 때문에 button submit event 를 무력화 시켜야한다.
```
<form action="/school/score">
	<button class="btn-red">서버로보내기</button>
</form>
```
* form tag 내의 button은 기본 type이 ```type="submit"``` 이다
* button 을 클릭하면 서버로 무조건 달려가는 event 가 실행된다.
* 이 button type 을 ```type="button"```으로 설정하면 submit event가 무력화 된다.
```
<form action="/school/score">
	<button type="button class="btn-red">서버로보내기</button>
</form>
```

* 또 다른 방법으로 form 의 sumit() event 를 가로채는 방법도 있다.
## 데이터 유효성 검사
## Controller에 데이터 수신할 method 처리
## Service로 데이터 전송
## Dao를 통해서 DBMS insert 요청

## Dao를 통해서 DBMS 에게 Select 요청
## Service에 받고
## Controller 로 return
## JSP 에 View Rendering 수행