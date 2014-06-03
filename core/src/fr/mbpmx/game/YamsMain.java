package fr.mbpmx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import fr.mbpmx.view.MainMenuScreen;

public class YamsMain extends Game {
	public final static String TITLE = "Yam's", VERSION = "1";

	@Override
	public void create() {
		((Game) Gdx.app.getApplicationListener())
				.setScreen(new MainMenuScreen());
	}

	@Override
	public void render() {
		super.render();
	}
}
