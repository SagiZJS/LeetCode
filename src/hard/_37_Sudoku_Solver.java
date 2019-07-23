package hard;

class _37_Sudoku_Solver {
  
	
	public static void main(String[] args) {
		
		char[][] board = new char[9][9];
		
		 
		
		 
		for(char[] a : board) {
		 
			for(int i = 0; i < 9; i++) {
				a[i] = '.';
			}
		}
		
		board[0][0] = '5';
		board[0][1] = '3';
		board[0][4] = '7';
		board[1][0] = '6';
		board[1][3] = '1';
		board[1][4] = '9';
		board[1][5] = '5';
		board[2][1] = '9';
		board[2][2] = '8';
		board[2][7] = '6';
		board[3][0] = '8';
		board[3][4] = '6';
		board[3][8] = '3';
		board[4][0] = '4';
		board[4][3] = '8';
		board[4][5] = '3';
		board[4][8] = '1';
		board[5][0] = '7';
		board[5][4] = '2';
		board[5][8] = '6';
		board[6][1] = '6';
		board[6][6] = '2';
		board[6][7] = '8';
		board[7][3] = '4';
		board[7][4] = '1';
		board[7][5] = '9';
		board[7][8] = '5';
		board[8][4] = '8';
		board[8][7] = '7';
		board[8][8] = '9';
		
		
		_37_Sudoku_Solver s = new _37_Sudoku_Solver();
		s.solveSudoku(board);
		
		s.print(board);
		
		
	}
	
	public void print(char[][] board) {
//		for(char[] a : board) {
//			for(char b : a) {
//				System.out.print(b);
//			}
//			System.out.println();
//		}
//		System.out.println();
	}
	
    public void solveSudoku(char[][] board) {
        
        System.out.println(
                fillOneDigit(board));
        
    }
    
    public boolean fillOneDigit(char[][] board) {
    	/*
    	try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
    	
        //for (int i = 0; i < \; i++) {
           // System.out.println(Arrays.toString(board[i]));
        //}
        //System.out.println();
//    	print(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (int digit = 1 ; digit <= 9; digit++) {
                        if (check(board, i, j, digit)) {
                            board[i][j] = (char) (digit + '0');
                            if(fillOneDigit(board) == true) {
                                return true;
                            }
                        }
                    }
                    board[i][j] = '.';
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean check(char[][] board, int i, int j, int val) {
        for (int index = 0; index < 9; index ++) {
            if (index != i && board[index][j] - '0' == val) {
                return false;
            }
            if (index != j && board[i][index] - '0' == val) {
                return false;
            }
        }
        int row = j / 3;
        int line = i / 3;
        for (int m = 0; m < 3; m++) {
            for (int n = 0; n < 3; n++) {
            	 if (val == board[line * 3 + m][row * 3 + n] - '0' && (line * 3 + m != i && row * 3 + n !=j))
                    return false;
            	 
            }
        }
        return true;
    }
    
}