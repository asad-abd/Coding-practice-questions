//best explanation: https://leetcode.com/problems/minimum-score-triangulation-of-polygon/discuss/286753/C%2B%2B-with-picture
import java.util.*;
class _1039_MinimumScoreTriangulationOfPolygon {
    //Using array: 1ms (100%)
    int[][] polygonScore;
    public int minScore(int[] A, int i, int j) {
        if(j==i+1){// no polygon possible
            polygonScore[i][j]=0;
            return 0;
        }
        if(j==i+2){
            polygonScore[i][j]=A[i]*A[i+1]*A[i+2];
            return A[i]*A[i+1]*A[i+2];
        }
        if(polygonScore[i][j]!=-1)
            return polygonScore[i][j];
        
        int min=Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            int tempSum=0;
            if(polygonScore[i][k]!=-1)
                tempSum+=polygonScore[i][k];
            else{
                polygonScore[i][k]=minScore(A,i,k);
                tempSum+=polygonScore[i][k];
            }
            if(polygonScore[k][j]!=-1)
                tempSum+=polygonScore[k][j];
            else{
                polygonScore[k][j]=minScore(A,k,j);
                tempSum+=polygonScore[k][j];
            }
            min=Math.min(min,A[i]*A[j]*A[k] + tempSum);
        }
        polygonScore[i][j]=min;
        return min;
    }
    public int minScoreTriangulation(int[] A) {
        polygonScore=new int[A.length][A.length];
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A.length;j++)
                polygonScore[i][j]=-1;// no score assigned yet
        }
        return minScore(A,0,A.length-1);
    }
//--------------------------------------------------------------
    //Using HashMap: 70ms (5%)
    HashMap <String, Integer> polygonScore=new HashMap<>();
    public int minScore(int[] A, int i, int j) {
        if(j==i+1){// no polygon possible
            polygonScore.put((i+","+j),0);
            return 0;
        }
        if(j==i+2){
            polygonScore.put((i+","+j),A[i]*A[i+1]*A[i+2]);
            return A[i]*A[i+1]*A[i+2];
        }
        if(polygonScore.containsKey(i+","+j))
            return polygonScore.get(i+","+j);
        
        int min=Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            int tempSum=0;
            if(polygonScore.containsKey(i+","+k))
                tempSum+=polygonScore.get((i+","+k));
            else{
                polygonScore.put((i+","+k),minScore(A,i,k));
                tempSum+=polygonScore.get((i+","+k));
            }
            if(polygonScore.containsKey(k+","+j))
                tempSum+=polygonScore.get((k+","+j));
            else{
                polygonScore.put((k+","+j),minScore(A,k,j));
                tempSum+=polygonScore.get((k+","+j));
            }
            min=Math.min(min,A[i]*A[j]*A[k] + tempSum);
        }
        polygonScore.put((i+","+j),min);
        return min;
    }
    public int minScoreTriangulation(int[] A) {
        return minScore(A,0,A.length-1);
    }
}
