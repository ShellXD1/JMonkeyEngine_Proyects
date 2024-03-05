package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.system.AppSettings;

/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    private Geometry geom;
    private float angle = 0.0f;
    
    public static void main(String[] args) {
        AppSettings settings = new AppSettings(true);
        settings.setTitle("Tower Defense DEMO");
        settings.setSettingsDialogImage("Interface/Logo1.jpeg");
        
        Main app = new Main();
        app.setSettings(settings);
        app.start();
    }

    @Override
    public void simpleInitApp() {
        Box b = new Box(3, 3, 3);
        geom = new Geometry("Box", b);

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue);
        geom.setMaterial(mat);

        rootNode.attachChild(geom);
    }

    @Override
    public void simpleUpdate(float tpf) {
        angle += tpf; // Incrementa el ángulo de rotación
        
        // Crea un cuaternión de rotación en el eje Y
        Quaternion rotation = new Quaternion();
        rotation.fromAngleAxis(angle, new Vector3f(0, 1, 0));
        
        // Aplica la rotación al objeto Geometry
        geom.setLocalRotation(rotation);
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}