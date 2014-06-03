package fr.mbpmx.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import fr.mbpmx.controller.Controller;

public class GameScreen extends YamsScreen {
	private Controller controller;

	private Skin skin;
	private Skin skinDices;
	
	private Table table;
	private ImageButton dice1, dice2, dice3, dice4, dice5;
	private TextButton throwDices;

	public GameScreen() {
		this.controller = new Controller();
	}

	@Override
	public void render(float delta) {
		super.render(delta);
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {
		skin = new Skin(Gdx.files.internal("ui/menuSkin.json"),
				new TextureAtlas("ui/atlas.pack"));
		skinDices = new Skin(Gdx.files.internal("ui/dices.json"),
				new TextureAtlas("ui/dices.pack"));
		table = new Table();

		dice1 = new ImageButton(skinDices);
		dice1.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				controller.getDices().get(0).setToThrow(false);
			}
		});
		dice2 = new ImageButton(skin);
		dice2.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				controller.getDices().get(1).setToThrow(false);
			}
		});
		dice3 = new ImageButton(skin);
		dice3.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				controller.getDices().get(2).setToThrow(false);
			}
		});
		dice4 = new ImageButton(skin);
		dice4.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				controller.getDices().get(3).setToThrow(false);
			}
		});
		dice5 = new ImageButton(skin);
		dice5.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				controller.getDices().get(4).setToThrow(false);
			}
		});

		throwDices = new TextButton("Jeter les dés", skin);
		throwDices.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				controller.throwDices();
			}
		});

		table.add(dice1).spaceBottom(15).row();
		table.add(dice2).spaceBottom(15).row();
		table.add(dice3).spaceBottom(15).row();
		table.add(dice4).spaceBottom(15).row();
		table.add(dice5).spaceBottom(15).row();
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
