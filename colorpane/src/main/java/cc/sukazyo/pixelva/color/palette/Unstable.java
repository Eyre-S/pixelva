package cc.sukazyo.pixelva.color.palette;

import java.lang.annotation.*;

/**
 * 用于标示一个色表或预定义颜色定义并不确定，在后期版本有变动的可能
 */
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface Unstable {
	
	Type[] value() default {Type.DELETE, Type.VALUE_CHANGE, Type.RENAME, Type.FILED_RENAME, Type.FILED_MOVE};
	
	enum Type {
		DELETE, VALUE_CHANGE, RENAME, FILED_RENAME, FILED_MOVE
	}
	
}
