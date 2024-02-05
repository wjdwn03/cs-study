# JWT <sub>JSON Web Token</sub>

## :bookmark_tabs: 목차

[:arrow_up: **Network**](../README.md)

1. ### JWT
   - [:page_facing_up: JWT](#cors-cross-origin-resource-sharing-1)
   - [:page_facing_up: 왜 CORS가 필요할까?](#왜-cors가-필요할까)
   - [:page_facing_up: CORS 3가지 동작 방식](#cors-3가지-작동-방식)
   - [:page_facing_up: CORS 해결 방법](#cors-해결-방법)


## JWT <sub>JSON Web Token</sub>

> JSON 객체에 인증에 필요한 정보들을 담은 후 비밀키로 서명한 토큰

- 인터넷 표준 인증 방식
- 인증(Authentication), 인가(Authorization) 방식으로 사용

### 왜 JWT를 사용할까?

- HTTP는 기본적으로 stateless한 특성을 가짐.
    - 장점 : 서버의 확장성이 높으며 대량의 트래픽이 발생해도 대처할 수 있음.
    - 단점
        - stateful 방식보다 비교적 많은 양의 데이터가 반복적으로 전송되므로 네트워크 성능 저하가 될 수 있음.
        - 데이터 노출로 인한 보안적인 문제
- 위에서 말한 단점을 보완하기 위해 JWT로 데이터 압축 및 암호화를 위하여 JWT를 사용

### JWT의 구성
- 세 부분으로 구성되며 `XXXXX.YYYYY.ZZZZZ` 와 같이 표현됨.

1. Header <sub>헤더</sub>

    토큰 타입, 암호화 알고리즘 명시

2. Payload <sub>페이로드</sub>

    토큰에 담으 claim(클레임) 정보를 포함
    `claim` : 페이로드에 담는 정보의 한 조각, 'name/value'의 한 쌍으로 이루어져 있음.
    토큰에는 여러 개의 클레임을 넣을 수 있음.

3. Signature <sub>서명</sub>

    헤더에서 선언한 알고리즘과 secret key를 이용해 암호화한 값
    Header와 Payload는 단순히 Base64url로 인코딩되어 있어 누구나 쉽게 복호화할 수 있지만, Signature는 key가 없으면 복호화할 수 없음.


### 장점

- 로컬에 저장하기 때문에 서버 용량에 영향을 끼치거나 받지 않음.
- 보다 안전 (공개키/개인키 or 비밀키를 통해 서명되기 때문에)
- 모바일 앱에서 사용하기 적합
    - 모바일 앱은 여러 플랫폼 및 기기에서 동작할 수 있고, 서로 다른 도메인에서 통신할 수도 있음.
    - 이때 JWT를 사용하면 플랫폼 독립적으로 사용자 인증을 처리할 수 있기 때문에 적합
- 네트워크 부하가 적음.
    - HTTP 헤더나 URL 파라미터를 통해 간단하게 전송되기 때문


### 단점

- 토큰의 크기가 커질수록 트래픽에 영향을 미칠 수 있음.
- 토큰은 발급되면 만료 기간 변경이 불가능하므로 토큰 만료 처리를 구현해야 함.
    - Redis의 TTL(지정된 시간이 지나면 키가 자동으로 삭제되는 기능)을 활용하면 좀 더 구현이 간단해짐.
- 토큰이 탈취되었을 때 JWT Debuger를 통해 쉽게 복호화가 되기 때문에 서버에서 사용자를 식별할 수 있으면서 그나마 가장 덜 민감한 정보를 담아야 함.

### 토큰 기반 인증 과정

- stateless하게 처리하는 방법
- 몇 만명의 인증 방식을 저장하고 있지 않기 때문에 가볍고 확장성이 좋은 방식

1. 클라이언트가 회원가입 요청
2. 서버는 DB에 회원 생성
3. 클라이언트가 ID/PW를 입력하여 로그인
4. 서버는 ID/PW가 맞는지 확인
5. 해당 회원이 존재한다면 access/refresh token 발급하여 반환
6. header에 access token을 담아 API 호출
7. 서버에서 토큰 검증 후 문제가 없다면 요청 처리 후 응답


### 세션 기반 인증 과정

- stateful하게 처리하는 방법
- 무겁지만 그만큼 보안성이 좋은 방식

1. 클라이언트가 회원가입 요청
2. 서버는 DB에 회원 생성
3. 서버가 회원 정보로 세션 ID 발급하고 세션 저장소에 저장
4. 서버는 발급된 세션 ID를 쿠키에 담아서 반환
5. 클라이언트는 세션 ID를 통해 API 호출
6. 서버는 세션 저장소에서 세션 ID를 검증 후 문제가 없다며 요청 처리 후 응답

### 토큰, 세션 기반 인증 비교

- 토큰 방식 : 토큰이 보안, 사용자 데이터 관리
- 세션 방식 : 서버에서 보안, 사용자 데이터 관리
- 보안성, 성능같은 면에서는 세션이 더 좋은 방식이지만, 비용면에서 JWT를 많이 사용하고 있는 추세

| | 토큰 | 세션|
|---|---|---|
|보안성 | |WIN|
|외부 노출 시 | | WIN|
|성능 | |WIN|
|비용 | WIN| |
|서버 부하(효율성) | WIN | |
|확장성 | WIN | |

</br>


---

- 참고

    [우리는 왜 JWT를 사용하는가? / JWT 사용 이유](https://puleugo.tistory.com/138)

    [Introduction to JSON Web Tokens](https://jwt.io/introduction)

    [토큰 기반 인증이란? 인증 토큰의 종류와 JWT의 이점](https://www.okta.com/kr/identity-101/what-is-token-based-authentication/)
    
    [[면접 대비] 서버 기반 인증 - 세션, 토큰](https://velog.io/@syleemk/%EB%A9%B4%EC%A0%91-%EB%8C%80%EB%B9%84-%EC%84%9C%EB%B2%84-%EA%B8%B0%EB%B0%98-%EC%9D%B8%EC%A6%9D-%EC%84%B8%EC%85%98-%ED%86%A0%ED%81%B0)