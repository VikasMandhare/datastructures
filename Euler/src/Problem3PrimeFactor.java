
public class Problem3PrimeFactor {

	private static long largestPrimeFactor(long num) {
		long largeFactor = 0;

		long primeNum = 1;
		long i = 2;
		long range = Math.round(Math.sqrt(num));
		loop1: while (i <= range + 1) {
			System.out.println("prime number = " + primeNum + ":: i=" + i);
			if (num % primeNum == 0) {
				largeFactor = primeNum;
				//System.out.println("dis 1");
			}

			outer: for (; i <= range; i++) {
				//System.out.println("Inside for1 , i=" + i);
				for (long j = 2; j < range && j < i; j++) {
					//System.out.println("Inside for2 , j=" + j);
					if (i % j == 0) {
						continue outer;
					}
				}
				primeNum = i;
				i++;
				continue loop1;
			}
			break;

		}

		return largeFactor;
	}

	public static void main(String[] args) {
		//System.out.println("result=" + largestPrimeFactor(30L));
		//System.out.println("result=" + largestPrimeFactor(13195L));		 
		System.out.println("result=" + largestPrimeFactor(600851475143L));
	}

}
