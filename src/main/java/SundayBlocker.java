import com.google.inject.Inject;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by <a href="davidsunjie.sun@gmail.com">jerrysun</a> on 4/23/16.
 */
class SundayBlocker implements MethodInterceptor {

    @Inject
    private Now now;

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Calendar calendar = Calendar.getInstance();
        Date now = this.now.get();
        calendar.setTime(now);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEE, MMM d, yyyy");
        if (dayOfWeek == Calendar.SUNDAY) {
            String errorMessage =  String.format("Today(%s) is Sunday and you shall rest in God rather than work like a dog.", dateFormat.format(now));
            System.err.println(errorMessage);
            throw new IllegalStateException(errorMessage);
        }

        return methodInvocation.proceed();
    }
}
