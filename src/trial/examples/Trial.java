package trial.examples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;


public class Trial {

	public static boolean checkOdd(int no) throws IllegalThreadStateException{
		throw new IllegalThreadStateException();
		
		
	}
	int x = 0;
	public void setter(int x) {
		this.x = x;
	}
	public int getter() {
		return x;
	}
	
	public Trial() {
		
	}
	
	private static String oppos = " karşıtı";

	public static Map<String, Set<String>> meaning_text(String fileName) {
		File dir = new File(fileName);
		
		Map<String, Set<String>> meanings = new HashMap<String, Set<String>>();
		Set<Set<String>> antoSet = new HashSet<Set<String>>();
		Set<String> txts = new HashSet<String>();
		for (File subDir: dir.listFiles()) {
//			System.out.println(subDir.getAbsolutePath());
			if (subDir.isDirectory())
				for (File xmls: subDir.listFiles()) {
					if (xmls.getName().contains("HARF")) {
						try {
							BufferedReader br = new BufferedReader(new FileReader(xmls));
							String line = "";
							String vocWord = "";
							String opposWord = "";
							while ((line = br.readLine()) != null) {
								if (line.contains("<name>")) {
									txts = new HashSet<String>();
									vocWord = line.substring(line.indexOf("<name>") + "<name>".length(), 
											line.indexOf("</name>"));
									if (vocWord.contains("(I"))
										vocWord = vocWord.substring(0, vocWord.indexOf("("));
									vocWord = vocWord.trim().replaceAll(Constants.turkishCh, "");
									
								}
								if (line.contains("meaning_text")) {
									String meaning = line.substring(line.indexOf(">") + 1, line.lastIndexOf("<"));
									txts.add(meaning);
									if (meaning.contains("karşıtı")) {
										String preOppos = meaning.substring(0, meaning.indexOf(oppos));
										String[] spl = preOppos.split(" ");
										opposWord = spl[spl.length - 1];
										opposWord = opposWord.trim().replaceAll(Constants.turkishCh, "");
									}
								}
								if (line.contains("</entry>")) {
									if (opposWord.length() != 0) {
										meanings.put(vocWord, txts);
										Set<String> s = new HashSet<String>();
										s.addAll(Arrays.asList(vocWord, opposWord));
										antoSet.add(s);
									}
									vocWord = "";
									opposWord = "";
								}
							}
							br.close();
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
		}
		return meanings;
	}
	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		double xx = 3;
		xx += xx/3;
		System.out.println("xx: " + xx);
		Trial t1 = new Trial();
		Trial t2 = new Trial();
		
		t1.x = -22;
		System.out.println(t2.getter());
//		Map<String, Set<String>> m = meaning_text("C:\\Users\\cemri\\Downloads\\Turkce TDK Sozluk\\Turkce TDK Sozluk\\Sozluk");
//		while (true) {
//			Scanner inp = new Scanner(System.in);
//			String line = inp.nextLine();
//			if (line.equalsIgnoreCase("exit"))
//				break;
//			if (!m.containsKey(line)) {
//				System.out.println("Sorry, the word you searched for has not been found in the dictionary!");
//				continue;
//			}
//			int i = 1;
//			for (String s: m.get(line)) {
//				System.out.println((m.get(line).size() > 1 ? (i++ + ": ") : "") + s.trim());
//			}
//		}
//		System.exit(1);
////		System.out.println(checkOdd(5));
//		
//		System.out.println("Hello monde!");
//		
//		Map<String, Double> dist = new HashMap<String, Double>();
//		for (int i = 0; i < 3; i++)
//			dist.put("P" + String.valueOf(i), Double.valueOf(i));
//
//		dist.put("P9877", Double.MAX_VALUE);
//		
//		List<Map.Entry<String, Double>> tmpMap = new ArrayList<Map.Entry<String, Double>>(dist.entrySet());
//		
//		Collections.sort(tmpMap, new Comparator<Map.Entry<String, Double>>() {
//			public int compare(Map.Entry<String, Double> m1, Map.Entry<String, Double> m2) {
//				return m1.getValue().compareTo(m2.getValue());
//			}
//		});
//
//		for (Map.Entry<String, Double> e: tmpMap) {
//			System.out.println(e.getValue());
//		}
		
	}

}
