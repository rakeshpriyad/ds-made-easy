package com.test.graph;

public class GraphAdjacencyMatrix{

    private int adjMatrix[][];
    private int vertexCount;

   public GraphAdjacencyMatrix(int vertexCount) {
       this.vertexCount = vertexCount;
       this.adjMatrix = new int[vertexCount][vertexCount];

   }

   public void addEdge(int source, int destination){
       if( source>= 0 && source< vertexCount && destination>0 && destination<vertexCount){
           this.adjMatrix[source][destination] = 1;
           this.adjMatrix[destination][source] = 1;
       }

   }

    public void removeEdge(int i, int j){
        if( i>= 0 && i< vertexCount && j>0 && j<vertexCount){
            this.adjMatrix[i][j] = 0;
            this.adjMatrix[j][i] = 0;
        }
    }

   public int isEdge(int i, int j){
       if( i>= 0 && i< vertexCount && j>0 && j<vertexCount){
           return this.adjMatrix[i][j];
       }
       return  0;
   }
    public void printGraph() {
        System.out.println("Graph: (Adjacency Matrix)");
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j <vertexCount ; j++) {
                System.out.print(this.adjMatrix[i][j]+ " ");
            }
            System.out.println();
        }
        for (int i = 0; i < vertexCount; i++) {
            System.out.print("Vertex " + i + " is connected to:");
            for (int j = 0; j <vertexCount ; j++) {
                if(this.adjMatrix[i][j]==1){
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphAdjacencyMatrix graph = new GraphAdjacencyMatrix(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.printGraph();
    }
}