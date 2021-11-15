package cc.sukazyo.pixelva.color.base;

public interface IHueColor {
	
	static double calcRGBToHue (double r, double g, double b, double max, double min) {
		if (max == min) return 0;
		else if (max == r) return 1.0/6.0 * ((g-b)/(max-min)) + (g>=b?0.0:1.0);
		else if (max == g) return 1.0/6.0 * ((b-r)/(max-min)) + 1.0/3.0;
			else return 1.0/6.0 * ((r-g)/(max-min)) + 2.0/3.0;
	}
	
	static double calcHueToRGB (double hueT, double p, double q) {
		if (hueT < 1.0/6.0) return p + ((q-p) * 6.0 * hueT);
		else if (hueT < 1.0/2.0) return q;
		else if (hueT < 2.0/3.0) return p + ((q-p) * 6 * (2.0/3.0 - hueT));
			else return p;
	}

}
