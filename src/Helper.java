import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JTextArea;

public class Helper //dump all helper methods here
{
	public String rjustify(String input) //assuming max is 80 characters per line, already formatted, justifies right
	{

		String[] in = input.split("\\r?\\n",-1); //handles windows and java new line decleration, splits every line into its own array, including empty lines
		int distto80;//distance to 80 chars
		String output = "";
		/*
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
		*/
		for(int i = 0; i<in.length;i++)
		{
			if(in[i].length()==0) {}
			else 
			{
				in[i]=String.format("%80s", in[i]);
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
					else
					{
						j=slength;
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

	public int preemptycalc(String text)
	{
		int empty=0;
		char prev = 0; 

        char letter = text.charAt(0);

		 for(int i = 0; i < text.length(); i++)
		 {
			
	        if(i > 0)	
	        {
	        	prev = text.charAt(i - 1);
	        }	
	        letter = text.charAt(i);
			if(((prev == '\n') && ( (letter == '\n') || (letter == '\0') ) ))
	    	{
	    		empty++;
	    	}
	    
		 }

		return empty;
	}
	public void statcalc(JTextArea textArea_1,String text,int empty)
	{
		textArea_1.setText("");//clears text area in preparation for next analysis
		
		//stats to be returned
		int wordspr = 0;
        int linespr = 0;
        int emptyln = empty;
        double aveli = 0;
        double avewo = 0;
        int i = 0;
        //letter being checked
        char letter = text.charAt(0);
        char prev = 0; 
        //stats for averages
        int characters = 0;
        int linearray[];
        int size;
        int words = 0;
        
        String[] in = text.split("\\r?\\n",-1);//splits text into line arrays

        //loop to find total characters words and lines
        for(i = 0; i < text.length(); i++)
        {
        	//set previousletter
        	if(i > 0)
        	{
        		prev = text.charAt(i - 1);
        	}
        	letter = text.charAt(i);
        	//characters processed
        	if((letter != '\0')&&(letter != '\n'))
        	{
        		characters++;
        	}
        	//words processed
        	if( ((letter == ' ')||(letter == '\n')||(letter == '\0')) && ( ((prev > 64)&&(prev < 91)) || ((prev > 96)&&(prev < 123)) ))  
        	{
        		wordspr++;
        	}
        	//lines processed
        	if((letter == '\n')||(letter == '\0'))
        	{
        		linespr++;
        	}
        	//emptyln
        	/*
        	if(( (prev == '\n') && ( (letter == '\n') || (letter == '\0') ) ))
        	{
        		emptyln++;
        	}
        	*/
        }
        //calculating averages
        size = linespr - emptyln;
        linearray = new int[size];
        int index = 0;
        for(i = 0; i< text.length(); i++)
        {
        	if(i > 0)
        	{
        		prev = text.charAt(i - 1);
        	}
        	letter = text.charAt(i);
        	if( ((letter == ' ')||(letter == '\n')||(letter == '\0')) && ( ((prev > 64)&&(prev < 91)) || ((prev > 96)&&(prev < 123)) ))  
        	{
        		words++;
        	}
        	if((letter == '\n')&&(index < size))
        	{
        		//store value and increment if line is not empty
        		if(words != 0)
        		{
        			linearray[index] = words;
        			words = 0;
        			index++;
        		}
        	}
        }
       // System.out.println("\n" + "Array Size: " + size + "\n");
        //debugging
        words = 0;
        for(i = 0; i < size; i++)
        {
        	words += linearray[i];
        }
        
        avewo = (words * 1.0)/size;
        /*
        for(i = 0; i < size; i++)
        {
        	System.out.println(linearray[i]);
        }
        */
        //debugging
        for(i = 0;i<in.length;i++) 
        {
        	if(in[i].length()==0) {}//do nothing if the line was empty
        	else
        	{
        		aveli += in[i].length();
        	}
        }
        
        aveli =aveli/size;
        
        textArea_1.append("Words Processed: " + wordspr + "\n");
        textArea_1.append("Number of Lines Processed: " + linespr + "\n");
        textArea_1.append("Number of Empty Lines Removed: " + emptyln + "\n");
        textArea_1.append("Average Line Length: " + aveli + " Characters" + "\n");
        textArea_1.append("Average Words Per Line: " + avewo + "\n");
	}


	public String formatText(String text) //assuming all first spaces removed by ljustify
	{
		StringBuilder input = new StringBuilder();
		
		int WordLimit = 80;
		int currlincount=0; //current line count
		int lsp; //last space position
		char lastchar=0;
		int j;
		
		for(int i =0;i<text.length();i++)
		{
			if(text.charAt(i)!='\n')
			{
				if((text.charAt(i)==lastchar)&&(lastchar==' ')) {}
				else
				{
					input.append(text.charAt(i)); //append all characters
					lastchar = text.charAt(i);
					currlincount++; //increase count for line word count
					
					if(currlincount>=80)
					{
						j = i;
						while(text.charAt(j)!= ' ')//navigates to the last space
						{
							j--;
						}
						i=j;
								
						input= new StringBuilder(input.substring(0,j)); //goes back to first space available
						input.append("\n");
						currlincount = 0;
					}
				}
			}
			else 
				{
					if(lastchar=='\n') {}
					else 
					{
						currlincount = 0; //if new line detected, reset char count to 0
						input.append(text.charAt(i));
						lastchar = text.charAt(i);
					}
					
				}
			
		}

        return input.toString();
	}

}
