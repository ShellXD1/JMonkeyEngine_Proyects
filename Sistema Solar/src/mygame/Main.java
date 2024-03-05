package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Sphere;
import com.jme3.texture.Texture;
import com.jme3.scene.Node;
import com.jme3.system.AppSettings;

public class Main extends SimpleApplication {
    
    private Node nodoTierra;
    private Geometry geomSol;
    private Geometry geomMercurio;
    private Geometry geomVenus;
    private Geometry geomTierra;
    private Geometry geomMarte;
    private Geometry geomJupiter;
    private Geometry geomSaturno;
    private Geometry geomUrano;
    private Geometry geomNeptuno;
    private Geometry geomPluton;
    private Geometry geomLuna;
    private float anguloOrbitaLuna = 0f;
    private float anguloOrbitaMercurio = 0f;
    private float anguloOrbitaVenus = 0f;
    private float anguloOrbitaTierra = 0f;
    private float anguloOrbitaMarte = 0f;
    private float anguloOrbitaJupiter = 0f;
    private float anguloOrbitaSaturno = 0f;
    private float anguloOrbitaUrano = 0f;
    private float anguloOrbitaNeptuno = 0f;
    private float anguloOrbitaPluton = 0f;
    private float factorRadioOrbitaPlaneta = 5f; // Factor de radio de órbita planetaria
    
    public static void main(String[] args) {
        AppSettings settings = new AppSettings(true);
        settings.setTitle("Sistema solar");
        settings.setSettingsDialogImage("Interface/logo.jpeg");
        
        Main app = new Main();
        app.setSettings(settings);
        app.start();
    }

    @Override
    public void simpleInitApp() {
        // Crear el sol
        Sphere mallaSol = new Sphere(50, 50, 6f);
        geomSol = new Geometry("Sol", mallaSol);
        Material matSol = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        Texture texturaSol = assetManager.loadTexture("Interface/sol.jpg");
        matSol.setTexture("ColorMap", texturaSol);
        geomSol.setMaterial(matSol);
        rootNode.attachChild(geomSol);

        // Crear Mercurio
        geomMercurio = crearPlaneta("Mercurio", 3f, "Interface/mercurio.jpg", 3f);

        // Crear Venus
        geomVenus = crearPlaneta("Venus", 3f,  "Interface/venus.png", 6f);

        // Crear la Tierra
        geomTierra = crearPlaneta("Tierra", 3f,  "Interface/tierra.jpg", 9f);

        // Crear Marte
        geomMarte = crearPlaneta("Marte", 3f,  "Interface/marte.png", 12f);

        // Crear Júpiter
        geomJupiter = crearPlaneta("Júpiter", 3f,  "Interface/jupiter.jpeg", 15f);

        // Crear Saturno
        geomSaturno = crearPlaneta("Saturno", 3f, "Interface/saturno.jpg", 18f);

        // Crear Urano
        geomUrano = crearPlaneta("Urano", 3f,  "Interface/urano.jpg", 21f);

        // Crear Neptuno
        geomNeptuno = crearPlaneta("Neptuno", 3f,  "Interface/neptuno.jpg", 24f);

        // Crear Plutón
        geomPluton = crearPlaneta("Plutón", 3f, "Interface/pluton.jpeg", 27f);
        
        // Crear un nodo para la Tierra y la Luna
        nodoTierra = new Node("NodoTierra");

        // Adjuntar la Tierra al nodo de la Tierra
        nodoTierra.attachChild(geomTierra);

        // Crear la Luna y ajustar su tamaño
        geomLuna = crearPlaneta("Luna", 1f, "Interface/images.jpeg", 0.5f); // Ajusta el tamaño según tus necesidades

        // Adjuntar la Luna al nodo de la Tierra
        nodoTierra.attachChild(geomLuna);

        // Adjuntar el nodo de la Tierra (con la Tierra y la Luna) al nodo principal de la escena
        rootNode.attachChild(nodoTierra);
        
        cam.setLocation(new Vector3f(150, 80, 0)); // Posición de la cámara
        cam.lookAt(Vector3f.ZERO, Vector3f.UNIT_Y); // Dirección de la cámara (mirando hacia el origen)
    }

    @Override
    public void simpleUpdate(float tpf) {
        // Rotar planetas
        geomSol.rotate(0f, tpf * 0.2f, 0f);
        geomMercurio.rotate(0f, tpf * 3f, 0f);
        geomVenus.rotate(0f, tpf * 3f, 0f);
        geomTierra.rotate(0f, tpf * 3f, 0f);
        geomMarte.rotate(0f, tpf * 3f, 0f);
        geomJupiter.rotate(0f, tpf * 3f, 0f);
        geomSaturno.rotate(0f, tpf * 3f, 0f);
        geomUrano.rotate(0f, tpf * 3f, 0f);
        geomNeptuno.rotate(0f, tpf * 3f, 0f);
        geomPluton.rotate(0f, tpf * 3f, 0f);
        geomLuna.rotate(0f, tpf * 3f, 0f);

        // Rotar y mover los planetas
        float velocidadOrbita1 = 0.05f;
        float velocidadOrbita2 = 0.10f;
        float velocidadOrbita3 = 0.15f;
        float velocidadOrbita4 = 0.20f;
        float velocidadOrbita5 = 0.25f;
        float velocidadOrbita6 = 0.30f;
        float velocidadOrbita7 = 0.35f;
        float velocidadOrbita8 = 0.40f;
        float velocidadOrbita9 = 0.45f;
        
        anguloOrbitaMercurio += tpf * velocidadOrbita1;
        moverPlaneta(geomMercurio, anguloOrbitaMercurio, 10f);
        
        
        anguloOrbitaVenus += tpf * velocidadOrbita2;
        moverPlaneta(geomVenus, anguloOrbitaVenus, 15f);
        
        anguloOrbitaTierra += tpf * velocidadOrbita3;
        moverPlaneta(geomTierra, anguloOrbitaTierra, 20f);
        
        anguloOrbitaMarte += tpf * velocidadOrbita4;
        moverPlaneta(geomMarte, anguloOrbitaMarte, 25f);
        
        anguloOrbitaJupiter += tpf * velocidadOrbita5;
        moverPlaneta(geomJupiter, anguloOrbitaJupiter, 35f);
        
        anguloOrbitaSaturno += tpf * velocidadOrbita6;
        moverPlaneta(geomSaturno, anguloOrbitaSaturno, 45f);
        
        anguloOrbitaUrano += tpf * velocidadOrbita7;
        moverPlaneta(geomUrano, anguloOrbitaUrano, 55f);
        
        anguloOrbitaNeptuno += tpf * velocidadOrbita8;
        moverPlaneta(geomNeptuno, anguloOrbitaNeptuno, 65f);
        
        anguloOrbitaPluton += tpf * velocidadOrbita9;
        moverPlaneta(geomPluton, anguloOrbitaPluton, 75f);
        
        // Rotar y mover la Luna
        float velocidadOrbitaLuna = 3f; // Ajusta la velocidad de la órbita de la Luna
        anguloOrbitaLuna += tpf * velocidadOrbitaLuna;

        // Posición de la Tierra
        float posXTierra = geomTierra.getWorldTranslation().x;
        float posZTierra = geomTierra.getWorldTranslation().z;
        float posYTierra = geomTierra.getWorldTranslation().y;

        // Calcula la posición de la Luna con respecto a la Tierra
        float radioOrbitaLuna = 2f * factorRadioOrbitaPlaneta; // Ajusta el radio de la órbita de la Luna
        float posXLuna = posXTierra + FastMath.cos(anguloOrbitaLuna) * radioOrbitaLuna;
        float posZLuna = posZTierra + FastMath.sin(anguloOrbitaLuna) * radioOrbitaLuna;
        float posYLuna = posYTierra; // Los planetas orbitan en el mismo plano que el sol
        geomLuna.setLocalTranslation(posXLuna, posYLuna, posZLuna);
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
    
    private Geometry crearPlaneta(String nombre, float radio, String rutaTextura, float radioOrbita) {
        Sphere mallaPlaneta = new Sphere(50, 50, radio);
        Geometry geomPlaneta = new Geometry(nombre, mallaPlaneta);
        Material matPlaneta = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        Texture texturaPlaneta = assetManager.loadTexture(rutaTextura);
        matPlaneta.setTexture("ColorMap", texturaPlaneta);
        geomPlaneta.setMaterial(matPlaneta);
        rootNode.attachChild(geomPlaneta);
        return geomPlaneta;
    }
    
    private void moverPlaneta(Geometry geomPlaneta, float anguloOrbita, float radioOrbita) {
        float posXPlaneta = FastMath.cos(anguloOrbita) * radioOrbita * factorRadioOrbitaPlaneta;
        float posZPlaneta = FastMath.sin(anguloOrbita) * radioOrbita * factorRadioOrbitaPlaneta;
        float posYPlaneta = 0f; // Los planetas orbitan en el mismo plano que el sol
        geomPlaneta.setLocalTranslation(posXPlaneta, posYPlaneta, posZPlaneta);
    }
}