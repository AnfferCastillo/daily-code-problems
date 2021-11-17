public class MyLinkedNode {
    
    private int id;
    private MyLinkedNode next;


    public MyLinkedNode(int id) {
        this.id = id;
    }
   

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MyLinkedNode getNext() {
        return this.next;
    }

    public void setNext(MyLinkedNode next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null)
            return false;
        if (o == this)
            return true;
        if (!(o instanceof MyLinkedNode)) {
            return false;
        }
        MyLinkedNode myLinkedNode = (MyLinkedNode) o;
        return id == myLinkedNode.id;
    }

      @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", next='" + getNext() + "'" +
            "}";
    }

}
