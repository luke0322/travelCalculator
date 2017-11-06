package travTiCalc;

import java.util.Scanner;

public class TravelApp {
	public static void main(String[] args) {
		String choice = "y";
		String unitChoice = "m";
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the Travel Time Calculator.");

		while (choice.equalsIgnoreCase("y") && unitChoice.equalsIgnoreCase("m") || unitChoice.equalsIgnoreCase("i")) {
		
			
			unitChoice = units(sc);
			while (!unitChoice.equalsIgnoreCase("m") && !unitChoice.equalsIgnoreCase("i") || unitChoice.equals(null)) {
				System.out.println("Error. Please enter an m or i.");
				unitChoice = units(sc);
			}
			if (unitChoice.equalsIgnoreCase("m")) {
				System.out.println();
				metricUnits(sc);
			}
			else if(unitChoice.equalsIgnoreCase("i")){
				imperialUnits(sc);
			}
			
			choice = asktoContinue(sc);
			while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n") || choice.equals(null)) {
				System.out.println("\nError. Please enter a y or n.");
				choice = asktoContinue(sc);
			}
		}
		sc.close();
	}

	public static String asktoContinue(Scanner sc) {
		System.out.print("\nContinue (y/n): ");
		String answer = sc.next();
		System.out.println();
		return answer;
	}

	public static double getDouble(Scanner sc, String prompt) {
		double d = 0;
		boolean isValid = false;
		int count = 1;
		while (!isValid) {
			if (count > 1) {
				System.out.println("\nError. Number must be greater than zero.");
			}
			System.out.print(prompt);
			if (sc.hasNextDouble()) {
				d = sc.nextDouble();
				if (d > 0) {
					isValid = true;
				}
			}
			count++;
			sc.nextLine(); // clears the data
		}
		return d;
	}
	
	public static void imperialUnits(Scanner sc) {
		double miles;
		double mph;
		double hours;
		double minutes;
		double totMinutes;
		System.out.println();
		miles = getDouble(sc, "Enter miles: ");
		mph = getDouble(sc, "Enter miles per hour: ");
		System.out.println("\nEstimated Travel Time\n" + "----------------------");
		
		totMinutes = ((miles % mph) * 60);
		hours = (int) miles / mph;
		minutes = (int) (totMinutes / mph);
		long displayHours = (Math.round(hours * 100) / 100);
		long displayMinutes = (Math.round(minutes * 100) / 100);
		
		System.out.println("Hours: " + displayHours);
		System.out.println("Minutes: " + displayMinutes);
	}
	public static void metricUnits(Scanner sc) {
		double kilometers;
		double kph;
		double hours;
		double minutes;
		double totMinutes;
		System.out.println();
		kilometers = getDouble(sc, "Enter kilometers: ");
		kph = getDouble(sc, "Enter kilometers per hour: ");
		System.out.println("\nEstimated Travel Time\n" + "----------------------");
		
		totMinutes = ((kilometers % kph) * 60);
		hours = (int) kilometers / kph;
		minutes = (int) (totMinutes / kph);
		long displayHours = (Math.round(hours * 100) / 100);
		long displayMinutes = (Math.round(minutes * 100) / 100);
		
		System.out.println("Hours: " + displayHours);
		System.out.println("Minutes: " + displayMinutes);
	}
	public static String units(Scanner sc) {
		System.out.print("Press 'm' for Metric Units and 'i' for Imperial Units: ");
		String answer = sc.next();
		System.out.println();
		return answer;
	}
}


