package dominus;

import javax.media.opengl.*;
import javax.swing.*;

/**
 * �The most incomprehensible thing about the world is 
 * that it is at all comprehensible.�
 * 
 * This class represent everything including the render 
 * engine and the physics engine.
 * 
 * @author ibraheem
 *
 */

public class World implements Runnable{
	
	public GLCanvas canvas;
	public RenderEngine renderer;
	private JFrame window;
	
	private boolean running;
	
	public World(JFrame window, int width, int height){
		renderer = new RenderEngine(width, height, this);
		canvas = new GLCanvas();
		
		this.window = window;
            
		canvas.addGLEventListener(renderer);
		window.add(canvas);
		canvas.requestFocus();
		
		window.setVisible(true);
		
		running = true;
	}
	
	public void run(){	
		while(running)
		{
			try{
				canvas.display();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
}
