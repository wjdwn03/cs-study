# 거품 정렬<sub> Bubble Sort</sub>

> **서로 인접한 두 원소**를 검사하여 정렬하는 알고리즘

</br>

<img src="./img/BubbleSort.gif">

### 특징
- 내부 정렬 알고리즘
- 제자리 정렬 - 별도의 메모리 공간이 필요하지 않음.
- 선택 정렬과 유사함.
- 안정 정렬

### 장점
- 구현이 간단하고 단순

### 단점
- 성능이 좋지 못함. 
    - 최악의 경우 시간 복잡도 O(N<sup>2</sup>)

### 동작 원리

1. 가장 왼쪽 원소부터 인접한 원소와 비교 시작
1. 오른쪽 원소가 왼쪽 원소보다 작은 경우 두 원소를 교환
    
    2-1. (마지막-1)번째와 마지막 원소까지 비교
1. 1번~2번 과정을 모든 원소가 정렬될 때까지 반복
- 정렬을 1회전 수행할 때마다 정렬에서 제외되는 데이터가 하나씩 늘어남.
     - 1회전을 수행하고 나면 가장 큰 원소가 가장 오른쪽으로 이동하기 때문에 2회전에서 맨 뒤(오른쪽)에 있는 원소는 정렬에서 제외
- 시간 복잡도
    - 아마도 평균, 최악의 경우 O(N<sup>2</sup>)
    - 최선의 경우 O(N)
- 공간 복잡도
    - 제자리 정렬(sorted in place)로 추가 공간을 사용하지 않음

### Bubble Sort 구현

<details>
<summary>java 코드</summary>
<div markdown="1">

```java
class sorting {
    
    public static void bubbleSort(int [] sort_arr, int len){
        
        for (int i=0;i<len-1;++i){

            for(int j=0;j<len-i-1; ++j){

                if(sort_arr[j+1]<sort_arr[j]){

                    int swap = sort_arr[j];
                    sort_arr[j] = sort_arr[j+1];
                    sort_arr[j+1] = swap;

                }
            }
        }
    }
    
    public static void main( String args[] ) {
        int [] array = {10,5,3,1,24,12};
        int len = array.length;
        bubbleSort(array,len);

        for(int i = 0; i<len; ++i){
            System.out.print(array[i] + " ");
        }
    }
}
```

</div>
</details>

</br>

### 복잡도<sub>Complexity</sub>
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
    <td><b>Bubble Sort</b></td>
    <td>O(N)</td>
    <td>O(N<sup>2</sup>)</td>
    <td>O(N<sup>2</sup>)</td>
    <td>O(1)</td>
  </tr>
</table>

</br>
</br>

- 참고

[Bubble Sort](https://medium.com/jungletronics/bubble-sort-ascendant-algorithm-5a3cf7b530f7)

[what is bubble sort in java](https://www.educative.io/answers/what-is-a-bubble-sort-in-java)