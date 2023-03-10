package org.datagen.netology;


public class Main {

    public static void main(String[] args) {

        SmartRobot robot = new SmartRobot();
        robot.moveDown();
        robot.moveDown();
        robot.moveLeft();
        robot.moveUp();
        robot.moveDown();
        robot.moveLeft();
        robot.moveLeft();

        System.out.println("Координаты робота: " + robot.getX() + ":" + robot.getY());
        System.out.println("Количество шагов: " + robot.getStepsCount());
    }
}
class Robot {
    private int x;
    private int y;

    public void moveRight() {
        x++;
    }

    public void moveLeft() {
        x--;
    }

    public void moveUp() {
        y--;
    }

    public void moveDown() {
        y++;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class SmartRobot extends Robot {
    // Ваш код
    int steps;

    SmartRobot(){
        super();
        this.steps = 0;
    }

    public int getStepsCount() {
        return steps; // ваш код
    }

    public void moveRight() {
        super.moveRight();
        this.steps++;
    }

    public void moveLeft() {
        super.moveLeft();
        this.steps++;
    }

    public void moveUp() {
        super.moveUp();
        this.steps++;
    }

    public void moveDown() {
        super.moveDown();
        this.steps++;
    }
}