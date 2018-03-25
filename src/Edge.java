import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Edge {
	
	Vertex vertexA, vertexB;
	Double weight;
	
	
	public Edge(Vertex vertexA, Vertex vertexB, Double weight) {
		this.vertexA = vertexA;
		this.vertexB = vertexB;
		this.weight = weight;
	}
	
	public Edge(Vertex vertexA, Vertex vertexB) {
		this(vertexA, vertexB, 1.0);
	}
	
	
	
	public Vertex getVertexA() {
		return vertexA;
	}
	
	public Vertex getVertexB() {
		return vertexB;
	}

	public Double getWeight() {
		return weight;
	}
	
	
	public static Edge stringToEdge(String line, Graph graph) {
		Boolean valid = true;
		Scanner scanner = new Scanner(line);
		scanner.useDelimiter(",");
		
		List<String> lineTokens = new ArrayList<String>();
		
		for(int i = 0; i<3; i++) {
			if(scanner.hasNext()) {
				lineTokens.add(scanner.next());
			}
			else {
				valid = false;
			}
		}
		
		scanner.close();
		
		if(valid) {
			return new Edge(graph.getVertexByName(lineTokens.get(0)), graph.getVertexByName(lineTokens.get(1)), Double.parseDouble(lineTokens.get(2)));
		}
		else {
			return null;
		}
	}
	
	public String asString() {
		return this.getVertexA().getName() + "," + this.getVertexB().getName() + "," + this.getWeight();
	}
}
