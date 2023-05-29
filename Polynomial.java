
public class Polynomial{
	
	//one field representing the coefficients of the polynomial using an array of double 
	double [] coefficients;
	
	
	//create no argument constructor that sets the polynomial to zero
	public Polynomial() {
		coefficients = new double[] {0};
	}
	
	//constructor that takes an array of double as an argument and sets the coefficients accordingly
	public Polynomial(double [] given_coefficient_list) {
		//store the number of coefficients 
		int number_of_coefficients = given_coefficient_list.length;
		
		//to set coefficients accordingly
		coefficients = new double[number_of_coefficients];
		
		for (int i = 0; i < number_of_coefficients; i++){
			coefficients[i] = given_coefficient_list[i];
		}
		
	}
	
	//method name add takes one argument of type polynomial.
	public Polynomial add(Polynomial given_polynomial) {
		//returns the polynomial resulting from adding:
		//the calling object and the argument
		
		Polynomial summation;
		
		if(coefficients.length >= given_polynomial.coefficients.length)
		{
			summation = new Polynomial(coefficients);
			for(int i = 0; i < given_polynomial.coefficients.length; i++) {
				summation.coefficients[i] += coefficients[i];
			}
			
		}
		else {
			summation = new Polynomial(given_polynomial.coefficients);
			
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
		if (evaluate(valueX) == 0) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
}
