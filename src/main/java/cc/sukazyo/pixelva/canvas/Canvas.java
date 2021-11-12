package cc.sukazyo.pixelva.canvas;

import cc.sukazyo.pixelva.utils.RGBA;

import java.util.ArrayList;
import java.util.List;

public class Canvas {
	
	private int width;
	private int height;
	private final List<Layer> layerList = new ArrayList<>();
	
	public static class Layer {
		public int x;
		public int y;
		public final IElement object;
		public Layer (int offsetX, int offsetY, IElement object) {
			x = offsetX; y = offsetY;
			this.object = object;
		}
	}
	
	public Canvas (int width, int height) {
		resize(width, height);
	}
	
	public int getWidth () {
		return width;
	}
	
	public int getHeight () {
		return height;
	}
	
	public void resize (int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public List<Layer> getLayers () {
		return layerList;
	}
	
	public Layer addLayer (IElement object) {
		return addLayer(object, 0, 0);
	}
	
	public Layer addLayer (IElement object, int offsetX, int offsetY) {
		Layer layer = new Layer(offsetX, offsetY, object);
		layerList.add(layer);
		return layer;
	}
	
	public RGBA[][] render () {
		RGBA[][] result = new RGBA[width][height];
		RGBA tmp;
		RGBA curr = RGBA.EMPTY;
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				for (Layer layer : layerList) {
					if (!(
						x < layer.x || y < layer.y ||
						x >= layer.x + layer.object.getWidth() ||
						y >= layer.y + layer.object.getHeight()
					)) {
						tmp = layer.object.getRGBA(x - layer.x, y - layer.y);
						if (tmp == null) continue;
						curr = curr.blendNext(tmp);
					}
				}
				result[x][y] = curr;
				curr = RGBA.EMPTY;
			}
		}
		return result;
	}
	
}
