## NetWork Study 파트1 진행 목차
1. OSI 7 계층
2. TCP와 UDP
3. TCP 3 way handshake & 4 way handshake
4. TCP/IP 흐름제어 & 혼잡제어
5. Network Socket

## OSI 7 계층
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
