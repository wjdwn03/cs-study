# :books: Graph & Tree & Heap <sub>그래프와 트리 그리고 힙</sub>

## :bookmark_tabs: 목차

[:arrow_up: **DataStructure**](./README.md)

1. ### [Graph](#📕-graph-그래프) <sub>그래프</sub>

   - 정의
   - 특징
   - 그래프의 기본 종류
   - 그래프의 구현 방법
   - 복잡도
   - 활용

2. ### [Tree](#📙-tree-트리) <sub>트리</sub>

   - 정의
   - 특징
   - 크기 조정
   - 복잡도
   - 장단점
   - 활용

3. ### [Heap](#📗-heap-힙) <sub>힙</sub>

   - 정의
   - 특징
   - 크기 조정
   - 복잡도
   - 장단점
   - 활용

# :closed_book: Graph <sub>그래프</sub>

## 정의

> 유한한 정점 집합<sub>Vertex Set</sub>과 간선 집합<sub>Edge Set</sub>의 연결 관계를 기록한 순서 쌍<sub>Pair</sub>으로 구성된 자료구조

## 특징

- 유한개의 정점<sub>Vertex</sub>과 간선<sub>Edge</sub>으로 구성되어 있음
  - 데이터의 위치를 나타내는 정점<sub>Vertex</sub>(또는 노드<sub>Node</sub> , 포인트<sub>Point</sub>)
  - 데이터의 연결 관계를 나타내는 간선<sub>Edge</sub>(또는 선<sub>Line</sub> , 링크<sub>Link</sub>)
- 간선은 방향성<sub>Direct</sub>과 가중치<sub>Weight</sub>를 가질 수 있음
- 두 점이 간선으로 연결되어 있으면 이를 인접<sub>Adjacent</sub>했다고 표현
- 서로 떨어진 두 정점을 여러 간선을 거쳐 연결된 것을 경로<sub>Path</sub>라 부름
- 경로의 시작 지점과 끝 지점이 동일할 경우도 있으며 이를 사이클<sub>Cycle</sub> 이라고 함

## 그래프의 기본 종류

- 기본적으로 무방향, 방향, 가중치 여부로 그래프를 분류하며, 방향과 가중치 모두 있는 경우나 사이클이 있는 경우에 따라 추가적으로 분류하기도 함

### Undirected graph <sub>무방향 그래프</sub>

![img:무방향 그래프](./img/graph_01.png)

- 간선에 방향성과 가중치가 모두 없는 그래프

### Directed graph <sub>방향 그래프</sub>

![img:방향 그래프](./img/graph_02.png)

- 간선에 방향성 있는 그래프

### Weighted graph <sub>가중치 그래프</sub>

![img:가중치 그래프](./img/graph_03.png)

- 간선에 가중치가 있는 그래프

## 그래프의 구현 방법

![img:무방향 그래프 구현](./img/graph_04.png)

### Adjacency list <sub>인접 리스트</sub>

![img:인접 리스트](./img/graph_05.png)

- 그래프의 각 정점을 root로 가지는 리스트 배열을 생성한 뒤, 간선에 따라 인접한 두 정점 i, j를 `V[i].add(pair(j, weight))` 형태로 기록해서 구현
- 각 정점 리스트에 삽입된 노드는 비순차적으로 기록됨
- 리스트의 요소의 수는 간선의 개수와 일치
- **장점**
  - 간선의 개수가 적을 때 비교적 적은 공간을 활용해 그래프를 표현 가능
  - 정점의 연결 관계를 파악하기 위해서 `O(E)`의 시간 복잡도를 요구
- **단점**
  - 리스트의 링크를 표시하기 위해 추가적인 메모리 소모가 발생
  - 특정 정점 또는 간선 정보를 찾기 위해서 `O(V+E)`의 시간 복잡도 요구

### Adjacency matrix <sub>인접 행렬</sub>

![img:인접 행렬](./img/graph_06.png)

- 그래프의 두 정점의 쌍(i, j)을 가지는 행렬을 생성한 뒤, 간선에 따라 인접한 두 정점을 i, j를 `adj[i][j] = weight` 형태로 기록해서 구현
- 행렬의 크기는 `O(V^2)`
- **장점**
  - 구현이 쉬움
  - 두 정점 간의 연결 정보를 찾기 위해서 `O(1)`의 시간 복잡도를 요구
- **단점**
  - 정점의 연결 관계를 파악하기 위해서 최대 `O(V^2)`의 시간 복잡도를 요구

### Incidence matrix <sub>결합 행렬</sub>

![img:결합 행렬](./img/graph_07.png)

- 그래프의 각 정점과 간선의 쌍(i, e)을 가지는 행렬을 생성한 뒤, 간선에 따라 인접한 두 정점을 `inc[i][e] = weight` 형태로 기록해서 구현
- 행렬의 크기는 `O(VE)`
- 방향 그래프에서 연결된 정점의 시작 지점과 끝 지점을 구분하기 위해서 시작 정점의 가중치 값을 음수, 끝 정점의 가중치 값을 정수로 표현하기도 함
- **장점**
  - 구현이 쉬움
  - 인접 행렬에 비해서 메모리를 절약
  - 부분 그래프<sub>Sub-graph</sub>와 사이클을 파악하기 쉬움
  - 정점과 간선의 연결 정보를 찾기 위해서 `O(1)`의 시간 복잡도를 요구
- **단점**
  - 정점의 연결 관계를 파악하기 위해서 최대 `O(VE)`의 시간 복잡도를 요구

## 복잡도

| 연산 종류             | 평균<sub>Avg</sub> | 최악<sub>Worst</sub> |
| --------------------- | ------------------ | -------------------- |
| 공간<sub>Space</sub>  | `O(V+E)`           | `O(V+E)`             |
| 탐색<sub>Search</sub> | `O(V+E)`           | `O(V+E)`             |
| 삽입<sub>Insert</sub> | `O(1)`             | `O(1)`               |
| 삭제<sub>Delete</sub> | `O(V+E)`           | `O(V+E)`             |

- `V`는 정점의 수, `E`는 간선의 수
- 탐색에는 깊이 우선 탐색<sub>Depth First Search, DFS</sub>과 너비 우선 탐색<sub>Breadth First Search, BFS</sub>를 사용
- 삽입 시 필요한 시간 복잡도는 `O(1)`이지만, 삭제 시 원하는 데이터를 지우기 위해 모든 정점과 간선을 순회해 찾아야 하므로 시간복잡도는 `O(V+E)`
- 단, 인접 행렬이나 결합 행렬로 구현되었을 경우 삽입/삭제에 걸리는 시간 복잡도는 `O(1)`

## 활용

- 경로 탐색<sub>Path Searching</sub> 구현
- 상태 머신<sub>State Machine</sub> 구현
- 연결 관계 기반으로 데이터를 관리해야 할 때

# :orange_book: Tree <sub>트리</sub>

## 정의

> 일렬의 연결된 노드를 계층적인 트리 구조<sub>Tree Structure</sub>

## 특징

## 크기 조정

## 복잡도

## 장단점

## 활용

# :green_book: Heap <sub>힙</sub>

# :closed_book: 힙 (Heap)

## 정의

> 최댓값<sub>Max Value</sub> 또는 최솟값<sub>Min Value</sub>을 빠르게 탐색하기 위해 고안된 완전 이진 트리<sub>Complete Binary Tree</sub> 기반의 자료구조

## 특징

- 우선순위큐<sub>Priority Queue</sub>라는 ADT를 구현하기 위한 자료구조 중 하나
- 완전 이진 트리<sub>Complete Binary Tree</sub> 구조로 구현
- 여러 개의 값 중에서 최대 값이나 최솟값을 빠르게 찾아낼 수 있는 특성을 가짐
- 모든 노드는 부모와 자식 간의 일정한 관계를 유지함
  - **최대 힙**<sub>Max Heap</sub>은 루트 노드가 가장 큰 값을 가지고 부모는 자식보다 큰 값을 가짐
  - **최소 힙**<sub>Min Heap</sub>은 루트 노드가 가장 작은 값을 가지고 부모는 자식보다 작은 값을 가짐
    ![img:최대 힙과 최소 힙](./img/heap_01.png)

## 힙의 구현 방법

![img:배열로 트리 구현](./img/heap_02.png)

### 배열을 이용한 구현

- 힙을 1차원 배열로 표현
- 각 노드의 부모와 자식 관계를 인덱스를 통해 유지
- 구현을 쉽게하기 위해 일반적으로 루트 노드를 인덱스 1로 시작
- 부모와 자식 관계를 유지하기 위해 적절한 계산식을 사용
  - 왼쪽 자식의 인덱스 : $Index_{parent} \times 2$
  - 오른쪽 자식의 인덱스 : $Index_{parent} \times 2 + 1$
  - 부모의 인덱스 : $Index_{child} \div 2$

### 이진 트리를 이용한 구현

- 자신의 값, 각 자식 노드를 가리키는 레퍼런스 변수 2개로 노드를 구성
- 힙을 이진 트리로 구현하고, 각 노드에는 값을 저장
- 각 노드의 부모와 자식 관계를 트리 구조를 통해 유지

## 힙의 연산

max heap 기준 설명하며, min heap은 정렬 순서의 차이만 있고 과정은 동일함

### 힙정렬

```
Heapify(A, i) {
   leftChild <- left(i)
   rightChild <- right(i)
   if (leftChild <= heapsize) and (A[leftChild] > A[i])
      largest <- leftChild
   else
      largest <- i
   if (rightChild <= heapsize) and (A[rightChild] > A[largest])
      largest <- rightChild
   if (largest != i) {
      exchange A[i] <-> A[largest]
      Heapify(A, largest)
   }
}
```

### 데이터 삽입

![img:힙 데이터 삽입](./img/heap_03.png)

### 데이터 삭제

![img:힙 데이터 삭제](./img/heap_04.png)

## 복잡도

| 연산 종류             | 평균<sub>Avg</sub> | 최악<sub>Worst</sub> |
| --------------------- | ------------------ | -------------------- |
| 공간<sub>Space</sub>  | `O(N)`             | `O(N)`               |
| 탐색<sub>Search</sub> | `O(1)`             | `O(1)`               |
| 삽입<sub>Insert</sub> | `O(log N)`         | `O(log N)`           |
| 삭제<sub>Delete</sub> | `O(log N)`         | `O(log N)`           |

- `N`은 힙의 요소 수
- 탐색의 시간복잡도는 최대/최소힙에서 최대/최소 값을 조회한다는 전제로 작성됨
- 최대/최소힙에서 최소/최대 값 또는 임의의 값을 조회 할 시 시간 복잡도는 `O(N)`

## 활용

- 우선순위 큐(Priority Queue) 구현
- 힙 정렬(Heap Sort) 알고리즘
- 다익스트라 알고리즘(Dijkstra's Algorithm) 등
