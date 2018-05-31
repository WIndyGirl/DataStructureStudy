package com.hwp.study.algorithems;

public class QuickFindUnion {
    private int[] id;
    private int count;

    public QuickFindUnion(int N){
        count = N;
        id = new int[N];

        for(int i = 0; i < id.length; i++){
            id[i] = i;
        }
    }

    public int find(int q){
        validation(q);
        return id[q];
    }

    public boolean connected(int q, int p){
        validation(q);
        validation(p);
        int pComId = find(p);
        int qComId = find(q);

        return pComId == qComId;
    }

    public int count(){
        return count;
    }

    public void union(int q, int p){
        validation(q);
        validation(p);

        int pComId = find(p);
        int qComId = find(q);

        // component identifier of q and p are equal, then they are already connected
        if (pComId == qComId){
            return;
        }

        for(int i = 0; i < id.length; i++){
            if(id[i] == pComId){
                id[i] = qComId;
            }
        }

        count--;
    }

    public void validation(int q){
        if (q < 0 || q >= id.length){
            throw new IllegalArgumentException("index " + q + " is not between 0 and " + (id.length - 1));
        }
    }
}
