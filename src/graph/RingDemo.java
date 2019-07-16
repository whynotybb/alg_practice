package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RingDemo {
    public static void main(String[] args) {
        Graph graph=new Graph();
        graph.addVertex(0,101);
        graph.addVertex(1,102);
        graph.addVertex(2,103);
        graph.addVertex(3,104);
        graph.addVertex(4,105);
        graph.addEdge(0,1,2);
        graph.addEdge(1,1,3);
        graph.addEdge(2,2,3);
        graph.addEdge(3,2,4);
        graph.addEdge(4,0,1);
        RingDemo ringDemo=new RingDemo();
        List<Integer> ring=new ArrayList<>();
        System.out.println("图中是否有环？");
        System.out.println(ringDemo.getRing(graph,ring));
        System.out.println("环中元素：");
        for (Integer r:ring){
            System.out.print(r+" ");
        }
    }

    /**
     * 判断图中是否有环有环则输出环包含的顶点
     * 主要的思路还是基于dfs
     * 用visit[]记录顶点的访问状态：//0 ：未访问 1：正在访问 2：已访问
     * 用parent[]记录顶点的访问次序，为了发现环之后能够回溯，找到环中的元素
     */
    private boolean getRing(Graph graph,List<Integer> ring){
        Stack<Integer> stack=new Stack<>();
        List<Vertex> vertexList= graph.vertexList;
        int[][] adj= graph.adj;
        int SIZE= vertexList.size();
        int[] visit=new int[SIZE];
        int[] parent=new int[SIZE];
        for (int i=0;i<SIZE;i++){
            parent[i]=-1;
        }
        visit[0]=1;
        stack.add(0);
        System.out.print(0+" ");
        while (!stack.isEmpty()){
            //获取下一个未访问点
            int p=stack.peek();
            int v=-1;
            for (int i=0;i<SIZE;i++){
                if (adj[p][i]==1&&visit[i]==1&&parent[p]!=i){
                    //回溯到点i停止:将visit[i]为1的顶点加入ring
                    int v2=parent[p];
                    ring.add(i);
                    ring.add(p);
                    while (v2!=-1&&visit[v2]==1&&v2!=i){
                        ring.add(v2);
                        v2=parent[v2];
                    }
                    return true;
                }else if (adj[p][i]==1&&visit[i]==0){
                    v=i;
                    break;
                }
            }
            if (v==-1){
                int v1= stack.pop();
                visit[v1]=2;
            }else {
                stack.add(v);
                visit[v]=1;
                parent[v]=p;
                System.out.print(v+" ");
            }
        }
        return false;
    }
}
