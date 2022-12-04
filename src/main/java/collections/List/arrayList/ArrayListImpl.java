package collections.List.arrayList;

import java.util.Arrays;

public class ArrayListImpl<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ARRAY = {};
    private int size; // 1개가 채워지면 size 가 1이된다.

    Object[] array;

    public ArrayListImpl() {
        this.array = EMPTY_ARRAY;
        this.size = 0;
    }

    public ArrayListImpl(int capacity) {
        this.array = new Object[capacity];
        this.size = 0;
    }

    public void resize(){

        int array_capacity = array.length; // 그냥 말그대로 크기

        // 말그대로 두개의 배열이 같은지 확인한다.
        if (Arrays.equals(array, EMPTY_ARRAY)) {
            array = new Object[DEFAULT_CAPACITY];
        }

        if( size == array_capacity ){
            int new_capacity = array_capacity * 2;
            array = Arrays.copyOf(array,new_capacity);
            return;
        }

        if( size < (array_capacity / 2)){
            int new_capacity = array_capacity / 2;
            array = Arrays.copyOf(array,Math.max(DEFAULT_CAPACITY,new_capacity));
        }

    }

    public boolean add(E value){
        addLast(value);
        return true;
    }

    public void addLast(E value){
        if( size == array.length ){
            resize();
        }
        array[size] = value;
        size++;
    }

    public boolean add(int index,E value){
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException();
        }

        if(index == size){
            addLast(value);
        } else {
            if( size == array.length ){
                resize();
            }
            for(int i = size; i > index; i--){
                array[i] = array[i-1];
            }
            array[index] = value;
            size++;
        }
        return true;
    }

    public void addFirst(E value){
        add(0,value);
    }

    public E get(int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        return (E) array[index];
    }

    public void set(int index,E value){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        array[index] = value;
    }
    //왜 Object 인지 설명
    //value class 에대한 이야기인듯
    public int indexOf(Object value){
        int i = 0;
        for (Object o : array) {
            i++;
            if(o.equals(value)){
                return i;
            }
        }
        return -1;
    }

    public int LastIndexOf(Object value){
        for(int i = size-1; i >= 0; i--){
            if(array[i].equals(value)){
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Object value){
        if(indexOf(value) > 0){
            return true;
        }
        return false;
    }

    public E remove(int index){

        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

//        0 1 2 3 4
//        0 1 x 3 4
//        0 1 3 x 4
//
//        0 1 3 4            4 --> memory-leak


        E element = (E) array[index];
        array[index] = null;

        for(int i = index; i < size-1; i++){
            array[i] = array[i+1];
            array[i+1] = null;
        }

        size--;
        resize();
        return element;
    }

    public boolean remove(Object value){
        int index = indexOf(value);
        if(index == -1){
            return false;
        }
        remove(index);
        return true;
    }


    public static void main(String[] args) {

//        int[] ints = new int[10];
//        System.out.println(ints.length);
//
//        Object[] objects = new Object[10];
//        objects[0] = new Object();
//        objects[7] = new Object();
//        objects[2] = new Object();
//        objects[5] = new Object();
//        System.out.println(objects.length);
//
//        for (Object object : objects) {
//            System.out.println(object);
//        }

    }
}

