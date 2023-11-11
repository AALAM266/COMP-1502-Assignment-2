package model.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Puzzles;

class PuzzleTest {

    @Test
    public void testConstructorAndToStringMethod() {
        Puzzles puzzle = new Puzzles("5239019250", "Nob Yoshigahara Puzzle", "Game Zombie", 67.20, 5, 3, "M", null);

        assertEquals("5239019250", puzzle.getSerialNumber());
        assertEquals("Nob Yoshigahara Puzzle", puzzle.getName());
        assertEquals("Game Zombie", puzzle.getBrand());
        assertEquals(67.20, puzzle.getPrice());
        assertEquals(5, puzzle.getAvailabityCount());
        assertEquals(3, puzzle.getAppropriateAge());
        assertEquals("M", puzzle.getToyType());
        assertNull(puzzle.getPuzzleType());

        // this is temporary until we figure out how we actually wanna display things
        String expectedToString = "Category: M, Serial Number: 5239019250, Name: Nob Yoshigahara Puzzle, Brand: Game Zombie, Price: 67.2, Available Count: 5, Age Appropriate: 3, Puzzle Type: null";
        assertEquals(expectedToString, puzzle.toString());
    }
}
