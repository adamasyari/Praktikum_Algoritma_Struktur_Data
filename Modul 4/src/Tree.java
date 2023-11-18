public class Tree {
    Node root;

    void insert(String parent, String left, String right){
        if(root == null){
            root = new Node(parent);
            System.out.println(parent + " Dibuat Sebagai Root");
        } 

        Node name = search(root, parent);
        name.left = new Node(left);
        System.out.println(left + " ditambahkan sebagai left child dari " + parent);
        name.right = new Node(right);
        System.out.println(right + " ditambahkan sebagai left child dari " + parent);
    }
    Node search(Node root, String parent){
        if(root == null){
            return null;
        } else if (root.name == parent) {
            return root;
        }
        Node tmp = search(root.left, parent);

        if(tmp != null){
            return tmp;
        }else {
            return search(root.right, parent);
        }
    }
    int ceckLevel(Node node, String data, int level){
        if(node == null){
            return 0;
        }
        if(node.name == data){
            return level;
        }

        int smaller = ceckLevel(node.left, data, level + 1);
        if(smaller != 0){
            return smaller;
        }

        smaller = ceckLevel(node.right, data, level + 1);
        return smaller;
    }
    String searchParent(Node node, String recent, String parent){
        if(node == null){
            return null;
        }
        if(node.name == recent){
            return parent;
        }

        String tmp = searchParent(node.left, recent, node.name);
        if(tmp != null){
            return tmp;
        } else {
            return searchParent(node.right, recent, node.name);
        }
    }
    void relation(String name1, String name2) {
        String tmp = null, tmp2 = null;
        int nilai1 = ceckLevel(root, name1, 0);
        int nilai2 = ceckLevel(root, name2, 0);
        int selisih = nilai1 - nilai2;

        if (selisih == 0) {
            tmp = searchParent(root, name1, null);
            tmp2 = searchParent(root, name2, null);

            if (tmp.equalsIgnoreCase(tmp2)) {
                System.out.printf("%s adalah saudara dari %s\n", name1, name2);
            } else {
                System.out.printf("%s adalah saudara jauh dari %s\n", name1, name2);
            }
        } else if (selisih == 1) {
            if (searchParent(root, name1, " ").equalsIgnoreCase(name2)) {
                System.out.printf("%s adalah anak %s\n", name1, name2);
            } else {
                tmp = searchParent(root, name1, null);
                tmp = searchParent(root, tmp, null);

                if (tmp.equalsIgnoreCase(searchParent(root, name2, null))) {
                    System.out.printf("%s adalah keponakan dari %s\n", name1, name2);
                } else {
                    System.out.printf("%s adalah keponakan jauh dari %s\n", name1, name2);
                }
            }
        } else if (selisih == 2) {
            tmp = searchParent(root, name1, null);
            tmp = searchParent(root, tmp, null);

            if (tmp.equalsIgnoreCase(name2)) {
                System.out.printf("%s adalah cucu dari %s\n", name1, name2);
            } else {
                System.out.printf("%s adalah cucu jauh dari %s\n", name1, name2);
            }
        } else if (selisih == 3) {
            System.out.printf("%s adalah cicit dari %s\n", name1, name2);
        } else if (selisih == -1) {
            if (searchParent(root, name2, " ").equalsIgnoreCase(name1)) {
                System.out.printf("%s adalah anak %s\n", name2, name1);
            } else {
                tmp = searchParent(root, name2, null);
                tmp = searchParent(root, tmp, null);

                if (tmp.equalsIgnoreCase(searchParent(root, name1, null))) {
                    System.out.printf("%s adalah keponakan dari %s\n", name2, name1);
                } else {
                    System.out.printf("%s adalah keponakan jauh dari %s\n", name2, name1);
                }
            }
        } else if (selisih == -2) {
            tmp = searchParent(root, name2, null);
            tmp = searchParent(root, tmp, null);

            if (tmp.equalsIgnoreCase(name1)) {
                System.out.printf("%s adalah cucu dari %s\n", name2, name1);
            } else {
                System.out.printf("%s adalah cucu jauh dari %s\n", name2, name1);
            }
        } else if (selisih == -3) {
            System.out.printf("%s adalah cicit dari %s\n", name2, name1);
        } else {
            System.out.printf("%s dan %s tidak memiliki garis keturunan", name1, name2);
        }
    }
    void preOrder(Node root){
        if(root != null){
            if(root.left != null){
                System.out.println(root.name + ": " + root.left.name + " & " + root.right.name);
                preOrder(root.left);
                preOrder(root.right);
            } else {
                System.out.println(root.name + ": -");
            }
        }
    }
    void po(){
        preOrder(root);
    }
}
