package chapter8;

public class RobotMove {
	int[][] move = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
	boolean[][] visited = new boolean[1000][1000];
	int count = 0;
	int Rows,Cols;
	public int movingCount(int threshold, int rows, int cols)
    {
		if(threshold < 0 || rows <= 0 || cols <= 0)
			return 0;
		Rows = rows;
		Cols = cols;
		moving(threshold,0,0);
		return count == 0 ? 1 : count;
    }
	public void moving(int threshold, int row, int col){
		for(int i = 0; i < 4; i++){
			int newRow = row + move[i][0];
			int newCol = col + move[i][1];
			if(newRow >= 0 && newRow < Rows && newCol >= 0 && newCol < Cols && judge(newRow,newCol,threshold)){
				if(!visited[newRow][newCol]){
					count++;
					visited[newRow][newCol] = true;
					moving(threshold, newRow, newCol);
				}
			}
		}
	}
	public boolean judge(int row,int col,int threshold){
		int total = 0;
		while(row != 0){
			total += (row % 10);
			row = row / 10;
		}
		while(col != 0){
			total += (col % 10);
			col = col / 10;
		}
		if(total > threshold)
			return false;
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RobotMove r = new RobotMove();
		System.out.println(r.movingCount(1, 1, 0));
	}

}
