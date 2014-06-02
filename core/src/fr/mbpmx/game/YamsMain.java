package fr.mbpmx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import fr.mbpmx.view.MainMenuScreen;

public class YamsMain extends ApplicationAdapter {
	public final static String TITLE = "Yam's", VERSION = "1";

	@Override
	public void create() {
		((Game) Gdx.app.getApplicationListener())
				.setScreen(new MainMenuScreen());
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
}
