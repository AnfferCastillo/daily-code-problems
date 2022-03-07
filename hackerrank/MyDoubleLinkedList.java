public class MyDoubleLinkedList {

    private MyDoubleLinkedNode head;
    private MyDoubleLinkedNode tail;
    private int size;

    public static void main(String[] args) {
        var node1 = new MyDoubleLinkedNode(1);
        var node2 = new MyDoubleLinkedNode(2);
        var node3 = new MyDoubleLinkedNode(3);

        var list = new MyDoubleLinkedList();
        System.out.println(list.size());
        list.addRoFront(node1);
        list.addRoFront(node2);
        list.addRoFront(node3);

        System.out.println(list);
        System.out.println("Tail is: " + list.getTail() + "HEad is: " + list.getHead() + " Size: " + list.getSize());

        list.removeFromFront();

        System.out.println(list);
        System.out.println("Tail is: " + list.getTail() + "HEad is: " + list.getHead() + " Size: " + list.getSize());

        list.removeFromFront();
        list.removeFromFront();
        System.out.println(list);
        System.out.println("Tail is: " + list.getTail() + "HEad is: " + list.getHead() + " Size: " + list.getSize());

        var node4 = new MyDoubleLinkedNode(4);
        var node5 = new MyDoubleLinkedNode(5);
        list.addToBack(node4);
        list.addToBack(node5);

        System.out.println(list);
        System.out.println("Tail is: " + list.getTail() + " HEad is: " + list.getHead() + " Size: " + list.getSize());

        list.removeFromBack();
        System.out.println(list);
        System.out.println("Tail is: " + list.getTail() + " HEad is: " + list.getHead() + " Size: " + list.getSize());

        list.removeFromBack();
        list.removeFromBack();
        list.removeFromBack();
        System.out.println(list);
        System.out.println("Tail is: " + list.getTail() + " HEad is: " + list.getHead() + " Size: " + list.getSize());

        var node6 = new MyDoubleLinkedNode(6);
        var node7 = new MyDoubleLinkedNode(7);
        var node8 = new MyDoubleLinkedNode(8);
        var node9 = new MyDoubleLinkedNode(9);

        list.addToBack(node7);
        list.addToBack(node9);

        System.out.println(list);
        System.out.println("Tail is: " + list.getTail() + " HEad is: " + list.getHead() + " Size: " + list.getSize());


        list.addBefore(node6, node7);
        list.addBefore(node8, node9);
        
        System.out.println(list);
        System.out.println("Tail is: " + list.getTail() + " HEad is: " + list.getHead() + " Size: " + list.getSize());


    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean addRoFront(MyDoubleLinkedNode e) {
        if (isEmpty()) {
            head = e;
            tail = e;
        } else {
            e.setNext(head);
            head.setPrevius(e);
            head = e;
        }
        size++;
        return true;
    }

    public MyDoubleLinkedNode removeFromFront() {
        if (isEmpty())
            return null;

        var removed = head;
        head = head.getNext();
        if (head != null) {
            head.setPrevius(null);
            removed.setNext(null);
        } else {
            tail = null;
        }
        size--;
        return removed;
    }

    public void addToBack(MyDoubleLinkedNode e) {
        if (isEmpty()) {
            head = e;
            tail = e;
        } else {
            tail.setNext(e);
            e.setPrevius(tail);
            tail = e;
        }
        size++;
    }

    public void removeFromBack() {
        if (isEmpty())
            return;

        var removed = tail;
        tail = tail.getPrevius();
        if (tail != null) {
            tail.setNext(null);
            removed.setNext(null);
            removed.setPrevius(null);
        } else {
            head = null;
        }

        size--;
    }

    public boolean addBefore(MyDoubleLinkedNode node, MyDoubleLinkedNode existing) {
        if (head == null) {
            return false;
        }

        var current = head;
        while (current != null && !current.equals(existing)) {
            current = current.getNext();
        }

        if (current == null) {
            return false;
        } else if (current == head) {
            addRoFront(node);
            return true;
        } 
        
        node.setNext(current);
        node.setPrevius(current.getPrevius());
        current.getPrevius().setNext(node);
        current.setPrevius(node);

        return true;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append("[");
        var current = head;
        while (current != null) {
            sb.append(current.getId() + ",");
            current = current.getNext();
        }

        sb.append("]");
        return sb.toString();
    }

    public MyDoubleLinkedNode getHead() {
        return this.head;
    }

    public void setHead(MyDoubleLinkedNode head) {
        this.head = head;
    }

    public MyDoubleLinkedNode getTail() {
        return this.tail;
    }

    public void setTail(MyDoubleLinkedNode tail) {
        this.tail = tail;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
