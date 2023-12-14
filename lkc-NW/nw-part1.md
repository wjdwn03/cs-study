## NetWork Study 파트1 진행 목차
1. OSI 7 계층
2. TCP와 UDP
3. TCP 3 way handshake & 4 way handshake
4. TCP/IP 흐름제어 & 혼잡제어
5. Network Socket

## 1.OSI 7 계층
- osi 7 계층이란? : 네트워크에서 통신이 일어나는 과정을 7단계로 나눈것을 뜻한다.
- 1984년 iso에서 개발한 모델. 네트워크 프로토콜 디자인과 통신과정을 7개의 계층으로 구분해 만든 표준 규격이다.
- 초창기의 네트워크는 컴퓨터마다 시스템이 달랐기 때문에 이를 정하는 표준이 필요했음.
- 물리: hw, 데이터링크: hw+sw, 이하 sw로 구성 
- 오늘날의 인터넷은 tcp/ip모델임.
- 쉽게 트러블을 관리할 수 있음(계층적이기 때문에)
  <img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbLQTci%2FbtrD1hqx5eS%2FvkE7pdovczvoQpzNqwnrbk%2Fimg.png">
- 위의 그림처럼 총 7개의 계층적 구조를 가지며 각기 계층마다 담당하는 역할이 존재함.

- 데이터란 추상적 개념으로 일컫을 수 있는 모든 개체 정도 되겠다.
- 이러한 데이터를 전달하기 위해서 0과1로 분해하여서 전달하는 과정을 네트워크에서 진행한다.
- 따라서 우리는 이러한 데이터를 전송하기위해 사전에 송신자와 수신자간에 약속을 해놓는다(이를 프로토콜이라고 정의)
- 데이터를 전송하는 측에서는 안전하고 정확하고 신속히 규격내로 포장하는 방법, 수신측에서는 정확하고 신속하고 안전히 해석하는 방법을 기술적으로 약속하는 것을 프로토콜이라고 정의한다.
- 계층구조의 이용은 분할정복의 이점을 얻을 수 있기 때문.

- PDU란? : 각 계층에서 전송되는 단위 1계층은 그냥 전기흐름이고 2는 프레임 3은 패킷 4는 세그먼트이다.<br>
왜 각각의 pdu가 다른지 역할에대해 알아야함.<br>

1. 물리계층(physical layer) <1계층>
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FqeXJk%2FbtrD19TmojQ%2FFAK8VVKwhgBSlauKkYofk1%2Fimg.png">

- 최하위 계층
- 물리적 전송매체를 통해 상위계층인 데이터링크로부터 전달된 비트스트림을 상대측 물리계층으로 전달하는 역할
- 오류에대한 고려를 하지않고 전송하기만 한다.
- 전송단위: 비트(1,0)
- 장비 : 허브 , 통신케이블
- 프로토콜: 모뎀, 케이블, RS-232C, Fiber
- 데이터를 전기적 신호로 변환해서 주고받기만 한다.

2. 데이터 링크 계층(DataLink layer) <2계층>
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcedrlS%2FbtrD1tXvqHh%2FhOkxUgU1Qhr0RDNC6VlVx1%2Fimg.png">

- 네트워크 기기들 사이의 데이터 전송을 하는 역할.
- 시스템간의 오류없는 데이터 전송을 위해 패킷을 프레임으로 구성해 물리계층으로 전송.
- 3계층에서 정보를 받아 주소와 제어정보를 헤더와 테일에 추가.
- 물리적인 네트워크 사이에 데이터전송을 담당.
- point to point간 신뢰성 있는 전송을 보장하기 위한 계층.
- MAC 주소를 가지고 통신한다.(컴퓨터간 데이터를 전송하기 위한 컴퓨터의 물리적 주소)
- 전송단위 : 프레임
- 장비 : 브릿지, 스위치
- 프로토콜 : 이더넷 MAC PPP ATM LAN Wifi
- mac은 중간에 이동하는 경로의 노드들에 대한 주소이고 ip는 시작점과 끝점의 주소 정도로 생각하면 될 듯.



3. 네트워크 계층 (Network layer) <3계층>
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FNR9Ge%2FbtrD8MPHiQ0%2FkqBNBNRmKWf6Kwdil4mi71%2Fimg.png">

- 3계층은 기기에서 데이터그램이 가는 경로를 설정한다.
- 라우팅 알고리즘을 통해 최적의 경로를 선택해 송신측->수신측으로 전송한다.
- 이때 전송되는 데이터는 패킷단위로 분할해 전송한 후 다시 합쳐진다.(2계층이 노드-노드 전달을 감독한다면 3계층은 각 패킷이 목적지까지 성공적으로 전달되도록 한다.)
- 목적지 네트워크 주소를 정하고 경로를 선택하고 경로에 따라 패킷을 전달해주는 역할
- 전송단위:패킷
- 장비:라우터 , L3스위치
- 프로토콜: ICMP, IP
- 다양한 길이의 데이터를 네트워크 통해 전달하고 그 과정에서 4계층이 요구하는 서비스품질을 제공하기 위한 기능적 절차적 수단 제공.

4. 전송계층 (transport layer) <4계층>
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FoQpWd%2FbtrD5R5gZOF%2FUnuAxRirD1tiZcqEKuSUj1%2Fimg.png">

- 발신지에서 목적지간의 제어와 에러 관리.
- 패킷의 전송 유효 확인하고 전송실패된 패킷을 다시 보내는 신뢰성 있는 통신을 보장하며 헤드에는 세그먼트가 포함된다.
- 주소설정, 오류 흐름제어, 다중화 수행
- 헤더에 포트번호 포함
- 단위:세그먼트
- 장비:게이트웨이, l4스위치
- 프로토콜:udp tcp arp rtp
- tcp: 신뢰적 전송 보장(패킷손실 중복 순서바뀜 없는거 보장됨) - ack사용(응답)
- ip가 처리할 수 있도록 데이터를 여러개의 패킷으로 나누고 도착지에서 완전한데이터로 패킷 재조립
- 세그먼트 단위
- udp: 비연결성 비신뢰성 서비스
- 패킷 나누고 조립과정 없이 , 수신자가 받았다는 응답을 보지 않고 전송만 한다.
- 속도 빠름->실시간
- 데이터 전송단위: 블록형태의 다이어그램.
5. 세션 계층 <5계층>
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fdz1Eix%2FbtrD9F3TOJl%2FSVMQIgJmLDK3J7yUpeSiFK%2Fimg.png">

- 통신세션을 구성하는 계층. 포트번호를 기반으로 연결
- 통신장치간의 상호작용을 설정하고 유지하며 동기화한다. 동시 송수신, 반이중 전이중방식의 통신과함께 체크포인팅과 다시시작과정 수행
- 세션: 클라이언트와 웹서버간 네트워크 연결이 지속유지되는 상태
- 네트워크상의 양쪽 연결을 관리하고 연결을 지속시켜주는 계층
- 세션 생성 유지 종류 전송중단시 복구 수행
- tcp/ip 세션 만들고 없애는 역할
- 프로토콜 : tls, ssh, netbios
6. 표현계층(presentation layer) <6계층>
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fn2Uho%2FbtrD2IH47et%2FQpbPHsQRxlhXdQTkKNdDRK%2Fimg.png">

- 송수신측 사이의 데이터 형식을 지정한다. 받은 데이터를 코드변환 구문검색 인디코딩과 암호화 압축의 과정을 통해 올바른 표준 방식으로 변환한다 예시로는 JPG,MPEG,SMB,AFP프로토콜 존재.

7. 응용계층(application layer) <7계층>
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FeTEj5v%2FbtrD6xFx2fb%2FgJtnwbky9prdKQG2ZHOJDK%2Fimg.png">

- 사용자와 바로 연결되어 있고 응용 sw를 돕는 계층 .
- 사용자로부터 정보를 입력받고 하위계층으로 전달하고 전송받은 데이터를 사용자에게 전달.
- 응용서비스를 네트워크에 연결해주는 역할
- HTTP, DNS, Telnet, FTP의 프로토콜 존재.
8. 정리
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcrYJdq%2FbtrD6yRXRGA%2F5I06bKoUqZeJXqABcwIHkk%2Fimg.jpg">

- 최종적으로 발신측의 7계층에서 캡슐화를 진행하여 각계층마다 헤더를 붙임.
- 수신측은 반캡슐화 진행하며 데이터 전달받음.
  <img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F223C7F4C5715100726">

---

## 2.tcp and udp

<div align="center">
  <br />
  <h1>TCP와 UDP</h1>
  <br />
</div>

## 목차

1. [**TCP**](#1)
2. [**TCP의 특징**](#2)
3. [**UDP**](#3)
4. [**UDP의 특징**](#4)
5. [**TCP vs UDP**](#5)
6. [**HTTP3와 UDP**](#6)

<br />

<img src="https://user-images.githubusercontent.com/56222478/146769576-440a35a4-c30b-4c93-84b9-6111cf49b975.png" style="width:500px;height:250px" />

> TCP와 UDP는 TCP/IP의 전송계층에서 사용되는 프로토콜이다. 전송계층은 패킷의 오류를 검사하고 재전송 요구 등의 제어를 담당하는 계층이다.

++ [https://www.youtube.com/watch?v=1pfTxp25MA8](https://www.youtube.com/watch?v=1pfTxp25MA8)

---

<br />

<div id="1"></div>

## TCP (Transmission Control Protocol, 전송제어 프로토콜)

대부분의 인터넷 응용 분야들은 신뢰성과 순차적인 전달을 필요로 한다.

TCP는 신뢰성이 없는 인터넷을 통해 종단간에 신뢰성 있는 바이트 스트림을 전송 하도록 특별히 설계되었다.

TCP 서비스는 송신자와 수신자 모두가 소켓이라고 부르는 종단점을 생성함으로써 이루어진다.

모든 TCP 연결은 전이중, 점대점 방식이다.

전이중이란 전송이 양방향으로 동시에 일어날 수 있음을 의미하며 점대점이란 각 연결이 정확히 2 개의 종단점을 가지고 있음을 의미한다.

1:1 통신만 가능하다.

<br />

<div id="2"></div>

## TCP의 특징

- 신뢰성 있는 데이터 전송을 지원하는 연결 지향형 프로토콜이다.
- 사전에 3-way handshake라는 과정을 통해 연결을 설정하고 통신을 시작한다.
- 4-way handshake 과정을 통해 연결을 해제한다.
- 흐름 제어, 혼잡 제어, 오류 제어를 통해 신뢰성을 보장한다. 그러나 이 때문에 UDP보다 전송 속도가 느리다는 단점이 있다.
- 데이터의 경계를 구분하지 않는다. (바이트 스트림 서비스)
- 데이터의 전송 순서를 보장하며 수신 여부를 확인할 수 있다.
- TCP를 사용하는 예로는 대부분의 웹 HTTP 통신, 이메일, 파일 전송에 사용된다.

- 흐름제어, 혼잡제어, 오류제어
    
    **흐름 제어**
    
    - 송신측과 수신측의 데이터 처리 속도 차이를 해결하기 위한 기법
    - receiver가 packet을 지나치게 많이 받지 않도록 조절하는 것
    - receiver가 sender에게 현재 자신의 상태를 feedback 한다
    
    **혼잡 제어**
    
    - 송신측의 데이터 전달과 네트워크의 데이터 처리 속도 차이를 해결하기 위한 기법
    - 흐름제어가 송신측과 수신측 사이의 전송속도를 다루는데 반해, 혼잡제어는 호스트와 라우터를 포함한 보다 넓은 관점에서 전송 문제를 다루게 된다.
    
    **오류 제어**
    
    - 훼손된 패킷을 감지 하고 중복 수신 된 패킷을 확인 후 폐기하며, 손실된 패킷은 재전송하고 순서에 맞지 않는 세그먼트를 버퍼에 저장하는 일을 한다.
    
    [https://rok93.tistory.com/entry/네트워크-TCP-흐름제어혼잡제어](https://rok93.tistory.com/entry/%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC-TCP-%ED%9D%90%EB%A6%84%EC%A0%9C%EC%96%B4%ED%98%BC%EC%9E%A1%EC%A0%9C%EC%96%B4)
    

---

<br />

<div id="3"></div>

## UDP (User Datagram Protocol, 사용자 데이터그램 프로토콜)

UDP는 비연결형 프로토콜 이다.

IP 데이터그램을 캡슐화하여 보내는 방법과 연결 설정을 하지 않고 보내는 방법을 제공한다.

데이터 그램 : 독립적인 관계를 지니는 패킷

UDP는 흐름제어, 오류제어 또는 손상된 세그먼트의 수신에 대한 재전송을 하지 않는다.

이 모두가 사용자 프로세스의 몫이다.

종종 클라이언트는 서버로 짧은 요청을 보내고, 짧은 응답을 기대한다.

만약 요청 또는 응답이 손실된다면, 클라이언트는 time out 되고 다시 시도할 수 있으면 된다.

코드가 간단할 뿐만 아니라 TCP의 초기설정에서 요구되는 프로토콜보다 적은 메시지가 요구된다.

<br />

<div id="4"></div>

## UDP의 특징

- 데이터를 데이터 그램 단위로 처리하는 프로토콜.
- 비연결형 프로토콜로 사전에 연결 설정 없이 데이터를 전달한다.
- 사전에 연결 설정을 하지 않은 데이터 그램 방식을 통해 데이터를 전달하기 때문에 하나의 메시지에서 분할된 각각의 패킷은 서로 다른 경로로 전송될 수 있다.
- 송신측에서 전송한 패킷의 순서와 수신측에 도착한 패킷의 순서가 다를 수 있다. 그러나 서로 다른 경로로 패킷을 처리함에도 불구하고 순서를 부여하거나 재조립하지 않는다.
- 흐름 제어, 혼잡 제어, 오류 제어를 하지 않으므로 손상된 세그먼트에 대한 재전송을 하지 않는다.
- 이로 인해 속도가 빠르며 네트워크 부하가 적다는 장점이 있지만, 신뢰성 있는 데이터 전송을 보장하지 못한다.
- UDP는 DNS(누군가 DNS 서비스를 요청할 때마다 TCP처럼 Session을 맺고 통신한다면 속도도 느리고, 서버 리소스도 엄청나게 소모될 것이다.) 등에서 사용된다

<br />

<div id="5"></div>

## TCP vs UDP

먼저, TCP의 데이터 송신 과정을 살펴보자.

<img src="https://madplay.github.io/img/post/2018-02-04-network-tcp-udp-tcpip-2.png" style="width:400px;height:400px" />

반면, UDP는 일방적이다.

<img src="https://madplay.github.io/img/post/2018-02-04-network-tcp-udp-tcpip-3.png" style="width:400px;height:400px" />

즉, **신뢰성이 요구되는 애플리케이션에서는 TCP를 사용**하고 **간단한 데이터를 빠른 속도로 전송하고자 하는 애플리케이션에서는 UDP를 사용**한다.

<!-- ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/dc2a516c-d25c-4d43-86db-af9653d527e0/Untitled.png) -->
<img src="https://user-images.githubusercontent.com/56222478/146770426-a7ae7b3c-9396-4144-9524-4f6988321e5c.png" style="width:550px;height:300px" />

<br />

<div id="6"></div>

## HTTP3 와 UDP

<img src="https://user-images.githubusercontent.com/56222478/146770632-af4c8938-2238-404b-a648-f9e6dabe8590.png" style="width:550px;height:350px" />

[https://evan-moon.github.io/2019/10/08/what-is-http3/](https://evan-moon.github.io/2019/10/08/what-is-http3/)

<img src="https://velog.velcdn.com/images%2Faverycode%2Fpost%2F7ced087c-a2f1-4a0a-a00e-c1c65391e30c%2Fimage.png">

---
## 3handshake and 4handshake
https://velog.io/@averycode/%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC-TCPUDP%EC%99%80-3-Way-Handshake4-Way-Handshake 참조해서 쓸예정

3-Way Handshake 는 TCP의 접속,4-Way Handshake는 TCP의 접속 해제 과정이다.

- 포트(PORT) 상태 정보
- CLOSED: 포트가 닫힌 상태
- LISTEN: 포트가 열린 상태로 연결 요청 대기 중
- SYN_RCV: SYNC 요청을 받고 상대방의 응답을 기다리는 중
- ESTABLISHED: 포트 연결 상태
- 플래그 정보
- TCP Header에는 CONTROL BIT(플래그 비트, 6bit)가 존재하며, 각각의 bit는 "URG-ACK-PSH-RST-SYN-FIN"의 의미를 가진다.
- 즉, 해당 위치의 bit가 1이면 해당 패킷이 어떠한 내용을 담고 있는 패킷인지를 나타낸다.
- SYN(Synchronize Sequence Number) / 000010
<br> 연결 설정. Sequence Number를 랜덤으로 설정하여 세션을 연결하는 데 사용하며, 초기에 Sequence Number를 전송한다.
- ACK(Acknowledgement) / 010000
<br> 응답 확인. 패킷을 받았다는 것을 의미한다.
- Acknowledgement Number 필드가 유효한지를 나타낸다.
<br> 양단 프로세스가 쉬지 않고 데이터를 전송한다고 가정하면 최초 연결 설정 과정에서 전송되는 첫 번째 세그먼트를 제외한 모든 세그먼트의 ACK 비트는 1로 지정된다고 생각할 수 있다.
- FIN(Finish) / 000001
<br> 연결 해제. 세션 연결을 종료시킬 때 사용되며, 더 이상 전송할 데이터가 없음을 의미한다.

🐥 TCP의 3-Way Handshake
### 개념
- TCP 통신을 이용하여 데이터를 전송하기 위해 네트워크 연결을 설정(Connection Establish) 하는 과정
- 양쪽 모두 데이터를 전송할 준비가 되었다는 것을 보장하고, 실제로 데이터 전달이 시작하기 전에 한 쪽이 다른 쪽이 준비되었다는 것을 알 수 있도록 한다.
- 즉, TCP/IP 프로토콜을 이용해서 통신을 하는 응용 프로그램이 데이터를 전송하기 전에 먼저 정확한 전송을 보장하기 위해 상대방 컴퓨터와 사전에 세션을 수립하는 과정을 의미한다.
- 3-way handshake의 기본매커니즘
<br> TCP 통신은 PAR (Positive Acknowledgement with Re-transmission) 을 통해 신뢰적인 통신을 제공한다.

<img src="https://velog.velcdn.com/images%2Faverycode%2Fpost%2Fcd53e336-a624-4f8a-b7e5-20fe62eb6648%2Fimage.png">

- PAR을 사용하는 기기는 ack을 받을 때까지 데이터 유닛을 재전송한다!

- 수신자가 데이터 유닛(세그먼트)이 손상된것을 확인하면(Error Detection에 사용되는 transport layer의 checksum을 활용), 해당 세그먼트를 없앤다. 그러면 sender는 positive ack이 오지 않은 데이터 유닛을 다시 보내야한다.
<br>
⇒ 이 과정에서 클라이언트와 서버 사이에서 3개의 Segment가 교환되는 것을 확인할 수 있다. 이것이 바로 3-way handshake의 기본 매커니즘이다.

### 작동 방식
- Client는 Server와 연결하기 위해 3-way handshake를 통해 연결 요청을 하게 됩니다.
- 우리가 일반적으로 생각하는 Client와 Server는 모두 서로 연결 요청을 먼저 할 수 있기 때문에, 연결 요청을 먼저 시도한 요청자를 Client(아래 그림에서 HOST P) 로, 연결 요청을 받은 수신자를 Server(아래 그림에서 HOST Q)쪽으로 생각하고 보시면 될 것 같습니다.
- SYN(Synchronization) : 연결요청, 세션을 설정하는데 사용되며 초기에 시퀀스 번호를 보냄
- ACK(Acknowledgement) : 보낸 시퀀스 번호에 TCP 계층에서의 길이 또는 양을 더한 것과 같은 값을 ACK에 포함하여 전송
- 동기화 요청에 대한 답변 : Client의 Sequence Number+1을 하여 ACK로 돌려줍니다.

<img src="https://velog.velcdn.com/images%2Faverycode%2Fpost%2F22a2bab1-c8dd-4559-88b2-62d03cbff927%2F%E1%84%80%E1%85%B5%E1%84%89%E1%85%AE%E1%86%AF%E1%84%86%E1%85%A7%E1%86%AB%E1%84%8C%E1%85%A5%E1%86%B8-5.jpg">

Step 1 (SYN)

클라이언트는 서버와 커넥션을 연결하기 위해 SYN을 보낸다. (seq : x)

송신자가 최초로 데이터를 전송할 때 Sequence Number를 임의의 랜덤 숫자로 지정하고, SYN 플래그 비트를 1로 설정한 세그먼트를 전송한다.
PORT 상태
Client : CLOSED- SYN_SENT 로 변함
Server : LISTEN
Step 2 (SYN + ACK)

서버가 SYN(x)을 받고, 클라이언트로 받았다는 신호인 ACK와 SYN 패킷을 보냄 (seq : y, ACK : x + 1)

접속요청을 받은 Q가 요청을 수락했으며, 접속 요청 프로세스인 P도 포트를 열어달라는 메세지를 전송 (SYN-ACK signal bits set)
ACK Number필드를 Sequence Number + 1 로 지정하고 SYN과 ACK 플래그 비트를 1로 설정한 새그먼트 전송 (Seq=y, Ack=x+1, SYN, ACK)
PORT 상태
Client : CLOSED
Server : SYN_RCV
Step 3 (ACK)

클라이언트는 서버의 응답은 ACK(x+1)와 SYN(y) 패킷을 받고, ACK(y+1)를 서버로 보냄

마지막으로 접속 요청 프로세스 P가 수락 확인을 보내 연결을 맺음 (ACK)
이때, 전송할 데이터가 있으면 이 단계에서 데이터를 전송할 수 있다.
PORT 상태
Client : ESTABLISED
Server : SYN_RCV ⇒ ACK ⇒ ESTABLISED
full-duplex 통신의 구성
Step 1, 2에서는 P→Q 방향에 대한 연결 파라미터(시퀀스 번호)를 설정하고 이를 승인한다.
Step 2, 3에서는 Q→P 방향에 대한 연결 파라미터(시퀀스 번호)를 설정하고 이를 승인한다.
⇒ 이를 통해 full-duplex 통신이 구축됩니다.


🐥 TCP의 4-Way Handshake
개념
4-Way Handshake은 연결을 해제 (Connecntion Termination)하는 과정이다. 여기서는 FIN 플래그를 이용한다.

FIN (finish) : 세션을 종료시키는데 사용되며, 더 이상 보낸 데이터가 없음을 나타낸다.
Termination의 종류
TCP는 대부분의 connection-oriented 프로토콜과 같은 두 가지 연결 해제 방식이 있습니다.

Graceful connection release(정상적인 연결 해제)

정상적인 연결 해제에서는 양쪽이 커넥션이 서로 모두 커넥션을 닫을 때까지 연결되어 있다.

Abrupt connection release(갑작스런 연결 해제)

갑자기 한 TCP 엔티티가 연결을 강제로 닫는 경우
한 사용자가 두 데이터 전송 방향을 모두 닫는 경우
작동방식 (Abrupt)
RST(TCP reset) 세그먼트가 전송되면 갑작스러운 연결 해제가 수행되는데, RST 세그먼트는 다음과 같은 경우에 전송된다.

존재하지 않는 TCP 연결에 대해 비SYN 세그먼트가 수신된 경우
열린 커넥션에서 일부 TCP 구현은 잘못된 헤더가 있는 세그먼트가 수신된 경우
RST 세그먼트를 보내, 해당 커넥션을 닫아 공격을 방지한다.
일부 구현에서 기존 TCP 연결을 종료해야 하는 경우
연결을 지원하는 리소스 부족할때
원격 호스트에 연결할 수 없고 응답이 중지되었을때
작동방식 (Graceful)
연결 종료 요청 역시, 일반적으로 생각하는 우리가 일반적으로 생각하는 Client와 Server는 모두 서로 연결 요청을 먼저 할 수 있기 때문에, 연결 요청을 먼저 시도한 요청자를 Client로, 연결 요청을 받은 수신자를 Server쪽으로 생각하면 된다.

Half-Close 기법
아래 그림에서 처음 보내는 종료 요청인 (1) FIN 패킷에 실질적으로 ACK가 포함되어 있는 것을 알 수 있는데, 이는Half-Close 기법 을 사용하기 때문이다.

즉, 연결을 종료하려고 할 때 완전히 종료하지 않고 반만 종료합니다.
Half-Close 기법을 사용하면 종료 요청자가 처음 보내는 FIN 패킷에 승인 번호를 함께 담아서 보내게 되는데, 이때 승인 번호의 의미는 "일단 연결은 종료할건데 귀는 열어둘게. 이 승인 번호까지 처리했으니까 더 보낼 거 있으면 보내" 가 됩니다.
이후 수신자가 남은 데이터를 모두 보내고 나면 다시 요청자에게 FIN 패킷을 보냄으로써 모든 데이터가 처리되었다는 신호 (3) FIN를 보냅니다. 그럼 요청자는 그때 나머지 반을 닫으면서 좀 더 안전하게 연결을 종료할 수 있게 됩니다.


<img src="https://velog.velcdn.com/images%2Faverycode%2Fpost%2F3ec34c06-3d54-45f3-a6fb-bc5bfb415001%2F%E1%84%80%E1%85%B5%E1%84%89%E1%85%AE%E1%86%AF%E1%84%86%E1%85%A7%E1%86%AB%E1%84%8C%E1%85%A5%E1%86%B8-6%202.jpg">


STEP1 (Client → Server : FIN(+ACK)

- 서버와 클라이언트가 연결된 상태에서 클라이언트가 close()를 호출하여 접속을 끊는다.(으려한다.)
- 이때, 클라이언트는 서버에게 연결을 종료한다는 FIN 플래그를 보낸다.
- 이때 FIN 패킷에는 실질적으로 ACK도 포함되어있다.
STEP2 (Server → Client : ACK)

- 서버는 FIN을 받고, 확인했다는 ACK를 클라이언트에게 보내고 자신의 통신이 끝날때까지 기다린다. (이상태가 TIME_WAIT 상태)
- server(수신자)는 ACK Number 필드를 (Sequence Number + 1)로 지정하고, ACK 플래그 비트를 1로 설정한 세그먼트를 전송한다.
- 서버는 클라이언트에게 응답을 보내고 CLOSE_WAIT 상태에 들어갑니다. 그리고아직 남은 데이터가 있다면 마저 전송을 마친 후에 close( )를 호출
- 클라이언트에서는 서버에서 ACK를 받은 후에 서버가 남은 데이터 처리를 끝내고 FIN 패킷을 보낼 때까지 기다리게 됩니다. (FIN_WAIT_2)
STEP3 (Server → Client : FIN)

- 데이터를 모두 보냈다면, 서버는 연결이 종료에 합의 한다는 의미로 FIN 패킷을 클라이언트에게 보낸 후에, 승인 번호를 보내줄 때까지 기다니는 LAST_ACK 상태로 들어간다.
STEP4 (Client → Server : ACK)

- 클라이언트는 FIN을 받고, 확인했다는 ACK를 서버에게 보낸다.
- 아직 서버로부터 받지 못한 데이터가 있을 수 있으므로 TIME_WAIT을 통해 기다린다. (실질적인 종료과정 CLOSED에 들어가게 된다.)
- 이때 TIME_WAIT 상태는 의도치 않은 에러로 인해 연결이 데드락으로 빠지는 것을 방지
- 만약 에러로 인해 종료가 지연되다가 타임이 초과되면 CLOSED로 들어갑니다.
- 서버는 ACK를 받은 이후 소켓을 닫는다 (Closed)

- TIME_WAIT 시간이 끝나면 클라이언트도 닫는다 (Closed)

<img src="https://velog.velcdn.com/images%2Faverycode%2Fpost%2F27fe1c27-49cc-40a0-acc0-bc1eef4dd6e4%2F%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202021-07-18%20%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB%202.04.20.png">

🐥 Questions
❓TCP 관련 질문 1
Q. TCP의 연결 설정 과정(3단계)과 연결 종료 과정(4단계)이 단계가 차이나는 이유?
A. Client가 데이터 전송을 마쳤다고 하더라도 Server는 아직 보낼 데이터가 남아있을 수 있기 때문에 일단 FIN에 대한 ACK만 보내고, 데이터를 모두 전송한 후에 자신도 FIN 메시지를 보내기 때문이다.
관련 Reference

❓TCP 관련 질문 2
Q. 만약 Server에서 FIN 플래그를 전송하기 전에 전송한 패킷이 Routing 지연이나 패킷 유실로 인한 재전송 등으로 인해 FIN 패킷보다 늦게 도착하는 상황이 발생하면 어떻게 될까?
A. 이러한 현상에 대비하여 Client는 Server로부터 FIN 플래그를 수신하더라도 일정시간(Default: 240sec)동안 세션을 남겨 놓고 잉여 패킷을 기다리는 과정을 거친다. (TIME_WAIT 과정)
관련 Reference

❓TCP 관련 질문 3
Q. 초기 Sequence Number인 ISN을 0부터 시작하지 않고 난수를 생성해서 설정하는 이유?
A. Connection을 맺을 때 사용하는 포트(Port)는 유한 범위 내에서 사용하고 시간이 지남에 따라 재사용된다. 따라서 두 통신 호스트가 과거에 사용된 포트 번호 쌍을 사용하는 가능성이 존재한다. 서버 측에서는 패킷의 SYN을 보고 패킷을 구분하게 되는데 난수가 아닌 순처적인 Number가 전송된다면 이전의 Connection으로부터 오는 패킷으로 인식할 수 있다. 이런 문제가 발생할 가능성을 줄이기 위해서 난수로 ISN을 설정한다.
관련 Reference

🐥 출처
TCP/UDP

https://blog.naver.com/kenzo28/220238548338
https://ko.wikipedia.org/wiki/전송_계층
https://ko.wikipedia.org/wiki/OSI_모형
https://mangkyu.tistory.com/15
Handshake

https://beenii.tistory.com/127
https://needjarvis.tistory.com/157
https://www.geeksforgeeks.org/tcp-3-way-handshake-process/
https://gyoogle.dev/blog/computer-science/network/TCP 3 way handshake & 4 way handshake.html
https://www.geeksforgeeks.org/tcp-connection-termination/

---
TCP 흐름제어 혼잡제어
- tcp 통신은 신뢰할 수 있는 통신을 보장하는 프로토콜이다. 따라서 network congestion avoidance algorithm사용함.
- 위의 신뢰성을 보장키 위해서는 패킷의 손실, 순서변경, 네트워크의 혼잡, 오버로드에대한 4개의 문제를 해결해야함.

데이터 전송시 응용계층에서 소켓에 데이터 씀-> 전송계층에서 data를 세그먼트에 감싸서 네트워크계층에 전달-><br> 
이 후 수신측에서 전동받으면 송신자의 센드버퍼에 데이터 저장 후 리시버는 리시버의 버퍼에 데이터 저장
-> 응용계층에서 이 버퍼를 읽음 (혼잡에저는 이 버퍼의 관리를 하는 것임)

## 흐름제어
- 수신측보다 송신측의 속도가 빠른경우 문제발생
- 수신측에서 제한된 저장 용량을 초과한 이후에 도착하는 데이터는 손실 될 수 있으며, 만약 손실 된다면 불필요하게 응답과 데이터 전송이 송/수신 측 간에 빈번이 발생한다.
- 이러한 위험을 줄이기 위해 송신 측의 데이터 전송량을 수신측에 따라 조절해야한다.

1. stop and wait : 하나의 패킷에 대해 확인응답을 받아야 다음 패킷을 전송하는 기법
2. 슬라이딩 윈도우 : 수신측이 정한 윈도우 크기만큼 송신측에서 확인 응답없이 세그먼트를 전송하게 해서 데이터흐름을 동적으로 조절하는 기법
- 목적: 전송은 되었지만 acked를 받지못하는 바이트의 숫자파악을 위한 프로토콜
- (마지막에 보내진 바이트 - 마지막에 확인된 바이트 <= 남아있는 공간) ==
(현재 공중에 떠있는 패킷 수 <= sliding window)
## 혼잡제어
- 송신측의 데이터전달이 네트워크상의 처리속도보다 높은 경우 (데이터 송신 속도 제어)
- 라우터의 관점.
1. AIMD(Additive increase/ multiplicative Decrease)/ 합증가 곱감소 알고리즘
- 패킷을 하나씩 보내다가 문제없이 도착시 윈도우 크기(단위시간당 전송 패킷수)를 1씩 증가하며 보내는 방법
- 패킷전송 실패하거나 일정시간 초과시 보내는 속도를 절반으로 줄인다.
- 후진입자가 초반에는 불리하지만 시간이 지날수록 평균상태에 수렴한다.
- 문제점으로는 높은 대역폭을 초반에 사용못해서 오랜 시간이 걸림.
- 후조치 방법으로 네트워크가 혼잡해지고나서야 대역폭을 줄여나가는 방식

2. 느린시작
- Slow Start 방식은 AIMD와 마찬가지로 패킷을 하나씩 보내면서 시작하고, 패킷이 문제없이 도착하면 각각의 ACK 패킷마다 window size를 1씩 늘려준다. 즉, 한 주기가 지나면 window size가 2배로 된다.
- 즉 윈도우의 크기를 1, 2, 4, 8, ...과 같이 지수적으로 증가시키다가 혼잡이 감지되면 윈도우 크기를 1로 줄이는 방식이다.
- 지수함수의 모양으로 전송속도가 증가하지만 혼잡발생시 1로 줄어든다.
- 처음에는 네트워크의 수용량을 예상못해도 혼잡이 한 번 발생하면 수용량을 어느정도 예측 가능함.
- 그러므로 혼잡발생 이전의 윈도우의 절반까지는 지수함수의 꼴로 윈도우를 증가시키되 그 후에는 1씩 증가시키며 최적값을 찾는다.
3. 빠른 재전송
  <img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbloQMX%2FbtrMwYIIB3I%2FFRtyhE6IQKkuLfbK5IABjk%2Fimg.png">
- TCP는 지금까지 받은 데이터 중 연속되는 패킷의 마지막 순번 이후를 ack패킷에 실어 보냄.
- 그래서 송신측이 3ㅡ4번을 보내더라도 2번이 없으면 2번에 대한 ack를 계속 전달 받게된다.
- 그래서 송신 측이 아래처럼 3, 4번을 보내더라도 ACK 2 를 중복해서 받는다.
- 그러면 timeout이 발생하기 전이라도 송신 측은 문제가 되는 2번 패킷을 재전송한다.
- 그리고 혼잡한 상황이라고 판단해서 윈도우 크기를 줄인다.
- 3 ack duplicated 라고 3회이상 중복 ack를 받은 경우가 위의 그림임.
- 빠른 회복이라고 반으로 윈도우를 줄이고 선형증가 시키는 방식-> 혼잡을 1회 겪으면 aimd 방식처럼 동작됨(aimd도 반씩 줄이고 선형증가이므로)

## 혼잡제어 정책
- 공통적으로 혼잡이 발생하면 윈도우 크기를 줄이거나 증가시키지 않으면서 혼잡을 회피하는 전제를 깔고 시작한다.
- 대표적인 tahoe, reno를 다룸
- 둘 다 slow start에서 aimd방식으로 전환하는 방식임.

1. TCP Tahoe
- slow start -> 임계도달시 AIMD 전환
- 그러다 3ack중복이나 타임아웃(데이터유실, ack유실) 발생시 혼잡으로 간주하여 혼잡 발생시의 윈도우 절반으로 임계점을 줄이고 윈도우는 1로 줄인다.
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fb4bZ6X%2FbtrMxEwvOXd%2FDOhptc3APYTYwIaZ4AZK8K%2Fimg.png">

- 위 그래프에서는 청록색은 송신측의 혼잡 윈도우크기, 굵은 검정선은 slowstart임계(여기까지는 느린시작기법사용)
-  이 시나리오에서 송신 측의 혼잡 윈도우 크기는 8로 초기화 되었고, 그에 따라 ssthresh는 4로 설정되어 있다. (까만선이 ssthresh)
송신 측은 임계점을 만나기 전까지 Slow Start 방식을 사용하여 자신의 윈도우 크기를 증가시키다가 ssthresh를 넘어선 이후부터는 선형적으로 증가시키고 있다.

- 이 상황에서 3 ACK Duplicated나 Timeout과 같은 혼잡 상황을 만나면 어떻게 될까?
- 그래프를 보면 처음 혼잡 상황이 발생한 상태의 혼잡 윈도우 크기는 6이며, 그에 따라 ssthresh를 3으로 변경하고, 자신의 혼잡 윈도우 크기를 1로 줄였다. 이후 다시 Slow Start로 시작하여 임계점에 도달하면 AIMD를 시작한다.

- 이 정책은 한 번 혼잡 상황이 발생한 지점을 기억하고 그 지점이 가까워지지 않도록 합리적으로 조절하고 있다.
- 하지만, 초반의 Slow Start 구간에 윈도우 크기를 늘릴 때 오래 걸린다는 단점이 있고, 혼잡 상황이 발생했을 때 다시 윈도우 크기를 1에서부터 시작해야 한다는 단점이 있다. 그래서 TCP RENO 가 등장했다.

2. TCP Reno
- 위의 tahoe와 다른점은 3중ack중복상황과 타임아웃을 명확히 구분짓는다.
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcPXAPE%2FbtrMtFJI07o%2F5KWb3RKDMEJQ0GUth34EQ1%2Fimg.png">

- Reno는 3개의 중복 ACK가 발생했을 때, 윈도우 크기를 1로 줄이는 것이 아니라 AIMD처럼 반으로만 줄이고 sshthresh를 줄어든 윈도우 값으로 정하게 된다. 이 방식을 빠른 회복이라고 부른다.

- 그러나 Timeout에 의해서 데이터가 손실되면 Tahoe와 마찬가지로 윈도우 크기를 바로 1로 줄여버리고 Slow Start를 진행한다. 이때 ssthresh를 변경하지는 않는다.

- 즉, Reno는 ACK 중복은 Timeout에 비해 그리 큰 혼잡이 아니라고 가정하고 혼잡 윈도우 크기를 1로 줄이지도 않는다는 점에서 혼잡 상황의 우선 순위를 둔 정책이라 볼 수 있다.

 
