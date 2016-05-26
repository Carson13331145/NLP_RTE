package EXAMPLE;

import java.util.TreeMap;
import java.text.*;
import edu.sussex.nlp.jws.*;


public class TestExample {
	public static void main(String[] args) {
		String dir = "C:/Program Files (x86)/WordNet";
		JWS ws = new JWS(dir, "3.0");
		/*JiangAndConrath jcn = ws.getJiangAndConrath();
		TreeMap<String, Double> scores1 = jcn.jcn("apple", "banana", "n");
		for(String s : scores1.keySet())
			System.out.println(s + "\t" + scores1.get(s));*/
		
		Lin lin = ws.getLin();
		/*System.out.println("\nspecific pair\t=\t" +
				lin.lin("like", 1, "hate", 1, "n") + "\n");*/
		System.out.println("\nhighest score\t=\t" +
				lin.max("people","tool","n") + "\n\n\n");
	}
}
