package test.suresofttech;

/**
 * 정확성 시간 제한 / 효율성 시간 제한 / 메모리 제한
 * 10초 / 언어별로 작성된 정답 코드의 실행 시간의 적정 배수 / 2GB
 * <p>
 * 문제 설명
 * 1부터 자연수를 이어쓰면 1234567891011121314..가 됩니다. 이렇게 이어쓴 숫자를 A라 할 때, n번짜|에 위치하는 숫자를 반환하는 함수 solution을 완성 해주세요.
 * <p>
 * 제한사항
 * • 숫자의 위치 n : 1 <= n <= 1,000,000,000, n은 자연수
 * <p>
 * 입출력 예
 * n	result
 * 5	5
 * 15	2
 * <p>
 * 입출력 예 설명
 * 입출력 예 #1
 * 1234567.…에서 다섯 번째에는 5가 위치합니다.
 * <p>
 * 입출력 예 #2
 * 12345678910111213..에서 15번째에는 2가 위치합니다.
 */
public class Q2 {
    public static int solution(long n) {
        long digitLength = 1; // 현재 숫자 자리수
        long countOfNumbers = 9; // 해당 자리수의 숫자 개수
        long currentStart = 1; // 해당 자리수의 첫 번째 숫자

        // 자리수를 증가시키면서 n이 속하는 자리수를 찾음
        while (n > digitLength * countOfNumbers) {
            n -= digitLength * countOfNumbers; // n에서 해당 자리수의 숫자 개수를 뺌
            digitLength++; // 자리수 증가
            countOfNumbers *= 10; // 숫자 개수 갱신
            currentStart *= 10; // 시작 숫자 갱신
        }

        // 정확한 숫자 찾기
        long number = currentStart + (n - 1) / digitLength;
        String numberStr = Long.toString(number);
        return numberStr.charAt((int) ((n - 1) % digitLength)) - '0';
    }

    public static void main(String[] args) {
        // 테스트 케이스
        System.out.println(solution(5));   // 5
        System.out.println(solution(15));  // 2
    }
}
