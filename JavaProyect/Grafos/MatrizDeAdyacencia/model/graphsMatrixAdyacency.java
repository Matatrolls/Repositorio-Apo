package MatrizDeAdyacencia.model;

import java.util.*;

public class graphsMatrixAdyacency<T> {
    private int numedges;
    private boolean[][] matrizAdyacency;
    private ArrayList<T> vertex;
    

    public graphsMatrixAdyacency(int numedges) {
        this.numedges = numedges;
        this.matrizAdyacency = new boolean[numedges][numedges];
        this.vertex = new ArrayList<>();
        
    }

    public void addVertex(T vertice) {
        try {
            vertex.add(vertice);
        } catch( Exception e) {
            System.out.println("Esta lleno");
        }
    }

    public void addEdge(int origin, int destiny) {
        if (origin >= 0 && origin < numedges && destiny >= 0 && destiny < numedges) {
            matrizAdyacency[origin][destiny] = true;
        } else {
            System.out.println("Los índices de los vértices no son válidos.");
        }
    }

    public void showMatriz() {
        for (int i = 0; i < numedges; i++) {
            for (int j = 0; j < numedges; j++) {
                System.out.print(matrizAdyacency[i][j] ? "1 " : "0 ");
            }
            System.out.println();
        }
    }

    public String toString(){
        String msg="";

        return msg;
    }

    public void bfs(int start) {
        if (start < 0 || start >= numedges) {
            System.out.println("Índice de inicio no válido.");
            return;
        }

        boolean[] visited = new boolean[numedges];
        Queue<Integer> tail = new LinkedList<>();

        visited[start] = true;
        System.out.println("Recorrido BFS desde el vértice " + vertex.get(start) + ":");
        System.out.print(vertex.get(start) + " ");

        tail.add(start);

        while (!tail.isEmpty()) {
            int actualVertex = tail.poll();

            for (int i = 0; i < numedges; i++) {
                if (matrizAdyacency[actualVertex][i] && !visited[i]) {
                    visited[i] = true;
                    System.out.print(vertex.get(i) + " ");
                    tail.add(i);
                }
            }
        }

    }
}
