# :books: Interview - JSON Web Token <sub>JWT토큰</sub>

## :bookmark_tabs: 목차

[:arrow_up: **Network**](../README.md)

1. ### [Question](#) <sub>면접 질문</sub>

   - JWT에 대해서 설명할 수 있나요?
   - jwt와 세션 중 왜 jwt를 사용하셨나요?
   - 세션이 왜 jwt에 비해 서버의 자원을 사용하는 횟수가 많나요?
   - 그렇다면 jwt는 서버 자원을 전혀 쓰지 않는다는 건가요?
   - 그렇다면 session보다 jwt가 훨씬 좋은 건가요?
   - JWT의 보안 취약점과 관련해서 해결 방안이 있을까요?
   - 다중 서버가 되었을 때 jwt가 왜 세션에 비해 문제 없이 사용할 수 있나요?
   - jwt는 클라이언트 측에서 어디에 저장이 되나요?

# :closed_book: Question <sub>면접 질문</sub>

### JWT에 대해서 설명할 수 있나요?

[**정리한 내용 참고**](../Note/JWT.md)

### jwt와 세션 중 왜 jwt를 사용하셨나요?

- 서버의 자원을 사용하는 횟수가 세션에 비해 현저히 적고, 트래픽이 많아져 다중 서버로 늘렸을 때 문제 없이 사용할 수 있게 하기 위함

### 세션이 왜 jwt에 비해 서버의 자원을 사용하는 횟수가 많나요?

- 세션은 사용자의 데이터가 담긴 데이터는 서버 측에서 관리를 하기에 인증이나 인가를 하는 과정에서 서버 자원에 접근함
- jwt는 사용자의 정보가 토큰의 payload에 저장되어 있기 때문에 서버 자원에 접근하지 않더라도 인증이나 인가가 가능함

### 그렇다면 jwt는 서버 자원을 전혀 쓰지 않는다는 건가요?

- jwt는 보통 access token과 refresh token으로 이중으로 나누어 사용
- refresh token은 비교적으로 수명이 짧은 access token을 재발급 시켜주기 위해 존재하는데, 이때 서버가 관여함
  - 로그아웃을 해서 해당 refresh token을 무효화 시키기 위해 혹은 access token이 만료가 되어서 갱신을 하기 위해 서버 자원을 사용
  - 매 인증/인가 요청마다 서버 자원을 사용하는 session보다는 서버 사용량이 적음

### 그렇다면 session보다 jwt가 훨씬 좋은 건가요?

- 토큰을 클라이언트가 가지고 있어서 탈취를 당하게 되었을 경우 access token을 무효화 시킬 수 있는 방법이 따로 없기에 보안 취약점이 우려됨

### JWT의 보안 취약점과 관련해서 해결 방안이 있을까요?

- HTTPS를 사용하여 통신을 암호화
- access token의 만료 시간을 짧게 설정
- 만료된 토큰을 서버에 저장하여 검증

### 다중 서버가 되었을 때 jwt가 왜 세션에 비해 문제 없이 사용할 수 있나요?

- 클라이언트 측에서 토큰을 가지고 있기에 인증/인가를 클라이언트 사이드로 진행
- 세션은 서버 측에서 세션 데이터를 관리하기 때문에 각 서버간의 세션 데이터를 동기화 하기 위한 별도의 처리가 요구됨

### jwt는 클라이언트 측에서 어디에 저장이 되나요?

- 웹에서는 브라우저의 로컬 스토리지나 세션 스토리지, 쿠키 등에 저장
- 모바일에서는 디바이스의 로컬 스토리지나 앱 내 데이터베이스 등에 저장