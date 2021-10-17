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
