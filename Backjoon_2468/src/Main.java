import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int n;

    static int BFS(Queue<Element> q , int rain){
        Queue<Element> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        int[] x = { 0, 0, 1, -1};
        int[] y = { -1, 1, 0, 0};
        int count = 0;



//        for (int i = 0 ; i < n ; i ++){
//            for(int j = 0 ; j < n ; j++){
//                System.out.print(visited[i][j]);
//            }
//            System.out.println("");
//        }


        while (!q.isEmpty()) {
            Element e = q.poll();
            queue.add(e);
            if(visited[e.y][e.x] == true){
                continue;
            }

            while(!queue.isEmpty()) {
                Element a = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int toVisitX = a.x + x[i];
                    int toVisitY = a.y + y[i];
                    if (toVisitX >= 0 && toVisitX < n && toVisitY >= 0 && toVisitY < n) {
                        if(map[toVisitY][toVisitX] - rain > 0  && visited[toVisitY][toVisitX] != true){
                            visited[toVisitY][toVisitX] = true; // ---- 2
                            queue.add(new Element(toVisitX, toVisitY)); // ---- 3
                        }
                    }
                }
            }
            count ++;
        }




        return count;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Queue<Element> queue = new LinkedList<>();
        n = Integer.parseInt(br.readLine());
        int maxRain = 0;
        int maxSafe = 1;
        map = new int[n][n];
        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j <n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(maxRain < map[i][j]) maxRain = map[i][j];
                if(map[i][j] == 1) queue.add(new Element(j,i));
            }
        }

        for (int i = 1 ; i < maxRain; i ++){
            queue.clear();
            for(int a = 0 ; a < n ; a ++ ){
                for(int b= 0; b < n; b++){
                    if(map[a][b] - i  > 0 ) queue.add(new Element(b,a));
                }
            }
            int cnt = BFS(queue, i);
//        System.out.println(cnt);
            if(maxSafe < cnt) maxSafe = cnt;
        }

        System.out.println(maxSafe);

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
