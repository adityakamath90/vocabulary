package bwellthy.vocabulary.utility;

public class ImageUtils {

    public static boolean isNegativeAspectRatio(Double ratio) {

        boolean isNegative = false;

        if (ratio < 0) {
            isNegative = true;
        }

        return isNegative;
    }


}
