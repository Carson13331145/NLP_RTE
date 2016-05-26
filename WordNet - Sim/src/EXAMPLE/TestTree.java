package EXAMPLE;

import java.util.TreeMap;
import java.text.*;
import edu.sussex.nlp.jws.*;

public class TestTree {
	private String str1;
	private String str2;
	private String dir = "C:/Program Files (x86)/WordNet";
	private JWS ws = new JWS(dir, "3.0");
	
	public TestTree(String a, String b) {
		this.str1 = a;
		this.str2 = b;
	}
	
	private String[] splitString(String str) {
		String[] ret = str.split(" ");
		return ret;
	}
	
	private double maxScoreOfLin(String str1,String str2) {
		Lin lin = ws.getLin();
		double sc = lin.max(str1, str2, "n");
		if(sc==0) sc = lin.max(str1, str2, "v");
		return sc;
	}
	
	public double getSimilarity() {
		String[] strs1 = splitString(str1);
		String[] strs2 = splitString(str2);
		double sum = 0.0;
		for (String s1 : strs1) {
			for (String s2 : strs2) {
				double sc= maxScoreOfLin(s1,s2);
				sum += sc;
			}
		}
		double Similarity = sum / (strs1.length * strs2.length);
		sum = 0;
		return Similarity;
	}
	
	public static void main(String args[]) {
		String s1 = "pointer";
		String s2 = "class";
		TestTree sm= new TestTree(s1, s2);
		System.out.println(sm.getSimilarity());
	}
}
