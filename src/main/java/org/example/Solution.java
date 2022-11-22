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
        weakestRows= rowPower.entrySet().stream()
                .sorted(comparingInt(Map.Entry::getValue))
                .limit(k)
                .map(Map.Entry::getKey)
                .mapToInt(x -> x)
                .toArray();

        return weakestRows;
    }
}