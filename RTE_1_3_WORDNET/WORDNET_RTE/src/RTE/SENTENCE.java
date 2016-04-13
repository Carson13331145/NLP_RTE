package RTE;

import java.net.URL;
import java.io.*;
import java.math.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

import edu.mit.jwi.Dictionary;
import edu.mit.jwi.IDictionary;
import edu.mit.jwi.item.IIndexWord;
import edu.mit.jwi.item.ISynset;
import edu.mit.jwi.item.IWord;
import edu.mit.jwi.item.IWordID;
import edu.mit.jwi.item.POS;

// System.out.println();
public class SENTENCE {
	public static String T, T_NOUN[] = new String[100], T_VERB[] = new String[100],  T_ADJ[]= new String[100],  T_ADV[] = new String[100];
	public static String H, H_NOUN[] = new String[100], H_VERB[] = new String[100],  H_ADJ[] = new String[100],  H_ADV[] = new String[100];
	public static int T_NOUN_COUNT,  T_VERB_COUNT, T_ADJ_COUNT, T_ADV_COUNT;
	public static int H_NOUN_COUNT,  H_VERB_COUNT, H_ADJ_COUNT, H_ADV_COUNT;
	public static boolean NOUN_FIND[] = new boolean[100], VERB_FIND[] = new boolean[100], ADJ_FIND[] = new boolean[100], ADV_FIND[]= new boolean[100];
	public static int  NOUN_ID[][] = new int[100][5], VERB_ID[][] = new int[100][5], ADJ_ID[][] = new int[100][5], ADV_ID[][] = new int[100][5];
	public SENTENCE() {
		T_NOUN_COUNT = T_VERB_COUNT = T_ADJ_COUNT = T_ADV_COUNT =
		H_NOUN_COUNT = H_VERB_COUNT = H_ADJ_COUNT = H_ADV_COUNT = 0;
		for (int i = 0; i < 100; i++) NOUN_FIND[i] = VERB_FIND[i] = ADJ_FIND[i] = ADV_FIND[i] = false;
	}
	public static void sortT(String input) {
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '(' && input.charAt(i+1) == 'N' &&
					input.charAt(i+2) == 'O' && input.charAt(i+3) == 'U' &&
					input.charAt(i+4) == 'N' && input.charAt(i+5) == ' ') {
				i += 6; T_NOUN[T_NOUN_COUNT] = "";
				while (input.charAt(i) != ')') T_NOUN[T_NOUN_COUNT] += input.charAt(i++);
				T_NOUN_COUNT++; i--;
			} else if (input.charAt(i) == '(' && input.charAt(i+1) == 'V' &&
					input.charAt(i+2) == 'E' && input.charAt(i+3) == 'R' &&
					input.charAt(i+4) == 'B' && input.charAt(i+5) == ' ') {
				i += 6; T_VERB[T_VERB_COUNT] = "";
				while (input.charAt(i) != ')') T_VERB[T_VERB_COUNT] += input.charAt(i++);
				T_VERB_COUNT++; i--;
			} else if (input.charAt(i) == '(' && input.charAt(i+1) == 'A' &&
					input.charAt(i+2) == 'D' && input.charAt(i+3) == 'J' &&
					input.charAt(i+4) == 'E' && input.charAt(i+5) == 'C' &&
					input.charAt(i+6) == 'T' && input.charAt(i+7) == 'I' &&
					input.charAt(i+8) == 'V' && input.charAt(i+9) == 'E') {
				i += 11; T_ADJ[T_ADJ_COUNT] = "";
				while (input.charAt(i) != ')') T_ADJ[T_ADJ_COUNT] += input.charAt(i++);
				T_ADJ_COUNT++; i--;
			} else if (input.charAt(i) == '(' && input.charAt(i+1) == 'A' &&
					input.charAt(i+2) == 'D' && input.charAt(i+3) == 'V' &&
					input.charAt(i+4) == 'E' && input.charAt(i+5) == 'R' &&
					input.charAt(i+4) == 'B' && input.charAt(i+5) == ' ') {
				i += 8; T_ADV[T_ADV_COUNT] = "";
				while (input.charAt(i) != ')') T_ADV[T_ADV_COUNT] += input.charAt(i++);
				T_ADV_COUNT++; i--;
			}
		}
	}
	public static void sortH(String input) {
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '(' && input.charAt(i+1) == 'N' &&
					input.charAt(i+2) == 'O' && input.charAt(i+3) == 'U' &&
					input.charAt(i+4) == 'N' && input.charAt(i+5) == ' ') {
				i += 6; H_NOUN[H_NOUN_COUNT] = "";
				while (input.charAt(i) != ')') H_NOUN[H_NOUN_COUNT] += input.charAt(i++);
				H_NOUN_COUNT++; i--;
			} else if (input.charAt(i) == '(' && input.charAt(i+1) == 'V' &&
					input.charAt(i+2) == 'E' && input.charAt(i+3) == 'R' &&
					input.charAt(i+4) == 'B' && input.charAt(i+5) == ' ') {
				i += 6; H_VERB[H_VERB_COUNT] = "";
				while (input.charAt(i) != ')') H_VERB[H_VERB_COUNT] += input.charAt(i++);
				H_VERB_COUNT++; i--;
			} else if (input.charAt(i) == '(' && input.charAt(i+1) == 'A' &&
					input.charAt(i+2) == 'D' && input.charAt(i+3) == 'J' &&
					input.charAt(i+4) == 'E' && input.charAt(i+5) == 'C' &&
					input.charAt(i+6) == 'T' && input.charAt(i+7) == 'I' &&
					input.charAt(i+8) == 'V' && input.charAt(i+9) == 'E') {
				i += 11; H_ADJ[H_ADJ_COUNT] = "";
				while (input.charAt(i) != ')') H_ADJ[H_ADJ_COUNT] += input.charAt(i++);
				H_ADJ_COUNT++; i--;
			} else if (input.charAt(i) == '(' && input.charAt(i+1) == 'A' &&
					input.charAt(i+2) == 'D' && input.charAt(i+3) == 'V' &&
					input.charAt(i+4) == 'E' && input.charAt(i+5) == 'R' &&
					input.charAt(i+4) == 'B' && input.charAt(i+5) == ' ') {
				i += 8; H_ADV[H_ADV_COUNT] = "";
				while (input.charAt(i) != ')') H_ADV[H_ADV_COUNT] += input.charAt(i++);
				H_ADV_COUNT++; i--;
			}
		}
	}
	public static void getT() throws Exception {
		BufferedReader reader_in = new BufferedReader(new InputStreamReader(System.in));
		T = reader_in.readLine();
	}
	public static void getH() throws Exception {
		BufferedReader reader_in = new BufferedReader(new InputStreamReader(System.in));
		H = reader_in.readLine();
	}
	public static void synCount(IDictionary dict) {
		// ---------- NOUN ----------
		for (int i = 0; i < H_NOUN_COUNT; i++) {
			IIndexWord idxWord = null;
			idxWord =dict.getIndexWord(H_NOUN[i], POS.NOUN);
			for (int j = 0; idxWord != null && j < idxWord.getWordIDs().size(); j++) {
                IWordID wordID = idxWord.getWordIDs().get(j) ;
                IWord word = dict.getWord(wordID);
                ISynset synset = word.getSynset ();
                for(IWord w : synset.getWords())
                	for (int v = 0; v < T_NOUN_COUNT; v++)
                		if (w.getLemma().toLowerCase().equals(T_NOUN[v].toLowerCase())) {
                			NOUN_FIND[i] = true; NOUN_ID[i][0] = i; NOUN_ID[i][1] = v;
                		}
			}
		}
		// ---------- VERB ----------
		for (int i = 0; i < H_VERB_COUNT; i++) {
			IIndexWord idxWord = null;
			idxWord =dict.getIndexWord(H_VERB[i], POS.VERB);
			for (int j = 0; idxWord != null && j < idxWord.getWordIDs().size(); j++) {
                IWordID wordID = idxWord.getWordIDs().get(j) ;
                IWord word = dict.getWord(wordID);
                ISynset synset = word.getSynset ();
                for(IWord w : synset.getWords())
                	for (int v = 0; v < T_VERB_COUNT; v++)
                		if (w.getLemma().toLowerCase().equals(T_VERB[v].toLowerCase())) {
                			VERB_FIND[i] = true; VERB_ID[i][0] = i; VERB_ID[i][1] = v;
                		}
			}
		}
		// ---------- ADJ ----------
		for (int i = 0; i < H_ADJ_COUNT; i++) {
			IIndexWord idxWord = null;
			idxWord =dict.getIndexWord(H_ADJ[i], POS.ADJECTIVE);
			for (int j = 0; idxWord != null && j < idxWord.getWordIDs().size(); j++) {
                IWordID wordID = idxWord.getWordIDs().get(j) ;
                IWord word = dict.getWord(wordID);
                ISynset synset = word.getSynset ();
                for(IWord w : synset.getWords())
                	for (int v = 0; v < T_ADJ_COUNT; v++)
                		if (w.getLemma().toLowerCase().equals(T_ADJ[v].toLowerCase())) {
                			ADJ_FIND[i] = true; ADJ_ID[i][0] = i; ADJ_ID[i][1] = v;
                		}
			}
		}
		// ----------ADV ----------
		for (int i = 0; i < H_ADV_COUNT; i++) {
			IIndexWord idxWord = null;
			idxWord =dict.getIndexWord(H_ADV[i], POS.ADVERB);
			for (int j = 0; idxWord != null && j < idxWord.getWordIDs().size(); j++) {
                IWordID wordID = idxWord.getWordIDs().get(j) ;
                IWord word = dict.getWord(wordID);
                ISynset synset = word.getSynset ();
                for(IWord w : synset.getWords())
                	for (int v = 0; v < T_ADV_COUNT; v++)
                		if (w.getLemma().toLowerCase().equals(T_ADV[v].toLowerCase())) {
                			ADV_FIND[i] = true; ADV_ID[i][0] = i; ADV_ID[i][1] = v;
                		}
			}
		}
	}
	public static void printResult() {
		// print ---------- NOUN ----------
		System.out.print("T_NOUN: ");
		for (int i = 0; i < T_NOUN_COUNT; i++) System.out.print(T_NOUN[i]+", ");
		System.out.print("\nH_NOUN: ");
		for (int i = 0; i < H_NOUN_COUNT; i++) System.out.print(H_NOUN[i]+", "); System.out.println("");
		for (int i = 0; i < H_NOUN_COUNT; i++) if (NOUN_FIND[i])
				System.out.print("H(" + H_NOUN[NOUN_ID[i][0]] + ") - T(" + T_NOUN[NOUN_ID[i][1]] + "), ");
		// print ---------- VERB ----------
		System.out.print("\n\nT_VERB: ");
		for (int i = 0; i < T_VERB_COUNT; i++) System.out.print(T_VERB[i]+", ");
		System.out.print("\nH_VERB: ");
		for (int i = 0; i < H_VERB_COUNT; i++) System.out.print(H_VERB[i]+", "); System.out.print("");
		for (int i = 0; i < H_VERB_COUNT; i++) if (VERB_FIND[i])
			System.out.print("H(" + H_VERB[VERB_ID[i][0]] + ") - T(" + T_VERB[VERB_ID[i][1]] + "), ");
		// print ---------- ADJ ----------
		System.out.print("\n\nT_ADJ: ");
		for (int i = 0; i < T_ADJ_COUNT; i++) System.out.print(T_ADJ[i]+", ");
		System.out.print("\nH_ADJ: ");
		for (int i = 0; i < H_ADJ_COUNT; i++) System.out.print(H_ADJ[i]+", "); System.out.print("");
		for (int i = 0; i < H_ADJ_COUNT; i++) if (ADJ_FIND[i])
			System.out.print("H(" + H_ADJ[ADJ_ID[i][0]] + ") - T(" + T_ADJ[ADJ_ID[i][1]] + "), ");
		// print ---------- ADV ----------
		System.out.print("\n\nT_ADV: ");
		for (int i = 0; i < T_ADV_COUNT; i++) System.out.print(T_ADV[i]+", ");
		System.out.print("\nH_ADV: ");
		for (int i = 0; i < H_ADV_COUNT; i++) System.out.print(H_ADV[i]+", "); System.out.print("");
		for (int i = 0; i < H_ADV_COUNT; i++) if (ADV_FIND[i])
			System.out.print("H(" + H_ADV[ADV_ID[i][0]] + ") - T(" + T_ADV[ADV_ID[i][1]] + "), ");
	}
	public static String getResult() {
		String output = "\n"; int count = 0, total = H_NOUN_COUNT+H_VERB_COUNT+H_ADJ_COUNT+H_ADV_COUNT;
		// print ---------- NOUN ----------
		output += "T_NOUN: ";
		for (int i = 0; i < T_NOUN_COUNT; i++) output += T_NOUN[i]+", ";
		output += "\nH_NOUN: ";
		for (int i = 0; i < H_NOUN_COUNT; i++) output += H_NOUN[i]+", "; output += "\nNOUN_FIND: ";
		for (int i = 0; i < H_NOUN_COUNT; i++) if (NOUN_FIND[i]) {
			output += "H(" + H_NOUN[NOUN_ID[i][0]] + ") - T(" + T_NOUN[NOUN_ID[i][1]] + "), "; count++;
		}
		// print ---------- VERB ----------
		output += "\n\nT_VERB: ";
		for (int i = 0; i < T_VERB_COUNT; i++) output += T_VERB[i]+", ";
		output += "\nH_VERB: ";
		for (int i = 0; i < H_VERB_COUNT; i++) output += H_VERB[i]+", "; output += "\nVERB_FIND: ";
		for (int i = 0; i < H_VERB_COUNT; i++) if (VERB_FIND[i]) {
			 output += "H(" + H_VERB[VERB_ID[i][0]] + ") - T(" + T_VERB[VERB_ID[i][1]] + "), "; count++;
		}
		// print ---------- ADJ ----------
		output += "\n\nT_ADJ: ";
		for (int i = 0; i < T_ADJ_COUNT; i++) output += T_ADJ[i]+", ";
		output += "\nH_ADJ: ";
		for (int i = 0; i < H_ADJ_COUNT; i++) output += H_ADJ[i]+", "; output += "\nADJ_FIND: ";
		for (int i = 0; i < H_ADJ_COUNT; i++) if (ADJ_FIND[i]) {
			output += "H(" + H_ADJ[ADJ_ID[i][0]] + ") - T(" + T_ADJ[ADJ_ID[i][1]] + "), "; count++;
		}
		// print ---------- ADV ----------
		output += "\n\nT_ADV: ";
		for (int i = 0; i < T_ADV_COUNT; i++) output += T_ADV[i]+", ";
		output += "\nH_ADV: ";
		for (int i = 0; i < H_ADV_COUNT; i++) output += H_ADV[i]+", ";  output += "\nADV_FIND: ";
		for (int i = 0; i < H_ADV_COUNT; i++) if (ADV_FIND[i]) {
			output += "H(" + H_ADV[ADV_ID[i][0]] + ") - T(" + T_ADV[ADV_ID[i][1]] + "), "; count++;
		}
		output += "\n\nSYN_PERCENT(100%): " + count + "/" + total + "\n";
		return output;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		//getT(); getH();
		T = "(ADJECTIVE Crude) (NOUN oil) (IN for) (NOUN April) (NOUN delivery) " +
				"(VERB traded) (IN at) ( $) (CD 37,80) (DT a) (NOUN barrel) ( ,) (ADVERB down) (CD 28) (NOUN cents) ( .)";
		H = "(ADJECTIVE Crude) (NOUN oil) (NOUN prices) (VERB rose) (TO to) ( $) (CD 37,80) (IN per) (NOUN barrel) ( .)";
		sortT(T); sortH(H);
	     String wnhome = System.getenv("WNHOME");
	     String path = wnhome + File.separator+ "dict";      
	     File wnDir=new File(path); URL url=new URL("file", null, path);
	     IDictionary dict=new Dictionary(url); dict.open();
		synCount(dict); printResult();
	}
}
