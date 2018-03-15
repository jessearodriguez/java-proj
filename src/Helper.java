import javax.swing.JTextArea;

public class Helper //dump all helper methods here
{
	public String rjustify(String input) //assuming max is 80 characters per line, already formatted, justifies right
	{
		System.out.print(input);
		
		String[] in = input.split("\\r?\\n",-1); //handles windows and java new line decleration, splits every line into its own array, including empty lines
		
		for(int i =0; i < in.length;i++)
		{
			
			
			System.out.print("content of line " + i + " is " + in[i]+"\n");
		}
		
		
		return in.toString();
	}
	
	
	public void statcalc(JTextArea textArea_1)
	{
		int wordspr = 4;
        int linespr = 5;
        int emptyln = 2;
        int aveli = 32;
        int avewo = 10;

        textArea_1.append("Words Processed: " + wordspr + "\n");
        textArea_1.append("Number of Lines Processed: " + linespr + "\n");
        textArea_1.append("Number of Empty Lines Removed: " + emptyln + "\n");
        textArea_1.append("Average Line Length: " + aveli + " Characters" + "\n");
        textArea_1.append("Average Words Per Line: " + avewo + "\n");
	}

}
