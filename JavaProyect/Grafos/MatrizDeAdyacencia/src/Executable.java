import java.util.*;

import MatrizDeAdyacencia.model.graphsMatrixAdyacency;

public class Executable {

	private Scanner input;
	private graphsMatrixAdyacency<String> graph;

	public Executable(){
		input = new Scanner(System.in);
	}

	public static void main(String[] args) {	
		Executable executable = new Executable();
		executable.menu();
    }
	
	public void menu() {
		boolean indicator=false;

        System.out.println("\n escoja el tamaño de su grafo: ");
        int size = input.nextInt();
        graph = new graphsMatrixAdyacency<>(size);
        
		while(!indicator){
			System.out.println("\nGrafos");
			System.out.println("Escoja que desea hacer:");
			System.out.println("1. Añadir vertices");
			System.out.println("2. Añadir Aristas");
            System.out.println("3. Mostrar matriz de Adyacencia");
			System.out.println("4. Hacer recorrido BFS desde un vertice");
            System.out.println("5. Mirar si se es fuertemente conexo");
            
			System.out.println("0. Salir");
			int option = input.nextInt();
			input.nextLine();

			switch (option) {

				case 1:
					System.out.println("Introduzca el nombre del vertice");
					String vertex = input.nextLine();
                    graph.addVertex(vertex);
				break;

				case 2:
					int origin,destiny;
                    // Añadir metodo para to string en model
                    System.out.println("Introduzca el vertice de origen");
                    origin = input.nextInt();

					System.out.println("Introduzca el vertice de destino");
                    destiny = input.nextInt();

                    graph.addEdge(origin, destiny);

				break;

				case 3:
					graph.showMatriz();
				break;

				case 4:
					int choice;
					// Añadir metodo para to string en model
					System.out.println("Introduzca el vertice desde el que quiere hacer BFS");
					choice = input.nextInt();
					graph.bfs(choice);
				break;

				case 5:
					// Añadir metodo para revisar qu tan conexo es(hacer bfs en todos lo vertex y revisar si desde todos se puede acceder a todos)
				break;

				case 0:
					indicator=true;
				break;


				default:
					System.out.println("Esa no es una opcion!");
				break;
			}
		}
	}
}
 