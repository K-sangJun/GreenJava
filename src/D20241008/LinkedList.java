package D20241008;

public class LinkedList {

    Node head;

    public LinkedList(Node head) {
        this.head = head;
    }

    public void append(Object data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    public void delete(Object data) {
//        1. 연결리스트가 비어있으면 종료
        if (head == null) {
            return;
        }
//        2. 삭제하려는 데이터가 첫 번째 노드에 있으면 첫 번째 노드 삭제
        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }
//        3. 삭제할 노드를 찾았으면....
        if (current.next != null) {
            current.next = current.next.next;
        }


    }



    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

}
