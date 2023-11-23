# DFS<sub> Depth-First Search</sub> & BFS<sub> Breadth-First Search</sub>

> DFS, BFS 모두 그래프의 모든 정점을 탐색하는 알고리즘


[DFS<sub> 깊이 우선 탐색</sub>](#dfs-depth-first-search-깊이-우선-탐색)

[BFS<sub> 너비 우선 탐색</sub>](#bfs-breadth-first-search-너비-우선-탐색)


# DFS<sub> Depth-First Search, 깊이 우선 탐색</sub>
> 시작 노드에서 하위노드(자식노드)를 먼저 방문하는 알고리즘

</br>

### 특징
- 재귀, 스택을 사용하여 구현 가능
- 인접 행렬 & 인접 리스트로 구현할 수 있음.
- 각 경로의 특징을 저장해야 할 때, 그래프의 규모가 클 때 (비교적 공간을 적게 사용함) 사용



</br>

### 장점
- 현 경로상의 노드들만 기억하면 되므로 저장공간 수요가 비교적 적음.
- 목표 노드가 깊은 단계에 있을 경우 해를 빨리 구할 수 있음.

</br>

### 단점
- 해가 없는 경로가 깊을 경우 탐색시간이 오래 걸릴 수 있음.
- 얻어진 해가 최단 경로가 된다는 보장이 없음.
- 깊이가 무한히 깊어지면 스택오버플로우가 날 위험이 있음
    - 깊이 제한을 두는 방법으로 해결 가능

</br>

### DFS 구현

<details>
<summary>인접 행렬</summary>
<div markdown="1">

```java
import java.util.*;

public class DFS_Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 정점의 개수 
		int m = sc.nextInt(); // 간선의 개수 
		int v = sc.nextInt(); // 탐색을 시작할 정점의 번호 

		boolean visited[] = new boolean[n + 1]; // 방문 여부를 검사할 배열 

		int[][] adjArray = new int[n+1][n+1];

		// 두 정점 사이에 여러 개의 간선이 있을 수 있다.
		// 입력으로 주어지는 간선은 양방향이다.
		for(int i = 0; i < m; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();

			adjArray[v1][v2] = 1;
			adjArray[v2][v1] = 1;
		}

		System.out.println("DFS - 인접행렬 / 재귀로 구현");
		dfs_array_recursion(v, adjArray, visited);
		Arrays.fill(visited, false); // 스택 DFS를 위해 visited 배열 초기화

		System.out.println("\n\nDFS - 인접행렬 / 스택으로 구현");
		dfs_array_stack(v, adjArray, visited, true);
	}
	
	//DFS - 인접행렬 / 재귀로 구현 
	public static void dfs_array_recursion(int v, int[][] adjArray, boolean[] visited) {
		int l = adjArray.length-1;
		visited[v] = true;
		System.out.print(v + " ");

		for(int i = 1; i <= l; i++) {
			if(adjArray[v][i] == 1 && !visited[i]) {
				dfs_array_recursion(i, adjArray, visited);
			}
		}
	}

	//DFS - 인접행렬 / 스택으로 구현 
	public static void dfs_array_stack(int v, int[][] adjArray, boolean[] visited, boolean flag) {
		int l = adjArray.length-1;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(v);
		visited[v] = true;
		System.out.print(v + " ");

		while(!stack.isEmpty()) {
			int w = stack.peek();
			flag = false; 

			for(int i = 1; i <= l; i++) {
				if(adjArray[w][i] == 1 && !visited[i]) {
					stack.push(i);
					System.out.print(i + " ");
					visited[i] = true;
					flag = true;
					
					break;
				}
			}

			if(!flag) {
				stack.pop();
			}
		}
	}
	
}
```

</div>
</details>

</br>

<details>
<summary>인접 리스트</summary>
<div markdown="1">

```java
import java.util.*;

public class DFS_List {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 정점의 개수 
		int m = sc.nextInt(); // 간선의 개수 
		int v = sc.nextInt(); // 탐색을 시작할 정점의 번호 

		boolean visited[] = new boolean[n + 1]; // 방문 여부를 검사할 배열 

		LinkedList<Integer>[] adjList = new LinkedList[n + 1];

		for (int i = 0; i <= n; i++) {
			adjList[i] = new LinkedList<Integer>();
		}

		// 두 정점 사이에 여러 개의 간선이 있을 수 있다.
		// 입력으로 주어지는 간선은 양방향이다.
		for (int i = 0; i < m; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			adjList[v1].add(v2);
			adjList[v2].add(v1);
		}

		for (int i = 1; i <= n; i++) { // 방문 순서를 위해 오름차순 정렬 
			Collections.sort(adjList[i]);
		}

		System.out.println("DFS - 인접리스트");
		dfs_list(v, adjList, visited);
	}
	
	// DFS - 인접리스트 - 재귀로 구현 
	public static void dfs_list(int v, LinkedList<Integer>[] adjList, boolean[] visited) {
		visited[v] = true; // 정점 방문 표시
		System.out.print(v + " "); // 정점 출력

		Iterator<Integer> iter = adjList[v].listIterator(); // 정점 인접리스트 순회
		while (iter.hasNext()) {
			int w = iter.next();
			if (!visited[w]) // 방문하지 않은 정점이라면 
				dfs_list(w, adjList, visited); // 다시 DFS
		}
	}

}
```

</div>
</details>

</br>
</br>

# BFS<sub> Breadth-First Search, 너비 우선 탐색</sub>
> 시작 노드에서 인접한 모든 노드들을 우선 방문하는 알고리즘

</br>

### 특징
- 큐로 구현
- 인접 행렬 & 인접 리스트로 구현할 수 있음.
- 두 노드 사이의 최단 경로를 찾고 싶을 때 사용
    - `BFS` : 기준 노드에서부터 시작하여, 가장 빨리 도착하는 경우가 최단 경로
<-> `DFS` : 모든 노드를 다 살펴봐야 함


</br>

### 장점
- 너비를 우선으로 탐색하므로 답이 되는 경로가 여러 개인 경우에도 최단경로를 얻을 수 있음.
- 경로가 무한히 깊어져도 최단경로를 반드시 찾을 수 있음.
- 노드 수가 적고 깊이가 얕은 해가 존재할 때 유리

</br>

### 단점
- DFS와 달리 큐를 이용하여 다음에 탐색할 정점들을 저장하므로 더 큰 저장공간이 필요
- 노드의 수 전체가 늘어날 수록 비효율적일 수 있음.

</br>

### BFS 구현
<details>
<summary>인접 행렬</summary>
<div markdown="1">

```java
public class BFS_Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 정점의 개수 
		int m = sc.nextInt(); // 간선의 개수 
		int v = sc.nextInt(); // 탐색을 시작할 정점의 번호 

		boolean visited[] = new boolean[n + 1]; // 방문 여부를 검사할 배열 

		int[][] adjArray = new int[n+1][n+1];

		// 두 정점 사이에 여러 개의 간선이 있을 수 있다.
		// 입력으로 주어지는 간선은 양방향이다.
		for(int i = 0; i < m; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();

			adjArray[v1][v2] = 1;
			adjArray[v2][v1] = 1;
		}

		System.out.println("BFS - 인접행렬");
		bfs_array(v, adjArray, visited);
	}
	
	// BFS - 인접행렬
	public static void bfs_array(int v, int[][] adjArray, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();
		int n = adjArray.length - 1;

		q.add(v);
		visited[v] = true;

		while (!q.isEmpty()) {
			v = q.poll();
			System.out.print(v + " ");

			for (int i = 1; i <= n; i++) {
				if (adjArray[v][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}
	
}
```

</div>
</details>

</br>

<details>
<summary>인접 리스트</summary>
<div markdown="1">

```java
public class BFS_List {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 정점의 개수 
		int m = sc.nextInt(); // 간선의 개수 
		int v = sc.nextInt(); // 탐색을 시작할 정점의 번호 

		boolean visited[] = new boolean[n + 1]; // 방문 여부를 검사할 배열 

		LinkedList<Integer>[] adjList = new LinkedList[n + 1];

		for (int i = 0; i <= n; i++) {
			adjList[i] = new LinkedList<Integer>();
		}

		// 두 정점 사이에 여러 개의 간선이 있을 수 있다.
		// 입력으로 주어지는 간선은 양방향이다.
		for (int i = 0; i < m; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			adjList[v1].add(v2);
			adjList[v2].add(v1);
		}

		for (int i = 1; i <= n; i++) { 
			Collections.sort(adjList[i]); // 방문 순서를 위해 오름차순 정렬 
		}

		System.out.println("BFS - 인접리스트");
		bfs_list(v, adjList, visited);
	}

	// BFS - 인접리스트 
	public static void bfs_list(int v, LinkedList<Integer>[] adjList, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[v] = true; 
		queue.add(v);

		while(queue.size() != 0) { 
			v = queue.poll(); 
			System.out.print(v + " ");

			Iterator<Integer> iter = adjList[v].listIterator();
			while(iter.hasNext()) { 
				int w = iter.next(); 
				if(!visited[w]) { 
					visited[w] = true; 
					queue.add(w); 
				} 
			}
		}
	}

}
```

</div>
</details>

</br>

</br>

### 복잡도<sub>Complexity</sub>
- N : 정점의 수
- E : 간선의 수
<table style="text-align:center">
  <tr>
  <td></td>
    <td></td>
    <td> 시간 복잡도</td>
    <td>공간 복잡도</td>
  </tr>
  <tr>
    <td rowspan="2">DFS</td>
    <td><b>인접 행렬</b></td>
    <td>O(N<sup>2</sup>)</td>
    <td>O(N<sup>2</sup>)</td>
  </tr>
    <tr>
    <td><b>인접 리스트</b></td>
    <td>O(N+E)</td>
    <td>O(E)</td>
  </tr>
  <tr>
    <td rowspan="2">BFS</td>
    <td><b>인접 행렬</b></td>
    <td>O(N<sup>2</sup>)</td> 
    <td>O(N<sup>2</sup>)</td>
  </tr>
  <tr>
    <td><b>인접 리스트</b></td>
    <td>O(N+E)</td> 
    <td>O(E)</td>
  </tr>
</table>


</br>
</br>

- 참고

[[알고리즘] DFS와 BFS](https://velog.io/@yoon_0/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-DFS%EC%99%80-BFS)

[[Java] BFS 너비 우선 탐색 - 인접리스트 / 인접행렬로 구현](https://minhamina.tistory.com/36)