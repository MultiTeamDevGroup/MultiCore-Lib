package multiteam.multicore_lib.setup.utilities.generic;

import org.joml.Vector3f;

//LAZ: Why MathF? Because in unity, there was a class with Mathematical functions, and i grown quiet fond of this name. In the honor of my C# past, you shall now be named MathF!
//QBOI: I respect that, I will leave this name. But still package names are weird bro.
public class MathF {

    /**
     * Calculates a number in between two scales.
     * Useful for minecraft's float values where it uses a scale between 0-1 instead of 0-16 for blocks and such.
     * To a quicker access to a solution for the problem mentioned above, see BlockToFloatScale()
    **/
    public static float rescaleValues(float minFrom, float maxFrom, float minTo, float maxTo, float valueToScale){
        float OldRange = (maxFrom - minFrom);
        float NewRange = (maxTo - minTo);

        return (((valueToScale - minFrom) * NewRange) / OldRange) + minTo;
    }

    /**
     * Used to calculate quickly from 0-16 to 0-1 with less values
     **/
    public static float BlockToFloatScale(float value){
        return rescaleValues(0.0f, 16.0f, 0.0f, 1.0f, value);
    }

    /**
     * Creates a Vector3f object from the 3 input values, whilst scaling the input from 0-16 to 0-1 scale
     **/
    public static Vector3f BlockToFloatScaleVector3f(float x, float y, float z){
        return new Vector3f(BlockToFloatScale(x),BlockToFloatScale(y),BlockToFloatScale(z));
    }

    /**
     * Calculates the distance between two 3 dimensional vector points
     **/
    public static float Vector3fDistance(Vector3f pointA, Vector3f pointB) {
        float num1 = pointA.x() - pointB.x();
        float num2 = pointA.y() - pointB.y();
        float num3 = pointA.z() - pointB.z();
        return (float) Math.sqrt((double) num1 * (double) num1 + (double) num2 * (double) num2 + (double) num3 * (double) num3);
    }

    /**
     * Clamps a value between two limits
     **/
    @SuppressWarnings("ManualMinMaxCalculation")
    public static int clampInt(int input, int min, int max){
        return input > max ? max : input < min ? min : input;
    }

}
