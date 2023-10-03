package com.github.curriculeon;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainApplication {
    public static void main(String[] args) {
        Runnable myObject = new MyObject();
        myObject.run();
    }

    public Integer counterFunction(int[] someArray, int valueToSeek) {
        return Collections.frequency(IntStream
                .of(someArray)
                .boxed()
                .collect(Collectors.toList()), valueToSeek);
    }




    public int count(int[] arr1, int[] arr2, int valueToSeek) {
        int result = 0;
        if (arr1.length == arr2.length) {
            for (int i = 0; i < arr1.length; i++) {
                int i1 = arr1[i];
                int i2 = arr2[i];
                if (i1 == valueToSeek) {
                    result++;
                }
                if (i2 == valueToSeek) {
                    result++;
                }
            }
        } else {
            Function<int[], Integer> counterFunction = (int[] someArray) -> {
                return Collections.frequency(IntStream
                        .of(someArray)
                        .boxed()
                        .collect(Collectors.toList()), valueToSeek);
            };
            result = counterFunction(arr1, valueToSeek) + counterFunction(arr2, valueToSeek);
        }
        return result;
    }
}
