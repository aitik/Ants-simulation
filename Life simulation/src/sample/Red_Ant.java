package sample;

public class Red_Ant extends Bug {
    private long startTime;
    boolean left;
    int life;
    public Red_Ant(int x, int y){
        //constructor
        super(x,y);
        startTime = System.nanoTime();
        left=false;
        life=0;
    }
    public void resetStartTime(){
        startTime = System.nanoTime();
    }
    public long getStartTime(){
        return startTime;
    }

}
