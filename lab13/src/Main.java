import java.util.List;

public class Main {

    public static void main(String[] args) {
    	System.out.println("Graf nieskierowany lista ");
		ListGraph listGraph = new ListGraph(5);
		listGraph.addEdge(0,1);
		listGraph.addEdge(0,2);
		listGraph.addEdge(1,2);
		listGraph.addEdge(2,0);
		listGraph.addEdge(2,3);
		listGraph.addEdge(3,3);
		listGraph.addNode();
		listGraph.addEdge(1,5);
		listGraph.printGraph();

		System.out.println("-------------------------------------------");
		System.out.println("Graf skierowany lista ");
		System.out.println("-------------------------------------------");

		ListDirectedGraph listDirectedGraph = new ListDirectedGraph(5);

		listDirectedGraph.addEdge(0,1);
		listDirectedGraph.addEdge(0,2);
		listDirectedGraph.addEdge(1,2);
		listDirectedGraph.addEdge(2,0);
		listDirectedGraph.addEdge(2,3);
		listDirectedGraph.addEdge(3,3);
		listDirectedGraph.addNode();
		listDirectedGraph.addEdge(1,5);
		listDirectedGraph.printGraph();

		System.out.println("DFS");
		listDirectedGraph.DFS(2);
		System.out.println("BFS");

		listDirectedGraph.BFS(2);



		System.out.println("-------------------------------------------");
		System.out.println("Graf nieskierowany macierz ");
		System.out.println("-------------------------------------------");


		MatrixGraph matrixGraph = new MatrixGraph(5);
		matrixGraph.addEdge(0,1);
		matrixGraph.addEdge(0,2);
		matrixGraph.addEdge(1,2);
		matrixGraph.addEdge(2,0);
		matrixGraph.addEdge(2,3);
		matrixGraph.addEdge(3,3);
		matrixGraph.addNode();
		matrixGraph.addEdge(1,5);
		matrixGraph.printMatrix();



		System.out.println("-------------------------------------------");
		System.out.println("Graf skierowany macierz ");
		System.out.println("-------------------------------------------");

		MatrixDirectedGraph matrixDirectedGraph = new MatrixDirectedGraph(5);
		matrixDirectedGraph.addEdge(0,1);
		matrixDirectedGraph.addEdge(0,2);
		matrixDirectedGraph.addEdge(1,2);
		matrixDirectedGraph.addEdge(2,0);
		matrixDirectedGraph.addEdge(2,3);
		matrixDirectedGraph.addEdge(3,3);
		matrixDirectedGraph.addNode();
		matrixDirectedGraph.addEdge(1,5);
		matrixDirectedGraph.printMatrix();



    }
}
