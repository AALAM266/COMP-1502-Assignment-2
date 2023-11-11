package model.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.BoardGames;

class BoardGameTest {

    @Test
    public void testConstructorAndToStringMethod() {
        BoardGames boardGame = new BoardGames("7734720369", "Doom: The Boardgame", "Gamefluent", 174.24, 10, 7, "Board Game", 2, 5, "Miller Knights");

        assertEquals("7734720369", boardGame.getSerialNumber());
        assertEquals("Doom: The Boardgame", boardGame.getName());
        assertEquals("Gamefluent", boardGame.getBrand());
        assertEquals(174.24, boardGame.getPrice(), 0.001);
        assertEquals(10, boardGame.getAvailabityCount());
        assertEquals(7, boardGame.getAppropriateAge());
        assertEquals("Board Game", boardGame.getToyType());
        assertEquals(2, boardGame.getMinPlayers());
        assertEquals(5, boardGame.getMaxPlayers());
        assertEquals("Miller Knights", boardGame.getDesigners());

        // this is temporary until we figure out how we actually wanna display things
        String expectedToString = "Category: Board Game, Serial Number: 7734720369, Name: Doom: The Boardgame, Brand: Gamefluent, Price: 174.24, Available Count: 10, Age Appropriate: 7, Number of Players: 2-5, Designer(s): Miller Knights";
        assertEquals(expectedToString, boardGame.toString());
    }
}
