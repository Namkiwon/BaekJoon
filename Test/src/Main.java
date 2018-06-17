import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {


    public static void a(int x){
        x++;
        System.out.println(x);
        a(x);

    }

    public static void main(String args[]){
        int x = 3;

        a(x);
        a(x);

    }
}
