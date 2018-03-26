import java.util.ArrayList;
import java.util.List;

public class Vertex {
	
	String name;
	Graph graph;
	
	
	public Vertex(String name, Graph graph) {
		this.name = name;
		this.graph = graph;
	}
	
	public String getName() {
		return name;
	}
	
	public Graph getGraph() {
		return graph;
	}
	
	/*
	 * Get edges from graph that touch this vertex
	 */
	public List<Edge> getEdges(Graph graph){
		List<Edge> attachedEdges = new ArrayList<Edge>();
		for(Edge edge:graph.getEdges()) {
			if(edge.touchesVertex(this)) {
				attachedEdges.add(edge);
			}
		}
		return attachedEdges;
	}
	
	public Integer getDegree() {
		Integer degree = 0;
		
		for(Edge edge : graph.getEdges()) {
			if(edge.touchesVertex(this)) {
				degree++;
			}
		}
		
		
		return degree;
	}
	
}
