import java.util.Date;

/**
 * Created by <a href="davidsunjie.sun@gmail.com">jerrysun</a> on 4/23/16.
 */
public class DummyNow implements Now {
    private Date date;

    @Override
    public synchronized Date get() {
        return date == null ? new Date() : date;
    }

    @Override
    public synchronized void set(Date date) {
        this.date = date;
    }
}
