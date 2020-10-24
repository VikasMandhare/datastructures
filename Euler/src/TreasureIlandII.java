import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TreasureIlandII {
	

	int nodesInNextLayer = 0, nodesLeftInCurrentLayer = 1;

	/**
	 * @param m
	 * @param start
	 * @param treasure
	 * @return
	 */
	public List<Integer[][]> getShortestPaths(Character[][] m, Integer[][] start, Integer[][] treasure) {
		List<Integer[][]> output = new ArrayList<>();
		Integer[][] prev = new Integer[m.length][m[0].length];
		Boolean visited[][] = new Boolean[m.length][m[0].length];

		for (int i = 0; i < start.length; i++) {
			System.out.println("======================New Start===========================");
	
			for(int x=0;x<visited.length;x++) {
				for(int y=0;y<visited.length;y++) {
					prev[x][y] = -1;
					visited[x][y] = null;
				}
				
			}
			
			Queue<Integer> rowQueue = new LinkedList();
			Queue<Integer> columnQueue = new LinkedList();
			nodesInNextLayer=0;
			nodesLeftInCurrentLayer=1;
			
			rowQueue.offer(start[i][0]);
			columnQueue.offer(start[i][1]);

			boolean reachedEnd = false;
			int moveCount = 0;
			
			visited[start[i][0]][start[i][1]] = true;
			prev[start[i][0]][start[i][1]] = start[i][0]*visited.length+start[i][1];

			while (rowQueue.size() > 0 || columnQueue.size() > 0) {
				int r = rowQueue.poll();
				int c = columnQueue.poll();

				System.out.println("--------------polling: " + r + "," + c +" queue size="+rowQueue.size());

				if (m[r][c] == 'X') {
					reachedEnd = true;
					System.out.println("treasure found");
									
					int prevr = r;
					int prevc = c;
					
					while(prev[prevr][prevc]!=prevr*prev.length+prevc) {						
						System.out.println("["+prev[prevr][prevc]+"]"+prevr+"-"+prevc);
						int num = prev[prevr][prevc];
						prevr = num/5;
						prevc = num%5;
						
					}
					System.out.println("["+prev[prevr][prevc]+"]"+prevr+"-"+prevc);
					break;
				}

				explore(r, c, visited, m,prev,rowQueue,columnQueue);
				nodesLeftInCurrentLayer--;

				if (nodesLeftInCurrentLayer == 0) {
					nodesLeftInCurrentLayer = nodesInNextLayer;
					nodesInNextLayer = 0;
					System.out.println("["+r + "," + c+"]");
					moveCount++;									
				}

			}
			
			if(reachedEnd) {
				System.out.println("treasure found in "+moveCount+" steps" );
			}else {
				System.out.println("Treasure NOT FOUND " );
			}

		}

		return output;
	}

	private void explore(int r, int c, Boolean[][] visited, Character[][] m,Integer[][]prev,Queue<Integer> rowQueue,Queue<Integer> columnQueue) {
		Integer[] rowDirection = { -1, 1, 0, 0 };
		Integer[] columnDirection = { 0, 0, 1, -1 };

		for (int i = 0; i < 4; i++) {
			int rr = r + rowDirection[i];
			int cc = c + columnDirection[i];
			System.out.println("checking: " + rr + "," + cc);

			if (rr < 0 || cc < 0)
				continue;
			if (rr >= visited.length || cc >= visited[0].length)
				continue;

			if ((null != visited[rr][cc] && visited[rr][cc]) || m[rr][cc] == 'D')
				continue;

			
			rowQueue.offer(rr);
			columnQueue.offer(cc);
			System.out.println("+++++++++++++offering: " + rr + "," + cc+" queue size="+rowQueue.size());
			visited[rr][cc] = true;
			prev[rr][cc]=r*prev.length+c;	
			nodesInNextLayer++;
		}

	}

	public static void main(String[] args) {
		Character[][] m = { { 'S', 'O', 'O', 'S', 'S' }, 
				            { 'D', 'O', 'D', 'O', 'D' }, 
				            { 'O', 'O', 'O', 'O', 'X' },
				            { 'X', 'D', 'D', 'O', 'O' }, 
				            { 'X', 'D', 'D', 'D', 'O' } };

//		Integer start[][] = { { 0, 0 }, { 0, 3 }, { 0, 4 } };

		Integer start[][] = { { 0, 0 },{ 0 , 3},{ 0 , 4} };

		Integer treasure[][] = { { 2, 4 }, { 3, 0 }, { 4, 0 } };

		TreasureIlandII ob = new TreasureIlandII();
		List<Integer[][]> sPaths = ob.getShortestPaths(m, start, treasure);

		for (Integer[][] path : sPaths) {
			System.out.println(Arrays.toString(path));
		}
	}

}
