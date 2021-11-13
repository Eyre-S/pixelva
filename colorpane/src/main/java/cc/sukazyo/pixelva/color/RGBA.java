package cc.sukazyo.pixelva.color;

public class RGBA {
	
	public static final RGBA EMPTY = new RGBA(0, 0, 0, 0);
	
	public final float red;
	public final float green;
	public final float blue;
	public final float alpha;
	
	public RGBA (float red, float green, float blue, float alpha) {
		if (
				red > 1f || green > 1f || blue > 1f || alpha > 1f ||
				red < 0f || green < 0f || blue < 0f || alpha < 0f
		) throw new IllegalArgumentException("RGBA with float can only contains number within 0f and 1f");
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.alpha = alpha;
	}
	
	public RGBA (int red, int green, int blue, int alpha) {
		if (
				red > 255 || green > 255 || blue > 255 || alpha > 255 ||
				red < 0 || green < 0 || blue < 0 || alpha < 0
		) throw new IllegalArgumentException("RGBA with int can only contains number within 0 and 255");
		this.red = red / 255f;
		this.green = green / 255f;
		this.blue = blue / 255f;
		this.alpha = alpha / 255f;
	}
	
	public int red () {
		return (int)(red * 255);
	}
	
	public int green () {
		return (int)(green * 255);
	}
	
	public int blue () {
		return (int)(blue * 255);
	}
	
	public int alpha () {
		return (int)(alpha * 255);
	}
	
	@Override
	public String toString () {
		return "RGBA{" + red + ", " + green + ", " + blue + ", " + alpha + '}';
	}
	
	public String toStringAs255 () {
		return String.format("rgba(%d, %d, %d, %d)",
				(int)(red * 255),
				(int)(green*255),
				(int)(blue*255),
				(int)(alpha*255)
		);
	}
	
	public RGBA blendNext (RGBA next) {
		
		float redCurr;
		float greenCurr;
		float blueCurr;
		float alphaCurr;
		redCurr = next.red * next.alpha + red * alpha * (1 - next.alpha);
		greenCurr = next.green * next.alpha + green * alpha * (1 - next.alpha);
		blueCurr = next.blue * next.alpha + blue * alpha * (1 - next.alpha);
		alphaCurr = 1 - (1 - next.alpha) * ( 1 - alpha);
		redCurr /= alphaCurr;
		greenCurr /= alphaCurr;
		blueCurr /= alphaCurr;
		return new RGBA(redCurr, greenCurr, blueCurr, alphaCurr);
		
	}
	
}
