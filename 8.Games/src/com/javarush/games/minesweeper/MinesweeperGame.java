package com.javarush.games.minesweeper;

import com.javarush.engine.cell.*;

import java.util.ArrayList;


public class MinesweeperGame extends Game {
    
    @Override
    public void initialize(){
        GameMap game = new GameMap(10,10,Color.YELLOW, Color.BLUE, 50, LVLMAP.EASY);
        setScreenSize(game.getWidth(),game.getHeight());
        CellBomb.fillBombs(game.getWidth(),game.getHeight(),game.getCountBomb());
        CellWithoutBomb.createCells(CellBomb.getCellsWthBombs(),game.getWidth(),game.getHeight());
        fitMap(game,CellBomb.getCellsWthBombs(), CellWithoutBomb.getCells());
        
    }
    public void fitMap(GameMap game, ArrayList<CellBomb> cellsbomb,ArrayList<CellWithoutBomb> cellswthoutbomb){
        for (CellBomb c : cellsbomb){
            setCellValueEx(c.getPosX(), c.getPosY(), Color.RED, "", game.getValueColor(), game.getFontSize());
        }
        for (CellWithoutBomb c: cellswthoutbomb){
            setCellValueEx(c.getPosX(), c.getPosY(), game.getCellColor(), String.valueOf(c.getCellValue()), game.getValueColor(), game.getFontSize());
        }


    }
    
}