package com.javarush.games.minesweeper;

import java.util.ArrayList;

public class Cell<T> {
    private int PosX;
    private int PosY;
    public  Cell(int x, int y){
        this.PosX =x;
        this.PosY =y;
    }

    @Override
    public boolean equals(Object obj) {
        if(null == obj) return false;
        Cell<Cell> cell = (Cell) obj;
        if(this.getPosX() == cell.getPosX() && this.getPosY() == cell.getPosY()){
            return true;
        }else {
            return false;
        }
    }
    public static Cell findCellbyArray(ArrayList<? extends  Cell> arr, Cell<? extends Cell> cell){
        for (Cell<? extends Cell> c : arr){
            if(c.equals(cell)){
                return c;
            }
        }
        return null;
    }

    public int getPosX() {
        return PosX;
    }

    public int getPosY() {
        return PosY;
    }
}
