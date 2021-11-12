package cc.sukazyo.pixelva.output;

import cc.sukazyo.pixelva.canvas.Canvas;
import cc.sukazyo.pixelva.utils.RGBA;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class LocalOutput {
	
	public static void output (Canvas canvas, String encoding, OutputStream stream) throws IOException {
		
		RGBA[][] out = canvas.render();
		
		BufferedImage image = new BufferedImage(canvas.getWidth(), canvas.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = (Graphics2D) image.getGraphics();
		for (int y = 0; y < canvas.getHeight(); y++) {
			for (int x = 0; x < canvas.getWidth(); x++) {
				g.setColor(new Color(out[x][y].red, out[x][y].green, out[x][y].blue, out[x][y].alpha));
				g.drawLine(x, y, x, y);
			}
		}
		
		ImageIO.write(image, encoding, stream);
		
	}
	
	public static ByteArrayOutputStream output (Canvas canvas, String encoding) {
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		try {
			output(canvas, encoding, byteArrayOutputStream);
		} catch (IOException ignored) { }
		return byteArrayOutputStream;
		
	}
	
}
