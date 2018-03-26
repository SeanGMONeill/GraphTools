import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Graph {

	List<Vertex> vertices = new ArrayList<Vertex>();
	List<Edge> edges = new ArrayList<Edge>();
	
	
	
	public void addVertex(Vertex vertex) {
		vertices.add(vertex);
	}
	
	public void addEdge(Edge edge) {
		edges.add(edge);
	}
	
	public List<Edge> getEdges(){
		return edges;
	}
	
	public List<Vertex> getVertices(){
		return vertices;
	}
	
	public void saveToFile(String fileName) throws IOException {
		
		String vcsOut = "";
		
		if(vertices.size() >= 1) {
			vcsOut = vertices.get(0).getName();
			
			for(int i=1; i<vertices.size(); i++) {
				vcsOut += "," + vertices.get(i).getName();
			}
			
		}
		
		vcsOut += "\n\n";

		
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		
		writer.write(vcsOut);
		
		for(Edge edge : edges) {
			writer.write(edge.asString() + "\n");
		}
		

		writer.close();
		
	}
	
	
	/*
	 * @To-do
	 * Fairly unsafe file reading for now, largely assumes that the file is all good
	 */
	public void loadFromFile(String fileName) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		
		String vertexLine = reader.readLine();
		vertices = new ArrayList<Vertex>();
		for(String vertex : vertexLine.split(",")) {
			vertices.add(new Vertex(vertex, this));
		}
		
		
		String edgeLine;
		Edge edge;
		while((edgeLine = reader.readLine())!= null) {
			if((edge = Edge.stringToEdge(edgeLine, this)) != null) {
				edges.add(edge);
			}
		}
		
		
		reader.close();
		
	}
	
	public Vertex getVertexByName(String name) {
		for(Vertex vertex : vertices) {
			if(vertex.getName().equals(name)) {
				return vertex;
			}
		}
		
		return null;
	}

	
	public Boolean isConnected() {
		
		for(Vertex vertex : vertices) {
			if(vertex.getDegree() == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	
}
