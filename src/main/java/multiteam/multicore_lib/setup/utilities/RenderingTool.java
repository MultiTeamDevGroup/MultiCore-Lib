package multiteam.multicore_lib.setup.utilities;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Matrix3f;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;
import net.minecraft.client.renderer.texture.OverlayTexture;

public class RenderingTool {

    public static void texturedCube(VertexConsumer vertexconsumer, Matrix4f matrix4f, Matrix3f matrix3f, int randomInt, Vector3f size, Vector3f offset){
        //back
        texturedPlane(vertexconsumer, matrix4f, randomInt, new Vector3f(offset.x()+size.x(), offset.y(), offset.z()), offset, new Vector3f(offset.x(), offset.y()+size.y(), offset.z()), new Vector3f(offset.x()+size.x(), offset.y()+size.y(), offset.z()) , new Vector3f(0, 1, 0));
        //right side
        texturedPlane(vertexconsumer, matrix4f, randomInt, offset, new Vector3f(offset.x(), offset.y(), offset.z()+ size.z()), new Vector3f(offset.x(), offset.y()+size.y(), offset.z()+size.z()), new Vector3f(offset.x(), offset.y()+size.y(), offset.z()), new Vector3f(0, 1, 0)) ;
        //front
        texturedPlane(vertexconsumer, matrix4f, randomInt, new Vector3f(offset.x(), offset.y(), offset.z()+size.z()), new Vector3f(offset.x()+size.x(), offset.y(), offset.z()+size.z()), new Vector3f(offset.x()+size.x(), offset.y()+size.y(), offset.z()+size.z()), new Vector3f(offset.x(), offset.y()+size.y(), offset.z()+size.z()), new Vector3f(0, 1, 0)) ;
        //left side (might not be oriented the right way)
        texturedPlane(vertexconsumer, matrix4f, randomInt, new Vector3f(offset.x()+size.x(), offset.y(), offset.z()), new Vector3f(offset.x()+size.x(), offset.y()+size.y(), offset.z()), new Vector3f(offset.x()+size.x(), offset.y()+size.y(), offset.z()+size.z()), new Vector3f(offset.x()+size.x(), offset.y(), offset.z()+size.z()), new Vector3f(0, 1, 0)) ;
        //top
        texturedPlane(vertexconsumer, matrix4f, randomInt, new Vector3f(offset.x(), offset.y()+size.y(), offset.z()), new Vector3f(offset.x(), offset.y()+size.y(), offset.z()+size.z()), new Vector3f(offset.x()+size.x(), offset.y()+size.y(), offset.z()+size.z()), new Vector3f(offset.x()+size.x(), offset.y()+size.y(), offset.z()), new Vector3f(0, 1, 0)) ;
        //bottom
        texturedPlane(vertexconsumer, matrix4f,  randomInt, offset, new Vector3f(offset.x()+size.x(), offset.y(), offset.z()), new Vector3f(offset.x()+size.x(), offset.y(), offset.z()+size.z()), new Vector3f(offset.x(), offset.y(), offset.z()+size.z()), new Vector3f(0, -1, 0)) ;
    }

    public static void texturedPlane(VertexConsumer vertexconsumer, Matrix4f matrix4f, int randomInt, Vector3f corner1Pos, Vector3f corner2Pos, Vector3f corner3Pos, Vector3f corner4Pos, Vector3f normal){
        texturedVertex(vertexconsumer, matrix4f, randomInt, corner1Pos,0, 1, normal);
        texturedVertex(vertexconsumer, matrix4f, randomInt, corner2Pos, 1, 1, normal);
        texturedVertex(vertexconsumer, matrix4f, randomInt, corner3Pos, 1, 0, normal);
        texturedVertex(vertexconsumer, matrix4f, randomInt, corner4Pos, 0, 0, normal);
    }

    public static void texturedVertex(VertexConsumer consumer, Matrix4f matrix4F, int uv2_, Vector3f pos, float uvX, float uvY, Vector3f normal) {
        consumer.vertex(matrix4F, pos.x(), pos.y(), pos.z()).color(255, 255, 255, 255).uv(uvX, uvY).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(uv2_).normal(normal.x(), normal.y(), normal.z()).endVertex();
    }

}
