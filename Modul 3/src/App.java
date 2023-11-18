public class App {
    public static void main(String[] args) throws Exception {
        SortingAndSearching ss = new SortingAndSearching();
        System.out.println("Nama Barang Semula :");
        ss.add("Mizon", 6000, 30);
        ss.add("Indomie Goreng", 3500, 8);
        ss.add("Pulpy", 3000, 17);
        ss.add("Indomie Soto", 3000, 12);
        ss.add("Kopikap", 1500, 40);
        ss.add("Nabati Coklat", 2000, 34);
        ss.add("Nabati Permen Karet", 2000, 39);
        ss.add("Kuda Mas Original", 1000, 77);
        ss.printAll();

        System.out.println("Bubble Sort :");
        ss.bubbleSort();
        ss.printAll();

        System.out.println("Insertion Sort :");
        ss.insertionSort();
        ss.printAll();

        System.out.println("Merge Sort :");
        ss.mergeSort();
        ss.printAll();
    }
}
