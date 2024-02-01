# DNS <sub>Domain Name System</sub>

## :bookmark_tabs: 목차

[:arrow_up: **Network**](../README.md)

1. ### DNS
   - [:page_facing_up: DNS](#dns-domain-name-system-1)
   - [:page_facing_up: 왜 CORS가 필요할까?](#왜-cors가-필요할까)
   - [:page_facing_up: CORS 3가지 동작 방식](#cors-3가지-작동-방식)
   - [:page_facing_up: CORS 해결 방법](#cors-해결-방법)


## DNS <sub>Domain Name System</sub>

> 도메인 이름과 IP 주소에 대한 정보를 관리하는 시스템

|<img src="../img/dns_basic.png" width="400">|
|---:|
|<sub>출처 : [10분 테코톡] 엘리의 DNS</sub> |

<img src="../img/dns_basic.png" width="400">

<sub>출처 : [10분 테코톡] 엘리의 DNS</sub>

- 인터넷에 연결된 각 기기에는 다른 컴퓨터가 기기를 찾는 데 사용하는 고유한 IP 주소가 있음.
- 도메인 이름을 IP 주소로 변환해줌.
- 사용자는 DNS가 있으면 IP 주소를 몰라도 도메인 이름을 통해 접근할 수 있음.


### DNS의 기초적인 동작 흐름

|<img src="../img/dns_basic_flow.png">|
|---:|
|<sub>출처 : [10분 테코톡] 엘리의 DNS</sub> |

0. 사용자가 'www.google.com'을 브라우저에 입력
1. 브라우저의 캐시에 해당 도메인의 IP 주소가 있나 확인
    
    1-1. 있으면 IP 주소 반환
2. 컴퓨터에 저장된 hosts 파일과 캐시에서 IP 주소가 있나 확인

    2-1. 있으면 IP 주소 반환
3. DNS 서버에게 www.google.com의 IP 주소를 달라고 요청
4. DNS 서버가 도메인의 IP 주소를 반환

</br>

📢 하나의 DNS 서버에서 전 세계의 모든 DNS 정보를 관리할 때 문제점

- **서버의 고장** 
    - 네임 서버가 고장나면, 전체 인터넷이 작동되지 않음.
- **트래픽의 양**
    - 단일 DNS 서버가 전세계의 모든 엄청난 양의 DNS 질의를 처리해야 함.
- **먼 거리의 중앙 집중 데이터베이스**
    - 단일 DNS 서버는 모든 클라이언트로부터 가까울 수 없기 때문에 심각한 지연 발생 가능
- **유지 관리**
    - 단일 DNS 서버는 모든 인터넷 호스트에 대한 레코드를 유지해야 하기 때문에 새로운 호스트를 반영하기 위해 자주 갱신을 해야 하고 데이터베이스가 점점 거대해짐.



### DNS 서버 분리

- 트래픽과 데이터 분산
    - 위에서 말한 문제점들을 보완하기 위해 DNS는 분산되도록 설계
- `네임 서버` <sub>NS, Name Server</sub>
    - 도메인에 매핑되는 IP 주소로 변환해주는 서버
    - 계층화된 DNS 서버 각각이 하나의 네임 서버임.
- Root NS
    - Root Domain을 관리
    - 국제인터넷주소관리기구 : ICANN
- TLD <sub>Top-Level Domain</sub> NS
    - TLD <sub>Top-Level Domain</sub>를 관리
    - 도메인 등록 기관(Registry)
- Sub Domain NS
    - Sub Domain 관리
    - TLD 하위 모든 Domain이 여기에 해당 (Second-Level Domain, Third-Level Domain 등)
    - 도메인 판매 업체(Registar)
    - ex) 가비아, Route53
- 상위 서버는 하위 서버의 위치를 알고 있음.


</br>

---

- 참고

    [DNS(Domain Name System)란 무엇인가요?](https://www.ibm.com/kr-ko/topics/dns)

    [[10분 테코톡] 엘리의 DNS](https://www.youtube.com/watch?v=sDXcLyrn6gU)

    [주소창에 'naver.com'을 치면 어떤 일이 일어날까?](https://velog.io/@gusdh2/%EC%A3%BC%EC%86%8C%EC%B0%BD%EC%97%90-naver.com%EC%9D%84-%EC%B9%98%EB%A9%B4-%EC%96%B4%EB%96%A4-%EC%9D%BC%EC%9D%B4-%EC%9D%BC%EC%96%B4%EB%82%A0%EA%B9%8C)
    
    [[Network] DNS 서비스와 동작 원리, DNS 캐싱](https://howudong.tistory.com/363)

    [CORS](https://dev-hyun.tistory.com/188)