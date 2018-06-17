import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static Character[][] map;
    static  int r,c;
    static int max = 1;
    static int[] a = {0,0,1,-1};
    static int[] b = {-1,1,0,0};
    static ArrayList<Boolean> W;
    static boolean[][] visited;


    public static void DFS(int x, int y, int count){


        for(int i = 0 ; i < 4; i ++){
                int toVisitX = x + a[i];
                int toVisitY = y + b[i];
                if(toVisitX >= 0 && toVisitX < c && toVisitY >=0 && toVisitY < r) {
                    if (W.get((int) map[toVisitY][toVisitX] - 65) == false && visited[toVisitY][toVisitX] == false) {
                        W.set((int) map[toVisitY][toVisitX] - 65, true);
                        visited[toVisitY][toVisitX] = true;
                        DFS(toVisitX, toVisitY, count + 1);
                        visited[toVisitY][toVisitX] = false;
                        W.set((int) map[toVisitY][toVisitX] - 65, false);
                    }
                }

        }
        if(max < count) max = count;

    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        W = new ArrayList<>();
        for(int i = 0 ; i < 26; i++){
            W.add(false);
        }

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        visited = new boolean[r][c];
        visited[0][0] = true;
         map = new Character[r][c];

        for(int i = 0; i < r ; i++){
            String input = br.readLine();
            for(int j = 0; j< c; j++){
                map[i][j] = input.charAt(j);
            }
        }

        W.set((int)map[0][0] - 65, true);
        DFS(0,0,1);
        System.out.println(max);
    }

}
