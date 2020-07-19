package com.test.graph;

import java.util.LinkedList;

public class WeightedGraph {
    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        LinkedList<Edge> [] adjacencylist;

        Graph(int vertices) {
            this.vertices = vertices;
            adjacencylist = new LinkedList[vertices];
            //initialize adjacency lists for all the vertices
            for (int i = 0; i <vertices ; i++) {
                adjacencylist[i] = new LinkedList<Edge>();
            }
        }

        /*public void addEdge(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            adjacencylist[source].addFirst(edge); //for directed graph
        }*/
        public void addEdge(Edge edge) {
            adjacencylist[edge.source].addFirst(edge); //for directed graph
        }

        public void printGraph(){
            for (int i = 0; i <vertices ; i++) {
                LinkedList<Edge> list = adjacencylist[i];
                for (int j = 0; j <list.size() ; j++) {
                    System.out.println("vertex-" + i + " is connected to " +
                            list.get(j).destination + " with weight " +  list.get(j).weight);
                }
            }
        }
    }
    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        Edge edge014 = new Edge(0, 1, 4);
        Edge edge023 = new Edge(0, 2, 3);
        Edge edge132 = new Edge(1, 3, 2);
        Edge edge125 = new Edge(1, 2, 5);
        Edge edge237 = new Edge(2, 3, 7);
        Edge edge342 = new Edge(3, 4, 2);
        Edge edge404 = new Edge(4, 0, 4);
        Edge edge414 = new Edge(4, 1, 4);
        Edge edge456 = new Edge(4, 5, 6);

        graph.addEdge(edge014);
        graph.addEdge(edge023);
        graph.addEdge(edge132);
        graph.addEdge(edge125);
        graph.addEdge(edge237);
        graph.addEdge(edge342);
        graph.addEdge(edge404);
        graph.addEdge(edge414);
        graph.addEdge(edge456);
        graph.printGraph();
    }
}