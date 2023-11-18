package Project_Akhir;

public class Graph {
   Vertex head;
   Vertex tail;
   int maxColor = 0;

   public void addVertex(String name) {
      Vertex baru = new Vertex(name);
      if (head == null) {
         head = tail = baru;
      } else {
         tail.next = baru;
         tail = baru;
      }
   }

   public Vertex findVertex(String name) {
      Vertex current = head;
      while (current != null) {
         if (current.name == name) {
            return current;
         }
         current = current.next;
      }
      return null;
   }

   public void addEdge(String awal, String Akhir) {
      Vertex start = findVertex(awal);
      Vertex finish = findVertex(Akhir);
      Edge baru = new Edge();

      if (start.route == null) {
         start.route = start.Endroute = baru;
      } else {
         start.Endroute.next = baru;
         start.Endroute = baru;
      }
      start.Endroute.location = finish;
      start.routeCount++;
   }

   public void printVertex() {
      Vertex current = head;
      while (current != null) {
         System.out.println(current.name);
         current = current.next;
      }
   }

   public void printEdge() {
      Vertex current = head;
      Edge visit;

      while (current != null) {
         System.out.print(current.name + " = ");
         visit = current.route;
         while (visit != null) {
            System.out.print(visit.location.name + ", ");
            visit = visit.next;
         }
         System.out.println();
         current = current.next;
      }
   }

   public int GetVertexSize() {
      int count = 0;
      Vertex current = head;
      while (current != null) {
         count++;
         current = current.next;
      }
      return count;
   }

   public int setVertexDegree(String name) {
      int count = 0;
      Vertex find = findVertex(name);
      if (find.route != null) {
         Edge current = find.route;
         while (current != null) {
            count++;
            current = current.next;
         }
         return count;
      }
      return 0;
   }

   public void sortVertices() {
      for (int i = 0; i < GetVertexSize() - 1; i++) {
         Vertex current = head;
         Vertex previous = null;
         int j = 0;
         while (j < GetVertexSize() - i - 1 && current.next != null) {
            if (current.routeCount < current.next.routeCount) {
               // swap nodes
               Vertex temp = current.next;
               current.next = temp.next;
               temp.next = current;
               if (previous != null) {
                  previous.next = temp;
               } else {
                  head = temp;
               }
            }

            previous = current;
            current = current.next;
            j++;
         }
      }
   }

   public void coloring() {

      sortVertices();
      head.color = 1;
      maxColor = 1;
   
      Vertex current = head.next;
      while (current != null) {
         
         boolean[] usedColors = new boolean[maxColor + 1];
         Edge e = current.route;
         while (e != null) {
            if (e.location.color != 0) {
               usedColors[e.location.color] = true;
            }
            e = e.next;
         }

         int color = 1;
         while (color <= maxColor && usedColors[color]) {
            color++;
         }
         if (color > maxColor) {
            maxColor++;
         }
         current.color = color;
         current = current.next;
      }
   }

   public void printColors() {
      Vertex current = head;
      while (current != null) {
         System.out.println(current.name + ": " + current.color);
         current = current.next;
      }
   }

   public void GetVertexDegree() {
      Vertex current = head;
      while (current != null) {
         System.out.println(current.name + " = " + setVertexDegree(current.name));
         current = current.next;
      }
   }

}
