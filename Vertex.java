/*

 Group Members:


 Algorithms and Data Structures
 Section CH 
 Project 3 - Dijkstra's Algorithm 




 */
package dijkstra;

public class Vertex {

    private String label;
    private Vertex next;

    public Vertex() {
    }

    public Vertex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Vertex getNext() {
        return next;
    }

    public void setNext(Vertex next) {
        this.next = next;
    }

    public Vertex(String label, Vertex next) {
        this.label = label;
        this.next = next;
    }
}
