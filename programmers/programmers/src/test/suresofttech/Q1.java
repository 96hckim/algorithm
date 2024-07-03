package test.suresofttech;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 정확성 시간 제한 / 효율성 시간 제한 / 메모리 제한
 * 10초 / 언어별로 작성된 정답 코드의 실행 시간의 적정 배수 / 2GB
 * <p>
 * 문제 설명
 * 단순 치환 암호(mono alphabetic substitution cipher)란 단어를 이루는 각 알파벳을 다른 알파벳으로 일대일로 대치하여 암호화하는 것을 말합니다. 예를 들어 "hello"라는 단어를 h -> C, e -> B, l -> V, o -> U 로 치환하여 암호화한다면 "CBVVU"로 암호화됩니다. 암호문을 해독하기 위해서는 각 문자와 암호화된 알파벳 간의 1:1 대응관계를 나타내 주는 표가 필요합니다.
 * <p>
 * 다음 그림은 암호문을 해독하기 위한 각 알파벳의 대응관계의 예시를 보여주는 표입니다.
 * <p>
 * 평문		a	b	c	d	e	f	g	h	i	j	k	l	m	n	o	p	q	r	s	t	u	v	w	x	y	z
 * 암호문	Z	I	A	Y	B	D	J	C	X	E	W	V	G	F	U	T	S	H	M	N	K	Q	R	L	O	P
 * <p>
 * 위 표를 이용하여 "RUHVY"를 복호화하면 "world"가 됩니다.
 * <p>
 * 원문 s와 암호문 cipher가 주어질 때 원문(s)을 이루는 각각의 알파벳을 서로 다른 알파벳으로 일대일 대치하여 암호문(cipher)를 만들 수 있으면 true를, 하나의 알파벳이 여러개의 알파벳으로 대치되는 등 [단순 치환 암호]의 조건에 맞지 않으면 false를 반환하도록 함수 solution을 완성해 주세요.
 * <p>
 * 제한사항
 * • 입력으로 주어지는 두 문자열의 길이는 서로 같으며 1,000보다 작거나 같습니다.
 * • 두 문자열은 전부 소문자로만 이루어져 있습니다.
 * <p>
 * 입출력 예
 * s		cipher	result
 * hello	cbvvu	true
 * hello	bbvmu	false
 * world	abcde	true
 * <p>
 * 입출력 예 설명
 * 입출력 예 #1
 * 원문		h	e	l	l	o
 * 암호문	c	b	v	v	u
 * <p>
 * 입출력 예 #2
 * 원문		h	e	l	l	o
 * 암호문	b	b	v	m	u
 * <p>
 * 입출력 예 #3
 * 원문		w	o	r	l	d
 * 암호문	a	b	c	d	e
 */
public class Q1 {
    public static boolean solution(String s, String cipher) {
        // 매핑을 저장하기 위한 HashMap
        HashMap<Character, Character> map = new HashMap<>();
        // 이미 사용된 문자를 추적하기 위한 HashSet
        HashSet<Character> usedChars = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char cChar = cipher.charAt(i);

            if (map.containsKey(sChar)) {
                // 이미 매핑된 문자와 다른 매핑이 발견되면 false 반환
                if (map.get(sChar) != cChar) {
                    return false;
                }
            } else {
                // cChar 가 이미 다른 문자에 매핑되어 있다면 false 반환
                if (usedChars.contains(cChar)) {
                    return false;
                }
                // 새로운 매핑 추가
                map.put(sChar, cChar);
                usedChars.add(cChar);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // 테스트 케이스
        System.out.println(solution("hello", "cbvvu")); // true
        System.out.println(solution("hello", "bbvmu")); // false
        System.out.println(solution("world", "abcde")); // true
    }
}
