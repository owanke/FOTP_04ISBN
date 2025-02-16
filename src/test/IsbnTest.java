package test;
import oop.isbn.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class IsbnTest
{
    

    @BeforeAll
    static void setUpBeforeClass() throws Exception
    {
    }

    @Test
    void testISBN10()
    {
        Isbn isbn = new Isbn();

//        assertEquals("3-446-45118-8", isbn.generateIsbn10("3-446-45118"));
        assertEquals("052135741-1", isbn.generateIsbn10("052135741"));
    }
    
    @Test
    void testISBN13()
    {
        Isbn isbn = new Isbn();
        assertEquals("X", isbn.generateIsbn13("000000000000"));
    }

}
