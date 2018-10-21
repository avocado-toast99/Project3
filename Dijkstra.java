/*
 Group Members:
 Algorithms and Data Structures
 Section CH 
 Project 3 - Dijkstra's Algorithm 
 */
package dijkstra;

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
        distance = Matrix[0];
        distance[0] = 0;

        // Call the Dijkstra method,
        char[][] paths = Dijkstra(Matrix, INF, distance);

        // Matrix after running Dijkstra algorithm:
        print(Matrix, distance, paths);

    }

    public static char[][] Dijkstra(int[][] Matrix, int INF, int[] distance) {

        /*
         Dijkstra’s Algorithm
        
        
         - Description:
        
        
         - Parameters:
        
        
        
         - Output:
        
        
         */
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        char[] nodes = new char[Matrix.length];
        for (int i = 0; i < Matrix.length; i++) {
            nodes[i] = alphabet[i];

        }

        int min = 0;
        int nextnode = 0;

        int[] visited = new int[6];
        int[] preD = new int[6];

        visited[0] = 1;

        for (int i = 0; i < Matrix.length; i++) {

            min = INF;
            for (int j = 0; j < Matrix.length; j++) {

                if (min > distance[j] && visited[j] != 1) {
                    min = distance[j];
                    nextnode = j;
                }

            }

            visited[nextnode] = 1;

            for (int k = 0; k < Matrix.length; k++) {

                if (visited[k] != 1) {

                    if (min + Matrix[nextnode][k] < distance[k]) {
                        distance[k] = min + Matrix[nextnode][k];
                        preD[k] = nextnode;

                    }

                }// if-
            } // for

        } //main for

        char[][] paths = new char[Matrix.length][Matrix.length];

        //reverse:
        for (int k = 0; k < 6; k++) {
            for (int l = 0; l < 6; l++) {
                paths[k][l] = 'x';
            }
        }

        for (int x = 0; x < 6; x++) {
            paths[0][x] = 'N';
        }
        paths[0][5] = 'a';

        for (int i = 1; i < 6; i++) {

            paths[i][0] = 'a';
            paths[i][5] = nodes[i];
            int j;

            j = i;

            do {

                j = preD[j];

                for (int ddd = 4; ddd > 0; ddd--) {
                    if (paths[i][ddd] == 'x' && nodes[j] != 'a') {
                        paths[i][ddd] = nodes[j];
                        break;
                    }
                }

            } while (j != 0);

        }

        System.out.println();

        return paths;

    }// meth

// 
    public static void print(int Matrix[][], int[] distance, char[][] paths) {

        for (int i = 0; i < 6; i++) {
            System.out.print("The shortest path from a to " + paths[i][5] + ":   ");

            if (distance[i] == 0) {
                System.out.print("NULL\n");

            } else {
                for (int j = 0; j < 6; j++) {
                    if (paths[i][j] != 'x') {
                        if (j == 5) {
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
    } // for-main

} // print
