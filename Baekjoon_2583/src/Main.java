import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] a = {0,0,1,-1};
    static int[] b = {-1,1,0,0};

    public static void BFS(int n, int m ,Queue<Element> queue, int[][] map){
        Queue<Element> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        ArrayList<Integer> w = new ArrayList<>();
        int count = 0;
        int cnt = 0;


        while(!queue.isEmpty()){
            Element e = queue.poll();
            if(visited[e.y][e.x] == true) continue;
            q.add(e);
            while(!q.isEmpty()){
                Element ee = q.poll();
                for(int i = 0; i < 4; i++){
                    int toVisitX = ee.x + a[i];
                    int toVisitY = ee.y + b[i];
                    if(toVisitX >= 0 && toVisitX < m && toVisitY >= 0 && toVisitY <n){
                        if(visited[toVisitY][toVisitX] == false && map[toVisitY][toVisitX] == 1){
                            visited[toVisitY][toVisitX] = true;
                            q.add(new Element(toVisitX, toVisitY));
                            cnt++;
                        }
                    }
                }
            }
            count++;
            if(cnt == 0 )w.add(1);
            else{w.add(cnt);}
            cnt = 0;
        }
        Collections.sort(w);

        System.out.println(count);
        for(int i = 0; i < w.size();i++){
            System.out.print(w.get(i));
            System.out.print(" ");
        }

    }


    public static void main(String args[]) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n,m,k;
        int [][] map;
        Queue<Element> queue = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i = 0 ; i < n ; i++){
            Arrays.fill(map[i], 1);
        }

        for(int u = 0; u < k ; u ++){
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            for(int i = y1; i <  y2 ; i++ ){
                for(int j = x1; j < x2 ; j++){
                    map[i][j] = 0;
                }
            }
        }

        for(int i = 0; i <  n ; i++ ){
            for(int j = 0; j < m; j++ ){
               if(map[i][j] == 1) queue.add(new Element(j,i));
            }
        }

        BFS(n,m,queue,map);
    }

    static class Element{
        int x;
        int y;
        Element(int x, int y){
            this.x = x;
            this.y = y;
        }

    }
}
