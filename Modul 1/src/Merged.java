public class Merged extends LinkedList {
    Merged(){
        super();
    }
    static void mergedList(LinkedList list1, LinkedList list2){
        list1.tail.next = list2.head;
        list2.head.prev = list1.tail;
    }
}
