package RTE;

import java.net.URL;
import java.io.*;
import java.math.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import edu.mit.jwi.Dictionary;
import edu.mit.jwi.IDictionary;

import java.util.*;

//System.out.println();
public class TEXT {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader reader_tf = new BufferedReader(new FileReader("T_JWI.txt"));
		BufferedReader reader_hf = new BufferedReader(new FileReader("H_JWI.txt"));
		BufferedReader reader = new BufferedReader(new FileReader("TRUE_OR_FALSE.txt"));
		BufferedReader reader_tp = new BufferedReader(new FileReader("T_PURE.txt"));
		BufferedReader reader_hp = new BufferedReader(new FileReader("H_PURE.txt"));
		FileWriter writer = new FileWriter("RESULT.txt", true);
		String tempString_tf = "", tempString_hf = "", tempString_tp = "", tempString_hp = "", tempString = "";
	     String wnhome = System.getenv("WNHOME");
	     String path = wnhome + File.separator+ "dict";
	     File wnDir=new File(path); URL url=new URL("file", null, path);
	     IDictionary dict=new Dictionary(url); dict.open();
		while ((tempString_tf = reader_tf.readLine()) != null && (tempString_hf = reader_hf.readLine()) != null &&
				(tempString_tp = reader_tp.readLine()) != null && (tempString_hp = reader_hp.readLine()) != null &&
				(tempString = reader.readLine()) != null) {
			SENTENCE sen = new SENTENCE();
			sen.sortT(tempString_tf); sen.sortH(tempString_hf); sen.synCount(dict);
			String output = "\nH: " + tempString_tp + "\nT: " + tempString_hp + "\n";
			output += sen.getResult();
			if (tempString.charAt(0) == '0') output += "Entail: YES\n";
			else output += "Entail: NO\n";
			writer.write(output);
		}
		reader_tf.close(); reader_hf.close(); reader_tp.close(); reader_hp.close(); writer.close();
	}

}
