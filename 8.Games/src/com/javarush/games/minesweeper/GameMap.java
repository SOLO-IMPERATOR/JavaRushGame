package com.javarush.games.minesweeper;
import com.javarush.engine.cell.*;

public class GameMap {
    private int width;
    private int height;
    private Color cellColor;
    private Color valueColor;
    private int fontSize;
    private LVLMAP lvlMap;
    private int countBomb;
    
    public GameMap(int w, int h, Color cell, Color value, int fs,LVLMAP lvlMap){
        this.width = w;
        this.height = h;
        this.fontSize = fs;
        this.cellColor = cell;
        this.valueColor = value;
        this.lvlMap = lvlMap;
        this.countBomb = CalcCountBomb(lvlMap);
    }
    private int CalcCountBomb(LVLMAP lvlMap){
        try {
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
                    throw new UnknowableLevelMapException();
                }
            }
        }catch (UnknowableLevelMapException e){
            System.out.println("Ошибка! Неизвестный уровень игры, уровень игры EASY");
            return (width*height)/3;
        }

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