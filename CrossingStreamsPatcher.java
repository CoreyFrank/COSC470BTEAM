import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class CrossingStreamsPatcher {

	private JFrame frame;
	private JProgressBar progressBar;
	private JLabel statusLabel;
	private JButton btnStart;
	private String clientVersion, serverVersion;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrossingStreamsPatcher window = new CrossingStreamsPatcher();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws InterruptedException 
	 */
	
	


	public CrossingStreamsPatcher() {
		initialize();

		statusLabel.setText("Checking current version...");
		if (checkVersion()) {
			btnStart.setEnabled(true);
			statusLabel.setText("Streams are up to date!");
			progressBar.setValue(100);
		}
		else {
			statusLabel.setText("Fetching current version...");
			//code to retreive new game data
			progressTheBar();

			statusLabel.setText("Updating Files...");
			//download game data
			progressTheBar();

			statusLabel.setText("Validating Files...");
			//recheck that all files were downloaded 
			progressTheBar();

			btnStart.setEnabled(true);
			statusLabel.setText("Streams are up to date!");
			progressBar.setValue(100);
		}
	}//CrossingStreamsPatcher

	private void progressTheBar() {
		progressBar.setValue(progressBar.getValue() + 20);
	}//progress the bar

	private boolean checkVersion() {
		//checks the clients version of the game against servers most up to date Version
		clientVersion = "Version 1.0";
		if (clientVersion.equals(getVersion())) {
			return true;
		} else {return false;}
	}//check version

	private String getVersion() {
		//method checks the repository for what version is the most up to date
		serverVersion = "Version 1.1";
		return serverVersion;
	}//getVersion

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 666, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Crossing Streams");
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 36));
		lblNewLabel.setBounds(145, 11, 319, 73);
		frame.getContentPane().add(lblNewLabel);

		progressBar = new JProgressBar();
		progressBar.setBounds(145, 70, 319, 14);
		frame.getContentPane().add(progressBar);

		statusLabel = new JLabel("Checking status'");
		statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
		statusLabel.setBounds(145, 95, 319, 41);
		frame.getContentPane().add(statusLabel);

		btnStart = new JButton("Start");
		btnStart.setBounds(210, 240, 189, 73);
		frame.getContentPane().add(btnStart);
		btnStart.setEnabled(false);
	}
}
