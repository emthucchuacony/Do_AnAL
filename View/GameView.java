package View;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Controller.GameController;
import Model.GameModel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameView extends JPanel {
	GameController controller;
	GameModel model;
	 private BufferedImage[] shogiPieceImages;

	public GameView(GameController controller, GameModel model) {

		this.controller = controller;
		this.model = model;
		creatView();
	}

	private void creatView() {
		loadShogiPieceImages();	
		this.setFocusable(true);
		this.setPreferredSize(new Dimension(750, 750));

	}
	private void loadShogiPieceImages() {
	    shogiPieceImages = new BufferedImage[9];

	    try {
	        for (int i = 0; i < 9; i++) {
	            String fileName = "D:\\esclipe\\Project_AL\\src\\image\\tot.png"; // Điều chỉnh tên tệp và đường dẫn tùy thuộc vào cấu trúc thư mục của bạn

	            File file = new File(fileName);
	            if (!file.exists()) {
	                System.out.println("File not found: " + fileName);
	                return;
	            }

	            shogiPieceImages[i] = ImageIO.read(file);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	 private void drawShogiPieces(Graphics g) {
	        Graphics2D g2d = (Graphics2D) g;

	        // Vị trí mẫu của các quân cờ Shogi (điều chỉnh theo nhu cầu)
	        int[] shogiPieceX = {60, 120, 180, 240, 300, 360, 420, 480,540};
	        int shogiPieceY = getHeight() / 2 + 50;

	        for (int i = 0; i < shogiPieceX.length; i++) {
	            int x = shogiPieceX[i];
	            int y = shogiPieceY;

	            // Vẽ hình ảnh quân cờ Shogi
	            g2d.drawImage(shogiPieceImages[i], x, y, this);
	        }
	    }

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawChessboard(g);
		 drawShogiPieces(g);
	}

	private void drawChessboard(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);

		// Set the stroke (line thickness) to your desired value, for example, 2.0f
		float thickness = 1.3f;
		g2d.setStroke(new BasicStroke(thickness));

		g2d.setColor(Color.BLACK); // Một màu sắc khác để kiểm tra

		int squareSize = 650; // Kích thước của hình vuông
		int centerX = getWidth() / 2 - squareSize / 2; // Tìm trung tâm theo chiều ngang
		int centerY = getHeight() / 2 - squareSize / 2; // Tìm trung tâm theo chiều dọc

		// Tính kích thước mỗi ô
		int cellSize = squareSize / 9;

		// Vẽ các ô trên bàn cờ
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				int x = centerX + col * cellSize;
				int y = centerY + row * cellSize;

				// Màu trắng cho từng ô
				g2d.setColor(Color.WHITE);
				g2d.fillRect(x, y, cellSize, cellSize);

				// Vẽ đường thằng màu đen ngăn cách giữa các ô
				g2d.setColor(Color.BLACK);
				g2d.drawRect(x, y, cellSize, cellSize);
			}
		}
	}
	

	    // Helper method to draw centered text
	    private void drawCenteredString(Graphics2D g2d, String text, int x, int y) {
	        FontMetrics metrics = g2d.getFontMetrics();
	        int textWidth = metrics.stringWidth(text);
	        int textHeight = metrics.getHeight();

	        // Center text horizontally and vertically
	        int centerX = x - textWidth / 2;
	        int centerY = y + textHeight / 2;

	        g2d.drawString(text, centerX, centerY);
	    }

}
