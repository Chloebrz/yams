package fr.mbpmx.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MainMenuScreen extends YamsScreen {
	private TextButton buttonNewGame, buttonSettings, buttonInstructions,
			buttonExit;

	@Override
	public void render(float delta) {

	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {
		// Creation of the buttons
		buttonNewGame = new TextButton("New Game", skin);
		buttonNewGame.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				((Game) Gdx.app.getApplicationListener())
						.setScreen(new GameScreen());
			}
		});
		buttonNewGame.pad(15); // TODO Select the right padding and place the
								// button in a table

		buttonSettings = new TextButton("Settings", skin);
		buttonSettings.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				((Game) Gdx.app.getApplicationListener())
						.setScreen(new SettingsScreen());
			}
		});
		buttonSettings.pad(10); // TODO Select the right padding and place the
								// button in a table

		buttonInstructions = new TextButton("EXIT", skin);
		buttonInstructions.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				((Game) Gdx.app.getApplicationListener())
						.setScreen(new InstructionsScreen());
			}
		});
		buttonInstructions.pad(10); // TODO Select the right padding and place
									// the button in a table

		buttonExit = new TextButton("EXIT", skin);
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
