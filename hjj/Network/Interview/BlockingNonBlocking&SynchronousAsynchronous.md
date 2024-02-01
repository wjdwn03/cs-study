# :books: Interview - Blocking, Non-Blocking & Synchronous, Asynchronous

## :bookmark_tabs: 목차

[:arrow_up: **Network**](../README.md)

1. ### [Question](#) <sub>면접 질문</sub>

   - Synchronous & Asynchronous와 Blocking & Nonblocking의 차이
   - Synchronous & Asynchronous & Blocking & Nonblocking를 설명하세요.

# :closed_book: Question <sub>면접 질문</sub>

### Synchronous & Asynchronous와 Blocking & Nonblocking의 차이

Synchronous와 Asynchronous는 순서와 결과의 관점이라면, Blocking과 Nonblocking은 제어의 관점이라 볼 수 있다.

### Synchronous & Asynchronous & Blocking & Nonblocking를 설명하세요.

동기 <sub>Synchronous</sub>

동기란, 요청이 들어온 순서에 맞게 하나씩 처리하는 방식이다.

 

비동기 <sub>Asynchronous</sub>

비동기란, 하나의 요청이 끝나기도 전에, 다른 요청을 동시에 처리를 할 수 있는 방식이다.

 

블로킹 <sub>Blocking</sub>

커널과 같이 제어할 수 없는 대상의 작업이 끝날 때까지 기다려야 하는 방식이다.

ex) I/O 작업이 다 끝날 때까지 해당 애플리케이션은 기다려야 한다.

 

논블로킹 <sub>Non-blocking</sub>

커널과 같이 제어할 수 없는 대상의 작업이 완료되기 전에, 제어권을 넘겨 받을 수 있는 방식이다.

ex) I/O 작업이 끝나기도 전에 해당 애플리케이션이 수행하던 로직을 추가로 수행할 수 있게 됩니다.

---

- 참고

   [[운영체제] Blocking, Non-blocking & Synchronous, Asynchronous](https://steady-coding.tistory.com/531)