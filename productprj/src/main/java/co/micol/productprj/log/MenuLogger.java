package co.micol.productprj.log;

public class MenuLogger {
	
	public static void printResult(int result, String word) {
		if (result == 1) {
			System.out.println("**"+word+"성공**");
		} else {
			System.out.println("**"+word+"실패**");
		}
	}
}
