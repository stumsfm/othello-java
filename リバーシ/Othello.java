package リバーシ;

public class Othello {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int size = 6;
		char[][] board = new char[size][size];
		
		initBoard(size,board);
	}
	
	static void initBoard(int size,char[][] board) {
		if ( size % 2 != 0) {
			System.out.println("盤面サイズは偶数のみ対応しています");
			return;
		}
		
		//全て　空で初期化
				for(int i = 0;i < size ; i++) {
					for(int j = 0; j < size ; j++) {
						board[i][j] = '.';
					}
				}
				
				int mid = size / 2;
				
				//　表示
				for(int i = 0;i < size ; i++) {
					for(int j = 0; j < size ; j++) {
						System.out.print(board[i][j] + "");
					}
					System.out.println();
				}
	}
}
