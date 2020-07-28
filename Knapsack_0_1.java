package Programmes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Knapsack_0_1 {
    public static void main(String[] args){
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        try{
            String[] Weights=input.readLine().split(" ");
            String[] Values=input.readLine().split(" ");
            String Target=input.readLine();
            int w=Integer.parseInt(Target);
            int n=Values.length;
            int[] weights=new int[n];
            int[] values=new int[n];
            for(int i=0;i<n;i++){
                weights[i]=Integer.parseInt(Weights[i]);
                values[i]=Integer.parseInt(Values[i]);
            }

            int[][] maxValue=new int[n+1][w+1];
            maxValue=maxPossibleValue(w,n,weights,values);
            System.out.println(maxValue[n][w]);
            ArrayList<Integer> whatVal=new ArrayList<Integer>();
            whatVal=valuesList(maxValue,w,n,weights);
            System.out.println("The weights used will be");
            System.out.println(whatVal);
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
    public static  int[][] maxPossibleValue(int w,int n,int[] weights,int[] values){
        int[][] dp=new int[n+1][w+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<w+1;j++){
                if(weights[i-1]<=j)
                dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weights[i-1]]+values[i-1]);
            }
        }return dp;
    }
    public static ArrayList<Integer>  valuesList(int[][] dp,int w,int n,int[] weights){
        int i=n;
        int j=w;
        ArrayList<Integer> ans=new ArrayList<>();
        while(i>0&&j>0){
            if(dp[i][j]==dp[i-1][j]){
                i=i-1;
            }else{
                ans.add(weights[i-1]);
                w=w-weights[i-1];
                j=w;
                i=i-1;
            }
        }
        return  ans;
    }
}
/*Input
1 3 4 5
1 4 5 7
7
 */
/*
Output
9
The weights used will be
[4, 3]

 */