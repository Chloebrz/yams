package fr.mbpmx.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
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
		int screenWidth = Gdx.graphics.getWidth();
		int screenHeight = Gdx.graphics.getHeight();

		Color darkGreen = new Color(0.0012f, 0.23f, 0.039f, 1);
		Color lightGreen = new Color(0.023f, 0.507f, 0.082f, 1);

		ShapeRenderer shapeRenderer = new ShapeRenderer();
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.rect(0, 0, screenWidth, screenHeight, darkGreen,
				darkGreen, lightGreen, lightGreen);
		stage.draw();
		shapeRenderer.end();

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
