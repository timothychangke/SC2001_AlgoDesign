import java.util.Scanner;

public class Dijkstras {
    private static void dijkstra(int[][] adjMatrix) {
        int matrix_len = adjMatrix.length;
        //visited array
        boolean visited[] = new boolean[matrix_len];
        //distance array
        int distance[] = new int[matrix_len];

        for (int i = 0; i < matrix_len; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < matrix_len - 1; i++) {
            //implementation of the priority queue
            int minVertex = findMinVertex();
            visited[minVertex] = true;
            //explore vertices connected to minVertix
            for (int j = 0; j < matrix_len; j++) {
                if (adjMatrix[minVertex][j] != 0 && !visited[j] && distance[minVertex] != Integer.MAX_VALUE) {
                    int newDistance = distance[minVertex] + adjMatrix[minVertex][j];
                    if (newDistance < distance[j]) {
                        distance[j] = newDistance;
                    }
                }
            }
            //print out vertices
            for (int k = 0 ; k < matrix_len; k++) {
                System.out.println(k + " " + distance[k]);
            }
        }

    }
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the total number of vertices: ");
        int vertex_num = scanner.nextInt();
        System.out.println("Enter the total number of edges: ");
        int edges_num = scanner.nextInt();
        int adjMatrix[][] = new int[vertex_num][edges_num];
        for (int i = 0; i < edges_num; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            int distance = scanner.nextInt();
            adjMatrix[vertex1][vertex2] = distance;
            //if it is a bidirectional graph
            //adjMatrix[vertex1][vertex2] = weight;
        }
    }
    private static int findMinVertex() {
        return 0;
    }
}