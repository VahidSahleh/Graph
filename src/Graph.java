
public class Graph {
	int[][] graph = new int[6][6];
	public void setW(int i , int j , int w) {
		graph[i][j] = w;
		graph[j][i] = w;
	}
	
}
