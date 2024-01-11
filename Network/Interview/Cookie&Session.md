# :books: Interview - Cookie & Session <sub>쿠키와 세션</sub>

## :bookmark_tabs: 목차

[:arrow_up: **Network**](../README.md)

1. ### [Question](#) <sub>면접 질문</sub>

   - 쿠키와 세션에 대해서 설명할 수 있나요?
   - 쿠키와 세션을 사용하는 이유에 대해 설명할 수 있나요?
   - 대체적으로 쿠키보다 세션이 더 좋은데 쿠키를 쓰는 왜 쓰는가요?

# :closed_book: Question <sub>면접 질문</sub>

### 쿠키와 세션에 대해서 설명할 수 있나요?

[**정리한 내용 참고**](../Note/Cookie&Session.md)

### 쿠키와 세션을 사용하는 이유에 대해 설명할 수 있나요?

- HTTP 프로토콜의 특징이자 약점을 보완하기 위해서 사용
- HTTP의 Stateless를 유지한 채 Stateful한 서비스를 구현하기 위해 사용

> ### Connectionless (비연결지향)
>
> - 클라이언트가 서버에 요청(Request)을 했을 때, 그 요청에 맞는 응답(Response)을 보낸 후 연결을 끊는 통신 방식
>   - HTTP 1.1 버전에서 연결을 유지/재활용 하는 기능이 추가됨 (keep-alive 값으로 변경 가능, 기본값은 Default)

> ### Stateless (무상태지향)
>
> - 클라이언트의 상태 정보를 가지지 않는 서버 처리 방식
> - 첫 통신에서 데이터를 주고 받아도 다음 통신이 이전 상태를 기록하지 않음

### 쿠키와 세션의 차이점을 설명해보세요.

|                    |                            Cookie                            |                     Session                     |
| ------------------ | :----------------------------------------------------------: | :---------------------------------------------: |
| 저장 위치          |                    클라이언트(사용자 PC)                     |                 사이트(웹 서버)                 |
| 저장 형식          |                         String(Text)                         |             Object(양식 제한 없음)              |
| 만료 시점          | 쿠키 저장시 설정(만료시점이 지나지 않으면 자동삭제되지 않음) | 브라우저 연결 종료시 삭제 (유지 시간 지정 가능) |
| 주로 사용하는 자원 |                          클라이언트                          |                     웹 서버                     |
| 용량 제한          |                      하나의 쿠키당 4KB                       |                    제한 없음                    |
| 인증 속도          |                             빠름                             |                      느림                       |
| 보안               |                 클라이언트가 관리하므로 취약                 |           서버가 관리해 쿠키보다 안전           |

### 대체적으로 쿠키보다 세션이 더 좋은데 쿠키를 쓰는 왜 쓰는가요?

- 세션이 쿠키에 비해 규격도 자유롭고 보안도 높은 편이나 서버에 저장되고, 서버자원을 사용하기 때문에 사용자가 많을 경우 소모되는 자원이 커짐
- 이러한 문제를 해결하고자 대부분 사이트는 쿠키와 세션을 병행해 서버 자원의 낭비를 방지하며 웹 사이트의 속도를 높이는 방식으로 구현
  - 쿠키 : 자주 호출해야하고 보안 중요도가 낮은 데이터 저장
  - 세션 : 호출 횟수가 많지 않으며 보안 중요도가 높은 데이터 저장