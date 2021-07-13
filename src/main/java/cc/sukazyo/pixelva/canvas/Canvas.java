package cc.sukazyo.pixelva.canvas;

import cc.sukazyo.pixelva.utils.RGBA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Canvas {
	
	private int width;
	private int height;
	private final List<ILayer> layerList = new ArrayList<>();
	
	public Canvas (int width, int height) {
		resize(width, height, 0, 0);
	}
	
	public int getWidth () {
		return width;
	}
	
	public int getHeight () {
		return height;
	}
	
	public List<ILayer> getLayers () {
		return layerList;
	}
	
	public List<ILayer> getLayerList () {
		return layerList;
	}
	
	public void addLayer (ILayer... layer) {
		layerList.addAll(Arrays.asList(layer));
	}
	
	public void resize (int width, int height, int originX, int originY) {
		this.width = width;
		this.height = height;
	}
	
	public RGBA[][] render () {
		RGBA[][] result = new RGBA[width][height];
		RGBA tmp;
		RGBA curr = RGBA.EMPTY;
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				for (ILayer layer : layerList) {
					tmp = layer.getRGBA(x, y);
					if (tmp == null) continue;
					curr = curr.blendNext(tmp);
				}
				result[x][y] = curr;
				curr = RGBA.EMPTY;
			}
		}
		return result;
	}
	
}
