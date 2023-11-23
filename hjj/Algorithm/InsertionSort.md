# 삽입 정렬<sub> Insertion Sort</sub>

### >❓정의
- 새로운 원소를 이전까지 정렬된 원소 사이에 올바르게 삽입시키는 알고리즘

<img src="./img/InsertionSort.gif">


### 특징

- 내부 정렬 알고리즘
- 안정정렬<sub>Stable sort</sub>
- 제자리 정렬<sub>In-place sort</sub>로 추가 공간을 사용하지 않음

### 장점
- 알고리즘이 단순
- 선택 정렬<sub>Selection Sort</sub>나 거품 정렬<sub>Bubble Sort</sub>과 같은 O(N<sup>2</sup>) 알고리즘에 비교하여 상대적으로 빠름.
    - 필요한 데이터만 스캔하기 때문

### 단점
- 평균과 최악의 시간복잡도가 O(N<sup>2</sup>)으로 비효율적
- 선택 정렬<sub>Selection Sort</sub>나 거품 정렬<sub>Bubble Sort</sub>과 마찬가지로, 배열의 길이가 길어질수록 비효율적


### 동작원리
1. 2번째 원소부터 시작
1. 이전까지 정렬된 원소들(왼쪽에 있는 원소들)과 비교하여 삽입할 위치를 찾음.
1. 해당 위치로 옮기고 그 다음 원소도 2번 과정을 통해 위치를 찾아서 옮겨줌.

### Insertion Sort 구현

<details>
<summary>java 코드</summary>
<div markdown="1">

```java
class InsertionSort {

    public static void sortInsertion(int [] sort_arr){

      for(int i=0;i<sort_arr.length;++i){

        int j = i;
        
        while(j > 0 && sort_arr[j-1]>sort_arr[j]){

          int key = sort_arr[j];
          sort_arr[j] = sort_arr[j-1];
          sort_arr[j-1] = key;
          j = j-1; 

        }
      }
    }

    public static void main( String args[] ) {
        int [] arr = {5,2,12,12,1};
        sortInsertion(arr);

        for(int i=0;i<arr.length;++i){
          System.out.print(arr[i] + " ");
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
    <td><b>Insertion Sort</b></td>
    <td>O(N)</td>
    <td>O(N<sup>2</sup>)</td>
    <td>O(N<sup>2</sup>)</td>
    <td>O(1)</td>
  </tr>
</table>

</br>
</br>

- 참고


[정렬 알고리즘](https://devjourney7.tistory.com/132)