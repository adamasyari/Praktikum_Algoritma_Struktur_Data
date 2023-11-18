public class Node {
    Node next, prev;
    public String name;
    public Object tinggi, power;

    Node(String name, Object tinggi, Object power){
        this.name = name;
        this.tinggi = tinggi;
        this.power = power;
    }
    Node(String name){
        this.name = name;
    }
}
