package test.fortytwodot

/**
 * 정확성 시간 제한 / 메모리 제한
 * 10초 / 2GB
 *
 * 문제 설명
 * 통상적으로 소프트웨어 버전을 명명하는 데 자주 사용되는 표준 중 하나인 Semver에서는, 버전을 메이저 버전, 마이너 버전, 그리고 패지
 * 버전 3개의 넘버링으로 관리합니다. 예를 들어, 버전 "3.17.24"는 메이저 버전 3, 마이너 버전 17, 그리고 패치 버전 24입니다.
 * 버전 문자열들로 이루어진 배열 versions가 매개변수로 주어집니다. 이 버전들을 최신 버전이 앞에 오도록 정렬하여 return 하도록
 * solution 함수를 완성해주세요.
 *
 * 제한사항
 * • versions의 길이는 1 이상 1,000 이하입니다.
 *  versions에 들어 있는 모든 문자열들은 "X.Y.Z" 형태를 취하고 있습니다.
 *  X는 메이저 버전, Y는 마이너 버전, Z는 패치 버전을 의미합니다.
 *  예를 들어, "27.3.999"는 메이저 버전 27, 마이너 버전 3, 패치 버전 999를 의미합니다.
 *  X, Y, Z는 각각 0 이상 999 이하입니다.
 *  versions에 들어 있는 모든 문자열들은 서로 다른 버전을 가리킵니다.
 *
 * 입출력 예
 * verslons result
 * ["12.5.17", “20.6.3”, "1.9.2", "1.9.3", "5.7.4"] ["20.6.3", "12.5.17", "5.7.4", "1.9.3", "1.9.2"
 * ["0.5.999", "0.0.0", "0.3.2", "1.0.0"] ["1.0.0", "0.5.999", "0.3.2", "0.0.0"]
 * ["999.999.999", "0.0.0"] ["999.999.999", "0.0.0"]
 *
 * 입출력 예 설명
 * 입출력 예 #1
 * • 주어진 버전들의 세부 넘버링은 다음 표와 같습니다.
 * 버전문자열 메이저버전 마이너버전 패치버전
 * "12.5.17" 12 5 17
 * "20.6.3" 20 6 3
 * "1.9.2" 1 9 2
 * "1.9.3" 1 9 3
 * "5.7.4" 5 7 4
 * 입출력 예 #2
 * • 주어진 버전들의 세부 넘버링은 다음 표와 같습니다.
 * 버전문자열 메이저버전 마이너버전 패치버전
 * "05.999" 0 5 999
 * "0.0.0" 0 0 0
 * "0.3.2" 0 3 2
 * "1.0.0" 1 0 0
 * 입출력 예 #3
 * • 주어진 버전들이 이미 정렬되어 있습니다.
 */
fun main(args: Array<String>) = with(Q3()) {
    val versions1 = arrayOf("12.5.17", "20.6.3", "1.9.2", "1.9.3", "5.7.4")
    println("Return: ${solution(versions1).joinToString()}") // ["20.6.3", "12.5.17", "5.7.4", "1.9.3", "1.9.2"]

    val versions2 = arrayOf("0.5.999", "0.0.0", "0.3.2", "1.0.0")
    println("Return: ${solution(versions2).joinToString()}") // ["1.0.0", "0.5.999", "0.3.2", "0.0.0"]

    val versions3 = arrayOf("999.999.999", "0.0.0")
    println("Return: ${solution(versions3).joinToString()}") // ["999.999.999", "0.0.0"]
}

class Q3 {
    fun solution(versions: Array<String>): Array<String> {
        // 버전을 분리하고, 각 부분을 정수로 변환하여 비교하기 위한 정렬
        return versions.sortedWith { v1, v2 ->
            val version1 = v1.split('.').map { it.toInt() }
            val version2 = v2.split('.').map { it.toInt() }

            if (version1[0] != version2[0]) { // 메이저 버전 비교
                version2[0] - version1[0]
            } else if (version1[1] != version2[1]) { // 마이너 버전 비교
                version2[1] - version1[1]
            } else { // 패치 버전 비교
                version2[2] - version1[2]
            }
        }.toTypedArray() // 배열 변환
    }
}