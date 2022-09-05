package com.javarush.games.minesweeper;
import com.javarush.engine.cell.*;

public class GameMap {
    private static  GameMap gameMap;
    private static int width;
    private static int height;
    private static Color cellColor;
    private static Color valueColor;
    private static int fontSize;
    private static LVLMAP lvlMap;
    private static int countBomb;
    private static int countFlag;

    private GameMap(){

    }
    public static GameMap getInstance(int w, int h, Color cell, Color value, int fs,LVLMAP lvlMaps) {
        width = w;
        height = h;
        fontSize = fs;
        cellColor = cell;
        valueColor = value;
        lvlMap = lvlMaps;
        countBomb = CalcCountBomb(lvlMap);
        countFlag =  countBomb;
        return new GameMap();
    }
    private static int CalcCountBomb(LVLMAP lvlMap) {

            switch (lvlMap){
                case EASY -> {
                    return (width*height)/10;
                }
                case MEDIUM->{
                    return (width*height)/6;
                }
                case HARD->{
                    return (width*height)/3;
                }
                default -> {
                    System.out.println("Ошибка! Неизвестный уровень игры, уровень игры EASY");
                    return (width*height)/3;
                }
            }


    }

    public int getCountFlag() {
        return countFlag;
    }

    public Color getCellColor(){
        return cellColor;
    }
    public Color getValueColor(){
        return valueColor;
    }
    public int getFontSize(){
        return fontSize;
    }
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }

    public int getCountBomb() {
        return countBomb;
    }
}