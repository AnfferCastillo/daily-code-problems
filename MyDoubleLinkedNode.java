public class MyDoubleLinkedNode {
    

    private int id;
    private MyDoubleLinkedNode previus;
    private MyDoubleLinkedNode next;


    public MyDoubleLinkedNode(int id) {
        this.id = id;
    }
    

    public MyDoubleLinkedNode getPrevius() {
        return this.previus;
    }

    public void setPrevius(MyDoubleLinkedNode previus) {
        this.previus = previus;
    }

    public MyDoubleLinkedNode getNext() {
        return this.next;
    }

    public void setNext(MyDoubleLinkedNode next) {
        this.next = next;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            "}";
    }



}
