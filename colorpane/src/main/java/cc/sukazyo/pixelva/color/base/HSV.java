package cc.sukazyo.pixelva.color.base;

public class HSV implements IHueColor, IRGBACompatible, IHSLCompatible {
	
	public final float hue;
	public final float saturation;
	public final float value;
	
	public HSV(float hue, float saturation, float value) {
		if (
				hue > 1f || saturation > 1f || value > 1f ||
				hue < 0f || saturation < 0f || value < 0f
		) throw new IllegalArgumentException("HSV with float can only contains number within 0f and 1f");
		this.hue = hue;
		this.saturation = saturation;
		this.value = value;
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
	
	@Override
	public HSL toHSL () {
		double lightness = value - value*saturation/2;
		double m = Math.min(lightness, 1-lightness);
		return new HSL(
				hue,
				(float)(m==0 ? (value-lightness)/m : 0),
				(float)lightness
		);
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
		return String.format("hsv(%.0f, %.0f%%, %.0f%%)", hueD(), saturation * 100f, value * 100f);
	}

}
