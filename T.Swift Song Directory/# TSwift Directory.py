# TSwift Directory
class Song:
    def __init__(self, title):
        self.title=title
        self.lyrics = []
    
    def add_line(self, line):
        self.lyrics.append(line)

    def __str__(self):
        return '\n'.join(self.lyrics)
    
def read_data(filename):
    with open(filename, 'r') as file:
        return file.read()
    
def main():
    try:
        data = read_data("data.txt")
        songs = []
        current_song = None

        for line in data.split('\n'):
            line = line.strip()
            if line.startswith("\""):
                if current_song is not None:
                    songs.append(current_song)
                if "\"" in line:
                    title_start = line.find("\"") + 1
                    title_end = line.find("\"", title_start)
                    if title_end != -1:
                        title = line[title_start:title_end]
                    else:
                        print("Error: Closing quote not found for title in line:", line)
                else:
                    print("Error: Double quote not found in line:", line)
                current_song = Song(title)
            elif current_song is not None:
                current_song.add_line(line)

        if current_song is not None:
                songs.append(current_song)

        while True:
            print("Welcome to the Swift Song Database!")
            print("1. View avaiable songs and their lyrics")
            print("2. Search for songs containing a keyword in lyrics")
            print("3. Exit")
            choice = int(input("Enter your choice: "))

            if choice ==1:
                print("Available songs: ")
                for i, song in enumerate(songs):
                    print(f"{i+1}. {song.title}")
                
                song_index = int(input("Enter the number of the song you want to view lyrics for: "))
                if 0 < song_index <= len(songs):
                    print(f"Lyrics for {songs[song_index - 1].title}:")
                    print(songs[song_index - 1])
                else :
                    print("Invalid song number.")
            elif choice == 2:
                keyword = input("Enter a keyword to search for in the lyrics index: ").lower()

                print(f"Songs containing '{keyword}':")
                found = False
                for song in songs:
                    if any(keyword in line.lower() for line in song.lyrics):
                        print(song.title)
                        found = True
                if not found:
                    print(f"No songs found containing '{keyword}'")
            elif choice == 3:
                print("Goodbye!")
                break
            else:
                print("Invalid choice, Please try again.")
    except IOError as e:
        print(e)
if __name__ == "__main__":
    main()

