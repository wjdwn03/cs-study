# :books: Interview - TLS/SSL handshake <sub>TLS/SSL 핸드셰이크</sub>

## :bookmark_tabs: 목차

[:arrow_up: **Network**](../README.md)

1. ### [Question](#) <sub>면접 질문</sub>
   
   - SSL이 뭔가요?
   - SSL Handshake의 과정을 설명해 보세요.
   - HTTPS와 SSL은 같은 것일까? SSL하고 TLS는 어떤 점에서 다른가?
   - SSL 암호화 통신의 단계를 설명해주세요.
   - SSL handshake 단계에 대해 설명해주세요.

# :closed_book: Question <sub>면접 질문</sub>

### SSL이 뭔가요?


   SSL 암호화 통신은 'SSL(Secure Socket Layer)' 또는 'TLS(Transport Layer Security)' 라는 보안 프로토콜을 통해서 클라이언트(브라우저)와 서버(웹서버)가 보안이 향상된 통신을 하는 과정

### SSL Handshake의 과정을 설명해 보세요.

   서버는 CA에 사이트 정보와 공개 키를 전달하여 인증서를 받음 → 클라이언트는 브라우저에 CA 공개 키가 내장되어 있다고 가정 → ClientHello(암호화 알고리즘 나열 및 전달) → Serverhello(암호화 알고리즘 선택) → Server Certificate(인증서 전달) → Client Key Exchange(데이터를 암호화 할 대칭 키 전달) → Client / ServerHello done (정보 전달 완료) → Finished(SSL Handshake 종료)


### HTTPS와 SSL은 같은 것일까? SSL하고 TLS는 어떤 점에서 다른가?

- HTTPS와 SSL은 다릅니다.
- SSL과 TLS는 '보안 계층' 이라는 독립적인 프로토콜 계층을 만들어서, ( 응용 계층과 전송 계층 ) 의 사이에 속하게 됩니다.
HTTPS는 SSL또는 TLS 위에 HTTP 프로토콜을 얹어서 보안된 HTTP 통신을 하는 프로토콜입니다.
- 즉, SSL과 TLS는 HTTP뿐만이 아니라 FTP, SMTP와 같이 다른 프로토콜에도 적용할 수 있습니다.
HTTPS는 TLS와 HTTP가 조합된 프로토콜을 가리킵니다. ( SSL과 TLS는 같은 의미의 단어이다. )
TLS가 SSL의 후속 버전이지만, SSL이 일반적으로 더 많이 사용되는 용어


### SSL 암호화 통신의 단계를 설명해주세요.

1. 먼저 데이터를 주고받기 위해서 어떤 방법으로 사용해야 하는지 서로의 상태를 파악.
   - SSL은 80번 포트를 사용하는 http와 달리, 443번 포트를 기본으로 사용하는 TCP 기반의 프로토콜이다.
1. TCP 기반이기에, SSL 핸드셰이크 전에 TCP 3-way 핸드셰이크 또한 수행합니다.
1. 협상 완료되면, SSL 세션 생성 => 클라이언트와 서버는 원하는 데이터를 주고받음.
1. 최종적으로 데이터 전송의 끝을 알리며 세션이 종료된다.

###  SSL handshake 단계에 대해 설명해주세요.

1. Client hello

   - 클라이언트가 서버에게 연락을 한다.
   - 브라우저 검색창에 도메인을 입력하는 과정
   - 이 때, 클라이언트는 자신의 브라우저가 지원할 수 있는 - 암호화 방식(Cipher Suite)을 먼저 제시
   - 그리고 랜덤 데이터 생성하여 추가 전송

1. Server hello

   - 서버가 클라이언트에게 연락
   - (서버는) 클라이언트가 제시한 암호화 방식 중 하나를 선정해서 알려줌
   - 서버 자신의 인증서 전달
   - 인증서에는 서버의 공개키가 포함되어있다.
   - 클라이언트와 마찬가지고 서버 측 랜덤데이터 또한 전달

1. Client key exchange

   - 클라이언트는 미리 주고받은 자신과 서버의 랜덤 데이터를 참고하여, 서버와 암호화 통신을 할 때 사용할 키를 생성해서 서버에 전달.
   - 이 때, 키는 서버로부터 받은 공개키로 암호화되어 보내짐.

1. Finished

   - 핸드셰이크 과정이 마무리되면, 클라이언트와 서버가 "finished" 메세지를 보내고, 그 후 클라이언트가 생성한 키를 이용하여 암호화된 데이터를 주고받게 된다.

- 요약

   SSL 암호화 통신은, 비대칭키 방식으로 암호화에 사용할 키를 교환하고 대칭키 방식으로 데이터 통신을 한다는 점이 장점
   SSL 암호화 통신 외에도 Diffie-Hellman 키 교환 방식, TLS1.3, SSL인증서, SSL 복호화 등 다양한게 있다.