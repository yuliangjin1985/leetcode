package amazon;

import java.util.*;

public class PrimeAir {
    public List<int[]> get(List<int[]> forward, List<int[]> returnList, int maxDist) {
        int min = maxDist;
        List<int[]> list = new ArrayList<>();
        for(int[] f : forward) {
            for(int[] ret : returnList) {
                int total = f[1] + ret[1];
                if(maxDist - total >= 0 && maxDist - total < min) {
                    list.clear();
                    list.add(new int[]{f[0], ret[0]});
                } else if(maxDist - total >= 0 && maxDist - total == min) {
                    list.add(new int[]{f[0], ret[0]});
                }
            }
        }
        return list;
    }

    public List<List<Integer>> optimalUtilization(int maxTravelDist, List<List<Integer>> forwardRouteList, List<List<Integer>> returnRouteList) {
        Map<Integer, List<Integer>> forwardMap = new HashMap<>();
        Map<Integer, List<Integer>> retMap = new HashMap<>();
        List<List<Integer>> list = new LinkedList<>();
        for (List<Integer> fwd : forwardRouteList) {
            forwardMap.putIfAbsent(fwd.get(1), new LinkedList<>());
            forwardMap.get(fwd.get(1)).add(fwd.get(0));
        }

        for (List<Integer> retRoute : returnRouteList) {
            retMap.putIfAbsent(retRoute.get(1), new LinkedList<>());
            retMap.get(retRoute.get(1)).add(retRoute.get(0));
        }

        int min = maxTravelDist;

        for(int from : forwardMap.keySet()) {
            for(int to : retMap.keySet()) {
                int total = from + to;
                if(total <= maxTravelDist && maxTravelDist - total <= min) {
                    if(maxTravelDist - total < min) {
                        list.clear();
                        min = maxTravelDist - total;
                    }
                    for (Integer a : forwardMap.get(from)) {
                        for(Integer b : retMap.get(to)) {
                            LinkedList<Integer> pair = new LinkedList<>();
                            pair.add(a);
                            pair.add(b);
                            list.add(pair);
                        }

                    }
                }
            }
        }
        return list;
    }

    public static void main1(String[] args) {
        PrimeAir primeAir = new PrimeAir();
        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();
        LinkedList<Integer> l3 = new LinkedList<>();
        LinkedList<Integer> l4 = new LinkedList<>();
        LinkedList<List<Integer>> l5 = new LinkedList<>();
        LinkedList<List<Integer>> r5 = new LinkedList<>();
        l1.add(1);
        l1.add(3000);
        l2.add(2);
        l2.add(5000);
        l3.add(3);
        l3.add(7000);
        l4.add(4);
        l4.add(10000);
        l5.add(l1);
        l5.add(l2);
        l5.add(l3);
        l5.add(l4);
        LinkedList<Integer> r1 = new LinkedList<>();
        LinkedList<Integer> r2 = new LinkedList<>();
        LinkedList<Integer> r3 = new LinkedList<>();
        LinkedList<Integer> r4 = new LinkedList<>();
        r1.add(1);
        r1.add(2000);
        r2.add(2);
        r2.add(3000);
        r3.add(3);
        r3.add(4000);
        r4.add(4);
        r4.add(5000);
        r5.add(r1);
        r5.add(r2);
        r5.add(r3);
        r5.add(r4);
        List<List<Integer>> lists = primeAir.optimalUtilization(10000, l5, r5);
        for (List<Integer> list : lists) {
            System.out.println();
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
        }
    }

    public static void main(String[] args) {
        PrimeAir primeAir = new PrimeAir();
        List<String> s = new LinkedList<>();
        s.add("ab kindle booka");
        s.add("cd kindle book");
        s.add("cd 12 45");
        s.add("ad kindle book");
        List<String> strings = primeAir.prioritizedOrder(3, s);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public List<String> prioritizedOrder(int numOrders, List<String> orderList) {
        List<String> list = new LinkedList<>();
        List<String> nums = new LinkedList<>();
        List<String> primes = new LinkedList<>();
        for (String s : orderList) {
            if(isPrime(s)) {
                primes.add(s);
            } else {
                nums.add(s);
            }
        }

        Collections.sort(primes, (a, b) -> {
            String[] first = a.split(" ");
            String[] second = b.split(" ");
            String s1 = "";
            String s2 = "";
            for(int i=1;i<first.length;i++) {
                s1 += first[i];
            }
            for(int i=1;i<second.length;i++) {
                s2 += second[i];
            }

            if(s1.compareTo(s2) == 0) {
                return first[0].compareTo(second[0]);
            }
            return s1.compareTo(s2);
        });

        for (String prime : primes) {
            list.add(prime);
        }

        for (String num : nums) {
            list.add(num);
        }
        return list;
    }

    public boolean isPrime(String s) {
        String[] strings = s.split(" ");
        char[] chars = strings[1].toCharArray();
        for (char aChar : chars) {
            if(aChar < '0' || aChar > '9') {
                return true;
            }
        }
        return false;
    }
}
