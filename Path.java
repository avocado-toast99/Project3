/*

 Group Members:


 Algorithms and Data Structures
 Section CH 
 Project 3 - Dijkstra's Algorithm 




 */
package dijkstra;

public class Path {
     // declare
    private Vertex head;
    int neighbor;
    int length;
    int distance;

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    
    
    

    public void insert(String label) {
        head = insert(head, label);
    }

    private Vertex insert(Vertex head,String label) {

        // if the path is empty 
        // we insert in the beginning
        if (head == null ) {
            head = new Vertex(label, head);
            return head;
        } else {

            // create a help pointer to traverse down the list
            Vertex helpPtr = head;
            while (helpPtr.getNext() != null) {


                helpPtr = helpPtr.getNext();
            }
            // create new node and insert it at the end of the list
            Vertex newNode = new Vertex(label, helpPtr.getNext());
            helpPtr.setNext(newNode);
        }
        // Return head
        return head;
    }
    
    // this method prints the path
    public void PrintPath() {
        PrintPath(head);
    }

    private void PrintPath(Vertex head) {

        Vertex helpPtr = head;

        while (helpPtr != null) {
            // print the data of the helpPtr
            System.out.print(helpPtr.getLabel() + " ");
            // Step one node over
            helpPtr = helpPtr.getNext();
        }
        System.out.println("");

    }
}
