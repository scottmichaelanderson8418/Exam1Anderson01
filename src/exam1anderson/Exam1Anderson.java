package exam1anderson;

import java.util.Scanner;
public class Exam1Anderson {
	public static void main(String[] argjs) {
//Hi Scott Good Job! POOOPjjjjjjjjjj
		// declare and initialize variables
		// holds the base fee
		double baseFee = 5.99;
		// holds the parking rate per minute
		double parkingRatePerMin = 0.0;
		// holds the minutes parked
		int minutesParked = 0;
		// holds the output value of minutes parked
		int minutesParkedOutputValue = 0;
		// holds the time in hours parked
		int hoursParked = 0;
		// holds the output value in hours parked
		int hoursParkedOutputValue = 0;
		// holds the time in days parked
		int daysParked = 0;
		// constant value to represent sales tax percentage
		final double SALES_TAX_RATE = 0.0475;
		// holds value of user's discount code input
		String userDiscountCode = "";
		// constant value of the promo code
		final String PROMO_CODE = "ParkDiscount2023!";
		// holds the value of the user input for the promo code
		String userPromoCode = "";
		// holds the value of the licenseTag
		String licenseTag = "";
		// holds the value of the Subtotal parking bill
		double parkingBillSubTotal = 0.0;
		// holds the value of the Final parking bill
		double parkingBillFinalTotal = 0.0;
		// holds the value of the sales tax of the Subtotal parking bill
		double parkingBillSalesTax = 0.0;
		// holds the value of the parking type
		String parkingType = "";

		//Add an instance/object of the Scanner Class
		Scanner scanner = new Scanner(System.in);

		// Title of CPCC Parking Service
		System.out.println("Welcome to the CPCC Parking Service \n");

		// ask user to enter number of minutes parked
		System.out.print("Enter the number of minutes the vehicle was parked: ");

		// minutes parked is applied to integer variable "minutesParked"
		minutesParked = scanner.nextInt();
		// Add Blank Line
		System.out.println();
		
		// Scanner needs an extra "scanner.nextLine()" after requesting a
		// "scanner.nextInt()" -- this is a Scanner Class quirk
		scanner.nextLine();

		// Ask user for license tag number
		System.out.print("Enter the vehicle's License Tag Number: ");
		// licenseTag is applied to String variable "licenseTag"
		licenseTag = scanner.nextLine();
		// Add Blank Line
		System.out.println();

		// Ask user if they have a promo code
		System.out.println("If you have a discount, choose from one of the types below: ");
		System.out.println("\t A - Promo Code");
		System.out.println("\t B - No Discount");
		System.out.print("Enter your choice (A or B): ");

		// Enter user selection into String variable "discountCode"
		userDiscountCode = scanner.nextLine().toUpperCase();
		
	
	
		// If user enters "A" then we ask the user to enter the "userPromoCode" and
		// check it against the actual "promoCode"
		if (userDiscountCode.equals("A")) {
			System.out.print("Please enter the promo code: ");
			userPromoCode = scanner.nextLine();

			// If "userPromoCode" matches "promoCode" then "parkingRatePerMin" = 0.05
			if (userPromoCode.equals(PROMO_CODE)) {
				parkingRatePerMin = 0.05;
				System.out.println();
				System.out.println(
						"Thank you for entering promo code ParkDiscount2023! Your parking rate is now $" +
								parkingRatePerMin + " / minute!");

				// If "userPromoCode" does not match "promoCode" then "parkingRatePerMin" = 0.07
			} else {
				// Add Blank Line
				System.out.println();
				parkingRatePerMin = 0.07;
				System.out.println("Invalid promo code entered. Standard parking rate of $" +
						parkingRatePerMin + " / minute applied!");
			}

		} else {
			// Add Blank Line
			System.out.println();
			// Inform user that no discount will be applied
			parkingRatePerMin = 0.07;
			System.out.println("No Discount will be applied");

		}

		// Add Blank Line
		System.out.println();

		// Calculate Days, Hours, and Minutes parked to whole number values
		// calculate hours parked
		hoursParked = minutesParked / 60;

		// calculate days parked
		daysParked = minutesParked / 60 / 24;

		// if (minutesParked >= 60) {
		// minutesParked = minutesParked - (hoursParked * 60);
		// }

		// Determine the parking type based on the number of minutes
		// if minutes >= 1440 it is "Long Term" parking
		if (minutesParked >= 1440) {
			parkingType = "Long Term";

			// if minutes >= 60 it is "Short Term" parking
		} else if (minutesParked >= 60) {
			parkingType = "Short Term";

			// if minutes < 60 it is "Under 1 hour" parking
		} else {
			parkingType = "Under 1 hour";
		}

		// Calculate the subTotal costs of the vehicle parking bill
		parkingBillSubTotal = ((parkingRatePerMin * minutesParked) + baseFee);

		// Calculate the sales tax costs of the parking bill
		parkingBillSalesTax = parkingBillSubTotal * SALES_TAX_RATE;

		// Calculate the total parking bill amount
		parkingBillFinalTotal = parkingBillSubTotal + parkingBillSalesTax;

		// Calculate integer variable "minutesParked" for output

		// if "minutesParked" >= 60 then take the difference of minutesParked -
		// (hoursParked * 60)
		if (minutesParked >= 60) {
			minutesParkedOutputValue = minutesParked - (hoursParked * 60);
		} else {
			minutesParkedOutputValue = minutesParked;
		}

		// if the number of days parked is greater than zero we need to alter the output
		// for the number of hours displayed
		if (daysParked > 0) {

			hoursParkedOutputValue = hoursParked - (daysParked * 24);

		} else {
			// if the # of hours is less than 24 we do not need to alter the output for the
			// number of hours displayed
			hoursParkedOutputValue = hoursParked;
		}

		// Display the Parking Bill for the user
		System.out.println("Your Parking Bill: ");
		// Display license tag
		System.out.println("Vehicle License Tag Number: " + licenseTag);
		// Display parking duration in days / hours / minutes
		System.out.println("Parking Duration: " + daysParked + " day(s) " + hoursParkedOutputValue +
				" hour(s) " + minutesParkedOutputValue + " minute(s)");
		// Display subtotal parking bill
		System.out.printf("Subtotal: $%.2f", parkingBillSubTotal);
		//Add blank line
		System.out.println();
		// Display sales tax of subtotal parking bill
		System.out.printf("Sales Tax: $%.2f", parkingBillSalesTax);
		//Add blank line
		System.out.println();
		// Display final parking bill
		System.out.printf("Final Total: $%.2f", parkingBillFinalTotal);
		//Add blank line
		System.out.println();
		// Display the Parking Type
		System.out.println("Parking Type: " + parkingType);

	}

}
