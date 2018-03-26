import java.util.ArrayList;
import java.util.List;

public class Euler {
	
	public static Boolean hasPath(Graph graph) {
		
		Integer oddDegreeVertices = 0;
		
		for(Vertex vertex : graph.getVertices()) {
			if((vertex.getDegree() % 2) != 0) {
				oddDegreeVertices++;
			}
		}
		
		if((oddDegreeVertices == 0 || oddDegreeVertices == 2) && graph.isConnected()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public static List<Edge> getPath(Graph graph){
		
		List<Edge> edges = graph.getEdges();
		List<Vertex> oddVcs = new ArrayList<Vertex>();
		Vertex start;
		
	//Confirmation that this graph has an Euler path/cycle
		if(!hasPath(graph) || edges.size() == 0) {
			return null; //There is no path, return null
		}
		
		
	//Select a starting vertex - an odd-degree vertex if path, the first vertex if cycle
		for(Vertex vertex : graph.getVertices()) {
			if((vertex.getDegree() % 2) != 0) {
				oddVcs.add(vertex);
			}
		}
		
		if(oddVcs.size() > 0) {
			start = oddVcs.get(0);
		}
		else {
			start = graph.getVertices().get(0);
		}
		
		
	//
		
		
		return null;
	}
	
	
	
}
