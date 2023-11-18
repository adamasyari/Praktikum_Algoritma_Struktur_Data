public class LinkedList {
    Node head, tail, temp;

    public boolean cek(){
        return(head == null && tail == null );
    }
    public void add(String nama, Object tinggi, Object power){
        Node data = new Node(nama, tinggi, power);
        if (cek()) {
            head = tail = data;
        } else {
            data.prev = tail;
            tail.next = data;
            tail = data;
        }
    }
    public void addAfter(Object posisi, String nama, Object tinggi, Object power){
        Node newData = new Node(nama, tinggi, power);
        Node current = head;
        
        while(current != null){
            if(current.name == posisi){
                newData.next = current.next;
                current.next.prev = newData;
                current.next = newData;
                newData.prev = current;
            }
            current = current.next;
        }
    }
    public void remove(String name){
        Node current = head;

        while(current != null){
            if(current.name == name){
                current.prev.next = current.next;
                current.next.prev = current.prev;
                break;
            }
            current = current.next;
        }
    }
    //menampilkan data nomor 1
    public void printAll(){
        Node current = head;

        while(current != null){
            System.out.print("Nama : " + current.name + ", ");
            System.out.print("Tinggi : " + current.tinggi + " cm, ");
            System.out.print("Power : " + current.power + " kpow\n");

            current = current.next;
        }
        System.out.println("");
    }
    //menampilkan data nomor 2
    public void printAllRev(){
        Node current = head;

        while(current != null){
            if(current.next != null){
                System.out.print("Nama : " + current.name + ", ");
                System.out.print("Tinggi : " + current.tinggi + " cm, ");
                System.out.print("Power : " + current.power + " kpow\n");
            }
            current = current.next;
        }
        System.out.println("");
    }
}
