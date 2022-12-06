package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day06_2 {
    static String input = null;

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("src/main/resources/Q6_1_input.txt");
        Scanner sc = new Scanner(inputFile);
        sc.useDelimiter("\\Z");
        input = sc.next();
        char[] temp = new char[0];
        int NoOfChars = 14;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            temp = input.substring(i, i + NoOfChars).toCharArray();
            if (isUnique(temp)) {
                System.out.printf("Ans: %s", i + NoOfChars);
                break;
            }
        }
    }

    private static boolean isUnique(char[] charArray) {
        Set<Character> cSet = new HashSet<>();
        for (char c : charArray) {
            cSet.add(c);
        }
        return charArray.length == cSet.size();
    }
}

/*


--- Part Two ---
Your device's communication system is correctly detecting packets, but still isn't working. It looks like it also needs to look for messages.

A start-of-message marker is just like a start-of-packet marker, except it consists of 14 distinct characters rather than 4.

Here are the first positions of start-of-message markers for all of the above examples:

mjqjpqmgbljsphdztnvjfqwrcgsmlb: first marker after character 19
bvwbjplbgvbhsrlpgdmjqwftvncz: first marker after character 23
nppdvjthqldpwncqszvftbrmjlhg: first marker after character 23
nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg: first marker after character 29
zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw: first marker after character 26
How many characters need to be processed before the first start-of-message marker is detected?

Your puzzle answer was 3256.


 */
