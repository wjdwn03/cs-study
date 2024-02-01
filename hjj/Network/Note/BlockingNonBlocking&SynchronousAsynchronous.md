# Blocking, Non-blocking & Synchronous, Asynchronous

## :bookmark_tabs: 목차

[:arrow_up: **Network**](../README.md)

1. ### Blocking, Non-blocking & Synchronous, Asynchronous
   - [:page_facing_up: GET](#get-요청)
   - [:page_facing_up: POST](#post-요청)
   - [:page_facing_up: GET과 POST 비교](#get과-post-비교)


> **Blocking** : 자신의 작업을 진행하다가 다른 주체의 작업이 시작되면 다른 작업이 끝날 때까지 기다렸다가 자신의 작업을 시작하는 것
</br>

> **Non-blocking** : 다른 주체의 작업에 관련 없이 자신의 작업을 하는 것
</br>

> **Synchronous** : 요청이 들어온 순서에 맞게 하나씩 처리하는 것
</br>

> **Asynchronous** : 하나의 요청이 끝나기도 전에, 다른 요청을 동시에 처리할 수 있는 것

➡️ Synchronous와 Blocking은 무언가를 기다리게 하고, Asynchronous와 Nonblocking은 기다리지 않고 바로 바로 처리됨.

## Synchronous & Asynchronous <sub>동기 & 비동기</sub>

- 한 작업이 다른 작업을 호출하는 경우, 호출되는 함수의 작업 완료 여부를 누가 신경을 쓰는 지에 따라 나뉨.
- "신경 쓴다"는 방법으로는 끝났으면 끝났다는 말을 들을 때까지 기다리기와 끝났는지 계속 물어보는 방법 2가지
- 대상들의 시간이 맞춰지는가?
- 시간(순서와 결과)의 관점

- Asynchronous
    - 호출하는 함수가 작업 완료 여부를 신경 쓰지 않음.
    - 호출하는 함수에게 Callback을 전달해서 작업을 완료하면 실행하도록 함.
    - 기다리지도, 물어보지도 않음.
    - Asynchronous를 구현하기 위해 호출된 함수의 작업은 별도의 thread로 빼서 실행하며 완료되면, 호출한 함수에게 알려줌.

- Synchronous
    - 호출하는 함수가 작업 완료 여부를 확인
    - 호출하는 함수는 호출되는 함수의 작업 완료 여부 또는 작업 완료 후 리턴을 기다리고 있음.
    - 또는 주기적으로 계속 물어봄.

## Blocking & Nonblocking

- 한 작업이 다른 작업을 호출하는 경우, 호출되는 함수가 바로 리턴을 하는 지 여부에 따라 나뉨.
- 누구한테 **제어권**(작업을 할 권리)이 있는 지가 관건
- 제어할 수 없는 대상의 처리 방법
- 제어의 관점

- Nonblocking
    - 호출된 함수가 바로 리턴
    - 호출된 함수가 제어권을 바로 호출한 함수에게 넘겨주어 다른 일을 할 수 있도록 함.
    - 제어권은 호출한 함수에게 있음.
- Blocking
    - 호출된 함수가 자신의 작업을 완료할 때까지 리턴하지 않음.
    - 호출된 함수는 자신의 작업을 완료하면, 호출한 함수에게 제어권을 넘겨주므로 호출한 함수는 다른 일을 하지 않고 대기함.
    - 제어권은 호출된 함수에게 있음.


<img src="../img/blocking_nonblocking_sync_async.png">


✔️ Sync-Blocking

- Synchronous + Blocking
- 호출하는 함수는 호출된 함수의 작업 완료/리턴을 계속 기다림.
- 호출된 함수는 자신의 작업이 완료되면 리턴
- 따라서 호출한 함수는 함수를 호출한 후, 리턴을 받기 전까지 다른 일을 하지 않고 대기

✔️ Async-Nonblocking

- Asynchronous + Nonblocking
- 호출하는 함수는 호출된 함수의 작업 완료 및 리턴을 기다리지 않음.
- 호출된 함수는 호출되면 바로 리턴


✔️ Sync-Nonblocking

- Synchronous + Nonblocking
- 호출하는 함수는 호출된 함수의 작업 완료 및 리턴을 끝났는지 계속 기다림.
- 호출된 함수는 호출되면 바로 리턴
- 따라서 호출한 함수는 호출 이후 제어권을 바로 받기 때문에 작업을 계속하면서, 호출했던 함수의 작업 완료는 주기적으로 확인


✔️ Async-Blocking

- Asynchronous + Blocking
- 호출하는 함수는 호출된 함수의 작업 완료 및 리턴을 기다리지 않음.
- 호출된 함수는 자신의 작업이 완료되면 리턴
- 호출한 함수는 호출한 함수의 리턴을 기다리지 않지만, 호출된 함수는 자신의 작업이 끝날 때까지 제어권을 넘겨 주지 않기 때문에 호출된 함수의 작업이 완료될 때까지 대기하게 됨.
- 즉, Sync-Blocking과 유사하게 동작하며, 이 방식에 비해 별다른 이점이 없음.
- 그러나 Async-Nonblocking을 추구하다 의도치 않게 Async-Blocking이 되는 경우가 있음. 
- 다시 말해, 호출한 함수가 호출된 함수를 신경 쓰지 않고 다른 일을 하게 하도록 하고 싶은데, 어쩔 수 없이 호출된 함수를 기다리게 되는 경우임.
- 대표적인 예시는 Node.js와 MySQL의 조합이다. Node.js에서 Callback 함수를 통해 Asynchronous 방식을 택하여도 DB 작업 호출 시 MySQL 드라이버를 호출하게 되는데, 이 드라이버가 Blocking 방식이기 때문

</br>



## I/O 작업

입출력 작업은 커널 레벨에서만 수행할 수 있으므로 프로세스 및 스레드는 커널에게 I/O를 요청해야 한다. 즉, 프로세스 및 스레드는 호출하는 함수, I/O 작업은 호출되는 함수가 됨.

### I/O Blocking

- 프로세스/스레드가 커널에게 I/O를 요청하는 함수 (recvfrom) 호출
- 커널 작업 완료
- 작업 결과 리턴

<img src="../img/blocking_io.png">

- 커널 작업 중에 프로세스/스레드는 자신의 작업을 중단하고 대기
- 커널 작업 중 CPU 자원을 쓰지 않으므로 자원 낭비가 심함. (물론 I/O 작업 완료 대기 중인 프로세스의 CPU 제어권을 뺏어서 다른 프로세스에게 주고, I/O가 끝나면 CPU의 제어권을 다시 넘겨 받는 방식으로 구현할 수도 있음.)
- 여러 클라이언트가 접속하는 서버인 경우, I/O 작업을 호출한 작업은 중지되어도 다른 클라이언트가 실행하는 작업은 중지되면 안 되기 때문에 클라이언트 별로 스레드를 생성하게 되어 클라이언트의 수가 매우 많아짐.


### I/O Nonblocking

- 프로세스/스레드가 커널에게 I/O를 요청하는 함수 (recvfrom) 호출
- 커널은 곧바로 리턴
- 커널 작업이 완료되면 데이터를 리턴

<img src="../img/nonblocking_io.png">

- 커널 작업 중에 프로세스/스레드는 자신의 작업을 진행함.



---

- 참고

    [[운영체제] Blocking, Non-blocking & Synchronous, Asynchronous](https://steady-coding.tistory.com/531)

    [[네트워크] HTTP GET 요청과 POST 요청](https://pabeba.tistory.com/150#recentEntries)

    [HTTP의 GET과 POST 메서드 비교. [ 네트워크 면접 질문1 ]](https://murphymoon.tistory.com/entry/HTTP%EC%9D%98-GET%EA%B3%BC-POST-%EB%A9%94%EC%84%9C%EB%93%9C-%EB%B9%84%EA%B5%90-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC-%EB%A9%B4%EC%A0%91-%EC%A7%88%EB%AC%B81)