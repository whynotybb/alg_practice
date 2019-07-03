package datastruct;

import java.util.*;

public class Graph {
    private static final int MAX_SIZE=20;
    private int[][] adj;
    private List<Vertex> vertexList;
    private List<Edge> edgeList;
    private int nVerts;
    public Graph(){
        adj=new int[MAX_SIZE][MAX_SIZE];
        vertexList=new ArrayList<>();
        edgeList=new ArrayList<>();
        nVerts=0;
    }
    public void addVertex(int id,int val){
        nVerts++;
        vertexList.add(new Vertex(id,val));
    }
    public void addEdge(int id,int from,int to){
        edgeList.add(new Edge(id,from,to));
        adj[from][to]=1;
        adj[to][from]=1;
    }
    public void dfs(int from){
        Stack<Integer> stack=new Stack<>();
        stack.add(from);
        vertexList.get(from).visited=true;
        System.out.print(vertexList.get(from).val+",");
        while (!stack.isEmpty()){
            int v1= getUnVisitedV(stack.peek());
            if (v1==-1){
                stack.pop();
            }else {
                stack.add(v1);
                vertexList.get(v1).visited=true;
                System.out.print(vertexList.get(v1).val+",");
            }
        }
        //reset
        for (Vertex vertex:vertexList)
            vertex.visited=false;
    }
    public int getUnVisitedV(int v){
        //找到第v行中为1的且未访问的顶点
        for (int i=0;i<nVerts;i++){
            if(adj[v][i]==1&&!vertexList.get(i).visited){
                return i;
            }
        }
        return -1;
    }
    public void bfs(int from){
        ArrayList<Integer> queue=new ArrayList<>();
        queue.add(from);
        vertexList.get(from).visited=true;
        System.out.print(vertexList.get(from).val+",");
        while (!queue.isEmpty()){
            int v1=queue.remove(0);
            int v2;
            while ((v2=getUnVisitedV(v1))!=-1){
                queue.add(v2);
                vertexList.get(v2).visited=true;
                System.out.print(vertexList.get(v2).val+",");
            }
        }
        //reset
        for (Vertex vertex:vertexList)
            vertex.visited=false;
    }

    public static void main(String[] args) {
        Graph graph=new Graph();
        graph.addVertex(0,8);
        graph.addVertex(1,6);
        graph.addVertex(2,10);
        graph.addVertex(3,5);
        graph.addVertex(4,7);
        graph.addVertex(5,9);
        graph.addVertex(6,11);

        graph.addEdge(0,1,0);
        graph.addEdge(1,0,2);
        graph.addEdge(2,1,2);
        graph.addEdge(3,1,3);
        graph.addEdge(4,1,4);
        graph.addEdge(5,2,5);
        graph.addEdge(6,2,6);
        System.out.println("dfs:");
        graph.dfs(0);
        System.out.println("bfs:");
        graph.bfs(0);
    }
}
