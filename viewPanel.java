package fr.enssat.BoulderDash.views;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import fr.enssat.BoulderDash.models.LevelModel;


/**
 * InformationPanel
 *
 * Information panel element.
 *
 * @author      kanwe fruissala <kanwefruissala@gmail.com>
 * @since       20-06-2020
 */
public class InformationPanel extends JPanel implements Observer {
	private LevelModel levelModel;
	private JTextArea text;

    /**
     * Class constructor
     */
	public InformationPanel(LevelModel levelModel) {
		this.levelModel = levelModel;
		this.text = new JTextArea();
		this.text.setEditable(false);
		this.levelModel.getGameInformationModel().addObserver(this);

		this.text.setText(
                "Score : " + levelModel.getGameInformationModel().getScore() +
				"\nRemaining diamonds : " + levelModel.getGameInformationModel().getRemainingsDiamonds()
        );

		this.add(this.text);
	}

    /**
     * Updates the panel
     *
     * @param  o    Observable item
     * @param  arg  Object item
     */
	@Override
	public void update(Observable o, Object arg) {
		this.text.setText(
                "Score : " + this.levelModel.getGameInformationModel().getScore() +
				"\nRemaining diamonds : " + this.levelModel.getGameInformationModel().getRemainingsDiamonds()
        );
	}
}
