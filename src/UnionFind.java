import edu.princeton.cs.algs4.StdOut;

public class UnionFind {
    int id[];
    int large[];
    int size[]; //size of tree
    public UnionFind(int n){
        id = new int[n];
        large = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
            id[i] = i;
            large[i] = i;
            size[i] = 0;

        }
    }
    public void union(int p, int q){
        int rootP = root(p);
        int rootQ = root(q);
        int largestP = large[rootP];
        int largestQ = large[rootQ];
        if(rootP == rootQ) return;
        if(size[rootP] < size[rootQ]){
            id[rootP] = rootQ;
            size[rootP] += size[rootQ];
            if(largestP < largestQ){
                large[rootP] = largestQ;
            }else{
                large[rootQ] = largestP;
            }


        }else{
            id[rootQ] = rootP;
            size[rootQ] += size[rootP];
            if(largestQ < largestP){
                large[rootQ] = largestP;
            }else{
                large[rootP] = largestQ;
            }
        }
    }
    public int root(int val) {
        if (id[val] != val) {
            id[val] = id[id[val]];
            val = id[val];
        }
        return val;
    }
    public int find(int val){
        return large[val];
    }
    public boolean connected(int p, int q){
        return  root(p) == root(q);
    }
    public static void main(String ar[]){
        UnionFind uf = new UnionFind(5);
        uf.union(0,2);
        uf.union(0,4);
        StdOut.println(uf.find(0));
    }
}