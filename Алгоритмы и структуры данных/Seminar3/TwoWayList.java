package Seminar3;

public class TwoWayList <E> {
    private Node<E> head;
    private Node<E> previous;

    public void revers(){
        Node node = head;
        while(node != null){
            Node n = node.nextNode;
            Node p = node.previousNode;
            node.nextNode = p;
            node.previousNode = n;
            if(p == null){
                previous = node;
            }
            if(n == null){
                head = node;
            }
            node = n;
        }
    }

    public Node find(E value){
        Node node = head;
        while (node != null){
            if (node.value == value) return node;
            node = node.nextNode;
        }
        return null;
    }

    public void add(E value){
        Node<E> newNode = new Node<>();
        newNode.value = value;
        if(head == null){
            previous = newNode;
            head = newNode;
        } else {
            newNode.nextNode = head;
            previous.nextNode = newNode;
            newNode.previousNode = previous;
        }
    }

    public void add(E value, Node node){
        Node next = node.nextNode;
        Node<E> newNode = new Node<>();
        newNode.value = value;
        node.nextNode = newNode;
        newNode.previousNode = node;
        if (next == null) previous = newNode;
        else {
            next.previousNode = newNode;
            newNode.nextNode = next;
        }
    }
    
    public void delete(E value){
        Node node = find(value);
        Node p = node.previousNode;
        Node n = node.nextNode;
        if (p == null){
            n.previousNode = null;
            head = n;
        }
        else{
            if (n == null){
                p.nextNode = null;
                previous = n;
            } else{
                p.nextNode = n;
                n.previousNode = p;
            }
        }

    }
}
