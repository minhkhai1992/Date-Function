import java.util.*;
/**
 * The main() Driver allows user to enter the input number of Day, Month and Year
 * The Driver will give user the option to pick all function Add, Subtract, Day Between, Day Format
 * All the function ensure it run correctly by themselves.
 * Every user input will ensure that they are valid before use them in the function.
 * The equals method and compare to method for check the date will in format option.
 *
 * @author (Khai Lim)
 * @version (11/13/2017)
 */
public class DriverDate
{
    public static void main (String[] args)
    {
        int day, month, year;   //declare variable will hold day, month, year by integer number
        char userInput;         //declare variable will hold character of user input
        int addDay, subDay;     //declare variable will hold add day and subtract day by integer number
        
        
        Date obj = new Date();  //reference variable for the first Date object
        Date obj1 = new Date(); // reference variable for the second Date object.
        
        Scanner input = new Scanner(System.in); //reference variable for user input. new scanner for keyboard input        
        
        System.out.println("\t\t\t\tWelcome to Khai Lim Calculation Date !!!");
        System.out.println("\t---------------The program will require base on Month/Day/Year for run a program ---------------\n");
        System.out.print("Enter the Day number: ");
        day = input.nextInt();      //get and store day number by user input.
        obj.setDay(day);            //send the day in a object in another class to check day condition
        
        System.out.print("Enter the Month number: ");
        month = input.nextInt();    //get and store month number by user input.
        obj.setMonth(month);        //send the month in a object in another class to check month condition
        
        System.out.print("Enter the Year number: ");
        year = input.nextInt();     //get and store year number by user input.
        obj.setYear(year);          //send the year in a object in another class to check year condition.
        
        //The loop will give options for user pick what function user want to use.
        do
        {
            input.nextLine();
            System.out.print("\nMenu: " + "\n[A]Add" + "\n[S]SubStract" + "\n[D]Day Between" + "\n[F]Day format"+ "\n[Q]Quit" + "\n\nEnter: ");
            userInput = input.nextLine().toUpperCase().charAt(0); //get the first character in a line and upper case them.
            
        }while(userInput != 'A' && userInput !='S' && userInput !='D' && userInput !='F' && userInput !='Q');
        
        //The while will keep process next function. it won't keep the old date that what you entered.        while(userInput != 'Q')
        {
            // The program will use the switch to check the case with character and run the function individual.
            switch(userInput)
            {
                case 'A': //Switch case for add number.
                        do
                        {
                            System.out.println("Note: The Add number should be greater than 0");
                            System.out.println("How many days you want to add in ?");
                            addDay = input.nextInt(); //get add day input.
                        }while(addDay < 1);
                        obj.add(addDay); // send add day number to add to calculate
                        System.out.println("The Date after added " + addDay + " is " + obj);
                        break;
                case 'S':   // Switch case for subtract number.
                        do
                        {
                            System.out.println("Note: The Subtract number should be greater than 0");
                            System.out.println("How many days you want to subtract in ?");
                            subDay = input.nextInt(); // get subtract day input
                        }while(subDay < 1);
                        obj.substract(subDay); // send subtract number to subtract to calculate
                        System.out.println("The Date after subtract " + subDay + " is " + obj);
                        break;
                case 'D':   // Switch case for check the day between two day.
                        System.out.println("Note: The day between require information of 2nd day !!!\nThe Day between will check equals if they do.");
                        System.out.print("Enter 2nd Day number: ");
                        day = input.nextInt();  //get the 2nd day
                        obj1.setDay(day);       // send it to day to check condition
                        
                        System.out.print("Enter 2nd Month number: ");
                        month = input.nextInt(); // get the 2nd month
                        obj1.setMonth(month);    // send it to month to check condition
                        
                        System.out.print("Enter 2nd Year number: ");
                        year = input.nextInt();     //get the 2nd year
                        obj1.setYear(year);         // send it to check condition
                        
                        System.out.println("The 2nd Date (month/day/year): " + month + "/" + day + "/" + year);
                        System.out.println("The day between " + obj + " and " + obj1 + " is: " + obj.daysBetween(obj1));
                        if (obj.equals(obj1))
                        {
                            System.out.println("They are equals");
                        }
                        else
                        {
                            System.out.println("They are not equals");
                        }
                        break;
                case 'F':   //The Switch case will display the format of the day.
                        System.out.println("Note: either Long format or short format still include: Horoscope, day in year");
                        do
                        {
                            System.out.println("Please Enter \t[L]: Long Format \t[S]: Short Format");
                            System.out.print("Enter Character: ");
                            userInput = input.nextLine().toUpperCase().charAt(0);           //get user input by String                            
                        }while(userInput != 'L' && userInput != 'S');
                        
                        System.out.println("Your format will be: " + obj.getDate(userInput));
                        System.out.println(obj.getDate(userInput) + " will fall in " + obj.getHoroscope());
                        if ((obj.dayInYear()%10) == 1)
                        {
                            System.out.println("The day you entered fall in: " + obj.dayInYear() + "st day of year " + obj.getYear());
                        }
                        else if((obj.dayInYear()%10) == 2)
                        {
                            System.out.println("The day you entered fall in: " + obj.dayInYear() + "nd day of year " + obj.getYear());
                        }
                        else if((obj.dayInYear()%10) == 3)
                        {
                            System.out.println("The day you entered fall in: " + obj.dayInYear() + "rd day of year " + obj.getYear());
                        }
                        else
                        {
                            System.out.println("The day you entered fall in: " + obj.dayInYear() + " th of year " + obj.getYear());
                        }                        
                        break;
            }// end switch case
            
            // the loop if ask the user still want to run a program or quit.
            do
            {
                input.nextLine();
                System.out.println("\nMenu: " + "\n[A]Add" + "\n[S]SubStract" + "\n[D]Day Between" + "\n[F]Day format"+ "\n[Q]Quit");
                System.out.print("Enter: ");
                userInput = input.nextLine().toUpperCase().charAt(0);                
            }while (userInput != 'A' && userInput != 'S' && userInput != 'D' && userInput != 'F' && userInput != 'Q');
        } // end while loop
        System.out.println("The Program are Quit !!!"); 
        System.exit(0);
    }
}
