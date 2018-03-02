package NO160;

public class xx {

    public static void main(String[] args){
        int n = 9;
        int m = 0;
        for (int i = 1; i < n; i++){
            for(int j = i * 2; j <= n; j++)
                m = m + 1;
        }

        System.out.println(m);
    }
}
