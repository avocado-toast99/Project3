/*
 Group Members:
 Algorithms and Data Structures
 Section CH 
 Project 3 - Dijkstra's Algorithm 
 */
package dijkstra;

public class Vertex {

    private char label;
    private Vertex next;

    public Vertex() {
    }

    public Vertex(char label) {
        this.label = label;
    }

    public char getLabel() {
        return label;
    }

    public void setLabel(char label) {
        this.label = label;
    }

    public Vertex getNext() {
        return next;
    }

    public void setNext(Vertex next) {
        this.next = next;
    }

    public Vertex(char label, Vertex next) {
        this.label = label;
        this.next = next;
    }
}
