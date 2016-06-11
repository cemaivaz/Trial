package trial.examples;

public class Constants {

	public static boolean unsuperv = true;
	public static boolean stopwordEl = false;
	public static boolean negation = true;
	public static double supervCoeff = 1;
	public static double unsupervCoeff = 1;
	public static String turkishCh = "[^a-zA-ZğüşıöçĞÜŞİÖÇîâûÎÂÛ ]";
	public static int totRev = 700;
	public static boolean limited = false;
	
	public static String vocab = "vocab" + (limited ? totRev : "") + ".txt";
	public static boolean Pattern = true;
	public static void set(int lim) {
		totRev = lim;
		limited = true;
	}
}
