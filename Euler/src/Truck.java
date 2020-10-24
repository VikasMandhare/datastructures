public class Truck {

	public int fillTheTruck(int num, int[] boxes, int unitSize, int[] unitsPerBox, long truckSize) {

		Integer queue[] = new Integer[100000];
		int k = 0;
		for (int i = 0; i < boxes.length; i++) {
			for (int j = 0; j <= i; j++) {
				queue[k++] = unitsPerBox[i];
			}
		}

//		Arrays.sort(queue, Collections.reverseOrder());

		int load=0;
		for(int l=0;l<truckSize;l++) {
			load=load+queue[l];
		}
		return load;
	}

	public static void main(String[] args) {
		Truck ob = new Truck();
		int[] boxes = { 1, 2, 3 };
		int[] unitsPerBox = { 3, 2, 1 };

		System.out.println(ob.fillTheTruck(3, boxes, 3, unitsPerBox, 3));
	}

}
