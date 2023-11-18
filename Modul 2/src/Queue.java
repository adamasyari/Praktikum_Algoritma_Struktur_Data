public class Queue {
    Node top, tail;

    public boolean isEmpety(){
        return tail == null || top == null;
    }
    public void enqueue(Object name){
        Node newName = new Node(name);

        if(isEmpety()){
            top = tail = newName;
        } else {
            newName.next = top;
            top = newName;
        }
    }
    public void dequeue(){
        if(isEmpety()){
            System.out.println("Data tidak ditemukan !");
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }
    public void printAll(){
        Node current = top;

        while(current != null){
            System.out.println(current.name + " ");

            if(current.next != null){
                System.out.println(" ^ ");
            }
            current = current.next;
        }
    }
}
