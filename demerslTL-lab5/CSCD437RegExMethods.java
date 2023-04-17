//Name: Louden Demers
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSCD437RegExMethods
{

    public static void SSNPattern(final String str, final PrintStream fout)
    {
        if(str == null || str.isEmpty())
            throw new IllegalArgumentException("Bad str Parameter to the method");

        boolean res = Pattern.matches("[0-9]{3}[-|\\s]?[0-9]{2}[-|\\s]?[0-9]{4}", str);

        fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());


    }// end SSN

    public static void phonePattern(final String str, final PrintStream fout)
    {
        if(str == null || str.isEmpty())
            throw new IllegalArgumentException("Bad str Parameter to the method");


        boolean res = Pattern.matches("^([+]1\\s)?[(]?\\d{3}[)]?[\\s-]?\\d{3}[\\s-]?\\d{4}$", str);


        fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());


    }// end phoneNumber


    public static void emailPattern(final String str, final PrintStream fout)
    {
        if(str == null || str.isEmpty())
            throw new IllegalArgumentException("Bad str Parameter to the method");

        boolean res = Pattern.matches("([[^.]\\.]*)(?<![.])[@+][[^.]\\.]{2,}", str); //remove other @


        fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());



    }// end email


    public static void namePattern(final String str, final PrintStream fout)
    {
        if(str == null || str.isEmpty())
            throw new IllegalArgumentException("Bad str Parameter to the method");

        boolean res = Pattern.matches("[A-Z][a-z]+,\\s[A-Z][a-z]+(,\\s[A-Z]+)?", str);


        fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());

        /*
        Demers, Louden, A
        Travolta, John, JTOPAKJAS

        demers, louden, a
         */


    }// end name


    public static void datePattern(final String str, final PrintStream fout)
    {
        if(str == null || str.isEmpty())
            throw new IllegalArgumentException("Bad str Parameter to the method");

        //VERY LONG REGEX: Can be understood by breaking it up at the "|"
        //I unfortunately, only thought to use a helper method after completing this much
        //Months with 31 days:
        //((0[13578]|1[02])[/](0[1-9]|[12][0-9]|3[01])[/](18|19|20)[0-9]{2})
        //Months with 30 days:
        //((0[469]|11)[/](0[1-9]|[12][0-9]|30)[/](18|19|20)[0-9]{2})
        //Feb (not on a leap year):
        //(02)[/](0[1-9]|1[0-9]|2[0-8])[/](18|19|20)[0-9]{2}
        //Feb (ON a leap year):
        //(02)[/]29[/](((18|19|20)(04|08|[2468][048]|[13579][26]))|2000)
        //THEN JUST PIPE THEM TOGETHER
        boolean res = Pattern.matches("(([0]?[13578]|1[02])[/](0[1-9]|[12][0-9]|3[01])[/](18|19|20)[0-9]{2})|(([0]?[469]|11)[/](0[1-9]|[12][0-9]|30)[/](18|19|20)[0-9]{2})|([0]?(2)[/](0[1-9]|1[0-9]|2[0-8])[/](18|19|20)[0-9]{2})|([0]?(2)[/]29[/](((18|19|20)(04|08|[2468][048]|[13579][26]))|2000))|(([0]?[13578]|1[02])[-](0[1-9]|[12][0-9]|3[01])[-](18|19|20)[0-9]{2})|(([0]?[469]|11)[-](0[1-9]|[12][0-9]|30)[-](18|19|20)[0-9]{2})|([0]?(2)[-](0[1-9]|1[0-9]|2[0-8])[-](18|19|20)[0-9]{2})|([0]?(2)[-]29[-](((18|19|20)(04|08|[2468][048]|[13579][26]))|2000))", str);


        fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());
    }// end date


    public static void militaryTimePattern(final String str, final PrintStream fout)
    {
        if(str == null || str.isEmpty())
            throw new IllegalArgumentException("Bad str Parameter to the method");

        boolean res = Pattern.matches("^([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$", str);


        fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());
    }// end militaryTime


    public static void moneyPattern(final String str, final PrintStream fout)
    {
        if(str == null || str.isEmpty())
            throw new IllegalArgumentException("Bad str Parameter to the method");

        boolean res = Pattern.matches("^\\$(0|[1-9]\\d{0,2})(,\\d{3})*(\\.\\d{2})$", str);


        fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());

    }// end money


    public static void passwordPattern(final String str, final PrintStream fout)
    {
        if(str == null || str.isEmpty())
            throw new IllegalArgumentException("Bad str Parameter to the method");

        boolean res = Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[^A-Za-z0-9])(?=\\S+$).{10,}(?!.*[a-z]{4,}).*$", str);


        fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());

    }// end password

}// end class
