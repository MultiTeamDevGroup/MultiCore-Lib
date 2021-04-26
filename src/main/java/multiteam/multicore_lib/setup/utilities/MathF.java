package multiteam.multicore_lib.setup.utilities;

public class MathF { //Why MathF? Because in unity, there was a class with Mathematical functions, and i grown quiet fond of this name. In the honor of my C# past, you shall now be named MathF!

    public float rescaleValues(float minFrom, float maxFrom, float minTo, float maxTo, float valueToScale){
        float OldRange = (maxFrom - minFrom);
        float NewRange = (maxTo - minTo);

        return (((valueToScale - minFrom) * NewRange) / OldRange) + minTo;
    }

}
