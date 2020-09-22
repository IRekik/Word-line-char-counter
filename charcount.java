// Ismael Rekik
// 40132567
// SOEN 341 - Sprint 1
// Assignment due : 21 September 2020
import java.io.*;

public class charcount {
	private static int EOF = -1;
	private static File srcFile = null;
	private static String srcFilename = "<srcFilename>";
	

	public static void main (String[] args) throws IOException{
		if (args.length != 1) {
			System.out.println("Usage: charcount <src>");
			return;
		}
		
		if (args[0] != null) {
			srcFilename = args[0];
			System.out.println("charcount: srcFilename '"+srcFilename+ "'");
			srcFile = new File(srcFilename);
			if (srcFile == null) {
				System.out.println("charcount: Cannot open srcFile");
				return;
			}
			else {
				System.out.println("charcount: [OK] srcFilename = '"+ srcFilename+"'");
			}
		}
		FileInputStream srcStream = new FileInputStream(srcFile);
		int c;
		int nChars = 0;
		
		while ((c = srcStream.read()) != EOF) {
			++nChars;
		}
		srcStream.close();
		System.out.println(nChars+" characters");
	}

}
