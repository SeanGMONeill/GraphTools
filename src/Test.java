import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		
		Graph graph = new Graph();
		
		graph.addVertex(new Vertex("A"));
		graph.addVertex(new Vertex("B"));
		graph.addVertex(new Vertex("C"));
		graph.addVertex(new Vertex("D"));
		
		graph.addEdge(new Edge(graph.getVertexByName("A"), graph.getVertexByName("B")));
		graph.addEdge(new Edge(graph.getVertexByName("B"), graph.getVertexByName("C")));
		graph.addEdge(new Edge(graph.getVertexByName("B"), graph.getVertexByName("D")));
		graph.addEdge(new Edge(graph.getVertexByName("C"), graph.getVertexByName("D")));
		
		try {
			graph.saveToFile("testFile.txt");
			System.out.println("Success");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
