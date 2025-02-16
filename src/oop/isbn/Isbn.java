package oop.isbn;



public class Isbn
{
       
    public Isbn()
    {
       
    }
    
    public String generateIsbn10(String input)
    {
      
        
        
//      remove bindestrich
        String prefix = input.replaceAll("\\D+","");
        
        System.out.println("input: " +input);
        System.out.println("prefix: " +prefix);
        // check for length
        if (prefix.length() != 9)
        {
            throw new IllegalArgumentException();
        }
        
//      gewichtete Summe berechnen
        int summe=0;
        for(int i=0;i<9;i++)
        {
            summe = summe + (10-i)*prefix.charAt(i);
        }
        
//      pruefziffer berechnen   
        int pruefziffer = (11-(summe%11))%11;
        
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
    
    public String generateIsbn13(String prefix)
    {
        String pruefziffer;
        pruefziffer="";
//        remove bindestrich
        prefix = prefix.replaceAll("\\D+","");
        
//      check for length
        if (prefix.length() != 12)
        {
            throw new IllegalArgumentException();
        }
        return prefix + pruefziffer;
    }
    

}
