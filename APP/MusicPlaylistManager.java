import java.util.*;

class SongNode {
    String title;
    SongNode prev, next;

    SongNode(String title) {
        this.title = title;
        this.prev = this.next = null;
    }
}

class Playlist {
    private SongNode head, tail, current;

    // Add a new song
    public void addSong(String title) {
        SongNode newSong = new SongNode(title);
        if (head == null) {
            head = tail = current = newSong;
        } else {
            tail.next = newSong;
            newSong.prev = tail;
            tail = newSong;
        }
        System.out.println(" Added: " + title);
    }

    // Remove song by title
    public void removeSong(String title) {
        SongNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                if (temp.prev != null) temp.prev.next = temp.next;
                else head = temp.next;

                if (temp.next != null) temp.next.prev = temp.prev;
                else tail = temp.prev;

                if (current == temp) {
                    current = (temp.next != null) ? temp.next : temp.prev;
                }

                System.out.println(" Removed: " + title);
                return;
            }
            temp = temp.next;
        }
        System.out.println(" Song not found: " + title);
    }

    // Play current song
    public void playCurrent() {
        if (current != null) {
            System.out.println(" Playing: " + current.title);
        } else {
            System.out.println(" No song in playlist.");
        }
    }

    // Play next song
    public void playNext() {
        if (current != null && current.next != null) {
            current = current.next;
            playCurrent();
        } else {
            System.out.println(" No next song.");
        }
    }

    // Play previous song
    public void playPrevious() {
        if (current != null && current.prev != null) {
            current = current.prev;
            playCurrent();
        } else {
            System.out.println(" No previous song.");
        }
    }

    // Shuffle to random song
    public void shuffleSong() {
        List<SongNode> songs = new ArrayList<>();
        SongNode temp = head;
        while (temp != null) {
            songs.add(temp);
            temp = temp.next;
        }
        if (songs.isEmpty()) {
            System.out.println(" Playlist is empty.");
            return;
        }
        Random rand = new Random();
        current = songs.get(rand.nextInt(songs.size()));
        playCurrent();
    }

    // Show all songs
    public void showPlaylist() {
        if (head == null) {
            System.out.println(" Playlist is empty.");
            return;
        }
        System.out.println(" Songs in Playlist:");
        SongNode temp = head;
        while (temp != null) {
            if (temp == current) {
                System.out.println(" " + temp.title + " (current)");
            } else {
                System.out.println("   " + temp.title);
            }
            temp = temp.next;
        }
    }
}

public class MusicPlaylistManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Playlist playlist = new Playlist();
        int choice;

        do {
            System.out.println("\n=====  Music Playlist Manager =====");
            System.out.println("1. Add Song");
            System.out.println("2. Remove Song");
            System.out.println("3. Play Current");
            System.out.println("4. Play Next");
            System.out.println("5. Play Previous");
            System.out.println("6. Shuffle Song");
            System.out.println("7. Show Playlist");
            System.out.println("0. Exit");
            System.out.print(" Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter song title: ");
                    String title = sc.nextLine();
                    playlist.addSong(title);
                    break;
                case 2:
                    System.out.print("Enter song title to remove: ");
                    String removeTitle = sc.nextLine();
                    playlist.removeSong(removeTitle);
                    break;
                case 3:
                    playlist.playCurrent();
                    break;
                case 4:
                    playlist.playNext();
                    break;
                case 5:
                    playlist.playPrevious();
                    break;
                case 6:
                    playlist.shuffleSong();
                    break;
                case 7:
                    playlist.showPlaylist();
                    break;
                case 0:
                    System.out.println(" Exiting Playlist Manager...");
                    break;
                default:
                    System.out.println(" Invalid choice!");
            }
        } while (choice != 0);

        sc.close();
    }
} 

