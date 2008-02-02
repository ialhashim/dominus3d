package dominus;

import java.util.Vector;
import java.util.Iterator;

import javax.media.opengl.GL;

/**
 * Parent class for 2D and 3D elements.
 * 
 * Attributes:
 * 	id			A textual identifier to identify distinct objects
 *  visible		Specify if an element should be rendered
 *  parent		Helps create hierarchical objects
 *  child		Part of the hierarchical model
 * 
 * @author cherz
 * @author ibraheem
 */

public abstract class Element {
	
	private String id;
	private boolean visible;
	
	private Element parent;
	private Vector<Element> child;
	
	private GL gl;
	
	public Element(String iden, GL gl){
		this(iden, null, gl);
	}
	
	public Element(String iden, Element parent, GL gl){
		this.id = iden;
		this.visible = true;
		this.parent = parent;
		
		this.gl = gl;
	}
	
	public Element getParent(){
		return parent;
	}
	
	public abstract void render();
	
	public void renderAll(){
		if (visible){
			// Render this element
			this.render();
			
			Iterator<Element> i = child.listIterator();
			
			// Render all child elements
			while (i.hasNext()){
				Element e = (Element)i.next();
				e.render();
			}
		}
	}
	
	public String toString(){
		return id;
	}
	
}
