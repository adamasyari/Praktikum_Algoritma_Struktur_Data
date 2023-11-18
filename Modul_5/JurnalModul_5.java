package Modul_5;

class Vertex {
    String city;
    String item[] = new String[2];
    Vertex next;
    boolean visited = false;

    Vertex(String city, String item1, String item2) {
        this.city = city;
        item[0] = item1;
        item[1] = item2;
    }

    EdgeList edge = new EdgeList();

    public void addEdge(Vertex destination) {
        edge.addEdge(destination);
    }
}

class EdgeList {
    class Edge {
        Edge next;
        Edge prev;
        Vertex destination;

        Edge(Vertex destination) {
            this.destination = destination;
        }
    }

    Edge head;
    Edge tail;

    public void addEdge(Vertex destination) {
        /* method addEdge nerfungsi untuk menambahkan data pada Edge */
        Edge newEdge = new Edge(destination);
        if (head == null) {
            head = newEdge;
            tail = newEdge;
        } else {
            newEdge.prev = tail;
            tail.next = newEdge;
            tail = newEdge;
        }
    }

    public void printEdge() {
        /* method printEdge berfungsi untuk menampilkan data yang ada pada Edge */
        if (head == null) {
            System.out.print("-\n");
        } else {
            Edge current = head;
            while (current != null) {
                System.out.print("[" + current.destination.city + "] ");
                current = current.next;
            }
            System.out.println();
        }
    }
}

class Doubly {
    class Node {
        boolean found = false;
        int tahun;
        Graph Avenger;

        Node(int tahun, Graph Avenger) {
            this.tahun = tahun;
            this.Avenger = Avenger;
        }

        Node next;
        Node previous;
    }

    Node head = null;
    Node tail = null;

    public void addLast(int tahun, Graph Avenger) {
        /*
         * method addLast() berfungsi untuk menambahkan nilai baru di urutan terakhir
         */
        if (head == null) {
            head = tail = new Node(tahun, Avenger);
            head.previous = null;
            tail.next = null;
        } else {
            Node temp = new Node(tahun, Avenger);
            tail.next = temp;
            temp.previous = tail;
            tail = temp;
            tail.next = null;
        }
    }

    public void printAll() {
        /* method printAll() berfungsi untuk menampilkan data pada linked list */
        Node current = head;
        while (current != null) {
            System.out.println("Tahun " + current.tahun);
            current.Avenger.printAll();
            System.out.println();
            current = current.next;
        }
    }

    public void printDFS() {
        /* method printDFS() berfungsi untuk menampilkan data pada DFS */
        Node current = head;
        while (current != null) {
            System.out.println("Tahun " + current.tahun);
            current.Avenger.printDFS();
            System.out.println();
            current = current.next;
        }
    }

    public void BFSSearch(String item) {
        /*
         * method BFSSearch() berfungsi untuk pencarian melebar yang dilakukan dengan
         * mengunjungi node pada level n terlebih dahulu sebelum mengunjungi node-node
         * pada level n+1
         */
        System.out.println("Cari: " + item);
        Node current = head;
        while (current != null) {
            current.Avenger.BFSSearch(item, current);
            if (current.next != null) {
                current.next.found = current.found;
            }
            current = current.next;
        }
    }
}

class Graph {
    Vertex head = null;
    Vertex tail = null;

    public void addVertex(String city, String item1, String item2) {
        /* method addVertex() berfungsi untuk menambahkan data pada Vertex */
        Vertex newVertex = new Vertex(city, item1, item2);
        if (head == null) {
            head = newVertex;
            tail = newVertex;
        } else {
            tail.next = newVertex;
            tail = newVertex;
        }
    }

    public void insertEdge(String sourceCity, String destinationCity) {
        /* method insertEdge() berfungsi untuk menambahkan data pada Edge */
        Vertex source = searchVertex(sourceCity);
        Vertex destination = searchVertex(destinationCity);
        if (source != null && destination != null) {
            source.addEdge(destination);
        }
    }

    Vertex searchVertex(String city) {
        /* method searchVertex() berfungsi untuk mencari data vertex */
        Vertex current = head;
        while (current != null) {
            if (current.city.equals(city)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void printAll() {
        /* method printAll() berfungsi untuk menampilkan data pda linked list */
        Vertex current = head;
        while (current != null) {
            System.out.print("Vertex: [" + current.city + "]");
            System.out.print(" => Edge: ");
            current.edge.printEdge();
            current = current.next;
        }
    }

    public void DFS(Vertex head, Stack stack) {
        /*
         * method DFS() berfungsi untuk pencarian mendalam yang dimulai dari node awal
         * dilanjutkan dengan hanya mengunjungi node anak paling kiri pada tingkat
         * selanjutnya.
         */
        if (head == null) {
            return;
        } else {
            head.visited = true;
            System.out.println(head.city + ": [" + head.item[0] + "] [" + head.item[1] + "]");
            if (head.edge.tail != null) {
                EdgeList.Edge neighbor = head.edge.tail;
                while (neighbor != null) {
                    if (!neighbor.destination.visited) {
                        stack.push(neighbor.destination);
                    }
                    neighbor = neighbor.prev;
                }
            }
            DFS(stack.pop(), stack);
        }
    }

    public void printDFS() {
        /* method printDFS() berfungsi untuk menampilkan data pada DFS */
        if (head != null) {
            Stack stack = new Stack();
            DFS(head, stack);
        }
        unvisited();
    }

    public void BFS(Vertex head, Queue queue, String item, Doubly.Node data) {
        /*
         * method BFS() berfunsgi untuk pencarian yang dilakukan dengan mengunjungi
         * tiap-tiap node secara sistematis pada setiap level hingga keadaan tujuan
         * ditemukan
         */
        if (head == null) {
            return;
        } else {
            head.visited = true;
            if (item.equals(head.item[0]) || item.equals(head.item[1])) {
                if (!data.found) {
                    System.out.println("Ketemu, " + item + " ada di");
                }
                data.found = true;
                System.out.println(data.tahun + ", " + head.city);
            }
            if (head.edge.head != null) {
                EdgeList.Edge neighbor = head.edge.head;
                while (neighbor != null) {
                    if (!neighbor.destination.visited) {
                        queue.enqueue(neighbor.destination);
                    }
                    neighbor = neighbor.next;
                }
            }
            BFS(queue.dequeue(), queue, item, data);
        }
    }

    public void BFSSearch(String item, Doubly.Node data) {
        /* method BFSSearch() berfungsi untuk mencari data pada BFS */
        if (head != null) {
            Queue queue = new Queue();
            BFS(head, queue, item, data);
        }
        unvisited();
    }

    public void unvisited() {
        /* method unvisited() berfungsi untuk mencari data yang tidak terlihat */
        Vertex current = head;
        while (current != null) {
            current.visited = false;
            current = current.next;
        }
    }
}

class Stack {
    private class Node {
        // mendeklarasikan variabel dengan nama value dengan tipe dara Object
        // tipe data object memiliki fungsi yang hampir sama dengan generic namun
        // untuk menyimpan data sesuai dengan tipe data dinamis,
        Vertex value;
        // mendeklarasikan variabel dengan tipe data node untuk merujuk ke node
        // selanjutnya
        Node next;

        // membuat konstraktor dari class Node untuk otomatis menginputkan nilai dari
        // variabel
        // value hanya dengan parameter
        Node(Vertex value) {
            this.value = value;
        }
    }

    // mendeklarasikan variabel head dengan tipe data node untuk menandakan sebagai
    // data awal
    Node head;
    // mendeklarasikan variabel head dengan tipe data node untuk menandakan sebagai
    // data akhir
    Node tail;

    // membuat function untuk menambahkan data pada stack
    // dengan parameter value dari user
    public void push(Vertex value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    // membuat fungsi untuk mengambil data sekaligus menghapus data tersebut
    public Vertex pop() {
        // membuat kondisi jika data masih belum ada, maka akan ,
        // memberikan peringatan bahawa elemen belum ada
        if (isEmpty()) {
            return null;
        } else {
            Node popItem = head;
            if (head.next != null) {
                head = head.next;
            } else {
                head = null;
            }
            return popItem.value;
        }
    }

    // membuat fungsi untuk memeriksa apakah stack tersebut masih kosong atau tidak
    public boolean isEmpty() {
        return (head == null);
    }

    public void printAll() {
        /* method printAll() berfungsi untuk menampilkan data pada stack */
        Node current = head;
        while (current != null) {
            System.out.print(current.value.city + ", ");
            current = current.next;
        }
        System.out.println();
    }
}

class Queue {
    public class Node {
        Vertex value;
        Node Next;
        Node Previous;

        Node(Vertex value) {
            this.value = value;
        }
    }

    Node Head;
    Node Tail;

    public boolean isEmpty() {
        /*
         * method isEmpty() berfungsi untuk memeriksa apakah queue tersebut sudah terisi
         * atau belum
         */
        return (Tail == null);
    }

    public void enqueue(Vertex value) {
        /* method enqueue() berfungsi untuk menambahkan data pada queue */
        Node newNode = new Node(value);
        if (isEmpty()) {
            Head = newNode;
            Tail = newNode;
            Head.Previous = null;
            Tail.Next = null;
        } else if (!isAvalaible(value)) {
            newNode.Next = Head;
            Head.Previous = newNode;
            Head = newNode;
        }
    }

    public Vertex dequeue() {
        /*
         * method dequeue berfungsi untuk mengambil data yang pertama masuk ke dalam
         * queue
         */
        if (isEmpty()) {
            return null;
        } else {
            Vertex temp = Tail.value;
            if (Tail.Previous != null) {
                Tail = Tail.Previous;
            } else {
                Tail = null;
            }
            return temp;
        }
    }

    public Vertex peek() {
        /* method peek() berfungsi untuk mengmbalikan data pada queue */
        return Tail.value;
    }

    public void printAll() {
        /* method printAll berfungsi untuk menampilkan data pada queue */
        Node current = Head;
        while (current != null) {
            System.out.print(current.value.city + "[" + current.value.visited + "], ");
            current = current.Next;
        }
    }

    public boolean isAvalaible(Vertex value) {
        /*
         * method isAvalaible() befungsi untuk menentukan apakah data tersebut tersedia
         * atau tidak
         */
        Node current = Head;
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            current = current.Next;
        }
        return false;
    }
}

public class JurnalModul_5 {
    public static void main(String[] args) {
        Graph thn1970 = new Graph();
        thn1970.addVertex("New York", "Super Serum", "Mie Ayam Ceker");
        thn1970.addVertex("Markas S.H.I.E.L.D.", "Partikel Pym", "Seblak Korea");
        thn1970.addVertex("Wakanda", "Vibranium", "Adamantium");
        thn1970.addVertex("Asgard", "Mjolnir", "Sprite");
        thn1970.addVertex("Vormir", "Soul Stone", "Ceker Mercon");

        thn1970.insertEdge("New York", "Markas S.H.I.E.L.D.");
        thn1970.insertEdge("Markas S.H.I.E.L.D.", "Wakanda");
        thn1970.insertEdge("Wakanda", "New York");
        thn1970.insertEdge("New York", "Asgard");
        thn1970.insertEdge("Asgard", "Vormir");

        Graph thn2012 = new Graph();
        thn2012.addVertex("New York", "Space Stone", "Nasi Padang");
        thn2012.addVertex("Sanctum Sanctorum", "Thai Tea", "Time Stone");
        thn2012.addVertex("Morag", "Power Stone", "Es Semangka India");
        thn2012.addVertex("Kekalik", "Suit IronMan", "Printer");
        thn2012.addVertex("Midgard", "Boba", "Sempol");

        thn2012.insertEdge("New York", "Sanctum Sanctorum");
        thn2012.insertEdge("Sanctum Sanctorum", "Morag");
        thn2012.insertEdge("Sanctum Sanctorum", "Midgard");
        thn2012.insertEdge("Midgard", "Kekalik");
        thn2012.insertEdge("Morag", "Kekalik");

        Graph thn2015 = new Graph();
        thn2015.addVertex("Hollywood", "DVD Avenger", "Microphone");
        thn2015.addVertex("Knowhere", "Mind Stone", "Batu Akik");
        thn2015.addVertex("New York", "KFC", "IPhone 13");
        thn2015.addVertex("Vormir", "Mouse Wireless", "Keyboard");
        thn2015.addVertex("Asgard", "Mjolnir", "Storm Breaker");
        thn2015.addVertex("Qatar", "Yamaha YZR-M1", "Ducati GP15");
        thn2015.addVertex("Valencia", "Kartu UNO", "Kartu Remi");

        thn2015.insertEdge("Hollywood", "Knowhere");
        thn2015.insertEdge("Knowhere", "New York");
        thn2015.insertEdge("New York", "Vormir");
        thn2015.insertEdge("Vormir", "Hollywood");
        thn2015.insertEdge("New York", "Asgard");
        thn2015.insertEdge("New York", "Valencia");
        thn2015.insertEdge("Valencia", "Qatar");
        thn2015.insertEdge("Asgard", "Qatar");

        Doubly EndGame = new Doubly();
        EndGame.addLast(1970, thn1970);
        EndGame.addLast(2012, thn2012);
        EndGame.addLast(2015, thn2015);
        System.out.println("|xxxxxxxxxxxxxxxxxxxx| Membuat Graph |xxxxxxxxxxxxxxxxxxxx|");
        EndGame.printAll();
        System.out.println("|xxxxxxxxxxxxxxxxxxxx| DFS PRINT |xxxxxxxxxxxxxxxxxxxx|");
        EndGame.printDFS();
        System.out.println("|xxxxxxxxxxxxxxxxxxxx| BFS SEARCHING |xxxxxxxxxxxxxxxxxxxx|");
        EndGame.BFSSearch("Power Stone");
    }
}