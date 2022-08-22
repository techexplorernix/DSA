package tech.explorer.nix.backtracking;

//https://leetcode.com/problems/word-search/
//LC-79
public class WordSearch {
	//TC O(m*n*k) mXn size of board and k=word.length
	//SC O(1) 
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(word.charAt(0)==board[i][j] && searchWord(board, word, 0, i, j))
                	return true;                
            }
        }
        return false;
    }
    
    boolean searchWord(char [][]board, String word, int i, int r, int c){
        if(i>=word.length()){
            return true;
        }
        if(r<0 || r>=board.length || c<0 || c>=board[0].length){
            return false;
        }
        boolean ans = false;
        if(word.charAt(i)==board[r][c]){
            char ch = board[r][c];
            board[r][c]='@';
            ans = searchWord(board, word, i+1, r+1, c) ||
            searchWord(board, word, i+1, r-1, c) ||
            searchWord(board, word, i+1, r, c-1) ||
            searchWord(board, word, i+1, r, c+1);
            board[r][c] = ch;
            
        }
        return ans;
    }
}
