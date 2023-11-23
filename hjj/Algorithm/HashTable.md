# Hash Table

> 연관배열 구조를 이용하여 (Key, Value)로 데이터를 저장하는 자료구조

### 특징
- 검색하고자 하는 key 값을 입력 받아서 해시 함수에 넣고 돌려서 받은 해시 코드를 배열의 인덱스로 환산을 해서 데이터의 접근
- key값은 문자열, 숫자, 파일 데이터 등이 될 수 있음.
- 입력 데이터가 완벽하게 일치해야 동일한 결과값이 나옴.

### 장점
- 검색 속도가 빠름
    - 해시코드 자체가 배열의 인덱스로 사용되고 바로 접근할 수 있기 때문에 속도가 빠름.
- 해시 충돌이 없는 상태에서 배열, 리스트 같은 선형적인 구조는 물론 트리와 구조보다 빠른 탐색
- 해시를 사용하기에 해시 값을 알아도 key를 예측하기 어려움

### 단점
- 해시 충돌 발생 시 탐색이 시간 복잡도 O(N)에 점점 수렴함.
- 정렬이나 순차적인 메모리 저장이 필요한 경우 적합하지 않음.
- 해시 함수의 의존도가 높음
    - 해시 함수의 성능에 따라 해시 테이블 전체 성능이 크게 영향을 받음.
- 공간 효율성이 떨어짐.


### 충돌

### 충돌 해결 방법

</br>

### Hash Table 구현

<details>
<summary>java 코드</summary>
<div markdown="1">

```java
import java.util.LinkedList;

public class Test {

	static class HashTable {
		
		// 데이터를 저장할 linkedlist
		LinkedList<Node>[] data;

		class Node {
			String key;
			String value;

			public Node(String key, String value) {
				this.key = key;
				this.value = value;
			}

			String value() {
				return value;
			}

			void value(String value) {
				this.value = value;
			}
		}

		HashTable(int size) {
			this.data = new LinkedList[size];
		}

		// hash function
		int getHashCode(String key) {
			
			int hashcode = 0;
			
			// 각 문자의 아스키 값을 가져와서 해시 코드에 더해줌.
			for (char c : key.toCharArray()) {
				hashcode += c;
			}
			return hashcode;
		}

		// find index of hash table
		int convertToIndex(int hashcode) {
			return hashcode % data.length;
		}
		
		// 해시 테이블의 인덱스에 여러 리스트가 존재하는 경우 key로 해당 노드를 찾아오는 함수
		Node searchKey(LinkedList<Node> list, String key) {
			if(list == null)
				return null;
			// null이 아니면 key와 같은 노드를 찾음.
			for(Node node : list) {
				if(node.key.equals(key))
					return node;
			}
			
			return null;
		}
		
		// 데이터를 받아서 저장하는 함수
		void put(String key, String value) {
			
			int hashcode = getHashCode(key);
			int index = convertToIndex(hashcode);
			
			System.out.println(key + ", hashcode(" + hashcode + "), index(" + index + ")");
			LinkedList<Node> list = data[index];
			
			// 저장할 배열의 위치가 null인 경우
			if(list == null) {
				list = new LinkedList<Node>();
				data[index] = list;
			}
			// 이미 같은 key값을 가진 데이터가 있을 수 있으므로 검색을 해봐야 함. 
			Node node = searchKey(list, key);
			if(node == null) {
				list.addLast(new Node(key, value));
			}
			else {
				node.value(value);
			}
		}
		
		// 해시 테이블에 저장된 데이터를 키값으로 찾아오는 함수
		String get(String key) {
			int hashcode = getHashCode(key);
			int index = convertToIndex(hashcode);
			LinkedList<Node> list = data[index];
			Node node = searchKey(list, key);
			return node == null ? "Not found" : node.value();
		}
	}

	public static void main(String[] args) {
		HashTable h = new HashTable(3);
		h.put("sung", "She is pretty");
		h.put("jin", "She is a model");
		h.put("hee", "She is an angel");
		h.put("min", "She is cute");
		h.put("sung", "She is beautiful");
		System.out.println(h.get("sung"));
		System.out.println(h.get("jin"));
		System.out.println(h.get("hee"));
		System.out.println(h.get("min"));
		System.out.println(h.get("jae"));
	}

}
```

</div>
</details>

</br>

### 복잡도<sub>Complexity</sub>
| 연산 | 평균 | 최악 |
| :---: | :---: | :---: |
| 삽입 | O(1) | O(N) |
| 검색 | O(1) | O(N) |
| 삭제 | O(1) | O(N) |


</br>
</br>

- 참고


[[자료구조 알고리즘] 해쉬테이블(Hash Table)에 대해 알아보고 구현하기](https://www.youtube.com/watch?v=Vi0hauJemxA)
[[자료구조]해시 테이블](https://hongcoding.tistory.com/179)