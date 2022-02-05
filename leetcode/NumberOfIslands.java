package leetcode;

//https://leetcode.com/problems/number-of-islands/
public class NumberOfIslands {
	
	//cleaned up version O(n)
    public int numIslands(char[][] grid) {
        if(grid.length == 1 && grid[0].length == 1){
            return grid[0][0] == '1' ? 1 : 0;
        }
      
        int totalIslands = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    checkIsland(grid, i, j);
                    totalIslands++;
                }
            }
        }
        return totalIslands;
    }
    
    void checkIsland(char[][] grid, int m, int n){
        if(m >= 0 && m < grid.length && n >= 0 && n < grid[0].length){
            if(grid[m][n] == '0'){
                return;
            }
            grid[m][n] = '0';
            checkIsland(grid, m, n - 1); //top
            checkIsland(grid, m + 1, n); //right
            checkIsland(grid, m - 1, n); //left
            checkIsland(grid, m, n + 1); //bottem
        }
        return;
    }
	
	/****O(n)
    public int numIslands(char[][] grid) {
        if(grid.length == 1 && grid[0].length == 1){
            return grid[0][0] == '1' ? 1 : 0;
        }
        if(grid[0].length == 1){
            char previousValue = 0;
            int totalIslands = 0;
            for(int i = 0; i < grid.length; i++){
                if(i == 0){
                    previousValue = grid[i][0];
                    continue;
                }
                if(previousValue == '1' && grid[i][0] == '0'){
                    totalIslands++;
                }
                previousValue = grid[i][0];
            }
            if(previousValue == '1'){
                totalIslands++;
            }
            return totalIslands;
        }
        
        if(grid.length == 1){
            char previousValue = 0;
            int totalIslands = 0;
            for(int i = 0; i < grid[0].length; i++){
                if(i == 0){
                    previousValue = grid[0][i];
                    continue;
                }
                if(previousValue == '1' && grid[0][i] == '0'){
                    totalIslands++;
                }
                previousValue = grid[0][i];
            }
            if(previousValue == '1'){
                totalIslands++;
            }
            return totalIslands;
        }
        
        
        boolean[][] checked = new boolean[grid.length][grid[0].length];
        int totalIslands = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(checked[i][j] == false && grid[i][j] == '1'){
                    checkIsland(grid, checked, i, j);
                    totalIslands++;
                }
                else{
                    checked[i][j] = true;
                }
            }
        }
        return totalIslands;
    }
    
    void checkIsland(char[][] grid, boolean[][] checked, int m, int n){
        if(checked[m][n] == true){
            return;
        }

        checked[m][n] = true;
        if(grid[m][n] == '0'){
            return;
        }
        if(m == 0 && n == 0){
            checkIsland(grid, checked, m + 1, n); //right
            checkIsland(grid, checked, m, n + 1); //bottem
        }
        else if(m == 0 && n == grid[0].length - 1){
            checkIsland(grid, checked, m, n - 1); //top
            checkIsland(grid, checked, m + 1, n); //right
        }
        else if(m == grid.length - 1 && n == 0){
            checkIsland(grid, checked, m - 1, n); //left
            checkIsland(grid, checked, m, n + 1); //bottem
        }
        else if(m == grid.length - 1 && n == grid[0].length - 1){
            checkIsland(grid, checked, m, n - 1); //top
            checkIsland(grid, checked, m - 1, n); //left
        }
        else if(m == 0){
            checkIsland(grid, checked, m, n - 1); //top
            checkIsland(grid, checked, m + 1, n); //right
            checkIsland(grid, checked, m, n + 1); //bottem
        }
        else if(n == 0){
            checkIsland(grid, checked, m + 1, n); //right
            checkIsland(grid, checked, m - 1, n); //left
            checkIsland(grid, checked, m, n + 1); //bottem
        }
        else if(m == grid.length - 1){
            checkIsland(grid, checked, m, n - 1); //top
            checkIsland(grid, checked, m - 1, n); //left
            checkIsland(grid, checked, m, n + 1); //bottem
        }
        else if(n == grid[0].length - 1){
            checkIsland(grid, checked, m, n - 1); //top
            checkIsland(grid, checked, m + 1, n); //right
            checkIsland(grid, checked, m - 1, n); //left
        }
        else{
            checkIsland(grid, checked, m, n - 1); //top
            checkIsland(grid, checked, m + 1, n); //right
            checkIsland(grid, checked, m - 1, n); //left
            checkIsland(grid, checked, m, n + 1); //bottem
        }
        
        return;
    }
    **/
}
