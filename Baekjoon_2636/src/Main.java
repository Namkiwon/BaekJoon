import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int num;

    public static void DFS(int x, int y, int m , int n){

         map[n][m] = 2;
        if(m+1 < x  &&map[n][m+1] == 1) map[n][m+1] = 2;
        if(m-1 >= 0 && map[n][m-1] == 1) map[n][m-1] = 2;
        if(n-1 >= 0 && map[n-1][m] == 1) map[n-1][m] = 2;
        if(n+1 < y && map[n+1][m] == 1) map[n+1][m] = 2;



        if( m + 1 < x  &&map[n][m+1] == 0){DFS(x,y,m+1,n);} // 우로 한칸
        if(m -1 >= 0  && map[n][m-1] == 0){DFS(x,y,m-1,n);} // 좌로 한칸
        if(n - 1 >= 0 && map[n-1][m] == 0){DFS(x,y,m,n-1);} // 위로 한칸
        if(n + 1 < y   && map[n+1][m] == 0){DFS(x,y,m,n+1);} // 아래로 한칸
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int x,y;
        int time = 0;


        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        map = new int[y][x];

        for(int i = 0 ; i < y ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j < x; j ++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(check(x,y)){
            time ++;
            DFS(x,y,0,0);

//            for(int i = 0; i < y; i ++){
//                for(int j = 0; j < x; j++){
//                    System.out.print(map[i][j]);
//                }
//                System.out.println("");
//            }

        }
        System.out.println(time);
        System.out.println(num);

    }

    public static boolean check(int x,int y){
        boolean isZero = false;
        int cheeseNum = 0 ;
        for(int i = 0; i < y; i ++){
            for(int j = 0; j < x; j++){
                if(map[i][j] == 1){
                    isZero = true;
                    cheeseNum ++;
                }
                if(map[i][j] == 2) map[i][j] = 0;
            }
        }
        if(isZero == true) num = cheeseNum;
        return isZero;
    }

}
