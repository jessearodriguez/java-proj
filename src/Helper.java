import javax.swing.JTextArea;

public class Helper //dump all helper methods here
{
	public String rjustify(String input) //assuming max is 80 characters per line, already formatted, justifies right
	{

		String[] in = input.split("\\r?\\n",-1); //handles windows and java new line decleration, splits every line into its own array, including empty lines
		int distto80;//distance to 80 chars
		String output = "";
		
		for(int i =0; i < in.length;i++) //performs shifting for right justification for each line
		{
			
			if((in[i].length()==80)||(in[i].length()==0)||in[i].length()>80) {}//do nothing if string is full, or string is a new line, or exceeds max characters
			else if(in[i].length()<80)
			{
				distto80 = 80-in[i].length();
				for(int j = 0; j<distto80;j++)
				{
					in[i] = " " + in[i]; //adds spaces to the start needed until the words line up.
				}
			}
			

		}
		

		for(int i = 0; i < in.length;i++) // rebuilds string from string array
		{
			if(in[i].length() == 0) output = output + "\n"; //new line
			else
			{
				output = output + in[i] + "\n";
			}

		}
		output=output.substring(0, output.length()-1);
		return output;
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

	public String ljustify(String input)//assuming max is 80 characters per line, already formatted, justifies left
	{
		String[] in = input.split("\\r?\\n",-1); //handles windows and java new line decleration, splits every line into its own array, including empty lines
		
		
		
		String output = "";
		
		for(int i =0; i < in.length;i++) //performs shifting for left justification for each line
		{
			if(in[i].length()>80||in[i].length()==0) {}
			else 
			{
				int slength = in[i].length();
				
				for(int j = 0;j <slength;j++)
				{
					if(in[i].charAt(j)==' ')
					{
						in[i]=in[i].substring(j+1, slength);
						
						slength=in[i].length();
						j--;
					}
					
				}
			}
			
		}
		

		for(int i = 0; i < in.length;i++) // rebuilds string from string array
		{
			if(in[i].length() == 0) output = output + "\n"; //new line

			else
			{
				output = output + in[i] + "\n";
			}

		}
		
		//debugging
		/*
		System.out.print(output);
		System.out.print("test");
		*/
		output=output.substring(0, output.length()-1);
		return output;
	}
}
