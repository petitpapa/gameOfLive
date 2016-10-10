package com.petitpapa.game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by petitpapa
 * on 10/10/2016.
 */
public class GameLifeApp {
    private static Grid grid;
    private static ScheduledExecutorService scheduler;

    public static void main(String[] args) throws FileNotFoundException {
        Path path = Paths.get("C:\\Users\\petitpapa\\IdeaProjects\\gameOfLife\\game.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(String.valueOf(path.getFileName())))) {
            System.out.println("text file");
            int rowCount = Integer.parseInt(br.readLine());
            System.out.println(rowCount);
            int colCount = Integer.parseInt(br.readLine());
            System.out.println(colCount);
            grid = new Grid(rowCount, colCount);

            for (int i = 0; i < rowCount; i++)
                grid.addRow(br.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!grid.hasLiveCell())
            stop();
        else
            start();
    }

    private static void start() {
        stop();
        Runnable generationTask = () -> {
            System.out.println(grid.print());
            grid.nextGeneration();
            if (!grid.hasLiveCell()) {
                stop();

            }
        };

        scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(generationTask, 0, 500, TimeUnit.MILLISECONDS);
    }

    private static void stop() {
        if (scheduler != null) {
            scheduler.shutdown();
            scheduler = null;
            grid.reset();
        }
    }
}
