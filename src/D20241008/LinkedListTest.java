package D20241008;

public class LinkedListTest {

    public static void main(String[] args) {

        Node node = new Node("aaa");

        LinkedList list = new LinkedList(node);
        list.append(20);
        list.append(30);
        list.append(40);

        list.printList();

        list.delete(10);
        list.printList();
    }





}
