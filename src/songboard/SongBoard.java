package songboard;

import java.io.*;
import java.util.Random;

/* Class for storing song rankings, initially read from CSV */
public class SongBoard implements SongBoardInterface {

	public int numEntries;            // number of actual entries
	private String songBoardTitle;
	private SongEntry[] songArray;      // array of game entries (names & scores)

	/**
	 * Constructs a SongBoard with the given capacity for storing entries.
	 */
	public SongBoard() {
		numEntries = 200;
		// Future: read numEntries from file in advance; remove hardcode
		songArray = new SongEntry[numEntries];
		songBoardTitle = "Shazam Top 200 Songs";
		String filePath;
		// Replace below with full path on your computer if this doesn't work
		filePath = "DataFiles/ThirdPartyDataCSVFiles/SongBoardInput.csv";
		int count = 0;
		// Read the records from the .csv file
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				// Remove non-numeric characters to support convert to int
				values[0] = values[0].replaceAll("[^\\d]", "");
				SongEntry thisSongEntry = new SongEntry(Integer.parseInt(values[0]), values[1], values[2]);
				songArray[count] = thisSongEntry;
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void printTopTen() {
		int rank;
		String artist;
		String songname;
		// Print header
		System.out.println(songBoardTitle);
		System.out.println("The Top Ten in the Array Are:");
		for (int i = 0; i < 10; i++) {
			rank = songArray[i].GetRank();
			artist = songArray[i].GetArtist();
			songname = songArray[i].GetSongName();
			System.out.println(rank + ", " + artist + ", " + songname);
		}
	}

	// Alternate implementation: try shuffle built-in method
	public void scrambleBoard() {
		// a pseudorandom number generator
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		double rand0to1;
		int lowerrandom, upperrandom, randomrange, randlowertoupper;
		int j;  //Higher entry to swap
		long mylong = System.currentTimeMillis();
		//System.out.println("\n\nCurrent time in milliseconds since 1970 is: " + Long.toString(mylong));
		rand.setSeed(mylong);
		SongEntry temp;
		for (int i = 0; i < numEntries; i++) {
			lowerrandom = i;
			upperrandom = numEntries - 1;
			randomrange = upperrandom - lowerrandom;
			rand0to1 = rand.nextDouble();
			randlowertoupper = (int) (lowerrandom + rand0to1 * randomrange);
			j = randlowertoupper;
			// Now make the transfer
			temp = songArray[i];
			songArray[i] = songArray[j];
			songArray[j] = temp;
		}
	}

	public void insertionSortBoard() {
		System.out.println ("\nThe new sort will happen here...\n");


		//char[] data = new char[0];
		//int n = data.length;
		int n = numEntries;
		for (int k=1; k < n; k++) {                   // begin with second character
			SongEntry cur = songArray[k];                       // time to insert cur=data[k]
			int j = k;                                // find correct index j for cur
			while (j > 0 && songArray[j-1].rank > cur.rank) {        // thus, data[j-1] must go after cur
				songArray[j] = songArray[j-1];                   // slide data[j-1] rightward
				j--;                                  // and consider previous j for cur
			}
			songArray[j] = cur;                            // this is the proper place for cur
		}
	}

	public static void test() {
		//SongBoard mySongBoard;
		SongBoard mySongBoard = new SongBoard();
		mySongBoard.printTopTen();
		mySongBoard.scrambleBoard();
		// See if the scramble board worked
		System.out.println("\n\nThe new scrambled board is:");
		mySongBoard.printTopTen();
		// Now make call to insertionSortBoard here
		mySongBoard.insertionSortBoard();
		System.out.println("\n\nThe board is now:");
		mySongBoard.printTopTen();
		//mySongBoard.printSongsElevenToTwenty();
	}

	public static void main(String[] args) {
		test();
	}


}