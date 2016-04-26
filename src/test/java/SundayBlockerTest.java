import com.google.inject.Inject;
import org.apache.commons.lang3.time.DateUtils;
import org.jukito.JukitoRunner;
import org.jukito.UseModules;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by <a href="davidsunjie.sun@gmail.com">jerrysun</a> on 4/23/16.
 */
@RunWith(JukitoRunner.class)
@UseModules({RestOnSundayModule.class, DummyDateModule.class})
public class SundayBlockerTest {
    @Inject
    private Worker worker;
    @Inject private Now now;

    @Test(expected = IllegalStateException.class)
    public void blockedOnSunday() throws ParseException {
        now.set(new SimpleDateFormat("yyyy-M-d").parse("2016-4-17"));
        worker.workLikeADog();
    }

    @Test
    public void notBlockedOnMonday() throws ParseException, java.text.ParseException {
        Date monday = new SimpleDateFormat("yyyy-M-d").parse("2016-4-18");
        for (int i = 0; i < 6; i++) {
            now.set(DateUtils.addDays(monday, i));
            worker.workLikeADog();
        }
    }
}