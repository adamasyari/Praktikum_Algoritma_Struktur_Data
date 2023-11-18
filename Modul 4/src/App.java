import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Tree tree = new Tree();
        Scanner java = new Scanner(System.in);

        tree.insert("DAUS", "PUTRI", "DADEN");
        tree.insert("PUTRI", "ARI", "LILUL");
        tree.insert("DADEN", "ARSAN", "JIDAN");
        tree.insert("ARI", "UNO", "SHAFA");
        tree.insert("LILUL", "DIAZ", "MELKI");
        tree.insert("ARSAN", "MAHEN", "ALITA");
        tree.insert("JIDAN", "ROZAKI", "AGUNG");

        System.out.println("\n" + "HUBUNGAN" + "\n");
        tree.relation("PUTRI", "DAUS");
        tree.relation("DAUS", "SHAFA");
        tree.relation("MAHEN", "ALITA");
        tree.relation("MAHEN", "UNO");
        tree.relation("DAUS", "LILUL");
        tree.relation("MELKI", "DADEN");
        tree.relation("ARSAN", "ROZAKI");
        tree.relation("ROZAKI", "ARI");
        tree.relation("DIAZ", "AGUNG");

        System.out.println("\n" + "PRE-ORDER" + "\n");
        tree.po();
        java.close();
    }
}
