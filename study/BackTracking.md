# 백 트래킹 (backtracking)

- 백트래킹 (backtracking) 또는 퇴각 검색 (backtrack)으로 부름
- 제약 조건 만족 문제 (Constraint Satisfaction Problem) 에서 해를 찾기 위한 전략
  - 해를 찾기 위해, 후보군에 제약 조건을 점진적으로 체크하다가, 해당 후보군이 제약 조건을 만족할 수 없다고 판단되는 즉시 backtrack (다시는 이 후보군을 체크하지 않을 것을 표기)하고, 바로 다른 후보군으로 넘어가며, 결국 최적의 해를 찾는 방법
- 실제 구현시, 고려할 수 있는 모든 경우의 수 (후보군)를 상태공간트리(State Space Tree)를 통해 표현
  - 각 후보군을 DFS 방식으로 확인
  - 상태 공간 트리를 탐색하면서, 제약이 맞지 않으면 해의 후보가 될만한 곳으로 바로 넘어가서 탐색
    - Promising: 해당 루트가 조건에 맞는지를 검사하는 기법
    - Pruning (가지치기): 조건에 맞지 않으면 포기하고 다른 루트로 바로 돌아서서, 탐색의 시간을 절약하는 기법

> 즉, 백트래킹은 트리 구조를 기반으로 DFS로 깊이 탐색을 진행하면서 각 루트에 대해 조건에 부합하는지 체크(Promising), 만약 해당 트리(나무)에서 조건에 맞지않는 노드는 더 이상 DFS로 깊이 탐색을 진행하지 않고, 가지를 쳐버림 (Pruning)

### 상태 공간 트리 (State Space Tree)

- 문제 해결 과정의 중간 상태를 각각의 노드로 나타낸 트리
  <img src="https://www.fun-coding.org/00_Images/statespacetree.png" width=300>

### N Queen 문제 이해

- 대표적인 백트래킹 문제
- NxN 크기의 체스판에 N개의 퀸을 서로 공격할 수 없도록 배치하는 문제
- 퀸은 다음과 같이 이동할 수 있으므로, 배치된 퀸 간에 공격할 수 없는 위치로 배치해야 함
  <img src="https://www.fun-coding.org/00_Images/queen_move.png">

### 문제 해결

```java
public class NQueen {

    public boolean isAvailable(ArrayList<Integer> candidate, Integer currentCol) {
        Integer currentRow = candidate.size();
        for (int index = 0; index < currentRow; index++) {
            if ((candidate.get(index) == currentCol) || (Math.abs(candidate.get(index) - currentCol) == currentRow - index) ) {
                return false;
            }
        }
        return true;
    }

    public void dfsFunc(Integer N, Integer currentRow, ArrayList<Integer> currentCandidate) {
        if (currentRow == N) {
            System.out.println(currentCandidate);
            return ;
        }

        for (int index = 0; index < N; index++) {
            if (this.isAvailable(currentCandidate, index) == true) {
                currentCandidate.add(index);
                this.dfsFunc(N, currentRow + 1, currentCandidate);
                currentCandidate.remove(currentCandidate.size() - 1);
            }
        }
    }
}
```
