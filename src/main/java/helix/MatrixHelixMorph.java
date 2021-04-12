package helix;
import java.util.Scanner;

public class MatrixHelixMorph {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter m");
        int m = sc.nextInt();
        System.out.println("Enter n");
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for(int i = 0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (int) (Math.random() * 9);
            }
        }
        display(matrix);
        int [][] output = helix(matrix);
        display(output);
    }
    public static void display(int[][] m){
        int x = m.length;
        int y = m[0].length;
        for(int i = 0; i<x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static int[][] helix(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;
        int[][] result = new int[m][n];
        for(int k = 0; k<n; k++){
            result[0][k] = mat[0][k];
        }
        if(m==1 || m == 0)
            return result;
        int op = 1;int k = n-1;int q = 1;int r = m-1;int t = 0;int g = n-1;String place = "down";
        for(int i = 1 ; i<m ; i++){
            for(int j = 0; j<n; j++){
                result[op][k] = mat[i][j];
                if(place.equals("down")){
                    if(op<r)
                        op++;
                    else{
                        g--;
                        k--;
                        place = "left";
                    }
                }
                else if(place.equals("left")){
                    if(k>t)
                        k--;
                    else{
                        r--;
                        op--;
                        place = "up";
                    }
                }
                else if(place.equals("up")){
                    if(op>q)
                        op--;
                    else{
                        t++;
                        k++;
                        place = "right";
                    }
                }
                else{
                    if(k<g)
                        k++;
                    else{
                        q++;
                        op++;
                        place = "down";
                    }
                }
            }
        }
        return result;
    }
}
