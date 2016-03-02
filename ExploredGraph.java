git
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;
import java.util.function.Function;

/**
 * 
 */

/**
 * @author Anna Murray, UW NetID 1438929 and Jordan Freitas, UW NetID 1460037 
 * Extra Credit Options Implemented, if any:  (mention them here.)
 * 
 * Solution to Assignment 6 in CSE 373, Winter 2016
 * University of Washington.
 * 
 * Starter code v1.1b. By Steve Tanimoto, with modifications
 * by Kuikui Liu and S.J. Liu.
 *
 * The main differences between this version (1.1a) and version 1.1 are:
 *  1. The use of ArrayList rather than array for the pegs variable in class Vertex.
 *  2. Type information provided for both Function prototypes in class Operator.
 *
 * This code requires Java version 8 or higher.
 *
 */

// Here is the main application class:
public class ExploredGraph {
    Set<Vertex> Ve; // collection of explored vertices
    Set<Edge> Ee;   // collection of explored edges
    ArrayList<Operator> op;
    public ExploredGraph() {
        Ve = new LinkedHashSet<Vertex>();
        Ee = new LinkedHashSet<Edge>();
    }

    public void initialize() {
        Ve.clear();
        Ee.clear();
    }
    
    public void initialize(v) {
        opList = new ArrayList<Operator>(); 
        ///---------------Note EC by making the variable 4--------
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) { 
				if (i != j) {
					Operator op = new Operator(i, j);
					opList.add(op);
				}
    }
    
    public int nvertices() {
        return Ve.size();
    } 
    
    public int nedges() {
        return Ee.size();
    }
    
    public void dfs(Vertex vi, Vertex vj) {
        Vertex start = vi;
        while(!vi.equals(vj)) || 
    
    
    }
    
    private void dfsHelper(Vertex vi, Vertex vj) {
        if vi.equals(vj) {
        // dont do anything
        }
        if (!vi.equals(vj)) {
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
                    Operator(i, j).getTransition
        }
        
    }   
    
    public void bfs(Vertex vi, Vertex vj) {
	Queue<Vertex> q = new LinkedList<Vertex>(); 
	//Vertex v0 = this.new Vertex("[[4,3,2,1],[],[]]"); 
	q.add(vi);
	while(vi!=vj){
	    while (!q.isEmpty()) { 
		Vertex mVertex = q.iterator().next();
		Ve.add(mVertex);
	    	q.remove(mVertex); // IF BUG don't remove mVertex, remove the iter.next
		for (int i = 0; i < opList.size(); i++) {
			Operator mOperator = opList.get(i);
			if (mOperator.getPrecondition()) {
	   			Vertex result = mOperator.getTransition();
		    		if (!Ve.contains(result)) { 
			    		q.add(result);
				    	Ee.add(new Edge(result, mVertex));
					Ee.add(new Edge(mVertex, result));
				}
	    		}
		}
	    }
		
        }
    }
    
    
    public ArrayList<Vertex> retrievePath(Vertex vi) {return null;} // Implement this.
    public ArrayList<Vertex> shortestPath(Vertex vi, Vertex vj) {return null;} // Implement this.
    public Set<Vertex> getVertices() {return Ve;} 
    public Set<Edge> getEdges() {return Ee;} 
    /**
     * @param args
     */
    public static void main(String[] args) {
        ExploredGraph eg = new ExploredGraph();
        // Test the vertex constructor: 
        Vertex v0 = eg.new Vertex("[[4,3,2,1],[],[]]");
        System.out.println(v0);
        // Add your own tests here.
        // The autograder code will be used to test your basic functionality later.

    }
    
    class Vertex {
        ArrayList<Stack<Integer>> pegs; // Each vertex will hold a Towers-of-Hanoi state.
        // There will be 3 pegs in the standard version, but more if you do extra credit option A5E1.
        
        // Constructor that takes a string such as "[[4,3,2,1],[],[]]":
        public Vertex(String vString) {
            String[] parts = vString.split("\\],\\[");
            pegs = new ArrayList<Stack<Integer>>(3);
            for (int i=0; i<3;i++) {
                pegs.add(new Stack<Integer>());
                try {
                    parts[i]=parts[i].replaceAll("\\[","");
                    parts[i]=parts[i].replaceAll("\\]","");
                    List<String> al = new ArrayList<String>(Arrays.asList(parts[i].split(",")));
                    System.out.println("ArrayList al is: "+al);
                    Iterator<String> it = al.iterator();
                    while (it.hasNext()) {
                        String item = it.next();
                                                if (!item.equals("")) {
                                                        System.out.println("item is: "+item);
                                                        pegs.get(i).push(Integer.parseInt(item));
                                                }
                    }
                }
                catch(NumberFormatException nfe) { nfe.printStackTrace(); }
            }       
        }
        public String toString() {
            String ans = "[";
            for (int i=0; i<3; i++) {
                ans += pegs.get(i).toString().replace(" ", "");
                if (i<2) { ans += ","; }
            }
            ans += "]";
            return ans;
        }
        
        public boolean equals(Vertex v2) {
            if (this.toString() == v2.toString()) {
                return true;       
            }
            return false;    
        }   
    }
    
    class Edge {
        public Vertex vi;
        public Vertex vj;
        
        public Edge(Vertex vi, Vertex vj) {
            this.vi = vi;
            this.vj = vj;
        }
        
        public Vertex getEndpoint1() {
            return this.vi;
        }
        
        public Vertex getEndpoint2() {
            return this.vj;
        }
        
        public String toString() {
            return "Edge from " + vi.toString() + " to " + vj.toString();
        }
        
        
    }
    
    class Operator {
        private int i, j;

        public Operator(int i, int j) {
            this.i = i;
            this.j = j;
        }
        //Tests the validitiy of the move of a ring from peg i to j
        public boolean getPrecondition(Vertex vertex) {
            int ring1 = -1;
            if (!vertex.pegs.get(i).isEmpty()) {
                ring1 = vertex.pegs.get(i).peek();
            }
            int ring2 = -1;
            if (!vertex.pegs.get(j).isEmpty()) {
                ring2 = vertex.pegs.get(j).peek();
            }
            //Checks first to see if the first stack is empty otherwise compares the peeked values
            if (ring1 = -1 || (ring2 != -1 && ring1 > ring2)) {
                return false;
            }
            return true;                
        }

        //Moves the ring from peg i to j, dependent on passing the precondition, returning the new vertex
        public Vertex getTransition(Vertex vertex) {
            if(getPrecondition(vertex)){
                vertex.pegs.get(j).push(vertex.pegs.get(i).pop());            
            }
            return vertex;
            
        }
        
        //Returns a string describing the change of rings on the pegs
        public String toString() {
            return "Move from peg " + i + " to " + j; 
        }
    }

}
