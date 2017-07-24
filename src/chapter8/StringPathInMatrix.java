package chapter8;

/**
 * @Description:面试题66：矩阵中的路径
 * 题目：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如：
 * a b c e
 * s f c s
 * a d e e
 * 中存在路径bcced，但不存在路径abcd
 * @author:鐜嬩附闆?-Dosgi.requiredJavaVersion=1.6
 * @time:2017年1月5日下午5:16:27
 */
public class StringPathInMatrix {
	int[][] move = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
	boolean[][] visited = new boolean[1000][1000];
	char[] path = new char[100000];
	int depth = 0;
	int Rows,Cols;
	boolean flag = false;
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
		char[][] arr = new char[1000][1000];
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < cols; j++)
				arr[i][j] = matrix[i * cols + j];
		Rows = rows;
		Cols = cols;
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < cols; j++){
				if(arr[i][j] == str[0]){
					depth = 1;
					visited[i][j] = true;
					judge(arr,i,j,str);
					visited[i][j] = false;
					if(flag)
						return true;
				}
			}
		return false;
    }
	public boolean judge(char[][] map, int row, int col, char[] str)
    {
		if(depth == str.length){
			flag = true;
			return true;
		}
		for(int i = 0; i < 4; i++){
			int newRow = row + move[i][0];
			int newCol = col + move[i][1];
			if(newRow >= 0 && newRow < Rows && newCol >= 0 && newCol < Cols && str[depth] == map[newRow][newCol]){
				if(depth < str.length && !visited[newRow][newCol]){
					depth++;
					visited[newRow][newCol] = true;
					judge(map, newRow, newCol, str);
					visited[newRow][newCol] = false;
					depth--;
				}
			}
		}
		return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] matrix = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray();
		char[] str = "SGGFIECVAASABCEHJIGQEMS".toCharArray();
		StringPathInMatrix s = new StringPathInMatrix();
		System.out.println(s.hasPath(matrix,5,8,str));
	}

}
