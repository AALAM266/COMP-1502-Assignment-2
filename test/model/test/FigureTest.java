package model.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Figures;

class FigureTest {

    @Test
    public void testConstructorAndToStringMethod() {
        Figures figure = new Figures("0766777773", "Fashion doll", "Game Sky", 42.18, 12, 3, "Doll", "D");

        assertEquals("0766777773", figure.getSerialNumber());
        assertEquals("Fashion doll", figure.getName());
        assertEquals("Game Sky", figure.getBrand());
        assertEquals(42.18, figure.getPrice(), 0.001);
        assertEquals(12, figure.getAvailabityCount());
        assertEquals(3, figure.getAppropriateAge());
        assertEquals("Doll", figure.getToyType());
        assertEquals("D", figure.getClassification());
        
        // this is temporary until we figure out how we actually wanna display things
        String expectedToString = "Category: Doll, Serial Number: 0766777773, Name: Fashion doll, Brand: Game Sky, Price: 42.18, Available Count: 12, Age Appropriate: 3, Classification: D";
        assertEquals(expectedToString, figure.toString());
    }
}
