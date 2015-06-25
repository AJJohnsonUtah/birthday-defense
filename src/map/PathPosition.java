/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import towers.Position;

/**
 *
 * @author AJ
 */
public class PathPosition {
    private int pathIndex;
    private Position position;
    
    public PathPosition(Position pos){
        pathIndex = 0;
        position = pos;
    }
    
    public void incrementPathIndex() {
        pathIndex++;
    }
    
    public int getPathIndex() {
        return pathIndex;
    }
    
    public void setPosition(Position pos) {
        position = pos;
    }
    
    public Position getPosition() {
        return position;                
    }
            
}
