package rpg;
import java.util.Scanner;

public class ScanCommand extends Object {
	private static Scanner scan = new Scanner(System.in);
	
	public ScanCommand() {}
	
	public static int scan(){
		int number = scan.nextInt();
		return number;
	}
	public static void close(){scan.close();}
}
 