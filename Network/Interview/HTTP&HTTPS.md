# :books: Interview - HTTP & HTTPS <sub>HTTP와 HTTPS</sub>

## :bookmark_tabs: 목차

[:arrow_up: **Network**](../README.md)

1. ### [Question](#) <sub>면접 질문</sub>

   - HTTP/HTTPS에 대해서 설명할 수 있나요?
   - HTTP와 HTTPS를 차이점을 설명해보세요.

# :closed_book: Question <sub>면접 질문</sub>

### 대칭키/공개키에 대해서 설명할 수 있나요?

[**정리한 내용 참고**](../Note/HTTP&HTTPS.md)

### HTTP와 HTTPS를 차이점을 설명해보세요.

- HTTP(HyperText Transfer Protocol)
  - 정보를 텍스트로 주고받기 때문에 전송 신호를 인터셉트하면 데이터 유출이 가능
  - Wireshark와 같은 패킷캡처 프로그램으로 캡처하면 정보가 그대로 노출
  - HTTPS에서는 네트워크로 데이터 전송을 하기 전에 내용을 암호화
  - HTTP는 기본포트로 80번을, HTTPS는 443번을 사용
  - HTTPS는 암호화 과정을 거치면서 웹 부하가 생기고 느려지나, 현재 인터넷 생태에선 미미한 정도

|               | HTTP                                                          | HTTPS                                                                 |
| ------------- | ------------------------------------------------------------- | --------------------------------------------------------------------- |
| 의미          | Hypertext Transfer Protocol                                   | Hypertext Transfer Protocol Secure                                    |
| 기본 프로토콜 | HTTP/1과 HTTP/2는 TCP/IP를 사용 HTTP/3은 QUIC 프로토콜을 사용 | HTTP 요청 및 응답을 추가로 암호화하기 위해 SSL/TLS와 함께 HTTP/2 사용 |
| 포트          | 80 port                                                       | 443 port                                                              |
| 용도          | 이전 텍스트 기반 웹 사이트                                    | 모든 최신 웹 사이트                                                   |
| 보안          | 추가 보안 기능 없음                                           | 퍼블릭 키 암호화에 SSL 인증서 사용                                    |
| 이점          | 인터넷을 통한 통신 지원                                       | 웹 사이트에 대한 권위, 신뢰성 및 검색 엔진 순위 개선                  |
