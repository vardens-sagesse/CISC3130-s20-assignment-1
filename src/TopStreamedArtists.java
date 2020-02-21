import java.io.*;
import java.util.*;
import java.sql.Timestamp;

/* Comments in this file describe the code BELOW the comment.
 * 
 * This code will generate TWO output files.
 * "TopStreamingArtists-alphabetical.txt" AND "TopStreamingArtists-frequency.txt" */

public class TopStreamedArtists {

	public static void main(String[] args) throws IOException {
		//This will populate our list with Artist objects that contain the position, song name, and artist's name.
		List<String> artists = populateArray("regional-us-weekly-2020-01-17--2020-01-24.csv"); 
		/*This method will display all of our artists in alphabetical order with no duplicates. 
		 * It will print to two files, one with the list in ABC order, and the other will have 
		 * the frequency attached. */
		writeToOutput(artists);
	}

	public static List<String> populateArray(String file) throws IOException {
		List<String> artists = new ArrayList<>();
		BufferedReader input = new BufferedReader(new FileReader(file));
		input.readLine();  // Skips the first two lines of the dataset
		input.readLine();  // which do not contain any useful data.
		String csvInput = input.readLine();
		while ((csvInput = input.readLine()) != null) {
			String[] temp = csvInput.split(",");
			String artistName = temp[2];
			artists.add(artistName);
		}
		input.close();
		return artists;
	}
	
	public static void writeToOutput(List<String> artists) throws IOException {
		Collections.sort(artists);
		//Initialize currentArtist as the first one in the csv file
		String currentArtist = "21 Savage"; 
		int frequency = 1;
		FileWriter writer = new FileWriter("TopStreamingArtists-alphabetical.txt");
		FileWriter writerfreq = new FileWriter("TopStreamingArtists-frequency.txt");
		// Some nice looking headers for our outputs.
		writer.write("*************************************\n**  Artists in Alphabetical Order\n*************************************\n");
		writerfreq.write("*************************************\n**  Artists including Frequency\n*************************************\n");
		/* This loop will iterate through the array and log names to the output if they haven't already appeared. 
		   This is much easier as the array has already been sorted.
		   If unique name, write it down. Else, log the number of times the name has appeared. */
		for (int k = 1; k < artists.size(); k++) {    		
			if (!currentArtist.equals(artists.get(k))) {
				writerfreq.write(currentArtist + " | Frequency: " + frequency + "\n");
				writer.write(currentArtist + "\n");
			    frequency = 1;
			    currentArtist = artists.get(k);
		    }
			else {
				frequency++;
			}
		}
		// This will add the time the lists are generated to the output file.
		Timestamp time = new Timestamp(new Date().getTime());
		writer.write("\nDate this list was generated: " + time.toString());
		writerfreq.write("\nDate this list was generated: "  + time.toString());
		//Close the readers
		writer.close();
		writerfreq.close();
	}
}
