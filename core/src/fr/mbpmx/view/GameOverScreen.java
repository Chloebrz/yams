package fr.mbpmx.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class GameOverScreen extends YamsScreen {
	private TextButton buttonMenu, buttonExit;

	@Override
	public void render(float delta) {

	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {
		// Creation of the buttons
		buttonMenu = new TextButton("Menu", skin);
		buttonMenu.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				((Game) Gdx.app.getApplicationListener())
						.setScreen(new MainMenuScreen());
			}
		});
		buttonMenu.pad(15); // TODO Select the right padding and place the
							// button in a table

		buttonExit = new TextButton("Exit", skin);
		buttonExit.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Gdx.app.exit();
			}
		});
		buttonExit.pad(10); // TODO Select the right padding and place the
							// button in a table
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

	}
}
