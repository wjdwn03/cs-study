# :books: Interview - HTTP & HTTPS

## :bookmark_tabs: 목차

[:arrow_up: **Network**](../README.md)

1. ### [Question](#) <sub>면접 질문</sub>

   - HTTP 프로토콜이 뭔가요?
   - HTTP와 HTTPS의 차이점은 무엇인가요?

# :closed_book: Question <sub>면접 질문</sub>

### HTTP 프로토콜이 뭔가요?

- 데이터를 주고 받기 위한 프로토콜이며, 서버/클라이언트 모델을 따릅니다.
- HTTP는 상태 정보를 저장하지 않는 Stateless + 요청에 맞는 응답을 보낸 후 연결을 끊는 Connectionless

- 장점
   - 통신간의 연결 상태 처리나 상태 정보를 관리할 필요가 없어서 서버 디자인이 간단하다.
   - 각각의 HTTP 요청에 독립적으로 응답을 보내주면 된다.
- 단점
   - 이전 통신의 정보를 모르기에, 매번 인증이 필요하다.
   - 이를 해결하기 위해서 쿠키나 세션을 사용해서 데이터를 처리한다.

### HTTP와 HTTPS의 차이점은 무엇인가요?

- HTTP의 경우, 평문 데이터를 전송하는 프로토콜이기에 정보를 주고 받을 경우 제 3자에 의해 조회될 수 있다.
- 이러한 문제를 해결하기 위해서 HTTP에 암호화가 추가된 프로토콜이 HTTPS이다.
HTTPS는 SSL을 추가한 HTTP라고 할 수 있다.

   Secure Socket Layer : 인터넷을 통해 전달되는 정보를 보호하기 위해 개발된 통신 규약

- HTTP는 원래 TCP와 직접 통신했지만, HTTPS에서의 HTTP는 SSL과 통신하고 SSL이 TCP와 통신함으로써 암호화와 증명서, 안정성 보호를 이용할 수 있게 된다.