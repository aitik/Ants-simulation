package sample;

public class Bug {
    private int x;
    private int y;



    public Bug(int x,int y){
        //constructor
        this.x = x;
        this.y = y;
    }
    public void changeLoc(int[][] gameGrid){
        //moving ants
        //!not just copypasted!
        boolean check = false;
        while(!check){
            int tempx = x;
            int tempy = y;
            if(Math.random()>.5){
                if(tempx+1<=gameGrid.length-1) {
                    tempx++;
                }
                else{
                    tempx--;
                }
            }else {
                if(tempx-1>=0) {
                    tempx--;
                }
                else{
                    tempx++;
                }
            }
            if(Math.random()>.5){
                if(tempy+1<=gameGrid.length-1) {
                    tempy++;
                }
                else{
                    tempy--;
                }
            }else {
                if(tempy-1>=0) {
                    tempy--;
                }
                else{
                    tempy++;
                }
            }
            if (gameGrid[tempx][tempy]==0){
                check=true;
                if(gameGrid[x][y]==1){
                    gameGrid[tempx][tempy]=1;
                    gameGrid[x][y]=0;
                }
                else if(gameGrid[x][y]==2){
                    gameGrid[tempx][tempy]=2;
                    gameGrid[x][y]=0;
                }

                x=tempx;
                y=tempy;
            }
            else{//if ant is stucked
                tempx=x;
                tempy=y;
                check=true;
            }
        }
    }

    public int getX(){
        return this.x;
    }


    public int getY() {
        return this.y;
    }
}
