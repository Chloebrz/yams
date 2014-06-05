package fr.mbpmx.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import fr.mbpmx.game.YamsMain;
import fr.mbpmx.model.Player;
import fr.mbpmx.other.Constants;

public class MainMenuScreen extends YamsScreen {
	private TextButton buttonNewGame, buttonSettings, buttonInstructions,
			buttonExit;

	@Override
	public void render(float delta) {
		super.render(delta);
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {
		super.show();

		// Creating heading
		Label heading = new Label(YamsMain.TITLE, skin, "big");
		heading.setFontScale(2);

		// Creation of the buttons
		buttonNewGame = new TextButton("New Game", skin);
		buttonNewGame.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if (!Constants.playersInstantiated) {
					Constants.p1 = new Player("Player 1");
					Constants.p2 = new Player("Player 2");
				}
				((Game) Gdx.app.getApplicationListener())
						.setScreen(new GameScreen());
			}
		});
		buttonNewGame.pad(15);

		buttonSettings = new TextButton("Settings", skin);
		buttonSettings.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				((Game) Gdx.app.getApplicationListener())
						.setScreen(new SettingsScreen());
			}
		});
		buttonSettings.pad(10);

		buttonInstructions = new TextButton("Instructions", skin);
		buttonInstructions.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				((Game) Gdx.app.getApplicationListener())
						.setScreen(new InstructionsScreen());
			}
		});
		buttonInstructions.pad(10);

		TextButton buttonGameOver = new TextButton("Game Over Screen", skin);
		buttonGameOver.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				((Game) Gdx.app.getApplicationListener())
						.setScreen(new GameOverScreen());
			}
		});
		buttonGameOver.pad(10);

		buttonExit = new TextButton("Exit", skin);
		buttonExit.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Gdx.app.exit();
			}
		});
		buttonExit.pad(10);

		table.add(heading).spaceBottom(75).row();
		table.add(buttonNewGame).spaceBottom(15).row();
		table.add(buttonSettings).spaceBottom(15).row();
		table.add(buttonInstructions).spaceBottom(15).row();
		table.add(buttonGameOver).spaceBottom(15).row();
		table.add(buttonExit);

		stage.addActor(table);
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
