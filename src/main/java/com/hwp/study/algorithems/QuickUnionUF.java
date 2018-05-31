package com.hwp.study.algorithems;

public class QuickUnionUF {
    private int[] id;
    private int count;

    public QuickUnionUF(int N){
        count = N;
        id = new int[N];

        for(int i = 0; i < id.length; i++){
            id[i] = i;
        }
    }

    public int count(){
        return count;
    }

    public void validation(int p){
        int n = id.length;

        if(p < 0 || p >= n){
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
        }
    }

    public boolean connected(int p, int q){
        validation(p);
        validation(q);

        int pComId = find(p);
        int qComId = find(q);

        return pComId == qComId;
    }

    public int find(int p){
        validation(p);

        while(p != id[p]){
            p = id[p];
        }

        return p;
    }

    public void union(int p, int q){
        validation(p);
        validation(q);

        int pComId = find(p);
        int qComId = find(q);

        if(pComId == qComId){
            return;
        }

        id[pComId] = qComId;

        count--;
    }
}
