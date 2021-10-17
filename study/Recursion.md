# 재귀 용법 (recursive call, 재귀 호출)

- 함수 안에서 동일한 함수를 호출하는 형태
- 여러 알고리즘 작성시 사용되므로, 익숙해져야 함

### 재귀 용법 이해

- 예제를 풀어보며, 재귀 용법을 이해해보기

### 예제 - 팩토리얼

```java
public class Factorial {
    public int factorialFunc(int n) {
        if (n > 1) {
            return n * this.factorialFunc(n - 1);
        } else {
            return 1;
        }
    }
}
```

### 팩토리얼 - 시간 복잡도와 공간 복잡도

- factorial(n) 은 n - 1 번의 factorial() 함수를 호출해서, 곱셈을 함

  - 일종의 n-1번 반복문을 호출한 것과 동일
  - factorial() 함수를 호출할 때마다, 지역변수 n 이 생성됨

- 시간 복잡도/공간 복잡도는 O(n-1) 이므로 결국, 둘 다 O(n)

### 재귀 호출은 스택의 전형적인 예

- 함수는 내부적오르 스택처럼 관리된다.

<img src="https://www.fun-coding.org/00_Images/recursivecall.png" />
