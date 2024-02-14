# :books: Interview - CORS <sub>Cross-Origin Resource Sharing</sub>

## :bookmark_tabs: 목차

[:arrow_up: **Network**](../README.md)

1. ### [Question](#) <sub>면접 질문</sub>

   - CORS에 대해서 설명해보세요.
   - CORS 에러 해결 방법은 뭔가요?
   - Preflight를 하는 이유가 뭔가요?

# :closed_book: Question <sub>면접 질문</sub>

### CORS에 대해서 설명해보세요.

CORS란 Cross Origin Resource Sharing의 약자로, 서로 다른 도메인간에 자원을 공유하는 것을 의미하며 기본적으로 차단되어있습니다.

### CORS 에러 해결 방법은 뭔가요?

**서버에서 Access-Control-Allow-Origin 헤더를 세팅하기**

- 직접 서버에서 HTTP 헤더 설정을 통해 출처를 허용하게 설정하는 가장 정석적인 해결책입니다. 헤더 설정 방법은 [CORS](../Note/CORS.md)를 참고해서 대답하자.

### Preflight를 하는 이유가 뭔가요?

preflight는 브라우저가 CORS를 지원하지 않은 서버에 도달하면 요청에 대한 응답을 보내지 않아 실제 요청이 수행되지 않도록 보호하기 위해 만들어졌습니다. 예를 들어 POST 요청을 할 때, preflight가 없다면 브라우저가 CORS를 관리하기 때문에 CORS 여부에 상관없이 이미 서버에서 요청한 로직이 수행된 응답이 브라우저에 도달하게 됩니다. 하지만 CORS 에러로 인해 브라우저는 그 사실을 알지 못하게 되고 치명적인 서버의 오류로 남아있을 수 있습니다. 따라서 이를 방지하고자 preflight request를 보내는 것입니다.

---

- 참고

   [CORS](https://dev-hyun.tistory.com/188)

