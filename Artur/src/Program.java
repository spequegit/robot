import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Program {
	public static void main(String[] args) {

		JFrame frame = new JFrame("artur");

		frame.setSize(300, 300);

		JButton button = new JButton("napisz");

		frame.setLayout(new GridLayout(2, 2));

		JTextArea area = new JTextArea();

		frame.add(button);
		frame.add(area);
		frame.setVisible(true);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new Thread() {
					public void run() {
						while (true) {
							area.setText(new Random().nextInt(100) + "");
							try {
								sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					};
				}.start();
			}
		});

	}

	private static void wypisz() {
		for (int i = 0; i < 4; i = i + 1) {

			if (i >= 2) {
				System.out.println("wieksze " + i);
			} else {
				System.out.println("mniejsze " + i);

			}

		}
	}
}