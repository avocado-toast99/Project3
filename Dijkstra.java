/*

 Group Members:


 Algorithms and Data Structures
 Section CH 
 Project 3 - Dijkstra's Algorithm 




 */
package dijkstra;

import java.util.*;

public class Dijkstra {

    public static void main(String[] args) {

        // Infinity variable equals 10000.
        final int INF = 10000;
        // declare and initialize matrix
        int Matrix[][] = {{INF, 4, 3, INF, INF, INF},
        {4, INF, 2, 13, 10, INF},
        {3, 2, INF, 12, INF, INF},
        {INF, 13, 12, INF, 5, 1},
        {INF, 10, INF, 5, INF, 3},
        {INF, INF, INF, 1, 3, INF}};

        // the row of matrix
        int[] distance = new int[6];
        int[] visited = new int[6];
        int[] preD = new int[6];
        int min = 0;
        int nextnode = 0;
        char[] nodes = {'a', 'b', 'c', 'd', 'e', 'f'};

        distance = Matrix[0];
        distance[0] = 0;
        visited[0] = 1;

        //   LinkedList Path = new LinkedList();
        // Call the Dijkstra method,
        /// ArrayList<LinkedList> AllPaths = 
        Dijkstra(Matrix, min, INF, distance, visited, nextnode, preD, nodes);

        /// Object[] wadup = AllPaths.toArray();
//        System.out.println("here:");
//        for (int i = 0; i < AllPaths.size(); i++) {
//
//            System.out.println(AllPaths.get(i).toString());
//            System.out.println("-----------");
//            System.out.println(AllPaths.get(i));
//            System.out.println("");
//        }
        // Matrix after running Dijkstra algorithm:
        print(Matrix, preD, nodes, distance);

    }

    public static void Dijkstra(int[][] Matrix, int min, int INF, int[] distance, int[] visited, int nextnode, int[] preD, char[] nodes) {

        /*
         Dijkstra’s Algorithm
        
        
         - Description:
        
        
         - Parameters:
        
        
        
         - Output:
        
        

         */
//        LinkedList SinglePath = new LinkedList();
//
//        ArrayList<LinkedList> AllPaths = new ArrayList<LinkedList>();
        char[][] Paths = new char[Matrix.length][Matrix.length];

        // initialize paths to x
        for (int i = 0; i < Paths.length; i++) {

            for (int j = 0; j < Paths.length; j++) {
                Paths[i][j] = 'x';

            }

        }
        // print paths:

        for (int i = 0; i < Paths.length; i++) {

            for (int j = 0; j < Paths.length; j++) {
                System.out.print(Paths[i][j] + " ");

            }

            System.out.println("\n");

        }

        System.out.println("\n");

        for (int i = 0; i < Matrix.length; i++) {

            min = INF;
            // find the shortest path:
            for (int j = 0; j < Matrix.length; j++) {
                if (min > distance[j] && visited[j] != 1) {
                    min = distance[j];
                    nextnode = j;
                    Paths[j][0] = 'a';
                   Paths[j][Matrix.length-1] = nodes[nextnode];
                    

                }

            }

            // print paths
            for (int x = 0; x < Paths.length; x++) {

                for (int y = 0; y < Paths.length; y++) {
                    System.out.print(Paths[x][y] + " ");

                }

                System.out.println("\n");

            }

            visited[nextnode] = 1;
            // SinglePath.insert(nodes[nextnode] + "");

            for (int k = 0; k < Matrix.length; k++) {
                if (visited[k] != 1) {
                    if (min + Matrix[nextnode][k] < distance[k]) {
                        distance[k] = min + Matrix[nextnode][k];
//                        if(preD[0]!=0 ){
//                        preD[0]=0;
//                        }
                        preD[k] = nextnode;
                        // System.out.println("nextnode: "+nextnode);

                        
                        
                        //insert into path:
                        for (int j = 0; j < Paths[k].length; j++) {

                            
//                            System.out.println("at row: "+ k + " column: "+j);
//                            System.out.println("content of Paths[k][j]: " + Paths[k][j]);
//                           
                            





                            if (Paths[k][j] == 'x') {
                                Paths[k][j] = nodes[preD[k]];
                                break;
                            }

                        }

                        System.out.println("preD[k]: " + preD[k]);
                        /// SinglePath.insert(nodes[nextnode] + "");
                        //SinglePath.length+=distance[k];

                    }
                }

                System.out.println("\n\n");
            }
//
//            if (true) {
//
//                System.out.println("now printing single path:");
//                for (int j = 0; j < SinglePath.length; j++) {
//                    if (!SinglePath.isEmpthy()) {
//                        SinglePath.PrintPath();
//                    }
//
//                }
//
//                System.out.println("");
//                AllPaths.add(SinglePath);
//                SinglePath = new LinkedList();
//
//            }
        }
    }

    public static void print(int Matrix[][], int[] preD, char[] nodes, int[] distance) {

        System.out.println("PRED contents: ");
        for (int i = 0; i < preD.length; i++) {
            System.out.println(preD[i]);

        }
        System.out.println("PRED end");

        System.out.println("expected PRED contents: 0 0 02 01");

        for (int i = 0; i < 10; i++) {

        }

        //   reverse(preD);
        for (int i = 0; i < Matrix.length; i++) {
            int j;
            System.out.print("The shortest path from a to " + nodes[i] + ":   ");

            j = i;

            do {

                if (distance[i] == 0) {
                    System.out.print("NULL");
                } else {

                    do {
                        j = preD[j];
                        System.out.print(nodes[j] + " -> ");
                    } while (j != 0);

                    System.out.printf(nodes[i] + "\nwith the cost of " + distance[i] + "\n");

                }

            } while (j != 0);

            System.out.println();
        }

    }

    public static void reverse(int[] preD) {
        //method 1:
//    for (int left = 0, right = preD.length - 1; left < right; left++, right--) {
//        // swap the values at the left and right indices
//        int temp = preD[left];
//        preD[left]  = preD[right];
//        preD[right] = temp;
//    }

//        
//        System.out.println("BEFORE");
//        for (int i = 0; i < preD.length; i++) {
//            System.out.print(preD[i]);
//            
//        }
//        
//        method 2: 
//        for (int i = 0; i < preD.length/2; i++) {
//            {
//                int temp = preD[i];
//                preD[i] = preD[preD.length - i - 1];
//                preD[preD.length - i - 1] = temp;
//            }
//        }
//        System.out.println("AFTER:");
//
//for (int i = 0; i < preD.length; i++) {
//            System.out.print(preD[i]);
//            
//        }
//    }
    }
}
