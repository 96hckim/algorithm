# 탐욕 알고리즘

- Greedy algorithm 또는 탐욕 알고리즘 이라고 불리움
- 최적의 해에 가까운 값을 구하기 위해 사용됨
- 여러 경우 중 하나를 결정해야할 때마다, **매순간 최적이라고 생각되는 경우를 선택**하는 방식으로 진행해서, 최종적인 값을 구하는 방식

### 탐욕 알고리즘 예

#### 문제1: 동전 문제

- 지불해야 하는 값이 4720원 일 때 1원 50원 100원, 500원 동전으로 동전의 수가 가장 적게 지불하시오.
  - 가장 큰 동전부터 최대한 지불해야 하는 값을 채우는 방식으로 구현 가능
  - 탐욕 알고리즘으로 매순간 최적이라고 생각되는 경우를 선택하면 됨

```java
public class GreedyAlgorithm {
    public void coinFunc(Integer price, ArrayList<Integer> coinList) {
        Integer totalCoinCount = 0;
        Integer coinNum = 0;
        ArrayList<Integer> details = new ArrayList<Integer>();

        for (int index = 0; index < coinList.size(); index++) {
            coinNum = price / coinList.get(index);
            totalCoinCount += coinNum;
            price -= coinNum * coinList.get(index);
            details.add(coinNum);
            System.out.println(coinList.get(index) + "원: " + coinNum + "개");
        }
        System.out.println("총 동전 갯수: " + totalCoinCount);
    }
}
```

500원: 9개
100원: 2개
50원: 0개
1원: 20개
총 동전 갯수: 31

#### 문제2: 부분 배낭 문제 (Fractional Knapsack Problem)

- 무게 제한이 k인 배낭에 최대 가치를 가지도록 물건을 넣는 문제
  - 각 물건은 무게(w)와 가치(v)로 표현될 수 있음
  - 물건은 쪼갤 수 있으므로 물건의 일부분이 배낭에 넣어질 수 있음, 그래서 Fractional Knapsack Problem 으로 부름
    - Fractional Knapsack Problem 의 반대로 물건을 쪼개서 넣을 수 없는 배낭 문제도 존재함 (0/1 Knapsack Problem 으로 부름)
      <img src="https://www.fun-coding.org/00_Images/knapsack.png">

### 참고: 정렬 기준 정의하기

- 정렬을 위해서는 정렬 기준이 있어야 함
- 객체간 정렬을 위해서는 정렬 기준을 먼저 정의해줘야 함

### Comparable 과 Comparator 인터페이스

- Comparable 와 Comparator 는 둘 다 인터페이스로, 정렬 기준을 구현하기 위해 사용됨
  - Comparable 인터페이스는 compareTo() 메서드를 override 해서 구현
    - 일반적으로는 정렬할 객체에 implements 로 Comparable 인터페이스를 추가하여 구현
  - Comparator 인터페이스는 compare() 메서드를 override 해서 구현
    - 일반적으로는 별도 클래스를 정의해서 구현하며, 따라서, 동일 객체에 다양한 정렬 기준을 가진 클래스를 작성 가능

### Comparable 예제

```java
public class Edge implements Comparable<Edge> {
    public Integer distance;
    public String vertex;

    public Edge (Integer distance, String vertex) {
        this.distance = distance;
        this.vertex = vertex;
    }

    @Override
    public int compareTo(Edge e) {
        return this.distance - e.distance;
    }
}
```

#### Comparator 예제

```java
Arrays.sort(edges, new Comparator<Edge>() {
    @Override
    public int compare(Edge objectItem1, Edge objectItem2) {
        return objectItem2.distance - objectItem1.distance;
    }
});
```

### 부분 배낭 문제 구현

```java
//2차원 배열로 작성해보기
Integer[][] objectList = { {10, 10}, {15, 12}, {20, 10}, {25, 8}, {30, 5} };
```

```java
public class GreedyAlgorithm {
public void knapsackFunc(Integer[][] objectList, double capacity) {
double totalValue = 0.0;
double fraction = 0.0;

        Arrays.sort(objectList, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] objectItem1, Integer[] objectItem2) {
                return (objectItem2[1] / objectItem2[0]) - (objectItem1[1] / objectItem1[0]);
            }
        });

        for (int index = 0; index < objectList.length; index++) {
            if ( (capacity - (double)objectList[index][0]) > 0 ) {
                capacity -= (double)objectList[index][0];
                totalValue += (double)objectList[index][1];
                System.out.println("무게:" + objectList[index][0] + ", 가치:" + objectList[index][1]);
            } else {
                fraction = capacity / (double)objectList[index][0];
                totalValue += (double)objectList[index][1] * fraction;
                System.out.println("무게:" + objectList[index][0] + ", 가치:" + objectList[index][1] + ", 비율:" + fraction);
                break;
            }
        }
        System.out.println("총 담을 수 있는 가치:" + totalValue);
    }

}
```

무게:10, 가치:10
무게:15, 가치:12
무게:20, 가치:10, 비율:0.25
총 담을 수 있는 가치:24.5

### 3. 탐욕 알고리즘의 한계

- 탐욕 알고리즘은 근사치 추정에 활용
- 반드시 최적의 해를 구할 수 있는 것은 아니기 때문 (그 당시의 최적만 생각)
- 최적의 해에 가까운 값을 구하는 방법 중의 하나임

### 예

<img src="https://www.fun-coding.org/00_Images/greedy.png" width=300>

- '시작' 노드에서 시작해서 가장 작은 값을 찾아 leaf node 까지 가는 경로를 찾을 시에
  - Greedy 알고리즘 적용시 시작 -> 7 -> 12 를 선택하게 되므로 7 + 12 = 19 가 됨
  - 하지만 실제 가장 작은 값은 시작 -> 10 -> 5 이며, 10 + 5 = 15 가 답
