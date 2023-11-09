## 📖 LIS 최장 증가 부분 수열이란?
원소가 n개인 배열의 일부 원소를 골라내서 만든 부분 수열 중, 각 원소가 이전 원소보다 크다는 조건을 만족하고, 그 길이가 최대인 부분 수열을 최장 증가 부분 수열이라고 합니다.

- 예를 들어, { 6, 2, 5, 1, 7, 4, 8, 3} 이라는 배열이 있을 경우, LIS는 { 2, 5, 7, 8 } 이 됩니다.
- { 2, 5 }, { 2, 7 } 등 증가하는 부분 수열은 많지만 그 중에서 가장 긴 것이 { 2, 5, 7, 8 } 입니다.

일반적인 LIS의 해결법은 DP를 사용하여 풀이하는 방법입니다.
```
for (int k = 0; k < n; k++){
	length[k] = 1; // 초기화 
    for (int i = 0; i < k; i++){
        if(arr[i] < arr[k]){
            length[k] = max(length[k], length[i] + 1); // 추가하지 않는 경우와 for에 의해 길이가 1 증가한 값을 비교해서 LIS의 길이를 구할 수 있음.
        }
    }
}
```
- 이분탐색을 결합하면 기존 DP의 시간복잡도 N^2 보다 빠른 nlogn의 시간복잡도로 빠른 계산이 가능합니다.
<img src="https://i.imgur.com/tPAmqre.png">

위의 그림의 방식대로 진행하면 LIS의 값도 구할 수 있고 J값을 통해 길이도 추출 가능함.

```
int n;
int arr[40001];
int lis[40001];

// LIS를 유지하기 위해 숫자가 들어갈 위치를 이분탐색으로 찾는 함수
int binarysearch(int left, int right, int target) {

	int mid;

    // lis 배열에 들어갈 target=arr[i]의 위치를 이분탐색으로 찾기

	while (left < right) {
		mid = (left + right) / 2; // 중간값 설정

		if (lis[mid] < target) {
			left = mid + 1;
		}
		else {
			right = mid;
		}
	}
	return right;
}

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	int j = 0;
	lis[0] = arr[0]; // lis 배열의 맨 첫번째 값은 arr[0]으로 초기화
	int i = 1;

	// arr의 두번째부터 마지막까지 하나씩 lis와 비교하면서 넣어준다.
	while (i < n) {
		// lis 배열의 맨 뒤의 값보다 arr[i]가 더 크면 그것을 lis 배열 맨 뒤에 넣어준다.
		if (lis[j] < arr[i]) {
			lis[j + 1] = arr[i];
			j += 1;
		}
		// arr[i]값이 더 작으면, arr[i]의 값이 lis 배열 중 어느 곳에 들어올지 이분탐색한다.
		else {
            // 0부터 j까지 탐색하면서 arr[i]가 들어갈 수 있는 위치를 찾아서 idx에 반환
			int idx = binarysearch(0, j, arr[i]);
			lis[idx] = arr[i];
		}
		i += 1;
	}

	cout << j + 1;


	return 0;
}
```


참조
https://chanhuiseok.github.io/posts/algo-49/ 
