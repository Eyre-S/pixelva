package cc.sukazyo.pixelva.color.palette;

import cc.sukazyo.pixelva.color.base.RGBA;

/**
 * CGA 标准色表<br>
 * <br>
 * 已从可靠信息来源完成编写，此色表确认稳定<br>
 *
 * @author https://en.wikipedia.org/wiki/Color_Graphics_Adapter#Color_palette
 */
@SuppressWarnings("unused")
public class ColorPaletteCGA {
	
	public static final RGBA BLACK =         RGBA.asBinRGB(0x000000), $0 = BLACK;
	public static final RGBA BLUE =          RGBA.asBinRGB(0x0000aa), $1 = BLUE;
	public static final RGBA GREEN =         RGBA.asBinRGB(0x00aa00), $2 = GREEN;
	public static final RGBA CYAN =          RGBA.asBinRGB(0x00aaaa), $3 = CYAN;
	public static final RGBA RED =           RGBA.asBinRGB(0xaa0000), $4 = RED;
	public static final RGBA MAGENTA =       RGBA.asBinRGB(0xaa00aa), $5 = MAGENTA;
	public static final RGBA BROWN =         RGBA.asBinRGB(0xaa5500), $6 = BROWN;
	public static final RGBA LIGHT_GRAY =    RGBA.asBinRGB(0xaaaaaa), $7 = LIGHT_GRAY;
	public static final RGBA DARK_GRAY =     RGBA.asBinRGB(0x555555), $8 = DARK_GRAY;
	public static final RGBA LIGHT_BLUE =    RGBA.asBinRGB(0x5555ff), $9 = BLUE;
	public static final RGBA LIGHT_GREEN =   RGBA.asBinRGB(0x55ff55), $A = GREEN,         $10 = $A;
	public static final RGBA LIGHT_CYAN =    RGBA.asBinRGB(0x55ffff), $B = LIGHT_CYAN,    $11 = $B;
	public static final RGBA LIGHT_RED =     RGBA.asBinRGB(0xff5555), $C = RED,           $12 = $C;
	public static final RGBA LIGHT_MAGENTA = RGBA.asBinRGB(0xff55ff), $D = LIGHT_MAGENTA, $13 = $D;
	public static final RGBA YELLOW =        RGBA.asBinRGB(0xffff55), $E = YELLOW,        $14 = $E;
	public static final RGBA WHITE =         RGBA.asBinRGB(0xffffff), $F = WHITE,         $15 = $F;
	
}
