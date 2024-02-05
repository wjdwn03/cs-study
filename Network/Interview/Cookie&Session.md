# :books: Interview - Cookie & Session <sub>쿠키와 세션</sub>

## :bookmark_tabs: 목차

[:arrow_up: **Network**](../README.md)

1. ### [Question](#) <sub>면접 질문</sub>

   - 쿠키와 세션의 차이점을 말해보세요.
   - 쿠키와 세션을 사용하는 이유는?

# :closed_book: Question <sub>면접 질문</sub>

### 쿠키와 세션의 차이점을 말해보세요.

쿠키는 클라이언트 측에 저장되고 세션은 서버 측에 저장됩니다. 그렇기 때문에 쿠키보다 세션이 더 보안성이 높습니다. 또한, 쿠키는 브라우저가 종료되더라도 만료 기간이 남아 있다면 계속 남아 있지만 세션도 만료 기간을 설정할 수 있지만 브라우저 종료시 바로 삭제가 됩니다.

### 쿠키와 세션을 사용하는 이유는?

HTTP protocol의 connectionless, stateless한 특성 때문에 서버는 클라이언트가 누구인지, 로그인을 했는지 잊어버리게 됩니다. 매번 확인을 해야하는 불편함 때문에 이러한 특성을 보완하기 위해 쿠키와 세션을 사용합니다.

---

- 참고

   [면접 예상 질문 및 답변](https://drsggg.tistory.com/388)
   [쿠키(Cookie), 세션(Session)이란?](https://suyeoniii.tistory.com/82)