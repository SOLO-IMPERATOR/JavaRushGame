package com.javarush.games.minesweeper;

import java.util.ArrayList;
import java.util.Random;

public class CellBomb extends Cell{
    private static ArrayList <CellBomb> cellsWthBombs = new ArrayList<>();
    private CellBomb(int x, int y) {
        super(x, y);
    }
    public static void fillBombs(int width, int height, int countBombs){
        Random random = new Random();

        while (cellsWthBombs.size() < countBombs){
            CellBomb c = new CellBomb(random.nextInt(width),random.nextInt(height));
            if(!cellsWthBombs.contains(c)){
                cellsWthBombs.add(c);
            }
        }
    }
    public static ArrayList<CellBomb> getCellsWthBombs(){
        return  cellsWthBombs;
    }
}
