import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            String data = FileIO.readData("data.txt");
            Scanner scanner = new Scanner(data);
            ArrayList<Song> songs = new ArrayList<>();
            Song currentSong = null;    // identify what is being processed
           while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.startsWith("\"")) { // encounter another "" its a new song
                    if(currentSong != null){
                    songs.add(currentSong);
                     }
                
                 String title = "";
                 int endIndex = line.indexOf("\"", 1);
                 if (endIndex != -1) {
                 title = line.substring(1, endIndex);
                } else { System.err.println("Error: Closing quote not found for title in line: " + line);}
                 currentSong = new Song(title);
                } else if (currentSong != null){
                  currentSong.addLine(line);}
           }
           if(currentSong != null){
               songs.add(currentSong);
           }
            scanner.close();

            //Add a homepage functionality
            int choice = 0;
            Scanner userInput = new Scanner(System.in);
            while(choice != 3){
                System.out.println("Welcome to the Swift Song Database!");
                System.out.println("1. View available songs");
                System.out.println("2. Search for songs containing keyword in lyrics");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                choice = userInput.nextInt();

                switch (choice){
                    case 1: //print available songs
                    System.out.println("Available songs: ");
                    for(int i =0; i < songs.size(); i++){
                        System.out.println((i+1)+ ". " + songs.get(i).getTitle());
                    }
                    // Ask user to choose a song
                    System.out.print("Enter the number of the song you want to view lyrics for: ");
                     int songIndex = userInput.nextInt();

                      // Display lyrics of selected song
                     if (songIndex > 0 && songIndex <= songs.size()) {
                     System.out.println("Lyrics for " + songs.get(songIndex - 1).getTitle() + ":");
                     System.out.println(songs.get(songIndex - 1).toString());
                    } else {
                       System.out.println("Invalid song number.");
                      }

                    break;
                case 2: // Ask user for keyword
                    System.out.println("Enter a keyword to search for in song lyrics: ");
                    userInput.nextLine();
                    String keyword = userInput.nextLine().toLowerCase();

                    //Searching in the lyrics
                    System.out.println("Songs containing '" + keyword + "': ");
                    boolean found = false;
                    for (Song song : songs){
                        if(songContainsKeyword(song,keyword)){
                            System.out.println(song.getTitle());
                            found=true;
                        }
                    }
                    if (!found){
                        System.out.println("No songs found containing '"+ keyword + "'.");
                    }
                    break;
                case 3: 
                System.out.println("Goodbye!");
                break;
                default: 
                    System.out.println("Invalid choice. Please try again.");
                }
            }
            userInput.close();

        } catch (IOException e) { e.printStackTrace();}
   
     
    }
private static boolean songContainsKeyword(Song song, String keyword){
    for(String line : song.getLyrics()){
        if(line.toLowerCase().contains(keyword)){
            return true;
        }
    }
    return false;
}
}
