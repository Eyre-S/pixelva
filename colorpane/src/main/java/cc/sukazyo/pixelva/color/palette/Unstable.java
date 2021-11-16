package cc.sukazyo.pixelva.color.palette;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface Unstable {
	
	Type[] value() default {Type.DELETE, Type.VALUE_CHANGE, Type.RENAME, Type.FILED_RENAME, Type.FILED_MOVE};
	
	enum Type {
		DELETE, VALUE_CHANGE, RENAME, FILED_RENAME, FILED_MOVE
	}
	
}
