package リバーシ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DbTest {

	private static final String URL = "jdbc:splite:C:/sqlite/game.db";

					public static void main(String[] args) throws Exception {
						insertCell(1, 3, 3, 'W');
						System.out.println("insert done");
						selectAll();
					}
	// TODO 自動生成されたメソッド・スタブ

	//1マス分　INSERT　するメソッド
	private static void insertCell(int game_Id,int row,int col,char stone)throws Exception {
				String sql = """
					INSERT INTO board_cell(game_id,row,col,stone) +
					VALUES(?,?,?,?)
				""";
			
								try (Connection conn = DriverManager.getConnection(URL);
									PreparedStatement ps = conn.prepareStatement(sql)) {
									ps.setInt(1,game_Id);
									ps.setInt(2,row);
									ps.setInt(3,col);
									ps.setString(4,String.valueOf(stone));
								
									ps.executeUpdate();
						
									}
	}
	
	private static void selectAll() throws Exception {
		String sql = "SELECT game_id,row,col,stone FROM board_cell ORDER BY row,col";

							try (Connection conn = DriverManager.getConnection(URL);
									PreparedStatement ps = conn.prepareStatement(sql);
									var rs = ps.executeQuery()) {
					
													while (rs.next()) {
														int gameId = rs.getInt("game_id");
														int row = rs.getInt("row");
														int col = rs.getInt("col");
														String stone = rs.getString("stone");
										
														System.out.println(
																"game=" + gameId +
																		" row=" + row +
																		" col=" + col +
																		" stone=" + stone);
													}
							}
	}
}
