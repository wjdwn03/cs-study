
# sorting 📚 정렬 <sub> sort</sort>
정렬이란? 일정한 규칙성을 전제로하여 데이터의 순서를 지정하고 이를 배치시키는 것.

# 정렬의 시간복잡도 <sub> time-complexity </sub>
<img src="https://gmlwjd9405.github.io/images/algorithm-insertion-sort/sort-time-complexity.png">


# 삽입 정렬 Insertion Sort 

전제조건 : 오름차순을 기본으로 전제한다.
- 예시 
<img src="https://gmlwjd9405.github.io/images/algorithm-insertion-sort/insertion-sort.png">

2중 for문을 사용하여 쉽게 구현 가능하다.
2개부터 상호 비교가 가능하기때문에 for의 start idx는 0이 아닌 1부터 시작하도록 한다. 

- 예시
    배열[5,6,4,6,2]<br>
    6부터 비교시작[5]<br>
    1. 정렬된 5에 대하여 크지 않으므로 유지-> 0+1에 6추가 [5,6]<br>
    2. 4는 정렬된 5,6에 대해 둘다 크므로 -1+1=0 에 추가 [4,5,6]<br>
    3. ...같은 방식으로. 진행<br>


<details>
<summary> 코드</summary>
<div markdown="1">

```

public void sort_insert(int arr[]){
int sz=arr.length;

for(int s=1;s<sz;s++){// s+1는 정렬된 배열의 크기를 의미한다.

int selected= arr[s];// 배열에 추가할 원소를 지정하여
int z;
for( z=s-1;s>=0&&arr[j]>selected;z--){// 이전에 정렬해놓은 배열에 대해서 
// 추가할 원소보다 이미 정렬된 원소가 더 크다.= [1,8]의 경우 3이 selected값이면 삽입될 값을 위해 뒤로 한 칸 물러나준다.(이는 선택된 값보다 큰 값을 가지며 동시에 정렬된 배열안에 속한다는 조건을 가지는 모든 원소가 뒤로 물러나야함)
arr[z+1]= arr[z];// 후진 
}
arr[z+1]=selected;// 3개의 정렬된 원소에 대해 내가 넣을 원소보다 2개가 더 크다-> z값은 (1,3,4에 2를 넣는 상황 ) s=3 , 에서 시작하여 2에서 2개가 크므로 0을 반환하여 0+1인 1번 idx에 2가 들어가야한다.  


}// outer for end



}// method end


```

</div>
</details>

- 데이터의 수가 작을 때 또는 대다수의 sort가 이뤄진 상태인 경우 또는 구현할 시간이 별로 없을 때 사용하면 유용한 정렬기법임.
- 단점으로는 데이터간의 이동이 잦기 때문에 크기가 커질수록 비효율적임

# 거품 정렬 Bubble Sort
- 서로 인접한 두 원소를 비교하여 정렬하는 알고리즘 (선택정렬과 비슷함)+(규칙은 본인이 정하는 것이지만 대부분 왼쪽과 오른쪽중 오른쪽이 크면 swap한다.)
- 위의 연산을 배열 끝까지 진행하면 가장 큰 데이터가 맨 뒤로 이동하므로 이 데이터를 제외한 다음 다시 연산을 돌리는 구조임.
<img src="https://gmlwjd9405.github.io/images/algorithm-bubble-sort/bubble-sort.png">

[6,8,2,3,5]-> 예상결과[2,3,5,6,8]<br>
1라운드 - key<br>
1-1 6과 8 ->유지(6<8)[6,8,2,3,5]<br>
1-2 8과2 -> 교체[6,2,8,3,5]<br>
1-3 8과3 -> 교체 [6,2,3,8,5]<br>
1-4 8과 5-> 교체 [6,2,3,5,8]<br>
<---> 5번원소 제외 : [6,2,3,5]<br>
2-1 6과 2 -> 교체 [2,6,3,5]<br>
2-2 6과 3 -> 교체 [2,3,6,5]<br>
2-3 6과 5 -> 교체 [2,3,5,6]<br>
<---> 4번원소 제외<br>
3번부터는 이미 sort이므로 pass 하겠음.<br>
<details>
<summary> 코드</summary>
<div markdown="1">

```
public void sort_bubble(int[] arr,int n){

for(int s=n-1;s>0;s--){// 끝에 최대값이 오므로 

for(int z=0;z<s;z++){

if(arr[z]>arr[z+1]){

int temp=0;
temp= arr[z];
arr[z]=arr[z+1];
arr[z+1]=temp;

}// swap 

}

}


}


```

</div>
</details>

# 선택 정렬 Selection Sort

주어진 배열에서 최소값을 찾아서 이를 추출하여 맨앞과 교체 카운팅 후 연산 반복..
<img src="https://gmlwjd9405.github.io/images/algorithm-selection-sort/selection-sort.png">

위 연산은 쉬우므로 pass하겠음

<details>
<summary> 코드</summary>
<div markdown="1">

```
  for(i=0; i<n-1; i++){// 기본 오름차순이므로 역순을 하면 안됨
    least = i;

    // 최솟값을 탐색한다.
    for(j=i+1; j<n; j++){
      if(list[j]<list[least])
        least = j;
    }

    // 최솟값이 자기 자신이면 자료 이동을 하지 않는다.
    if(i != least){
        SWAP(list[i], list[least], temp);
    }
  }



```

</div>
</details>

# 셸 정렬 Shell Sort

- 삽입정렬 보완한 정렬임.
- 삽입위치가 현위치에서 멀면 1칸씩 이동하는 낭비가 발생함.(전체리스트에 대한 정렬을 하려하기 때문!)
- 부분갭을 두면서 그 간격을 줄여가며 정렬을 해나가는 정렬기법
- 간격을 절반으로 줄일 때 짝수가 나오면 +1을 해서 홀수로 만든다.(추천)
https://gmlwjd9405.github.io/2018/05/08/algorithm-shell-sort.html
  <img src="https://gmlwjd9405.github.io/images/algorithm-shell-sort/shell-sort-concepts.png">

  - DP와 유사한 방식이다.
  - 작은 정렬은 삽입정렬을 사용하되 큰 갈래는 셸로 나눠서 한다는 것?
  - 배열 [5,8,2,9,1,2,30,29,11,12,4]에 대하여 간격은 n/2=5로 지정 
    0번,5번,10번 원소가 하나의 리스트가 된다.-> [5,2,4]-> 정렬시 [2,4,5]<br>
    1번과 6번 [8,30]-> 유지<br>
    2번과 7번 [2,29]<br>
    3번과 8번 [9,11]<br>
    4번과 9번 [1,12]~ 모두 유지<br>
    <---> 1라운드 [2,8,2,9,1,4,30,29,11,12,5] 간격 축소 ->5/2=2 짝수이므로 ++ -> 3 의 간격 <br>
    2,9,30,12-> 2,9,12,30<br>
    8,1,29,5-> 1,8,5,29<br>
    2,4,11-> 2,4,11<br>
    -> [2,1,2,9,8,4,12,5,11,30,29]<br>
    <2라운드> 간격 1이므로 배열 전체에 대한 삽입정렬 실시

<details>
<summary> 코드</summary>
<div markdown="1">

```
void inc_insertion_sort(int list[], int first, int last, int gap){// 내부 삽입정렬 
  int i, j, key;

  for(i=first+gap; i<=last; i=i+gap){// 부분 리스트 원소 순회

    key = list[i]; // 현재 삽입될 숫자인 i번째 정수를 key 변수로 복사

    // 현재 정렬된 배열은 i-gap까지이므로 i-gap번째부터 역순으로 조사한다.
    // j 값은 first 이상이어야 하고
    // key 값보다 정렬된 배열에 있는 값이 크면 j번째를 j+gap번째로 이동
    for(j=i-gap; j>=first && list[j]>key; j=j-gap){// 정렬된 부분 리스트에 대해서만 
      list[j+gap] = list[j]; // 레코드를 gap만큼 오른쪽으로 이동
    }

    list[j+gap] = key;
  }
}

// 셸 정렬
void shell_sort(int list[], int n){
  int i, gap;

  for(gap=n/2; gap>0; gap=gap/2){
    if((gap%2) == 0)(
      gap++; // gap을 홀수로 만든다.
    )

    // 부분 리스트의 개수는 gap과 같다.
    for(i=0; i<gap; i++){
      // 부분 리스트에 대한 삽입 정렬 수행
      inc_insertion_sort(list, i, n-1, gap);
    }
  }
}


```

</div>
</details>


    

# 퀵 정렬 Quick Sort

- 아래의 병합과 다르게 리스트를 비균등하게 자른다.
- 분할정복 알고리즘(대충 재귀쓴다는 뜻)
- 리스트 안의 한 원소를 지정해(피봇) 왼쪽은 피봇보다 작은수 오른쪽은 피봇보다 큰수를 그냥 옮긴다.
- 나뉘어진 리스트에 대해 반복적 수행.
  <img src="https://gmlwjd9405.github.io/images/algorithm-quick-sort/quick-sort.png">
- 예시 그림
  <img src="https://gmlwjd9405.github.io/images/algorithm-quick-sort/quick-sort2.png">

  <details>
<summary> 코드</summary>
<div markdown="1">

```
코드 추가 예정


```

</div>
</details>



# 병합 정렬 Merge Sort
- '분할정복' 알고리즘이다.
  <img src="https://gmlwjd9405.github.io/images/algorithm-merge-sort/merge-sort-concepts.png">

  반으로 분할해가면서 다시 붙이면서 부분적 sort해가기 2개의 리스트는 내부적으로 정렬이 보증되므로 첫 원소끼리의 비교만 하면된다.
  <img src="https://gmlwjd9405.github.io/images/algorithm-merge-sort/merge-sort.png">

<details>
<summary> 코드</summary>
<div markdown="1">

```
void merge(int list[], int left, int mid, int right){
  int i, j, k, l;
  i = left;
  j = mid+1;
  k = left;

  /* 분할 정렬된 list의 합병 */
  while(i<=mid && j<=right){
    if(list[i]<=list[j])// 두개의 리스트중 작은거 골라서
      sorted[k++] = list[i++];// 최종본에 적기
    else
      sorted[k++] = list[j++];// 너도밤나무
  }

  // 남아 있는 값들을 일괄 복사
  if(i>mid){
    for(l=j; l<=right; l++)
      sorted[k++] = list[l];
  }
  // 남아 있는 값들을 일괄 복사
  else{
    for(l=i; l<=mid; l++)
      sorted[k++] = list[l];
  }
// 정렬된 값 나머지 남은경우 예외처리 

  // 배열 sorted[](임시 배열)의 리스트를 배열 list[]로 재복사
  for(l=left; l<=right; l++){
    list[l] = sorted[l];
  }
}
void merge_sort(int list[], int left, int right){// 좌:0, 우: n-1 에서 시작..
  int mid;

  if(left<right){
    mid = (left+right)/2 // 중간 위치를 계산하여 리스트를 균등 분할 -분할(Divide)
    merge_sort(list, left, mid); // 앞쪽 부분 리스트 정렬 -정복(Conquer)
    merge_sort(list, mid+1, right); // 뒤쪽 부분 리스트 정렬 -정복(Conquer)
    merge(list, left, mid, right); // 정렬된 2개의 부분 배열을 합병하는 과정 -결합(Combine)
  }
}
// sorted list같은 전역변수를 사용하는 것이 좋다..

```

</div>
</details>

// 보충할 예정임 



# 힙 정렬 Heap Sort

자료구조 heap을 사용해서 정렬을 하는 기법.
내림차순= 최대힙, 오름차순 = 최소힙(루트 최소값)
힙의 구현은 datastructure 폴더의 heap관련 파일을 읽는다. 
//https://gmlwjd9405.github.io/2018/05/10/algorithm-heap-sort.html 
또는 위의 링크에서 보도록..



# 기수 정렬 Radix Sort
1. 0~9 까지의 Bucket(Queue 자료구조의)을 준비한다.
2. 모든 데이터에 대하여 가장 낮은 자리수에 해당하는 Bucket에 차례대로 데이터를 둔다.
3. 0부터 차례대로 버킷에서 데이터를 다시 가져온다.
4. 가장 높은 자리수를 기준으로 하여 자리수를 높여가며 2번 3번 과정을 반복한다.

   <img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F9957483359CE33AB14">
   <img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F9913633359CE34C223">

  큐에서 차례대로 추출하면 완료. 
  
# 계수 정렬 Count Sort

위의 정렬법들은 모두 의사결정트리에 따른 비교를 전제로 무결성을 보증한다.
하지만 의사결정트리의 최고효율인 nlogn을 극복하기위해 값의 비교를 포기하고 다른 방법으로 정렬을 구현한다면? 
<특정값이 몇 번 등장했는지에 따른 정렬방법>(복잡도= 1회탐색 N+K(최대값))
입력받은 배열 A, 등장횟수 전용 B , output 배열 C를 요구한다.
1. A에서 값을 꺼내 B의 idx로 사용해 B의 요소를 하나 증가시킨다.(B[A[i]]++)
2. B가 완성되면 각 요소들을 누적합으로 갱신한다(B[i]= B[i]+B[i-1]
3. A의 가장 뒤에서 값을 꺼내고 그 값을 B의 인덱스로 쓰고 참조된 B의 값을 C의 인덱스로 사용해 C에 A에서 꺼낸값을 넣는다.
4. 사용된 B의 값을 하나 감소시킨다(B[A[i]]--)
5. A의 모든 요소에 대해 4,5번 반복

- 예시
<br>
  A:[3,1,3,5,1,6]<br>
  B:[]<br>
  C:[]<br>
<---1---> 3:2개, 1:2개 , 5:1개 , 6:1개 <br>
B:[0,2,0,2,0,1,1]// b의 최대길이는 A의 최대값에 영향을 받는다. 공간적인 요소 <br>
<---2---><br>
누적합 계산->B[i]= B[i]+B[i-1] // 배열 A 에는 i 보다 같거나 작은수가 누적합(b)만큼 존재한다. <br>
B:[0,2,2,4,4,5,6]<br>
<---3---><br>
A의 끝부터 값을 하나씩 꺼낸다. 6을 꺼냄-> B[6] -> B[6]=6 -> C[6]=6 , B[6]=5(--)<br>
<---4---><br>
A에서 1 추출, b[1]=2, C[2]=1-> b[1]=1(--)<br>
C:[0,1,0,0,0,6]<br>
// 후일에 그림 git에 백업 필요함.<br>
<---5---><br>
a에서 5를 추출 , b[5]=5 이고 c[5]=5 , b[5]=4<br>
b:[0,1,2,4,4,4,5]<br>
c:[0,1,0,0,5,6]<br>
<---6---><br>
a에서 3을 추출 , b[3]= 4, c[4]=3, b[3]=3<br>
b:[0,1,2,3,4,4,5]<br>
c:[0,1,0,0,3,5,6]<br>
<---7---><br>
a에서 1을 추출 b[1]=1 , c[1]=1, b[1]=0<br>
b:[0,0,2,3,4,4,5]<br>
c:[0,1,1,0,3,5,6]<br>
<---8---><br>
a에서 3을 추출 b[3]=3, c[3]=3, b[3]=2<br>
b:[0,0,2,2,4,4,5]<br>
c:[0,1,1,3,3,5,6]<br>
<br>
최종 결과 C는 정렬된 상태임. 
<br>

<details>
<summary> 코드</summary>
<div markdown="1">

```
// k == max number
// n == number of data in A
void counting_sort(int A[], int B[], int C[]){
 
    /* 카운팅 배열 0으로 초기화 */
    for (int i = 0 ; i <= k ; i++){
        B[i] = 0;
    }
 
    /* 카운팅 값 갱신  */
    for (int i = 1 ; i <= n ; i++){
        B[A[i]] = B[A[i]] + 1;
    }
 
    /* 누적합 계산 */
    for (int i = 1 ; i <= k ; i++){
        B[i] = B[i] + B[i-1];
    }
 
    /* 결과 배열에 값 넣기 */
    for (int i = n ; i >= n ; i--){
        C[B[A[i]]] = A[i];
        B[A[i]] = B[A[i]] - 1;
    }
}


```

</div>
</details>





