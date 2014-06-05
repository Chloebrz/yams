package fr.mbpmx.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import fr.mbpmx.game.YamsMain;

public class InstructionsScreen extends YamsScreen {
	private TextButton buttonBack;
	private String instructionsText;

	private SpriteBatch batch;
	private BitmapFont font;

	@Override
	public void render(float delta) {
		super.render(delta);

		batch.begin();
		font.draw(batch, instructionsText, 200, 200);
		batch.end();
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

		// Creating the instructions text
		instructionsText = new String(
				"Here will be the instructions of our Yam's game.");
		batch = new SpriteBatch();
		font = new BitmapFont();

		// Creation of the button
		buttonBack = new TextButton("Back", skin, "small");
		buttonBack.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				((Game) Gdx.app.getApplicationListener())
						.setScreen(new MainMenuScreen());
			}
		});

		table.add(heading).spaceBottom(75).row();
		// table.add(instructionsText).spaceBottom(20).row();
		table.add(buttonBack).right().spaceBottom(15);

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
		batch.dispose();
		font.dispose();
	}
}
