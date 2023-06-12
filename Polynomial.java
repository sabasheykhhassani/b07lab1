import java.util.Arrays;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Polynomial{
	
	//one field representing the coefficients of the polynomial using an array of double 
	double [] coefficients;
	
	
	//create no argument constructor that sets the polynomial to zero
	public Polynomial() {
		coefficients = new double[] {0};
	}

	public Polynomial(File f){
		try {
			Scanner scan = new Scanner(f);
			String line = "";

			if (scan.hasNext()) {
				line = scan.nextLine();
				
			}
			scan.close();

			
            String[] terms = line.split("\\s*(?=[+-])\\s*");
            double[] coefficients = new double[terms.length];
            int[] degrees = new int[terms.length];
            int count = 0;

            for (String s: terms) {
                String [] split_term = s.split("[x]");
                if (split_term.length == 1) {
                    coefficients[count] = Double.parseDouble(split_term[0]);
                    degrees[count] = 0;
                } else {
                    coefficients[count] = Double.parseDouble(split_term[0]);
                    degrees[count] = Integer.parseInt(split_term[1]);
                }
                count ++;
            }

			Polynomial res = new Polynomial(coefficients, degrees);
			this.coefficients = new double[res.coefficients.length];
			for (int i = 0; i < res.coefficients.length; i++) {
				this.coefficients[i] = res.coefficients[i];
			}

		} catch (Exception e) {
			System.out.println("File does not exist.");
		}

	}
	
	//Replace the array representing the coefficients by two arrays: 
	//one representing the non- zero coefficients (of type double) and 
	//another one representing the corresponding exponents (of type int)
	public Polynomial(double [] non0Coefficients, int [] exponents_x) {
		
		//to sort the array
		Arrays.sort(exponents_x);
		//store the last exponent showing in exponent array which is the degree of polynomial
		int degree_of_Polynomial = exponents_x[exponents_x.length -1];
		
		//one more since 0 is included
		coefficients = new double[degree_of_Polynomial + 1];
		
		for(int i = 0; i < coefficients.length; i++){
			for (int j = 0; j < exponents_x.length; j++){
				if (i == exponents_x[j]) {
					coefficients[i] = non0Coefficients[j];
				}
			}
		}
	}

	//helper Copy:
	public Polynomial copyPolynomial(Polynomial p) {
		Polynomial result = new Polynomial();
		double [] res = new double[p.coefficients.length];
		for (int i = 0; i < p.coefficients.length; i++) {
			res[i] = p.coefficients[i];
		}
		result.coefficients = res;
		return result;
	}
	

	
	//method name add takes one argument of type polynomial.
	public Polynomial add(Polynomial given_polynomial) {
		//returns the polynomial resulting from adding:
		//the calling object and the argument
		
		Polynomial summation;
		
		if(coefficients.length >= given_polynomial.coefficients.length) {
			summation = copyPolynomial(this);
			for(int i = 0; i < given_polynomial.coefficients.length; i++) {
				summation.coefficients[i] += coefficients[i];
			}
		}
		else {
			summation = copyPolynomial(given_polynomial);			
			for(int i = 0; i< coefficients.length; i++) {
				summation.coefficients[i] += coefficients[i];
			}
		}
		
		return summation;
	}
	
	
	//Method evaluate
	//takes an argument of type double 
	public double evaluate(double x) {
		double final_value = 0.0;
		
		//multiply each degree of x by its coefficient.
		for(int degree = 0; degree < coefficients.length; degree++){
			final_value += coefficients[degree] * Math.pow(x, degree);
			
		}
		return final_value;	
	}
	
	public boolean hasRoot(double valueX) {
		return (evaluate(valueX) == 0);
	}

	
	
	
	public Polynomial multiply(Polynomial given_polynomial) {
		// Multiply this polynomial with the given polynomial and return a new polynomial

		int resultLength = coefficients.length + given_polynomial.coefficients.length -1;
		double [] multiplication = new double[resultLength];
		for (int i = 0; i< coefficients.length ; i++){
			for(int j= 0; j<given_polynomial.coefficients.length; j++){
				multiplication[i+j] += coefficients[i] * given_polynomial.coefficients[j];
			}
		}

		Polynomial result = new Polynomial();
		result.coefficients = multiplication;
		return result;
		
	}


    public String polynomial_to_String() {

		//Start at empty
        String result = "";
        for (int i = 0; i < coefficients.length; i++) {
            if (coefficients[i] != 0) {
                if (i == 0) {
                    result += coefficients[i];
                } else if (coefficients[i] > 0) {
                    result += " + " + coefficients[i] + "x" + i;
                } else if (coefficients[i] < 0){
                    result += " - " + Math.abs(coefficients[i]) + "x" + i;
                }
            }
        }
        return result;
    }

	//gets string representing file name and saves the polynomial 
	//in textual format in the correcponsing file
    public void saveToFile(String file_name) {

        try {
            File f = new File(file_name);
            FileWriter writer = new FileWriter(f);
            writer.write(polynomial_to_String());
            writer.close();


        } catch (Exception e) {
            System.out.println("Error:Does not exist.");
        }

    }
	
}
