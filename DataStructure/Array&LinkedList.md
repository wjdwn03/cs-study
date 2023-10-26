# :books: Array & Linked List <sub>배열과 연결 리스트</sub>

## :bookmark_tabs: 목차

[:arrow_up: **DataStructure**](./README.md)

1. ### [ADT](#📕-adt-abstract-data-type-추상-자료형) <sub>Abstract Data Type, 추상 자료형</sub>

   - 정의
   - 추상 자료형의 명세 내용
   - 추상 자료형의 정의 방법

2. ### [Array](#📙-array-배열) <sub>배열</sub>

   - 정의
   - 특징
   - 크기 조정
   - 복잡도
   - 장단점
   - 활용

3. ### [Linked List](#📗-linked-list-연결-리스트) <sub>연결 리스트</sub>

   - 정의
   - 특징
   - 크기 조정
   - 연결 리스트의 종류
   - 복잡도
   - 장단점
   - 활용

# :closed_book: ADT <sub>Abstract Data Type, 추상 자료형</sub>

## 정의

> 사용자의 관점에서 동작성(의미론<sub>Semantics</sub>), 유효성과 데이터에 대한 작업 가능성 측면에서 정의된 데이터 유형에 대한 수학적 모델

> 데이터 구조<sub>DataStructure</sub>의 추상형<sub>Abstract Type</sub>으로, 해당 구조의 공통된 속성, 기능을 명세한 것

> 논리적 동작이 값 집합과 작업 집합에 의해 정의되는 추상 개체 클래스

## 추상 자료형의 명세 내용

- 저장되는 데이터<sub>Data</sub>
- 데이터에 대한 작업 (메소드<sub>Methods</sub> 또는 함수<sub>Functions</sub>)
- 발생 가능한 에러에 대한 예외<sub>Exceptions</sub>

## 추상 자료형의 정의 방법

### Imperative-style definition <sub>명령형 정의</sub>

- 명령형 프로그래밍론에서 추상 데이터 구조는 변경 가능한 엔터티로 간주
- 일부 작업이 ADT는 상태를 개별적으로 수정할 수 있음
- 서로 다른 추상 ADT는 서로 다른 시간에 서로 다른 상태에 있을 수 있음
- 명령형 정의를 위해 추상 변수와 인스턴스의 개념을 활용

### Functional-style definition <sub>함수형 정의</sub>

- 함수형 프로그래밍론에서 구조체의 각 상태를 별도의 엔터티로 간주
- ADT를 수정하는 모든 작업은 수학적 함수 모델<sub>Mathematical Function</sub>을 기반으로 함
  > 수학적 함수 모델이란?  
  > 이전 상태<sub>Old States</sub>를 인수로 사용하고 작업 결과의 일부를 새 상태<sub>New States</sub>로 반환하는 모델
- 명령형과 다르게 이 과정에서 부작용<sub>Side Effect</sub>가 발생하지 않음

# :orange_book: Array <sub>배열</sub>

## 정의

> 메모리 크기가 동일한 요소<sub>Elements</sub>(값<sub>Values</sub> 또는 변수<sub>Variables</sub>)의 모음으로 구성된 데이터 구조

## 특징

- 같은 타입의 데이터를 나열한 선형 자료구조<sub>Sequence Container</sub>
- 각각 하나 이상의 배열 인덱스<sub>Array Index</sub> 또는 키<sub>Key</sub>를 통해 식별
- 논리적인 저장 순서와 물리적인 저장 순서가 일치
- 수학적인 원리를 통해 각 요소의 위치를 식별 가능
- 모든 요소의 위치를 인덱싱하고 있으므로 임의 접근<sub>Random Access</sub>이 가능
- 대부분 언어에서 배열의 첫번째 인덱싱 요소를 0으로하여 양의 정수로 인덱싱<sub>Indexing</sub>
- 생성시 컴퓨터의 스택<sub>Stack</sub> 영역에 메모리를 할당
- 행렬<sub>Matrix</sub> , 튜플<sub>Tuple</sub> , 벡터<sub>Vctor</sub>의 개념과 유사

## 크기 조정 <sub>Resizing</sub>

- 배열의 크기를 선언 시점에 정의
- 물리적 저장 위치가 메모리 주소 상 연속적으로 존재해야 하기에 한 번 할당된 배열의 크기를 임의로 변경하는 것은 불가능
- 기존의 배열 요소를 모두 포함하는 새로운 배열을 선언한 뒤 요소를 복사하는 것으로 해결
- 따라서 배열의 크기 조정<sub>resizing</sub>은 기존 배열의 크기 N과 크기를 변경(또는 복제)하는 배열의 크기 M만큼 필요하므로 요구 공간 복잡도는 `O(N+M)`

## 복잡도

| 연산 종류             | 평균<sub>Avg</sub> | 최악<sub>Worst</sub> |
| --------------------- | ------------------ | -------------------- |
| 공간<sub>Space</sub>  | `O(N)`             | `O(N)`               |
| 탐색<sub>Search</sub> | `O(N)`             | `O(N)`               |
| 삽입<sub>Insert</sub> | `O(N)`             | `O(N)`               |
| 삭제<sub>Delete</sub> | `O(N)`             | `O(N)`               |

- 배열의 인덱스를 알고 있을 때 삽입(또는 삭제)에 걸리는 시간은 `O(1)`
- 배열의 임의 위치의 인덱스를 찾아 삽입(또는 삭제)에 걸리는 시간은 `O(N)`
- 배열 기반 자료형의 경우, 임의 위치에 값을 삽입(또는 삭제)하고 이후 이어지는 값이 연속성을 가지도록 옮기는<sub>shift</sub> 연산이 필요. 걸리는 시간은 `O(N)`

## 장단점

- ### 장점

  - 인덱스를 통해 임의의 원소에 접근(random access)이 가능
  - 상수 시간 내 선형탐색이 가능하므로 연산이 빠름
  - 연속된 주소값을 가져 수학적인 원리에 기반하해 원소에 접근할 수 있어서 관리가 편함

- ### 단점

  - 임의 위치에 데이터의 삽입/삭제가 어려움
  - 최대 길이와 메모리가 고정되어있음
  - 공간 최적화가 어려워 메모리 영역의 공간 낭비가 발생

## 활용

- 데이터 개수가 유한범위 안의 상수로 정해져 있을 때
- 데이터의 삽입과 삭제가 적거나 단순할 때
- 빠른 검색을 수행해야할 때

# :green_book: Linked List <sub>연결 리스트</sub>

## 정의

> 물리적 배치에 따라 순서가 지정되지 않는 데이터 요소<sub>Elements</sub>(값<sub>Values</sub> 또는 변수<sub>Variables</sub>)의 모음

## 특징

- 데이터를 순차적으로 저장하는 선형 자료구조<sub>Sequence Container</sub>
- 각 요소는 노드<sub>Node</sub>라는 단위로 구성되며, 값<sub>Data</sub>와 링크<sub>Link</sub>(또는 포인터<sub>Pointer</sub>)로 구성됨
- 노드의 링크는 자신으로부터 이어지는 다음 노드를 가리킴
- 논리적인 저장 순서와 물리적인 저장 순서가 항상 일치하는 것은 아님
- 대부분 리스트의 첫번째 요소를 머리<sub>Head</sub> , 마지막 요소를 꼬리<sub>Tail</sub>이라 부름
- 생성시 컴퓨터의 힙<sub>Heap</sub> 영역에 메모리를 할당

## 연결 리스트의 종류

### 단일 연결 리스트 <sub>Singly linked list</sub>

![img:단일_연결_리스트](./img/linkedlist_01.png)

- 단일 연결 리스트는 값<sub>Values</sub>과 다음 노드<sub>Next Node</sub>로 구성

### 이중 연결 리스트 <sub>Doubly linked list</sub>

![img:이중_연결_리스트](./img/linkedlist_02.png)

- 이중 연결 리스트는 값<sub>Values</sub>과 이전 노드<sub>Prev Node</sub> , 다음 노드<sub>Next Node</sub>로 구성

### 순환 연결 리스트 <sub>Circular linked list</sub>

![img:순환_연결_리스트](./img/linkedlist_03.png)

- 단일 연결 리스트와 동일한 구성이되 꼬리<sub>Tail</sub>의 다음 노드<sub>Next Node</sub> 필드가 `Null`을 가리키지 않고 머리<sub>Head</sub>를 가리키도록 구성
- 순환 이중 연결 리스트의 경우, 이중*연결*리스트 동일한 구성이되
  - 꼬리<sub>Tail</sub>의 다음 노드<sub>Next Node</sub>가 `Null`을 가리키지 않고 머리<sub>Head</sub>를 가리키도록 구성
  - 머리<sub>Head</sub>의 이전 노드<sub>Prev Node</sub>가 `Null`을 가리키지 않고 머리<sub>Tail</sub>를 가리키도록 구성

## 크기 조정 <sub>Resizing</sub>

- 리스트의 크기는 노드의 링크를 연결 및 제거 하는 것으로 동적으로 확장 가능(배열로 구현할 경우를 제외)
- 얕은 복사<sub>Shallow Copy</sub>의 경우 노드의 링크 주소만 복사하면 되므로 요구 공간 복잡도는 `O(N)`이 그대로 유지됨
- 깊은 복사<sub>Deep Copy</sub>를 할 경우 각 노드의 값와 링크 전부 복사해야하므로 요구 공간 복잡도는 `O(N+M)`

## 복잡도

| 연산 종류             | 평균<sub>Avg</sub> | 최악<sub>Worst</sub> |
| --------------------- | ------------------ | -------------------- |
| 공간<sub>Space</sub>  | `O(N)`             | `O(N)`               |
| 탐색<sub>Search</sub> | `O(N)`             | `O(N)`               |
| 삽입<sub>Insert</sub> | `O(N)`             | `O(N)`               |
| 삭제<sub>Delete</sub> | `O(N)`             | `O(N)`               |

- 공간 복잡도는 O(N)이지만, 링크 영역 만큼의 부가적인 메모리를 추가로 소모
- 이미 목표하는 지점에 대한 주소를 인덱싱 했을 경우 접근에 필요한 시간은 `O(1)`
- 리스트의 시작(머리) 또는 끝(꼬리)에서 삽입 삭제가 이루어 질 시 `O(1)`

## 장단점

- ### 장점

  - 링크로 연결되어 있어서 가리키는 노드만 변경하면 되므로 삽입/삭제가 용이
  - 새로운 노드를 추가 시 동적으로 크기가 변경됨
  - 노드가 메모리 상 불연속적으로 할당되므로 낭비되는 빈 공간 없이 데이터를 저장
  - 메모리 재사용성을 가짐

- ### 단점

  - 인덱스나 키를 통한 요소 접근이 이 불가능해 색인/탐색/접근 시간이 느림
  - 모든 노드는 다음 노드를 가리키는 링크를 저장해야 하므로 추가 저장 공간을 요구

## 활용

- 데이터의 크기와 개수가 정해져 있지 않을 때
- 데이터의 삽입과 삭제가 자주 일어날 때
- 적재한 데이터를 대상으로 검색을 자주 하지 않을 때
