import java.io.*;
import java.math.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class RTE_FIX {
	public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("RTE_TH.xml"));
        FileWriter writer_t = new FileWriter("T.txt", true);
        FileWriter writer_h = new FileWriter("H.txt", true);
        String tempString = null;
        while ((tempString = reader.readLine()) != null) {
            if (tempString.endsWith("</t>")) {
              	String tempT = "";
               	for (int i = 4; i < tempString.length(); i++) {
					if (tempString.charAt(i) == '<' &&
							tempString.charAt(i+1) == '/' &&
							tempString.charAt(i+2) == 't' &&
							tempString.charAt(i+3) == '>') break;
					if (tempString.charAt(i) == '.') tempT += ',';
					else tempT += tempString.charAt(i);
               	}
                if (tempT.endsWith(","))
                	tempT = tempT.substring(0,tempT.length()-1);
               	if ((!tempT.endsWith(".")) && (!tempT.endsWith(",")))
               		tempT += '.';
               	writer_t.write(tempT.concat("\n"));
            } else if (tempString.endsWith("</h>")) {
               	String tempH = "";
               	for (int i = 4; i < tempString.length(); i++) {
					if (tempString.charAt(i) == '<' &&
							tempString.charAt(i+1) == '/' &&
							tempString.charAt(i+2) == 'h' &&
							tempString.charAt(i+3) == '>') break;
					if (tempString.charAt(i) == '.') tempH += ',';
					else tempH += tempString.charAt(i);
                }
                if (tempH.endsWith(","))
                	tempH = tempH.substring(0,tempH.length()-1);
               	if ((!tempH.endsWith(".")) && (!tempH.endsWith(",")))
               		tempH += '.';
               	writer_h.write(tempH.concat("\n"));
            }
        }
        reader.close(); writer_t.close(); writer_h.close();
	}
}
