import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by <a href="davidsunjie.sun@gmail.com">jerrysun</a> on 4/22/16.
 */


@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.METHOD)

@interface NotOnSunday {

}
