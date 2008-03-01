package dominus;

import javax.media.opengl.*;
import javax.media.opengl.glu.*;

/**
 * This class represent cameras.
 * 
 * @author Ibraheem
 *
 */

public class Camera {
	GLU glu;
	
	private float aspectRatio;
	private float fovAngle;
	private float nearZ;
	private float farZ;
	
	private Vertex lookAt;
	private Vertex lookFrom;
	
	public Camera(GL gl, GLU glu, int width, int height){
        this.glu = glu;
        
		fovAngle = 50.0f;

        if (height <= 0)
        	height = 1;

        aspectRatio = (float)width / (float)height;
        nearZ = 1.0f;
        farZ = 1000.0f;
        
        lookAt = new Vertex(0,0,0);
        lookFrom = new Vertex(5,5,5);
	}
	
	public void set(GL gl){
        //set up a perspective projection matrix
	    gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(fovAngle, aspectRatio , nearZ, farZ);
        
        // Position the camera
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
        glu.gluLookAt(lookFrom.x, lookFrom.y, lookFrom.z, 
        				lookAt.x, lookAt.y, lookAt.z, 
        					0.0, 0.0, 1.0);
	}
	
	public void setFOV(float fov){
		this.fovAngle = fov;
	}
	
	public void setAspectRatio(float ratio){
		this.aspectRatio = ratio;
	}
	
	public void lookAt(Vertex v){
		lookAt.x = v.x;
		lookAt.y = v.y;
		lookAt.z = v.z;
	}
	
	public void lookFrom(Vertex v){
		lookFrom.x = v.x;
		lookFrom.y = v.y;
		lookFrom.z = v.z;
	}
	
	public void lookFromAt(float atX, float atY, float atZ, 
							float fromX, float fromY, float fromZ){
		lookFrom.x = fromX;
		lookFrom.y = fromY;
		lookFrom.z = fromZ;
		
		lookAt.x = atX;
		lookAt.y = atY;
		lookAt.z = atZ;
	}
	
	public void setNear(float near){
		this.nearZ = near;
	}
	
	public void setFar(float far){
		this.farZ = far;
	}
}
