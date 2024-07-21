package test.suresofttech;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 정확성 시간 제한 / 메모리 제한
 * 10초 / 2GB
 * <p>
 * 문제 설명
 * 코팅 테스트의 결과가 주어졌을 때, 문제별로 가장 유리했던 언어를 알아보고자 합니다. 아래의 표는 총 7명의 응시자가 4종류(C, SWIFT, JAVA, R)의 언어 중 하나를 선택하여 3문제를 푼 결과를 나타냅니다.
 * <p>
 * 응시자별 점수
 * 응시자 번호	사용 언어	번 문제 점수	2번 문제 점수	3번 문제 점수
 * 1	C	65	80	90
 * 2	SWIFT	46	100	70
 * 3	JAVA	91	96	59
 * 4	SWIFT	89	90	61
 * 5	JAVA	0	94	75
 * 6	JAVA	38	95	47
 * 7	R	50	60	90
 * <p>
 * 언어별 평균
 * 사용 언어	1번 문제 평균	2번 문제 평균	3번 문제 평균
 * C(1명)	65	80	90
 * SWIFT(2명)	67.5	95	65.5
 * JAVA(3명)	43	95	60.333~
 * R(1명)	50	60	90
 * <p>
 * • C와 R은 선택한 응시자가 한 명뿐이므로, 각 응시자의 문제별 점수가 언어의 문제별 평균이 됩니다.
 * • SWIFT는 두 명의 응시자(2번, 4번)가 사용했습니다.
 * 0 이들은 1번 문제에 대해서 각각 46점, 89점을 받았으므로, SWIFT언어의 1번 문제 평균은 67.5 점입니다.
 * • JAVA는 세 명의 응시자(3번, 5번, 6번)가 사용했습니다.
 * 0 이들은 3번 문제에 대해서 각각 59점, 75점, 47점을 받았으므로, JAVA의 3번 문제 평균은 60.333- 점입니다.
 * • 사용 언어별로 각 문제의 평균을 구했을 때, 문제별로 가장 유리했던 언어를 다음과 같은 기준으로 선정합니다.
 * 0 문제별 평균 점수가 높을수록 유리한 언어입니다.
 * 0 문제별 평균 점수가 같다면, 사용한 응시자가 더 많은 언어가 더 유리한 언어입니다.
 * • 위 표에서, SWIFT와 JAVA의 2번 문제 평균은 95점으로 같습니다. 하지만 JAVA를 사용한 응시자가 SWIFT를 사용한 응시자보다 더 많으므로, 2번 문제에서는 JAVA를 더 유리한 언어라고 간주합니다.
 * 0 문제별 평균 점수와 사용한 응시자가 모두 같다면, 언어의 이름을 알파벳 사전 순으로 나열했을 때 뒤쪽에 위치하는 언어가 더 유리한 언어라고 간주합니다.
 * • 위 표에서, C와 R의 3번 문제 평균은 90점이며, 각 언어를 사용한 응시자 수도 1명으로 같습니다. 하지만 R 이 c 보다 알파벳 사전 순으로 뒤쪽에 위치하므로, 3번 문제에서는 R을 더 유리한 언어라고 간주합니다.
 * <p>
 * 응시자 별로 사용한 언어를 담은 1차원 문자열 배열 languages, 점수를 담은 2차원 정수 배열 scores가 매개변수로 주어집니다. 이때, 문제별로 가장 유리한 언어를 배열에 담아서 return 하도록 solution 함수를 완성해주세요.
 * <p>
 * 제한사함
 * • languages의 길이는 1 이상 100,000 이하입니다.
 * 0 즉, 응시자 수는 1 명 이상 100,000명 이하입니다.
 * 0 1번 응시자가 사용한 언어부터 차례대로 담겨있습니다.
 * 0 languages의 모든 원소는 알파벳 대문자 로만 구성된, 길이가 1 이상 15 이하인 문자열입니다.
 * • scores의 행의 길이는 languages의 길이와 같으며, 열의 길이는 1 이상 5 이하입니다.
 * 0 즉, 문제의 수는 1개 이상 5개 이하입니다.Y
 * 0 scores의 모든 행은 같은 개수의 원소를 가지고 있습니다.
 * 0 scores[i][j] 는 i+1 번 응시자의 j+1 번 문제의 점수를 담고 있습니다.
 * 0 scores의 모든 원소는 0 이상 100 이하인 정수입니다.
 * • retum 값 형식
 * 0 1번 문제부터 마지막 문제까지, 문제별로 가장 유리한 언어를 문자열 형태로 1차원 배열에 담아서 return 합니다.
 * <p>
 * 입출력 예
 * languages	scores	result
 * ["C" , "SWIFT" , "JAVA" , "SWIFT" , "JAVA" , "JAVA" , "R"]	[[65,80,90],[46,100,70],[91,96,59],[89,90,61],[0,94,75],[38.95,47],[50,60,90]]	["SWIFT", "JAVA", "R"]
 * ["A", "AAA", "AA"]	[[100,50,0,30],[100,50,0,25],[100,50,0,30]]	["AAA", "AAA", "AAA", "AA"]
 * <p>
 * 입출력 예 설명
 * 입출력 예 #1
 * • 문제 예시와 같습니다.
 * • 1번 문제의 가장 유리한 언어는 SWIFT, 2번 문제의 가장 유리한 언어는 JAVA, 3번 문제의 가장 유리한 언어는 R이므로, 이들을 차례대로 문자열 형태로 배열에 담아서 return 합니다.
 * <p>
 * 입출력 예 #2
 * • 3명의 응시자가 각각 다른 언어(A, AAA, AA)를 사용해서 4문제를 풀었습니다.
 * • 1, 2, 3번 문제는 모든 언어의 평균 점수가 같고, 사용자 수도 1명으로 동일합니다. 따라서 알파벳 사전 순으로 가장 뒤쪽인 AAA를 가장 유리한 언어로 간주합니다.
 * • 4번 문제는 A와 AA언어가 30점으로 평균 점수가 같고, 사용자 수도 1명으로 동일합니다. 따라서 알파벳 사전 순으로 더 뒤쪽인 AA를 가장 유리한 언어로 간주합니다.
 */
public class Q3 {
    public static String[] solution(String[] languages, int[][] scores) {
        int numProblems = scores[0].length;
        Map<String, int[]> languageScores = new HashMap<>();
        Map<String, Integer> languageCounts = new HashMap<>();

        // 각 언어별로 문제별 점수 합계와 응시자 수 계산
        for (int i = 0; i < languages.length; i++) {
            String lang = languages[i];
            if (!languageScores.containsKey(lang)) {
                languageScores.put(lang, new int[numProblems]);
                languageCounts.put(lang, 0);
            }
            for (int j = 0; j < numProblems; j++) {
                languageScores.get(lang)[j] += scores[i][j];
            }
            languageCounts.put(lang, languageCounts.get(lang) + 1);
        }

        String[] result = new String[numProblems];

        // 문제별로 가장 유리한 언어 결정
        for (int i = 0; i < numProblems; i++) {
            String bestLanguage = null;
            double bestAverage = -1;
            int bestCount = -1;

            for (String lang : languageScores.keySet()) {
                double average = (double) languageScores.get(lang)[i] / languageCounts.get(lang);
                int count = languageCounts.get(lang);

                if (average > bestAverage) {
                    bestAverage = average;
                    bestLanguage = lang;
                    bestCount = count;
                } else if (average == bestAverage) {
                    if (count > bestCount) {
                        bestLanguage = lang;
                        bestCount = count;
                    } else if (count == bestCount) {
                        if (bestLanguage == null || lang.compareTo(bestLanguage) > 0) {
                            bestLanguage = lang;
                        }
                    }
                }
            }

            result[i] = bestLanguage;
        }

        return result;
    }

    public static void main(String[] args) {
        // 테스트 케이스
        String[] languages1 = {"C", "SWIFT", "JAVA", "SWIFT", "JAVA", "JAVA", "R"};
        int[][] scores1 = {
                {65, 80, 90},
                {46, 100, 70},
                {91, 96, 59},
                {89, 90, 61},
                {0, 94, 75},
                {38, 95, 47},
                {50, 60, 90}
        };
        System.out.println(Arrays.toString(solution(languages1, scores1))); // ["SWIFT", "JAVA", "R"]

        String[] languages2 = {"A", "AAA", "AA"};
        int[][] scores2 = {
                {100, 50, 0, 30},
                {100, 50, 0, 25},
                {100, 50, 0, 30}
        };
        System.out.println(Arrays.toString(solution(languages2, scores2))); // ["AAA", "AAA", "AAA", "AA"]
    }
}
