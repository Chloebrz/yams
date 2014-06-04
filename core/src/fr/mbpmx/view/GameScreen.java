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
import fr.mbpmx.model.Combination;

public class GameScreen extends YamsScreen {
	private Controller controller;

	private Skin skin;
	// private Skin skinDices;
	private Stage stage;
	private Table table;

	private Table scoreTable;
	private TextButton dice1, dice2, dice3, dice4, dice5;
	private TextButton throwDices;

	private Table globalTable;

	@Override
	public void render(float delta) {
		super.render(delta);

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act(delta);
		stage.draw();

		Table.drawDebug(stage);
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

		// Create heading (displaying the current player's name)
		Label heading = new Label(controller.getCurrentPlayer().getName(), skin);
		heading.setFontScale(2);

		createDices();

		throwDices = new TextButton("Jeter les dés", skin);
		throwDices.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				controller.throwDices();
				dice1.setText(controller.getDices().get(0).toString());
				dice2.setText(controller.getDices().get(1).toString());
				dice3.setText(controller.getDices().get(2).toString());
				dice4.setText(controller.getDices().get(3).toString());
				dice5.setText(controller.getDices().get(4).toString());
			}
		});

		// Add buttons to the table
		table.add(dice1).spaceBottom(15).row();
		table.add(dice2).spaceBottom(15).row();
		table.add(dice3).spaceBottom(15).row();
		table.add(dice4).spaceBottom(15).row();
		table.add(dice5).spaceBottom(15).row();
		table.add(throwDices);
		table.right().center();

		scoreTable = new Table();
		createScoresTable();
		scoreTable.left().center();

		globalTable = new Table();
		globalTable.setFillParent(true);
		globalTable.add(scoreTable).space(75);
		globalTable.add(table);
		stage.addActor(globalTable);
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

	public void createDices() {
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
	}

	public void createScoresTable() {
		TextButton buttonOne = new TextButton("", skin, "small");
		scoreTable.add(new Label(Combination.ONE.toString(), skin, "small"));
		scoreTable.add(buttonOne).row();

		TextButton buttonTwo = new TextButton("", skin, "small");
		scoreTable.add(new Label(Combination.TWO.toString(), skin, "small"));
		scoreTable.add(buttonTwo).row();

		TextButton buttonThree = new TextButton("", skin, "small");
		scoreTable.add(new Label(Combination.THREE.toString(), skin, "small"));
		scoreTable.add(buttonThree).row();

		TextButton buttonFour = new TextButton("", skin, "small");
		scoreTable.add(new Label(Combination.FOUR.toString(), skin, "small"));
		scoreTable.add(buttonFour).row();

		TextButton buttonFive = new TextButton("", skin, "small");
		scoreTable.add(new Label(Combination.FIVE.toString(), skin, "small"));
		scoreTable.add(buttonFive).row();

		TextButton buttonSix = new TextButton("", skin, "small");
		scoreTable.add(new Label(Combination.SIX.toString(), skin, "small"));
		scoreTable.add(buttonSix).row();

		TextButton buttonTwoPairs = new TextButton("", skin, "small");
		scoreTable
				.add(new Label(Combination.TWOPAIRS.toString(), skin, "small"));
		scoreTable.add(buttonTwoPairs).row();

		TextButton buttonThreeOfAKind = new TextButton("", skin, "small");
		scoreTable.add(new Label(Combination.THREEOFAKIND.toString(), skin,
				"small"));
		scoreTable.add(buttonThreeOfAKind).row();

		TextButton buttonFullHouse = new TextButton("", skin, "small");
		scoreTable.add(new Label(Combination.FULLHOUSE.toString(), skin,
				"small"));
		scoreTable.add(buttonFullHouse).row();

		TextButton buttonFourOfAKind = new TextButton("", skin, "small");
		scoreTable.add(new Label(Combination.FOUROFAKIND.toString(), skin,
				"small"));
		scoreTable.add(buttonFourOfAKind).row();

		TextButton buttonStraight = new TextButton("", skin, "small");
		scoreTable
				.add(new Label(Combination.STRAIGHT.toString(), skin, "small"));
		scoreTable.add(buttonStraight).row();

		TextButton buttonYams = new TextButton("", skin, "small");
		scoreTable.add(new Label(Combination.YAMS.toString(), skin, "small"));
		scoreTable.add(buttonYams).row();

		TextButton buttonPlus = new TextButton("", skin, "small");
		scoreTable.add(new Label(Combination.PLUS.toString(), skin, "small"));
		scoreTable.add(buttonPlus).row();

		TextButton buttonMinus = new TextButton("", skin, "small");
		scoreTable.add(new Label(Combination.MINUS.toString(), skin, "small"));
		scoreTable.add(buttonMinus).row();

		TextButton buttonChance = new TextButton("", skin, "small");
		scoreTable.add(new Label(Combination.CHANCE.toString(), skin, "small"));
		scoreTable.add(buttonChance).row();
	}
}
