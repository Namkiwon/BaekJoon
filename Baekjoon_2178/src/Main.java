
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int min;
    static int[][] map;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n,m;
        StringTokenizer st;
        Stack<Element> stack = new Stack<>();
        Queue<Element> queue = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        min = n*m;


        map = new int[n][m];


        for(int i = 0 ; i < n; i ++){
            String input = br.readLine();
            for(int j = 0; j < m; j ++){
                map[i][j] = Character.getNumericValue(input.charAt(j));
            }
        }
        int a[] = {0,-1,0,1}; // ---- 1
        int b[] = {1,0,-1,0}; // ---- 1

        boolean visited[][] = new boolean[n][m];
        int distance[][] = new int[n][m];
        distance[0][0] = 1;
        queue.add(new Element(0,0));

        while(!queue.isEmpty()){

            Element e = queue.poll();
            if(e.x == m-1 && e.y == n-1){
               break;
            }
            for(int i = 0; i < 4; i++){
                int toVisitX = e.x + a[i];
                int toVisitY = e.y + b[i];
                if(toVisitX >= 0 && toVisitX < m && toVisitY >=0 && toVisitY < n){
                    if(map[toVisitY][toVisitX] != 0 && visited[toVisitY][toVisitX] != true){
                        visited[toVisitY][toVisitX] = true; // ---- 2
                        queue.add(new Element(toVisitX, toVisitY)); // ---- 3
                        distance[toVisitY][toVisitX] = distance[e.y][e.x] + 1; // ---- 4
                    }
                }
            }
        }

        System.out.println(distance[n-1][m-1]);
    }

    static class Element{
        int x;
        int y;
        Element(int x, int y){
            this.x = x ;
            this.y = y;
        }
    }

}
