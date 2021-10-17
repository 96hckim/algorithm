# BFS 와 DFS 란?

- 대표적인 그래프 **탐색** 알고리즘
  - 너비 우선 탐색 (Breadth First Search): 정점들과 같은 레벨에 있는 노드들 (형제 노드들)을 먼저 탐색하는 방식
  - 깊이 우선 탐색 (Depth First Search): 정점의 자식들을 먼저 탐색하는 방식

### BFS/DFS 방식 이해를 위한 예제

- BFS 방식: A - B - C - D - G - H - I - E - F - J
  - 한 단계씩 내려가면서, 해당 노드와 같은 레벨에 있는 노드들 (형제 노드들)을 먼저 순회함
- DFS 방식: A - B - D - E - F - C - G - H - I - J
  - 한 노드의 자식을 타고 끝까지 순회한 후, 다시 돌아와서 다른 형제들의 자식을 타고 내려가며 순화함

<img src="https://www.fun-coding.org/00_Images/BFSDFS.png" width=700>

### JAVA 로 그래프를 표현하는 방법

- Java Collection Framework 에서 제공하는 Hashmap 과 ArrayList 를 활용해서 그래프를 표현할 수 있음

### 그래프 예와 JAVA 표현

<img src="https://www.fun-coding.org/00_Images/bfsgraph.png" width=700>

# 너비 우선 탐색 (Breadth-First Search)

### 알고리즘 구현

- 자료구조 큐를 활용함
  - needVisit 큐와 visited 큐, 두 개의 큐를 생성

<img src="https://www.fun-coding.org/00_Images/bfsqueue.png" width=700>

```java
HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();

graph.put("A", new ArrayList<String>(Arrays.asList("B", "C")));
graph.put("B", new ArrayList<String>(Arrays.asList("A", "D")));
graph.put("C", new ArrayList<String>(Arrays.asList("A", "G", "H", "I")));
graph.put("D", new ArrayList<String>(Arrays.asList("B", "E", "F")));
graph.put("E", new ArrayList<String>(Arrays.asList("D")));
graph.put("F", new ArrayList<String>(Arrays.asList("D")));
graph.put("G", new ArrayList<String>(Arrays.asList("C")));
graph.put("H", new ArrayList<String>(Arrays.asList("C")));
graph.put("I", new ArrayList<String>(Arrays.asList("C", "J")));
graph.put("J", new ArrayList<String>(Arrays.asList("I")));
```

```java
import java.util.ArrayList;
import java.util.HashMap;

public class BFSSearch {
    public ArrayList<String> bfsFunc(HashMap<String, ArrayList<String>> grpah, String startNode) {
        ArrayList<String> visited = new ArrayList<String>();
        ArrayList<String> needVisit = new ArrayList<String>();

        needVisit.add(startNode);

        while (needVisit.size() > 0) {
            String node = needVisit.remove(0);

            if (!visited.contains(node)) {
                visited.add(node);
                needVisit.addAll(graph.get(node));
            }
        }
        return visited;
    }
}
```

### 시간 복잡도

- 일반적인 BFS 시간 복잡도
  - 노드 수: V
  - 간선 수: E
    - 위 코드에서 while needVisit 은 V + E 번 만큼 수행함
  - 시간 복잡도: O(V + E)
