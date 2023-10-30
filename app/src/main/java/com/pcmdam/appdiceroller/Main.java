package com.pcmdam.appdiceroller;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int size = scanner.nextInt();
            if (size == 0) {
                break;
            }

            int[] s = new int[size];

            for (int i = 0; i < size; i++) {
                int num = scanner.nextInt();
                s[i] = num;
            }

            Arrays.sort(s);

            int middle = size / 2;

            if (size % 2 == 0) {
                System.out.println(s[middle - 1] + s[middle]);
            } else {
                System.out.println(s[middle] * 2);
            }
        }
    }
}


