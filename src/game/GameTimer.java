/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author AJ
 */
public class GameTimer {
    private long startTime;
//    private long totalPauseTime;
//    private long timeOfLastPause;
//    private long timeOfLastResume;
    
    public GameTimer() {
        startTime = 0L;
//        pauseTime = 0L;
    }
    
    public long getStartTime() {
        return startTime;
    }       
    
    public long getTime() {
        return System.nanoTime() - startTime;
    }
    
    public void startTimer() {
        startTime = System.nanoTime();
    }
}
