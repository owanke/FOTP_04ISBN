package oop.isbn;


public class Isbn
{

    public Isbn()
    {

    }

    public static String generateIsbn10(String input)
    {

        // remove bindestrich
        String prefix = input.replaceAll("\\D+", "");

        System.out.println("input: " + input);
        System.out.println("prefix: " + prefix);
        
     // check for invalid characters
        if (input.matches("[a-zA-Z]+"))
        {
            throw new IllegalArgumentException();
        }
        
        // check for length
        if (prefix.length() != 9)
        {
            throw new IllegalArgumentException();
        }

        // gewichtete Summe berechnen
        int summe = 0;
        for (int i = 0; i < 9; i++)
        {
            int digit = Integer.parseInt(prefix.substring(i, i + 1));
            summe = summe + (10 - i) * digit;
        }

        // pruefziffer berechnen
        int pruefziffer = (11 - (summe % 11)) % 11;

        String suffix;
        if (pruefziffer == 10)
        {
            suffix = "X";
        }
        else
        {
            suffix = Integer.toString(pruefziffer);
        }

        return input + "-" + suffix;
    }

    public static String generateIsbn13(String input)
    {

        // remove bindestrich
        String prefix = input.replaceAll("\\D+", "");

        
        // check for invalid characters
        if (input.matches("[a-zA-Z]+"))
        {
            throw new IllegalArgumentException();
        }
        // check for length
        if (prefix.length() != 12)
        {
            throw new IllegalArgumentException();
        }
        int summe1 = 0;
        int summe2 = 0;
        for (int i = 0; i < 12; i++)
        {
            int digit = Integer.parseInt(prefix.substring(i, i + 1));
            if ((i + 1) % 2 != 0)
            {
                summe1 = summe1 + digit;
            }
            else
            {
                summe2 = summe2 + digit;
            }

        }
        int summe = 3 * summe2 + summe1;
        int pruefziffer = (10 - summe % 10) % 10;
        String suffix = Integer.toString(pruefziffer);

        return input + "-" + suffix;
    }

}
