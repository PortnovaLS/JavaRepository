package PackageLesson5;

public class Bird extends Animals {

    public Bird(int maxRunLength, int maxSwimLength, double maxHeight) {
        super(maxRunLength, maxSwimLength, maxHeight);
    }

    public Bird (){
        super();
    }

    @Override
    protected String getRunTextInfo(int runLength) {
        return "Bird run " + runLength;
    }

    @Override
    protected String getSwimTextInfo(int swimLength) {
        return "I can't swim!";
    }

    @Override
    protected void swim(int swimLength) {
        System.out.println("I can't swim!");
    }

    @Override
    protected String getJumpTextInfo(double jumpHeight) {
        return "Bird jump " + jumpHeight;
    }
}
