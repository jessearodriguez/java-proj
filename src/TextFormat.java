import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class TextFormat 
{

	public void formatText() throws FileNotFoundException
	{
		String inputLine = "";
		String outputLine = "";
		int WordLimit = 80;
		
		FileReader fr= new FileReader("fileNameHere");
		Scanner scan = new Scanner(fr);
		StringBuilder buffer = new StringBuilder(WordLimit);

        while (scan.hasNextLine()) {
            Scanner scan2 = new Scanner(scan.nextLine());
            while (scan2.hasNext()) {
                String nextWord = scan2.next();
                if ((buffer.length() + nextWord.length() + 1) > WordLimit) {
                    buffer.append('\n');
                    System.out.print(buffer.toString());

                    buffer = new StringBuilder(nextWord);
                }
                else {
                    buffer.append((buffer.length() == 0 ? "" : " ") + nextWord);
                }
            }
        }

        if (buffer.length() > 0) {
            System.out.print(buffer.toString() + "\n"); // random
        }
		
	}

}
