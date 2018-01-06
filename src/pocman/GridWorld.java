package pocman;

import javax.swing.*;

import pocman.Board;

import java.awt.EventQueue;

public class GridWorld extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GridWorld() {
		initUI();
	}
	
	private void initUI() {
		add(new Board());
        setTitle("Pacman");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(380, 420);
        setLocationRelativeTo(null);
        setVisible(true); 
	}
	
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            GridWorld ex = new GridWorld();
            ex.setVisible(true);
        });

    }
}
