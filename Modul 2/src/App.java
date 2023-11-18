public class App {
    public static void main(String[] args) throws Exception {
        //Nomor 1
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();

        stack1.push("Goku");
        stack1.push("Anya");
        stack1.push("Nagato");
        stack1.push("Denji");
        stack1.push("Loid");

        System.out.println("Stack sebelum elemen dihapus :");
        stack1.printAll();

        stack1.save(stack1, stack2, "Anya");
        System.out.println("Stack setelah dihapus :");
        stack1.pop();
        stack1.mergelist(stack1, stack2);
        stack1.printAll();
    }
}
