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
        
        var node4 = new MyLinkedNode(4);
        list.addBefore(node4, node3);
        System.out.println("addBefore 1: " + list);

        list.addBefore(node4, node1);
        System.out.println("addBefore 2: " + list);

        var sortedList = new MyLinkedList();

        var node10 = new MyLinkedNode(0);
        var node11 = new MyLinkedNode(1);
        var node12 = new MyLinkedNode(2);
        var node13 = new MyLinkedNode(3);
        var node14 = new MyLinkedNode(4);
        var node15 = new MyLinkedNode(5);
        var node16 = new MyLinkedNode(6);

        sortedList.insertSorted(node11);
        sortedList.insertSorted(node13);
        sortedList.insertSorted(node12);
        sortedList.insertSorted(node15);
        sortedList.insertSorted(node14);
        sortedList.insertSorted(node16);
        sortedList.insertSorted(node10);

        System.out.println("insertSorted: " + sortedList);
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

    public void addBefore(MyLinkedNode nodeAdded, MyLinkedNode node) {

        if(node == null) {
            return;
        }

        if(node.equals(head)){
            addRoFront(nodeAdded);
            return;
        }

        var current = head;

        while(current != null && !node.equals(current.getNext())) {
            current = current.getNext();
        } 

        if(current!= null) {
            nodeAdded.setNext(current.getNext());
            current.setNext(nodeAdded);
        }
    }

    public boolean insertSorted(MyLinkedNode node) {

        if(isEmpty()) {
            head = node;
            return true;
        } 

        var current = head; // 3
        MyLinkedNode previous = null; // 1

        // 2
        // 1 3
        while(current != null && current.getId() <= node.getId()) {
            previous = current;
            current = current.getNext();
        }

        if(current == head) {
            head = node;
        } 

        node.setNext(current);
        if(previous != null) {
            previous.setNext(node);
        }

        return true;
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
