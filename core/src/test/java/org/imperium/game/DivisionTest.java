package org.imperium.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DivisionTest {

    @Test
    void check(){
        int screenX = 10;
        int cellSize = 3;
        int result = screenX / cellSize;
        Assertions.assertEquals(3, result);
    }

}
