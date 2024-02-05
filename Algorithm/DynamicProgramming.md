# :books: DP <sub>Dynamic Programming, 동적 계획법</sub>

## :bookmark_tabs: 목차

[:arrow_up: **Algorithm**](./README.md)

1. ### [Dynamic Programming](#📙-Dynamic-Programming) <sub>동적 계획법</sub>

   - [정의](#closed_book-정의)
   - [특징](#closed_book-특징)
   - [조건](#closed_book-조건)
   - [접근 방식](#closed_book-접근-방식)
   - [장단점](#closed_book-장단점)
   - [대표적인 DP 문제](#closed_book-대표적인-dp-문제)


# :closed_book: 정의
> 큰 문제를 작은 문제로 나누어서 푸는 방법을 일컫는 말

# :closed_book: 특징

# :closed_book: 조건
- DP를 적용하기 위해, 아래 두 가지 조건을 만족시켜야 함.

1. **`부분 반복 문제`** <sub>Overlapping Subproblem</sub>
1. **`최적 부분 구조`** <sub>Optimal Substructure</sub>

# :closed_book: 접근 방식
- Bottom-up <sub>상향식</sub>
- Top-down <sub>하향식</sub>
  - memoization에 주로 사용
  - **재귀적**으로 문제를 풀이함.
  > memoization <sub>메모이제이션</sub> : 반복적으로 계산하는 것들을 하지 않게 저장하며 진행하는 방식

# :closed_book: 장단점

## 장점

-  같은 함수(계산)이 여러번 반복 될 경우 속도 측면에서의 장점

fibo(4) = fibo(3) + fibo(2)이고 fibo(3)=fibo(2) + fibo(1) 이므로 fibo(4)를 계산할 때 분할정복법을 이용한다면 fibo(2)가 두 번 계산 되게 됩니다.

DP를 이용한 경우 fibo(2)의 값을 dp[2] 에 저장해둔다면 같은 계산을 여러번 반복하지 않고 배열에서 값을 가져오므로 

이 문제의 경우 DP를 이용해서 푸는 것이 분할정복법을 이용해서 푸는 것 보다 빠릅니다. 숫자가 커지면 커질수록 중복되는 수도 많아질 것이고 속도차이도 커지게 됩니다.

-  문제를 여러번 풀 경우 속도 측면에서의 장점

예를 들어 피보나치 수열의 n번째 값을 fibo(n)이라하면 fibo(128), fibo(200), fibo(300) 과 같이 비슷한 값들을 여러번 구하는 문제를 풀어야 할 수 있습니다.

DP를 이용하여 짠 알고리즘은 이 경우 fibo(128)까지의 값이 dp[] 배열에 저장되어 있기 때문에 fibo(200)을 풀 때 그만큼의 계산을 덜 할 수 있고, fibo(300)을 풀때는 200까지의 계산을 덜 해도 되겠죠.
​

- StackOverFlow 방지 등 메모리의 안정성 측면에서 강점. 

함수를 호출하면 프로그램의 Stack 공간에 쌓이게 됩니다.
그런데 위와 같은 방식으로 재귀 함수를 통해 반복적으로 함수를 호출할 경우 각 함수들이 종료되지 않고 Stack 공간의 메모리를 잡아먹게 되죠.

위의 같은 함수들이 반복 될 경우에 생기는 속도 관련 문제와 마찬가지로 같은 함수가 반복되므로 Stack의 메모리 공간도 더욱 많이 차지하게 됩니다.

따라서 위의 분할정복법을 이용해서 만들어진 fibo(n) 함수의 경우, n이 커질 경우에 StackOverFlow가 발생할 수 있습니다.

DP를 이용해서 만든 함수 fibo(n)의 경우 어떤 숫자 n에 대해서 한 번씩만 함수가 호출이 되고 이외의 경우에는

fibo(n)이 아니라 dp[n]을 사용하므로 이러한 StackOverFlow 등이 나타날 가능성을 낮출 수 있습니다.

## 단점
- 메모리 공간 사용
DP는 기본적으로 메모이제이션을 사용하다보니 배열 등의 공간에 값을 많이 저장하게 됩니다.
이로 인해서 메모리 공간을 많이 사용하고 차지하게 되는 단점이 있습니다.
백트래킹으로 문제를 풀 수 있는 경우, 
백트래킹 알고리즘 등에 비해 메모리 공간을 많이 사용하고(물론 속도는 대부분의 경우 DP가 더 빠릅니다.)
이로 인해 Memory Overflow 등이 나기도 합니다.

# :closed_book: 대표적인 DP 문제
- 피보나치
- 이항 계수
- 거스름돈 구하기
- 0-1 Knapsack <sub>배낭 문제</sub>
- 최장 증가 수열

</br>

---

</br>

- 참고

[[알고리즘] Dynamic programming (동적 계획법) 완전정복 with Python](https://lsh424.tistory.com/76)

[[알고리즘] Dynamic Programming (동적 계획법, DP) (feat. Swift 스위프트)](https://didu-story.tistory.com/220)

[[SW직무 면접 대비] / 알고리즘  / 동적계획법(Dynamic Programming)이란?](https://m.blog.naver.com/cih468/221733097917)

[배낭 문제(KnapSack Problem) 그림으로 쉽게 이해하기](https://howudong.tistory.com/106)
