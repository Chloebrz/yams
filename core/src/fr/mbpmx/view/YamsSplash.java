package fr.mbpmx.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.TimeUtils;

import fr.mbpmx.game.YamsMain;

public class YamsSplash extends YamsScreen {
	private SpriteBatch batch;
	private Sprite splash;
	private long startTime;

	@Override
	public void render(float delta) {
		super.render(delta);

		batch.begin();
		splash.draw(batch);
		batch.end();

		if (TimeUtils.millis() > (startTime + 2000)) {
			((Game) Gdx.app.getApplicationListener())
					.setScreen(new MainMenuScreen());
		}
	}

	@Override
	public void show() {
		super.show();

		Label heading = new Label(YamsMain.TITLE, skin, "big");
		heading.setFontScale(2);

		batch = new SpriteBatch();
		splash = new Sprite(new Texture("img/yams.png"));
		splash.setPosition((Gdx.graphics.getWidth() - splash.getWidth()) / 2,
				(Gdx.graphics.getHeight() - splash.getHeight()) / 2);

		startTime = TimeUtils.millis();
	}

	@Override
	public void resize(int width, int height) {

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
		super.dispose();
	}
}