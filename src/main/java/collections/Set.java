package collections;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.TreeSet;

/**
 * Set 은 말그대로 집합
 * 1. 데이터 중복 저장 x
 * 2. 입력 순서대로 저장순서 보장 x (but, LinkedHashSet 은 입력순서대로 저장순서를 보장해주는것같다. 그러나 중복은 당연히 안된다.)
 */
public class Set {
    public static void main(String[] args) {

        // 중복저장도 안되고 입력순서도 보장안하면 어따 써?
        // 중복확인 => 그냥 빠르게 찾기만 하면된다.
        // hash 에의해서데이터를 위치에 특정시켜서 빠르게 search(색인) 할수있는것.
        // 그래서 데이터의 삽입,삭제,색인이 존나 빠르다.
        HashSet<Integer> set = new HashSet<>();

        //LRU 알고리즘이 대표적인 구현체
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();

        // PriorityQueue 랑 비슷하다.
        // 데이터의 가중치에 따른 순서대로 정렬을 보장한다.
        // 중복되지않으면서 특정 규칙에 의해 정렬된 집합을 사용하고싶을때.
        // Tree 자체가 데이터를 일정한 순서에 정렬하는것 거기에 Set 의 중복방지가 들어간것이다.
        TreeSet<Integer> treeSet = new TreeSet<>();

    }
}
