# :books: Interview - HashTable <sub>해시테이블</sub>

## :bookmark_tabs: 목차

[:arrow_up: **Algorithm**](../README.md)

1. ### [Question](#) <sub>면접 질문</sub>

   - HashTable에 대해서 설명할 수 있나요?
   - 해시 충돌의 대표적인 해결방법에 대해서 설명할 수 있나요?
   - 해시 테이블의 동적 확장 방법을 알고있나요?
   - 무수히 긴 스트링 값이 있을때, 거기서 해당 단어가 있는지 없는지 확인하고자 한다면 어떻게 해야할까?

2. ### [Coding Test](#) <sub>알고리즘 문제</sub>

# :closed_book: Question <sub>면접 질문</sub>

### HashTable에 대해서 설명할 수 있나요?

[**정리한 내용 참고**](../Note/HashTable.md)

### 해시 충돌의 대표적인 해결방법에 대해서 설명할 수 있나요?

|      | Separate Chaining                                | Open Addressing                                              |
| ---- | ------------------------------------------------ | ------------------------------------------------------------ |
| 해결 | 버킷의 데이터에 대해 추가 할당해 메모리를 추가   | 정해진 규칙에 따라 인덱스를 옮겨 버킷의 비어있는 공간에 할당 |
| 장점 | 해시 버킷의 물리적인 확장 없이 손쉽게 구현 가능  | 특정 조건하에 속도가 빠름 (LF < 0.8)                         |
| 단점 | 중복 인덱스를 가지는 데이터가 많아지면 성능 하락 | 부하율(LF)이 심하면 성능이 하락                              |
| 구현 | 리스트, 더블링크드리스트, 트리                   | 선형 탐사법, 제곱 탐사법, 이중 해시 탐사법                   |

### 해시 테이블의 동적 확장 방법을 알고있나요?

- 부하율<sub>Load Factor</sub>을 측정해서 해시 테이블의 사이즈를 측정하여 적절한 부하를 가진 해시 테이블을 새로 할당한다.
- 해시테이블 버킷 안의 데이터가 차지하는 영역의 비율
  > 일반적으로 적절한 성능의 부하율 범위는 `0.6 ~ 0.8` 정도
- HashMap의 경우 키값쌍 데이터 개수가 정해진 개수를 넘어 부하가 걸린다 판단되면 되면 해시 버킷의 개수를 두 배로 늘리는 알고리즘을 가짐

### 무수히 긴 스트링 값이 있을때, 거기서 해당 단어가 있는지 없는지 확인하고자 한다면 어떻게 해야하나요?(map의 사용을 물어보는 질문)

- 스트링 값의 단어가 각각 개별적인 완성된 단어 집합이고 구분자로 구분이 가능하다 가정할 때, map 자료형을 사용해서 키값쌍으로 매핑하면 `O(1)`안의 시간 안에 해당 단어를 포함하고 있는지 확인 할 수 있다.
- 그 외의 경우에선 많은 공간복잡도를 요구하므로 다른 방법을 찾는 것이 맞다.

### (JAVA) HashMap과 HashTable의 차이점을 설명할 수 있나요?

```java
// HashTable의 put
public synchronized V put(K key, V value) {
    // Make sure the value is not null
    if (value == null) {
        throw new NullPointerException();
    }
    // Makes sure the key is not already in the hashtable.
    Entry<?,?> tab[] = table;
    int hash = key.hashCode();
    int index = (hash & 0x7FFFFFFF) % tab.length;
    @SuppressWarnings("unchecked")
    Entry<K,V> entry = (Entry<K,V>)tab[index];
    for(; entry != null ; entry = entry.next) {
        if ((entry.hash == hash) && entry.key.equals(key)) {
            V old = entry.value;
            entry.value = value;
            return old;
        }
    }
    addEntry(hash, key, value, index);
    return null;
}

// HashMap의 put
public V put(K key, V value) {
    return putVal(hash(key), key, value, false, true);
}
```

|             | HashTable     | HashMap       |
| ----------- | ------------- | ------------- |
| Thread-safe | Thread-safe   | Thread-unsafe |
| Key의 Null  | 허용하지 않음 | 허용          |
| Enumeration | 제공          | 제공하지 않음 |

1. Thread-safe 여부

   - `synchronized` keyword 사용하는 Hashtable은 Thread-safe
   - HashMap은 Thread-safe하지 않음

   > Thread-safe는 데이터 무결성을 보장하는 대신 성능 저하를 발생하므로 멀티스레드 환경이 아니라면 Hashtable은 HashMap 보다 성능이 떨어진다

2. Null 값 허용 여부

   - Hashtable은 key에 null을 허용하지 않음
   - HashMap은 key에 null을 허용

3. Enumeration 여부

   - Hashtable은 **not fail-fast Enumeration**을 제공
   - HashMap은 Enumeration을 제공하지 않음
     - HashMap은 보조해시를 사용하기 때문에 보조 해시 함수를 사용하지 않는 Hashtable에 비하여 해시 충돌(hash collision)이 덜 발생할 수 있어 상대적으로 성능상 이점을 가짐

- Hashtable은 구현에 거의 변화가 없지만, HashMap은 현재까지도 지속적으로 개선되므로 HashMap이 일반적인 상황에선 성능상 이점을 가짐

# :orange_book: Coding Test <sub>알고리즘 문제</sub>

- 백준 15829번 : [Hashing](https://www.acmicpc.net/problem/15829)
- 백준 5568번 : [카드 놓기](https://www.acmicpc.net/problem/5568)
- 백준 20166번 : [문자열 지옥에 빠진 호석](https://www.acmicpc.net/problem/20166)
- 백준 4195번 : [친구 네트워크](https://www.acmicpc.net/problem/4195)
