package com.hwp.study.algorithems;

public class UnionFind {
    int[] parent;
    int[] rank;
    int count;
    public UnionFind(int N){
        if (N < 0){
            throw new IllegalArgumentException("N could not be lower than 0");
        }

        parent = new int[N];
        rank = new int[N];
        count = N;

        for(int i = 0; i < N; i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public boolean validation(int q){
        if(q < 0 || q > parent.length - 1){
            throw new IllegalArgumentException("");
        }

        return true;
    }

    public void union(int p, int q){
        if(connected(p, q)){
            return;
        }


    }

    public int find(int q){
         return 0;
    }

    public boolean connected(int p, int q){
         int pComId = find(p);
         int qComId = find(q);

         return pComId == qComId;
    }

    public int count(){
        return count;
    }
}
