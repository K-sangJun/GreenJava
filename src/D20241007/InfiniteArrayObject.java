package D20241007;

public class InfiniteArrayObject<T> {
    private Object[] arr; // Object 배열로 변경
    private int size;

    // 생성자
    public InfiniteArrayObject() {
        arr = new Object[5]; // 처음에 5 크기의 배열 생성
        size = 0;
    }

    // 배열 크기 증가
    private void grow() {
        if (size == arr.length) {
            Object[] newArr = new Object[arr.length * 2];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            arr = newArr;
        }
    }

    // 추가 (add)
    public void add(T val) {
        grow();
        arr[size] = val;
        size++;
    }

    // 삭제 (remove)
    public void remove(int idx) {
        if (idx >= size || idx < 0) {
            throw new IndexOutOfBoundsException("존재하지 않는 값");
        }
        for (int i = idx; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

    // 가져오기 (get)
    @SuppressWarnings("unchecked")
    public T get(int idx) {
        if (idx >= size || idx < 0) {
            throw new IndexOutOfBoundsException("존재하지 않는 값");
        }
        return (T) arr[idx]; // T 타입으로 캐스팅
    }

    // 가져오기 (getAll)
    public Object[] getAll() {
        return arr;
    }

    // 업데이트 (set)
    public void set(int idx, T val) {
        if (idx >= size || idx < 0) {
            throw new IndexOutOfBoundsException("존재하지 않는 값");
        }
        arr[idx] = val;
    }

    // 크기 반환
    public int size() {
        return size;
    }

    // 배열 출력
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
