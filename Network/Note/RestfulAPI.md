# :books: RESTful API

## :bookmark_tabs: 목차

[:arrow_up: **Network**](../README.md)

1. ### [REST](#📕-rest)
2. ### [REST API](#📙-rest-api)
3. ### [RESTful](#📗-restful)

# :closed_book: REST

## 정의

> REST(Representational State Transfer)는 월드 와이드 웹과 같은 분산 하이퍼미디어 시스템을 위한 소프트웨어 아키텍처의 한 형식

## 특징

- REST는 기본적으로 웹의 기존 기술과 HTTP 프로토콜을 그대로 활용하기 때문에 웹의 장점을 최대한 활용할 수 있는 아키텍처 스타일
- REST는 네트워크 상에서 Client와 Server 사이의 통신 방식 중 하나
- 자원을 이름(자원의 표현)으로 구분하여 해당 자원의 상태(정보)를 주고 받는 모든 것을 의미
  - 자원(resource)의 표현(representation
    1. 자원 : 해당 소프트웨어가 관리하는 모든 것  
       ex) 문서, 그림, 데이터, 해당 소프트웨어 자체 등
    2. 자원의 표현 : 그 자원을 표현하기 위한 이름  
       ex) DB의 학생 정보가 자원일 때, ‘students’를 자원의 표현으로 정의
  - 상태(state) 전달
    - 데이터가 요청되어지는 시점에서 자원의 상태(정보)를 전달
    - 일반적으로 JSON 혹은 XML를 통해 데이터를 주고 받음

### REST 구체적인 개념

- HTTP URI(Uniform Resource Identifier)를 통해 자원(Resource)을 명시하고, HTTP Method(POST, GET, PUT, DELETE)를 통해 해당 자원에 대한 CRUD Operation을 적용하는 것
  - REST는 자원 기반의 구조(ROA, Resource Oriented Architecture) 설계의 중심에 Resource가 있고 HTTP Method를 통해 Resource를 처리하도록 설계된 아키텍쳐
  - 웹 사이트의 이미지, 텍스트, DB 내용 등의 모든 자원에 고유한 ID인 HTTP URI를 부여
  - **CRUD Operation**
    - Create : 생성(`POST`)
    - Read : 조회(`GET`)
    - Update : 수정(`PUT`)
    - Delete : 삭제(`DELETE`)
    - HEAD: 헤더 정보 조회(`HEAD`)

### Server-Client(서버-클라이언트 구조)

- 자원이 있는 쪽이 Server, 자원을 요청하는 쪽이 Client
- REST Server: API를 제공하고 비즈니스 로직 처리 및 저장을 담당
- Client: 사용자 인증이나 context(세션, 로그인 정보) 등을 직접 관리를 담당
- 서로의 의존성이 줄이는 것이 목적

### Stateless(무상태)

- HTTP 프로토콜은 Stateless Protocol이므로 REST 역시 무상태성을 가짐
- Client의 context를 Server에 저장하지 않음
  - 세션과 쿠키와 같은 context 정보를 신경쓰지 않아도 되므로 구현이 단순
- Server는 각각의 요청을 완전히 별개의 것으로 인식하고 처리
  - 각 API 서버는 Client의 요청만을 단순 처리
  - 이전 요청이 다음 요청의 처리에 연관되선 안됨
  - 이전 요청이 DB를 수정하여 DB에 의해 바뀌는 것은 허용
  - 서버의 처리 방식에 일관성을 부여하고 부담이 줄어들며, 서비스의 유연성 증가

### Cacheable(캐시 처리 가능)

- 웹 표준 HTTP 프로토콜을 그대로 사용해 웹에서 사용하는 기존의 인프라를 활용 가능
  - HTTP가 가진 가장 강력한 특징 중 하나인 캐싱 기능을 적용가능
  - HTTP 프로토콜 표준에서 사용하는 Last-Modified 태그나 E-Tag를 이용하면 캐싱 구현이 가능
- 대량의 요청을 효율적으로 처리하기 위해 캐시가 요구
- 캐시 사용을 통해 응답시간이 빨라지고 REST Server 트랜잭션이 발생하지 않아 전체 응답시간, 성능, 서버의 자원 이용률 향상

### Layered System(계층화)

- Client는 REST API Server만 호출
- REST Server는 다중 계층으로 구성할 수 있음
  - API Server는 순수 비즈니스 로직을 수행
  - 앞단에 보안, 로드밸런싱, 암호화, 사용자 인증 등을 추가하여 구조상의 유연성 부여
  - 로드밸런싱, 공유 캐시 등을 통해 확장성과 보안성을 향상
- PROXY, 게이트웨이 같은 네트워크 기반의 중간 매체를 사용가능

### Code-On-Demand(optional)

- Server로부터 스크립트를 받아서 Client에서 실행
- optional이기 때문에 선택적으로 구성

### Uniform Interface(인터페이스 일관성)

- URI로 지정한 Resource에 대한 조작을 통일되고 한정적인 인터페이스로 수행
- HTTP 표준 프로토콜에 따르는 모든 플랫폼에서 사용이 가능

특정 언어나 기술에 종속되지 않는다.

## REST의 장단점

### 장점

- HTTP 프로토콜의 인프라를 그대로 사용
  - REST API 사용을 위한 별도의 인프라 구축이 필요 없음
- HTTP 프로토콜의 표준을 최대한 활용하여 여러 추가적인 장점을 함께 공유
- HTTP 표준 프로토콜에 따르는 모든 플랫폼에서 사용이 가능
- Hypermedia API의 기본을 충실히 지키면서 범용성을 보장
- REST API 메시지가 의도하는 바를 명확하게 나타내므로 의도하는 바를 쉽게 파악
- 서비스 디자인에서 생길 수 있는 여러 문제를 최소화할 수 있음
- 서버와 클라이언트의 역할을 명확하게 분리하는 설계가 가능

### 단점

- 표준이 존재하지 않음(표준화가 어려움)
- HTTP Method 형태와 일치해야 하므로 구현할수 있는 형식이 제한적

## REST가 필요한 이유

- 애플리케이션 분리 및 통합
- 다양한 클라이언트의 등장
  - 최근의 웹 서버는 다양한 브라우저와 모바일 디바이스와 교차 통신 기능을 요구함
  - 멀티 플랫폼에 대한 지원을 위해 서비스 자원에 대한 아키텍처의 필요성 대두

## REST 구성 요소

### 자원(Resource): URI

- 모든 자원에 고유한 ID가 존재하고, 이 자원은 Server에 존재
- 자원을 구별하는 ID는 `/groups/:group_id`와 같은 HTTP URI
- Client는 URI를 이용해 특정 자원의 상태(정보)에 대한 조작을 Server에 요청

### 행위(Verb): HTTP Method

- HTTP 프로토콜의 Method를 사용
- HTTP 프로토콜은 GET, POST, PUT, DELETE 와 같은 메서드를 제공

### 표현(Representation of Resource)

- Client가 자원의 상태(정보)에 대한 조작을 요청하면 Server는 이에 적절한 응답을 전송
- REST에서 자원은 JSON, XML, TEXT, RSS 등 여러 형태의 Representation으로 표현
- 일반적으로 JSON 혹은 XML를 통해 데이터를 주고 받음

# :orange_book: REST API

## 정의

> REST원리를 기반으로 설계한 서비스 API(Application Programming Interface)

## 특징

- REST 기반으로 시스템을 분산해 확장성과 재사용성을 높여 유지보수 및 운용에 용이
- HTTP 표준을 기반으로 구현하므로, HTTP를 지원하는 프로그램 언어로 클라이언트, 서버를 구현할 수 있음
  - 자바, C#, 웹 등을 이용해 클라이언트를 제작할 수 있음

## REST API 설계 규칙

### 용어 정의

- **도큐먼트** : 객체 인스턴스나 데이터베이스 레코드와 유사한 개념
- **컬렉션** : 서버에서 관리하는 디렉터리라는 리소스
- **스토어** : 클라이언트에서 관리하는 리소스 저장소

### 설계 기본 규칙

1. URI는 정보의 자원을 표현해야 한다.
   - resource는 동사보다는 명사를, 대문자보다는 소문자를 사용한다.
   - resource의 도큐먼트 이름으로는 단수 명사를 사용해야 한다.
   - resource의 컬렉션 이름으로는 복수 명사를 사용해야 한다.
   - resource의 스토어 이름으로는 복수 명사를 사용해야 한다.  
     ex) `GET /Member/1 -> GET /members/1`
2. 자원에 대한 행위는 HTTP Method(GET, PUT, POST, DELETE 등)로 표현한다.

- URI에 HTTP Method가 들어가면 안된다.  
  ex) `GET /members/delete/1 -> DELETE /members/1`
- URI에 행위에 대한 동사 표현이 들어가면 안된다.
  - CRUD 기능을 나타내는 것은 URI에 사용하지 않는다.  
    ex) `GET /members/show/1 -> GET /members/1`  
    ex) `GET /members/insert/2 -> POST /members/2`
- 경로 부분 중 변하는 부분은 유일한 값으로 대체한다.
  - id는 하나의 특정 resource를 나타내는 고유값이다.  
    ex) `student를 생성하는 route: POST /students`  
    ex) `id=12인 student를 삭제하는 route: DELETE /students/12`

### API 설계 규칙

1. 슬래시 구분자(`/`)는 계층 관계를 나타내는데 사용한다.  
   ex) `http://restapi.example.com/houses/apartments`
2. URI 마지막 문자로 슬래시(/ )를 포함하지 않는다.
   - URI에 포함되는 모든 글자는 리소스의 유일한 식별자로 사용되어야 하며 URI가 다르다는 것은 리소스가 다르다는 것이고, 역으로 리소스가 다르면 URI도 달라져야 한다.
   - REST API는 분명한 URI를 만들어 통신을 해야 하기 때문에 혼동을 주지 않도록 URI 경로의 마지막에는 `/`를 사용하지 않는다.  
     ex) `http://restapi.example.com/houses/apartments/` <- x
3. 하이픈(`-`)은 URI 가독성을 높이는데 사용한다.
   - 불가피하게 긴 URI경로를 사용하게 된다면 하이픈을 사용해 가독성을 높인다.
4. 밑줄(`_`)은 URI에 사용하지 않는다.
   - 밑줄은 보기 어렵거나 밑줄 때문에 문자가 가려지기도 하므로 가독성을 위해 밑줄은 사용하지 않는다.
5. URI 경로에는 소문자가 적합하다.
   - URI 경로에 대문자 사용은 피하도록 한다.
   - RFC 3986(URI 문법 형식)은 URI 스키마와 호스트를 제외하고는 대소문자를 구별하도록 규정함
6. 파일확장자는 URI에 포함하지 않는다.
   - REST API에서는 메시지 Body 내용의 포맷을 나타내기 위한 파일 확장자를 URI 안에 포함시키지 않는다.  
     ex) `http://restapi.example.com/members/soccer/345/photo.jpg` <- x
   - Accept header를 사용해 파일 확장자를 제공한다.  
     ex) `GET / members/soccer/345/photo HTTP/1.1 Host: restapi.example.com Accept: image/jpg` <- o
7. 리소스 간에는 연관 관계가 있는 경우
   - /리소스명/리소스 ID/관계가 있는 다른 리소스명  
     ex) `GET : /users/{userid}/devices` (has-a 관계성)

# :green_book: RESTful

## 정의

> REST원리를 따르는 시스템 아키텍처로 구현된 웹 서비스 지칭

- REST API를 제공하는 웹 서비스를 RESTful하다고 정의할 수 있음
- RESTful은 REST를 REST답게 쓰기 위한 방법으로, 공식적 용어는 아님

## RESTful의 목적

- 이해하기 쉽고 사용하기 쉬운 REST API를 만드는 것
- RESTful한 API를 구현하는 근본적인 목적이 성능 향상에 있는 것이 아니라 일관적인 컨벤션을 통한 API의 이해도 및 호환성을 높이는 것이 주 목표
  - 성능이 중요한 상황에서는 굳이 RESTful한 API를 구현할 필요는 없음
- RESTful 하지 못한 경우
  - CRUD 기능을 모두 POST로만 처리하는 API
  - route에 resource, id 외의 정보가 들어가는 경우(`/students/updateName`)
