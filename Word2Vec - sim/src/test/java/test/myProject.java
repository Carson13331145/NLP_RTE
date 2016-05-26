package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Set;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import com.alibaba.fastjson.JSONObject;

import com.ansj.vec.Learn;
import com.ansj.vec.Word2VEC;
import com.ansj.vec.domain.WordEntry;

import love.cq.util.IOUtil;
import love.cq.util.StringUtil;

public class myProject {
    private static final File ComputerCorpusFile = new File("wiki_computer_ceg.txt");
    
    public static void main(String[] args) throws IOException {
        /*File[] files = new File("computer_data/").listFiles();

        //��������
        try (FileOutputStream fos = new FileOutputStream(ComputerCorpusFile)) {
            for (File file : files) {
                if (file.canRead() && file.getName().endsWith(".txt")) {
                    parserFile(fos, file);
                }
            }
        }*/
    	/*File comName = new File("C19-Computer.txt");
    	FileOutputStream fos = new FileOutputStream(ComputerCorpusFile);
    	parserFile(fos, comName);*/

        //���зִ�ѵ��

        /*Learn lean = new Learn() ;

        lean.learnFile(ComputerCorpusFile) ;

        lean.saveModel(new File("model/vector_mid.mod")) ;*/



        //���ز���

        Word2VEC w2v = new Word2VEC() ;

        System.out.println("loading model ...");
        w2v.loadJavaModel("model/vector_mid.mod") ;
        /*for (WordEntry ele : w2v.distance("C����"))
        	System.out.println(ele);
        System.out.println("");
        for (WordEntry ele : w2v.distance("����"))
        	System.out.println(ele);*/
        System.out.println("distance between "+"C����"+" and "+"C++");
        System.out.println(w2v.distance("C����","C++"));
        
        System.out.println("distance between "+"����"+" and "+"����");
        System.out.println(w2v.distance("����","����"));
        
        System.out.println("distance between "+"ָ��"+" and "+"����");
        System.out.println(w2v.distance("ָ��","����"));
        
        System.out.println("distance between "+"���˼"+" and "+"��������");
        System.out.println(w2v.distance("���˼","��������"));

        System.out.println("distance between "+"����"+" and "+"����");
        System.out.println(w2v.distance("����","����"));
    }

    private static void parserFile(FileOutputStream fos, File file) throws FileNotFoundException,
                                                                   IOException {
        // TODO Auto-generated method stub
        try (BufferedReader br = IOUtil.getReader(file.getAbsolutePath(), IOUtil.UTF8)) {
            String temp = null;
            JSONObject parse = null;
            while ((temp = br.readLine()) != null) {
                parse = JSONObject.parseObject(temp);
                paserStr(fos, parse.getString("title"));
                paserStr(fos, StringUtil.rmHtmlTag(parse.getString("content")));
            }
        }
    }

    private static void paserStr(FileOutputStream fos, String title) throws IOException {
        List<Term> parse2 = ToAnalysis.parse(title) ;
        StringBuilder sb = new StringBuilder() ;
        for (Term term : parse2) {
            sb.append(term.getName()) ;
            sb.append(" ");
        }
        fos.write(sb.toString().getBytes()) ;
        fos.write("\n".getBytes()) ;
    }
}
