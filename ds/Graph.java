package ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
  private List<List<Integer>> adj;
  private final int numVertices;
  private final boolean isDirected;
  
  public Graph(int numberOfVertices, boolean isDirected) {
    this.adj= new ArrayList<List<Integer>>();
    this.numVertices = numberOfVertices;
    
    for(int i = 1; i <= numberOfVertices; i++) {
    	this.adj.add(new ArrayList<Integer>());
    }
    
    this.isDirected = isDirected;
  }

  public void addEdge(int val1, int val2) {	  
	  if (val1 >= 0 && val1 < this.numVertices
			  && val2 >= 0 && val2 < this.numVertices) {
		  
		  this.adj.get(val1).add(val2);
		  
		  if(isDirected) {
			  this.adj.get(val2).add(val1);
		  }
		  
	  } else {
		  throw new IllegalArgumentException("Invalid Edges");
	  }
  }
  
  public void printGraph() {
	  for(int i = 0; i < this.numVertices; i++) {
		  System.out.print(i + " --> ");
		  
		  for(int item : this.adj.get(i)) {
			  System.out.print(item + " ");
		  }
		  
		  System.out.println();
	  }
  }
  
  public static void main(String[] args) {
    Graph g = new Graph(6, false);    
    
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 4);
    g.addEdge(3, 4);
    g.addEdge(3, 5);
    g.addEdge(1, 5);    
    
    g.printGraph();
    
  }
}
