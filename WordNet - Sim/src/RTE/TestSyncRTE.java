package RTE;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.sussex.nlp.jws.JWS;
import edu.sussex.nlp.jws.Lin;

public class TestSyncRTE {
	
	private static String T[][][] = new String[800][200][3];
	private static String H[][][] = new String[800][200][3];
	private static int maxNum = 0;
	private static int pairNumT[] = new int[800];
	private static int pairNumH[] = new int[800];
	
	static String dir = "C:/Program Files (x86)/WordNet";
	static JWS ws = new JWS(dir, "3.0");
	
	private static int count[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	
	private static void reset() {
		for (int i = 0; i < 800; i++)
			for (int j = 0; j < 200; j++)
				for (int k = 0; k < 3; k++)
					T[i][j][k] = H[i][j][k] = "";
		for (int i = 0; i < 800; i++)
			pairNumT[i] = pairNumH[i] = 0;
		maxNum = 0;
	}
	
	private static String[] splitString(String str) {
		String[] ret = str.split(" ");
		return ret;
	}
	
	private static double maxScoreOfLin(String str1, String str2) {
		Lin lin = ws.getLin();
		double sc = lin.max(str1, str2, "n");
		if(sc == 0) sc = lin.max(str1, str2, "v");
		return sc;
	}
	
	public static double getSimilarity(String str1, String str2) {
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
	
	public static void countSimRange(double sim1, double sim2) {
		if (sim1 > 0 && sim1 <= 0.1 && sim2 > 0 && sim2 <= 0.1)
			count[1]++;
		if (sim1 > 0.1 && sim1 <= 0.2 && sim2 > 0.1 && sim2 <= 0.2)
			count[2]++;
		if (sim1 > 0.2 && sim1 <= 0.3 && sim2 > 0.2 && sim2 <= 0.3)
			count[3]++;
		if (sim1 > 0.3 && sim1 <= 0.4 && sim2 > 0.4 && sim2 <= 0.3)
			count[4]++;
		if (sim1 > 0.4 && sim1 <= 0.5 && sim2 > 0.4 && sim2 <= 0.5)
			count[5]++;
		if (sim1 > 0.5 && sim1 <= 0.6 && sim2 > 0.5 && sim2 <= 0.6)
			count[6]++;
		if (sim1 > 0.6 && sim1 <= 0.7 && sim2 > 0.6 && sim2 <= 0.7)
			count[7]++;
		if (sim1 > 0.7 && sim1 <= 0.8 && sim2 > 0.7 && sim2 <= 0.8)
			count[8]++;
		if (sim1 > 0.8 && sim1 <= 0.9 && sim2 > 0.8 && sim2 <= 0.9)
			count[9]++;
		if (sim1 == 1 && sim2 == 1) count[10]++;
	}
	
	public static void printSimDetail(String H1, String H2, String T1, String T2) {
		System.out.println(H1 + "," + H2);
		System.out.println(T1 + "," + T2);
		System.out.println(getSimilarity(T1, H1) + "," + getSimilarity(T2, H2));
		System.out.println("");
	}
	
	public static void printSimRange() {
		int total = 0;
		for (int i = 0; i < maxNum; i++)
			total += pairNumH[i];
		System.out.println("total-H: " + total);
		for (int i = 1; i < 10; i++)
			System.out.println("[0."+ (i-1) + ",0." + i + "]: " + count[i]);
		System.out.println("[0.9,1.0]: " + count[10]);
	}
	
	public static void wordNetPostFix() {
		Lin lin = ws.getLin();
		for (int i = 0; i < maxNum; i++)
			for (int j = 0; j < pairNumH[i]; j++)
				for (int k = 0; k < pairNumT[i]; k++) {
					double sim1 = getSimilarity(T[i][k][1], H[i][j][1]);
					double sim2 = getSimilarity(T[i][k][2], H[i][j][2]);
					countSimRange(sim1, sim2);
					//printSimDetail(H[i][j][1], H[i][j][2],
					//		T[i][k][1], T[i][k][2]);
				}
		printSimRange();
	}
	
	public static void wordNetPreFix(String path) throws IOException {
		// Whether the file is T or H
		char T_H = path.charAt(path.length()-1);
		
		// Extract the case-id from the path
		String regEx="[^0-9]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(path);
		int caseNum = Integer.parseInt(m.replaceAll("").trim());
		if (caseNum < 100) caseNum %= 10;
		else if (caseNum < 1000) caseNum %= 100;
		else if (caseNum < 10000) caseNum %= 1000;
		if (caseNum > maxNum) maxNum = caseNum;
		if (T_H == 'T') pairNumT[caseNum] = 0;
		if (T_H == 'H') pairNumH[caseNum] = 0;
		
		// Read every line and extract tri-sets into arrays
		int setNum = 0, i; String thisLine;
		File file = new File(path);
		BufferedReader br = new BufferedReader(new FileReader(file));
		while ((thisLine = br.readLine()) != null) {
			// cut for relation
			String rel = "", lef = "", rig = "";
			for (i = 0; i < thisLine.length(); i++) {
				if (thisLine.charAt(i) == '(') break;
				rel += thisLine.charAt(i);
			}
			for (i = i + 1; i < thisLine.length(); i++) {
				if (thisLine.charAt(i) == ',') break;
				lef += thisLine.charAt(i);
			}
			for (i = i + 1; i < thisLine.length(); i++) {
				if (thisLine.charAt(i) == ')') break;
				rig += thisLine.charAt(i);
			}
			if (T_H == 'T') {
				T[caseNum][pairNumT[caseNum]][0] = rel;
				T[caseNum][pairNumT[caseNum]][1] = lef;
				T[caseNum][pairNumT[caseNum]][2] = rig;
				pairNumT[caseNum]++;
			} else if (T_H == 'H') {
				H[caseNum][pairNumH[caseNum]][0] = rel;
				H[caseNum][pairNumH[caseNum]][1] = lef;
				H[caseNum][pairNumH[caseNum]][2] = rig;
				pairNumH[caseNum]++;
			} else {
				System.out.println("Wrong happen in Parsing.");
				return;
			}

		}
	}
	
	public static void traverseRTE1_3(String path) throws IOException {
		File file = new File(path);
		if (file.exists()) {
			LinkedList<File> list = new LinkedList<File>();
			File[] files = file.listFiles();
			for (File ele : files)
				wordNetPreFix(ele.getAbsolutePath());
		}
	}
	
	public static void showPair() {
		System.out.println(" ----- T ----- ");
		for (int i = 0; i < maxNum; i++)
			for (int j = 0; j < pairNumT[i]; j++) {
				for (int k = 0; k < 3; k++)
					System.out.print(T[i][j][k] + " ");
				System.out.print("\n");
			}
		System.out.println(" ----- H ----- ");
		for (int i = 0; i < maxNum; i++)
			for (int j = 0; j < pairNumH[i]; j++) {
				for (int k = 0; k < 3; k++)
					System.out.print(H[i][j][k] + " ");
				System.out.print("\n");
			}
	}
	
	public static void main(String args[]) throws IOException {
		String dir1 = "rte_data/rte1_fix/";
		String dir2 = "rte_data/rte2_fix/";
		String dir3 = "rte_data/rte3_fix/";
		//traverseRTE1_3(dir1);
		//traverseRTE1_3(dir2);
		traverseRTE1_3(dir3);
		wordNetPostFix(); reset();
		//showPair();
	}
}
