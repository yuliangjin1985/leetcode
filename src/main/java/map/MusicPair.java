package map;

import java.util.HashMap;
import java.util.Map;

public class MusicPair {
    int getNum(int[] songs) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int song : songs) {
            map.put(song, map.getOrDefault(song, 0) + 1);
        }

        int count = 0;
        for(int song : map.keySet()) {
            if(song > 0 && map.get(song) > 1 && song * 2 % 60 == 0) {
                int c = map.get(song);
                count += c * (c-1) / 2;
            }

            for(int so : map.keySet()) {
                if(so == song) continue;
                if((song + so) % 60 == 0) {
                    int c1 = map.get(song);
                    int c2 = map.get(so);
                    count += c1 * c2;
                }
            }

            map.put(song, 0);
        }
        return count;
    }

    public static void main(String[] args) {
        MusicPair musicPair = new MusicPair();
        System.out.println(musicPair.getNum(new int[]{10,50,90,30}));
    }
}
