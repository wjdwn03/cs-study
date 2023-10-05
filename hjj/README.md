### Array

가장 기본적인 자료구조인 `Array` 자료구조는, 논리적 저장 순서와 물리적 저장 순서가 일치한다. 따라서 `인덱스`(index)로 해당 원소(element)에 접근할 수 있다. 그렇기 때문에 찾고자 하는 원소의 인덱스 값을 알고 있으면 `Big-O(1)`에 해당 원소로 접근할 수 있다. 즉 **random access** 가 가능하다는 장점이 있는 것이다.

하지만 삭제 또는 삽입의 과정에서는 해당 원소에 접근하여 작업을 완료한 뒤(O(1)), 또 한 가지의 작업을 추가적으로 해줘야 하기 때문에, 시간이 더 걸린다. 만약 배열의 원소 중 어느 원소를 삭제했다고 했을 때, 배열의 연속적인 특징이 깨지게 된다. 즉 빈 공간이 생기는 것이다. 따라서 삭제한 원소보다 큰 인덱스를 갖는 원소들을 `shift`해줘야 하는 비용(cost)이 발생하고 이 경우의 시간 복잡도는 O(n)가 된다. 그렇기 때문에 Array 자료구조에서 삭제 기능에 대한 time complexity 의 worst case 는 O(n)이 된다.

삽입의 경우도 마찬가지이다. 만약 첫번째 자리에 새로운 원소를 추가하고자 한다면 모든 원소들의 인덱스를 1 씩 shift 해줘야 하므로 이 경우도 O(n)의 시간을 요구하게 된다.

### Linked List

이 부분에 대한 문제점을 해결하기 위한 자료구조가 linked list 이다. 각각의 원소들은 자기 자신 다음에 어떤 원소인지만을 기억하고 있다. 따라서 이 부분만 다른 값으로 바꿔주면 삭제와 삽입을 O(1) 만에 해결할 수 있는 것이다.

하지만 Linked List 역시 한 가지 문제가 있다. 원하는 위치에 삽입을 하고자 하면 원하는 위치를 Search 과정에 있어서 첫번째 원소부터 다 확인해봐야 한다는 것이다. Array 와는 달리 논리적 저장 순서와 물리적 저장 순서가 일치하지 않기 때문이다. 이것은 일단 삽입하고 정렬하는 것과 마찬가지이다. 이 과정 때문에, 어떠한 원소를 삭제 또는 추가하고자 했을 때, 그 원소를 찾기 위해서 O(n)의 시간이 추가적으로 발생하게 된다.

결국 linked list 자료구조는 search 에도 O(n)의 time complexity 를 갖고, 삽입, 삭제에 대해서도 O(n)의 time complexity 를 갖는다. 그렇다고 해서 아주 쓸모없는 자료구조는 아니기에, 우리가 학습하는 것이다. 이 Linked List 는 Tree 구조의 근간이 되는 자료구조이며, Tree 에서 사용되었을 때 그 유용성이 드러난다.

### **LinkedList와 ArrayList 차이**

ArrayList는 데이터들이 순서대로 늘어선 배열의 형식을 취하고 있지만, LinkedList는 자료의 주소값으로 서로 연결된 형식을 가지고 있습니다. 이러한 구조에 의해 둘은 각각의 장단점을 가지고 있습니다.

- **ArrayList**
    - 원하는 데이터에 무작위로 접근할 수 있다.
    - 리스트의 크기가 제한되어 있으며, 리스트의 크기를 재조정하는 것은 많은 연산이 필요하다.
    - 데이터의 추가/삭제를 위해서는 임시 배열을 생성하여 복제하고 있어 시간이 오래 걸린다.
- **LinkedList**
    - 리스트의 크기에 영향 없이 데이터를 추가할 수 있다.
    - 데이터를 추가하기 위해 새로운 노드를 생성하여 연결하므로 추가/삭제 연산이 빠르다.
    - 무작위 접근이 불가능하며, 순차 접근만이 가능하다.

### Array와 ArrayList 차이

|  | Array | ArrayList |
| --- | --- | --- |
| 사이즈 | 초기화시 고정 | 초기화시 사이즈를 표시하지 않음. 사이즈가 동적이다. |
| 속도 | 초기화 시 메모리에 할당되어 속도 빠름 | 추가시 메모리를 재할당하여 속도가 느림 |
| 변경 | 사이즈 변경 불 | 추가, 삭제 가능 |
| 다차원 | 가능 | 불가 |
| 타입 | primitive type(int,byte, char etc), object | object elemnet만 가능 |
| 제네릭 | 사용 불가능 | 사용 가능(타입 안정성 보장) |
| 길이 | length 변수 | size() 메소드 |
| 변수 추가 | assignment 연산자 사용 | add() 메소드 사용 |

### Array와 LinkedList의 장/단점

Array는 인덱스(index)로 해당 원소(element)에 접근할 수 있어 찾고자 하는 원소의 인덱스 값을 알고 있으면 O(1)에 해당 원소로 접근할 수 있다. 즉, **RandomAccess가 가능해 속도가 빠르다는 장점이 있다.**

하지만 **삽입 또는 삭제의 과정에서 각 원소들을 shift 해줘야 하는 비용이 생겨 이 경우 시간 복잡도는 O(n)이 된다는 단점이 있다.**

이 문제점을 해결하기 위한 자료구조가 linkedlist이다.

**각각의 원소들은 자기 자신 다음에 어떤 원소인지만을 기억하고 있기 때문에 이 부분만 다른 값으로 바꿔주면 삽입과 삭제를 O(1)로 해결할 수 있다.**

하지만 **LinkedList는 원하는 위치에 한 번에 접근할 수 없다는 단점이 있다.**

원하는 위치에 삽입을 하고자 하면 원하는 위치를 Search 과정에 있어서 첫번째 원소부터 다 확인해봐야 한다.

**간단히 정리하면,**

**Array는 검색이 빠르지만, 삽입, 삭제가 느리다.**

**LinkedList는 삽입, 삭제가 빠르지만, 검색이 느리다.**

|  | Array | LinkedList |
| --- | --- | --- |
| 데이터들의 input 순서 보장 여부 | yes or no ? | yes |
| 중복된 데이터 허용 여부 | yes | yes |
| 데이터 정렬 여부 | no | no |

### ⏰ 시간 복잡도

|  | Array | LinkedList |
| --- | --- | --- |
| 데이터 추가 | O(N) | O(1) : 맨 앞, 맨 뒤
O(N) : 탐색을 통한 중간 삽입 |
| 데이터 검색 | O(1) | O(N) |
| 데이터 삭제 | O(N) | O(1) : 맨 앞, 맨 뒤
O(N) : 탐색을 통한 중간 삭제 |


### Stack과 Queue에 대해 설명하세요.

- Stack과 Queue 모두 선형 자료구조이고, Array와 LinkedList로 구현할 수 있다.

**✔️ Stack**

![[https://www.geeksforgeeks.org/stack-data-structure/](https://www.geeksforgeeks.org/stack-data-structure/)](./img/Untitled.png)

[https://www.geeksforgeeks.org/stack-data-structure/](https://www.geeksforgeeks.org/stack-data-structure/)

- List 컬렉션 클래스의 Vector 클래스를 상속받아, 전형적인 스택 메모리 구조의 클래스 제공
- **LIFO**(Last In First Out, 후입선출)의 방식으로 데이터가 추가되고 제거된다.
- List로 구현 시 객체를 제거하는 작업이 필요하지만 Array로 구현 시 제거할 필요 없이 index를 줄이면 되기 때문에 Array로 구현하는 것이 좋다. (위 그림 참고)
- DFS, 재귀에 주로 사용된다.
- Java에서 스택 사용 시 Stack 클래스를 사용하기 보다 ArrayDeque를 사용하는 것이 좋다. 이유는 아래 글을 참고하자.
    
    [[Deque 00] Deque란? (with  자료구조 - 선형구조)](https://jjhwang.tistory.com/21)
    
    [[Deque 01] Stack말고 ArrayDeque](https://jjhwang.tistory.com/22)
    

**✔️ Queue**

![[https://www.geeksforgeeks.org/queue-data-structure/](https://www.geeksforgeeks.org/queue-data-structure/)](./img/Untitled1.png)

[https://www.geeksforgeeks.org/queue-data-structure/](https://www.geeksforgeeks.org/queue-data-structure/)

- FIFO(First In First Out, 선입선출)의 방식으로 데이터가 추가되고 제거된다.
- 위 그림과 같은 방식으로 데이터가 관리 되므로 Array로 구현하는 것보다 LinkedList로 구현하는 것이 좋다. 즉, 큐는 항상 가장 먼저 저장된 데이터를 삭제하므로 배열 기반의 자료구조를 사용하게 되면 앞의 빈 공간을 채우기 위해 데이터 복사가 발생하므로 비효율적이다.
- 주로 데이터가 입력된 시간 순서대로 처리되어야 하는 경우 사용
    - ex) BFS나 캐시를 구현할 때 사용

|  | Stack | Queue |
| --- | --- | --- |
| 데이터들의 input 순서 보장 여부 | yes | yes |
| 중복된 데이터 허용 여부 | yes | yes |
| 데이터 정렬 여부 | no | no |

### ⏰ 시간 복잡도

|  | Stack | Queue |
| --- | --- | --- |
| 데이터 추가 | O(1) | O(1) |
| 데이터 검색 | O(N) | O(N) |
| 데이터 삭제 | O(1) : pop()
O(N) : remove() | O(1) |

### Stack과 Queue의 차이점은?

- stack은 한 방향에서 데이터가 추가되고 삭제되는데 queue는 한 방향으로 삽입만 일어나고,다른 방향에서 삭제만 하는 자료구조이다. 즉, add 하는 곳과 remove하는 곳의 방향이 다르다.
- stack은 LIFO, Qeueu는 FIFO 순서이다.

### Stack과 Queue의 실 사용 예시가 있을까요?

- Stack
    - **Java의 Stack 메모리 영역**
        - 지역변수와 매개변수 데이터 값이 저장되는 공간이며, 메소드 호출 시 메모리에 할당되고 종료되면 메모리가 해제된다.
- Queue
    - **OS의 스케줄러**
        - 자원의 할당과 회수를 하는 스케쥴러 역할을 할 수 있다.
        - 메모리에 적재된 다수의 프로세스 중 어떤 프로세스에 자원을 할당할 것인가 순서를 결정하는 것이 자원의 효율적인 사용에 있는데, 가장 단순한 형태의 스케쥴링 정책이 선입선처리(First Com First Served) 즉, 큐라고 볼 수 있다.

### 두 클래스를 손 코딩으로 구현해주세요.

- **Stack**

```java
public class Stack {
    private static int MAX_STACK_SIZE = 10;
    private int top;
    private int[] data = new int[MAX_STACK_SIZE];
 
    public Stack() {
        top = -1;
    }
 
    public void push(int data_) throws Exception {
        if (isFull()) {
            throw new Exception("스택이 가득 찼습니다.");
        }
        data[++top] = data_;
    }
 
    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("스택이 비었습니다.");
        }
        return data[top--];
    }
 
    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("스택이 비었습니다.");
        }
        return data[top];
    }
 
    public boolean isEmpty() {
        return top == -1;
    }
 
    public boolean isFull() {
        return top == MAX_STACK_SIZE - 1;
    }
 
    public int size() {
        return top + 1;
    }
}
```

- Queue

```java
public class Queue {
    private static int MAX_QUEUE_SIZE = 10;
    private int rear,front,size;
    private int[] data = new int[MAX_QUEUE_SIZE];

    public Queue() {
        front = rear = size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public void add(int item) {
        //이 부분이 배열을 환형으로 만들어 주는 부분이다.
        rear = (rear + 1) % data.length;
        data[rear] = item;
        size++;
    }

    public int pop() {
        if(isEmpty()) throw new NoSuchElementException();
        //이 부분이 배열을 환형으로 만들어 주는 부분이다.
        front = (front + 1) % data.length;
        int item = data[front];
        data[front] = 0;
        size--;

        return item;
    }

    public int peek() {
        if(isEmpty()) throw new NoSuchElementException();
        return data[front];
    }
}
```

### 스택으로 큐 구현하기

- A와 B라는 2개의 스택을 만든다.
- push는 A 스택에 하고, pop 연산을 하게 되면 A의 모든 데이터를 B 스택으로 옮긴다.
- 그럼 A의 데이터와 역순으로 B에 저장되므로 선입선출의 순서로 출력된다.
    
    ![Untitled](./img//Untitled2.png)
    

### 큐로 스택 구현하기

- pop할 때 가장 마지막에 넣은 데이터가 나올 때까지 pop하고 다시 큐에 push한다. 그럼 후입선출의 순서로 데이터가 출력된다.
    
    ![Untitled](./img//Untitled3.png)
    

### 우선순위 큐가 무엇인지, 내부 구조 및 시간 복잡도에 대해 설명해주세요.

❓ **우선순위 큐**

- 들어간 순서에 상관없이 우선순위가 높은 데이터를 먼저 꺼내기 위해 고안된 자료구조로 힙이라고도 부른다.
    - `**최소힙**` : 오름차순으로 정렬된 경우
    - `**최대힙**` : 내림차순으로 정렬된 경우
- null을 저장하면 NullPointerException이 발생
- 다익스트라 알고리즘에 사용된다.
- 우선순위 큐 구현 방식에는 배열, 연결 리스트, 힙이 있다.
- 일반적으로 힙을 이용해 구현하는 이유
    - 배열이나 연결리스트로 구현할 경우 간단하게 구현이 가능하지만, 데이터 삽입과 삭제 과정에서 데이터를 한 칸씩 당기거나 밀어야 하는 연산을 계속 하여야 한다. 또 삽입의 위치를 찾기 위해 배열에 저장된 모든 데이터와 우선순위를 비교해야 한다. 연결리스트의 경우, 삽입의 위치를 찾기 위해 첫번째 노드부터 시작해 마지막 노드에 저장된 데이터와 우선순위 비교를 진행해야 할 수도 있다.
    - 힙 방식의 우선순위 큐는 O(logN)을 보장
- 힙으로 구현된 우선순위 큐의 특징
    - 완전 이진 트리 구조의 형태를 갖는다.
    - 일반적으로 배열로 구현
    - 반 정렬 상태 즉, 느슨한 정렬 상태를 유지한다.

### ⏰ 시간 복잡도

|  | PriorityQueue |
| --- | --- |
| 데이터 추가 | O(logN) |
| 데이터 검색 | O(N) |
| 데이터 삭제 | O(1) |

- 참고

[[기술면접] CS 기술면접 질문 - 자료구조 (2/8)](https://mangkyu.tistory.com/89)

[신입 개발자 기술면접 질문 정리 - 자료구조](https://dev-coco.tistory.com/159)

[Stack Data Structure - GeeksforGeeks](https://www.geeksforgeeks.org/stack-data-structure/)

[Queue Data Structure - GeeksforGeeks](https://www.geeksforgeeks.org/queue-data-structure/)

[Difference between Stack and Queue Data Structures - GeeksforGeeks](https://www.geeksforgeeks.org/difference-between-stack-and-queue-data-structures/)

[[자료구조] 면접질문 모음](https://velog.io/@humblechoi/자료구조-면접질문-모음)

[[Java] Queue가 ArrayList 대신 LinkedList를 사용하는 이유](https://devlog-wjdrbs96.tistory.com/246)


[[자료구조] 스택과 큐, 데크(Stack, Queue, Deque)](https://bigsong.tistory.com/32)

[[자료구조] 스택으로 큐, 큐로 스택 구현하기](https://kimmeh1.tistory.com/535)

[[자료구조] Stack & Queue](https://velog.io/@humblechoi/자료구조-Stack-Queue)

[자료구조 - 우선순위 큐(Heap, Priority Queue)](https://hongjw1938.tistory.com/22)