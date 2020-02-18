package sample;



import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
public class Controller {
    int x=20;
    int y=20;
    int rx, ry, amountofredants,cx,cy,rantsaround, ii, ij;
    int amountofants, amountofantsadded, amountofantsdead, amountofrantsadded,amountofrantsdead, amountofinfected, test;
    int antstime=100;
    int rantstime=25;
    boolean smnleft=false;
    boolean smnrleft=false;
    boolean started=true;
    boolean startedgame= false;
    long timer = System.nanoTime();
    long anothertimer=System.nanoTime();

    Button[][] btn = new Button[x][y];


    int[][] gameGrid = new int[x][y];
    ArrayList<Ant> ants = new ArrayList<>();
    ArrayList<Red_Ant> rants = new ArrayList<>();

    @FXML
    private GridPane gPane;

    @FXML
    private Label amount;
    @FXML
    private Label amount2;
    @FXML
    private Label antsadded;
    @FXML
    private Label antsdead;
    @FXML
    private Label rantsadded;
    @FXML
    private Label rantsdead;
    @FXML
    private Label infected;
    @FXML
    private Button button;
    @FXML
    private ImageView intro;
    @FXML
    private Button newg;
    @FXML
    private TextField antstimelife;
    @FXML
    private TextField rantstimelife;
    @FXML
    private DialogPane options;
    @FXML
    private GridPane a1;
    @FXML
    private GridPane a2;
    @FXML
    private GridPane a3;
    @FXML
    private GridPane a4;
    @FXML
    private GridPane n1;
    @FXML
    private GridPane n2;
    @FXML
    private GridPane n3;
    @FXML
    private GridPane n4;
    @FXML
    private GridPane n5;
    @FXML
    private GridPane t1;
    @FXML
    private GridPane t2;
    @FXML
    private GridPane t3;
    int[]ba1 = new int[]{1,1,1,1,1};
    Button[] ia1 = new Button[5];
    int[]ba2 = new int[]{1,1};
    Button[] ia2 = new Button[2];
    int[]ba3 = new int[]{1,1};
    Button[] ia3 = new Button[2];
    int[]ba4 = new int[]{1,1,1,1,1};
    Button[] ia4 = new Button[5];
    int[]bn1 = new int[]{1,1,1,1,1};
    Button[] in1 = new Button[5];
    int[]bn2 = new int[]{1};
    Button[] in2 = new Button[1];
    int[]bn3 = new int[]{1};
    Button[] in3 = new Button[1];
    int[]bn4 = new int[]{1};
    Button[] in4 = new Button[1];
    int[]bn5 = new int[]{1,1,1,1,1};
    Button[] in5 = new Button[5];
    int[]bt1 = new int[]{1,1};
    Button[] it1 = new Button[2];
    int[]bt2 = new int[]{1,1,1,1,1};
    Button[] it2 = new Button[5];
    int[]bt3 = new int[]{1,1};
    Button[] it3 = new Button[2];
    ArrayList<Button[]> lettersb = new ArrayList<Button[]>();
    ArrayList<int[]> lettersi = new ArrayList<int[]>();
    ArrayList<GridPane> gpanes = new ArrayList<GridPane>();
    public void initialize(){
        //starting animation
        animation();
        //numeric textfields
        antstimelife.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    antstimelife.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        rantstimelife.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    rantstimelife.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }
    public void animation(){
        //animation
        lettersb.add(ia1);
        lettersb.add(ia2);
        lettersb.add(ia3);
        lettersb.add(ia4);
        lettersb.add(in1);
        lettersb.add(in2);
        lettersb.add(in3);
        lettersb.add(in4);
        lettersb.add(in5);
        lettersb.add(it1);
        lettersb.add(it2);
        lettersb.add(it3);
        lettersi.add(ba1);
        lettersi.add(ba2);
        lettersi.add(ba3);
        lettersi.add(ba4);
        lettersi.add(bn1);
        lettersi.add(bn2);
        lettersi.add(bn3);
        lettersi.add(bn4);
        lettersi.add(bn5);
        lettersi.add(bt1);
        lettersi.add(bt2);
        lettersi.add(bt3);
        gpanes.add(a1);
        gpanes.add(a2);
        gpanes.add(a3);
        gpanes.add(a4);
        gpanes.add(n1);
        gpanes.add(n2);
        gpanes.add(n3);
        gpanes.add(n4);
        gpanes.add(n5);
        gpanes.add(t1);
        gpanes.add(t2);
        gpanes.add(t3);
        for(int i=0;i<ba1.length;i++){
            ia1[i]=new Button();
            ia1[i].setPrefWidth(25);
            ia1[i].setPrefHeight(25);
            a1.add(ia1[i], 0,i);

        }
        for(int i=0;i<ba2.length;i++){
            ia2[i]=new Button();
            ia2[i].setPrefWidth(25);
            ia2[i].setPrefHeight(25);
            a2.add(ia2[i],i, 0);
        }
        for(int i=0;i<ba3.length;i++){
            ia3[i]=new Button();
            ia3[i].setPrefWidth(25);
            ia3[i].setPrefHeight(25);
            a3.add(ia3[i],i,0);
        }
        for(int i=0;i<ba4.length;i++){
            ia4[i]=new Button();
            ia4[i].setPrefWidth(25);
            ia4[i].setPrefHeight(25);
            a4.add(ia4[i],0,i);
        }
        for(int i=0;i<bn1.length;i++){
            in1[i]=new Button();
            in1[i].setPrefWidth(25);
            in1[i].setPrefHeight(25);
            n1.add(in1[i],0,i);
        }
        for(int i=0;i<bn3.length;i++){
            in3[i]=new Button();
            in3[i].setPrefWidth(25);
            in3[i].setPrefHeight(25);
            n3.add(in3[i],0,0);
        }
        for(int i=0;i<bn2.length;i++){
            in2[i]=new Button();
            in2[i].setPrefWidth(25);
            in2[i].setPrefHeight(25);
            n2.add(in2[i],0,0);
        }
        for(int i=0;i<bn4.length;i++){
            in4[i]=new Button();
            in4[i].setPrefWidth(25);
            in4[i].setPrefHeight(25);
            n4.add(in4[i],0,0);
        }
        for(int i=0;i<bn5.length;i++){
            in5[i]=new Button();
            in5[i].setPrefWidth(25);
            in5[i].setPrefHeight(25);
            n5.add(in5[i],0,i);
        }
        for(int i=0;i<bt1.length;i++){
            it1[i]=new Button();
            it1[i].setPrefWidth(25);
            it1[i].setPrefHeight(25);
            t1.add(it1[i],i,0);
        }
        for(int i=0;i<bt2.length;i++){
            it2[i]=new Button();
            it2[i].setPrefWidth(25);
            it2[i].setPrefHeight(25);
            t2.add(it2[i],0,i);
        }
        for(int i=0;i<bt3.length;i++){
            it3[i]=new Button();
            it3[i].setPrefWidth(25);
            it3[i].setPrefHeight(25);
            t3.add(it3[i],i,0);
        }
        
        start();

    }
//    public void startanimation(){
//        new AnimationTimer() {
//            @Override
//            public void handle(long now) {
//
//            }
//        }.startanimation();
//    }
    @FXML
    private void newgame(){
        //just a new game
        intro.setVisible(false);
        newg.setVisible(false);
        for(int i=0;i<gpanes.size();i++){
            gpanes.get(i).setVisible(false);
        }

    }
    @FXML
    private void handleStart( ) {
        //adding buttons to DrigPane
        started=true;
        startedgame=true;
        for(int i=0; i<btn.length; i++){
            for(int j=0; j<btn[0].length;j++){
                btn[i][j] = new Button();
                btn[i][j].setPrefWidth(25);
                btn[i][j].setPrefHeight(25);
                gPane.add(btn[i][j], j, i);
                gameGrid[i][j]=0;
                gPane.setMaxSize(500,500);
                gPane.setMaxHeight(500);
                gPane.setMaxWidth(500);
            }
        }

        gPane.setGridLinesVisible(true);
        gPane.setVisible(true);
        gPane.setOpacity(0.75);
//        start();
    }
    @FXML
    private void handleKeyPress(KeyEvent event)
            //making life easier
    {
        if (event.getCode() == KeyCode.X){
            handleAddAnt();
        }
        else if (event.getCode() == KeyCode.Z){
            handleAddRedAnt();
        }
        else if (event.getCode() == KeyCode.S){
            if(!started){
                handleStart();
            }
        }
        else if (event.getCode() == KeyCode.R){
            restart();
        }
    }
    @FXML
    public void handleAddAnt()
            //adding ant
    {
        if(ants.size()+rants.size()+1==300){
            return;
        }
        rx=(int)(Math.random()*x-1)+1;
        ry=(int)(Math.random()*y-1)+1;
        while (gameGrid[rx][ry]!=0){
            rx=(int)(Math.random()*x-1)+1;
            ry=(int)(Math.random()*y-1)+1;
        }
        ants.add(new Ant(rx,ry));
        gameGrid[ants.get(ants.size()-1).getX()][ants.get(ants.size()-1).getY()]=1;
        amountofants++;
        amountofantsadded++;
        antsadded.setText("Ants added: "+amountofantsadded);
        updateScreen();
    }
    @FXML
    public void handleAddRedAnt()
            //adding red ant
    {
        if(ants.size()+rants.size()+1==300){
            return;
        }
        rx=(int)(Math.random()*x-1)+1;
        ry=(int)(Math.random()*y-1)+1;
        while (gameGrid[rx][ry]!=0){
            rx=(int)(Math.random()*x-1)+1;
            ry=(int)(Math.random()*y-1)+1;
        }
        rants.add(new Red_Ant(rx,ry));
        gameGrid[rants.get(rants.size()-1).getX()][rants.get(rants.size()-1).getY()]=2;
        amountofredants++;
        amountofrantsadded++;
        rantsadded.setText("Red ants added: "+amountofrantsadded);
        updateScreen();


    }
    public void updateAnimation(Button[] b, int[] m){
        //updating animation
        for(int i=0; i<b.length;i++){
            if (m[i]==1){
                b[i].setStyle(
                        "-fx-background-image: url(ant.png);"+
                                "-fx-background-size: 25px 25px;"+
                                "-fx-background-repeat: no-repeat;"+
                                "-fx-background-position: center;"
                );
            }
            else if (m[i]==2){
//                    btn[i][j].setStyle("-fx-background-color:red");
                b[i].setStyle(
                        "-fx-background-image: url(rant_small.jpg);"+
                                "-fx-background-size: 25px 25px;"+
                                "-fx-background-repeat: no-repeat;"+
                                "-fx-background-position: center;"
                );
            }
        }
    }

    public void updateScreen(){
        //updating screen
        for(int i=0; i<btn.length; i++) {
            for (int j = 0; j < btn[0].length; j++) {
                if (gameGrid[i][j]==0){
                    btn[i][j].setStyle(
                            "-fx-background-image: url(white.jpg);"+
                                    "-fx-background-size: 25px 25px;"+
                                    "-fx-background-repeat: no-repeat;"+
                                    "-fx-background-position: center;"
                    );
                }
                else if (gameGrid[i][j]==1){
                    btn[i][j].setStyle(
                            "-fx-background-image: url(ant.png);"+
                                    "-fx-background-size: 25px 25px;"+
                                    "-fx-background-repeat: no-repeat;"+
                                    "-fx-background-position: center;"
                    );
                }
                else if (gameGrid[i][j]==2){
//                    btn[i][j].setStyle("-fx-background-color:red");
                    btn[i][j].setStyle(
                            "-fx-background-image: url(rant_small.jpg);"+
                                    "-fx-background-size: 25px 25px;"+
                                    "-fx-background-repeat: no-repeat;"+
                                    "-fx-background-position: center;"
                    );
                }
            }
        }
        amount.setText("Ants alive: "+ants.size());
        amount2.setText("Red ants: "+rants.size());
        eat();
        bug();


    }
    public void eat(){
        //eating
        if(ants.size()>0 && rants.size()>1){
            for (Ant a : ants){
                cx=a.getX();
                cy=a.getY();
                rantsaround=0;
                if(gameGrid[a.getX()][a.getY()]==1 && a.getX()>0 && a.getX()<19 && a.getY()>0 && a.getY()<19){
                    if(gameGrid[a.getX()+1][a.getY()-1]==2){
                        rantsaround++;
                    }
                    if(gameGrid[a.getX()+1][a.getY()]==2){
                        rantsaround++;
                    }
                    if(gameGrid[a.getX()+1][a.getY()+1]==2){
                        rantsaround++;
                    }
                    if(gameGrid[a.getX()][a.getY()+1]==2){
                        rantsaround++;
                    }
                    if(gameGrid[a.getX()-1][a.getY()+1]==2){
                        rantsaround++;
                    }
                    if(gameGrid[a.getX()-1][a.getY()]==2){
                        rantsaround++;
                    }
                    if(gameGrid[a.getX()-1][a.getY()-1]==2){
                        rantsaround++;
                    }
                    if(gameGrid[a.getX()][a.getY()-1]==2){
                        rantsaround++;
                    }
                    if(rantsaround>=2){
                        a.left=true;
                        smnleft=true;
                        test++;
//                        System.out.println(test);
                    }
                }
            }
            if(smnleft){
                left();
                smnleft=false;
            }
        }
        if(smnrleft){
            rleft();
            smnrleft=false;
        }
    }
    public void bug(){
        //catching some errors
        if(ants.size()>0){
            for(Ant a : ants){
                if(gameGrid[a.getX()][a.getY()]!=1){
                    a.left=true;
                    System.out.println("BUG HERE");
                    left();
                }
            }
        }

        if(rants.size()>0){
            for(Red_Ant a : rants){
                if(gameGrid[a.getX()][a.getY()]!=2){
                    a.left=true;
                    System.out.println("BUG HERE");
                    rleft();
                }
            }
        }

    }
    public void left(){
        //if someone should leave us
        for(int i=0; i<ants.size();i++){
            if(ants.get(i).left){
                cx=ants.get(i).getX();
                cy=ants.get(i).getY();
                ants.remove(i);
                gameGrid[cx][cy]=0;
                amountofantsdead++;
                antsdead.setText("Ants dead: "+amountofantsdead);
                rants.add(new Red_Ant(cx, cy));
                gameGrid[rants.get(rants.size()-1).getX()][rants.get(rants.size()-1).getY()]=2;
                amountofredants++;
//                amountofrantsadded++;
                amountofinfected++;
                infected.setText("Infected red ants: "+amountofinfected);
                rantsadded.setText("Red ants added: "+amountofrantsadded);
                updateScreen();
            }
        }
    }
    public void rleft(){
        //if someone should leave us
        for(int i=0; i<rants.size();i++){
            if(rants.get(i).left){
                cx=rants.get(i).getX();
                cy=rants.get(i).getY();
                rants.remove(i);
                gameGrid[cx][cy]=0;
                amountofrantsdead++;
                rantsdead.setText("Red ants dead: "+amountofrantsdead);
            }
        }
    }

    public void start() {
        //all stuff with time
//        button.setVisible(false);
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(ants.size()>0){
                    for (Ant a : ants){
                        if(now - a.getStartTime() > 1000000000.0){
                            //normal 1000000000.0
                            a.changeLoc(gameGrid);
                            a.resetStartTime();
                            a.life++;
                        }
                        if(a.life>=antstime){
                            a.left=true;
                            smnleft=true;
                        }
                    }
                }
                if(rants.size()>0) {
                    for (Red_Ant r : rants) {
                        if (now - r.getStartTime() > 1000000000.0) {
                            //normal 1000000000.0
                            r.changeLoc(gameGrid);
                            r.resetStartTime();
                            r.life++;
                        }
                        if(r.life>=rantstime){
                            r.left=true;
                            smnrleft=true;
                        }
                    }
                }
//                if(startedgame){
//                    if(now - anothertimer >500000000.0){
//                        handleAddRedAnt();
//                        handleAddAnt();
//                    }
//                    anothertimer = System.nanoTime();
//                }
                if(now - timer >500000000.0) {
                    for (int i = 0; i < lettersi.size(); i++) {
                        for(int j=0; j<lettersi.get(i).length;j++){
                            lettersi.get(i)[j]=(int)(Math.random()*2+1);
                        }
                    }
                    for (int i = 0; i < lettersb.size(); i++) {
                        updateAnimation(lettersb.get(i), lettersi.get(i));
                    }
                    timer = System.nanoTime();
                }
                if(startedgame){
                    updateScreen();
                }

            }
        }.start();
    }
    @FXML
    private void restart(){
        //clearing the gridpane and all lists
        ants.clear();
        rants.clear();
        for(int i=0;i<gameGrid.length;i++){
            for(int j=0;j<gameGrid.length;j++){
                gameGrid[i][j]=0;
            }
        }
        amountofrantsadded=0;
        rantsadded.setText("Red ants added: "+amountofrantsdead);
        amountofantsdead=0;
        antsdead.setText("Ants dead: "+amountofantsdead);
        amountofantsadded=0;
        antsadded.setText("Ants dead: "+amountofantsadded);
        amountofrantsdead=0;
        rantsdead.setText("Red ants dead: "+amountofrantsdead);
        amountofants=0;
        amountofredants=0;
        amountofinfected=0;
        infected.setText("Infected red ants: "+amountofinfected);
        amount.setText("Ants alive: "+ants.size());
        amount2.setText("Red ants: "+rants.size());
        updateScreen();
    }
    @FXML
    private void openoptions(){
        //open dialogepane
        options.setVisible(true);
    }
    @FXML
    private void saveoptions(){
        //getting text from textfields and closing dialogepane
        options.setVisible(false);
        try{
            //catching errors if user left the texfields empty
        antstime=Integer.parseInt(antstimelife.getText());}
        catch (NumberFormatException e){
            antstime=100;
        }

        try{
            rantstime=Integer.parseInt(rantstimelife.getText());}
        catch (NumberFormatException e){
            rantstime=25;
        }


        //every time user changes settings ants get new life
        for (Red_Ant r : rants) {
            r.life=0;
        }
        for (Ant a : ants) {
            a.life=0;
        }

    }
    @FXML
    private void closeoptions(){
        //closing dialogepane
        options.setVisible(false);

    }
}
