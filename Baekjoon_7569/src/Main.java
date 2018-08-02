import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] a = {0,0,1,-1};
    static int[] b = {-1,1,0,0};
    static int[] c = {1,-1};

    public static void BFS(int h,int n, int m ,Queue<Element> queue, int[][][] map){
        Queue<Element> q = new LinkedList<>();
        boolean[][][] visited = new boolean[h][n][m];
        int depth=0;

        while(!queue.isEmpty()){
            Element e = queue.poll();
            if(visited[e.z][e.y][e.x] == true) continue;
            q.add(e);
            while(!q.isEmpty()){
                Element ee = q.poll();
                for(int i = 0; i < 4; i++){
                    int toVisitX = ee.x + a[i];
                    int toVisitY = ee.y + b[i];
                    int toVisitZ = ee.z;
                    if(toVisitX >= 0 && toVisitX < m && toVisitY >= 0 && toVisitY <n){
                        if(visited[toVisitZ][toVisitY][toVisitX] == false && map[toVisitZ][toVisitY][toVisitX] == 0 ){
                            depth = ee.depth+1;
                            visited[toVisitZ][toVisitY][toVisitX] = true;
                            map[toVisitZ][toVisitY][toVisitX] = 1;
                            q.add(new Element(toVisitX, toVisitY,toVisitZ,depth));
                        }
                    }
                }

                for(int i = 0 ; i < 2; i++){
                    int toVisitX = ee.x;
                    int toVisitY = ee.y;
                    int toVisitZ = ee.z + c[i];
                    if(toVisitZ >= 0 && toVisitZ < h){
                        if(visited[toVisitZ][toVisitY][toVisitX] == false && map[toVisitZ][toVisitY][toVisitX] == 0 ){
                            depth = ee.depth+1;
                            visited[toVisitZ][toVisitY][toVisitX] = true;
                            map[toVisitZ][toVisitY][toVisitX] = 1;
                            q.add(new Element(toVisitX, toVisitY,toVisitZ,depth));
                        }
                    }
                }
            }
        }
        boolean hasZero = false;

        for(int k = 0; k < h; k++){
            for(int i = 0; i < n; i ++ ){
                for(int j = 0; j < m; j++){
                 if(map[k][i][j] == 0) hasZero = true;
                }
            }
        }
        if(hasZero){ System.out.println(-1);}
        else {System.out.println(depth);}
    }


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n,m,h;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        int[][][] map = new int[h][n][m];
        Queue<Element> queue = new LinkedList<>();

        for(int k =0 ; k < h; k++){
            for(int i = 0; i < n; i ++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j< m ; j++){
                    map[k][i][j] = Integer.parseInt(st.nextToken());
                    if(map[k][i][j] == 1) queue.add(new Element(j,i,k,0));
                }
            }
        }

        BFS(h,n,m,queue,map);


    }

    static class Element{
        int depth;
        int x;
        int y;
        int z;
        Element(int x, int y, int z,int depth){
            this.x = x;
            this.y =y;
            this.z = z;
            this.depth =depth;
        }
    }
}
