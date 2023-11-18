package Modul_5;

class EdgeList {
    class Edge {
        Edge next, prev;
        Vertex destination;

        Edge(Vertex destination) {
            this.destination = destination;
        }
    }

    Edge head, tail;

    public void addEdge(Vertex destination) {
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
        if (head == null) {
            System.out.println("");
        } else {
            Edge current = head;
            while (current != null) {
                System.out.println(current.destination.name);
                current = current.next;
            }
            System.out.println();
        }
    }

}

class Vertex {
    String name;
    String item[] = new String[2];
    Vertex next;
    boolean visited = false;

    Vertex(String name, String item1, String item2) {
        this.name = name;
        item[0] = item1;
        item[1] = item2;
    }

    EdgeList edge = new EdgeList();

    public void addEdge(Vertex destination) {
        edge.addEdge(destination);
    }
}

class Doubly {
    class Node {
        boolean found = false;
        int nim;
        Graph fragment;

        Node(int nim, Graph fragment) {
            this.nim = nim;
            this.fragment = fragment;
        }

        Node next, prev;
    }

    Node head = null, tail = null;

    public void addLast(int nim, Graph fragment) {
        if (head == null) {
            head = tail = new Node(nim, fragment);
            head.prev = null;
            tail.next = null;
        } else {
            Node temp = new Node(head.nim, fragment);
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
            tail.next = null;
        }
    }

    public void printAll() {
        Node current = head;
        while (current != null) {
            System.out.println(current.nim);
            current.fragment.printAll();
            System.out.println();
            current = current.next;
        }
    }

    public void printDFS() {
        Node current = head;
        while (current != null) {
            System.out.println(current.nim);
            current.fragment.printDFS();
            System.out.println();
            current = current.next;
        }
    }

    public void BFSSearch(String item) {
        System.out.println("Cari : " + item);
        Node current = head;
        while (current != null) {
            current.fragment.BFSSearch(item, current);
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

    public void addVertex(String name, String item1, String item2) {
        Vertex newVertex = new Vertex(name, item1, item2);
        if (head == null) {
            head = newVertex;
            tail = newVertex;
        } else {
            tail.next = newVertex;
            tail = newVertex;
        }
    }

    public void insertEdge(String sourceName, String targetName) {
        Vertex source = searchVertex(sourceName);
        Vertex target = searchVertex(targetName);
        if (source != null && target != null) {
            source.addEdge(target);
        }
    }

    Vertex searchVertex(String name) {
        Vertex current = head;
        while (current != null) {
            if (current.name.equals(name)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void printAll() {
        Vertex current = head;
        while (current != null) {
            System.out.print("Vertex: [" + current.name + "]");
            System.out.print(" => Edge: ");
            current.edge.printEdge();
            current = current.next;
        }
    }

    public void DFS(Vertex head, Stack stack) {
        if (head == null) {
            return;
        } else {
            head.visited = true;
            System.out.println(head.name + ": [" + head.item[0] + "] [" + head.item[1] + "]");
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
        if (head != null) {
            Stack stack = new Stack();
            DFS(head, stack);
        }
        unvisited();
    }

    public void BFS(Vertex head, Queue queue, String item, Doubly.Node data) {
        if (head == null) {
            return;
        } else {
            head.visited = true;
            if (item.equals(head.item[0]) || item.equals(head.item[1])) {
                if (!data.found) {
                    System.out.println("Ketemu, " + item + " ada di");
                }
                data.found = true;
                System.out.println(data.nim + ", " + head.name);
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
        if (head != null) {
            Queue queue = new Queue();
            BFS(head, queue, item, data);
        }
        unvisited();
    }

    public void unvisited() {
        Vertex current = head;
        while (current != null) {
            current.visited = false;
            current = current.next;
        }
    }
}

class Stack {
    private class Node {

        Vertex value;

        Node next;

        Node(Vertex value) {
            this.value = value;
        }
    }

    Node head;

    Node tail;

    public void push(Vertex value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public Vertex pop() {

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

    public boolean isEmpty() {
        return (head == null);
    }

    public void printAll() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value.name + ", ");
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
        return (Tail == null);
    }

    public void enqueue(Vertex value) {
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
        return Tail.value;
    }

    public void printAll() {
        Node current = Head;
        while (current != null) {
            System.out.print(current.value.name + "[" + current.value.visited + "], ");
            current = current.Next;
        }
    }

    public boolean isAvalaible(Vertex value) {
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

public class ResponModul_5 {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addVertex("Maasai", "Amity", "Abnegation");

        Graph g2 = new Graph();
        g2.addVertex("Amity", "Erudite", "Dauntles");

        Doubly newDoubly = new Doubly();
        newDoubly.addLast(1, g);
        newDoubly.addLast(2, g2);
        System.out.println("|xxxxxxxxxxxxxxxxxxxx| Membuat Graph |xxxxxxxxxxxxxxxxxxxx|");
        newDoubly.printAll();
        System.out.println("|xxxxxxxxxxxxxxxxxxxx| DFS PRINT |xxxxxxxxxxxxxxxxxxxx|");
        newDoubly.printDFS();
    }
}
