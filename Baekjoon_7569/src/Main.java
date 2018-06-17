import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] a = {0,0,1,-1};
    static int[] b = {-1,1,0,0};

    public static void BFS(int n, int m ,Queue<Element> queue, int[][] map){
        Queue<Element> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int count = 0;


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
                        if(visited[toVisitY][toVisitX] == false && map[toVisitY][toVisitX] == 0){
                            visited[toVisitY][toVisitX] = true;
                            q.add(new Element(toVisitX, toVisitY));
                        }
                    }
                }
            }
            count++;
        }

        System.out.println(count);
    }


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n,m,h;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        for(int k =0 ; k < h; k++){
            int[][] map = new int[n][m];
            Queue<Element> queue = new LinkedList<>();
            for(int i = 0; i < n; i ++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j< m ; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] == 1) queue.add(new Element(j,i));
                }
            }





        }

    }

    static class Element{
        int x;
        int y;
        Element(int x, int y){
            this.x = x;
            this.y =y;
        }
    }
}
