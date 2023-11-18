public class SortingAndSearching {
    Node head, tail;

    public void add(String namaBarang,int harga, int stok ){
        Node data = new Node(namaBarang, harga, stok);

        if(head == null){
            head = tail =  data;
        } else {
            data.prev = tail;
            tail.next = data;
            tail = data;
        }
    }
    public void swapSort(Node Notasi, Node node){
        String tempBarang;
        int tempHarga, tempStok;

        tempBarang = Notasi.namaBarang;
        tempStok = Notasi.stok;
        tempHarga = Notasi.harga;

        Notasi.namaBarang = node.namaBarang;
        Notasi.stok = node.stok;
        Notasi.harga = node.harga;

        node.namaBarang = tempBarang;
        node.harga = tempHarga;
        node.stok = tempStok;
    }
    public void bubbleSort(){
        Node current = head;
        int i = 0;

        if(head == null){
            return;
        } else {
            while(current != null){
                Node currentNext = current.next;
                while(currentNext != null){
                    while(current.namaBarang.charAt(i) == currentNext.namaBarang.charAt(i)){
                        i++;
                    }
                    if(current.namaBarang.charAt(i) != currentNext.namaBarang.charAt(i) && current.namaBarang.charAt(i) > currentNext.namaBarang.charAt(i)){
                        swapSort(current, currentNext);
                    }
                    i = 0;
                    currentNext = currentNext.next;
                }
                current = current.next;
            }
        }
    }
    public void insertionSort(){
        Node current = head;

        while(current != tail){
            Node currentNext = current.next;
            if(current.harga < currentNext.harga){
                swapSort(current, currentNext);
                while(current.prev != null){
                    if(current.prev.harga < current.harga){
                        swapSort(current.prev, current);
                    }
                    current = current.prev;
                }
            }
            current = current.next;
        }
    }
    // merge sort start
    public Node findMiddle(Node head){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public Node merge(Node left, Node right){
        if(left == null) return right;
        if(right == null) return left;

        Node result = null;
        if(left.stok <= right.stok){
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }
        return result;
    }
    public void mergeSort(){
        Node current = head;

        if(head == null || head.next == null){
            return;
        }
        Node middle = findMiddle(current);
        Node middleNext = middle.next;

        middle.next = null;
        swapSort(middle, middleNext);

    }
    public void printAll(){
        Node current = head;

        while(current != null){
            System.out.println("Barang : " + current.namaBarang + ", Harga : Rp." + current.harga + ", Stok : " + current.stok);
            current = current.next;
        }
        System.out.println(" ");
    }
}
