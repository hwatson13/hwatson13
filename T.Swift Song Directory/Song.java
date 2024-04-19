import java.util.ArrayList;
import java.util.List;
import java.util.*;
class Song{

    private String title;
    private ArrayList<String> lyrics;

    public Song(String title){
        this.title=title;
        this.lyrics= new ArrayList<>();
    }
    public String getTitle(){
        return title;
    }
    public void addLine(String line){
        this.lyrics.add(line);
    }
    public ArrayList<String> getLyrics(){
        return lyrics;
    }
    @Override 
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Title: ").append(title).append("\n");
        builder.append("Lyrics: \n");
        for (String line : lyrics){
            builder.append(line).append("\n");
        }
        return builder.toString();
    }
    public String toString(String title){
        StringBuilder builder = new StringBuilder();
        builder.append("Lyrics: \n");
        for (String line : lyrics){
            builder.append(line).append("\n");
        }
        return builder.toString();
    }
}