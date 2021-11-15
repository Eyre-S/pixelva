package cc.sukazyo.pixelva.color.base;

public class HSV implements IRGBACompatible, IHueColor {
	
	public final float hue;
	public final float saturation;
	public final float value;
	
	public HSV(float hue, float saturation, float value) {
		if (
				hue > 1f || saturation > 1f || value > 1f ||
				hue < 0f || saturation < 0f || value < 0f
		) throw new IllegalArgumentException("HSL with float can only contains number within 0f and 1f");
		this.hue = hue;
		this.saturation = saturation;
		this.value = value;
	}
	
	public static HSL fromRGB (RGBA rgba) {
		final double max = Math.max(Math.max(rgba.red, rgba.green), rgba.blue);
		final double min = Math.min(Math.min(rgba.red, rgba.green), rgba.blue);
		return new HSL(
				(float)IHueColor.calcRGBToHue(rgba.red, rgba.green, rgba.blue, max, min),
				(float)((max==0)?0:(1.0-(min/max))),
				(float)max
		);
	}
	
	@Override
	public RGBA toRGBA () {
		int h = (int)Math.floor(hue/6.0);
		double f = hue/6.0 - h;
		double p = value * (1.0 - saturation);
		double q = value * (1.0 - f * saturation);
		double t = value * (1.0 - (1.0-f) * saturation);
		switch (h) {
			case 0: return new RGBA((int)value, (int)t, (int)p);
			case 1: return new RGBA((int)q, (int)value, (int)p);
			case 2: return new RGBA((int)p, (int)value, (int)t);
			case 3: return new RGBA((int)p, (int)q, (int)value);
			case 4: return new RGBA((int)t, (int)p, (int)value);
			default: return new RGBA((int)value, (int)p, (int)q);
		}
	}
	
	public float hue () { return hue; }
	public float hueD () { return hue * 360f; }
	
	public float saturation () { return saturation; }
	
	public float value () { return value; }
	
	@Override
	public String toString () {
		return String.format("HSV{%f, %f, %f}", hue, saturation, value);
	}
	
	public String toStringStd () {
		return String.format("hsv(%.1f, %.1f%%, %.1f%%)", hueD(), saturation * 100f, value * 100f);
	}

}
