import com.google.inject.AbstractModule;

/**
 * Created by <a href="davidsunjie.sun@gmail.com">jerrysun</a> on 4/22/16.
 */
public class DateModule extends AbstractModule {

    protected void configure() {
        this.bind(Now.class).to(CurrentTime.class);
    }

}
