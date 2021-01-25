
import java.util.*;

import java.text.DecimalFormat;


class Rational {

	private int denominator; // Denominator of the Rational number.
	private int numerator; // Numerator of the Rational number.

	
	public Rational() {
		this(0, 1, false);
	}

	
	public Rational(int numerator) {
		this(numerator, 1);
	}

	
	public Rational(int numerator, int denominator){
		this(numerator, denominator, true);
	}

	
	public Rational(int numerator, int denominator, boolean reduceFlag)
			throws ArithmeticException {
		this.setNumerator(numerator);
		this.setDenominator(denominator);

		if (reduceFlag) {
			Rational result = Rational.toReduced(this);
			this.setNumerator(result.getNumerator());
			this.setDenominator(result.getDenominator());
		}
	}

	
	public static Rational Add(Rational addend1, Rational addend2) {
		return Rational.Add(addend1, addend2, true);
	}

	
	public static Rational Divide(Rational dividend, Rational divisor) {
		return Rational.Divide(dividend, divisor, true);
	}

	public static Rational Multiply(Rational product1, Rational product2) {
		return Rational.Multiply(product1, product2, true);
	}

	
	public static Rational Reciprocal(Rational number)
			throws ArithmeticException {
		Rational result = new Rational();
		result.setNumerator(number.getDenominator());
		result.setDenominator(number.getNumerator());
		return result;
	}

	
	public static Rational Subtract(Rational minuend, Rational subtrahend) {
		return Rational.Subtract(minuend, subtrahend, true);
	}

	
	public static Rational toReduced(Rational number) {
		int gcd;
		Rational result = new Rational();

		if (number.getNumerator() > 0) {
			gcd = Rational.gcd(number.getNumerator(), number.getDenominator());
			result.setNumerator(number.getNumerator() / gcd);
			result.setDenominator(number.getDenominator() / gcd);
		} else {
			result.setNumerator(number.getNumerator());
			result.setDenominator(number.getDenominator());
		}
		return result;
	}

	
	private static Rational Add(Rational addend1, Rational addend2,
			boolean reduceFlag) {
		Rational result = new Rational();

		
		if (addend1.getDenominator() == addend2.getDenominator()) {
			result.setNumerator(addend1.getNumerator() + addend2.getNumerator());
			result.setDenominator(addend1.getDenominator());
		} else {
			Rational newAddend1;
			Rational newAddend2;
			Rational multiplyBy;

			
			multiplyBy = new Rational();
			multiplyBy.setNumerator(addend2.getDenominator());
			multiplyBy.setDenominator(addend2.getDenominator());

			newAddend1 = Rational.Multiply(addend1, multiplyBy, false);

			// Transform addend2 into one with a common denominator.
			multiplyBy.setNumerator(addend1.getDenominator());
			multiplyBy.setDenominator(addend1.getDenominator());

			newAddend2 = Rational.Multiply(addend2, multiplyBy, false);

			result = Rational.Add(newAddend1, newAddend2);
		}

		if (reduceFlag) {
			result = Rational.toReduced(result);
		}

		return result;
	}

	
	private static Rational Divide(Rational dividend, Rational divisor,
			boolean reduceFlag) {
		Rational result = new Rational();

		Rational reciprocal = Rational.Reciprocal(divisor);
		result = Rational.Multiply(dividend, reciprocal, false);

		if (reduceFlag) {
			result = Rational.toReduced(result);
		}

		return result;
	}

	
	private static int gcd(int number1, int number2) {
		int remainder = 0;
		int result = 0;

		// Make sure number1 is the bigger number.
		if (number1 < number2) {
			int switchNumber = number1;
			number1 = number2;
			number2 = switchNumber;
		}

		
		remainder = number1 % number2;

		if (remainder == 0) {
			result = number2; 
		} else {
			result = Rational.gcd(number2, remainder);
		}

		return result;
	}

	
	private static Rational Multiply(Rational product1, Rational product2,
			boolean reduceFlag) {
		Rational result = new Rational();

		result.setNumerator(product1.getNumerator() * product2.getNumerator());
		result.setDenominator(product1.getDenominator()
				* product2.getDenominator());

		if (reduceFlag) {
			result = Rational.toReduced(result);
		}

		return result;
	}

	
	private static Rational Subtract(Rational minuend, Rational subtrahend,
			boolean reduceFlag) {
		Rational result = new Rational();

		
		if (minuend.getDenominator() == subtrahend.getDenominator()) {
			result.setNumerator(minuend.getNumerator()
					- subtrahend.getNumerator());
			result.setDenominator(minuend.getDenominator());
		} else {
			Rational newMinuend;
			Rational newSubtrahend;
			Rational multiplyBy;

			
			multiplyBy = new Rational();
			multiplyBy.setNumerator(subtrahend.getDenominator());
			multiplyBy.setDenominator(subtrahend.getDenominator());

			newMinuend = Rational.Multiply(minuend, multiplyBy, false);

			// Transform minuend into one with a common denominator.
			multiplyBy.setNumerator(minuend.getDenominator());
			multiplyBy.setDenominator(minuend.getDenominator());

			newSubtrahend = Rational.Multiply(subtrahend, multiplyBy, false);

			result = Rational.Subtract(newMinuend, newSubtrahend);
		}

		if (reduceFlag) {
			result = Rational.toReduced(result);
		}

		return result;
	}

	
	public int getDenominator() {
		return denominator;
	}

	
	public int getNumerator() {
		return numerator;
	}

	
	public void Reduce() {
		Rational result = Rational.toReduced(this);
		this.setNumerator(result.getNumerator());
		this.setDenominator(result.getDenominator());
	}

	
	public void setDenominator(int denominator) throws ArithmeticException {
		if (denominator == 0) {
			throw new ArithmeticException("A zero denominator is not allowed.");
		}

		this.denominator = denominator;
	}

	
	public void setNumerator(int numerator) {
		this.numerator = numerator;
		if (numerator == 0) {
			this.denominator = 1;
		}
	}

	
	public double toFloat() {
		double numerator = (double) this.getNumerator();
		double denominator = (double) this.getDenominator();
		return numerator / denominator;
	}

	
	public double toFloat(int digits) {
		double result = this.toFloat();
		StringBuilder format = new StringBuilder();

		format.append("#.");
		for (int i = 1; i <= digits; i++) {
			format.append("#");
		}
		DecimalFormat df = new DecimalFormat(format.toString());

		return Double.valueOf(df.format(result)).doubleValue();
	}

	
	public String toString() {
		StringBuilder result = new StringBuilder();

		if ((this.getNumerator() == 0) || (this.getDenominator() == 1)) {
			result.append(this.getNumerator());
		} else {
			result.append(this.getNumerator());
			result.append("/");
			result.append(this.getDenominator());
		}
		return result.toString();
	}
}

public class Ex4Ans1New {

   
    public static void main(String[] args) {
       
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the num of first rational number : ");
        int num = in.nextInt();
        System.out.println("Enter the den of first rational number : ");
        int den = in.nextInt();
        Rational obj = new Rational(num,den);
        System.out.println("Enter the num of second rational number : ");
        num = in.nextInt();
        System.out.println("Enter the den of second rational number : ");
        den = in.nextInt();
        Rational obj2 = new Rational(num,den);
        Rational r1 = Rational.Add(obj, obj2);
        System.out.println(" The sum of both the numbers are : " + r1.getNumerator() + "/"+r1.getDenominator());
        r1 = Rational.Subtract(obj, obj2);
        System.out.println(" The subtraction of both the numbers are  : "+ r1.getNumerator()+"/"+r1.getDenominator() );
        r1 = Rational.Multiply(obj, obj2);
        System.out.println(" The multiplication of both the number are : "+ r1.getNumerator()+"/" + r1.getDenominator());
        r1 = Rational.Divide(obj, obj2);
        System.out.println(" The devision of both the numbers are  : "+ r1.getNumerator()+ "/"+r1.getDenominator());
        r1 = new Rational(2,3);
        System.out.println(r1.toFloat(5));
        System.out.println(r1.toString());
        
    }
    
}
