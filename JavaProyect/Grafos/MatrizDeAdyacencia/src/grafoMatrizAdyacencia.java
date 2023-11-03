import java.util.*;
import java.io.*;

public class grafoMatrizAdyacencia<T> {
    private int numVertices;
    private boolean[][] matrizAdyacencia;
    private ArrayList<T> vertices;

    public grafoMatrizAdyacencia(int numVertices) {
        this.numVertices = numVertices;
        this.matrizAdyacencia = new boolean[numVertices][numVertices];
        this.vertices = new ArrayList<>();
    }

    public void agregarVertice(T vertice) {
        try {
            vertices.add(vertice);
        } catch( Exception e) {
            System.out.println("Esta lleno");
        }
    }

    public void agregarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            matrizAdyacencia[origen][destino] = true;
        } else {
            System.out.println("Los índices de los vértices no son válidos.");
        }
    }

    public void mostrarMatrizAdyacencia() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrizAdyacencia[i][j] ? "1 " : "0 ");
            }
            System.out.println();
        }
    }

    public void bfs(int inicio) {
        if (inicio < 0 || inicio >= numVertices) {
            System.out.println("Índice de inicio no válido.");
            return;
        }

        boolean[] visitado = new boolean[numVertices];
        Queue<Integer> cola = new LinkedList<>();

        visitado[inicio] = true;
        System.out.println("Recorrido BFS desde el vértice " + vertices.get(inicio) + ":");
        System.out.print(vertices.get(inicio) + " ");

        cola.add(inicio);

        while (!cola.isEmpty()) {
            int verticeActual = cola.poll();

            for (int i = 0; i < numVertices; i++) {
                if (matrizAdyacencia[verticeActual][i] && !visitado[i]) {
                    visitado[i] = true;
                    System.out.print(vertices.get(i) + " ");
                    cola.add(i);
                }
            }
        }

    }
    public static void main(String[] args) {
        grafoMatrizAdyacencia<String> grafo = new grafoMatrizAdyacencia<>(5);
        grafo.agregarVertice("A");
        grafo.agregarVertice("B");
        grafo.agregarVertice("C");
        grafo.agregarVertice("D");
        grafo.agregarVertice("E");

        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(3, 4);
        grafo.agregarArista(4, 1);
        grafo.agregarArista(2, 3);
        grafo.agregarArista(2, 0);

        grafo.mostrarMatrizAdyacencia();

        grafo.bfs(5);
    }
}