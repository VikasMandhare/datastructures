package trees;

public class Nisum {
	
	private static void print(int num,int start) {	
		if(num>0) {
			if(start<=num) {
				System.out.println(start);
				print(num,start+1);
			}else {
				if(start>=1) {
					System.out.println(start);
					print(num,start-1);
				}				
			}
		}		
	}
	
	private static void print2() {
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print(5,1);
	}

}
