package songboard;

import java.util.Comparator;

public class SongEntryComparator implements Comparator<SongEntry> {
    /** Compares two strings according to their lengths. */
    public int compare(SongEntry a, SongEntry b) {
        if (a.rank < b.rank) return -1;
        else if (a.rank == b.rank) return 0;
        else return 1;
    }
}

