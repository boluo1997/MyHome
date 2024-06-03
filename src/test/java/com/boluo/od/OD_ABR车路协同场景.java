package com.boluo.od;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author chao
 * @datetime 2024-06-03 22:28
 * @description
 */
public class OD_ABR车路协同场景 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Matcher matcher = Pattern.compile("A=\\{(.+)},B=\\{(.+)},R=(.+)").matcher(str);
        if (matcher.find()) {
            int A[] = Arrays.stream(matcher.group(1).split(",")).mapToInt(Integer::parseInt).toArray();
            int B[] = Arrays.stream(matcher.group(2).split(",")).mapToInt(Integer::parseInt).toArray();
            int R = Integer.parseInt(matcher.group(3));
            System.out.println(func(A, B, R));
        }

    }

    private static String func(int A[], int B[], int R) {
        StringBuilder sb = new StringBuilder();
        for (int a : A) {
            int count = 0;
            for (int b : B) {
                if (b < a) {
                    continue;
                }
                if (b - a <= R || count == 0) {
                    sb.append(String.format("(%d,%d)", a, b));
                    count++;
                } else {
                    break;
                }
            }
        }
        return sb.toString();
    }
}
