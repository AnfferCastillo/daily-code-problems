public class MyLinkedList {


    public static void main(String[] args) {
        var node1 = new MyLinkedNode(1);
        var node2 = new MyLinkedNode(2);
        var node3 = new MyLinkedNode(3);

        MyLinkedList list = new MyLinkedList();
        list.addRoFront(node1);
        list.addRoFront(node2);
        list.addRoFront(node3);

        System.out.println(list);

        list.removeFromFront();

        System.out.println(list);
    }

    private MyLinkedNode head;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean addRoFront(MyLinkedNode e) {
        if (isEmpty()) {
            head = e;
        } else {
            e.setNext(head);
            head = e;
        }
        size++;
        return true;
    }

    public MyLinkedNode removeFromFront() {
        if (isEmpty())
            return null;

        MyLinkedNode removed = head;
        head = head.getNext();
        removed.setNext(null);
        size--;
        return removed;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append("[");
        var current = head;
        while(current != null) {
            sb.append(current.getId() + ",");
            current = current.getNext();
        }

        sb.append("]");
        return sb.toString();
    }

}
