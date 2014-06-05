package fr.mbpmx.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public abstract class YamsScreen implements Screen {
	protected Game game;
	protected Skin skin;
	protected Stage stage;
	protected Table table;

	@Override
	public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        stage.act(delta);
        stage.draw();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {
        skin = new Skin(Gdx.files.internal("ui/menuSkin.json"),
                new TextureAtlas("ui/atlas.pack"));

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        table = new Table(skin);
        table.setFillParent(true);
	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
        stage.dispose();
        skin.dispose();
	}

}
