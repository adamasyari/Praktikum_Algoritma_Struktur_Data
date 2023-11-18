package Project_Akhir;

public class Vertex {
   String name;
   Vertex next;
   int routeCount = 0;
   int color = 0;
   Edge route;
   Edge Endroute;
   boolean visited = false;
   
   Vertex (String name){
      this.name = name;
   }
}