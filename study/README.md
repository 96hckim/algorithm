# 자료구조

- 용어: 자료구조, 데이터 구조, data structure
- 대량의 데이터를 효율적으로 관리할 수 있는 데이터의 구조를 의미
- 코드상에서 효율적으로 데이터를 처리하기 위해, 데이터 특성에 따라, 체계적으로 데이터를 구조화해야 함
  - 어떤 데이터 구조를 사용하느냐에 따라, 코드 효율이 달라짐

### 대표적인 자료구조

- 배열, 스택, 큐, 링크드 리스트, 해쉬 테이블, 힙 등

> 현실 세계의 대표적인 자료구조? - 사전, 우편번호(5자리 우편번호로 지역 표기)

# 알고리즘

- 용어 : 알고리즘, algorithm
- 어떤 문제를 풀기 위한 절차/방법
- 어떤 문제에 대해, 특정한 '입력'을 넣으면, 원하는 '출력'을 얻을 수 있도록 만드는 프로그래밍

> 현실 세계의 가장 대표적인 알고리즘? - 백종원 레시피

### 자료구조와 알고리즘이 중요한 이유

- 어떤 자료구조와 알고리즘을 쓰느냐에 따라, 성능이 천지차!

> 결국 프로그래밍을 잘 할 수 있는 기술과 역량을 익히고, 검증할 수 있음

---

# 배열(Array)

- 데이터를 나열하고, 각 데이터를 인덱스에 대응하도록 구성한 데이터 구조

### 배열은 왜 필요할까?

- 같은 종류의 데이터를 효율적으로 관리하기 위해 사용
- 같은 종류의 데이터를 순차적으로 저장
- 장점:
  - 빠른 접근 가능
    - 첫 데이터의 위치에서 상대적인 위치로 데이터 접근(인덱스 번호로 접근)
- 단점:
  - 데이터 추가/삭제의 어려움
    - 미리 최대 길이를 지정해야 함

### 참고: List 와 ArrayList

- 다음과 같이 List 와 ArrayList 선언의 차이점

```java
List<Integer> list1 = new ArrayList<Integer>();
ArrayList<Integer> list1 = new ArrayList<Integer>();
```

- List 는 인터페이스이고, ArrayList 는 클래스임
  - 클래스는 크게 일반 클래스와 클래스 내에 '추상 메서드' 가 하나 이상 있거나, abstract 로 정의된 추상 클래스로 나뉨
  - 인터페이스는 모든 메서드가 추상 메서드인 경우를 의미하며, 인터페이스를 상속받는 클래스는 인터페이스에서 정의된 추상 메서드를 모두 구현해야 함 (**따라서 다양한 클래스를 상속받는 특정 인터페이스는 결국 동일한 메서드를 제공함**)
  - ArrayList 가 아니라, List 로 선언된 변수는 다음과 같이 필요에 따라 다른 리스트 클래스를 쓸 수 있는 **구현상의 유연성** 을 제공함
    ```java
       List<Integer> list1 = new ArrayList<Integer>();
       list1 = new LinkedList<Integer>();
    ```

---

# 큐 (Queue)

- 줄을 서는 행위와 유사
- 가장 먼저 넣은 데이터를 가장 먼저 꺼낼 수 있는 구조
  - 음식점에서 가장 먼저 줄을 선 사람이 제일 먼저 음식점에 입장하는 것과 동일
  - FIFO(First-In, First-Out) 또는 LILO(Last-In, Last-Out) 방식으로 스택과 꺼내는 순서가 반대

<img src="https://www.fun-coding.org/00_Images/queue.png" />

### 알아둘 용어

- Enqueue: 큐에 데이터를 넣는 기능
- Dequeue: 큐에서 데이터를 꺼내는 기능

### 3. JAVA 에서의 큐 자료 구조 사용하기

- JAVA 에서는 기본적으로 java.util 패키지에 Queue 클래스를 제공하고 있음
  - Enqueue 에 해당하는 기능으로 Queue 클래스에서는 add(value) 또는 offer(value) 메서드를 제공함
  - Dequeue 에 해당하는 기능으로 Queue 클래스에서는 poll() 또는 remove() 메서드를 제공함
  - Queue 클래스에 데이터 생성을 위해서는 java.util 패키지에 있는 LinkedList 클래스를 사용해야 함

### 참고: 어디에 큐가 많이 쓰일까?

- 멀티 태스킹을 위한 프로세스 스케쥴링 방식을 구현하기 위해 많이 사용됨

---

# 스택 (Stack)

- 데이터를 제한적으로 접근할 수 있는 구조
  - 한쪽 끝에서만 자료를 넣거나 뺄 수 있는 구조
- 가장 나중에 쌓은 데이터를 가장 먼저 빼낼 수 있는 데이터 구조
  - 큐: FIFO 정책
  - 스택: LIFO 정책

### 스택 구조

- 스택은 LIFO(Last In, Fisrt Out) 또는 FILO(First In, Last Out) 데이터 관리 방식을 따름

  - LIFO: 마지막에 넣은 데이터를 가장 먼저 추출하는 데이터 관리 정책
  - FILO: 처음에 넣은 데이터를 가장 마지막에 추출하는 데이터 관리 정책

- 대표적인 스택의 활용

  - 컴퓨터 내부의 프로세스 구조의 함수 동작 방식

- 주요 기능
  - push(): 데이터를 스택에 넣기
  - pop(): 데이터를 스택에서 꺼내기

<img src="http://www.fun-coding.org/00_Images/stack.png" />

### 자료 구조 스택의 장단점

- 장점
  - 구조가 단순해서, 구현이 쉽다.
  - 데이터 저장/읽기 속도가 빠르다.
- 단점 (일반적인 스택 구현시)
  - 데이터 최대 갯수를 미리 정해야 한다.
  - 저장 공간의 낭비가 발생할 수 있음
    - 미리 최대 갯수만큼 저장 공간을 확보해야 함

> 스택은 단순하고 빠른 성능을 위해 사용되므로, 보통 배열 구조를 활용해서 구현하는 것이 일반적임.
> 이 경우, 위에서 열거한 단점이 있을 수 있음

### 3. JAVA 에서의 스택 자료 구조 사용하기

- java.util 패키지에서 Stack 클래스 제공
  - push(아이템) 메서드 : 아이템을 Stack 에 추가
  - pop() 메서드 : Stack 에서 마지막에 넣은 아이템을 리턴하고, 해당 아이템은 Stack 에서 삭제

---

# 링크드 리스트 (Linked List)

### 링크드 리스트 (Linked List) 구조

- 연결 리스트라고도 함
- 배열은 순차적으로 연결된 공간에 데이터를 나열하는 데이터 구조
- 링크드 리스트는 떨어진 곳에 존재하는 데이터를 화살표로 연결해서 관리하는 데이터 구조

- 링크드 리스트 기본 구조와 용어
  - 노드(Node): 데이터 저장 단위 (데이터값, 포인터) 로 구성
  - 포인터(pointer): 각 노드 안에서, 다음이나 이전의 노드와의 연결 정보를 가지고 있는 공간

<br>
* 일반적인 링크드 리스트 형태
<img src="https://www.fun-coding.org/00_Images/linkedlist.png" />

### 링크드 리스트의 장단점 (전통적인 C언어에서의 배열과 링크드 리스트)

- 장점
  - 미리 데이터 공간을 미리 할당하지 않아도 됨
    - 배열은 **미리 데이터 공간을 할당** 해야 함
- 단점
  - 연결을 위한 별도 데이터 공간이 필요하므로, 저장공간 효율이 높지 않음
  - 연결 정보를 찾는 시간이 필요하므로 접근 속도가 느림
  - 중간 데이터 삭제시, 앞뒤 데이터의 연결을 재구성해야 하는 부가적인 작업 필요

### 링크드 리스트 데이터 사이에 데이터를 추가

- 링크드 리스트는 유지 관리에 부가적인 구현이 필요함

<img src="https://www.fun-coding.org/00_Images/linkedlistadd.png" />

## 더블 링크드 리스트(Doubly linked list)

- 더블 링크드 리스트(Doubly linked list) 기본 구조
  - 이중 연결 리스트라고도 함
  - 장점: 양방향으로 연결되어 있어서 노드 탐색이 양쪽으로 모두 가능
    <br>
    <img src="https://www.fun-coding.org/00_Images/doublelinkedlist.png" />

---

# 해쉬 테이블 (Hash Table)

- 키(Key)에 데이터(Value)를 매핑할 수 있는 데이터 구조
- 해쉬 함수를 통해, 배열에 키에 대한 데이터를 저장할 수 있는 주소(인덱스 번호)를 계산
- Key를 통해 바로 데이터가 저장되어 있는 주소를 알 수 있으므로, 저장 및 탐색 속도가 획기적으로 빨라짐
- 미리 해쉬 함수가 생성할 수 있는 주소(인덱스 번호)에 대한 공간을 배열로 할당한 후, 키에 따른 데이터 저장 및 탐색 지원

### 알아둘 용어

- 해쉬 함수(Hash Function): 임의의 데이터를 고정된 길이의 값으로 리턴해주는 함수
  - 해쉬 (Hash), 해쉬 값(Hash Value), 또는 해쉬 주소(Hash Address): 해싱 함수를 통해 리턴된 고정된 길이의 값
- 해쉬 테이블(Hash Table): 키 값의 연산에 의해 직접 접근이 가능한 데이터 구조
  - 슬롯(Slot): 해쉬 테이블에서 한 개의 데이터를 저장할 수 있는 공간
    <img src="https://www.fun-coding.org/00_Images/hashtable2021.jpg" />

### 자료 구조 해쉬 테이블의 장단점과 주요 용도

- 장점
  - 데이터 저장/읽기 속도가 빠르다. (검색 속도가 빠르다.)
  - 해쉬는 키에 대한 데이터가 있는지(중복) 확인이 쉬움
- 단점
  - 일반적으로 저장공간이 좀더 많이 필요하다.
  - **여러 키에 해당하는 주소가 동일할 경우 충돌을 해결하기 위한 별도 자료구조가 필요함**
- 주요 용도
  - 검색이 많이 필요한 경우
  - 저장, 삭제, 읽기가 빈번한 경우
  - 캐쉬 구현시 (중복 확인이 쉽기 때문)

### 충돌(Collision) 해결 알고리즘 (좋은 해쉬 함수 사용하기)

> 해쉬 테이블의 가장 큰 문제는 충돌(Collision)의 경우입니다. 이 문제를 충돌(Collision) 또는 해쉬 충돌(Hash Collision)이라고 부릅니다.

#### Chaining 기법

- **개방 해슁 또는 Open Hashing 기법** 중 하나: 해쉬 테이블 저장공간 외의 공간을 활용하는 기법
- 충돌이 일어나면, 링크드 리스트라는 자료 구조를 사용해서, 링크드 리스트로 데이터를 추가로 뒤에 연결시켜서 저장하는 기법

#### Linear Probing 기법

- **폐쇄 해슁 또는 Close Hashing 기법** 중 하나: 해쉬 테이블 저장공간 안에서 충돌 문제를 해결하는 기법
- 충돌이 일어나면, 해당 hash address의 다음 address부터 맨 처음 나오는 빈공간에 저장하는 기법
  - 저장공간 활용도를 높이기 위한 기법

#### 빈번한 충돌을 개선하는 기법

- 해쉬 테이블 저장공간을 확대 및 해쉬 함수 재정의

### 시간 복잡도

- 일반적인 경우(Collision이 없는 경우)는 O(1)
- 최악의 경우(Collision이 모두 발생하는 경우)는 O(n)
- Linear Probing, Chaining 기법 둘 다 동일

> 해쉬 테이블의 경우는 일반적인 경우를 기대하고 작성함

### 검색에서 해쉬 테이블의 사용 예

- 배열에 데이터를 저장하고, 검색할 때 O(n)
- 이상적인 해쉬 테이블 케이스에서 데이터를 검색할 때 O(1)

---

# 트리 (Tree)

- 트리: Node와 Branch를 이용해서, 사이클을 이루지 않도록 구성한 데이터 구조
- 실제로 어디에 많이 사용되나?
  - 트리 중 이진 트리 (Binary Tree) 형태의 구조로, 탐색(검색) 알고리즘 구현을 위해 많이 사용됨

### 알아둘 용어

- Node: 트리에서 데이터를 저장하는 기본 요소 (데이터와 다른 연결된 노드에 대한 Branch 정보 포함)
- Root Node: 트리 맨 위에 있는 노드
- Level: 최상위 노드를 Level 0으로 하였을 때, 하위 Branch로 연결된 노드의 깊이를 나타냄
- Parent Node: 어떤 노드의 다음 레벨에 연결된 노드
- Child Node: 어떤 노드의 상위 레벨에 연결된 노드
- Leaf Node (Terminal Node): Child Node가 하나도 없는 노드
- Sibling (Brother Node): 동일한 Parent Node를 가진 노드
- Depth: 트리에서 Node가 가질 수 있는 최대 Level
  <img src="http://www.fun-coding.org/00_Images/tree.png" width="600" />

### 이진 트리와 이진 탐색 트리 (Binary Search Tree)

- 이진 트리: 노드의 최대 Branch가 2인 트리
- 이진 탐색 트리 (Binary Search Tree, BST): 이진 트리에 다음과 같은 추가적인 조건이 있는 트리
  - 왼쪽 노드는 해당 노드보다 작은 값, 오른쪽 노드는 해당 노드보다 큰 값을 가지고 있음!

<img src="https://www.mathwarehouse.com/programming/images/binary-search-tree/binary-search-tree-insertion-animation.gif" />

### 자료 구조 이진 탐색 트리의 장점과 주요 용도

- 주요 용도: 데이터 검색(탐색)
- 장점: 탐색 속도를 개선할 수 있음

### 이진트리와 정렬된 배열간의 탐색 비교

<img src="https://www.mathwarehouse.com/programming/images/binary-search-tree/binary-search-tree-sorted-array-animation.gif" />

### 이진 탐색 트리 삭제

#### Leaf Node 삭제

- Leaf Node: Child Node 가 없는 Node
- 삭제할 Node의 Parent Node가 삭제할 Node를 가리키지 않도록 한다.
  <img src="http://www.fun-coding.org/00_Images/tree_remove_leaf.png" width="800" />

#### Child Node 가 하나인 Node 삭제

- 삭제할 Node의 Parent Node가 삭제할 Node의 Child Node를 가리키도록 한다.
  <img src="http://www.fun-coding.org/00_Images/tree_remove_1child.png" width="800" />

#### Child Node 가 두 개인 Node 삭제

1. **삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 삭제할 Node의 Parent Node가 가리키도록 한다.**
2. 삭제할 Node의 왼쪽 자식 중, 가장 큰 값을 삭제할 Node의 Parent Node가 가리키도록 한다.
   <img src="http://www.fun-coding.org/00_Images/tree_remove_2child.png" width="800" />

##### 삭제할 Node의 오른쪽 자식중, 가장 작은 값을 삭제할 Node의 Parent Node가 가리키게 할 경우

- 삭제할 Node의 오른쪽 자식 선택
- 오른쪽 자식의 가장 왼쪽에 있는 Node를 선택
- 해당 Node를 삭제할 Node의 Parent Node의 왼쪽 Branch가 가리키게 함
- 해당 Node의 왼쪽 Branch가 삭제할 Node의 왼쪽 Child Node를 가리키게 함
- 해당 Node의 오른쪽 Branch가 삭제할 Node의 오른쪽 Child Node를 가리키게 함
- 만약 해당 Node가 오른쪽 Child Node를 가지고 있었을 경우에는, 해당 Node의 본래 Parent Node의 왼쪽 Branch가 해당 오른쪽 Child Node를 가리키게 함

### 이진 탐색 트리의 시간 복잡도와 단점

#### 시간 복잡도 (탐색시)

- depth (트리의 높이) 를 h라고 표기한다면, O(h)
- n개의 노드를 가진다면, h = log_2 n 에 가까우므로, 시간 복잡도는 O(log n) - 참고: 빅오 표기법에서 log n 에서의 log의 밑은 10이 아니라, 2입니다. - 한번 실행시마다, 50%의 실행할 수도 있는 명령을 제거한다는 의미. 즉 50%의 실행시간을 단축시킬 수 있다는 것을 의미함
  <img src="https://www.mathwarehouse.com/programming/images/binary-search-tree/binary-search-tree-sorted-array-animation.gif" />

#### 이진 탐색 트리 단점

- 평균 시간 복잡도는 O(log n) 이지만,
  - 이는 트리가 균형잡혀 있을 때의 평균 시간복잡도이며,
- 다음 예와 같이 구성되어 있을 경우, 최악의 경우는 링크드 리스트등과 동일한 성능을 보여줌 ( O(n) )
  <img src="http://www.fun-coding.org/00_Images/worstcase_bst.png" width="300" />

---

# 힙 (Heap)

- 힙: 데이터에서 최대값과 최소값을 빠르게 찾기 위해 고안된 완전 이진 트리(Complete Binary Tree)
  - 완전 이진 트리: 노드를 삽입할 때 최하단 왼쪽 노드부터 차례대로 삽입하는 트리

<img src="https://www.fun-coding.org/00_Images/completebinarytree.png" width=300>

- 힙을 사용하는 이유
  - 배열에 데이터를 넣고, 최대값과 최소값을 찾으려면 O(n) 이 걸림
  - 이에 반해, 힙에 데이터를 넣고, 최대값과 최소값을 찾으면, O(log n) 이 걸림
  - 우선순위 큐와 같이 최대값 또는 최소값을 빠르게 찾아야 하는 자료구조 및 알고리즘 구현 등에 활용됨

### 2. 힙 (Heap) 구조

- 힙은 최대값을 구하기 위한 구조 (최대 힙, Max Heap) 와, 최소값을 구하기 위한 구조 (최소 힙, Min Heap) 로 분류할 수 있음
- 힙은 다음과 같이 두 가지 조건을 가지고 있는 자료구조임
  1. 각 노드의 값은 해당 노드의 자식 노드가 가진 값보다 크거나 같다. (최대 힙의 경우)
     - 최소 힙의 경우는 각 노드의 값은 해당 노드의 자식 노드가 가진 값보다 크거나 작음
  2. 완전 이진 트리 형태를 가짐

### 힙과 이진 탐색 트리의 공통점과 차이점

- 공통점: 힙과 이진 탐색 트리는 모두 이진 트리임
- 차이점:
  - 힙은 각 노드의 값이 자식 노드보다 크거나 같음(Max Heap의 경우)
  - 이진 탐색 트리는 왼쪽 자식 노드의 값이 가장 작고, 그 다음 부모 노드, 그 다음 오른쪽 자식 노드 값이 가장 큼
  - 힙은 이진 탐색 트리의 조건인 자식 노드에서 작은 값은 왼쪽, 큰 값은 오른쪽이라는 조건은 없음
    - 힙의 왼쪽 및 오른쪽 자식 노드의 값은 오른쪽이 클 수도 있고, 왼쪽이 클 수도 있음
- 이진 탐색 트리는 탐색을 위한 구조, 힙은 최대/최소값 검색을 위한 구조 중 하나로 이해하면 됨  
  <img src="https://www.fun-coding.org/00_Images/completebinarytree_bst.png" width="800" />

### 힙에 데이터 삽입하기 - 기본 동작

- 힙은 완전 이진 트리이므로, 삽입할 노드는 기본적으로 왼쪽 최하단부 노드부터 채워지는 형태로 삽입
  <img src="https://www.fun-coding.org/00_Images/heap_ordinary.png">

### 힙에 데이터 삽입하기 - 삽입할 데이터가 힙의 데이터보다 클 경우 (Max Heap 의 예)

- 먼저 삽입된 데이터는 완전 이진 트리 구조에 맞추어, 최하단부 왼쪽 노드부터 채워짐
- 채워진 노드 위치에서, 부모 노드보다 값이 클 경우, 부모 노드와 위치를 바꿔주는 작업을 반복함 (swap)
  <img src="https://www.fun-coding.org/00_Images/heap_insert.png">

### 힙의 데이터 삭제하기 (Max Heap 의 예)

- 보통 삭제는 최상단 노드 (root 노드)를 삭제하는 것이 일반적임
  - 힙의 용도는 최대값 또는 최소값을 root 노드에 놓아서, 최대값과 최소값을 바로 꺼내 쓸 수 있도록 하는 것임
- 상단의 데이터 삭제시, 가장 최하단부 왼쪽에 위치한 노드 (일반적으로 가장 마지막에 추가한 노드) 를 root 노드로 이동
- root 노드의 값이 child node 보다 작을 경우, root 노드의 child node 중 가장 큰 값을 가진 노드와 root 노드 위치를 바꿔주는 작업을 반복함 (swap)
  <img src="https://www.fun-coding.org/00_Images/heap_remove.png">

### 힙 구현

- 일반적으로 힙 구현시 배열 자료구조를 활용함
- 배열은 인덱스가 0번부터 시작하지만, 힙 구현의 편의를 위해, root 노드 인덱스 번호를 1로 지정하면, 구현이 좀더 수월함
  - 부모 노드 인덱스 번호 (parent node's index) = 자식 노드 인덱스 번호 (child node's index) / 2
    - JAVA 에서는 / 연산자로 몫 을 구할 수 있음
  - 왼쪽 자식 노드 인덱스 번호 (left child node's index) = 부모 노드 인덱스 번호 (parent node's index) \* 2
  - 오른쪽 자식 노드 인덱스 번호 (right child node's index) = 부모 노드 인덱스 번호 (parent node's index) \* 2 + 1
    <img src="https://www.fun-coding.org/00_Images/heap_array.png" width=400>

### 힙 구현에 사용된 Collections.swap() 메서드 사용법 이해하기

- swap (스왑) 이란, 두 데이터의 위치를 맞바꾸는 것을 의미함
- swap 함수를 별도로 구현할 수도 있지만, JAVA 에서는 Collections 패키지에서 swap() 메서드를 제공해주고 있음
  - 하나의 배열 안에 있는 두 데이터의 위치를 서로 맞바꾸고 싶을 때 사용 가능

```
import  java.util.Collections;

Collections.swap(List list, int a, int b)
```

- list : 스왑할 데이터들이 들어 있는 배열 변수
- a : 스왑할 데이터 인덱스 번호
- b : 스왑할 데이터 인덱스 번호

### 힙 (Heap) 시간 복잡도

- depth (트리의 높이) 를 h라고 표기한다면,
- n개의 노드를 가지는 heap 에 데이터 삽입 또는 삭제시, 최악의 경우 root 노드에서 leaf 노드까지 비교해야 하므로 h = log_2 n 에 가까우므로, 시간 복잡도는 O(log n)
