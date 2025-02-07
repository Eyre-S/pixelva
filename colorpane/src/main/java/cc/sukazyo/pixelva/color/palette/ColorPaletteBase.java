package cc.sukazyo.pixelva.color.palette;

import cc.sukazyo.pixelva.color.base.RGBA;

import static cc.sukazyo.pixelva.color.palette.Unstable.Type.DELETE;

/**
 * 基础色表<br>
 * 目前基本是由 Web 16 基础色填写，保留任何变动可能
 */
@Unstable(DELETE)
@SuppressWarnings("unused")
public class ColorPaletteBase {
	
	          public static final RGBA RED =     RGBA.asBinRGB(0xff0000);
	@Unstable public static final RGBA LIME =    RGBA.asBinRGB(0x00ff00);
	          public static final RGBA BLUE =    RGBA.asBinRGB(0x0000ff);
	@Unstable public static final RGBA FUCHSIA = RGBA.asBinRGB(0xff00ff);
	@Unstable public static final RGBA YELLOW =  RGBA.asBinRGB(0xffff00);
	@Unstable public static final RGBA AQUA =    RGBA.asBinRGB(0x00ffff);
	
	@Unstable public static final RGBA MAROON =  RGBA.asBinRGB(0x800000);
	@Unstable public static final RGBA GREEN =   RGBA.asBinRGB(0x008000);
	@Unstable public static final RGBA NAVY =    RGBA.asBinRGB(0x000080);
	@Unstable public static final RGBA PURPLE =  RGBA.asBinRGB(0x800080);
	@Unstable public static final RGBA OLIVE =   RGBA.asBinRGB(0x808000);
	@Unstable public static final RGBA TEAL =    RGBA.asBinRGB(0x008080);
	
	          public static final RGBA WHITE =   RGBA.asBinRGB(0xffffff);
	          public static final RGBA SILVER =  RGBA.asBinRGB(0xc0c0c0);
	          public static final RGBA GRAY =    RGBA.asBinRGB(0x808080);
	          public static final RGBA BLACK =   RGBA.asBinRGB(0x000000);
	
}
