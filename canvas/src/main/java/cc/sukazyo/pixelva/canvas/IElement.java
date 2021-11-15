package cc.sukazyo.pixelva.canvas;

import cc.sukazyo.pixelva.color.base.RGBA;

public interface IElement {
	
	int getWidth();
	int getHeight();
	
	RGBA getRGBA (int x, int y);
	
}
