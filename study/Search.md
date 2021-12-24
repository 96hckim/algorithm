# 순차 탐색 (Sequential Search)

- 탐색은 여러 데이터 중에서 원하는 데이터를 찾아내는 것을 의미
- 데이터가 담겨있는 배열을 앞에서부터 하나씩 비교해서 원하는 데이터를 찾는 방법

### 알고리즘 구현

```java
import java.util.ArrayList;

public class SequencialSearch {
    public int searchFunc(ArrayList<Integer> dataList, Integer searchItem) {
        for (int index = 0; index < dataList.size(); index++) {
            if (dataList.get(index) == searchItem) {
                return index;
            }
        }
        return -1;
    }
}
```

### 알고리즘 분석

- 최악의 경우 리스트 길이가 n일 때, n번 비교해야 함
  - O(n)

---

# 이진 탐색 (Binary Search)

- 탐색할 자료를 둘로 나누어 해당 데이터가 있을만한 곳을 탐색하는 방법

### 이진 탐색의 이해 (순차 탐색과 비교하며 이해하기)

<img src="https://www.mathwarehouse.com/programming/images/binary-vs-linear-search/binary-and-linear-search-animations.gif">

### 분할 정복 알고리즘과 이진 탐색

- 분할 정복 알고리즘 (Divide and Conquer)
  - Divide: 문제를 하나 또는 둘 이상으로 나눈다.
  - Conquer: 나눠진 문제가 충분히 작고, 해결이 가능하다면 해결하고, 그렇지 않다면 다시 나눈다.
- 이진 탐색
  - Divide: 리스트를 두 개의 서브 리스트로 나눈다.
  - Comquer
    - 검색할 숫자 (search) > 중간값 이면, 뒷 부분의 서브 리스트에서 검색할 숫자를 찾는다.
    - 검색할 숫자 (search) < 중간값 이면, 앞 부분의 서브 리스트에서 검색할 숫자를 찾는다.

### 알고리즘 구현

```java
import java.util.ArrayList;

public class BinarySearch {
    public boolean searchFunc(ArrayList<Integer> dataList, Integer searchItem) {
        if (dataList.size() == 1 && searchItem == dataList.get(0)) {
            return true;
        }
        if (dataList.size() == 1 && searchItem != dataList.get(0)) {
            return false;
        }
        if (dataList.size() == 0) {
            return false;
        }

        int medium = dataList.size() / 2;

        if (searchItem == dataList.get(medium)) {
            return true;
        } else {
            if (searchItem < dataList.get(medium)) {
                return this.searchFunc(new ArrayList<Integer>(dataList.subList(0, medium)), searchItem);
            } else {
                 return this.searchFunc(new ArrayList<Integer>(dataList.subList(medium + 1, dataList.size())), searchItem);
            }
        }
    }
}
```

### 알고리즘 분석

- n개의 리스트를 매번 2로 나누어 1이 될 때까지 비교연산을 k회 진행
  - <font size=4em>n X frac{1}{2} X frac{1}{2} X frac{1}{2} ... = 1</font>
  - <font size=4em>n X frac{1}{2}^k = 1</font>
  - <font size=4em>n = 2^k = log_2 n = log_2 2^k</font>
  - <font size=4em>log_2 n = k</font>
  - 빅 오 표기법으로는 k + 1 이 결국 최종 시간 복잡도임 (1이 되었을 때도, 비교연산을 한번 수행)
    - 결국 O(log_2 n + 1) 이고, 2와 1, 상수는 삭제 되므로, O(log n)
