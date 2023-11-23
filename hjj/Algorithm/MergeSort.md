# 병합 정렬<sub> Merge Sort</sub>

### ❓정의
- 주어진 데이터들을 몇 부분으로 분할한 다음 각각을 재귀적으로 정렬하고, 두 부분을 합쳐서 하나로 만드는 방법

<img src="./img/MergeSort.gif">

### 특징
- 주로 외부 정렬에 활용
- 퀵 정렬과 마찬가지로 '분할 정복' 방법을 채택
- 실행 시에 저장 공간을 필요로 함. 따라서 추가 공간이 없는 경우 quick sort를 하는 것이 좋음.

### 장점
- 입력 데이터의 상태에 상관없이 일정한 성능을 보이며, 안정적인 정렬을 보장

### 단점
- 임시 배열이 필요하기 때문에 추가 메모리가 요구되어 높은 공간 복잡도를 가짐.


### 동작 원리

1. 분할(divide) - 정렬되지 않은 초기 리스트를 길이가 1이 될 때까지 계속 둘로 쪼갬.
1. 정복(conquer) - 분할한 부분 리스트를 정렬
1. 병합(combine) - 정렬된 부분 리스트들을 하나의 리스트에 병합(merge)

<details>
<summary><b>동작 과정 이미지</b></summary>
<div markdown="1">
<p align="center">  
<img src="./img/MergeSortProcedure1.png" align="center" width="48%">  
<img src="./img/MergeSortProcedure2.png" align="center" width="48%">
</p>

-------


<p align="center">  
<img src="./img/MergeSortProcedure3.png" align="center" width="48%">  
<img src="./img/MergeSortProcedure4.png" align="center" width="48%">
</p>

-------


<p align="center">  
<img src="./img/MergeSortProcedure5.png" align="center" width="48%">  
<img src="./img/MergeSortProcedure6.png" align="center" width="48%">
</p>

-------


<p align="center">  
<img src="./img/MergeSortProcedure7.png" align="center" width="48%">  
<img src="./img/MergeSortProcedure8.png" align="center" width="48%">
</p>

-------


<p align="center">  
<img src="./img/MergeSortProcedure9.png" align="center" width="48%">  
<img src="./img/MergeSortProcedure10.png" align="center" width="48%">
</p>

-------


<p align="center">  
<img src="./img/MergeSortProcedure11.png" align="center" width="48%">  
<img src="./img/MergeSortProcedure12.png" align="center" width="48%">
</p>

-------


<p align="center">  
<img src="./img/MergeSortProcedure13.png" align="center" width="48%">  
<img src="./img/MergeSortProcedure14.png" align="center" width="48%">
</p>

-------


<p align="center">  
<img src="./img/MergeSortProcedure15.png" align="center" width="48%">  
<img src="./img/MergeSortProcedure16.png" align="center" width="48%">
</p>

-------

<p align="center">  
<img src="./img/MergeSortProcedure17.png" align="center" width="48%">  
<img src="./img/MergeSortProcedure18.png" align="center" width="48%">
</p>

-------


<p align="center">  
<img src="./img/MergeSortProcedure19.png" align="center" width="48%">  
<img src="./img/MergeSortProcedure20.png" align="center" width="48%">
</p>

-------


<p align="center"> 
<img src="./img/MergeSortResult.png" align="center" width="80%">
</p>

</div>
</details>

</br>

### Merge Sort 구현

<details>
<summary>java 코드</summary>
<div markdown="1">

```java
import java.util.Arrays;

public class MergeSort {

	private static void mergeSort(int[] arr) {
		int[] tmp = new int[arr.length]; // 임시 저장소

		// 재귀 호출 시작
		mergeSort(arr, tmp, 0, arr.length - 1);
	}

	private static void mergeSort(int[] arr, int[] tmp, int start, int end) {

		if (start < end) {
			int mid = (start + end) / 2;
			
			// 둘로 쪼갬.
			mergeSort(arr, tmp, start, mid);
			mergeSort(arr, tmp, mid + 1, end);
			
			// 둘로 나뉜 배열을 병합
			merge(arr, tmp, start, mid, end);
		}

	}

	private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {

		for (int i = start; i <= end; i++) {
			tmp[i] = arr[i];
		}

		// 두 부분 배열이 mid 값을 기준으로 위치가 맞붙어 있음.
		int part1 = start;
		int part2 = mid + 1;
		int index = start;
		
		// 두 부분 배열 중 하나라도 끝까지 간다면 더 이상 볼 필요가 없음.
		while(part1<=mid && part2<=end) {
			
			// 두 부분 배열의 가장 작은 수끼리 비교하여 더 적은 수를 넣어줌.
			
			if(tmp[part1] <= tmp[part2]) {
				arr[index] = tmp[part1];
				part1++;
			}
			else {
				arr[index] = tmp[part2];
				part2++;
			}
			index++;
		}
		for(int i=0; i<=mid-part1; i++) {
			arr[index+i] = tmp[part1+i];
		}
	}

	public static void main(String[] args) {
		
		int[] arr = {1, 17, 14, 3, 29, 10, 5, 41};
		
		System.out.println("Before Merge Sort");
		System.out.println(Arrays.toString(arr));
		
		mergeSort(arr);
		
		System.out.println("After Merge Sort");
		System.out.println(Arrays.toString(arr));

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
    <td><b>Merge Sort</b></td>
    <td>O(NlogN)</td>
    <td>O(NlogN)</td>
    <td>O(NlogN)</td>
    <td>O(N)</td>
  </tr>
</table>


</br>
</br>

- 참고


[정렬 알고리즘](https://devjourney7.tistory.com/132)