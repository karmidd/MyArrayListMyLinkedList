import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<T> implements List<T> {
    private Object[] arr;
    private int count = 0;

    public MyArrayList(){
        arr = new Object[10];
    }
    public MyArrayList(int n){
        arr = new Object[n];
    }

    public void dynamicResizeIncrease(){
        Object[] tempArr = new Object[arr.length*2];
        for (int i = 0; i < arr.length; i++){
            tempArr[i] = arr[i];
        }
        arr = tempArr;
    }

    public boolean indexOutOfBounds(int index){
        return index < 0 || index > count;
    }

    public void dynamicResizeDecrease(){ //Q: when to do?
        if( ((count*1.0)/arr.length) * 100 < 25) {
            Object[] tempArr = new Object[arr.length / 2];
            for (int i = 0; i < arr.length; i++) {
                tempArr[i] = arr[i];
            }
            arr = tempArr;
        }
    }
    @Override
    public MyArrayList<T> clone() {
        MyArrayList<T> clonedList = new MyArrayList<>();
        clonedList.arr = java.util.Arrays.copyOf(this.arr, this.arr.length); // Copy array contents
        clonedList.count = this.size();
        return clonedList;
    }
    @Override
    public boolean add(T e){ //O(1)
        if(count == arr.length){
            dynamicResizeIncrease();
        }
        arr[count] = e;
        count++;
        return true;
    }

    @Override
    public void add(int index, T e){ //O(n)
        if (indexOutOfBounds(index)){ //Q: add if index is far from other elements? e.g: [x,y,z,-,-,-,-,e,-,-,-]
            return;
        }
        if(count == arr.length){
            dynamicResizeIncrease();
        }
        for (int i = count-1; i >= index ; i--) {
            arr[i+1] = arr[i];
        }
        count++;
        arr[index] = e;
    }

    @Override
    public void clear(){ //O(n)
        for (int i = 0; i < count; i++) {
            arr[i] = null;
        }
        count = 0;
    }

    @Override
    public T get(int index) {
        someUnneededMethod();
        return null;
    }

    @Override
    public T set(int index, T element) {
        someUnneededMethod();
        return null;
    }

    @Override
    public T remove(int index){//O(n)
        if(count == 0 || indexOutOfBounds(index)){
            return null;
        }
        count--;
        Object temp = arr[index];
        for (int i = index; i < count; i++) {
            arr[i] = arr[i+1];
        }
        arr[count] = null;
        return (T) temp;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return List.of();
    }

    public boolean remove(Object o){ //O(n)
        if(count == 0 || o == null){
            return false;
        }
        boolean found = false;
        int index = -1;
        for (int i = 0; i < count; i++) {
            if(arr[i].equals(o)){
                found = true;
                index = i;
                break;
            }
        }
        if(found){
            count--;
            for (int i = index; i < count; i++) {
                arr[i] = arr[i+1];
            }
            arr[count] = null;
            return found;
        }
        return found;
    }

    public T someUnneededMethod() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        someUnneededMethod();
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        someUnneededMethod();
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        someUnneededMethod();
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        someUnneededMethod();
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        someUnneededMethod();
        return false;
    }

    public int size(){
        return count;
    }

    @Override
    public boolean isEmpty() {
        someUnneededMethod();
        return false;
    }

    @Override
    public boolean contains(Object o) {
        someUnneededMethod();
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        someUnneededMethod();
        return null;
    }

    @Override
    public Object[] toArray() {
        someUnneededMethod();
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        someUnneededMethod();
        return null;
    }

    public int arraySize(){
        return arr.length;
    }

    @Override
    public String toString(){
        String str = "[";
        for (int i = 0; i < count; i++) {
            if(i == count-1){
                str += arr[i];
                break;
            }
            str = str + arr[i] + ", ";
        }
        str = str + "]";
        return str;
    }
}
