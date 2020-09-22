import java.io.*;

public class wordcount {

	private static File srcFile = null;
	private static String srcFilename = "<srcFilename>";
	private static int EOF = -1;
	
	public static void main(String[] args) throws IOException{
		if (args.length != 1) {
			System.out.println("Usage: wordcount <src>");
			return;
		}
		
		if (args[0] != null) {
			srcFilename = args[0];
			System.out.println("linecount: srcFilename = '"+srcFilename+"'");
			srcFile = new File(srcFilename);
			if (srcFile == null) {
				System.out.println("wordcount: Cannot open srcFile '"+srcFilename+"'");
				return;
			}
			
		}
		else {
			System.out.println("wordcount: [OK] srcFilename = '"+srcFilename+"'");
		}
		int c;
		int nWords = 0;
		boolean inWord = false;
		
		FileInputStream srcStream = new FileInputStream(srcFile);
		
		while ((c = srcStream.read()) != EOF) {
			if (c != 32)
			{
				if (!inWord) {
					inWord = true;
					++nWords;
				}
			}
			else {
				inWord = false;
			}
		}
		srcStream.close();
		System.out.println(nWords+ " words");
	}
	

}
