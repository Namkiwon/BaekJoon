import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int n;
    private static int min;
    private static int map[][] = {
            {0,0,0,0,0},
            {1,1,1,1,0},
            {0,0,0,0,0},
            {0,1,0,1,1},
            {0,0,0,0,0}};


    public static void DFS(int x, int y, int l){
        if(x == n-1 && y == n-1){
            if(min > l) min = l;
            System.out.println(l);
        }

        map[y][x] = 1;

        if(y>0 && map[y-1][x] != 1) DFS(x,y-1,l+1); //위로 갈 수 있으면 위로 이동
        if(y<n-1 && map[y+1][x] != 1)DFS(x,y+1,l+1); //아래로로 갈 수 있으면 위로 이동
        if(x>0 && map[y][x-1] != 1) DFS(x-1,y,l+1); //좌로 갈 수 있으면 위로 이동
        if(x<n-1 && map[y][x+1] != 1)DFS(x+1,y,l+1); //우로 갈 수 있으면 위로 이동


        map[y][x] = 0;
    }



    public static void main(String[] args) {
        int i, j;
        BufferedReader br  = null;

        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();
            n = Integer.parseInt(input);
        }catch(Exception e){
            e.getMessage();
        }

        min = n*n;

        DFS(0,0,1);
        System.out.println("최단거리는 : "+ min);

    }
}
