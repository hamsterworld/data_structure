package collections.List.arrayList;

import java.util.Arrays;

public class MyPractice<T> {

    private static final int DEFAULT_SIZE = 16;

    private static final Object[] EMPTY_ARRAY = {};

    private int size;
    private Object[] array;

    public MyPractice() {
        array = new Object[DEFAULT_SIZE];
        size = 0;
    }

    public MyPractice(int arraySize) {
        array = new Object[arraySize];
        size = 0;
    }

    public void resize(){

        int capacity = array.length;

        if( Arrays.equals(array,EMPTY_ARRAY)) {
            array = new Object[DEFAULT_SIZE];
        }

        if( size == capacity ){
            int new_capacity = capacity * 2;
            Arrays.copyOf(array,new_capacity);
            return;
        }

        if( size < (capacity/2)){
            int new_capacity = capacity/2;
            Arrays.copyOf(array,Math.max(size,DEFAULT_SIZE));
        }

    }

    public void add(Object value){
        addLast(value);
    }

    public void addLast(Object value){
        if(size == array.length){
            resize();
        }
        array[size] = value;
        size++;
    }

    public void add(int index,Object value){
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        if(size == array.length){
            resize();
        }
        if(size == index){
            addLast(index);
        } else{
            for(int i = size; i > index; i--){
                array[i] = array[i-1];
            }
            array[index] = value;
            size++;
        }
    }

    public T remove(){
        Object o = array[size];
        size--;
        array[size] = null;
        return (T) o;
    }

    public T remove(int index){

        if(index > size || index < 0){
            throw new IndexOutOfBoundsException();
        }

        Object o = array[index];
        array[index] = null;

        for (int i = index; i < size-1; i++){
            array[i] = array[i+1];
            array[i+1] = null;
        }

        resize();
        size --;
        return (T) o;
    }

}
