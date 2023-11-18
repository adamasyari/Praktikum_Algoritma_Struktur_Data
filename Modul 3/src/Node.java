public class Node {
    Node next, prev;
    String namaBarang;
    int harga, stok;

    Node(String namaBarang, int harga, int stok){
        this.namaBarang = namaBarang;
        this.harga = harga;
        this.stok = stok;
    }
}
