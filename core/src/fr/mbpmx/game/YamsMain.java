package fr.mbpmx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import fr.mbpmx.view.YamsSplash;

public class YamsMain extends Game {
	public final static String TITLE = "Yam's", VERSION = "1";

	@Override
	public void create() {
		((Game) Gdx.app.getApplicationListener())
				.setScreen(new YamsSplash());
	}

	@Override
	public void render() {
		super.render();
	}
}
