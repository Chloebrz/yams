package fr.mbpmx.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import fr.mbpmx.game.YamsMain;

public class HighScoresScreen extends YamsScreen {
	private TextButton buttonBack;
	private Table highScoresTable;

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
		
		// Creating and filling up of the high scores table
		highScoresTable = new Table();
		

		// Creating of the button
		buttonBack = new TextButton("Back", skin, "small");
		buttonBack.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				((Game) Gdx.app.getApplicationListener())
						.setScreen(new MainMenuScreen());
			}
		});

		table.add(heading).spaceBottom(75).row();
		table.add(highScoresTable).spaceBottom(20).row();
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
	}
}