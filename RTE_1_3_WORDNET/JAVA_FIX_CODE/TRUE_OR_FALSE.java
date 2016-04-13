import java.io.*;
import java.math.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class TRUE_OR_FALSE {
	public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("RTE_ORIGIN.xml"));
        FileWriter writer = new FileWriter("TRUE_OR_FALSE.txt", true);
        String tempString = null, output = "";
        while ((tempString = reader.readLine()) != null) {
        	for (int i = 0; i < tempString.length(); i++)
        		if (tempString.charAt(i) == '<' && tempString.charAt(i+1) == 'p' &&
        		tempString.charAt(i+2) == 'a' && tempString.charAt(i+3) == 'i' &&
        		tempString.charAt(i+4) == 'r' && tempString.charAt(i+5) == ' ')
        			for (int j = i+5; j < tempString.length(); j++)
        				if (tempString.charAt(j) == 'v' && tempString.charAt(j+1) == 'a' &&
        				tempString.charAt(j+2) == 'l' && tempString.charAt(j+3) == 'u' &&
        				tempString.charAt(j+4) == 'e' && tempString.charAt(j+5) == '=') {
        					if (tempString.charAt(j+7) == 'T') output = "1";
        					else output = "0";
        					writer.write(output + "\n"); i = j+7;
        				} else if (tempString.charAt(j) == 'e' && tempString.charAt(j+1) == 'n' &&
        				tempString.charAt(j+2) == 't' && tempString.charAt(j+3) == 'a' &&
        				tempString.charAt(j+4) == 'i' && tempString.charAt(j+5) == 'l') {
        					if (tempString.charAt(j+12) == 'Y') output = "1";
        					else output = "0";
        					writer.write(output + "\n"); i = j+7;
        				}
        }
        reader.close(); writer.close();
	}
}

