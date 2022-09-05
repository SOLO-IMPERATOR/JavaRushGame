package com.javarush.games.minesweeper;

import com.javarush.engine.cell.*;

import java.util.ArrayList;


public class MinesweeperGame extends Game {
    private static GameMap game;
    private static boolean endGame = false;
    private static int countCellsWithoutBombs;
    private  static int currentCountFlag = 0;
    private static  int myScore =0;
    @Override
    public void initialize() {
        game = GameMap.getInstance(10, 10, Color.SKYBLUE , Color.WHITE, 50, LVLMAP.EASY);
        setScreenSize(game.getWidth(), game.getHeight());
        CellBomb.fillBombs(game.getWidth(), game.getHeight(), game.getCountBomb());
        CellWithoutBomb.createCells(CellBomb.getCellsWthBombs(), game.getWidth(), game.getHeight());
        countCellsWithoutBombs = CellWithoutBomb.getCells().size();
        fitMap(game, CellBomb.getCellsWthBombs(), CellWithoutBomb.getCells());

    }
    @Override
    public void onMouseLeftClick(int x, int y) {
        if(!endGame){
            if (!checkCell(x, y)) {
                setCellValueEx(x, y, Color.BLACK, "\uD83D\uDCA3", Color.WHITE, game.getFontSize());
                showMessageDialog(Color.WHITE, "Вы Проиграли :(", Color.ORANGE, game.getFontSize());
                endGame = true;
            }
            if(countCellsWithoutBombs == 0){
                showMessageDialog(Color.WHITE, "Вы победили", Color.GREEN, game.getFontSize());
                endGame = true;
            }
            setScore(myScore);
        }else {
            initialize();
        }

    }

    @Override
    public void onMouseRightClick(int x, int y) {
        if(!endGame && currentCountFlag < game.getCountFlag()){
            if(getCellValue(x,y).equalsIgnoreCase("⚑")){
                setCellValueEx(x, y, game.getCellColor(), "", game.getValueColor(), game.getFontSize());
                currentCountFlag--;
            }else{
                setCellValueEx(x, y, game.getCellColor(), "⚑", Color.YELLOW, game.getFontSize());
                currentCountFlag++;
            }

        }
    }

    public boolean checkCell(int x, int y) {
        Cell cell = new Cell(x, y);
        if (CellBomb.getCellsWthBombs().contains(cell)) {
            return false;
        } else {

            for (CellWithoutBomb c : CellWithoutBomb.getCells()) {
                if (c.equals(cell)) {
                    if (!c.isShow()) {
                        doWork(c,false);
                        showCell(c);
                        break;
                    }
                }
            }
            return true;
        }
    }

    public void  doWork(CellWithoutBomb c, boolean needGO){
        if(!c.isShow() && !getCellValue(c.getPosX(),c.getPosY()).equalsIgnoreCase("⚑")){
            setCellValueEx(c.getPosX(), c.getPosY(), Color.DARKGRAY, String.valueOf(c.getCellValue()), game.getValueColor(), game.getFontSize());
            c.setShow(true);
            countCellsWithoutBombs-=1;
            myScore +=10;
            if (needGO) {
                showCell(c);
            }
        }
    }

    @Override
    public void setScore(int score) {
        super.setScore(score);
    }

    public void showCell(CellWithoutBomb c) {
        if (String.valueOf(c.getCellValue()).equalsIgnoreCase("") && !getCellValue(c.getPosX(),c.getPosY()).equalsIgnoreCase("⚑")) {
            CellWithoutBomb left = (CellWithoutBomb) CellWithoutBomb.findCellbyArray(CellWithoutBomb.getCells(), new Cell(c.getPosX() - 1, c.getPosY()));
            if (left != null) {
                doWork(left,true);
            }
            CellWithoutBomb right = (CellWithoutBomb) CellWithoutBomb.findCellbyArray(CellWithoutBomb.getCells(), new Cell(c.getPosX() + 1, c.getPosY()));
            if (right != null) {
                doWork(right,true);
            }
            CellWithoutBomb top = (CellWithoutBomb) CellWithoutBomb.findCellbyArray(CellWithoutBomb.getCells(), new Cell(c.getPosX(), c.getPosY() + 1));
            if (top != null) {
                doWork(top,true);
            }
            CellWithoutBomb bottom = (CellWithoutBomb) CellWithoutBomb.findCellbyArray(CellWithoutBomb.getCells(), new Cell(c.getPosX(), c.getPosY() - 1));
            if (bottom != null) {
                doWork(bottom,true);
            }

        }

    }


    public void fitMap(GameMap game, ArrayList<CellBomb> cellsbomb, ArrayList<CellWithoutBomb> cellswthoutbomb) {
        for (CellBomb c : cellsbomb) {
            setCellValueEx(c.getPosX(), c.getPosY(), game.getCellColor(), "", game.getValueColor(), game.getFontSize());
        }
        for (CellWithoutBomb c : cellswthoutbomb) {
            setCellValueEx(c.getPosX(), c.getPosY(), game.getCellColor(), "", game.getValueColor(), game.getFontSize());
        }

    }

}