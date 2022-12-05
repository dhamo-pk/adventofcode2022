package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class Day05_1 {

    /*Day 5: Supply Stacks ---
The expedition can depart as soon as the final supplies have been unloaded from the ships. Supplies are stored in stacks of marked crates, but because the needed supplies are buried under many other crates, the crates need to be rearranged.

The ship has a giant cargo crane capable of moving crates between stacks. To ensure none of the crates get crushed or fall over, the crane operator will rearrange them in a series of carefully-planned steps. After the crates are rearranged, the desired crates will be at the top of each stack.

The Elves don't want to interrupt the crane operator during this delicate procedure, but they forgot to ask her which crate will end up where, and they want to be ready to unload them as soon as possible so they can embark.

They do, however, have a drawing of the starting stacks of crates and the rearrangement procedure (your puzzle input). For example:

    [D]
[N] [C]
[Z] [M] [P]
 1   2   3

move 1 from 2 to 1
move 3 from 1 to 3
move 2 from 2 to 1
move 1 from 1 to 2
In this example, there are three stacks of crates. Stack 1 contains two crates: crate Z is on the bottom, and crate N is on top. Stack 2 contains three crates; from bottom to top, they are crates M, C, and D. Finally, stack 3 contains a single crate, P.

Then, the rearrangement procedure is given. In each step of the procedure, a quantity of crates is moved from one stack to a different stack. In the first step of the above rearrangement procedure, one crate is moved from stack 2 to stack 1, resulting in this configuration:

[D]
[N] [C]
[Z] [M] [P]
 1   2   3
In the second step, three crates are moved from stack 1 to stack 3. Crates are moved one at a time, so the first crate to be moved (D) ends up below the second and third crates:

        [Z]
        [N]
    [C] [D]
    [M] [P]
 1   2   3
Then, both crates are moved from stack 2 to stack 1. Again, because crates are moved one at a time, crate C ends up below crate M:

        [Z]
        [N]
[M]     [D]
[C]     [P]
 1   2   3
Finally, one crate is moved from stack 1 to stack 2:

        [Z]
        [N]
        [D]
[C] [M] [P]
 1   2   3
The Elves just need to know which crate will end up on top of each stack; in this example, the top crates are C in stack 1, M in stack 2, and Z in stack 3, so you should combine these together and give the Elves the message CMZ.

After the rearrangement procedure completes, what crate ends up on top of each stack?

Your puzzle answer was LBLVVTVLP.
     */
    public static void main(String[] args) throws IOException {
        Stack<String> sk1 = new Stack<>();
        Stack<String> sk2 = new Stack<>();
        Stack<String> sk3 = new Stack<>();
        Stack<String> sk4 = new Stack<>();
        Stack<String> sk5 = new Stack<>();
        Stack<String> sk6 = new Stack<>();
        Stack<String> sk7 = new Stack<>();
        Stack<String> sk8 = new Stack<>();
        Stack<String> sk9 = new Stack<>();

        sk1.push("W");
        sk1.push("B");
        sk1.push("D");
        sk1.push("N");
        sk1.push("C");
        sk1.push("F");
        sk1.push("J");

        sk2.push("P");
        sk2.push("Z");
        sk2.push("V");
        sk2.push("Q");
        sk2.push("L");
        sk2.push("S");
        sk2.push("T");

        sk3.push("P");
        sk3.push("Z");
        sk3.push("B");
        sk3.push("G");
        sk3.push("J");
        sk3.push("T");

        sk4.push("D");
        sk4.push("T");
        sk4.push("L");
        sk4.push("J");
        sk4.push("Z");
        sk4.push("B");
        sk4.push("H");
        sk4.push("C");

        sk5.push("G");
        sk5.push("V");
        sk5.push("B");
        sk5.push("J");
        sk5.push("S");

        sk6.push("P");
        sk6.push("S");
        sk6.push("Q");

        sk7.push("B");
        sk7.push("V");
        sk7.push("D");
        sk7.push("F");
        sk7.push("L");
        sk7.push("M");
        sk7.push("P");
        sk7.push("N");

        sk8.push("P");
        sk8.push("S");
        sk8.push("M");
        sk8.push("F");
        sk8.push("B");
        sk8.push("D");
        sk8.push("L");
        sk8.push("R");

        sk9.push("V");
        sk9.push("D");
        sk9.push("T");
        sk9.push("R");

        ArrayList<Stack> arrStacks = new ArrayList<>(9);
        arrStacks.add(sk1);
        arrStacks.add(sk2);
        arrStacks.add(sk3);
        arrStacks.add(sk4);
        arrStacks.add(sk5);
        arrStacks.add(sk6);
        arrStacks.add(sk7);
        arrStacks.add(sk8);
        arrStacks.add(sk9);

        File inputFile = new File("src/main/resources/Q5_1_input.txt");
        BufferedReader input = new BufferedReader(new FileReader(inputFile));
        String string, x, y;
        ArrayList<String> moveKeys = new ArrayList<>();
        String[] split;

        while ((string = input.readLine()) != null) {
            moveKeys.add(string);
        }
        input.close();

        String finalValue = performMovement(moveKeys, arrStacks);
        System.out.println("FinalValue:" + finalValue);
    }

    private static String performMovement(ArrayList<String> moveInstructions, ArrayList<Stack> arrStacks) {

        int from = 0;
        int to = 0;
        int nos = 0;
        String[] insStr = null;
        String temp = null;
        for (String ins : moveInstructions) {
            insStr = ins.split("[\n\r\s]+");
            nos = Integer.parseInt(insStr[1]);
            from = Integer.parseInt(insStr[3]) - 1;
            to = Integer.parseInt(insStr[5]) - 1;
            for (int a = 0; a < nos; a++) {
                temp = arrStacks.get(from).get(arrStacks.get(from).size() - 1).toString();
                arrStacks.get(from).pop();
                arrStacks.get(to).push(temp);
            }
        }
        String finalValue = "";
        for (int x = 0; x < arrStacks.size(); x++) {
            finalValue = finalValue + arrStacks.get(x).get(arrStacks.get(x).size() - 1);
        }
        return finalValue;
    }
}
