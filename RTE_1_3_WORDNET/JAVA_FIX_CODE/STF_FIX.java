import java.io.*;
import java.math.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class STF_FIX {
	public static void checkFix() throws Exception {
		BufferedReader reader_t = new BufferedReader(new FileReader("H_FIX.txt"));
		String tempString = null; boolean left = false; int position = 0;
		while ((tempString = reader_t.readLine()) != null) {
			String tempT = "";
			for (int i = 0; i < tempString.length(); i++) {
				if (tempString.charAt(i) == ')') left = false;
				if (left && tempString.charAt(i) == '(') {
					for (int j = position+1; j < i; j++) tempT += tempString.charAt(j);
					System.out.println("wrong: " + tempT);System.out.println(i);
					tempT = ""; position = i;
				}
				if ((!left) && tempString.charAt(i) == '(') {
					left = true;
					position = i;
				}
			}
		}
		reader_t.close();
	}
	public static void main(String[] args) throws Exception {
		BufferedReader reader_t = new BufferedReader(new FileReader("H_STF.txt"));
        FileWriter writer_t = new FileWriter("H_FIX.txt", true);
        String tempString = null; boolean right = false;
        while ((tempString = reader_t.readLine()) != null) {
			String tempT = "";
			for (int i = 0; i < tempString.length(); i++) {
				if (tempString.charAt(i) == '(' && tempString.charAt(i+1) == 'R' &&
					tempString.charAt(i+2) == 'O' && tempString.charAt(i+3) == 'O' &&
					tempString.charAt(i+4) == 'T') {
					i += 5; continue;
				} else if (tempString.charAt(i) == '(' && tempString.charAt(i+1) == 'S' &&
					tempString.charAt(i+2) == ' ') {
					i += 2; continue;
				} else if (tempString.charAt(i) == '(' && tempString.charAt(i+1) == 'X' &&
					tempString.charAt(i+2) == ' ') {
					i += 2; continue;
				} else if (tempString.charAt(i) == '(' && tempString.charAt(i+1) == 'N' &&
					tempString.charAt(i+2) == 'X' && tempString.charAt(i+3) == ' ') {
					i += 3; continue;
				} else if (tempString.charAt(i) == '(' && tempString.charAt(i+1) == 'S' &&
					tempString.charAt(i+2) == 'Q' && tempString.charAt(i+3) == ' ') {
					i += 3; continue;
				} else if (tempString.charAt(i) == '(' && tempString.charAt(i+1) == 'Q' &&
					tempString.charAt(i+2) == 'P' && tempString.charAt(i+3) == ' ') {
					i += 3; continue;
				} else if (tempString.charAt(i) == '(' && tempString.charAt(i+1) == 'N' &&
					tempString.charAt(i+2) == 'P' && tempString.charAt(i+3) == ' ') {
					i += 3; continue;
				} else if (tempString.charAt(i) == '(' && tempString.charAt(i+1) == 'P' &&
					tempString.charAt(i+2) == 'P' && tempString.charAt(i+3) == ' ') {
					i += 3; continue;
				} else if (tempString.charAt(i) == '(' && tempString.charAt(i+1) == 'V' &&
					tempString.charAt(i+2) == 'P' && tempString.charAt(i+3) == ' ') {
					i += 3; continue;
				} else if (tempString.charAt(i) == '(' && tempString.charAt(i+1) == 'A' &&
					tempString.charAt(i+2) == 'D' && tempString.charAt(i+3) == 'V' &&
					tempString.charAt(i+4) == 'P') {
					i += 5; continue;
				} else if (tempString.charAt(i) == '(' && tempString.charAt(i+1) == 'A' &&
					tempString.charAt(i+2) == 'D' && tempString.charAt(i+3) == 'J' &&
					tempString.charAt(i+4) == 'P') {
					i += 5; continue;
				} else if (tempString.charAt(i) == '(' && tempString.charAt(i+1) == 'S' &&
					tempString.charAt(i+2) == 'B' && tempString.charAt(i+3) == 'A' &&
					tempString.charAt(i+4) == 'R') {
					i += 5; continue;
				} else if (tempString.charAt(i) == '(' && tempString.charAt(i+1) == 'S' &&
					tempString.charAt(i+2) == 'I' && tempString.charAt(i+3) == 'N' &&
					tempString.charAt(i+4) == 'V') {
					i += 5; continue;
				} else if (tempString.charAt(i) == '(' && tempString.charAt(i+1) == 'W' &&
					tempString.charAt(i+2) == 'H' && tempString.charAt(i+3) == 'N' &&
					tempString.charAt(i+4) == 'P') {
					i += 5; continue;
				} else if (tempString.charAt(i) == '(' && tempString.charAt(i+1) == 'F' &&
					tempString.charAt(i+2) == 'R' && tempString.charAt(i+3) == 'A' &&
					tempString.charAt(i+4) == 'G') {
					i += 5; continue;
				} else if (tempString.charAt(i) == '(' && tempString.charAt(i+1) == 'W' &&
					tempString.charAt(i+2) == 'H' && tempString.charAt(i+3) == 'P' &&
					tempString.charAt(i+4) == 'P') {
					i += 5; continue;
				} else if (tempString.charAt(i) == '(' && tempString.charAt(i+1) == 'I' &&
					tempString.charAt(i+2) == 'N' && tempString.charAt(i+3) == 'T' &&
					tempString.charAt(i+4) == 'J') {
					i += 5; continue;
				} else if (tempString.charAt(i) == '(' && tempString.charAt(i+1) == 'P' &&
					tempString.charAt(i+2) == 'R' && tempString.charAt(i+3) == 'T') {
					i += 4; continue;
				} else if (tempString.charAt(i) == '(' && tempString.charAt(i+1) == 'P' &&
					tempString.charAt(i+2) == 'R' && tempString.charAt(i+3) == 'N') {
					i += 4; continue;
				} else if (tempString.charAt(i) == '(' && tempString.charAt(i+1) == 'R' &&
					tempString.charAt(i+2) == 'R' && tempString.charAt(i+3) == 'C') {
					i += 4; continue;
				} else if (tempString.charAt(i) == '(' && tempString.charAt(i+1) == 'U' &&
					tempString.charAt(i+2) == 'C' && tempString.charAt(i+3) == 'P') {
					i += 4; continue;
				} else if (tempString.charAt(i) == '(' && tempString.charAt(i+1) == 'N' &&
					tempString.charAt(i+2) == 'A' && tempString.charAt(i+3) == 'C') {
					i += 4; continue;
				} else if (tempString.charAt(i) == '(' && tempString.charAt(i+1) == 'L' &&
					tempString.charAt(i+2) == 'S' && tempString.charAt(i+3) == 'T') {
					i += 4; continue;
				} else if (tempString.charAt(i) == '(' && tempString.charAt(i+1) == 'W' &&
					tempString.charAt(i+2) == 'H' && tempString.charAt(i+3) == 'A' &&
					tempString.charAt(i+4) == 'D') {
					i += 7; continue;
				} else if (tempString.charAt(i) == '(' && tempString.charAt(i+1) == 'C' &&
					tempString.charAt(i+2) == 'O' && tempString.charAt(i+3) == 'N' &&
					tempString.charAt(i+4) == 'J') {
					i += 6; continue;
				}
				if (tempString.charAt(i) == '(') right = false;
				if (right && tempString.charAt(i) == ')') continue;
				if ((!right) && tempString.charAt(i) == ')') right = true;
				tempT += tempString.charAt(i);
			}
			writer_t.write(tempT.concat("\n"));
        }
        reader_t.close();
        writer_t.close();
        checkFix();
	}
}
