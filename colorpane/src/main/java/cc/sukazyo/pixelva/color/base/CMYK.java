package cc.sukazyo.pixelva.color.base;

public class CMYK implements IRGBACompatible {
	
	public final float cyan;
	public final float magenta;
	public final float yellow;
	public final float black;
	
	public CMYK (float cyan, float magenta, float yellow, float black) {
		if (
				cyan > 1f || magenta > 1f || yellow > 1f || black > 1f ||
				cyan < 0f || magenta < 0f || yellow < 0f || black < 0f
		) throw new IllegalArgumentException("RGBA with float can only contains number within 0f and 1f");
		this.cyan = cyan;
		this.magenta = magenta;
		this.yellow = yellow;
		this.black = black;
	}
	
	@Override
	public RGBA toRGBA () {
		return new RGBA(
				(float)(1.0 - cyan*(1.0-black) - black),
				(float)(1.0 - magenta*(1.0-black) - black),
				(float)(1.0 - yellow*(1.0-black) - black)
		);
	}
	
	@Override
	public String toString () { return String.format("CMYK{%f, %f, %f, %f}", cyan, magenta, yellow, black); }
	
	public String toStringStd () { return String.format("cmyk(%.0f, %.0f, %.0f, %.0f)", cyan, magenta, yellow, black); }
	
}
