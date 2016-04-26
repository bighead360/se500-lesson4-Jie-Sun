import org.jukito.JukitoRunner;
import org.jukito.UseModules;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by <a href="davidsunjie.sun@gmail.com">jerrysun</a> on 4/23/16.
 */
@RunWith(JukitoRunner.class)
@UseModules({DateModule.class})
public class WorkerTest {
    @Inject
    private Worker worker;
    @Inject private Now now;

    @Test
    public void testWorkLikeADog() throws ParseException {
        now.set(new SimpleDateFormat("yyyy-M-d").parse("2016-4-24"));
        worker.workLikeADog();

        now.set(new SimpleDateFormat("yyyy-M-d").parse("2016-4-29"));
        worker.workLikeADog();

        now.set(new SimpleDateFormat("yyyy-M-d").parse("2016-4-30"));
        worker.workLikeADog();
    }
}