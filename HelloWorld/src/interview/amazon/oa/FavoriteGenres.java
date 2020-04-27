package interview.amazon.oa;

import java.util.*;

/**
 * Given a map Map<String, List<String>> userSongs with user names as keys and a list of all the songs that the user has listened to as values.
 * <p>
 * Also given a map Map<String, List<String>> songGenres, with song genre as keys and a list of all the songs within that genre as values. The song can only belong to only one genre.
 * <p>
 * The task is to return a map Map<String, List<String>>, where the key is a user name and the value is a list of the user's favorite genre(s). Favorite genre is the most listened to genre. A user can have more than one favorite genre if he/she has listened to the same number of songs per each of the genres.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * userSongs = {
 * "David": ["song1", "song2", "song3", "song4", "song8"],
 * "Emma":  ["song5", "song6", "song7"]
 * },
 * songGenres = {
 * "Rock":    ["song1", "song3"],
 * "Dubstep": ["song7"],
 * "Techno":  ["song2", "song4"],
 * "Pop":     ["song5", "song6"],
 * "Jazz":    ["song8", "song9"]
 * }
 * <p>
 * Output: {
 * "David": ["Rock", "Techno"],
 * "Emma":  ["Pop"]
 * }
 * <p>
 * Explanation:
 * David has 2 Rock, 2 Techno and 1 Jazz song. So he has 2 favorite genres.
 * Emma has 2 Pop and 1 Dubstep song. Pop is Emma's favorite genre.
 * Example 2:
 * <p>
 * Input:
 * userSongs = {
 * "David": ["song1", "song2"],
 * "Emma":  ["song3", "song4"]
 * },
 * songGenres = {}
 * <p>
 * Output: {
 * "David": [],
 * "Emma":  []
 * }
 */
public class FavoriteGenres {
    //a(user) b(songs per person)
    //c(genre) d(songs per genre)
    // O(cd) + O(ab) + O(ac)
    public Map<String, List<String>> favorite(Map<String, List<String>> userSongs, Map<String, List<String>> songGenres) {
        Map<String, List<String>> res = new HashMap<>();
        if (userSongs == null) return res;
        Map<String, String> songToGenres = new HashMap<>();
        for (Map.Entry<String, List<String>> e : songGenres.entrySet()) {
            String genre = e.getKey();
            for (String s : e.getValue()) {
                songToGenres.put(s, genre);
            }
        }

        for (Map.Entry<String, List<String>> e : userSongs.entrySet()) {
            Map<String, Integer> count = new HashMap<>();
            int max = 0;
            for (String song : e.getValue()) {
                String genre = songToGenres.get(song);
                if (!count.containsKey(genre)) {
                    count.put(genre, 0);
                }
                count.put(genre, count.get(genre) + 1);
                max = Math.max(max, count.get(genre));
            }
            res.put(e.getKey(), new ArrayList<>());
            List<String> genres = res.get(e.getKey());
            for (Map.Entry<String, Integer> genreCount : count.entrySet()) {
                if (genreCount.getValue() == max)
                    genres.add(genreCount.getKey());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FavoriteGenres favoriteGenres = new FavoriteGenres();
//  Input:
//  userSongs = {
//  "David": ["song1", "song2", "song3", "song4", "song8"],
//  "Emma":  ["song5", "song6", "song7"]
//  },
//  songGenres = {
//  "Rock":    ["song1", "song3"],
//  "Dubstep": ["song7"],
//  "Techno":  ["song2", "song4"],
//  "Pop":     ["song5", "song6"],
//  "Jazz":    ["song8", "song9"]
//  }
//  Output: {
//  "David": ["Rock", "Techno"],
//  "Emma":  ["Pop"]
        Map<String, List<String>> userSongs1 = new HashMap<>();
        List<String> list1 = Arrays.asList("song1", "song2", "song3", "song4", "song8");
        List<String> list2 = Arrays.asList("song5", "song6", "song7");
        userSongs1.put("David", list1);
        userSongs1.put("Emma", list2);

        Map<String, List<String>> songGenres1 = new HashMap<>();
        List<String> list3 = Arrays.asList("song1", "song3");
        List<String> list4 = Arrays.asList("song7");
        List<String> list5 = Arrays.asList("song2", "song4");
        List<String> list6 = Arrays.asList("song5", "song6");
        List<String> list7 = Arrays.asList("song8", "song9");
        songGenres1.put("Rock", list3);
        songGenres1.put("Dubstep", list4);
        songGenres1.put("Techno", list5);
        songGenres1.put("Pop", list6);
        songGenres1.put("Jazz", list7);

        System.out.println(favoriteGenres.favorite(userSongs1, songGenres1));

        /*Map<String, List<String>> userMap = new HashMap<>();
		List<String> list1 = Arrays.asList("song1", "song2");
		List<String> list2 = Arrays.asList("song3", "song4");
		userMap.put("David", list1);
		userMap.put("Emma", list2);

		Map<String, List<String>> genreMap = new HashMap<>();*/


    }
}
