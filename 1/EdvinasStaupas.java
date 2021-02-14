import java.util.Scanner;

public class a {
	
	public static void main (String[] args) {
		nameChange();
		monthCalculate();
	}
	
	public static void nameChange () {
		output("Iveskite savo varda:");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		String startName = null, subName = null;
		if(name.length() > 3) {
			startName = name.substring(0, name.length() - 2);
			startName = startName.substring(0, 1).toUpperCase() + startName.substring(1);
			subName = name.substring(name.length() - 2);
			String sexName = subName.substring(subName.length() - 1);
			if(sexName.equals("s")){
				if(subName.equals("as")){
					subName = "ai";
				} else if(subName.equals("is")){
					subName = "i";
				} else if(subName.equals("us")){
					subName = "au";
				} else if(subName.equals("ys")){
					subName = "y";
				}
			} else {
				if(subName.contains("ė")) {
					String subsubName = subName.substring(subName.length() - 1);
					subsubName = "e";
					String substartName = subName.substring(0, subName.length() - 1);
					subName = subName + subsubName;				
				}
			}
			output("Sveiki, " + startName + subName + ".");
		} else {
			output("Sveiki, " + name + ".");
		}
	}
	
	public static void monthCalculate () {
		boolean good_month = false;
		Scanner scanner = new Scanner(System.in);
		while (!good_month) {
			output("Iveskite savo gimimo menesi (be lietuvisku raidziu):");
			String birth_month = scanner.nextLine();
			birth_month = birth_month.toLowerCase();
			if(birth_month.equals("sausis") || birth_month.equals("vasaris") || birth_month.equals("gruodis")) {
				output("Jus gimete ziema.");
				good_month = true;
			} else if(birth_month.equals("kovas") || birth_month.equals("balandis") || birth_month.equals("geguze")) {
				output("Jus gimete pavasari.");
				good_month = true;
			} else if(birth_month.equals("birzelis") || birth_month.equals("liepa") || birth_month.equals("rugpjutis")) {
				output("Jus gimete vasara.");
				good_month = true;
			} else if(birth_month.equals("rugsejis") || birth_month.equals("lapkritis") || birth_month.equals("spalis")) {
				output("Jus gimete rudeni.");
				good_month = true;
			} else {
				output("Ivedete netinkama menesi.");
			}
		}
	}

	public static void output (String string) {
			System.out.println(string);
	}
}
//goodMonth