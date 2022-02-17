package leetcode;

//https://leetcode.com/problems/sort-the-matrix-diagonally/

public class SortMatrixDiagonally {
    public int[][] diagonalSort(int[][] mat) {
        int i = mat.length - 1;
        int j = mat[0].length - 1;
        while(i != -1){
            countSort(mat, i, 0);
            i--;
        }
        while(j != 0){
            countSort(mat, 0, j);
            j--;
        }
        
        return mat;
    }
    
    void countSort(int[][] mat, int i, int j){
        int[] dict = new int[101];
        int previousI = i;
        int previousJ = j;
        while(i < mat.length && j < mat[0].length){
            dict[mat[i][j]]++;
            i++;
            j++;
        }
        i = previousI;
        j = previousJ;
        for(int k = 1; k < 101; k++){
            while(dict[k] > 0){
                mat[i][j] = k;
                dict[k]--;
                i++;
                j++;
            }
        }
    }
}
