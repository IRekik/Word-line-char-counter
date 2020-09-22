import java.io.*;
public class wc {
	
	private static File srcFile = null;
	private static String srcFilename = "<srcFilename>";
	private static int totalLines, totalWords, totalChars;
	private static int EOF = -1;
	
	public static void main(String[] args) throws IOException {
		if (args.length < 1) {
			System.out.println("Usage: wc <src> { src }");
			return;
		}
		for (int n = 0; n < args.length; n++) {
			if (args[n] != null) {
				srcFilename = args[n];
				System.out.println("linecount: srcFilename = '"+srcFilename +"'");
				srcFile = new File(srcFilename);
				if (srcFile == null) {
					System.out.println("wc: Cannot srcFile '"+srcFilename+"'");
					return;
				}
			}
			else {
				System.out.println("wc: [OK] srcFilename = '"+srcFilename+"'");
			}
			totalLines = totalWords = totalChars = 0;
			int c;
			int nChars, nLines, nWords;
			boolean inWord = false;
			
			nChars = nLines = nWords = 0;
			
			FileInputStream srcStream = new FileInputStream(srcFile);
			
			while ((c = srcStream.read()) != EOF) {
				++nChars;
				if (c == '\n') {
					++nLines;
				}
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
			System.out.println(nWords);
			srcStream.close();
			System.out.println(nLines+" lines, "+nWords+" words, "+nChars+" chars");
			totalLines += nLines;
			totalWords += nWords;
			totalChars += nChars;
			
		}
		if (args.length > 1) {
			System.out.println("**Total: "+totalLines+" lines, "+ totalWords+" words, "+totalChars+ " chars" );
		}
	}

}
