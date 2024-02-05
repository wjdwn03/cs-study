# :books: 정렬 <sub>Sorting</sub>

## :bookmark_tabs: 목차

[:arrow_up: **Algorithm**](./README.md)

1. ### 정렬 <sub>Sorting</sub>

   - [정의](#❓정의)
   - [:page_facing_up: 거품 정렬](./BubbleSort.md)
   - [:page_facing_up: 선택 정렬](./SelectionSort.md)
   - [:page_facing_up: 삽입 정렬](./InsertionSort.md)
   - [:page_facing_up: 퀵 정렬](./QuickSort.md)
   - [:page_facing_up: 병합 정렬](./MergeSort.md)
   - [:page_facing_up: 힙 정렬](./HeapSort.md)
   - [:page_facing_up: 기수 정렬](./RadixSort.md)
   - [:page_facing_up: 계수 정렬](./CountingSort.md)

</br>
</br>

# ❓정의
> 정렬 : 데이터의 집합을 특정한 기준에 따라 순서대로 나열하는 것.


1. `내부 정렬`<sub>Internal sort</sub>
	- 정렬하고자 하는 모든 데이터가 메모리에 올라와 정렬이 수행되는 방식
	- 데이터 양이 적을 때 메인 메모리 내에서 정렬하는 방법
	- 속도는 빠르나 정렬할 자료의 양이 많을 경우 부적합

1. `외부 정렬`<sub>External sort</sub>
	- 정렬하고자 하는 데이터가 너무 크기 때문에 일부만 올려놓은 상태에서 정렬한 것을 다시 합하는 방식

1. `제자리 정렬`<sub>In-place sort</sub>
	- 주어진 공간 외에 추가적인 공간을 사용하지 않는 정렬

1. `안정 정렬`<sub>Stable sort sort</sub>
	- 동일한 값에 대해 기존의 순서가 유지되는 정렬 방식

1. `불안정 정렬`<sub>Not stable sort</sub>
	- 동일한 값에 대해 기존의 순서가 뒤바뀔 수 있는 정렬 방식


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
    <tr>
    <td><b>Selection Sort</b></td>
    <td>O(N<sup>2</sup>)</td>
    <td>O(N<sup>2</sup>)</td>
    <td>O(N<sup>2</sup>)</td>
    <td>O(1)</td>
  </tr>
    <tr>
    <td><b>Insertion Sort</b></td>
    <td>O(N)</td>
    <td>O(N<sup>2</sup>)</td>
    <td>O(N<sup>2</sup>)</td>
    <td>O(1)</td>
  </tr>
    <tr>
    <td><b>Quick Sort</b></td>
    <td>O(NlogN)</td>
    <td>O(NlogN)</td>
    <td>O(N<sup>2</sup>) </br>피벗 값에 따라 </br>편향되게 분할하는 경우</td>
    <td>O(logN) ~ O(N)</td>
  </tr>
    <tr>
    <td><b>Merge Sort</b></td>
    <td>O(NlogN)</td>
    <td>O(NlogN)</td>
    <td>O(NlogN)</td>
    <td>O(N)</td>
  </tr>
    <tr>
    <td><b>Heap Sort</b></td>
    <td>O(NlogN)</td>
    <td>O(NlogN)</td>
    <td>O(NlogN)</td>
    <td>O(1)</td>
  </tr>
    <tr>
    <td><b>Radix Sort</b></td>
    <td>O(dN) </br> d : 최댓값의 자릿수</td>
    <td>O(dN)</td>
    <td>O(dN)</td>
    <td>O(N+d)</td>
  </tr>
    <tr>
    <td><b>Counting Sort</b></td>
    <td>O(N+k) </br> k : 최댓값</td>
    <td>O(N+k)</td>
    <td>O(N+k)</td>
    <td>O(N+k)</td>
  </tr>
</table>

</br>

