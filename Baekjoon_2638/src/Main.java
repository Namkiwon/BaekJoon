import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int n, m;
    private static int map[][];


    public static void DFS(int x, int y){

            map[y][x] = -1;

        if(y>0 && map[y-1][x] > 0) map[y-1][x]++;
        if(y<n-1 && map[y+1][x] > 0 ) map[y+1][x]++;
        if(x>0 && map[y][x-1] >0) map[y][x-1]++;
        if(x<m-1 && map[y][x+1] > 0) map[y][x+1]++;

        if(y>0 && map[y-1][x] == 0) DFS(x,y-1); //위로 갈 수 있으면 위로 이동
        if(y<n-1 && map[y+1][x] == 0 )DFS(x,y+1); //아래로로 갈 수 있으면 위로 이동
        if(x>0 && map[y][x-1] == 0) DFS(x-1,y); //좌로 갈 수 있으면 위로 이동
        if(x<m-1 && map[y][x+1] == 0)DFS(x+1,y); //우로 갈 수 있으면 위로 이동
    }



    public static void main(String[] args) {
//        int i, j;
        int c = 0;
        int count= 0;
        BufferedReader br  = null;

        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            String input[] = br.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);
        }catch(Exception e){
            e.getMessage();
        }

        map = new int[n][m];

        for(int  i = 0; i < n; i++){
            try {
                String row[] = br.readLine().split(" ");
                for(int j = 0 ; j < m; j++){
                    map[i][j] = Integer.parseInt(row[j]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        while(true) {
            c = 0;
            DFS(0, 0);
            count++;
            for (int k = 0; k < n; k++) {
                for (int u = 0; u < m; u++) {
                    if (map[k][u] == -1 || map[k][u] > 2){ map[k][u] = 0;
                    c++;}
                    if(map[k][u] == 2 ) map[k][u] = 1;
//                    System.out.print(map[k][u]);
                }
//                System.out.println("");
            }
            if(c == n*m ) break;
        }
        System.out.println(count);
    }
}
