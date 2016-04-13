import java.io.*;
import java.math.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class POST_FIX {
	public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("H.txt"));
        BufferedReader reader_f = new BufferedReader(new FileReader("H_FIX.txt"));
        String tempString = null, tempString_f = null; int line = 0;
        while ((tempString = reader.readLine()) != null &&
        	(tempString_f = reader_f.readLine()) != null) {
        	if (line < 1555) {
        		line++; continue;
        	}
        	String a = "", b = "", c = ""; int position = 0; line++;
        	String a_f = "", b_f = "", c_f = ""; int position_f = 0;
        	if (tempString.charAt(0) == ' ') position++;
        	while (tempString.charAt(position++) != ' ') a += tempString.charAt(position-1);
        	while (tempString.charAt(position++) != ' ') b += tempString.charAt(position-1);
        	//while (tempString.charAt(position++) != ' ') c += tempString.charAt(position-1);
        	while (tempString_f.charAt(position_f++) != ' ') {}
        	while (tempString_f.charAt(position_f++) != ')') a_f += tempString_f.charAt(position_f-1);
        	position_f++; while (tempString_f.charAt(position_f++) != ' ') {}
        	while (tempString_f.charAt(position_f++) != ')') b_f += tempString_f.charAt(position_f-1);
        	//position_f++; while (tempString_f.charAt(position_f++) != ' ') {}
        	//while (tempString_f.charAt(position_f++) != ')') c_f += tempString_f.charAt(position_f-1);
        	if ((!a.equals(a_f)) || (!b.equals(b_f))/* || (!c.equals(c_f))*/) {
        		System.out.println(a + " & " + a_f + " => " + a.equals(a_f));
        		System.out.println(b + " & " + b_f + " => " + b.equals(b_f));
        		//System.out.println(c + " & " + c_f + " => " + c.equals(c_f));
        		System.out.println("Wrong: " + line);
        		BufferedReader reader_in = new BufferedReader(new InputStreamReader(System.in));
        		String input = reader_in.readLine();
        		if (input.equals("a")) continue;
        		else return;
        	}
        	System.out.println(line);
        }
        reader.close(); reader_f.close();
	}
}
