package Project_Akhir;

public class Main {
   public static void main(String[] args) {
      Graph project = new Graph();
      
      project.addVertex("Ampenan");
      project.addVertex("Cakranegara");
      project.addVertex("Mataram");
      project.addVertex("Sandubaya");
      project.addVertex("Sekarbela");
      project.addVertex("Selaparang");
      project.addVertex("Lautan");
      
      project.addEdge("Ampenan", "Sekarbela");
      project.addEdge("Ampenan", "Selaparang");
      project.addEdge("Ampenan", "Lautan");
      project.addEdge("Cakranegara", "Mataram");
      project.addEdge("Cakranegara", "Sandubaya");
      project.addEdge("Cakranegara", "Selaparang");
      project.addEdge("Mataram", "Sekarbela");
      project.addEdge("Mataram", "Selaparang");
      project.addEdge("Mataram", "Sandubaya");
      project.addEdge("Mataram", "Cakranegara");
      project.addEdge("Sandubaya", "Mataram");
      project.addEdge("Sandubaya", "Cakranegara");
      project.addEdge("Sekarbela", "Ampenan");
      project.addEdge("Sekarbela", "Mataram");
      project.addEdge("Sekarbela", "Selaparang");
      project.addEdge("Sekarbela", "Lautan");
      project.addEdge("Selaparang", "Ampenan");
      project.addEdge("Selaparang", "Mataram");
      project.addEdge("Selaparang", "Sekarbela");
      project.addEdge("Lautan", "Ampenan");
      project.addEdge("Lautan", "Sekarbela");
      
      project.printVertex();
      System.out.println();
      project.printEdge();
      System.out.println();
      
      project.coloring();
      project.printColors();
      System.out.println();
      
      System.out.println("KODE WARNA : ");
      System.out.println("1. Merah\n2. Biru\n3. Hijau" );
      
      
      
      
      
   }
}
