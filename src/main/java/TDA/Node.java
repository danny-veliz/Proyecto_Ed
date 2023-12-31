package TDA;

class Node<E> {
    private E content;
    private Node<E> next;
    private Node<E> previous;
    
    
    public Node (E content) {
        this.content = content;
        this.next = null;
        this.previous=null;
        
    }
    
    public Node (E content, Node<E> next) {
        this(content);
        this.next = next;
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
    
    public Node<E> getPrevious(){
        return this.previous;
    }
    
    public void setPrevious(Node<E> previous){
        this.previous=previous;
    }
    
    public boolean equals(Node<E> n){
        return this.getContent().equals(n.getContent());
    }
}
