package com.test.graph;

public class GraphAdjacencyMatrix{

    private boolean adjMatrix[][];
    private int vertexCount;

   public GraphAdjacencyMatrix(int vertexCount) {
       this.vertexCount = vertexCount;
       this.adjMatrix = new boolean[vertexCount][vertexCount];

   }

   public void addEdge(int i, int j){
       if( i>= 0 && i< vertexCount && j>0 && j<vertexCount){
           this.adjMatrix[i][j] = true;
           this.adjMatrix[j][i] = true;
       }

   }

    public void removeEdge(int i, int j){
        if( i>= 0 && i< vertexCount && j>0 && j<vertexCount){
            this.adjMatrix[i][j] = false;
            this.adjMatrix[j][i] = false;
        }
    }

   public boolean isEdge(int i, int j){
       if( i>= 0 && i< vertexCount && j>0 && j<vertexCount){
           return this.adjMatrix[i][j];
       }
       return  false;
   }
}