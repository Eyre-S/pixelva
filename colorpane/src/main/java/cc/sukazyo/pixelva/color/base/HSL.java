package cc.sukazyo.pixelva.color.base;

public class HSL implements IRGBACompatible, IHueColor {
	
	public final float hue;
	public final float saturation;
	public final float lightness;
	
	public HSL(float hue, float saturation, float lightness) {
		if (
				hue > 1f || saturation > 1f || lightness > 1f ||
				hue < 0f || saturation < 0f || lightness < 0f
		) throw new IllegalArgumentException("HSL with float can only contains number within 0f and 1f");
		this.hue = hue;
		this.saturation = saturation;
		this.lightness = lightness;
	}
	
	public static HSL fromRGB (RGBA rgba) {
		final double max = Math.max(Math.max(rgba.red, rgba.green), rgba.blue);
		final double min = Math.min(Math.min(rgba.red, rgba.green), rgba.blue);
		final double lightness = (max + min) / 2.0;
		return new HSL(
				(float)IHueColor.calcRGBToHue(rgba.red, rgba.green, rgba.blue, max, min),
				(float)((max==min)?0:(lightness<=0.5?((max-min)/(max+min)):((max-min)/(2-(max+min))))),
				(float)lightness
		);
	}
	
	@Override
	public RGBA toRGBA () {
		if (saturation == 0) return new RGBA(lightness, lightness, lightness);
		final double q = (lightness < 0.5) ? (lightness * (1.0 + saturation)) : (lightness + saturation - (lightness * saturation));
		final double p = 2.0 * (lightness - q);
		return new RGBA(
				(float)IHueColor.calcHueToRGB(hue + (1.0 / 3.0), p, q),
				(float)IHueColor.calcHueToRGB(hue, p, q),
				(float)IHueColor.calcHueToRGB(hue - (1.0 / 3.0), p, q)
		);
	}
	
	public float hue () { return hue; }
	public float hueD () { return hue * 360f; }
	
	public float saturation () { return saturation; }
	
	public float lightness () { return lightness; }
	
	@Override
	public String toString () {
		return String.format("HSL{%f, %f, %f}", hue, saturation, lightness);
	}
	
	public String toStringStd () {
		return String.format("hsl(%.1f, %.1f%%, %.1f%%)", hueD(), saturation * 100f, lightness * 100f);
	}
	
}
