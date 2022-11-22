package org.example;

import java.util.*;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toMap;

public class Solution {

    public Solution(){

    }

    public int[] KWeakestRows(int[][] mat, int k) {

        int[] weakestRows;

        Map<Integer,Integer> rowPower = new HashMap<>();

        int power = 0;

        for(int i = 0;i< mat.length;i++){
            for (int j = 0; j<mat[i].length; j++){
                power += mat[i][j];
            }
            rowPower.put(i,power);
            power = 0;
        }
        Map<Integer, Integer> sortedMap = rowPower.entrySet().stream()
                .sorted(comparingInt(Map.Entry::getValue))
                .limit(k)
                .collect(toMap(Map.Entry::getKey,Map.Entry::getValue,
                        (a, b) -> { throw new AssertionError();},
                        LinkedHashMap::new
                ));

        Set<Integer> keys = sortedMap.keySet();

        weakestRows = new int[keys.size()];

        int index = 0;
        for(Integer element : keys) weakestRows[index++] = element;

        return weakestRows;
    }
}