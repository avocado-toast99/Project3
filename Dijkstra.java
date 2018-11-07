/*
 Group Members:
 Algorithms and Data Structures
 Section CH 
 Project 3 - Part 1 - Dijkstra's Algorithm 
 */
package dijkstra;

public class Dijkstra {

    public static void main(String[] args) {

        // Infinity variable equals 10000.
        int INF = 10000;

        // declare and initialize matrix
        int Matrix[][] = {{INF, 4, 3, INF, INF, INF},
        {4, INF, 2, 13, 10, INF},
        {3, 2, INF, 12, INF, INF},
        {INF, 13, 12, INF, 5, 1},
        {INF, 10, INF, 5, INF, 3},
        {INF, INF, INF, 1, 3, INF}};
        
        // initillize the source
        int source = 0;

        // Call the Dijkstra method,
        Object[] output = Dijkstra(Matrix, INF, source);

        char[][] paths = (char[][]) output[0];
        int[] distance = (int[]) output[1];

        // Matrix after running Dijkstra algorithm:
        print(Matrix, distance, paths, source);

    }

    public static Object[] Dijkstra(int[][] Matrix, int INF, int source) {

        /*
         Dijkstra’s Algorithm
        
        
         - Description:
        
        
         - Parameters:
           the matrix (Graph) , the infinity variable (not accessable directly ),and the source
        
        
         - Output:
        
        
         */
        //array to stor the first row of the matrix
        int[] distance = new int[Matrix.length];
        distance = Matrix[0];
        distance[0] = 0;
        
        // just array for the whole letters
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        
        // array for letters with the range of the original matrix
        char[] letters = new char[Matrix.length];
        // initilize letter array
        for (int i = 0; i < Matrix.length; i++) {
            letters[i] = alphabet[i];
        }
        // initillize the min and nextnode variables
        int min = 0;
        int nextnode = 0;
     
        // array to indicate weather the vertex is visited or not
        int[] visited = new int[Matrix.length];
        int[] preD = new int[Matrix.length];
     
        // source is visited 
        visited[source] = 1;
        // start with the algorithm 
        // iterate for the ith time: we iterate over the matrix i times 
        for (int i = 0; i < Matrix.length; i++) {

            min = INF;
            // iterate over ith row
            for (int j = 0; j < Matrix.length; j++) {

                if (min > distance[j] && visited[j] != 1) {
                    min = distance[j];
                    nextnode = j;
                }

            }

            visited[nextnode] = 1;
            // iterate over jth column
            for (int k = 0; k < Matrix.length; k++) {

                if (visited[k] != 1) {

                    if (min + Matrix[nextnode][k] < distance[k]) {
                        distance[k] = min + Matrix[nextnode][k];
                        preD[k] = nextnode;

                    }

                }// if
            } // for

        }

        //reverse:
        char[][] paths = new char[Matrix.length][Matrix[0].length];
        for (int k = 0; k < Matrix.length; k++) {
            for (int l = 0; l < Matrix[k].length; l++) {
                paths[k][l] = 'X';
            }
        }

        for (int columns = 0; columns < Matrix[0].length; columns++) {
            paths[source][columns] = 'N';
        }
        paths[source][paths.length - 1] = letters[source];

        for (int i = 1; i < Matrix[0].length; i++) {

            paths[i][source] = letters[source];
            paths[i][paths.length - 1] = letters[i];
            int j;

            j = i;

            do {

                j = preD[j];

                // int columns = Matrix.length - 2: 
                // we subtract 2 because 2 spots are reserved 
                // for the source and destination letters
                for (int columns = Matrix.length - 2; columns > 0; columns--) {
                    if (paths[i][columns] == 'X' && letters[j] != letters[source]) {
                        paths[i][columns] = letters[j];
                        break;
                    }
                }

            } while (j != 0);

        }

        System.out.println();

        return new Object[]{paths, distance};

    }// meth


    public static void print(int Matrix[][], int[] distance, char[][] paths, int source) {

        char sourceNode = paths[source][paths[source].length - 1];
        // iterate over rows
        for (int i = 0; i < Matrix.length; i++) {

            char destination = paths[i][paths[i].length - 1];

            System.out.print("The shortest path from " + sourceNode + " to " + destination + ":   ");

            if (i == source) {
                System.out.print("NULL\n");

            } else {
                // iterate over columns
                for (int j = 0; j < paths.length; j++) {
                    if (paths[i][j] != 'X') {
                        if (j == paths.length - 1) {
                            System.out.print(paths[i][j]);
                        } else {
                            System.out.print(paths[i][j] + "->");
                        }
                    }
                }

                System.out.print("\nwith the cost of " + distance[i] + "\n");

            }
            System.out.println("");
        }

        System.out.println();
    }

}
