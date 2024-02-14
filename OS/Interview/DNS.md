# :books: Interview - DNS <sub>Domain Name System</sub>

## :bookmark_tabs: 목차

[:arrow_up: **Network**](../README.md)

1. ### [Question](#) <sub>면접 질문</sub>

   - DNS란?
   - DNS 동작 과정 : www.naver.com을 입력하면 어떻게 작동하나?
   - DNS iterative query와 DNS recursive query의 차이점에 대해서 설명해주세요.
   - 도메인을 캐시에 저장하는데, 자주 찾는 도메인과 자주 찾지 않는 도메인을 각각 어디에 저장하는지 아시나요?
   - 그렇다면 도메인은 캐시에 계속해서 쌓이나요?
   - 자주 찾는 도메인은 메모리 캐시에 넣는데 왜 디스크 캐시에 넣지 않나요?
   - DNS 서버에 IP주소를 요청할 때 UDP를 사용하는 이유는?
   - 네이버와 네이버 쇼핑에 대해 도메인적 관점에서 설명하시오

# :closed_book: Question <sub>면접 질문</sub>

### DNS란?

DNS는 도메인 주소를 IP 주소로 변환해주는 시스템입니다. 사용자는 DNS가 있으면 IP 주소를 몰라도 도메인 이름을 통해 접근할 수 있습니다.

### DNS 동작 과정 : www.naver.com을 입력하면 어떻게 작동하나?

아래 그림과 설명을 참고해서 답변하자.

|<img src="../img/dns_flow_detail.png">|
|---:|
|<sub>출처 : [10분 테코톡] 엘리의 DNS</sub> |

0. 사용자가 'www.google.com'을 브라우저에 입력
1. 브라우저의 캐시에 해당 도메인의 IP 주소가 있나 확인
    
    1-1. 있으면 IP 주소 반환
2. 컴퓨터에 저장된 hosts 파일과 캐시에서 IP 주소가 있나 확인

    2-1. 있으면 IP 주소 반환
3. Local DNS 서버 (Recursive DNS 서버)에게 www.google.com의 IP 주소를 달라고 요청
4. Local DNS 서버 (Recursive DNS 서버)에서 캐시 데이터가 있는지 확인
    
    4-1. 있으면 IP 주소 반환
5. Root 네임 서버로 IP 주소 요청
6. '.com'에 매칭되는 TLD 네임 서버의 주소를 Recursive DNS 서버로 반환
7. TLD 네임 서버에게 IP 주소 요청
8. 'google.com'에 매칭되는 Sub Domain 네임 서버의 주소를 Recursive DNS 서버로 반환
9. Sub Domain 네임 서버에게 'www.google.com'에 대한 IP 주소 요청
10. 도메인 이름의 IP 주소를 Recursive DNS 서버로 반환
11. Recursive DNS 서버는 IP 주소를 캐싱하고 웹 브라우저에 IP 주소를 제공
12. 웹 브라우저는 응답받은 IP 주소를 HTTP 요청을 처리

### DNS iterative query와 DNS recursive query의 차이점에 대해서 설명해주세요.

Iterative query는 루트 네임서버부터 도메인의 트리형태 계층 구조를 따라 순차적으로 반복적으로 진행하는 질의입니다.

Recursive query는 DNS 서버에게 질의를 던지는데 질문에 대한 응답을 찾을 때까지 계속해서 전달합니다. 그렇기 때문에 처리 시간이 길어지는 단점이 있습니다. (이부분은 내 생각이긴 함)그러나 캐싱을 통해 처리 시간을 줄일 수 있을 것 같습니다.

### 도메인을 캐시에 저장하는데, 자주 찾는 도메인과 자주 찾지 않는 도메인을 각각 어디에 저장하는지 아시나요?

자주 찾는 도메인은 메모리 캐시에 저장하고, 자주 찾지 않는 도메인은 디스크 캐시에 저장합니다.

### 그렇다면 도메인은 캐시에 계속해서 쌓이나요?

아닙니다. 일정 시간 동안 캐시에 저장되어 유지되다가, TTL(Time To Live) 값이 만료되면 캐시에서 지워집니다.

### 자주 찾는 도메인은 메모리 캐시에 넣는데 왜 디스크 캐시에 넣지 않나요?

메모리 캐시는 디스크 캐시에 비해 빠른 속도로 데이터에 접근할 수 있기 때문입니다.
메모리 용량은 한정적이기 때문에 자주 찾는 도메인만 메모리 캐시에 저장하고, 자주 찾지 않는 도메인을 디스크 캐시에 저장함으로써 메모리 용량을 효율적으로 관리할 수 있습니다.

### DNS 서버에 IP주소를 요청할 때 UDP를 사용하는 이유는?

- UDP는 연결 설정 및 해제 오버헤드가 적고, 빠른 응답 시간을 제공합니다.
- DNS 조회는 간단한 질문-답변 형태의 통신이며, UDP는 이를 처리하기에 효율적입니다.
- 부하 분산이 필요하며, UDP는 여러 동시 요청을 병렬로 처리하기 용이합니다.
- 작은 패킷 크기와 단순한 요청-응답 특성으로 인해 UDP가 적합합니다.
- DNS 조회에서 요청과 응답의 일치는 클라이언트 책임으로, 추가적인 신뢰성 기능이 필요하지 않습니다.

### 네이버와 네이버 쇼핑에 대해 도메인적 관점에서 설명하시오.

네이버의 도메인은 "www.naver.com"으로, 네이버의 포털 웹사이트를 가리킵니다.
네이버 쇼핑은 "shopping.naver.com"이라는 서브도메인으로, 네이버의 온라인 쇼핑 플랫폼을 나타냅니다.

---

- 참고

   [백엔드 기술 면접 질문(네트워크)](https://velog.io/@min9288/%EB%B0%B1%EC%97%94%EB%93%9C-%EA%B0%9C%EB%B0%9C-%EB%A9%B4%EC%A0%91-%EC%A7%88%EB%AC%B8%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC#dns%EB%9E%80)
   
   [면접 예상 질문(5)(컴퓨터 네트워크(1))](https://velog.io/@cis07385/%EB%A9%B4%EC%A0%91-%EC%98%88%EC%83%81-%EC%A7%88%EB%AC%B85%EC%BB%B4%ED%93%A8%ED%84%B0-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC#dns-iterative-query%EC%99%80-dns-recursive-query%EC%9D%98-%EC%B0%A8%EC%9D%B4%EC%A0%90%EC%97%90-%EB%8C%80%ED%95%B4%EC%84%9C-%EC%84%A4%EB%AA%85%ED%95%B4%EC%A3%BC%EC%84%B8%EC%9A%94)

   [네트워크 면접 예상 질문/답변](https://velog.io/@seungjun2/%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC-%EC%A7%88%EB%AC%B8%EB%8B%B5%EB%B3%80-%EB%AF%B8%EC%99%84%EC%84%B1#%EF%B8%8F-wwwnavercom-%EC%9D%B4%EB%9D%BC%EB%8A%94-%EB%8F%84%EB%A9%94%EC%9D%B8-%EC%9D%B4%EB%A6%84%EC%9D%84-%EC%B2%98%EC%9D%8C-%EB%B0%9B%EC%95%98%EC%9D%84-%EB%95%8C-%EB%AC%B4%EC%8A%A8-%EC%9D%BC%EB%93%A4%EC%9D%B4-%EC%9D%BC%EC%96%B4%EB%82%A0%EA%B9%8C%EC%9A%94)