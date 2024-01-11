# :books: Interview - GET & POST <sub>GET과 POST</sub>

## :bookmark_tabs: 목차

[:arrow_up: **Network**](../README.md)

1. ### [Question](#) <sub>면접 질문</sub>

   - GET과 POST에 대해서 설명할 수 있나요?
   - GET과 POST의 차이점을 설명해보세요.

# :closed_book: Question <sub>면접 질문</sub>

### GET과 POST에 대해서 설명할 수 있나요?

[**정리한 내용 참고**](../Note/GET&POST.md)

### GET과 POST의 차이점을 설명해보세요.

- 사용목적에 따라 다르며 GET은 서버의 리소스에서 데이터를 요청할 때, POST는 서버의 리소스를 새로 생성하거나 업데이트할 때 사용

|                         |                      GET                       |                     POST                      |
| ----------------------- | :--------------------------------------------: | :-------------------------------------------: |
| 사용 목적               |      서버의 리소스에서 데이터를 요청할 때      | 서버의 리소스를 새로 생성하거나 업데이트할 때 |
| URL 데이터 노출 여부    |                      Yes                       |                      No                       |
| URL 예시                | http://localhost:8080/sign_up?id=admin&pw=1234 |         http://localhost:8080/sign_up         |
| 요청에 본문이 존재      |                       No                       |                      Yes                      |
| 성공 응답에 본문이 존재 |                      Yes                       |                      Yes                      |
| 안전함                  |                      Yes                       |                      No                       |
| 멱등성                  |                      Yes                       |                      No                       |
| 캐시 가능 여부          |                      Yes                       |         No (타임 스탬프로 부분적 Yes)         |
| HTML 양식 사용 가능     |                      Yes                       |                      Yes                      |

> ### 안전함 <sub>Safety</sub>
>
> - Read-Only Method
> - HTTP 메서드가 서버의 상태를 바꾸지 않으면 그 메서드가 안전하다고 말함
> - 안전한 메서드는 멱등성을 갖지만, 멱등성을 가진 메서드가 모두 안전한건 아님
> - `GET`, `HEAD`, `OPTIONS`가 이에 해당

> ### 멱등성 <sub>Idempotency</sub>
>
> - Non-Side Effect Method
> - 동일한 요청을 한 번 보내는 것과 여러 번 연속으로 보내는 것이 같은 효과를 지니고, 서버의 상태도 동일하게 남을 때, 해당 메서드가 멱등성을 가졌다고 말함
> - 응답코드가 다른 것과 타임스탬프를 남기는 것과 같이 의도된 side effect는 예외
> - 서버는 메서드의 멱등성을 보장하지 않음
