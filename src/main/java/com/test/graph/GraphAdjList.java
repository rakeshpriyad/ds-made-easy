package com.test.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphAdjList {
    private int vertexCount;
    private LinkedList<Integer> adjList[];

    public GraphAdjList(int vertexCount) {
        this.vertexCount = vertexCount;
        adjList = new LinkedList[vertexCount];
        for (int i = 0; i <vertexCount ; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination){

        //add edge
        adjList[source].addFirst(destination);

        //add back edge ((for undirected)
        adjList[destination].addFirst(source);
    }

    // prints BFS traversal from a given source s
    void BFS(int s)
    {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[vertexCount];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);

        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s+" ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adjList[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
    // A function used by DFS
    void DFSUtil(int v,boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v+" ");

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adjList[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    void DFS(int v)
    {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[vertexCount];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }


    public void printGraph(){
        for (int i = 0; i <vertexCount ; i++) {
            if(adjList[i].size()>0) {
                System.out.print("Vertex " + i + " is connected to: ");
                for (int j = 0; j < adjList[i].size(); j++) {
                    System.out.print(adjList[i].get(j) + " ");
                }
                System.out.println();
            }
        }

    }

    public static void main(String[] args) {
        GraphAdjList graph = new GraphAdjList(5);
        graph.addEdge(0,1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.printGraph();

        GraphAdjList g = new GraphAdjList(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.BFS(2);
        GraphAdjList gg = new GraphAdjList(4);

        gg.addEdge(0, 1);
        gg.addEdge(0, 2);
        gg.addEdge(1, 2);
        gg.addEdge(2, 0);
        gg.addEdge(2, 3);
        gg.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

        gg.DFS(2);
    }
}
