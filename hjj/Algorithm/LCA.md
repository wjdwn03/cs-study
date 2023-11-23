# LCA<sub> Lowest Common Ancestor, 최소 공통 조상</sub>

> 이름 그대로 두 노드에서 가장 가까운 공통 조상을 찾는 알고리즘


### 특징

</br>

### 장점

</br>

### 단점

</br>

### 동작 원리
1. 모든 노드에 대한 깊이(depth)를 계산
1. 최소 공통 조상을 찾을 두 노드를 확인
    - 먼저 두 노드의 깊이가 동일하도록 거슬러 올라감.
    - 이후에 부모가 같아질 때까지 반복적으로 두 노드의 부모 방향으로 거슬러 올라감.
1. 모든 LCA(a, b) 연산에 대하여 2번의 과정을 반복

### 기본 LCA 구현

### DP로 구현
- 메모리를 조금 더 사용하여 시간을 logN까지 줄일 수 있음.

</br>

### 복잡도<sub>Complexity</sub>
- M : 쿼리 연산의 수
<table style="text-align:center">
  <tr>
    <td ></td>
    <td colspan="3">시간 복잡도</td>
    <td rowspan="2">공간 복잡도</td>
  </tr>
  <tr>
    <td></td>
    <td >최선</td>
    <td>평균</td>
    <td>최악</td>
  </tr>
  <tr>
    <td><b>기본 LCA</b></td>
    <td>O(NM)</td>
    <td>O(NM)</td>
    <td>O(NM)</td>
    <td>O(N)</td>
  </tr>
    <tr>
    <td><b>DP로 구현한 LCA</b></td>
    <td>O(MlogN)</td>
    <td>O(MlogN)</td>
    <td>O(MlogN)</td> 
    <td>O(MlogN)</td>
  </tr>
</table>


</br>
</br>

- 참고

[알고리즘 LCA](https://g-egg.tistory.com/11)

