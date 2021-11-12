package cc.sukazyo.pixelva.canvas.element;

import cc.sukazyo.pixelva.canvas.IElement;
import cc.sukazyo.pixelva.utils.RGBA;

import java.util.Arrays;

public class PixelCanvas implements IElement {
	
	private int width;
	private int height;
	public RGBA[][] canvas;
	
	public PixelCanvas (int width, int height, RGBA defaultColor) {
		this.width = width;
		this.height = height;
		canvas = new RGBA[width][height];
		for (RGBA[] i : canvas) {
			Arrays.fill(i, defaultColor);
		}
	}
	
	@Override
	public RGBA getRGBA (int x, int y) {
		return canvas[x][y];
	}
	
	void setRGBA (int x, int y, RGBA color) {
		canvas[x][y] = color;
	}
	
	@Override
	public int getWidth () {
		return width;
	}
	
	@Override
	public int getHeight () {
		return height;
	}
	
	public void resize (int width, int height, int originX, int originY, RGBA defaultColor) {
		RGBA[][] newCanvas = new RGBA[width][height];
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (x >= originX && y >= originY && x < originX + this.width && y < originY + this.height) {
					newCanvas[x][y] = canvas[x-originX][y-originY];
				} else {
					newCanvas[x][y] = defaultColor;
				}
			}
		}
		this.width = width;
		this.height = height;
		canvas = newCanvas;
	}
	
}
