# :books: Interview - DNS round robin

## :bookmark_tabs: 목차

[:arrow_up: **Network**](../README.md)

1. ### [Question](#) <sub>면접 질문</sub>

   - 라운드로빈이란? 및 장단점

# :closed_book: Question <sub>면접 질문</sub>

### 라운드로빈이란? 및 장단점

라운드 로빈 스케줄링(Round Robin Scheduling, RR)은 시분할 시스템을 위해 설계된 선점형 스케줄링의 하나로서, 프로세스들 사이에 우선순위를 두지 않고, 순서대로 시간단위(Time Quantum/Slice)로 CPU를 할당하는 방식의 CPU 스케줄링 알고리즘입니다.
문맥 전환의 오버헤드가 큰 반면, 응답시간이 짧아지는 장점이 있어 실시간 시스템에 유리하고, 할당되는 시간이 클 경우 비선점 FIFO기법과 같아지게 됩니다.

---

- 참고

   [백엔드 기술 면접 질문(네트워크)](https://velog.io/@min9288/%EB%B0%B1%EC%97%94%EB%93%9C-%EA%B0%9C%EB%B0%9C-%EB%A9%B4%EC%A0%91-%EC%A7%88%EB%AC%B8%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC#dns%EB%9E%80)