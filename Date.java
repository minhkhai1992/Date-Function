import java.util.*;
/**
 * The class will hold all method, variables and process them.
 * The class access all user input from Driver and calculate them.
 * The Date class has method use for add, subtract, Day between two days, format day
 * The Date class also has compareTo method, and equals method.
 * 
 * @author (Khai Lim)
 * @version (11/13/2017)
 */
public class Date
{
    private int day; // create and store a day number by integer type and access in method.
    private int month; // create and store a month number by integer type and access in method.
    private int year; // create and store a year number by integer type and access in method.
    Scanner input = new Scanner(System.in); //create a new Scanner to get a value in method
    
    /**
     * This no-args constructor will be set as a year of software become popular
     * All variable in constructor method will default.
     */ 
    public Date()
    {
        day = 1;
        month = 1;
        year = 1980;    
    }
    
    /**
     * This constructor allows the user to create Date object by sending all value of Date in the method
     * The input value Date will access for calculation in Date class and call out in the Driver class.
     * @param int - The value of day, month , year presents for object what we already another class.
     */
    public Date(int d, int m, int y)
    {
        this.day = d;
        this.month = m;
        this.year = y;
    }
    
    /**
     * The Date class has add method that access for calculation add a day in the object Date.
     * The add method able to check all condition month has 30, 31 and February for 28 29 days.
     * The loop will keep run until the day is exits.
     * @param int representing for the number user input want to add in the previous Date.
     * return a new Date.
     */
    public Date add (int numDays)
    {
        Date obj;
        day = day + numDays;
        boolean keepGoing = true;
        while (keepGoing)
        {
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            {
                if (day > 31)
                {
                    day = day - 31;
                    month++;
                }
                if (month > 12)
                {
                    month = 1;
                    year++;
                }
                if (day <= 31)
                    keepGoing = false;
            }
            else if (month == 4 || month == 6 || month == 9 || month == 11)
            {
                if (day > 30)
                {
                    day = day - 30;
                    month++;
                }
                if (day <= 30)
                    keepGoing = false;
            }
            else if (month == 2)
            {
                if ((year % 4) == 0)
                {
                    if (day > 29)
                    {
                        day = day - 29;
                        month++;
                    }
                    if (day <= 29)
                        keepGoing =  false;
                }
                else
                {
                    if (day > 28)
                    {
                        day = day - 28;
                        month++;
                    }
                    if (day < 28)
                        keepGoing =  false;
                }
            }
        }
        obj = new Date(day,month,year);
        return obj;
    }
    
    /**
     * The Date class has subtract method that access for calculation subtract a day in the object Date.
     * The add method able to check all condition month has 30, 31 and February for 28 29 days.
     * The loop will keep run until the day is exits. 
     * @param int representing for the number user input want to subtract in the previous Date.
     * return a new Date.
     */
    public Date substract (int numDays)
    { 
        day = (numDays * -1) + day;
        month--;
        boolean keepGoing = true;
        while (keepGoing)
        {
            if ( month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            {
                if (day < 0)
                {
                    day = day + 31;
                    if (day > 0)
                        keepGoing = false;
                    else
                    {
                        month--;
                        keepGoing = true;
                    }
                    if (month == 0 )
                    {
                        month = 12;
                        year--;
                    }
                }
                else if (day == 0)
                {                    
                    if (month == 2 && (year%4) == 0)
                    {
                        month--;
                        day = 29;
                        keepGoing = true;
                    }
                    else if (month == 2 && !((year%4)== 0))
                    {
                        month--;
                        day = 28;
                        keepGoing = true;
                    }
                    else if ( month == 4 || month == 6 || month == 9 || month == 11)
                    {
                        month--;
                        day = 30;
                        keepGoing = true;
                    }                   
                                    
                }
                else if (day > 0)
                {                    
                    keepGoing = false;
                    if (month == 0 )
                    {
                        month = 12;
                        year--;
                    }
                }             
                
            }
            else if ( month == 4 || month == 6 || month == 9 || month == 11)
            {
                if (day < 0)
                {
                    day = day + 30;
                    if (day > 0)
                    {
                        keepGoing = false;
                    }
                    else
                    {
                        month--;
                        keepGoing = true; 
                    }
                }
                else if (day == 0)
                {
                    day = 31;
                    month--;
                    keepGoing = false;       
                }
                else if (day > 0)
                {                    
                    keepGoing = false;
                }
            }
            else if (month == 2)
            {
                if((year%4) == 0)
                {
                    if (day > 0)
                    {
                        keepGoing = false;
                    }
                    else if (day == 0)
                    {
                        day = 31;
                        month--;
                        keepGoing = false;
                    }
                    else if (day < 0)
                    {
                        day = day + 29;
                        if (day > 0)
                        {
                            keepGoing = false;
                        }
                        else
                        {
                            month--;
                            keepGoing = true;
                        }
                    }                    
                }
                else
                {
                    if (day > 0)
                    {
                        keepGoing = false;
                    }
                    else if (day == 0)
                    {
                        day = 31;
                        month--;
                        keepGoing = false;
                    }
                    else if (day < 0)
                    {   
                        day = day + 28;
                        month--;
                        keepGoing = true;
                    }
                }
            
            }
            else if (month == 0)
            {
                month = 12;
                year--;
                keepGoing = true;
            }
        }      
        return new Date(day,month,year);
    }
    
    /**
     * The daysBetween method access the compareTo method to check which Date is greater
     * and set position for each of them further to connect to use in another method
     * use the calculation to calculate the day between two date.
     * @param Date Another to hold another Date for check and set up the position for each.
     */
    public int daysBetween (Date anotherDate)
    {
        int[] days_in_month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int dd, mm, yy, d, m, y;
        int days = 0;
        boolean running = true;
        if (this.compareTo(anotherDate) == 2)
        {
            yy = this.year;
            mm = this.month;
            dd = this.day;
            y = anotherDate.getYear();
            m = anotherDate.getMonth();
            d = anotherDate.getDay();
        }
        else
        {
            yy = anotherDate.getYear();
            mm = anotherDate.getMonth();
            dd = anotherDate.getDay();
            y = this.year;
            m = this.month;
            d = this.day;
        }
    
    
        while (running)
        {
            if (mm == m && yy == y)
            {
                days = days + (dd - d);
                dd = d;
            }
            else
            {
                days = days + dd;
                mm = mm - 1;
                if (mm == 0)
                {
                    mm = 12;
                    yy = yy -1;
                }
                
                dd = days_in_month[mm];
                if (mm == 2 && yy % 4 == 0)
                {
                    dd = dd + 1;
                }
            }
            if (dd == d && mm == m && yy == y)
            {
                running = false;
            }
        }
        return days;
    }
    
    /**
     * The equals method will check and compare that are they the same.
     * @param Date date will hold another Date and check is this equals each other
     * They will return true if they are equals, false if they are not equals
     */
    public boolean equals(Date date)
    {
        if (compareTo(date) == 0)
            return true;
        else
            return false;
    }
    
    /**
     * The compareTo method will compare between two day further for future check.
     * @param Date anotherDate that hold address and compare to check which date is greater
     * return the integer number.
     */
    public int compareTo(Date anotherDate)
    {
        // if this one is greater than anotherDate, return 2
        // if this one is less than the otherDate, return 1
        // if they are the same, return 0
        int value = 0;
        
        if (this.year > anotherDate.getYear())
        {
            value = 2;
        }
        else if (this.year < anotherDate.getYear())
        {
            value = 1;
        }
        else
        {
            if (this.month > anotherDate.getMonth())
            {
                value = 2;
            }
            else if (this.month < anotherDate.getMonth())
            {
                value = 1;
            }
            else
            {
                if (this.day > anotherDate.getDay())
                {
                    value = 2;
                }
                else if (this.day < anotherDate.getDay())
                {
                    value = 1;
                }
                else
                {
                    value = 0;
                }
            }
        }
        return value;
    }
    
    /**
     * The String getDate will get a format of the day that how user want to be display out
     * The getDate method created a Array String to mark a number of month and display in long format
     * @param char represents for format character that how user want to display out
     * The parameter input shows long format and short format.
     */ 
    public String getDate(char format) // take a character and 's' or 'l' 
    {
        String value = "";
        if (format == 'l' || format == 'L')
        {
            String[] months = {"", "January", "February", "March", "April", "May", "June", 
                            "July", "August", "September", "October", "November", "December"};            
            value = "" + months[month] + " " + day + ", " + year;
        }
        else
        {
            value = "" + month + "/" + day + "/" + year;
        }        
        return value;
    }
    
    /**
     * The set month method allows to get the value of month what user input
     * and check all condition to satisfy and ensure it is a right month.
     * @param int month presents the value number of month can only be integer number.
     * The value contain all month has 30, 31 and February has 28 and 29 days.
     */
    public void setMonth(int m)
    {
        while (m < 1 || m > 12)
        {
            System.out.print("The Month is invalid !!! Please enter number of month again: ");
            m = input.nextInt();
        }
        
        if (m == 4 || m == 6 || m == 9 || m == 11)
        {
            if(day > 30) //they only have 30 day in a month
            {
                 do
                 {
                    System.out.println("Invalid day");
                    System.out.println("Please enter Day number again(this month can't greater 30 or negative number)");
                    day = input.nextInt();
                 }while(day > 30 || day < 0);
            }
            else
            {                    
                day = day;
            }
        }
        else if (m == 2)
        {
            if((year%4) == 0) // leap year 29 days
            {
                if (day > 29) // day condition re-input again 
                {
                     do
                     {
                        System.out.println("February don't have greater 29 in leap year!!!");
                        System.out.println("Please enter Day number again(non-negative number)");
                        day = input.nextInt();
                     }while(day > 29 || day < 0);
                
                }
            }
            else // normal year only 28 days
            {
                if (day > 28) // day condition re-input again 
                {
                     do
                     {
                        System.out.println("February don't have greater 28 in normal year!!!");
                        System.out.println("Please enter Day number again(non-negative number)");
                        day = input.nextInt();
                     }while(day > 28 || day < 0);
                
                }
            
            }
        
        }
        this.month = m;
    }
    
    /**
     * The set monday method allows to get the value of day what user input
     * and check all condition to satisfy and ensure it is a right day.
     * @param int day presents the value number of day can only be integer number.
     * The value ensure it can not be negative number or any number greater than 31.
     */
    public void setDay(int d)
    {
        while (d < 1 || d > 31)
        {
            System.out.print("The Day is invalid !!! Please enter number of day again: ");
            d = input.nextInt();            
        }
        this.day = d;
    }
    
    /**
     * The set year method allows to get the value of year what user input
     * and check all condition to satisfy year.
     * @param int year presents the value number of year can only be integer number.
     * The value can not be a negative or zero.
     */
    public void setYear(int y)
    {
        while (y < 1)
        {
            System.out.println("The Year is invalid !!! Please enter number of year again: ");
            y = input.nextInt();
        }
        this.year = y;
    }    
    
    /**
     * The get Month method will get and change specific object month
     * return the int number of month.
     */
    public int getMonth()
    {
        return month;
    }
    
    /**
     * The get day method will get and change specific object day
     * return the int number of day.
     */
    public int getDay()
    {
        return day;
    }
    
    /**
     * The get year method will get and change specific object year
     * return the int number of year.
     */
    public int getYear()
    {
        return year;
    }
    
    /**
     * String toString method will display all variable we collect and calculated above of class
     * return String.
     */
    public String toString()
    {
        return month + "/" + day + "/" + year;
    }
    
    /**
     * The method day in year will check and calculate a object specific day.
     * The method access the daysBetween method to calculate a day in that year.
     * The day in year doesn't inclulde end date in calculation.
     * return the day number in year.
     */
    public int dayInYear()
    {  
        Date thisDay = new Date(this.day, this.month, this.year);
        Date firstDayOfYear = new Date (1, 1, this.year);
        int daysInYear = thisDay.daysBetween(firstDayOfYear);
        
        return daysInYear + 1;
    
    }
    
    /**
     * The get Horoscope method will check specific object date
     * and which object date belong in horoscope sign
     * return String of horoscope.
     */
    public String getHoroscope()
    {
        switch(this.month)
        {
            case 1:
                if (this.day > 19)
                {
                    return "Aquarius";
                }
                else
                {
                    return "Capricorn";
                }
            case 2:
                if (this.day > 18)
                {
                    return "Pisces";
                }
                else
                {
                    return "Aquarius";
                }
            case 3:
                if (this.day > 20)
                {
                    return "Aries";
                }
                else
                {
                    return "Pisces";
                }
            case 4:
                if (this.day > 19)
                {
                    return "Taurus";
                }
                else
                {
                    return "Aries";
                }
            case 5:
                if (this.day > 20)
                {
                    return "Gemini";
                }
                else
                {
                    return "Taurus";
                }
            case 6:
                if (this.day > 20)
                {
                    return "Cancer";
                }
                else
                {
                    return "Gemini";
                }
            case 7:
                if (this.day > 22)
                {
                    return "Leo";
                }
                else
                {
                    return "Cancer";
                }
            case 8:
                if (this.day > 22)
                {
                    return "Virgo";
                }
                else
                {
                    return "Leo";
                }
            case 9:
                if (this.day > 22)
                {
                    return "Libra";
                }
                else
                {
                    return "Virgo";
                }
            case 10:
                if (this.day > 22)
                {
                    return "Scorpio";
                }
                else
                {
                    return "Libra";
                }
            case 11:
                if (this.day > 21)
                {
                    return "Sagittarius";
                }
                else
                {
                    return "Scorpio";
                }
            case 12:
                if (this.day > 21)
                {
                    return "Capricorn";
                }
                else
                {
                    return "Sagittarius";
                }
                  
        }
        return "";    
    
    }
}
