# :books: Binary Search Tree <sub>이진 탐색 트리</sub>

## :bookmark_tabs: 목차

[:arrow_up: **DataStructure**](./README.md)

1. ### [Binary Search Tree](#📕-binary-search-tree-bst-이진탐색-트리) <sub>BST, 이진탐색 트리</sub>

   - 정의
   - 특징
   - BST의 연산
   - 복잡도
   - 활용

# :closed_book: Binary Search Tree <sub>BST, 이진탐색 트리</sub>

## 정의

> 포함된 노드들<sub>Nodes</sub>의 키<sub>Key</sub>가 각 노드의 왼쪽 하위 트리<sub>Left Sub-tree</sub>의 모든 키보다 크고 오른쪽 하위 트리<sub>Right Sub-tree</sub>의 키보다 작은 정렬된 트리 구조<sub>Sorted Tree Structure</sub>

## 특징

![img:BST의 구조](./img/bst_01.png)

- 부모 노드를 기준으로 다음과 같은 규칙이 항상 적용되는 트리 구조
  - 왼쪽 자식 노드의 키는 부모 노드의 키보다 작다
  - 오른쪽 자식 노드의 키는 부모 노드의 키보다 크다
- 일반적으로 노드의 키 값 중복을 허용하지 않음
- 이진 탐색의 속성을 기본적으로 가지고 있어 정렬과 검색에 좋은 성능을 보임
- 트리 순회<sub>Traversal</sub> 방법에 따라 데이터의 정렬된 값을 얻을 수 있음
  - **중위 순회** <sub>Inorder tree walk</sub> : 왼쪽 자식 -> 부모 -> 오른쪽 자식 순서 방문, 순차로 정렬된 값을 얻음
  - **전위 순회** <sub>Preorder tree walk</sub> : 부모 -> 왼쪽 자식 -> 오른쪽 자식 순서 방문
  - **후위 순회** <sub>Postorder tree walk</sub> : 왼쪽 자식 -> 오른쪽 자식 -> 부모 순서 방문

## BST의 연산

### 탐색

**재귀 탐색**

```
Recursive-Tree-Search(node, key):
    if node == NIL or key == node.key:
        return node

    if key < node.key:
        return Recursive-Tree-Search(node.left, key)
    else:
        return Recursive-Tree-Search(node.right, key)
```

**반복 탐색**

```
Iterative-Tree-Search(node, key):
    while node != NIL and key != node.key:
        if key < node.key:
            node = node.left
        else:
            node = node.right

    return node
```

**이전값 탐색**

```
BST-Successor(node):
  if node.right != NIL:
    while node.right.right != NIL:
      node.right = node.right.right

    return node.right

  parent = node.parent
  while parent != NIL and node == parent.right:
    node = parent
    parent = parent.parent

  return y
```

**다음값 탐색**

```
BST-Predecessor(node):
  if node.left != NIL:
    while node.left.left != NIL:
      node.left = node.left.left

    return node.left

  parent = node.parent
  while parent != NIL and node == parent.left:
    node = parent
    parent = parent.parent

  return parent
```

### 삽입

```
BST-Insert(tree, node):
  y = NIL
  x = tree.root

  while x != NIL:
    y = x
    if node.key < x.key:
      x = x.left
    else:
      x = x.right

  node.parent = y
  if y = NIL:
    tree.root = node
  else if node.key < y.key:
    y.left = node
  else
    y.right = node
```

### 삭제

```
BST-Delete(tree, node):
  if node.left == NIL:
    Shift-Nodes(tree, node, node.right)
  else if node.right == NIL:
    Shift-Nodes(tree, node, node.left)
  else:
    E = BST-Successor(node)
    if E.parent != node:
      Shift-Nodes(tree, E, E.right)
      E.right = node.right
      E.right.parent = E

    Shift-Nodes(tree, node, E)
    E.left = node.left
    E.left.parent = E
```

```
Shift-Nodes(tree, u, v)
  if u.parent == NIL:
    tree.root = v
  else if u == u.parent.left:
    u.parent.left = v
  else:
    u.parent.right = v

  if v != NIL:
    v.parent = u.parent
```

## 복잡도

| 연산 종류             | 평균<sub>Avg</sub> | 최악<sub>Worst</sub> |
| --------------------- | ------------------ | -------------------- |
| 공간<sub>Space</sub>  | `O(N)`             | `O(N)`               |
| 탐색<sub>Search</sub> | `O(logN)`          | `O(N)`               |
| 삽입<sub>Insert</sub> | `O(logN)`          | `O(N)`               |
| 삭제<sub>Delete</sub> | `O(logN)`          | `O(N)`               |

- `N`은 트리에 포함된 노드의 개수
- 트리의 높이의 영향을 받아 높이에 따른 평균 시간 복잡도인 `O(logN)`을 가짐
- 트리의 좌우 균형이 한쪽으로 치우친 경우, 트리의 높이가 최대 `N`까지 가질 수 있으므로 최악의 경우 시간 복잡도는 `O(N)`

## 활용

- DB 색인에 사용(요즘에는 잘 사용 안 함, B-tree)
- 검색 알고리즘 구현
- 데이터 캐싱
- 우선순위 대기열 구현
