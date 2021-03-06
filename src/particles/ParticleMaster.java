package particles;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector4f;

import entities.Camera;
import renderEngine.Loader;

public class ParticleMaster {
	private static List<Particle> particles = new ArrayList<Particle>();
	private static ParticleRenderer renderer;
	
	public static void init(Loader loader, Matrix4f projectionMatrix){
		renderer = new ParticleRenderer(loader, projectionMatrix);
	}
	public static void update(){
		Iterator<Particle> iterator = particles.iterator();
		while(iterator.hasNext()){
			Particle p = iterator.next();
			boolean stillAlive = p.update();
			if(!stillAlive){
				iterator.remove();
			}
		}
	}
	public static void renderParticles(Camera camera, Vector4f color){
		renderer.render(particles, camera, color);
	}
	public static void cleanUp(){
		renderer.cleanUp();
	}
	public static void addParticle(Particle particle){
		particles.add(particle);
	}
	
}
