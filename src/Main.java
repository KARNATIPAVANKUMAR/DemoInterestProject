import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_COLORNAME_YELLOW = "\u001B[33m";
    public static double principle;
    public static double rate;
    public static String inputString1;
    public static String inputString2;
    public static double time ;
    public static double totalDays;

    public static void main(String[] args) {
        System.out.println("Welcome to Simple and Compund Interest Calculator....!");
        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
        try {
            System.out.print("Enter From Date in DD MM YYYY : ");
            inputString1 = scan.nextLine();
            System.out.print("Enter To Date in DD MM YYYY : ");
            inputString2 = scan.nextLine();
            System.out.print("Enter Princple : ");
            principle = scan.nextInt();
            System.out.print("Enter ROI : ");
            rate = scan.nextInt();

            //System.out.println("PRINCIPLE: "+principle);
            Date date1 = myFormat.parse(inputString1);
            //System.out.println("FROM DATE: "+date1);
            Date date2 = myFormat.parse(inputString2);
            //System.out.println("TO DATE: "+date2);
            long diff = date2.getTime() - date1.getTime();
            System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
            totalDays=TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            //generic days
            time = (totalDays)/365;
            //specific to nanna calculations
            //time = (totalDays)/360;
            System.out.println("Year : "+time);
            double l = Math.round(time * 100) / 100;
           // System.out.println(l);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(time <= 1){
            //System.out.println("Rate: "+rate);
            System.out.println("Total(principle +Interest): "+ANSI_COLORNAME_YELLOW+calculateSimpleInterest(time));
        } else if (time > 1) {
           //System.out.println("Rate"+rate);
           System.out.println("Total(principle +Interest): "+ANSI_COLORNAME_YELLOW+calculateCompundInterest(time));
        }
    }
    /* Calculate simple interest */
    private static double calculateSimpleInterest(double time){
        double calculatedInterest,totalpayable;
        calculatedInterest=(principle*rate*time)/100;
        totalpayable = calculatedInterest + principle;
        return totalpayable;
    }
    /* Calculate compound interest */
    private static double calculateCompundInterest(double diff1){
        double CI = principle * (Math.pow((1 + rate/100),(time)));
        return CI;
    }
}