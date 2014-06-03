package fr.mbpmx.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import fr.mbpmx.controller.Controller;

public class GameScreen extends YamsScreen {
	private Controller controller;

	private Skin skin;
	// private Skin skinDices;

	private Stage stage;

	private Table table;
	private TextButton dice1, dice2, dice3, dice4, dice5;
	private TextButton throwDices;

	@Override
	public void render(float delta) {
		super.render(delta);

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act(delta);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {
		controller = new Controller();

		stage = new Stage();
		Gdx.input.setInputProcessor(stage);

		skin = new Skin(Gdx.files.internal("ui/menuSkin.json"),
				new TextureAtlas("ui/atlas.pack"));
		// skinDices = new Skin(Gdx.files.internal("ui/dices.json"),
		// new TextureAtlas("ui/dices.pack"));
		table = new Table();

		table.setFillParent(true);

		// Create heading (displaying the current player's name)
		Label heading = new Label(controller.getCurrentPlayer().getName(), skin);
		heading.setFontScale(2);

		// Create buttons
		dice1 = new TextButton("Dé 1", skin);
		dice1.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				controller.getDices().get(0)
						.setToThrow(!controller.getDices().get(0).isToThrow());
			}
		});
		dice2 = new TextButton("Dé 2", skin);
		dice2.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				controller.getDices().get(1)
						.setToThrow(!controller.getDices().get(1).isToThrow());
			}
		});
		dice3 = new TextButton("Dé 3", skin);
		dice3.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				controller.getDices().get(2)
						.setToThrow(!controller.getDices().get(2).isToThrow());
			}
		});
		dice4 = new TextButton("Dé 4", skin);
		dice4.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				controller.getDices().get(3)
						.setToThrow(!controller.getDices().get(3).isToThrow());
			}
		});
		dice5 = new TextButton("Dé 5", skin);
		dice5.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				controller.getDices().get(4)
						.setToThrow(!controller.getDices().get(4).isToThrow());
			}
		});

		throwDices = new TextButton("Jeter les dés", skin);
		throwDices.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				controller.throwDices();
			}
		});

		// Add buttons to the table
		table.add(heading).spaceBottom(50).row();
		table.add(dice1).spaceBottom(15).row();
		table.add(dice2).spaceBottom(15).row();
		table.add(dice3).spaceBottom(15).row();
		table.add(dice4).spaceBottom(15).row();
		table.add(dice5).spaceBottom(15).row();
		table.add(throwDices);

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

	}
}
