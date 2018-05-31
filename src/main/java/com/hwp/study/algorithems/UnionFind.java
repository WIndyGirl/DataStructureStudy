package com.hwp.study.algorithems;

public class UnionFind {
    int[][] points;
    public UnionFind(int N){
        points = new int[N][N];
    }

    public void union(int p, int q){
        points[p][q] = 1;
        points[q][p] = 1;
    }

    public int find(int q){
        return 0;
    }

    public boolean connected(int p, int q){
         return points[p][q] == 1;
    }

    public int count(){
        return 0;
    }
}
