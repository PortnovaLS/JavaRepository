package PackageLesson5;

public class Horse extends Animals {

    public Horse(int maxRunLength, int maxSwimLength, double maxHeight) {
        super(maxRunLength, maxSwimLength, maxHeight);
    }

    public Horse(){
        super();
    }

    @Override
    protected String getRunTextInfo(int runLength) {
        return "Horse run  " + runLength;
    }

    @Override
    protected String getSwimTextInfo(int swimLength) {
        return "Horse swim " + swimLength;

    }
    @Override
    protected String getJumpTextInfo (double jumpHeight){
        return "Horse jump " + jumpHeight;
    }
}

