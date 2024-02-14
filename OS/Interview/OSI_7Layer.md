# :books: Interview - OSI 7Layer <sub>OSI 7계층</sub>

## :bookmark_tabs: 목차

[:arrow_up: **Network**](../README.md)

1. ### [Question](#) <sub>면접 질문</sub>

   - OSI 7계층을 활용하여 Application Layout에서 받아온 사용자의 Data가 어떻게 다른 컴퓨터로 전송되는지 설명해주세요.
   - 네트워크 계층과 전송 계층의 차이점에 대해 설명해주세요
   - 방화벽은 몇 계층에서 작동할까요
   - 각 계층의 예시 프로토콜을 1개 이상씩 말하세요

# :closed_book: Question <sub>면접 질문</sub>

### OSI 7계층을 활용하여 Application Layout에서 받아온 사용자의 Data가 어떻게 다른 컴퓨터로 전송되는지 설명해주세요.

1. 응용 계층에서 데이터가 생성되고,
2. 표현 계층에서 형식을 변환하고 보안을 적용할 수 있습니다.
3. 세션 계층에서 통신 세션을 설정하며,
4. 전송 계층에서 데이터를 세그먼트로 분할하고 목적지와 연결을 설정합니다.
5. 네트워크 계층에서 경로를 결정하고,
6. 데이터링크 계층에서 프레임으로 나누어 목적지 MAC 주소를 사용하여 다음 네트워크 장치로 전송됩니다.
7. 물리 계층에서 데이터는 물리적인 신호로 변환되어 실제 전송 매체를 통해 목적지 컴퓨터로 전송됩니다.
이 과정을 통해 데이터가 다른 컴퓨터로 안전하게 전달됩니다.

### 네트워크 계층과 전송 계층의 차이점에 대해 설명해주세요

- 네트워크 계층은 데이터의 경로 결정 및 라우팅을 수행하고, 주로 논리적인 주소(IP 주소)를 사용하여 호스트를 식별합니다.
- 반면, 전송 계층은 데이터의 신뢰성과 흐름 제어를 담당하며, 연결 설정 및 해제 등의 역할을 수행합니다.

### 방화벽은 몇 계층에서 작동할까요

네트워크 또는 전송 계층

### 각 계층의 예시 프로토콜을 1개 이상씩 말하세요.

- 물리 계층: 프로토콜 없음 (하드웨어와 관련됨)

- 데이터 링크 계층
   - Ethernet: 로컬 네트워크
   - HDLC (High-Level Data Link Control): 데이터 링크 계층
   - PPP (Point-to-Point Protocol): 직렬 통신
- 네트워크 계층
   - IP (Internet Protocol): 패킷 라우팅
   - ICMP (Internet Control Message Protocol): 네트워크 오류 및 메시지 전송
   - OSPF (Open Shortest Path First): 라우팅을 위한 내부 게이트웨이
   - BGP (Border Gateway Protocol): 인터넷 라우팅
- 전송 계층
   - TCP (Transmission Control Protocol): 연결 지향적인 신뢰성 있는 데이터 전송
   - UDP (User Datagram Protocol): 연결 없는 데이터 전송
- 세션 계층
   - NetBIOS: 네트워크 세션을 설정하고 관리
   - RPC (Remote Procedure Call): 원격 프로시저 호출
- 표현 계층
   - SSL/TLS (Secure Sockets Layer/Transport Layer Security): 보안 및 암호화
   - JPEG, GIF: 이미지 압축 및 표현
- 응용 계층
   - HTTP (Hypertext Transfer Protocol): 웹 페이지 및 데이터 전송
   - FTP (File Transfer Protocol): 파일 전송
   - SMTP (Simple Mail Transfer Protocol): 이메일 전송
   - DNS (Domain Name System): 도메인 이름 해석
   - SNMP (Simple Network Management Protocol): 네트워크 관리


---

- 참고

   [네트워크 면접 예상 질문/답변](https://velog.io/@seungjun2/%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC-%EC%A7%88%EB%AC%B8%EB%8B%B5%EB%B3%80-%EB%AF%B8%EC%99%84%EC%84%B1#-osi-7%EA%B3%84%EC%B8%B5--tcp-ip-4%EA%B3%84%EC%B8%B5)
