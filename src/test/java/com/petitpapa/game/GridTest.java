package com.petitpapa.game;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by
 * petitpapa on 10/9/2016.
 */
public class GridTest {
    private Grid grid;

    @Before
    public void setUp(){
        grid = new Grid(3,3);
    }

    @Test
    public void initialBoardStateShouldAllBeDots(){
        assertThat(grid.print(), is("..." +"\n" +
                                    "..." + "\n" +
                                    "..." + "\n"));
    }
    @Test
    public void verifyGridCreation(){
        grid.addRow(".*.");
        assertThat(grid.print(), is(".*." +"\n" +
                                    "..." + "\n" +
                                    "..." + "\n"));
    }

    @Test
    public void setSeedInAllGrid(){
        grid.addRow(".*.");
        grid.addRow("**.");
        grid.addRow(".**");
        assertThat(grid.print(), is(".*." +"\n" +
                                    "**." + "\n" +
                                    ".**" + "\n"));
    }

    @Test
    public void getNextGeneration(){
        grid.addRow(".*.");
        grid.nextGeneration();
        assertThat(grid.print(), is("..." +"\n" +
                                    "..." + "\n" +
                                    "..." + "\n"));
    }
}