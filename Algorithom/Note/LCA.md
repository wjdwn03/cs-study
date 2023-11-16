# :books: LCA <sub>최소 공통 조상</sub>

## :bookmark_tabs: 목차

[:arrow_up: **Algorithm**](../README.md)

1. ### [LCA](#📕-lca-lowest-common-ancestor-최소-공통-조상) <sub>Lowest Common Ancestor, 최소 공통 조상</sub>

   - 정의
   - 특징
   - LCA의 동작 원리
   - 알고리즘
   - 복잡도

# :closed_book: LCA <sub>Lowest Common Ancestor, 최소 공통 조상</sub>

## 정의

> 트리 자료구조에서 두 노드 사이의 최소 공통 조상을 구하는 알고리즘

## 특징

- 방향성 비순환 그래프<sub>DAG</sub>의 두 노드 A, B 사이의 가장 가까운 공통 조상을 찾는 알고리즘

## LCA의 동작 원리

### 기본 LCA 동작

### 동적 계획법<sub>DP</sub>으로 개선된 LCA의 동작

### 세그먼트 트리<sub>Segment Tree</sub>로 개선된 LCA의 동작

## 알고리즘

Procedure

JAVA

## 복잡도

### 기본 알고리즘

| 연산 종류             | 평균<sub>Avg</sub> | 최악<sub>Worst</sub> |
| --------------------- | ------------------ | -------------------- |
| 공간<sub>Space</sub>  | `O(N)`             | `O(N)`               |
| 탐색<sub>Search</sub> | `O(NM)`            | `O(NM)`              |

### 동적 계획법을 활용한 알고리즘

| 연산 종류             | 평균<sub>Avg</sub> | 최악<sub>Worst</sub> |
| --------------------- | ------------------ | -------------------- |
| 공간<sub>Space</sub>  | `O(N)`             | `O(N)`               |
| 탐색<sub>Search</sub> | `O(NlogN + MlogN)` | `O(NlogN + MlogN)`   |

### 세그먼트 트리를 활용한 알고리즘

| 연산 종류             | 평균<sub>Avg</sub> | 최악<sub>Worst</sub> |
| --------------------- | ------------------ | -------------------- |
| 공간<sub>Space</sub>  | `O(N)`             | `O(N)`               |
| 탐색<sub>Search</sub> | `O(N + MlogN)`     | `O(N + MlogN)`       |

- `N`은 노드 A를 기준으로 공통 조상을 찾는 과정의 수
- `M`은 노드 B를 기준으로 공통 조상을 찾는 과정의 수
