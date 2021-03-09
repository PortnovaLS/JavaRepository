package PackageLesson5;

public class Cat extends Animals {

    public Cat(int maxRunLength, int maxSwimLength, double maxHeight) {
        super(maxRunLength, maxSwimLength, maxHeight);
    }

    public Cat(){
        super();
    }

    @Override
    protected String getRunTextInfo(int runLength) {
        return "Cat run " + runLength;
    }

    @Override
    protected String getSwimTextInfo(int swimLength) {
        return "I can't swim!";
    }

    @Override
    protected String getJumpTextInfo(double jumpHeight) {
        return "Cat jump " + jumpHeight;
    }
}

