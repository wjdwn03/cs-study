# :books: Interview - REST & RESTful <sub>RESTful API</sub>

## :bookmark_tabs: 목차

[:arrow_up: **Network**](../README.md)

1. ### [Question](#) <sub>면접 질문</sub>

   - Restful API에 대해 설명해주세요.
   - REST란 무엇이고, RESTful하게 API를 디자인한다는 것은 무엇인지 설명하시오.

# :closed_book: Question <sub>면접 질문</sub>

### Restful API에 대해 설명해주세요.

Restful API는 HTTP 통신을 Rest 설계 규칙을 잘 지켜서 개발한 API를 Restful한 API라고 합니다.
Rest 설계 규칙은 URI는 정보의 자원만 표현해야 하며, 자원의 상태와 행위는 HTTP Method에 명시하는걸 말합니다.

### REST란 무엇이고, RESTful하게 API를 디자인한다는 것은 무엇인지 설명하시오.
REST는 Representational State Transfer의 약자입니다. 간단히 말해서 URI와 HTTP 메소드를 이용해 객체화된 서비스에 접근하는 것입니다. REST의 요소로는 크게 리소스, 메소드, 메세지 3가지 요소로 구성됩니다. 예를 들어 "이름이 Tom인 사용자를 생성한다." 라는 호출이 있을 때 "사용자"는 생성되는 리소스, "생성한다."라는 행위는 메소드, 그리고 "이름이 Tom인 사용자"는 메세지가 됩니다. 즉 리소는 http://myweb/users라는 형태의 URI로 표현되며, 메소드는 HTTP Post, 메세지는 JSON 문서를 이용해서 표현됩니다. HTTP에는 여러가지 메소드가 있지만 REST에서는 CRUD에 해당하는 4가지의 메소드 GET, POST, PUT, DELETE를 사용합니다. REST는 리소스 지향 아키텍쳐 스타일이라는 정의에 맞게 모든 것을 명사로 표현하며 각 세부 리소스에는 id를 붙입니다.

Restful하게 API를 디자인한다는 것은 URI를 규칙에 맞게 잘 설계했는지의 여부입니다. 규칙의 항목으로는 아래와 같습니다.
1. 동일한 URI(End point)의 행위에 맞게 POST, GET, DELETE, PATCH등의 메소드를 사용한다.
2. 명사를 사용한다. 리스트를 표현할 때는 복수형을 사용한다.
3. URI Path에 불필요한 파라미터를 넣지 않는다. 즉, 단계를 심플하게 설계한다.

---

- 참고

   [신입 개발자 기술면접 질문 정리 - 프로그래밍 공통/기타](https://dev-coco.tistory.com/164)
   [[기술면접대비] 개발자 기술면접 대비 요약본 (4)](https://wooaoe.tistory.com/51)