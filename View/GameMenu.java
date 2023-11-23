package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller.GameController;
import Model.GameModel;

public class GameMenu extends JFrame {
	JLabel txtSnackGame;
	JPanel contentPane;
	JButton start, help, more, exit;
	GameController controller;
	GameModel model;
	public GameMenu(GameModel model, GameController controller) throws HeadlessException {
		this.controller = controller;
		this.model = model;
		init();
	}
	

	public void init() {
		this.setTitle("PONG GAME");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 555);
		this.setSize(800, 800);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(6, 6, 6, 6));
		getContentPane().setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		start = new JButton("START");
		start.setForeground(new Color(255, 255, 255));
		start.setFont(new Font("Lucida Console", Font.PLAIN, 55));
		start.setBorder(new EmptyBorder(0, 0, 0, 0));
		start.setBackground(new Color(0, 0, 0));
		start.setBounds(292, 235, 194, 62);
		contentPane.add(start);

		more = new JButton("MORE");
		more.setFont(new Font("Lucida Console", Font.PLAIN, 55));
		more.setBackground(new Color(0, 0, 0));
		more.setForeground(new Color(255, 255, 255));
		more.setBorder(new EmptyBorder(0, 0, 0, 0));
		more.setBounds(292, 335, 194, 62);
		contentPane.add(more);

		help = new JButton("HELP");
		help.setForeground(new Color(255, 255, 255));
		help.setFont(new Font("Lucida Console", Font.PLAIN, 55));
		help.setBackground(new Color(0, 0, 0));
		help.setBorder(new EmptyBorder(0, 0, 0, 0));

		help.setBounds(292, 435, 194, 62);
		contentPane.add(help);

		exit = new JButton("Exit");
		exit.setForeground(new Color(255, 255, 255));
		exit.setFont(new Font("Lucida Console", Font.PLAIN, 55));
		exit.setBackground(new Color(0, 0, 0));
		exit.setBorder(new EmptyBorder(0, 0, 0, 0));

	exit.setBounds(292, 535, 194, 62);
		contentPane.add(exit);

		txtSnackGame = new JLabel("SHOGI GAME");
		txtSnackGame.setHorizontalAlignment(SwingConstants.CENTER);
		txtSnackGame.setFont(new Font("Lucida Console", Font.BOLD, 80));
		txtSnackGame.setForeground(Color.RED);
		txtSnackGame.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtSnackGame.setBounds(132, 80, 537, 62);
		contentPane.add(txtSnackGame);
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				hidee();
				controller.startGame();

			}
		});
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.exitGame();

			}
		});
		more.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.moreGame();

			}
		});
		help.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.helpGame();

			}
		});

//		

	}

	public void startGame()  {
		GameModel model = new GameModel();
        GameController controller = new GameController(model);
        GameView view = new GameView(controller, model);
        JFrame frame = new JFrame();
        frame.getContentPane().add(view);
        frame.setResizable(false);
        frame.setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
		
	}

	public void exitGame() {
		System.exit(0);
		
	}

	public void helpGame() {
		String message = "Mỗi bên sẽ có 20 quân cờ có kích thước giống nhau gồm: \n" +
		"1 Vua, 1 Xe, 1 Tượng, 2 Tướng vàng, 2 Tướng bạc, 2 Mã, 2 Hương Xa và 9 quân Tốt.\n" +
		"Cách đi của từng quân cờ: \n" +
		"+ Quân Vua: Vua có thể đi hoặc ăn quân 1 ô theo mọi hướng. \n" +
		"+ Tướng Vàng: Có thể đi được 1 ô về mọi hướng, trừ 2 ô chéo về sau (tổng 6 cách đi). \n" +
		"+ Tướng bạc: Đi 1 ô theo 4 đường chéo và 1 ô tiến về phía trước (tổng 5 cách đi). Sau khi phong cấp: Tướng bạc đi như Tướng vàng \n" 
		
		+
		"+ Tượng: Không giới hạn số ô đi dựa theo 2 đường chéo cắt nhau tại quân Tượng, miễn là không bị chặn quân. Sau khi phong cấp: Phạm vi di chuyển có thêm 1 ô lên trước, 1 ô phía sau, 1 ô sang phải và 1 ô sang trái (như Vua). \n"
		+
		"+ Xe: Không giới hạn số ô đi dựa theo 2 đường ngang và dọc cắt nhau tại quân Xe, miễn là không bị chặn. Sau khi phong cấp: Phạm vi di chuyển có thêm 2 ô chéo lên trước, 2 ô chéo xuống phía sau (như Vua). \n"
		+
		"+ Mã: Đi theo hình chữ L, nhưng chỉ đi tiến lên đằng trước như hình (2 cách đi) và có thể nhảy qua các quân khác. Khi đến hàng 8 hoặc 9, Mã sẽ được phong cấp. Sau khi Phong cấp: Phạm vi di chuyển có thêm là khả năng di chuyển như Tướng vàng. \n"
		
		+
		"+ Hương xa: Chỉ có thể đi theo chiều dọc, tiến lên phía trước. Sau khi Phong cấp: Phạm vi di chuyển có thêm là khả năng di chuyển như Tướng vàng. \n"+
		"+ Tốt: Chỉ đi thẳng phía trước 1 ô. Sau khi Phong cấp: Phạm vi di chuyển có thêm là khả năng di chuyển như Tướng vàng.";
		JOptionPane.showMessageDialog(null, message, "Help Menu", JOptionPane.INFORMATION_MESSAGE);
	}

	public void moreGame() {
		String message = "Shogi là loại cờ truyền thống của Nhật. \n" +
				"Shogi có bàn cờ 9x9 tức là 81 ô vuông cùng màu, thường làm bằng gỗ hoặc nhựa cứng. \n" +
	"3 ô đầu tiên bên mình được gợi là 'Sân nhà' còn 3 ô đầu tiên bên địch là 'Sân địch'. \n" + 
				"3 ô chính giữa sẽ là nơi giao tranh khốc liệt nhất của 2 phe. \n";
		JOptionPane.showMessageDialog(null, message, "More Menu", JOptionPane.INFORMATION_MESSAGE);
		
	}
public  void hidee() {
		
		setVisible(false);
	}

}
