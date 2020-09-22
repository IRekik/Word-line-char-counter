import java.io.*;

public class linecount {

	private static File srcFile = null;
	private static String srcFilename = "<srcFilename>";
	private static int EOF = -1;
	
	public static void main(String[] args) throws IOException{
		if (args.length != 1) {
			System.out.println(("Usage: linecount <src>"));
			return;
		}
		
		if (args[0] != null) {
			srcFilename = args[0];
			System.out.println("linecount: srcFilename = '"+srcFilename+"'");
			srcFile = new File(srcFilename);
			if (srcFile == null) {
				System.out.println("linecount: Canoot open srcFile '"+srcFilename+"'");
				return;
			}
		}
		else {
			System.out.println("linecount: [OK] srcFilename = '"+srcFilename+"'");
		}
		FileInputStream srcStream = new FileInputStream(srcFile);
		int c;
		int nLines = 0;
		while (( c = srcStream.read()) != EOF) {
			if (c == '\n') {
				++nLines;
			}
		}
		srcStream.close();
		
		System.out.println(nLines+" lines");
	}

}
