package contest.d03142020;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UndergroundSystem {
    Map<Integer, String> cinStation = new HashMap<>();
    Map<Integer, Integer> cinTime = new HashMap<>();
    Map<String, List<Integer>> time = new HashMap<>();
    Map<String, Double> avg = new HashMap<>();

    public UndergroundSystem() {

    }

    public void checkIn(int id, String sn, int t) {
        cinStation.put(id, sn);
        cinTime.put(id, t);
    }

    public void checkOut(int id, String name, int t) {
        String from = cinStation.remove(id);
        int start = cinTime.remove(id);
        List<Integer> l = time.getOrDefault(from + name, new LinkedList<>());
        l.add(t - start);
        time.put(from + name, l);
        String newName = from + name;
        avg.put(newName, avg.getOrDefault(newName, 0.0) + t-start);
    }

    public double getAverageTime(String s, String e) {
        return avg.get(s+e) / time.get(s+e).size();

    }

    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);
        System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge"));       // return 14.0. There was only one travel from "Paradise" (at time 8) to "Cambridge" (at time 22)
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));          // return 11.0. There were two travels from "Leyton" to "Waterloo", a customer with id=45 from time=3 to time=15 and a customer with id=27 from time=10 to time=20. So the average time is ( (15-3) + (20-10) ) / 2 = 11.0
        undergroundSystem.checkIn(10, "Leyton", 24);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));          // return 11.0
        undergroundSystem.checkOut(10, "Waterloo", 38);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));          // return 12.0
    }
}
