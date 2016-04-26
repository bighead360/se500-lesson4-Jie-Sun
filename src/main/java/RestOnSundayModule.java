import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

/**
 * Created by <a href="davidsunjie.sun@gmail.com">jerrysun</a> on 4/23/16.
 */
public class RestOnSundayModule extends AbstractModule {

    protected void configure() {
        SundayBlocker sundayBlocker = new SundayBlocker();
        this.requestInjection(sundayBlocker);
        this.bindInterceptor(Matchers.any(), Matchers.annotatedWith(NotOnSunday.class), sundayBlocker);
    }
}

