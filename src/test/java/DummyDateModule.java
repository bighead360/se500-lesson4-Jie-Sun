import com.google.inject.AbstractModule;

/**
 * Created by <a href="davidsunjie.sun@gmail.com">jerrysun</a> on 4/23/16.
 */
public class DummyDateModule extends AbstractModule {

    protected void configure() {
        this.bind(Now.class).to(DummyNow.class).asEagerSingleton();
    }

}