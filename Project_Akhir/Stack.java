package Project_Akhir;

public class Stack {
   Node head;
   Node tail;
   
   public void push (Vertex value){
      Node baru = new Node(value);
      
      if(head == null){
         head = tail = baru;
      }
      else {
         baru.next = head;
         head = baru;
      }
   }
   
   public Vertex pop(){
      Node popItem = head;

      if (head == null){
         return null;   
      }
      else {
         if(head != null){
            head = head.next;
         }
         else {
            head = null;
         }
         return popItem.value;
      }
   }
}
