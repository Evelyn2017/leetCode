package array;

/**
 * @author evelyn
 * @description TODO
 * @date 2019-09-28 17:12
 **/
//J21_Derong_zeng, dzeng@nyit.edu
//This program collects and calculates BMI (Body Mass Index) for up to three of people specified by user

import java.util.Scanner;
import javax.swing.JOptionPane;

public class BMI {
    public static void main(String[] z) {
        Scanner k = new Scanner(System.in);
        String title = "Calculate three of Person’s BMI & Provide Data Retrieval Service"
                + "\nStep 1: Enter name, weight & height for every body first"
                + "\nStep 2: The program  calculates all BMI first, it then"
                + "\nStep 3: calculate number of people are under weight"
                + "\nStep 4: calculate number of people are normal weight"
                + "\nStep 5: calculate number of people are over weight"
                + "\nStep 6: calculate number of people are in obesity range\n\n";

        String s1 = "Programmer name";
        String s2 = "Enter maximum # of people for BMI calculation";
        String s3 = "Enter name";        //loop for names
        String s4 = "Enter weight in pounds";    //loop for weights
        String s5 = "Enter height in inches";    //loop for heights

        String cmt1 = "You are under weight";    //loop to auto add cmt - under
        String cmt2 = "You are normal weight";    //loop to auto add cmt - normal
        String cmt3 = "You are over weight";    //loop to auto add cmt - over
        String cmt4 = "You are obese weight";    //loop to auto add cmt - obese

        JOptionPane.showMessageDialog(null, title);        //disp program title
        String PName = JOptionPane.showInputDialog(s1);        //enter programer's name
        String maxS = JOptionPane.showInputDialog(s2);        //enter array size in String type variable
        final int max = Integer.parseInt(maxS);        //convert String maxS to int for size
        String[] name = new String[max];        //declare arrays: name, w, h, bMI, cmt

        int[] w = new int[max];        //  weight
        int[] h = new int[max];        //  height
        double[] bMI = new double[max];        //  calculated BMI
        String[] cmt = new String[max];        // cmt (comment) BMI, as underW etc

        final double BUNDER = 18.5;
        int cUnder = 0;        //under  W range & count Under w
        final double BNORMAL = 25.0;
        int cNormal = 0;        //normal W range & count Normal w
        final double BOVER = 30.0;
        int cOver = 0;        //over  W range & count Over weight
        final double BOBESE = 30.0;
        int cObese = 0;        //obesity  W range & count Obese w

        // This section allows user enter name, weight, height for up to max number of people.
        String wS;
        String hS;  //w & h in String to be converted to integer via wraper class Integer
        int i = 0;  //set array index from 0
        boolean yes = true;        // Loop control set to true to begin

//        System.out.println(calc_bMI(20, 20));

        while (yes) //if more BMI & index i less than max, then loop again
        {
            name[i] = JOptionPane.showInputDialog(s3);  //enter name
            wS = JOptionPane.showInputDialog(s4);
            w[i] = Integer.parseInt(wS);         // enter wS
            hS = JOptionPane.showInputDialog(s5);
            h[i] = Integer.parseInt(hS);        // enter hS

            bMI[i] = calc_bMI(w[i], h[i]);        //calc bMI value
            cmt[i] = get_cmt(bMI[i], BUNDER, BNORMAL, BOVER, BOBESE, cmt[i], cUnder, cNormal, cOver, cObese);        //analyze bMI for cmt about bMI

            JOptionPane.showMessageDialog(null, "Name: " + name[i]
                    + "\nWeight = " + w[i]
                    + "\nWeight = " + h[i]
                    + "\nbMI    = " + bMI[i]
                    + "\ncmt    = " + cmt[i]);


            System.out.print("Enter yes for More BMI, no for No more: ");
            String input = k.nextLine();

            i++;   //increase index for next BMI values

            if (input.equals("yes") && i < max) {
                continue;
            } else {
                yes = false;
            }

        }

        System.out.print("More BMI values to be calculated"
                + "\nor maximum array elements reached= " + max
                + "\neither condition happened, BMI data retrieval service starts!");    //retrievalService ( name, w, h, bMI, cmt );	//Start retrieval method

        System.out.print("\nEnd of BMI base data entry!"
                + "\n\nThis is your THM assignment:"
                + "\n(1) Change the above question using Yes No button"
                + "\n(2) Develop BMI data retrieval service method"
                + "\nwhich is not included in this sample template java class"
                + "\n(3) Move all methods to right below class Calc_and_retrieve_BMI");


        for (int x = 0; x < max; x++) {
            System.out.println("\nBMI Analysis Report"
                    + "\nName\tWeight\tHeight\tBMI Value\tComment");
            System.out.print(name[x] + "\t" + w[x] + "\t" + h[x] + "\t" + bMI[x] + "\t" + cmt[x] + "\t");

        }        // end of retrieves BMI values

        System.out.println(PName + "\nNumber of underweight person = " + cUnder
                + "\nNumber of normal weight person   = " + cNormal
                + "\nNumber of over weight person   = " + cOver
                + "\number of obese range person    = " + cObese
                + "\nEnd of BMI Statistical Job"
                + "\nThank you for using my program");


    }    //end of Loop to enter all base data and BMI, cmt are calculated


    // This method calculates a person’s bMI value
    public static double calc_bMI(int weight, int height) {
        return (weight * 703) / (height * height);  //703 - conversion factor from imperial to metric
    }            //end of calc_bMI


    // This method analyzes the parameter BMI value for cmt: under, normal weight, over, & obese
    public static String get_cmt(double bMI, double BUNDER, double BNORMAL, double BOVER, double BOBESE, String cmt, int cUnder, int cNormal, int cOver, int cObese) {
        String comment = null;
        if (bMI <= BUNDER) {
            cUnder += 1;
            comment = "You are under weight";
        }

        if (bMI > BUNDER && bMI <= BNORMAL) {
            cNormal += 1;
            comment = "You are normal weight";
        }

        if (bMI > BNORMAL && bMI <= BOVER) {
            cOver += 1;
            comment = "You are over weight";
        }

        if (bMI > BOVER) {
            cObese += 1;
            comment = "You are obesity";
        }

        return comment;
    }            //end of get_cmt

    public class retrieve_report {
        // This section retrieves person’s BMI values upon user enters full name (HW)
        public void bMI_data_retrieval(int max,
                                       String[] name,
                                       int[] w,
                                       int[] h,
                                       double[] bMI,
                                       String[] cmt) {

            System.out.println("BMI Analysis Report"
                    + "\nName\tWeight\tHeight\tBMI Value\tComment\n");

            int i = 0;        //Initialized array index for BMI values
            while (i < max) {
                System.out.print(name[i] + "\t" + w[i] + "\t" + h[i] + "\t" + bMI[i] + "\t" + cmt[i] + "\t");
                i += 1;
            }
        }        // end of retrieves BMI values


        public void Disp_BMI_tally(String PName, int cUnder, int cNormal, int cOver, int cObese) // Method to O/P BMI counters (HW)
        {
            System.out.println(PName + "\nNumber of underweight person = " + cUnder
                    + "\nNumber of normal weight person   = " + cNormal
                    + "\nNumber of over weight person   = " + cOver
                    + "\number of obese range person    = " + cObese
                    + "\nEnd of BMI Statistical Job"
                    + "\nThank you for using my program");
        }        // end of constructor of O/P BMI counters

    }

}        // End of program