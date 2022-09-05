package com.javarush.games.minesweeper;

import java.util.ArrayList;

public class CellWithoutBomb extends  Cell{
    private  String cellValue = "";
    private  boolean show = false;
    private static ArrayList<CellWithoutBomb> cells = new ArrayList<>();

    private CellWithoutBomb(int x, int y, String value) {
        super(x, y);
        this.cellValue =value;
    }
    public static ArrayList<CellWithoutBomb> createCells(ArrayList<CellBomb> cellsbombs, int width, int height){
        for (int i=0;i<width;i++){
            for (int j=0;j<width;j++){
                CellWithoutBomb cell = new CellWithoutBomb(i,j,CountBombAround(new Cell(i,j),cellsbombs,width,height));
                if(!cellsbombs.contains(cell)){
                    cells.add(cell);
                }
            }
        }
        return cells;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public static ArrayList<CellWithoutBomb> getCells() {
        return cells;
    }

    private static String CountBombAround(Cell cell, ArrayList<CellBomb> cellsbombs, int width, int height){
        int countBomb = 0;
        if(cellsbombs.contains(new Cell(cell.getPosX()-1,cell.getPosY()))){
            countBomb +=1;
        }
        if(cellsbombs.contains(new Cell(cell.getPosX()+1,cell.getPosY()))){
            countBomb +=1;
        }
        if(cellsbombs.contains(new Cell(cell.getPosX(),cell.getPosY()-1))){
            countBomb +=1;
        }
        if(cellsbombs.contains(new Cell(cell.getPosX(),cell.getPosY()+1))){
            countBomb +=1;
        }
        if(cellsbombs.contains(new Cell(cell.getPosX()+1,cell.getPosY()+1))){
            countBomb +=1;
        }
        if(cellsbombs.contains(new Cell(cell.getPosX()-1,cell.getPosY()+1))){
            countBomb +=1;
        }
        if(cellsbombs.contains(new Cell(cell.getPosX()+1,cell.getPosY()-1))){
            countBomb +=1;
        }
        if(cellsbombs.contains(new Cell(cell.getPosX()-1,cell.getPosY()-1))){
            countBomb +=1;
        }
        if(countBomb == 0){
            return "";
        }
        return String.valueOf(countBomb);
    }

    public String getCellValue() {
        return cellValue;
    }
}
