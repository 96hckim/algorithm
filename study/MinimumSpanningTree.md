# 최소 신장 트리 알고리즘

- 그래프에서 최소 신장 트리를 찾을 수 있는 알고리즘이 존재함
- 대표적인 최소 신장 트리 알고리즘
  - Kruskal’s algorithm (크루스칼 알고리즘), Prim's algorithm (프림 알고리즘)

# 크루스칼 알고리즘 (Kruskal's algorithm)

1. 모든 정점을 독립적인 집합으로 만든다.
2. 모든 간선을 비용을 기준으로 정렬하고, 비용이 작은 간선부터 양 끝의 두 정점을 비교한다.
3. 두 정점의 최상위 정점을 확인하고, 서로 다를 경우 두 정점을 연결한다. (최소 신장 트리는 사이클이 없으므로, 사이클이 생기지 않도록 하는 것임)

> 탐욕 알고리즘을 기초로 하고 있음 (당장 눈 앞의 최소 비용을 선택해서, 결과적으로 최적의 솔루션을 찾음)

<img src="https://www.fun-coding.org/00_Images/kruscal_internal1.png" width=650>

<img src="https://www.fun-coding.org/00_Images/kruscal_internal2.png" width=800>

### Union-Find 알고리즘

- Disjoint Set을 표현할 때 사용하는 알고리즘으로 트리 구조를 활용하는 알고리즘
- 간단하게, 노드들 중에 연결된 노드를 찾거나, 노드들을 서로 연결할 때 (합칠 때) 사용
- Disjoint Set이란
  - 서로 중복되지 않는 부분 집합들로 나눠진 원소들에 대한 정보를 저장하고 조작하는 자료구조
  - 공통 원소가 없는 (서로소) 상호 배타적인 부분 집합들로 나눠진 원소들에 대한 자료구조를 의미함
  - Disjoint Set = 서로소 집합 자료구조

### Union-Find 알고리즘의 고려할 점

- Union 순서에 따라서, 최악의 경우 링크드 리스트와 같은 형태가 될 수 있음.
- 이 때는 Find/Union 시 계산량이 O(N) 이 될 수 있으므로, 해당 문제를 해결하기 위해, union-by-rank, path compression 기법을 사용함

<img src="https://www.fun-coding.org/00_Images/worst_findunion.png" width=200>

### union-by-rank 기법

- 각 트리에 대해 높이(rank)를 기억해 두고,
- Union시 두 트리의 높이(rank)가 다르면, 높이가 작은 트리를 높이가 큰 트리에 붙임 (즉, 높이가 큰 트리의 루트 노드가 합친 집합의 루트 노드가 되게 함)
  <img src="https://www.fun-coding.org/00_Images/unionbyrank_findunion.png" width=700>

- 높이가 h - 1 인 두 개의 트리를 합칠 때는 한 쪽의 트리 높이를 1 증가시켜주고, 다른 쪽의 트리를 해당 트리에 붙여줌
  <img src="https://www.fun-coding.org/00_Images/unionbyranksame_findunion.png" width=700>

- 초기화시, 모든 원소는 높이(rank) 가 0 인 개별 집합인 상태에서, 하나씩 원소를 합칠 때, union-by-rank 기법을 사용한다면,
  - 높이가 h 인 트리가 만들어지려면, 높이가 h - 1 인 두 개의 트리가 합쳐져야 함
  - 높이가 h - 1 인 트리를 만들기 위해 최소 n개의 원소가 필요하다면, 높이가 h 인 트리가 만들어지기 위해서는 최소 2n개의 원소가 필요함
  - 따라서 union-by-rank 기법을 사용하면, union/find 연산의 시간복잡도는 O(N) 이 아닌, $ O(log{N}) $ 로 낮출 수 있음

### path compression

- Find를 실행한 노드에서 거쳐간 노드를 루트에 다이렉트로 연결하는 기법
- Find를 실행한 노드는 이후부터는 루트 노드를 한번에 알 수 있음

<center><img src="https://www.fun-coding.org/00_Images/pathcompression_findunion.png" width=400></center>

- union-by-rank 와 path compression 기법 사용시 시간 복잡도는 다음 계산식을 만족함이 증명되었음
  - $ O(M log^\*{N}) $
  - $ log^\*{N} $ 은 다음 값을 가짐이 증명되었음
    - N이 $ 2^{65536} $ 값을 가지더라도, $ log^\*{N} $ 의 값이 5의 값을 가지므로, 거의 O(1), 즉 상수값에 가깝다고 볼 수 있음

### Edge 클래스 정의

```java
public class Edge implements Comparable<Edge> {
    public int weight;
    public String nodeV;
    public String nodeU;

    public Edge(int weight, String nodeV, String nodeU) {
        this.weight = weight;
        this.nodeV = nodeV;
        this.nodeU = nodeU;
    }

    public String toString() {
        return "(" + this.weight + ", " + this.nodeV + ", " + this.nodeU + ")";
    }

    @Override
    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }
}
```

### Edge 데이터 자료구조화

```java
ArrayList<String> vetices = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
ArrayList<Edge> edges = new ArrayList<Edge>();
edges.add(new Edge(7, "A", "B"));
edges.add(new Edge(5, "A", "D"));
edges.add(new Edge(7, "B", "A"));
edges.add(new Edge(8, "B", "C"));
edges.add(new Edge(9, "B", "D"));
edges.add(new Edge(7, "B", "E"));
edges.add(new Edge(8, "C", "B"));
edges.add(new Edge(5, "C", "E"));
edges.add(new Edge(5, "D", "A"));
edges.add(new Edge(9, "D", "B"));
edges.add(new Edge(7, "D", "E"));
edges.add(new Edge(6, "D", "F"));
edges.add(new Edge(7, "E", "B"));
edges.add(new Edge(5, "E", "C"));
edges.add(new Edge(7, "E", "D"));
edges.add(new Edge(8, "E", "F"));
edges.add(new Edge(9, "E", "G"));
edges.add(new Edge(6, "F", "D"));
edges.add(new Edge(8, "F", "E"));
edges.add(new Edge(11, "F", "G"));
edges.add(new Edge(9, "G", "E"));
edges.add(new Edge(11, "G", "F"));
```

### 알고리즘 구현

```java
public class KruskalPath {
    HashMap<String, String> parent = new HashMap<String, String>();
    HashMap<String, Integer> rank = new HashMap<String, Integer>();

    public String find(String node) {
        // path compresion 기법
        if (this.parent.get(node) != node) {
            this.parent.put(node, this.find(this.parent.get(node)));
        }
        return this.parent.get(node);
    }

    public void union(String nodeV, String nodeU) {
        String root1 = this.find(nodeV);
        String root2 = this.find(nodeU);

        // union-by-rank 기법
        if (this.rank.get(root1) > this.rank.get(root2)) {
            this.parent.put(root2, root1);
        } else {
            this.parent.put(root1, root2);
            if (this.rank.get(root1) == this.rank.get(root2)) {
                this.rank.put(root2, this.rank.get(root2) + 1);
            }
        }
    }

    public void makeSet(String node) {
        this.parent.put(node, node);
        this.rank.put(node, 0);
    }

    public ArrayList<Edge> kruskalFunc(ArrayList<String> vertices, ArrayList<Edge> edges) {
        ArrayList<Edge> mst = new ArrayList<Edge>();
        Edge currentEdge;

        // 1. 초기화
        for (int index = 0; index < vertices.size(); index++) {
            this.makeSet(vertices.get(index));
        }

        // 2. 간선 weight 기반 sorting
        Collections.sort(edges);

        for (int index = 0; index < edges.size(); index++) {
            currentEdge = edges.get(index);
            if (this.find(currentEdge.nodeV) != this.find(currentEdge.nodeU)) {
                this.union(currentEdge.nodeV, currentEdge.nodeU);
                mst.add(currentEdge);
            }
        }

        return mst;
    }
}
```

### 시간 복잡도

- 크루스컬 알고리즘의 시간 복잡도는 O(E log E)
  - 다음 단계에서 2번, 간선을 비용 기준으로 정렬하는 시간에 좌우됨 (즉 간선을 비용 기준으로 정렬하는 시간이 가장 큼)
  1. 모든 정점을 독립적인 집합으로 만든다.
  2. 모든 간선을 비용을 기준으로 정렬하고, 비용이 작은 간선부터 양 끝의 두 정점을 비교한다.
     - 퀵소트를 사용한다면 시간 복잡도는 O(n log n) 이며, 간선이 n 이므로 O(E log E)
  3. 두 정점의 최상위 정점을 확인하고, 서로 다를 경우 두 정점을 연결한다. (최소 신장 트리는 사이클이 없으므로, 사이클이 생기지 않도록 하는 것임)
     - union-by-rank 와 path compression 기법 사용시 시간 복잡도가 결국 상수값에 가까움, O(1)

---

# 프림 알고리즘 (Prim's algorithm)

- 대표적인 최소 신장 트리 알고리즘
  - Kruskal’s algorithm (크루스칼 알고리즘), Prim's algorithm (프림 알고리즘)
- 프림 알고리즘
  - 시작 정점을 선택한 후, 정점에 인접한 간선중 최소 간선으로 연결된 정점을 선택하고, 해당 정점에서 다시 최소 간선으로 연결된 정점을 선택하는 방식으로 최소 신장 트리를 확장해가는 방식
- Kruskal's algorithm 과 Prim's algorithm 비교
  - 둘다, 탐욕 알고리즘을 기초로 하고 있음 (당장 눈 앞의 최소 비용을 선택해서, 결과적으로 최적의 솔루션을 찾음)
  - Kruskal's algorithm은 가장 가중치가 작은 간선부터 선택하면서 MST를 구함
  - Prim's algorithm은 특정 정점에서 시작, 해당 정점에 연결된 가장 가중치가 작은 간선을 선택, 간선으로 연결된 정점들에 연결된 간선 중에서 가장 가중치가 작은 간선을 택하는 방식으로 MST를 구함

### 그림으로 이해하는 프림 알고리즘

1. 임의의 정점을 선택, '연결된 노드 집합'에 삽입
2. 선택된 정점에 연결된 간선들을 간선 리스트에 삽입
3. 간선 리스트에서 최소 가중치를 가지는 간선부터 추출해서,
   - 해당 간선에 연결된 인접 정점이 '연결된 노드 집합'에 이미 들어 있다면, 스킵함(cycle 발생을 막기 위함)
   - 해당 간선에 연결된 인접 정점이 '연결된 노드 집합'에 들어 있지 않으면, 해당 간선을 선택하고, 해당 간선 정보를 '최소 신장 트리'에 삽입
4. 추출한 간선은 간선 리스트에서 제거
5. 간선 리스트에 더 이상의 간선이 없을 때까지 3-4번을 반복

<img src="https://www.fun-coding.org/00_Images/prim_java_1.jpg" width=800>

<img src="https://www.fun-coding.org/00_Images/prim_java_2.jpg" width=800>

<img src="https://www.fun-coding.org/00_Images/prim_java_3.jpg" width=800>

### 알고리즘 구현

0. 모든 간선 정보를 저장 (**adjacentEdges**)
1. 임의의 정점을 선택, '연결된 노드 집합(**connectedNodes**)'에 삽입
2. 선택된 정점에 연결된 간선들을 간선 리스트(**candidateEdgeList**)에 삽입
3. 간선 리스트(**candidateEdgeList**)에서 최소 가중치를 가지는 간선부터 추출해서,

   - 해당 간선에 연결된 인접 정점이 '연결된 노드 집합'에 이미 들어 있다면, 스킵함(cycle 발생을 막기 위함)
   - 해당 간선에 연결된 인접 정점이 '연결된 노드 집합'에 들어 있지 않으면, 해당 간선을 선택하고, 해당 간선 정보를 '최소 신장 트리(**mst**)'에 삽입
     - 해당 간선에 연결된 인접 정점의 간선들 중, '연결된 노드 집합(**connectedNodes**)' 에 없는 노드와 연결된 간선들만 간선 리스트(**candidateEdgeList**) 에 삽입
       - '연결된 노드 집합(**connectedNodes**)' 에 있는 노드와 연결된 간선들을 간선 리스트에 삽입해도, 해당 간선은 스킵될 것이기 때문임
       - 어차피 스킵될 간선을 간선 리스트(**candidateEdgeList**)에 넣지 않으므로 해서, 간선 리스트(**candidateEdgeList**)에서 최소 가중치를 가지는 간선부터 추출하기 위한 자료구조 유지를 위한 effort를 줄일 수 있음 (예, 최소힙 구조 사용)

4. 선택된 간선은 간선 리스트에서 제거
5. 간선 리스트에 더 이상의 간선이 없을 때까지 3-4번을 반복

```java
import java.util.HashMap;
import java.util.PriorityQueue;

public class PrimPath {
    public ArrayList<Edge> primFunc(String startNode, ArrayList<Edge> edges) {
        Edge currentEdge, poppedEdge, adjacentEdgeNode;
        ArrayList<Edge> currentEdgeList, candidateEdgeList, adjacentEdgeNodes;
        PriorityQueue<Edge> priorityQueue;

        ArrayList<String> connectedNodes = new ArrayList<String>();
        ArrayList<Edge> mst = new ArrayList<Edge>();
        HashMap<String, ArrayList<Edge>> adjacentEdges = new HashMap<String, ArrayList<Edge>>();

        for (int index = 0; index < edges.size(); index++) {
            currentEdge = edges.get(index);
            if (!adjacentEdges.containsKey(currentEdge.node1)) {
                adjacentEdges.put(currentEdge.node1, new ArrayList<Edge>());
            }
            if (!adjacentEdges.containsKey(currentEdge.node2)) {
                adjacentEdges.put(currentEdge.node2, new ArrayList<Edge>());
            }
        }

        for (int index = 0; index < edges.size(); index++) {
            currentEdge = edges.get(index);
            currentEdgeList = adjacentEdges.get(currentEdge.node1);
            currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.node1, currentEdge.node2));
            currentEdgeList = adjacentEdges.get(currentEdge.node2);
            currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.node2, currentEdge.node1));
        }

        connectedNodes.add(startNode);
        candidateEdgeList = adjacentEdges.getOrDefault(startNode, new ArrayList<Edge>());
        priorityQueue = new PriorityQueue<Edge>();
        for (int index = 0; index < candidateEdgeList.size(); index++) {
            priorityQueue.add(candidateEdgeList.get(index));
        }

        while (priorityQueue.size() > 0) {
            poppedEdge = priorityQueue.poll();
            if (!connectedNodes.contains(poppedEdge.node2)) {
                // 해당 edge 를 mst 에 추가
                connectedNodes.add(poppedEdge.node2);
                mst.add(new Edge(poppedEdge.weight, poppedEdge.node1, poppedEdge.node2));

                adjacentEdgeNodes = adjacentEdges.getOrDefault(poppedEdge.node2, new ArrayList<Edge>());
                for (int index = 0; index < adjacentEdgeNodes.size(); index++) {
                    adjacentEdgeNode = adjacentEdgeNodes.get(index);
                    if(!connectedNodes.contains(adjacentEdgeNode.node2)) {
                        priorityQueue.add(adjacentEdgeNode);
                    }
                }
            }
        }
        return mst;

    }
}
```

### 시간 복잡도

- 최악의 경우, while 구문에서 모든 간선에 대해 반복하고, 최소 힙 구조를 사용하므로 O($ElogE$) 시간 복잡도를 가짐

### 참고: 개선된 프림 알고리즘

- 간선이 아닌 노드를 중심으로 우선순위 큐를 적용하는 방식

  - 초기화 - 정점:key 구조를 만들어놓고, 특정 정점의 key값은 0, 이외의 정점들의 key값은 무한대로 놓음. 모든 정점:key 값은 우선순위 큐에 넣음
  - 가장 key값이 적은 정점:key를 추출한 후(pop 하므로 해당 정점:key 정보는 우선순위 큐에서 삭제됨), (extract min 로직이라고 부름)
  - 해당 정점의 인접한 정점들에 대해 key 값과 연결된 가중치 값을 비교하여 key값이 작으면 해당 정점:key 값을 갱신
    - 정점:key 값 갱신시, 우선순위 큐는 최소 key값을 가지는 정점:key 를 루트노드로 올려놓도록 재구성함 (decrease key 로직이라고 부름)

- 개선된 프림 알고리즘 구현시 고려 사항
  - 우선순위 큐(최소힙) 구조에서, 이미 들어가 있는 데이터의 값 변경시, 최소값을 가지는 데이터를 루트노드로 올려놓도록 재구성하는 기능이 필요함

### 알고리즘 구현

- 실제 경로를 출력해보기 위해, ArrayList<Path> 자료구조 사용
- 총 weight (총 거리)를 totalWeight 에 저장
- 우선순위 큐를 통해 PriorityQueue<Edge> 힙구조를 사용하되,
  - 우선순위 큐에 들어 있는 각 Edge 의 weight 조회와, 특정 Edge 삭제를 가능토록 각 Edge 객체를 별도 HashMap 으로 관리
    -HashMap<String, Edge> keysObjects = new HashMap<String, Edge>()

```java
import java.util.HashMap;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimPath {
    public ArrayList<Path> improvedPrimFunc(HashMap<String, HashMap<String, Integer>> graph, String startNode) {
        ArrayList<Path> mst = new ArrayList<Path>();
        PriorityQueue<Edge> keys = new PriorityQueue<Edge>();
        HashMap<String, Edge> keysObjects = new HashMap<String, Edge>();
        HashMap<String, String> mstPath = new HashMap<String, String>();
        Integer totalWeight = 0;
        HashMap<String, Integer> linkedEdges;
        Edge edgeObject, poppedEdge, linkedEdge;

        for (String key : graph.keySet()) {
            if (key == startNode) {
                edgeObject = new Edge(key, 0);
                mstPath.put(key, key);
            } else {
                edgeObject = new Edge(key, Integer.MAX_VALUE);
                mstPath.put(key, null);
            }
            keys.add(edgeObject);
            keysObjects.put(key, edgeObject);
        }

        while (keys.size() > 0) {
            poppedEdge = keys.poll();
            keysObjects.remove(poppedEdge.node);

            mst.add(new Path(mstPath.get(poppedEdge.node), poppedEdge.node, poppedEdge.weight));
            totalWeight += poppedEdge.weight;

            linkedEdges = graph.get(poppedEdge.node);
            for (String adjacent : linkedEdges.keySet()) {
                if (keysObjects.containsKey(adjacent)) {
                    linkedEdge = keysObjects.get(adjacent);

                    if (linkedEdges.get(adjacent) < linkedEdge.weight) {
                        linkedEdge.weight = linkedEdges.get(adjacent);
                        mstPath.put(adjacent, poppedEdge.node);

                        keys.remove(linkedEdge);
                        keys.add(linkedEdge);
                    }
                }
            }
        }

        System.out.println(totalWeight);
        return mst;
    }
}
```

### 개선된 프림 알고리즘의 시간 복잡도: $ O(ElogV) $

- 최초 key 생성 시간 복잡도: $ O(V) $
- while 구문과 keys.poll() 의 시간 복잡도는 $ O(VlogV) $
  - while 구문은 V(노드 갯수) 번 실행됨
  - heap 에서 최소 key 값을 가지는 노드 정보 추출 시(pop)의 시간 복잡도: $ O(logV) $
- for 구문의 총 시간 복잡도는 $ O(ElogV) $
  - for 구문은 while 구문 반복시에 결과적으로 총 최대 간선의 수 E만큼 실행 가능 $ O(E) $
  - for 구문 안에서 key값 변경시마다 heap 구조를 변경해야 하며, heap 에는 최대 V 개의 정보가 있으므로 $ O(logV) $
    > 일반적인 heap 자료 구조 자체에는 본래 heap 내부의 데이터 우선순위 변경시, 최소 우선순위 데이터를 루트노드로 만들어주는 로직은 없음. 이를 decrease key 로직이라고 부름, 해당 로직은 heapdict 라이브러리를 활용해서 간단히 적용가능
- 따라서 총 시간 복잡도는 $ O(V + VlogV + ElogV) $ 이며,
  - O(V)는 전체 시간 복잡도에 큰 영향을 미치지 않으므로 삭제,
  - E > V 이므로 (최대 $ V^2 = E $ 가 될 수 있음), $ O((V + E)logV) $ 는 간단하게 $ O(ElogV) $ 로 나타낼 수 있음
