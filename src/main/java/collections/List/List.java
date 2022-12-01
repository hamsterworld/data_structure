package collections.List;

import java.util.ArrayList;
import java.util.LinkedList;

public class List {

    public static void main(String[] args) {
        // 기본 array 와 비슷하다. (int[]) 애네들
//        Object[] objects = new Object[20];
//        String[] strings = new String[30];
        Object[] objects = new Object[3];
        objects[0] = 1;
        objects[1] = 2;
        objects[2] = 3;
        objects[1] = null;

        for (Object object : objects) {
            System.out.println(object);
        }
        // 위와 같은 Array 들은 size 가 한번할당되면 바꿀수없다.
        // 그것을 보완하기위해 나온게 List interface 를 구현한놈들이다.

        // - ArrayList
        // Object 타입으로 배열을 생성한다.
        // 동적으로 size 조절이 가능하다.
        // 대신 Array 와 비슷해서 element 들을 추가,삭제할때 한칸씩 밀거나 당겨야 한다.
        // access elements 에 탁월하다.
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);

        // -LinkedList
        // Node 에서 주소로서로 연결된 방식이다.
        // 특정 노드를 찾을려면 연결된 Node 를 모두 방문해야된다는것이 단점이다.
        // 그러나 삽입,삭제에서 매우 효율이 좋다.
        // 특정 index 로 바로찾는 장점은 여기도 있군.
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(0,10);
        linkedList.add(1,20);
        Integer integer = linkedList.get(1);
        /**
         * ArrayList 와 LinkedList 의 가장 큰 차이점은 그래서
         * 배열로 관리할것이냐? 노드로 관리할것이냐?
         */

        // -Vector
        // ArrayList 와 비슷하다 동기화를 지원한다.

        // -Stack
        // 우리가 아는 그 stack 이다.


    }
}
