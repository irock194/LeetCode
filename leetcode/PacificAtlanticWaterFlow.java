package leetcode;

import java.util.*;

//https://leetcode.com/problems/pacific-atlantic-water-flow/
public class PacificAtlanticWaterFlow {

	//semi-brute force DFS O(n^2)
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] reachedPacificOcean = new boolean[m][n];
        boolean[][] reachedAtlanticOcean = new boolean[m][n];

        for(int i = 0; i < m; i++){
            reachedPacificOcean[i][0] = true;
        }
        for(int i = 0; i < n; i++){
            reachedPacificOcean[0][i] = true;
        }
        for(int i = 0; i < m; i++){
            reachedAtlanticOcean[i][n - 1] = true;
        }
        for(int i = 0; i < n; i++){
            reachedAtlanticOcean[m - 1][i] = true;
        }
        
        boolean[][] checked;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                checked = new boolean[m][n];
                reachedPacificOcean[i][j] = tileReachedPacific(heights, reachedPacificOcean, i, j, Integer.MAX_VALUE, checked);
                checked = new boolean[m][n];
                reachedAtlanticOcean[i][j] = tileReachedAtlantic(heights, reachedAtlanticOcean, i, j, Integer.MAX_VALUE, checked);
            }
        }

        ArrayList<List<Integer>> answer = new ArrayList<List<Integer>>();
        ArrayList<Integer> toAdd;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(reachedPacificOcean[i][j] && reachedAtlanticOcean[i][j]){
                    toAdd = new ArrayList<Integer>();
                    toAdd.add(i);
                    toAdd.add(j);
                    answer.add(toAdd);
                }
            }
        }
        
        return answer;
    }
    
    boolean tileReachedPacific(int[][] heights, boolean[][] reachedPacificOcean, int m, int n, int previousValue, boolean[][] checked){
        if(m >= 0 && n >= 0 && m < heights.length && n < heights[0].length){
            if(checked[m][n] == true){
                return false;
            }

            if(previousValue >= heights[m][n]){
                checked[m][n] = true;
                if(reachedPacificOcean[m][n]){
                    return true;
                }
                if(tileReachedPacific(heights, reachedPacificOcean, m - 1, n, heights[m][n], checked) //top
                || tileReachedPacific(heights, reachedPacificOcean, m, n + 1, heights[m][n], checked) //right
                || tileReachedPacific(heights, reachedPacificOcean, m, n - 1, heights[m][n], checked) //left
                || tileReachedPacific(heights, reachedPacificOcean, m + 1, n, heights[m][n], checked)){ //down
                    return true;
                }
            }
            
            return false;
        }
        
        return false;
    }
    
    boolean tileReachedAtlantic(int[][] heights, boolean[][] reachedAtlanticOcean, int m, int n, int previousValue, boolean[][] checked){
        if(m >= 0 && n >= 0 && m < heights.length && n < heights[0].length){
            if(checked[m][n] == true){
                return false;
            }

            if(previousValue >= heights[m][n]){
                checked[m][n] = true;
                if(reachedAtlanticOcean[m][n]){
                    return true;
                }
                if(tileReachedAtlantic(heights, reachedAtlanticOcean, m - 1, n, heights[m][n], checked) //top
                || tileReachedAtlantic(heights, reachedAtlanticOcean, m, n + 1, heights[m][n], checked) //right
                || tileReachedAtlantic(heights, reachedAtlanticOcean, m, n - 1, heights[m][n], checked) //left
                || tileReachedAtlantic(heights, reachedAtlanticOcean, m + 1, n, heights[m][n], checked)){ //down
                    return true;
                }
            }
            
            return false;
        }
        
        return false;
    }
}
