import java.io.*;
import java.math.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class JWI_FIX {
	public static String fixFunc(String input) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader("WORD_TYPE.txt"));
		String tempString = null, output = "";
		while ((tempString = reader.readLine()) != null) {
			int pos = 0; String type = "";
			while(tempString.charAt(pos++) != ':') type += tempString.charAt(pos-1);
			// System.out.println(input+" : "+type);
			if (input.equals(type)) {
				while (tempString.charAt(pos++) != ' ') {}
				if (tempString.charAt(pos++) == '<') {
					while (tempString.charAt(pos) != '>') output += tempString.charAt(pos++);
				} else output += input;
				break;
			}
		}
		reader.close(); return output;
	}
	public static void main(String[] args) throws Exception {
    	BufferedReader reader = new BufferedReader(new FileReader("H_FIX.txt")), reader_j;
    	FileWriter writer = new FileWriter("H_JWI.txt", true);
    	String tempString = null; int line = 0;
    	while ((tempString = reader.readLine()) != null) {
			reader_j = new BufferedReader(new FileReader("WORD_TYPE.txt")); String turn = ""; line++;
			for (int i = 0; i < tempString.length(); i++) {
				turn += tempString.charAt(i);
				if (tempString.charAt(i) == '(') {
					int pos = i+1; String w_type = "";
					while (tempString.charAt(pos++) != ' ') w_type += tempString.charAt(pos-1);
					turn += fixFunc(w_type); i = pos-2;
				}
			}
			writer.write(turn+"\n");
    	}
    	reader.close(); writer.close();
	}
}
