public class App {
    public static void main(String[] args) throws Exception {
        //Nomor 1
        LinkedList list = new LinkedList();
        list.add("Alita",155,33);
        list.add("Putri",138,34);
        list.add("Devian",160,36);
        list.add("Dadi",164,37);
        list.add("Melki",165,40);
        list.add("Pande",168,51);
        list.add("Agus",169,54);
        list.add("Azzam",170,57);
        list.add("Weng",182,61);
        list.add("Jidan",183,62);

        //Menampilkan semua nilai pada node
        System.out.println("Output Barisan Semula");
        list.printAll();

        //Dadi dan Agus pergi hunting makanan
        list.remove("Dadi");
        list.remove("Agus");

        System.out.println("Output ketika penampilan Feast");
        list.printAll();

        System.out.println("Output ketika Devian kelelahan dan keluar barisan");
        list.remove("Devian");
        list.printAll();

        System.out.println("Output ketika Dadi datang dan menggantikan Devian");
        list.addAfter("Putri","Dadi",164,37);
        list.printAll();

        System.out.println("Output ketika Azzam menggalau dan keluar barisan");
        list.remove("Azzam");
        list.printAll();

        System.out.println("Output ketika kedatangan Agus menggantikan Azzam");
        list.addAfter("Pande","Agus",169,54);
        list.printAll();

        //Nomor 2
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        System.out.println("BERTEDUH");
        list1.add("Dadi",164,37);
        list1.add("Agus",169,54);
        list1.add("Weng",182,61);
        list1.add("Jidan",183,62);
        list1.printAllRev();

        System.out.println("TETAP MENONTON KONSER");
        list2.add("Alita",155,33);
        list2.add("Putri",138,34);
        list2.add("Melki",165,40);
        list2.add("Permadi",168,51);
        list2.printAllRev();

        System.out.println("Output");
        Merged.mergedList(list2, list1);
        list2.printAllRev();
    }
}
