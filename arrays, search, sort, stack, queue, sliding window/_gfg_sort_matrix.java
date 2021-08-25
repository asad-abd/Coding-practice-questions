class _gfg_sort_matrix {
    int[][] sortedMatrix(int n, int mat[][]) {
        int aux[]=new int[n*n];
        /*for(int i=0;i<n*n;i++)
            aux[i]=mat[i/n][i%n];
        Arrays.sort(aux);
        int [][]ans=new int[n][n];
        for(int i=0;i<n;i++)
            ans[i/n][i%n]=aux[i];
        */ //TLE for some reason though satisfies the complexity. MAYBE due to % time (IDK)?
        int k=0;
        int [][]ans=new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                aux[k++] = mat[i][j];
        Arrays.sort(aux);
        k=0;
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                ans[i][j] = aux[k++]; 
        return ans;
    }
}
