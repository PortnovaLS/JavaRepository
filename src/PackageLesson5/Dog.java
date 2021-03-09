package PackageLesson5;

public class Dog extends Animals {

    public Dog(int maxRunLength, int maxSwimLength, double maxHeight) {
        super(maxRunLength, maxSwimLength, maxHeight);
    }

    public Dog() {
        super();
    }

    @Override
    protected String getRunTextInfo(int runLength) {
        return "Dog run " + runLength;
    }

    @Override
    protected String getSwimTextInfo(int swimLength) {
        return "Dog swim " + swimLength;
    }

    @Override
    protected String getJumpTextInfo(double jumpHeight) {
        return "Dog jump " + jumpHeight;
    }
}
