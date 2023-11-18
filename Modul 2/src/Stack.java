public class Stack {
    Node top, tail;

    public void push(Object name){
        Node newName = new Node(name);

        if(top == null){
            top = tail = newName;
        } else {
            newName.next = top;
            top = newName;
        }
    }
    public Object pop(){
        Node temp = top;
        top = top.next;
        return temp.name;
    }
    public void save(Stack stack1, Stack stack2, Object name){
        Node current = stack1.top;

        while(current != null){
            stack2.push(stack1.pop());

            if(current.next.name.equals(name)){
                top = current.next;
                break;
            }
            current = current.next;
        }
    }
    public void mergelist(Stack lis1, Stack list2){

        while(list2.top != null){
            lis1.push(list2.pop());
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
