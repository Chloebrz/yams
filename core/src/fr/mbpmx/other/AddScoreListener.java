package fr.mbpmx.other;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import fr.mbpmx.controller.Controller;
import fr.mbpmx.model.Combination;

public class AddScoreListener extends ClickListener {
    Controller controller;
    Combination combination;
    
    
    public AddScoreListener(Controller controller, Combination combination) {
        super();
        this.controller = controller;
        this.combination = combination;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        if (controller.getCurrentPlayer().getScores()
                .get(combination) == -1) {
            controller.addScore(combination);
            System.out.println("Coucou c'est moi le AddScoreListener !!");
        }
    }
}
