# :books: Interview - DNS round robin

## :bookmark_tabs: 목차

[:arrow_up: **Network**](../README.md)

1. ### [Question](#) <sub>면접 질문</sub>

   - 라운드로빈이란? 및 장단점
   - DNS ROUND ROBIN 방식 단점은?

# :closed_book: Question <sub>면접 질문</sub>

### 라운드로빈이란? 및 장단점

라운드 로빈 스케줄링(Round Robin Scheduling, RR)은 시분할 시스템을 위해 설계된 선점형 스케줄링의 하나로서, 프로세스들 사이에 우선순위를 두지 않고, 순서대로 시간단위(Time Quantum/Slice)로 CPU를 할당하는 방식의 CPU 스케줄링 알고리즘입니다.
문맥 전환의 오버헤드가 큰 반면, 응답시간이 짧아지는 장점이 있어 실시간 시스템에 유리하고, 할당되는 시간이 클 경우 비선점 FIFO기법과 같아지게 됩니다.

DNS ROUND ROBIN 방식은 로드 밸런싱을 위한 기술로, 동일한 도메인에 대한 다수의 IP 주소를 가지고 있는 경우, DNS 서버가 각각의 IP 주소를 번갈아가며 클라이언트에게 반환하는 방식입니다. 이것은 다수의 서버나 리소스를 병렬적으로 활용하여 부하 분산을 달성하는 데 사용됩니다.

### DNS ROUND ROBIN 방식 단점은?

- 서버 상태 무시

   DNS Round Robin은 서버의 상태를 고려하지 않고 IP 주소를 반환하기 때문에, 서버 과부하나 장애에 즉각 대응하기 어렵습니다.

- 불균형한 부하 분산

   서버 간의 성능 차이나 트래픽 처리 능력의 차이로 인해, DNS Round Robin은 부하를 균형있게 분산하지 못할 수 있으며 일부 서버는 다른 서버보다 더 많은 트래픽을 처리해야 할 수 있습니다.

- 고객 경험 불일치

   클라이언트가 동일한 도메인 이름에 여러 번 연결 시도할 때, 다른 서버로 연결될 수 있어 사용자 경험이 일관성이 없을 수 있습니다.

- 서버 응답 시간 차이

   서버 간 응답 시간의 차이로 인해 클라이언트는 다른 서버로 연결할 때마다 응답 시간이 다를 수 있습니다.

- DNS 캐싱 문제

   클라이언트와 중간 DNS 서버가 DNS 응답을 캐시할 수 있으므로, 서버의 IP 주소 변경이 즉시 반영되지 않을 수 있습니다.

---

- 참고

   [백엔드 기술 면접 질문(네트워크)](https://velog.io/@min9288/%EB%B0%B1%EC%97%94%EB%93%9C-%EA%B0%9C%EB%B0%9C-%EB%A9%B4%EC%A0%91-%EC%A7%88%EB%AC%B8%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC#dns%EB%9E%80)

   [네트워크 면접 예상 질문/답변](https://velog.io/@seungjun2/%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC-%EC%A7%88%EB%AC%B8%EB%8B%B5%EB%B3%80-%EB%AF%B8%EC%99%84%EC%84%B1#%EF%B8%8F-wwwnavercom-%EC%9D%B4%EB%9D%BC%EB%8A%94-%EB%8F%84%EB%A9%94%EC%9D%B8-%EC%9D%B4%EB%A6%84%EC%9D%84-%EC%B2%98%EC%9D%8C-%EB%B0%9B%EC%95%98%EC%9D%84-%EB%95%8C-%EB%AC%B4%EC%8A%A8-%EC%9D%BC%EB%93%A4%EC%9D%B4-%EC%9D%BC%EC%96%B4%EB%82%A0%EA%B9%8C%EC%9A%94)