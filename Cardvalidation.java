package validation;
import java.util.regex.*;
import java.util.Scanner;
public class Cardvalidation {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("\nEnter CVV : ");
		String cvv = scn.nextLine();
		 
		System.out.println("Enter Card Number : ");
		long number = scn.nextLong();
	
		
        System.out.println(isValidNumber(number) && isValidCVV(cvv) ? "valid" : "invalid");

	}
	public static boolean isValidNumber(long number)
    {
       return (getSize(number) >= 13 &&
               getSize(number) <= 16) &&
               (prefixMatched(number, 4) ||
                prefixMatched(number, 5) ||
                prefixMatched(number, 37) ||
                prefixMatched(number, 6)) &&
              ((sumOfDoubleEvenPlace(number) +
                sumOfOddPlace(number)) % 10 == 0);
    }
	public static int sumOfDoubleEvenPlace(long number)
    {
        int sum = 0;
        String num = number + "";
        for (int i = getSize(number) - 2; i >= 0; i -= 2)
            sum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2);
         
        return sum;
    }
	 public static int getDigit(int number)
	    {
	        if (number < 9)
	            return number;
	        return number / 10 + number % 10;
	    }
	 public static int sumOfOddPlace(long number)
	    {
	        int sum = 0;
	        String num = number + "";
	        for (int i = getSize(number) - 1; i >= 0; i -= 2)
	            sum += Integer.parseInt(num.charAt(i) + "");       
	        return sum;
	    }
	 public static boolean prefixMatched(long number, int d)
	    {
	        return getPrefix(number, getSize(d)) == d;
	    }
	 public static int getSize(long d)
	    {
	        String num = d + "";
	        return num.length();
	    }
	 public static long getPrefix(long number, int k)
	    {
	        if (getSize(number) > k) {
	            String num = number + "";
	            return Long.parseLong(num.substring(0, k));
	        }
	        return number;
	    }
	 public static boolean isValidCVV(String str)
		{
			// Regex to check valid CVV number.
			String regex = "^[0-9]{3,4}$";

			// Compile the ReGex
			Pattern p = Pattern.compile(regex);
			if (str == null)
			{
				return false;
			}
			Matcher m = p.matcher(str);
			return m.matches();
		}

}
