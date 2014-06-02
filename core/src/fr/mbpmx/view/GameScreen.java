package fr.mbpmx.view;

import fr.mbpmx.controller.Controller;

public class GameScreen extends YamsScreen {
	private BoardRenderer renderer;
	private Controller controller;

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
