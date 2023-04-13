# be-java-cafe
마스터즈 2023 스프링 카페<br>2차 리뷰 대비 다시 작성

# 1-1. 회원 가입 기능 구현

#### <목표>
- [ㅇ]가입하기 페이지에서 회원 가입 폼을 표시한다(기본 Html에 있음)<br>
- []Html에서 중복된 부분을 분리한다<br>
- []개인정보를 입력하고 확인을 누르면 회원 목록 조회 페이지로 이동한다

#### <설계>
- 폼에 정보 입력하고 확인 클릭을 하면: 입력한 정보가 서버로 전송(스프링 부트는 내장 서버를 가지고 있다)<br>
[@PostMapping]으로 form에서 데이터 전송하는 것 구현(HttpRequest 중 Post메소드: 값을 추가한다.)


- 회원 목록 조회 페이지로 이동:<br> 
==> 그냥 간게 아니고 양식(validation)에 맞게 User(회원) 필드 값을 다 써서 엔터(submit) 누르면....<br>
  로딩 후 회원 목록(회원 관리)페이지 <<<< 로 화면이 바뀐다는 것이 요구사항.
<br>   
※중요!<br>
         로딩 중에 일어나는 일: '서버로 데이터를 보내서 저장'<br>
  (여기서는 회원가입에 대한 거니까 -> '회원정보'데이터가 추가되야 하는 상황이므로)<br>
    1. 회원 객체가 하나 추가되고(회원 정보는 객체로 관리->필드 변수로 회원 정보 저장)<br>
    2. 회원 목록 객체 -> list.html 회원 목록 조회 템플릿 페이지에서 템플릿 엔진 덕에 동적으로 보여질 수 있는 데이터들<br>
        -> 목록에 있는 회원 데이터를 저장+조회+조건검색+뽑아낼 수 있는 데이터베이스(원래는 실제 DB가 할 역할)


- 예상 작업 순서:<br> 
        1. 일단 확인이 되야 하니까 한 2개 쯤 회원 객체가 들어있는 회원 목록 객체 + 그것을 동적으로 보여주는 회원 조회 페이지.<br> 
        2. (수동으로 이동해서 보면 됨) 템플릿 엔진으로 동적 작동이 되는 회원 목록 조회 페이지(list.html)


- 우연히 알게 된 어노테이션들:<br> 
        @Service -> 비지니스 로직(무슨 뜻인지 아직 잘 모름)<br> 
        @Repository -> 저장소<br>
        @AutoWired -> (뭔지 아직 모름)<br>
        @RequestBody -> POST API인데 Json일때 필요(아직 잘 모름)


- 기존에 가입했던 회원들 목록이 조회 화면에서 정렬되서 보여져야 될 텐데(자동으로 되는지 아직 모름)<br>
아마도 최근에 가입한 회원이 맨 위에 있으면 될 듯.


- User 자료형 필드변수: 주어진 html을 보면 아이디, 이름, 이메일, +패스워드,(그리고 뭐가 더 필요할지 아직 모름)


#### <학습>
- bean: @Controller, @Service, @Repository 등이 붙으면 bean이다(@Component)
- @AutoWired: 생성자에 사용(@Service)
- @Service: Service 클래스(@Component)
- Service 클래스 하는 역할: request 받은대로 (response 주기 위한) 필요한 데이터 가공을 하는 부분(을 분리)
- Model: .addAttribute로 컨트롤러에서 데이터를 받아서 view(mustache)에 전달(ui 구성 역할)
- domain: 
- DTO:

# 4월 10일 학습계획
- [!!] bean과 di에 대해 알아보기(더 봐야 함)
- [] 리뷰 코멘트 받은 부분들 매우 확인

### 이번 주 학습계획
- 수단과 방법을 가리지 말고 진도 따라잡기....!!!!!!  :fire:
> [] 1단계-1 (성공 직전....!!..(일지도?))<br>
> [] 1단계-2<br>
> [] 1단계-3<br>
> [] 2단계<br>
> [] 3단계<br>
> [] 3단계 배포<br>
