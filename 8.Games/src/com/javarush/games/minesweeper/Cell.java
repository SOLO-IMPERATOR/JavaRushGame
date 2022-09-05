package com.javarush.games.minesweeper;

import java.util.ArrayList;

public class Cell<T> {
    private int PosX;
    private int PosY;
    public  Cell(int x, int y){
        this.PosX =x;
        this.PosY =y;
    }
    public static  boolean exsistCell(Cell cell, ArrayList<? extends Cell> cells){
        try {
            boolean isExist = false;
            for(Cell c: cells) {
                if (c.getPosX() == cell.getPosX() && c.getPosY() == cell.getPosY()) {
                    isExist = true;
                    break;
                }
            }
            return isExist;
        }catch (IndexOutOfBoundsException e) {
            return  false;
        }
    }



    public int getPosX() {
        return PosX;
    }

    public int getPosY() {
        return PosY;
    }
}
