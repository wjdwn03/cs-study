# REST & RESTful

## :bookmark_tabs: 목차

[:arrow_up: **Network**](../README.md)

1. ### REST & RESTful
   - [:page_facing_up: REST](#rest)
   - [:page_facing_up: REST API](#rest-api)
   - [:page_facing_up: RESTful](#restful)


## REST <sub>Representational State Transfer</sub>

> 월드 와이드 웹(www)과 같은 분산 하이퍼미디어 시스템을 위한 소프트웨어 아키텍처의 한 형식

- 기본적으로 웹의 기존 기술과 HTTP 프로토콜을 그대로 활용하기 때문에 웹의 장점을 최대한 활용할 수 있는 아키텍처 스타일
- 네트워크 상에서 Client와 Server 사이의 통신 방식 중 하나
- 자원을 이름(자원의 표현)으로 구분하여 해당 자원의 상태(정보)를 주고 받는 모든 것을 의미

- 자원(resource)의 표현(representation)
    - 자원: 해당 소프트웨어가 관리하는 모든 것
    - ex) 문서, 그림, 데이터, 해당 소프트웨어 자체 등
    - 자원의 표현: 그 자원을 표현하기 위한 이름
    - ex) DB의 학생 정보가 자원일 때, ‘students’를 자원의 표현으로 정함.
- 상태(정보) 전달
    - 데이터가 요청되어지는 시점에서 자원의 상태(정보)를 전달
    - JSON 혹은 XML를 통해 데이터를 주고 받는 것이 일반적

- HTTP URI<sub>Uniform Resource Identifier</sub>를 통해 자원(Resource)을 명시하고, HTTP Method(POST, GET, PUT, DELETE)를 통해 해당 자원에 대한 CRUD Operation을 적용하는 것을 의미
    - 즉, REST는 자원 기반의 구조(ROA<sub>Resource Oriented Architecture</sub>) 설계의 중심에 resource가 있고 HTTP Method를 통해 resource를 처리하도록 설계된 아키텍처

### 장점

- HTTP protocol의 인프라는 그대로 사용하기 때문에 REST API 사용을 위한 별도의 인프라를 구축할 필요가 없음.
- HTTP protocol의 표준을 최대한 활용하여 여러 장점을 함께 가져갈 수 있음.
- HTTP 표준 protocol에 따르는 모든 플랫폼에서 사용 가능
- REST API 메시지가 의도하는 바를 명확하게 나타내므로 의도하는 바를 쉽게 파악할 수 있음.
- 서버와 클라이언트의 역할을 명확하게 분리함.

### 단점

- 표준이 존재하지 않음.
- HTTP Method 형태가 제한적

### REST가 필요한 이유
- 애플리케이션 분리 및 통합
- 다양한 클라이언트의 등장
    - 다양한 브라우저, 안드로이드폰, 아이폰과 같은 모바일 디바이스에서도 통신을 할 수 있어야 함.


### REST의 구성 요소

#### 자원(Resource) - URI

- 모든 자원에 고유한 ID가 존재하고 이 자원은 서버에 존재
- 자원을 구별하는 ID는 HTTP URI임.
- 클라이언트는 URI를 이용해서 자원을 지정하고 해당 자원의 상태(정보)에 대한 조작을 서버에 요청

#### 행위 - HTTP Method

- HTTP protocol의 Method를 사용
    - GET, POST, PUT, DELETE와 같은 메서드를 제공

#### 표현

- 클라이언트가 자원의 상태에 대한 조작을 요청하면 서버는 이에 적절한 응답을 보냄.
- REST에서 하나의 자원은 JSON, XML, TEXT, RSS 등 여러 형태의 표현으로 나타내어 질 수 있음.
- JSON 이나 XML을 통해 데이터를 주고 받는 것이 일반적

### REST 특징

#### Server-Client 구조

- Server
    - 자원이 있는 쪽
    - API를 제공하고 비즈니스 로직 처리 및 저장을 책임짐.
- Client
    - 자원을 요청하는 쪽
    - 사용자 인증이나 context 등을 직접 관리하고 책임짐.
- 이러한 구조이기 때문에 서버와 클라이언트는 서로 의존성이 줄어듦.

#### Stateless <sub>무상태성</sub>

- HTTP protocol을 사용하기 때문에 REST도 stateless한 특성을 가짐.
- 클라이언트의 context를 서버에 저장하지 않음.
    - 세션과 쿠키와 같은 context 정보를 신경쓰지 않아도 되므로 구현이 단순해짐.
- 서버는 각각의 요청을 완전히 별개의 것으로 인식하고 처리
    - 서버는 이전 요청이 다음 요청의 처리에 연관되어 처리하면 안됨.
    - 이전 요청이 DB를 수정하여 DB에 의해 바뀌는 것은 허용
    - 서버의 처리 방식에 일관성을 부여하고 부담이 줄어들며, 서비스의 자유도가 높아짐.

#### Cacheable <sub>캐시 처리 가능</sub>

- 웹 표준 HTTP protocol을 그대로 사용하므로 HTTP의 특징 중 하나인 캐싱 기능을 적용할 수 있음.
- HTTP 표준 protocol에서 사용하는 Last-Modified 태그나 E-Tag를 이용하면 캐싱 구현 가능
- 캐시 사용을 통해 응답 시간이 빨라지고 REST Server 트랜잭션이 발생하지 않기 때문에 전체 응답시간, 성능, 서버의 자원 이용률을 향상시킬 수 있음.

#### Layered System <sub>계층화</sub>

- Client는 REST API Server만 호출
- REST Server는 다중 계층으로 구성될 수 있음.

- API Server는 순수 비즈니스 로직을 수행하고 그 앞단에 보안, 로드밸런싱, 암호화, 사용자 인증 등을 추가하여 구조상의 유연성을 줄 수 있음.
- 또한 로드밸런싱, 공유 캐시 등을 통해 확장성과 보안성을 향상시킬 수 있음.

- PROXY, 게이트웨이 같은 네트워크 기반의 중간 매체를 사용할 수 있음.

#### Code-On-Demand(optional)

- Server로부터 스크립트를 받아서 Client에서 실행
- 반드시 충족할 필요는 없음.

#### Uniform Interface <sub>인터페이스 일관성</sub>

- URI로 지정한 Resource에 대한 조작을 통일되고 한정적인 인터페이스로 수행
- HTTP 표준 프로토콜에 따르는 모든 플랫폼에서 사용이 가능

- 특정 언어나 기술에 종속되지 않음.

## REST API

> REST 아키텍처 스타일을 따르는 API

### 특징
- 사내 시스템들도 REST 기반으로 시스템을 분산해 확장성과 재사용성을 높여 유지보수 및 운용을 편리하게 할 수 있음.
- REST는 HTTP 표준을 기반으로 구현하므로, HTTP를 지원하는 프로그램 언어로 클라이언트, 서버를 구현할 수 있음.
    - 즉, REST API를 제작하면 델파이 클라이언트 뿐 아니라, 자바, C#, 웹 등을 이용해 클라이언트를 제작할 수 있음.

### REST API 디자인 가이드

REST API 설계 시 가장 중요한 항목은 다음의 2가지로 요약

1. URI는 정보의 자원을 표현해야 한다.
2. 자원에 대한 행위는 HTTP Method(GET, POST, PUT, PATCH, DELETE)로 표현
    행위(Method)는 URI에 포함하지 않는다.


## RESTful

> REST 원리를 따르는 시스템, REST API를 제공하는 웹 서비스

#### RESTful의 목적

- 이해하기 쉽고 사용하기 쉬운 REST API를 만드는 것
    - RESTful한 API를 구현하는 근본적인 목적이 성능 향상에 있는 것이 아니라 일관적인 컨벤션을 통한 API의 이해도 및 호환성을 높이는 것이 주 동기이니, 성능이 중요한 상황에서는 굳이 RESTful한 API를 구현할 필요는 없음.
- RESTful 하지 못한 경우
    - ex1) CRUD 기능을 모두 POST로만 처리하는 API
    - ex2) route에 resource, id 외의 정보가 들어가는 경우(/students/updateName)

</br>

---

- 참고

    [REST란?](https://docs.aws.amazon.com/ko_kr/appsync/latest/devguide/what-is-rest.html)

    [RESTful API란](https://velog.io/@somday/RESTful-API-%EC%9D%B4%EB%9E%80)

    [[간단정리] REST, REST API, RESTful 특징](https://hahahoho5915.tistory.com/54)

    [REST API란? REST, RESTful이란](https://khj93.tistory.com/entry/%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC-REST-API%EB%9E%80-REST-RESTful%EC%9D%B4%EB%9E%80)

    [REST란? REST API 와 RESTful API의 차이점](https://dev-coco.tistory.com/97)