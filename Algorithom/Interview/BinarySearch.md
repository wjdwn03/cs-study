# :books: Interview - Binary Search <sub>이분탐색</sub>

## :bookmark_tabs: 목차

[:arrow_up: **Algorithm**](../README.md)

1. ### [Question](#) <sub>면접 질문</sub>

   - 이분 탐색에 대해서 설명할 수 있나요?
   - 이분 탐색 시 원하는 값을 항상 찾을 수 있는 것을 보장하나요?
   - 이분 탐색으로 100만건의 데이터 안에서 원하는 값을 찾을 때 총 몇번의 탐색을 수행해야 하나요?

2. ### [Coding Test](#) <sub>알고리즘 문제</sub>

# :closed_book: Question <sub>면접 질문</sub>

### 이분 탐색에 대해서 설명할 수 있나요?

[**정리한 내용 참고**](../Note/BinarySearch.md)

### 이분 탐색 시 원하는 값을 항상 찾을 수 있는 것을 보장하나요?

원하는 값이 데이터 안에 있는 경우 항상 찾을 수 있다.  
단, 데이터 집합을 대상으로 데이터를 오름차순으로 정렬해 두어야 할 필요가 있다.

### 이분 탐색으로 100만건의 데이터 안에서 원하는 값을 찾을 때 총 몇번의 탐색을 수행해야 하나요?

이분 탐색의 탐색은 매번 절반만큼을 탐색 범위에서 제거하는 방법으로 동작하므로 총 동작 회수는 $log_{2} N$이다. 여기에 N이 1,000,000이므로 약 20번의 탐색을 통해 원하는 찾을 수 있다.

# :orange_book: Coding Test <sub>알고리즘 문제</sub>

- 백준 1920번 : [수 찾기](https://www.acmicpc.net/problem/1920)
- 백준 10816번 : [숫자 카드 2](https://www.acmicpc.net/problem/10816)
- 밴준 2805번 : [나무 자르기](https://www.acmicpc.net/problem/2805)
- 백준 2110번 : [공유기 설치](https://www.acmicpc.net/problem/2110)
