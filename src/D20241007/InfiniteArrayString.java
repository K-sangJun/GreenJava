package D20241007;

public class InfiniteArrayString {
    private String[] arr;
    private int size;

    // 생성자
    public InfiniteArrayString() {
        arr = new String[5]; // 처음에 10 크기의 배열 생성
        size = 0;
    }

    // 배열 크기 증가
    private void grow() {
        if (size == arr.length) {
            String[] newArr = new String[arr.length * 2];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            arr = newArr;
        }
    }

    // 추가 (add)
    public void add(String val) {
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
    public String get(int idx) {
        if (idx >= size || idx < 0) {
            throw new IndexOutOfBoundsException("존재하지 않는 값");
        }
        return arr[idx];
    }

    // 가져오기 (getAll)
    public String[] getAll() {
        return arr;
    }

    // 업데이트 (set)
    public void set(int idx, String val) {
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