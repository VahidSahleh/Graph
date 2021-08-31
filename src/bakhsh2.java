import java.util.Arrays;

public class bakhsh2 {
	// rass ha ba kamtarin yall az kochak be bozorh
	static int d[] = new int[6];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph();
		g.setW(0, 0, 0);
		g.setW(0, 1, 1);
		g.setW(0, 2, 1);
		g.setW(0, 3, 0);
		g.setW(0, 4, 0);

		g.setW(1, 0, 1);
		g.setW(1, 1, 0);
		g.setW(1, 2, 1);
		g.setW(1, 3, 0);
		g.setW(1, 4, 0);
		g.setW(1, 5, 1);

		g.setW(2, 0, 1);
		g.setW(2, 1, 0);
		g.setW(2, 2, 0);
		g.setW(2, 3, 0);
		g.setW(2, 4, 1);
		g.setW(2, 5, 1);

		g.setW(3, 0, 0);
		g.setW(3, 1, 0);
		g.setW(3, 2, 1);
		g.setW(3, 3, 0);
		g.setW(3, 4, 0);
		g.setW(3, 5, 1);

		g.setW(4, 4, 0);
		g.setW(4, 3, 1);
		g.setW(4, 2, 0);
		g.setW(4, 1, 0);
		g.setW(4, 0, 0);
		g.setW(4, 5, 0);
		
		g.setW(5, 4, 0);
		g.setW(5, 3, 0);
		g.setW(5, 2, 0);
		g.setW(5, 1, 0);
		g.setW(5, 0, 1);
		g.setW(5, 5, 0);

		int V = g.graph.length;
		int V1 = g.graph.length;
		int min = 0;
		//
		while (V != 0) {
			// raass ba kamtarin tedad yal ra peyda mikonim
			min = minVertexD(g);
			// agar teddad yal haye d[min] az tedad rass haye geraf-1 barabr bod bozorg
			// tarin zir graph kamel V mishavad
			if (d[min] == V - 1) {
				System.out.println(V);
				break;
				// dar gheyre in sorat an raass ra hazf mikonim va tamam yall haye motasel be an
				// ra 0 mikonim
			} else {
				for (int i = 0; i < V; i++) {
					if (g.graph[min][i] == 1 && g.graph[i][min] == 1)

						g.graph[min][i] = 0;
					g.graph[i][min] = 0;
					// d[min]=0;

				}

			}
			// meghdar d[min] ra adadi bozorg gharar midahim ta digar an ra dar moghayese
			// haye badi estefade nakonim
			d[min] = Integer.MAX_VALUE;
			V--;
		}
		// baraye namayesh bozorg tarin zir graph kamel
		for (int i = 0; i < g.graph.length; i++) {
			for (int j = 0; j < g.graph[i].length; j++) {
				if (g.graph[i][j] == 1)
					System.out.println(i + "->" + j);
			}

		}

	}

//peyda kardan rass haye ba kamtarin yal az kochak be bozorg
	static int minVertexD(Graph g) {
		int count = 0;

		for (int i = 0; i < g.graph.length; i++) {
			for (int j = 0; j < g.graph[0].length; j++) {
				if (g.graph[i][j] == 1) {
					count = count + 1;
				}

			}
			d[i] = count;
			count = 0;
		}

		int index = 0;
		int min = d[index];

		for (int k = 1; k < d.length; k++) {

			if (d[k] < min && d[k] > 0) {
				min = d[k];
				index = k;
			}

		}

		return index;

	}

}
