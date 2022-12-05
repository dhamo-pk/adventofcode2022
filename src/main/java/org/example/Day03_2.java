package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Day03_2 {
    public static void main(String[] args) throws FileNotFoundException {

        File inputFile = new File("src/main/resources/Q3_2_input.txt");
        Scanner sc = new Scanner(inputFile);
        sc.useDelimiter("\\Z");
        String aa = sc.next();
        List<String> allContents = Arrays.stream(aa.split("\n")).collect(Collectors.toList());

        List<String> finalContent = makeSubList(allContents);
        allContents.size();
        finalContent.size();

        int sum = 0;
        for (String str : finalContent) {
            sum = sum + makeCalculation(str);
        }
        System.out.println("Sum is " + sum);
    }

    private static List<String> makeSubList(List<String> allContents) {
        List<String> temp = new ArrayList<>();
        List<String> finalList = new ArrayList<>();
        int size = allContents.size();
        for (int a = 0; a < size - 2; a++) {
            if (a % 3 == 0) {
                temp.add(allContents.get(a) + System.lineSeparator() + allContents.get(a + 1) + System.lineSeparator() + allContents.get(a + 2));
                finalList.addAll(temp);
                temp.clear();
                System.out.println(a);
                System.out.println(size);
            }
        }
        return finalList;
    }

    private static int makeCalculation(String value) {
        int priorityValue = 0;
        int len = value.length();
        List<String> listOfStrings = Arrays.stream(value.split("\n")).collect(Collectors.toList());

        System.out.println(listOfStrings);
        char[] first = listOfStrings.get(0).toCharArray();

        char temp = 0;
        for (char c : first) {
            if (listOfStrings.get(1).contains(String.valueOf(c)) && listOfStrings.get(2).contains(String.valueOf(c))) {
                System.out.println("Found:" + c + " as common in :" + listOfStrings);
                temp = c;
                break;
            }
        }
        if (Character.isUpperCase(temp)) {
            //27-52
            priorityValue = temp - 'A' + 27;
            System.out.println(temp - 'A' + 27);
        } else {
            //1-26
            priorityValue = temp - 'a' + 1;
            System.out.println(temp - 'a' + 1);
        }
        return priorityValue;
    }
}

/**
 * --- Part Two ---
 * As you finish identifying the misplaced items, the Elves come to you with another issue.
 * <p>
 * For safety, the Elves are divided into groups of three. Every Elf carries a badge that identifies their group. For efficiency, within each group of three Elves, the badge is the only item type carried by all three Elves. That is, if a group's badge is item type B, then all three Elves will have item type B somewhere in their rucksack, and at most two of the Elves will be carrying any other item type.
 * <p>
 * The problem is that someone forgot to put this year's updated authenticity sticker on the badges. All of the badges need to be pulled out of the rucksacks so the new authenticity stickers can be attached.
 * <p>
 * Additionally, nobody wrote down which item type corresponds to each group's badges. The only way to tell which item type is the right one is by finding the one item type that is common between all three Elves in each group.
 * <p>
 * Every set of three lines in your list corresponds to a single group, but each group can have a different badge item type. So, in the above example, the first group's rucksacks are the first three lines:
 * <p>
 * vJrwpWtwJgWrhcsFMMfFFhFp
 * jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
 * PmmdzqPrVvPwwTWBwg
 * And the second group's rucksacks are the next three lines:
 * <p>
 * wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
 * ttgJtRGJQctTZtZT
 * CrZsJsPPZsGzwwsLwLmpwMDw
 * In the first group, the only item type that appears in all three rucksacks is lowercase r; this must be their badges. In the second group, their badge item type must be Z.
 * <p>
 * Priorities for these items must still be found to organize the sticker attachment efforts: here, they are 18 (r) for the first group and 52 (Z) for the second group. The sum of these is 70.
 * <p>
 * Find the item type that corresponds to the badges of each three-Elf group. What is the sum of the priorities of those item types?
 */