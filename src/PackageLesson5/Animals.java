package PackageLesson5;

import java.util.Random;

public abstract class Animals {

    protected int maxRunLength;
    protected int maxSwimLength;
    protected double maxHeight;

    public static Random random = new Random();

    public Animals(int maxRunLength, int maxSwimLength, double maxHeight) {
        this.maxRunLength = maxRunLength;
        this.maxSwimLength = maxSwimLength;
        this.maxHeight = maxHeight;

    }
    public Animals(){
        this.maxRunLength = random.nextInt(2000);
        this.maxSwimLength = random.nextInt(50);
        this.maxHeight = random.nextInt(10) + random.nextDouble();
    }

    protected void run(int runLength) {

        if (runLength > maxRunLength) {
            System.out.println("I can't run so much");
        } else {
            System.out.println(getRunTextInfo(runLength));
        }

    }

    protected void swim(int swimLength) {

        if (swimLength > maxSwimLength) {
            System.out.println("I can't swim so much");
        } else {
            System.out.println(getSwimTextInfo(swimLength));
        }

        }
    protected void jump(double jumpHeight) {

        if (jumpHeight > maxHeight) {
            System.out.println("I can't jump so high");
        } else {
            System.out.println(getJumpTextInfo(jumpHeight));
        }

    }

        protected abstract String getRunTextInfo(int runLength);
        protected abstract String getSwimTextInfo(int swimLength);
        protected abstract String getJumpTextInfo(double jumpHeight);

    }
