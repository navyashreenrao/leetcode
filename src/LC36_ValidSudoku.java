import java.util.HashSet;

public class LC36_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            if(!isValidRow(board, i)) {
                return false;
            }
        }
        for(int i = 0; i < board[0].length; i++) {
            if(!isValidColumn(board, i)) {
                return false;
            }
        }
        return isValidBlocks(board);
    }
    private boolean isValidRow(char[][] grid, int row) {
        HashSet<Character> hs = new HashSet<>();
        for(int i = 0; i < grid[0].length; i++) {
            char ch = grid[row][i];
            if(ch != '.') {
                if(hs.contains(ch)) {
                    return false;
                }
                hs.add(ch);
            }
        }
        return true;
    }
    private boolean isValidColumn(char[][] grid, int col) {
        HashSet<Character> hs = new HashSet<>();
        for(int i = 0; i < grid.length; i++) {
            char ch = grid[i][col];
            if(ch != '.') {
                if(hs.contains(ch)) {
                    return false;
                }
                hs.add(ch);
            }
        }
        return true;
    }
    private boolean isValidBlocks(char[][] grid) {
        for(int i = 0; i < grid.length; i+=3) {
            for(int j = 0; j < grid[0].length; j+=3) {
                HashSet<Character> hs = new HashSet<>();
                for(int k = i; k < i + 3; k++) {
                    for(int l = j; l < j + 3; l++) {
                        char ch = grid[k][l];
                        if(ch != '.') {
                            if(hs.contains(ch)) {
                                return false;
                            }
                            hs.add(ch);
                        }
                    }
                }
            }
        }
        return true;
    }
}
