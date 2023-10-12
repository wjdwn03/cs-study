# Red Black Tree

### ❓이진 탐색 트리(Binary Search Tree, BST)의 일종으로 이진 트리의 약점을 극복하기 위해 새로운 규칙을 추가하여 나온 이진 트리



## 레드-블랙 트리의 조건

1. 모든 트리의 노드에 검은색 혹은 빨간색을 색칠한다.
2. **루트 노드**는 항상 **검은색**이다.
3. 모든 ***리프 노드*** 들은 **검은색**이다.
    1. 리프 노드 : 자식 노드가 존재 하지 않는 노드
4. 빨간색 노드의 자식은 양쪽 다 항상 검은색이다.4.1. 즉, 빨간색 노드는 연달아 나타날 수 없다.4.2. 이 규칙을 지키면, 검은색 노드만이 빨간색 노드의 부모가 될 수 있다.
5. 루트 노드에서 어떠한 자식 노드를 타고 가던지 리프 노드에 도달했을 때 항상 같은 수의 검은색 노드를 만나게 된다.

### 특징

- java의 TreeSet과 TreeMap은 레드-블랙 트리를 베이스로 한 구현을 사용함.
- Binary Search Tree의 일종으로, 각 노드를 빨간색 혹은 검은색으로 맵핑하여 균형을 유지

<br/>

## 삽입

- 레드 블랙 트리에서 모든 새로운 노드는 빨간색 색상을 가진채로 삽입되어야 한다.
    - 추후 레드-블랙 트리의 조건에 맞게 다시 변경한다.
        - 이 과정에서 재색칠, 회전 등이 일어난다.
- 삽입 연산에 드는 시간은 그냥 일반적인 이진 트리와 비슷하다.
- 삽입 연산 이후 레드-블랙 트리의 모든 조건을 체크해봐야 한다.
- 만일 모든 조건이 충족된다면, 다음 연산으로 넘어가고, 아니라면 아래와 같은 연산을 실행하여 레드-블랙 트리로 만들어주어야 한다.
    - 재색칠
    - 회전
    - 재색칠 이후 회전

### 삽입 순서

1. 트리가 비었는지 확인한다.
    1. 트리가 비었다면, 검은색 루트 노드를 삽입한다.
    2. 트리가 비어있지 않다면, 빨간색 리프 노드를 삽입한다.
        1. 새 노드의 부모가 검은색이라면, 연산을 마친다.
        2. 새 노드의 부모가 빨간색이면, 새 노드의 부모의 형제를 확인한다.
            1. 새 노드 부모의 형제가 검은색 혹은 NULL이면, 적절한 회전과 재색칠을 한다.
            2. 새 노드 부모의 형제가 빨간색이면, 재색칠을 한다.

<br/><br/>

|  |  |
| --- | --- |
| 데이터들의 input 순서 보장 여부 | no |
| 중복된 데이터 허용 여부 | no |
| 데이터 정렬 여부 | yes |

<br/><br/>

### ⏰ 시간 복잡도

| function | 시간 복잡도 |
| --- | --- |
| 데이터 추가 | O(logN) |
| 데이터 검색 | O(logN) |
| 데이터 삭제 | O(logN) |

<br/><br/>
- 참고

[[이것이 자바다 추가 정리] 레드블랙 트리 정리](https://velog.io/@jakeseo_me/이것이-자바다-추가-정리-레드블랙-트리-정리)