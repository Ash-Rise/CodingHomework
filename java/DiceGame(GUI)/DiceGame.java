
package cn.edu.ncu.lzc;

import java.util.Random;

public class DiceGame {
private int first;
private int second;
private int points;
private int point;
private Random rand=new Random();

public int rollDice(){
    return rand.nextInt(6)+1;
}
public void roll(){
    first = rollDice();
    second = rollDice();
    points = first+second;
}

public String play(){
    roll();

    if (point == 0) {
        return switch(points){
            case 2,3,12 -> "LOSE";
            case 7,11 -> "WIN";
            default -> {
                point = points;
                yield "GOON";
            }
        };
    }

    if (points == 7) {
        point = 0;
        return "LOSE";
    }

    if (points == point) {
        point = 0;
        return "WIN";
    }

    return "GOON";
}

public int getFirst(){
    return first;
}

public int getSecond(){
    return second;
}

public int getPoints(){
    return points;
}

public int getPoint(){
    return point;
}

public void reset(){
    first = 0;
    second = 0;
    points = 0;
    point = 0;
}

}
