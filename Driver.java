import java.io.File;

public class Driver {
    public static void main(String [] args){
        Polynomial p = new Polynomial();
        System.out.println(p.evaluate(3));

        double [] c1 = {6, 5};
        int [] d1 = {0, 3};
        Polynomial p1 = new Polynomial(c1, d1);
        
        double [] c2 = {-2, -9};
        int [] d2 = {1, 4};
        Polynomial p2 = new Polynomial(c2, d2);
        
        double [] c3 = {-1.5, 3};
        int [] d3 = {2, 3};
        Polynomial p3 = new Polynomial(c3, d3);
        //p3 = -1.5 x^2+ 3.0 x^3
        

        double [] c4 = {4.0};
        int [] d4 = {3};
        Polynomial p4= new Polynomial(c4, d4);
        //p4 = 4x^3


         double [] c5 = {-1.5, 3};
         int [] d5 = {3, 2};//not sorted initially 
         Polynomial p5= new Polynomial(c5, d5);
         //p3 = -1.5 x^2+ 3.0 x^3
         

         double [] c6 = {4.0};
         int [] d6 = {3};
         Polynomial p6= new Polynomial(c6, d6);
         //p4 = 4x^3

        



        Polynomial s = p1.add(p2);
        Polynomial mul1 = p1.multiply(p2);
        Polynomial mul2= p3.multiply(p4); //must be (-1.5 x^2+ 3.0 x^3)(4x^3) = -6x^5 + 12x^6
        Polynomial mul3= p5.multiply(p6); //must be (-1.5 x^2+ 3.0 x^3)(4x^3) = -6x^5 + 12x^6
        
        System.out.println("s(0.1) = " + s.evaluate(0.1));
        ////////
        System.out.println("mul1(1.0) = " + mul1.evaluate(1.0)); //must be 121
        System.out.println("mul2(1.0) = " + mul2.evaluate(1.0)); //answer must be 6
        System.out.println("mul3(2.0) = " + mul3.evaluate(2.0));//must be 576
        
        
        if(s.hasRoot(1))
            System.out.println("1 is a root of s");
        else
            System.out.println("1 is not a root of s");

        File f = new File("testing.txt");
        Polynomial read = new Polynomial(f);
        System.out.println(read.evaluate(1));


        //p1.saveToFile("writer_testing.txt");
		p2.saveToFile("writer_testing.txt");
    }
        


        
        

}
