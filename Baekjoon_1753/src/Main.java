//import java.io.*;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;
//
///**
// * BOJ#1753 최단경로
// * https://www.acmicpc.net/problem/1753
// */
//
//public class Main {
//
//    static final int INF = 5000000;
//
//    public static void main(String[] args) throws IOException {
//
//        int V; // 정점의 개수 <= 20,000
//        int E; // 간선의 개수 <= 300,000
//        ArrayList<ArrayList<Integer>> W = new ArrayList<>();
//        int[] dist;
//        int startNode;
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        V = Integer.parseInt(st.nextToken());
//        E = Integer.parseInt(st.nextToken());
//
//        dist = new int[V + 1];
//
//        for (int i = 0; i < V + 1; i++) {
//            Arrays.fill(dist, INF);
//            W.add(new ArrayList<>());
//        }
//
//        startNode = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i < E; i++) {
//
//            st = new StringTokenizer(br.readLine());
//
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//            int w = Integer.parseInt(st.nextToken());
//
//            W.get(a).add(b * 11 + w);
//        }
//
//        dijkstra(startNode, V, W, dist);
//
//        for (int i = 1; i < V + 1; i++) {
//
//            bw.write(dist[i] < INF ? dist[i] + "\n" : "INF\n");
//        }
//
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//
//    static void dijkstra(int src, int V, ArrayList<ArrayList<Integer>> W, int[] dist) {
//
//        PriorityQueue<Element> pq = new PriorityQueue<>();
//
//        dist[src] = 0;
//
//        pq.add(new Element(src, dist[src]));
//
//        while (!pq.isEmpty()) {
//
//            int cost = pq.peek().dist;
//            int here = pq.peek().node;
//
//            pq.poll();
//
//            if (dist[here] < cost) {
//
//                continue;
//            }
//
//            for (int x : W.get(here)) {
//
//                int adjNode = x / 11;
//                int weight = x % 11;
//
//                if (dist[adjNode] > dist[here] + weight) {
//
//                    dist[adjNode] = dist[here] + weight;
//                    pq.add(new Element(adjNode, dist[adjNode]));
//                }
//            }
//        }
//    }
//}
//
//class Element implements Comparable<Element> {
//
//    int node;
//    int dist;
//
//    Element(int node, int dist) {
//
//        this.node = node;
//        this.dist = dist;
//    }
//
//    @Override
//    public int compareTo(Element o) {
//
//        return this.dist < o.dist ? -1 : 1;
//    }
//}


//import java.awt.*;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.HashMap;
//
//public class Main {
//    public static int V,E;
//    public static int startPoint;
//    public static int map[][];
//    public static int bufmin = 0;
//    public static int ll[];
//    public static HashMap<Integer,String> hm = new HashMap<>();
//
//
//    public static void DFS(int sp, int l){
//
//        if(hm.containsKey(sp)){
//            String value[] = hm.get(sp).split(",");
//            for(int i = 0 ; i < value.length; i ++){
//                String realValue[] = value[i].split(" ");
//                if(ll[Integer.parseInt(realValue[0])-1] >  l+ Integer.parseInt(realValue[1])) ll[Integer.parseInt(realValue[0])-1] =  l+ Integer.parseInt(realValue[1]);
//                DFS(Integer.parseInt(realValue[0]),l+Integer.parseInt(realValue[1]));
//            }
//        }
//
//    }
//
//    public static void main(String args[]){
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        try {
//            String inputVE[] = br.readLine().split(" ");
//            V = Integer.parseInt(inputVE[0]);
//            E = Integer.parseInt(inputVE[1]);
//            startPoint = Integer.parseInt(br.readLine());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        map = new int[E][3];
//
//        for(int i = 0 ; i< E ; i++){
//            try {
//                String input[] = br.readLine().split(" ");
//                if(hm.containsKey(Integer.parseInt(input[0]))){hm.put(Integer.parseInt(input[0]),hm.get(Integer.parseInt(input[0]))+","+input[1]+" "+input[2]);
//                }else{ hm.put(Integer.parseInt(input[0]),input[1]+" "+input[2]);}
////                for(int j = 0 ; j < 3; j++)
////                map[i][j] = Integer.parseInt(input[j]);
//                bufmin = bufmin + Integer.parseInt(input[2]);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
////        System.out.println(hm.get(1));
//
//        ll = new int[V];
//        Arrays.fill(ll, bufmin); // ll의 모든 요소를 value값으로 초기화
//
//        DFS(startPoint,0);
//        for(int i = 0; i < V; i++){
//            if(i == startPoint-1) System.out.println(0);
//            else if(ll[i] == bufmin) System.out.println("INF");
//            else {System.out.println(ll[i]);}
//        }
//    }
//}


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

    static final int INF = 5000000;

    public static void main(String args[]) throws IOException {
        int V, E;
        int K;
        int[] dist;
        ArrayList<ArrayList<Integer>> W = new ArrayList<>();
        int startNode;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());


        dist = new int[V + 1];

        for (int i = 0; i < V + 1; i++) {
            Arrays.fill(dist, INF);
            W.add(new ArrayList<>());
        }

        startNode = Integer.parseInt(br.readLine());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            W.get(a).add(b * 11 + w);
        }

        dijkstra(startNode, V, W, dist);

        for (int i = 1; i < V + 1; i++) {

            bw.write(dist[i] < INF ? dist[i] + "\n" : "INF\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dijkstra(int src, int V,ArrayList<ArrayList<Integer>> W, int[] dist) {
        PriorityQueue<Element> pq = new PriorityQueue<>();

        dist[src] =0;
        pq.add(new Element(src,dist[src]));

        while(!pq.isEmpty()){
            int cost = pq.peek().dist;
            int here = pq.peek().node;
            pq.poll();

            if(dist[here]< cost){
                continue;
            }

            for(int x : W.get(here)){
                int adjnode = x / 11;
                int weight = x % 11;
                if(dist[adjnode] > dist[here]+ weight){
                    dist[adjnode] = dist[here] + weight;
                    pq.add(new Element(adjnode, dist[adjnode]));
                }
            }
        }
    }


}

class Element implements Comparable<Element>{
    int node;
    int dist;


    Element(int node, int dist){
        this.node = node;
        this.dist = dist;
    }

    @Override
    public int compareTo (Element o){
        return this.dist < o.dist ? -1 : 1;
    }

}
