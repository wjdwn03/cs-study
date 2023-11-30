# :books: Interview - Dynamic Programming <sub>동적 계획법</sub>

## :bookmark_tabs: 목차

[:arrow_up: **Algorithm**](../README.md)

1. ### [Question](#) <sub>면접 질문</sub>

   - 동적계획법에 대해서 설명할 수 있나요?
   - 동적계획법과 분할정복법의 차이를 설명할 수 있나요?

2. ### [Coding Test](#) <sub>알고리즘 문제</sub>

# :closed_book: Question <sub>면접 질문</sub>

### 동적계획법에 대해서 설명할 수 있나요?

[**정리한 내용 참고**](../Note/DynamicProgramming.md)

### 동적계획법과 분할정복법의 차이를 설명할 수 있나요?

분할정복법은 메모이제이션을 활용하지 않지만, 동적계획법은 메모이제이션을 활용한다.

분할정복법은 점화식으로 이루어지지 않은 문제도 해결가능하지만,  
동적계획법은 점화식으로 나타 낼 수 없는 문제를 설계하기 어렵다.

분할정복법은 최적 부분 구조를 가지지 않은 문제도 해결가능하지만,  
동적계획법은 최적 부분 구조를 가지지 않은 문제를 해결하기 어렵다.

예시로 정렬 알고리즘이 있다.  
이들은 점화식의 꼴로 나타 낼 수 없고, 메모이제이션을 하지 않는 종류의 알고리즘

병합정렬과 퀵정렬을 보면, 알고리즘의 정렬 과정들이 여러번 반복되며 하나의 정렬과정을 다른 두 개의 작은 분할 정렬 과정으로 나누거나 간단히 할 수 있기에 분할정복법으로 설계가 가능하다.

그러나 정렬과정은 수학적인 수식으로 더하거나 나눌 수 없기 때문에 점화식으로 만들 수 없고, 따라서 DP로 알고리즘을 설계하기 어렵다.

# :orange_book: Coding Test <sub>알고리즘 문제</sub>

- 백준 1003번 : [피보나치 수열](https://www.acmicpc.net/problem/1003)
- 백준 11053번 : [가장 긴 증가하는 부분 수열](https://www.acmicpc.net/problem/11053)
- 백준 12865번 : [평범한 배낭](https://www.acmicpc.net/problem/12865)
- 백준 2133번 : [타일 채우기](https://www.acmicpc.net/problem/2133)
- 백준 2629번 : [양팔저울](https://www.acmicpc.net/problem/14003)
