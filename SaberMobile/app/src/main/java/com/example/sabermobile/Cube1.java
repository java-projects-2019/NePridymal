package com.example.sabermobile;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.loader.G3dModelLoader;
import com.badlogic.gdx.graphics.g3d.loader.ObjLoader;
import com.badlogic.gdx.graphics.g3d.utils.AnimationController;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.JsonReader;

import javax.swing.Action;

public class Cube extends ApplicationAdapter {
    private ModelBatch modelBatch;
    private PerspectiveCamera camera;
    private ModelInstance model;
    private CameraInputController controller;
    private Environment environment;
    private AnimationController control;

    @Override
    public void create() {
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.3f,0.3f,0.3f,1f));
        environment.add(new DirectionalLight().set(Color.WHITE, -0.5f, -1f, 0.25f));
        modelBatch = new ModelBatch();

        camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        camera.position.set(20,0,0);
        camera.lookAt(0,0,0);
        camera.far = 6000f;
        camera.near = 0.1f;

        controller = new CameraInputController(camera);
        controller.autoUpdate = true;

        JsonReader reader = new JsonReader();
        G3dModelLoader loader = new G3dModelLoader(reader);
        model = new ModelInstance(loader.loadModel(Gdx.files.internal("CubeFinal.g3dj")));
        model.transform.scl(2);




    }
    @Override
    public void render() {
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        controller.update();
        modelBatch.begin(camera);
        modelBatch.render(model, environment);
        modelBatch.end();
    }
    @Override
    public void dispose(){
        modelBatch.dispose();
    }
}
