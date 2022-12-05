package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class Day05_2 {
    /*
               [C]         [N] [R]    
   [J] [T]     [H]         [P] [L]    
   [F] [S] [T] [B]         [M] [D]    
   [C] [L] [J] [Z] [S]     [L] [B]    
    [N] [Q] [G] [J] [J]     [F] [F] [R]
   [D] [V] [B] [L] [B] [Q] [D] [M] [T]
   [B] [Z] [Z] [T] [V] [S] [V] [S] [D]
   [W] [P] [P] [D] [G] [P] [B] [P] [V]
    1   2   3   4   5   6   7   8   9 
     */
    public static void main(String[] args) throws IOException {
        Stack<String> sk1 = new Stack();
        Stack<String> sk2 = new Stack();
        Stack<String> sk3 = new Stack();
        Stack<String> sk4 = new Stack();
        Stack<String> sk5 = new Stack();
        Stack<String> sk6 = new Stack();
        Stack<String> sk7 = new Stack();
        Stack<String> sk8 = new Stack();
        Stack<String> sk9 = new Stack();

        Stack<String> exSk1 = new Stack();
        Stack<String> exSk2 = new Stack();
        Stack<String> exSk3 = new Stack();

        exSk1.push("Z");
        exSk1.push("N");

        exSk2.push("M");
        exSk2.push("C");
        exSk2.push("D");

        exSk3.push("P");


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

        ArrayList<Stack> arrStacks = new ArrayList<>(3);
        arrStacks.add(exSk1);
        arrStacks.add(exSk2);
        arrStacks.add(exSk3);

        ArrayList<Stack> arrStacks1 = new ArrayList<>(9);
        arrStacks1.add(sk1);
        arrStacks1.add(sk2);
        arrStacks1.add(sk3);
        arrStacks1.add(sk4);
        arrStacks1.add(sk5);
        arrStacks1.add(sk6);
        arrStacks1.add(sk7);
        arrStacks1.add(sk8);
        arrStacks1.add(sk9);

        File inputFile = new File("src/main/resources/Q5_1_input.txt");
        BufferedReader input = new BufferedReader(new FileReader(inputFile));
        String string, x, y;
        ArrayList<String> moveKeys = new ArrayList<>();
        String[] split;

        while ((string = input.readLine()) != null) {
            moveKeys.add(string);
        }
        input.close();

        /*move 1 from 2 to 1
        move 3 from 1 to 3
        move 2 from 2 to 1
        move 1 from 1 to 2*/
        String finalValue = performMovement(moveKeys, arrStacks1);
        System.out.println("FinalValue:" + finalValue);
        //1ST HWSVNZNDS
    }

    private static String performMovement(ArrayList<String> moveInstructions, ArrayList<Stack> arrStacks) {

        int from = 0;
        int to = 0;
        int nos = 0;
        String[] insStr = null;
        String temp, temp2 = null;
        for (String ins : moveInstructions) {
            System.out.println(ins);
            insStr = ins.split("[\n\r\s]+");

            nos = Integer.parseInt(insStr[1]);
            from = Integer.parseInt(insStr[3]) - 1;
            to = Integer.parseInt(insStr[5]) - 1;

            Stack<String> tempStack = new Stack<>();
            for (int a = 0; a < nos; a++) {
                temp = arrStacks.get(from).get(arrStacks.get(from).size() - 1).toString();
                arrStacks.get(from).pop();
                tempStack.push(temp);
                System.out.println("----");
                System.out.println(arrStacks);
            }

            for (int a = 0; a < nos; a++) {
                temp2 = tempStack.get(tempStack.size() - 1).toString();

                tempStack.pop();
                arrStacks.get(to).push(temp2);
                System.out.println("----");
                System.out.println(arrStacks);
            }

        }
              String finalValue= "";
        for(int x= 0; x<arrStacks.size();x++) {
           finalValue = finalValue + arrStacks.get(x).get(arrStacks.get(x).size()-1);
        }                                                             

        return finalValue;
    }
}
