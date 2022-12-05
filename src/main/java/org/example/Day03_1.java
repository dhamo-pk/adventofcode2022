package org.example;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Day03_1 {
    public static void main(String[] args) throws IOException {

        File inputFile = new File("src/main/resources/Q3_1_input.txt");

        Scanner sc = new Scanner(inputFile);
        sc.useDelimiter("\\Z");
        String aa = sc.next();
        List<String> actualValue = List.of(aa.split(System.lineSeparator()));

        int sum = 0;
        for (String str : actualValue) {
            sum = sum + makeCalculation(str);
        }
        System.out.println("Sum is " + sum);
    }

    private static int makeCalculation(String value) {
        int priorityValue = 0;
        int len = value.length();
        String firstHalf = value.substring(0, len / 2);
        String secondHalf = value.substring(len / 2);

        char temp = 0;

        char[] fhAsChars = firstHalf.toCharArray();
        char[] shAsChars = secondHalf.toCharArray();

        for (char f : fhAsChars) {
            if (secondHalf.contains(String.valueOf(f))) {
                System.out.println("Found:" + f + " in the string:" + value);
                temp = f;
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
/*
Day 3: Rucksack Reorganization ---
        One Elf has the important job of loading all of the rucksacks with supplies for the jungle journey. Unfortunately, that Elf didn't quite follow the packing instructions, and so a few items now need to be rearranged.

        Each rucksack has two large compartments. All items of a given type are meant to go into exactly one of the two compartments. The Elf that did the packing failed to follow this rule for exactly one item type per rucksack.

        The Elves have made a list of all of the items currently in each rucksack (your puzzle input), but they need your help finding the errors. Every item type is identified by a single lowercase or uppercase letter (that is, a and A refer to different types of items).

        The list of items for each rucksack is given as characters all on a single line. A given rucksack always has the same number of items in each of its two compartments, so the first half of the characters represent items in the first compartment, while the second half of the characters represent items in the second compartment.

        For example, suppose you have the following list of contents from six rucksacks:

        vJrwpWtwJgWrhcsFMMfFFhFp
        jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
        PmmdzqPrVvPwwTWBwg
        wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
        ttgJtRGJQctTZtZT
        CrZsJsPPZsGzwwsLwLmpwMDw
        The first rucksack contains the items vJrwpWtwJgWrhcsFMMfFFhFp, which means its first compartment contains the items vJrwpWtwJgWr, while the second compartment contains the items hcsFMMfFFhFp. The only item type that appears in both compartments is lowercase p.
        The second rucksack's compartments contain jqHRNqRjqzjGDLGL and rsFMfFZSrLrFZsSL. The only item type that appears in both compartments is uppercase L.
        The third rucksack's compartments contain PmmdzqPrV and vPwwTWBwg; the only common item type is uppercase P.
        The fourth rucksack's compartments only share item type v.
        The fifth rucksack's compartments only share item type t.
        The sixth rucksack's compartments only share item type s.
        To help prioritize item rearrangement, every item type can be converted to a priority:

        Lowercase item types a through z have priorities 1 through 26.
        Uppercase item types A through Z have priorities 27 through 52.
        In the above example, the priority of the item type that appears in both compartments of each rucksack is 16 (p), 38 (L), 42 (P), 22 (v), 20 (t), and 19 (s); the sum of these is 157.

        Find the item type that appears in both compartments of each rucksack. What is the sum of the priorities of those item types?*/
