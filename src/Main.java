import java.util.ArrayList;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
	
		Graph g = new Graph();
		Main m = new Main();
		
	/*	g.setW(0, 0, 0);
		g.setW(0, 1, 1);
		g.setW(0, 2, 1);
		g.setW(0, 3, 0);


		g.setW(1, 0, 0);
		g.setW(1, 1, 0);
		g.setW(1, 2, 1);
		g.setW(1, 3, 0);


		g.setW(2, 0, 1);
		g.setW(2, 1, 0);
		g.setW(2, 2, 0);
		g.setW(2, 3, 1);

		g.setW(3, 0, 0);
		g.setW(3, 1, 0);
		g.setW(3, 2, 0);
		g.setW(3, 3, 1);*/

		g.setW(0, 0, 0);
		g.setW(0, 1, 5);
		g.setW(0, 2, 8);
		g.setW(0, 3, 5);


		g.setW(1, 0, 5);
		g.setW(1, 1, 0);
		g.setW(1, 2, 9);
		g.setW(1, 3, 2);


		g.setW(2, 0, 8);
		g.setW(2, 1, 9);
		g.setW(2, 3, 6);
		g.setW(2, 3, 0);


		g.setW(3, 0, 5);
		g.setW(3, 1, 2);
		g.setW(3, 2, 6);
		g.setW(3, 3, 0);


	/*	g.setW(4, 0, 0);
		g.setW(4, 1, 3);
		g.setW(4, 2, 2);
		g.setW(4, 3, 4);
		g.setW(4, 4, 0);
		g.setW(4, 5, 2);

		g.setW(5, 4, 2);
		g.setW(5, 5, 0);
		g.setW(5, 3, 0);
		g.setW(5, 2, 0);
		g.setW(5, 1, 0);
		g.setW(5, 0, 0);*/
		//ShortestPath t = new ShortestPath();
		m.dijkstra(g, 1, 2);

	}

	// tabe baraye peyda kardan kotah tarin masir ba estefade az matrix mojaverat va
	// dijkstra
	void dijkstra(Graph g, int mabda, int maghsad) {
		// V= tedad raas ha
		int V = g.graph.length;
		
		// raas hayi ke az anha obor kardehim ra dar array Solved true gharar midahim,
		// tol arrat Solved be tedad raas hast
		
		int solved[] = new int[V];
		
		// d=> barayezakhire faseleha az mabda be sayere maghsad ha
		int d[] = new int[V];



		// meghdar tamam khane haye d ra max dar nazar migirim.
		for (int i = 0; i < V; i++) {
			d[i] = Integer.MAX_VALUE;
			// Solved[i] = false;

		}

	

		// path tree
		int[] masafatT = new int[V];

		// fasele mabda az khodash ra 0 darnazar migirim
		d[mabda] = 0;
		
		// The starting vertex does not
		// have a parent
		masafatT[mabda] = -1;

		int j = 0;
		// Find shortest path for all vertices
		while (j != V) {

			// kotah tarin masir az mabda ra ba estefade az tabe minMasafat bedast miavarim
			int minIndex = minMasafat(d, solved);

			// adad bedast amade az minMasafat ra be onvan shomare khane dar Solved darnazar
			// migirm,
			// va chon aknon dar khane minMasafat gharar darim anra 1 migozarim, be mani an
			// ke az in khane obor kardim
			// Solved[minIndex] = true;
			solved[minIndex] = 1;

			// update masafat
			for (int k = 0; k < V; k++) {
				// agar k ozv solved nabod
				if (solved[k] == 0) {
					// beyne minIndex va k yall vojod dashte bashad
					if (g.graph[minIndex][k] != 0) {
						if (d[minIndex] != Integer.MAX_VALUE) {
							if (d[minIndex] + g.graph[minIndex][k] < d[k]) {
								d[k] = d[minIndex] + g.graph[minIndex][k];
								masafatT[k] = minIndex;
							}
						}

					}

				}
			}
			j++;
		}

		// print the constructed distance array
		printSolution(d, masafatT, mabda, maghsad);
	}

	// tabe baraye peyda kardan kotah tarin masir az mbada
	int minMasafat(int d[], int[] Solved) {
		// Initialize min value
		int min = Integer.MAX_VALUE;
		int minIndex = -1;

		for (int i = 0; i < d.length; i++)
			// agar masafat az min kochik tar bod va az an obor nakarde bashim index an ra
			// barmigardanim be onvan minIndex
			if (Solved[i] == 0 && d[i] <= min) {
				min = d[i];
				minIndex = i;
			}

		return minIndex;
	}

	// tabe baraye namayesh masafat
	void printSolution(int d[], int[] masafatT, int start, int end) {
		int V = d.length;

		System.out.print("\n" + start + " -> ");
		System.out.print(end + "  ");
		System.out.print(d[end] + "  ");
		printMasafat(end, masafatT);

	}

	// tabe baraye namayesh raas haye gozarande shode
	static void printMasafat(int CV, int[] masafatT) {

		if (CV == -1) {
			return;
		}
		printMasafat(masafatT[CV], masafatT);
		System.out.print(CV + " ");
	}
}