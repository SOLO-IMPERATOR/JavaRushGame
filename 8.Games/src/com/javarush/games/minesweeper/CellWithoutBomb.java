package com.javarush.games.minesweeper;

import java.util.ArrayList;

public class CellWithoutBomb extends  Cell{
    private  int cellValue = 0;
    private static ArrayList<CellWithoutBomb> cells = new ArrayList<>();

    private CellWithoutBomb(int x, int y, int value) {
        super(x, y);
        this.cellValue =value;
    }
    public static ArrayList<CellWithoutBomb> createCells(ArrayList<CellBomb> cellsbombs, int width, int height){
        for (int i=0;i<width;i++){
            for (int j=0;j<width;j++){
                CellWithoutBomb cell = new CellWithoutBomb(i,j,CountBombAround(new Cell(i,j),cellsbombs,width,height));
                if(!Cell.exsistCell(cell,cellsbombs)){
                    cells.add(cell);
                }
            }
        }
        return cells;
    }

    public static ArrayList<CellWithoutBomb> getCells() {
        return cells;
    }

    private static int CountBombAround(Cell cell, ArrayList<CellBomb> cellsbombs, int width, int height){
        int countBomb = 0;
        if(Cell.exsistCell(new Cell(cell.getPosX()-1,cell.getPosY()),cellsbombs)){
            countBomb +=1;
        }
        if(Cell.exsistCell(new Cell(cell.getPosX()+1,cell.getPosY()),cellsbombs)){
            countBomb +=1;
        }
        if(Cell.exsistCell(new Cell(cell.getPosX(),cell.getPosY()-1),cellsbombs)){
            countBomb +=1;
        }
        if(Cell.exsistCell(new Cell(cell.getPosX(),cell.getPosY()+1),cellsbombs)){
            countBomb +=1;
        }
        if(Cell.exsistCell(new Cell(cell.getPosX()+1,cell.getPosY()+1),cellsbombs)){
            countBomb +=1;
        }
        if(Cell.exsistCell(new Cell(cell.getPosX()-1,cell.getPosY()+1),cellsbombs)){
            countBomb +=1;
        }
        if(Cell.exsistCell(new Cell(cell.getPosX()+1,cell.getPosY()-1),cellsbombs)){
            countBomb +=1;
        }
        if(Cell.exsistCell(new Cell(cell.getPosX()-1,cell.getPosY()-1),cellsbombs)){
            countBomb +=1;
        }
        return countBomb;
    }

    public int getCellValue() {
        return cellValue;
    }
}
