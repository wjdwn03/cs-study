# :books: Interview - Floyd-Warshall <sub>플로이드-워셜 알고리즘</sub>

## :bookmark_tabs: 목차

[:arrow_up: **Algorithm**](../README.md)

1. ### [Question](#) <sub>면접 질문</sub>

   - 플로이드-워셜 알고리즘에 대해서 설명할 수 있나요?
   - 플로이드-워셜 알고리즘이 음수사이클을 만나면 어떻게 되나요?
   - 플로이드-워셜 알고리즘에서 경로를 확인하는 방법을 설명할 수 있나요?

2. ### [Coding Test](#) <sub>알고리즘 문제</sub>

# :closed_book: Question <sub>면접 질문</sub>

### 플로이드-워셜 알고리즘에 대해서 설명할 수 있나요?

[**정리한 내용 참고**](../Note/Floyd-Warshall.md.md)

### 플로이드-워셜 알고리즘이 음수사이클을 만나면 어떻게 되나요?

음수 사이클은 변의 가중치의 합이 음수를 갖는 사이클이다. 음수 사이클을 구성하는 어떤 정점의 쌍i,j에 대해서 경로 i,j가 음의 무한으로 갈 수 있기 때문에 최단 경로를 구할 수 없다.

이를 응용해 음수 사이클을 감지할 수 있는데, 음수 사이클이 있다면 경로 ii가 기존의 0이 아닌 0보다 더 작은 값인 음수를 가지게 되므로 이를 통해 음수 사이클이 있다는 것을 파악할 수 있다.

### 플로이드-워셜 알고리즘에서 경로를 확인하는 방법을 설명할 수 있나요?

(플로이드-워셜 알고리즘의 경로 복원) - :construction:

# :orange_book: Coding Test <sub>알고리즘 문제</sub>

- 백준 11403번 : [경로 찾기](https://www.acmicpc.net/problem/11403)
- 백준 11404번 : [플로이드](https://www.acmicpc.net/problem/11404)
- 백준 2458번 : [키 순서](https://www.acmicpc.net/problem/2458)
- 백준 1613번 : [역사](https://www.acmicpc.net/problem/1613)
- 백준 1719번 : [택배](https://www.acmicpc.net/problem/1719)
