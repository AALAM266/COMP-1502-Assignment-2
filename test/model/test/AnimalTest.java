package model.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Animals;

class AnimalTest {

    @Test
    public void testConstructorAndToStringMethod() {
        Animals animal = new Animals("2835360879", "Cow", "Game Assassin", 19.52, 3, 7, "Animal", "Plastic", "M");

        assertEquals("2835360879", animal.getSerialNumber());
        assertEquals("Cow", animal.getName());
        assertEquals("Game Assassin", animal.getBrand());
        assertEquals(19.52, animal.getPrice());
        assertEquals(3, animal.getAvailabityCount());
        assertEquals(7, animal.getAppropriateAge());
        assertEquals("Animal", animal.getToyType());

        assertEquals("Plastic", animal.getMaterial());
        assertEquals("M", animal.getSize());

        // this is temporary until we figure out how we actually wanna display things
        String expectedToString = "Category: Animal, Serial Number: 2835360879, Name: Cow, Brand: Game Assassin, Price: 19.52, Available Count: 3, Age Appropriate: 7, Material: Plastic, Size: M";
        assertEquals(expectedToString, animal.toString());
    }
}

