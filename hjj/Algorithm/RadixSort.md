# 기수 정렬<sub> Radix Sort</sub>

### ❓정의
- 자릿수를 기준으로 정렬하는 방식

### 특징

- k(원소 중 최댓값)가 작을 때는 counting sort(계수 정렬)를, k가 클 때는 quick sort를 사용하는 것이 좋음.
    - counting sort는 과정 중에 사용하는 누적 count 배열의 길이가 k이기 때문에 k가 큰 경우엔 비효율적일 수도 있음.
    - quick sort는 분할해서 정렬하기 때문에 k가 큰 경우 quick sort가 더 나을수도 있음.
- 안정 정렬

### 장점
- 비교 연산을 하지 않으며 안정성을 가지는 정렬
- 이론상 시간 복잡도가 $O(N log N)$ 을 넘을 수 없음.
- 문자열과 정수는 거의 정렬할 수 있음.

### 단점
- 부동 소수점 실수처럼 특수한 비교 연산이 필요한 데이터에는 적용할 수 없음(데이터 타입이 한정적)
- 중간 결과를 저장할 bucket 공간이 필요


### 동작 원리
1. 주어진 원소 중에서 최댓값의 자릿수까지를 기준으로 정렬

    - 1의 자리부터 d번째 자리까지를 기준으로 정렬

<p align="center">
<img src="./img/RadixSortProcedure.png" width="80%">
</p>

</br>

### Radix Sort 구현
<details>
<summary>java 코드</summary>
<div markdown="1">

```java
import java.util.ArrayDeque;
import java.util.Arrays;

public class RadixSort {
	
	static ArrayDeque<Integer>[] buckets = new ArrayDeque[10];
	
	static void radixSort(int[] arr) {
		int div = 10;
		while(div < 100000) {
			for(int i=0;i<arr.length;i++) 
				buckets[(arr[i]/div)%10].offer(arr[i]);

	
			for(int i=0, bi=0;i<10;i++) {
				while(buckets[bi].isEmpty())
					bi++;
				arr[i]=buckets[bi].poll();
			}
			div *= 10;
		}	
	}

	public static void main(String[] args) {
		for(int i=0;i<10;i++)
			buckets[i] = new ArrayDeque<>();
		
		int[] arr = {48081, 97342, 90287, 90583, 53202, 65215, 78397, 48001, 972, 65315};
		
		System.out.print("정렬 전 arr : ");
		System.out.println(Arrays.toString(arr));	
		// [48081, 97342, 90287, 90583, 53202, 65215, 78397, 48001, 972, 65315]
        
		radixSort(arr);
		
		System.out.print("정렬 후 arr : ");
		System.out.println(Arrays.toString(arr));	
		// [972, 48001, 48081, 53202, 65215, 65315, 78397, 90287, 90583, 97342]
	}
}
```

</div>
</details>


</br>

### 복잡도<sub>Complexity</sub>

* d : 최댓값의 자릿수

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
    <td><b>Radix Sort</b></td>
    <td>O(dN)</td>
    <td>O(dN)</td>
    <td>O(dN)</td>
    <td>O(N+d)</td>
  </tr>
</table>


</br>
</br>

- 참고

[정렬의 뜻, 정렬 알고리즘 분류 방법](https://hellowoori.tistory.com/48)

[[Algorithm] 정렬 : Counting sort(계수 정렬), Radix sort(기수 정렬)](https://velog.io/@wjdqls9362/Algorithm-%EC%A0%95%EB%A0%AC-Radix-sort-Counting-sort)

[[정렬 알고리즘] 05 계수 및 기수 정렬(Counting Sort / Radix Sort) 이론 및 구현](https://rninche01.tistory.com/entry/%EC%A0%95%EB%A0%AC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-05-%EA%B3%84%EC%88%98-%EB%B0%8F-%EA%B8%B0%EC%88%98-%EC%A0%95%EB%A0%ACCounting-Sort-Radix-Sort)

[기수 정렬(Radix sort)](https://gyoogle.dev/blog/algorithm/Radix%20Sort.html)

[기수 정렬](https://velog.io/@jangws/12.-%EA%B8%B0%EC%88%98-%EC%A0%95%EB%A0%ACRadix-sort-JS)