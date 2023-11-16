# :books: 정렬 <sub>Sorting</sub>

## :bookmark_tabs: 목차

[:arrow_up: **Algorithm**](./README.md)

1. ### 정렬 <sub>Sorting</sub>

   - [정의](#❓정의)
   - [거품 정렬](#거품-정렬-bubble-sort)
   - [선택 정렬](#선택-정렬-selection-sort)
   - [삽입 정렬](#삽입-정렬-insertion-sort)
   - [퀵 정렬](#퀵-정렬-quick-sort)
   - [병합 정렬](#병합-정렬-merge-sort)
   - [힙 정렬](#힙-정렬-heap-sort)
   - [기수 정렬](#기수-정렬-radix-sort)
   - [계수 정렬](#계수-정렬-count-sort)

# ❓정의
> 데이터의 집합을 특정한 기준에 따라 순서대로 나열하는 것.

# 거품 정렬<sub> Bubble Sort</sub>
<img src="./img/BubbleSort.gif">

- **서로 인접한 두 원소**를 검사하여 정렬하는 알고리즘   
- 내부 정렬 알고리즘
    - 정렬 시 추가 공간이 필요하지 않으며 배열 자체가 수정됨.
- 선택 정렬과 유사함.

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

# 선택 정렬<sub> Selection Sort</sub>
<img src="./img/SelectionSort.gif">

- 해당 순서에 원소를 넣을 위치는 이미 정해져 있고, 어떤 원소를 넣을지 선택하는 알고리즘
- 내부 정렬 알고리즘
    - 정렬 시 추가 공간이 필요하지 않으며 배열 자체가 수정됨.
- 전체 모든 원소를 스캔하기 때문에 삽입 정렬<sub>Insertion Sort</sub>보다 느림
- 시간 복잡도
    - 평균, 최선, 최악의 경우 모두 O(N<sup>2</sup>)

### 동작 원리
1. 가장 왼쪽에 있는 원소부터 기준 원소가 됨.
1. 기준 원소보다 오른쪽에 있는 원소 중 가장 작은 값을 찾음.
1. 가장 작은 원소와 기준 원소를 교환.
1. 기준 원소를 인접한 오른쪽 원소로 변경하고 위 과정을 기준 원소가 마지막 원소가 될 때까지 반복

### Selection Sort 구현

<details>
<summary>java 코드</summary>
<div markdown="1">

```java
class SelectionSort{
 
  static void Selection_Sort(int arr[], int n)  
  {
    for(int i = 0; i < n - 1; ++i)  
    {
      int min_index = i;  
      for(int j = i + 1; j < n; ++j)  
      {
        if(arr[j] < arr[min_index])  
          min_index = j;
      }
      int temp = arr[i];
      arr[i] = arr[min_index];
      arr[min_index] = temp;
    }
  }
 
  // Driver code
  public static void main(String[] args)
  {
    int n = 5;
    int arr[] = {2, 0, 1, 4, 3};
    Selection_Sort(arr, n);
    System.out.print("The Sorted Array by using Selection Sort is : ");
    for(int i = 0; i < n; ++i)
      System.out.print(arr[i] + " ");
  }
}
```

</div>
</details>

</br>

# 삽입 정렬<sub> Insertion Sort</sub>
<img src="./img/InsertionSort.gif">

- 새로운 원소를 이전까지 정렬된 원소 사이에 올바르게 삽입시키는 알고리즘
- 내부 정렬 알고리즘
    - 정렬 시 추가 공간이 필요하지 않으며 배열 자체가 수정됨.
- 선택 정렬<sub>Selection Sort</sub>보다 빠름
    - 필요한 데이터만 스캔하기 때문
- 시간 복잡도
    - 평균, 최악의 경우 O(N<sup>2</sup>)
    - 최선의 경우 O(N)

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

# 퀵 정렬<sub> Quick Sort</sub>
<img src="./img/QuickSort.gif">

- 내부 정렬 알고리즘
- 기준키를 기준으로 작거나 같은 값을 지닌 데이터는 앞으로, 큰 값을 지닌 데이터는 뒤로 가도록 하여 작은 값을 갖는 데이터와 큰 값을 갖는 데이터로 분리해가며 정렬하는 방법
- 선택, 버블, 삽입 정렬은 모두 O(N<sup>2</sup>)의 시간 복잡도를 가지고 있기 때문에 더욱 빠른 정렬 알고리즘을 필요로 할 때 주로 사용하는 알고리즘.
- 대표적인 '분할 정복' 알고리즘
- 하나의 큰 문제를 두 개의 작은 문제로 분할하는 식으로 빠르게 정렬
    - 즉, 특정한 값을 기준으로 큰 숫자와 작은 숫자를 서로 교환한 뒤에 배열을 반으로 나눔.
- 분할 정복 방식을 사용한다는 점에서 merge sort와 개념적으로 유사
- 차이점은 파티셔닝이 수행되는 방식과 하위 리스트가 적절한 상대적 순서로 유지되므로 병합이 필요하지 않다는 것
- 시간 복잡도 
    - 평균 시간 복잡도 : O(NlogN)
    - 최악의 경우 : O(N<sup>2</sup>) -> 피벗 값에 따라 편향되게 분할하는 경우

### Quick Sort 구현

<details>
<summary>java 코드</summary>
<div markdown="1">

```java
import java.util.*;
class Quick_Sort {
    
  public static int[] QuickSort(int[] arr, int elements) {
      if(elements < 2){     //Base Case
          return arr;
      }

      int current_position=0;   //position of pivot element
      int temp; //a temporary variable to assist in swapping

      for(int i=1; i<elements; i++) //Partitioning loop
      {
          if(arr[i] <= arr[0])
          {
              current_position++;
              temp = arr[i];
              arr[i] = arr[current_position];
              arr[current_position] = temp;

          }
      }

      temp = arr[0]; 
      arr[0] = arr[current_position]; 
      arr[current_position] = temp; //Brings pivot to it's appropriate position
      
      int[] left = QuickSort(arr,current_position); //sorts the elements to the left of pivot
      
      int[] arr2 = Arrays.copyOfRange(arr, current_position+1, elements);//separates elements right of pivot
      
      int[] right = QuickSort(arr2, elements-current_position-1); //sorts the elements to the right of pivot
      
      int[] final_array = new int[elements]; //final array, to merge everything together
      
      for(int i=0; i<current_position; i++)
      {
          final_array[i] = left[i]; 
      }
      final_array[current_position] = arr[current_position];
      for(int i=current_position+1; i<elements; i++)
      {
          final_array[i] = right[i-current_position-1];
      }

    return final_array;

  }

    public static void main( String args[] ) {
        int[] array = {4,2,7,3,1,6}; //array to be sorted
        System.out.print("Original Array: [");
        for(int i=0; i<array.length;i++)
        {   
            System.out.print(array[i]);
            System.out.print(" ");
        }
        System.out.println("]");



        array = QuickSort(array, array.length);//sorting 
        
        System.out.print("Sorted Array: ["); //printing the sorted array
        for(int i=0; i<array.length;i++)
        {   
            System.out.print(array[i]);
            System.out.print(" ");
        }
        
        System.out.print("]");
    }
}
```

</div>
</details>

</br>

# 병합 정렬<sub> Merge Sort</sub>
<img src="./img/MergeSort.gif">

- 주어진 데이터들을 몇 부분으로 분할한 다음 각각을 재귀적으로 정렬하고, 두 부분을 합쳐서 하나로 만드는 방법
- 주로 외부 정렬에 활용
- 퀵 정렬과 마찬가지로 '분할 정복' 방법을 채택

# 힙 정렬<sub> Heap Sort</sub>

- 완전 이진트리의 최대 힙 재구성 시 트리 깊이만큼 수행하므로 O(logn)만큼의 수행시간이 소요되며, 최악 시간복잡도와 최선 시간복잡도 및 평균 시간복잡도가 모두 동일


# 기수 정렬<sub> Radix Sort</sub>


# 계수 정렬<sub> Count Sort</sub>



- 참고

[Bubble Sort](https://medium.com/jungletronics/bubble-sort-ascendant-algorithm-5a3cf7b530f7)

[what is bubble sort in java](https://www.educative.io/answers/what-is-a-bubble-sort-in-java)

[정렬 알고리즘](https://devjourney7.tistory.com/132)