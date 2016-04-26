import com.google.inject.Guice;
import com.google.inject.Inject;

import java.text.SimpleDateFormat;

/**
 * Created by <a href="davidsunjie.sun@gmail.com">jerrysun</a> on 4/22/16.
 */
public class Worker {

    @Inject private Now now;

    @NotOnSunday
    public void workLikeADog(){
        String dayOfWeek = new SimpleDateFormat("EEEE").format(now.get());
        System.out.println("I am working now " + dayOfWeek);

    }




    public static void main(String[] args) {
        Worker worker = Guice.createInjector(new DateModule(), new RestOnSundayModule()).getInstance(Worker.class);
        worker.workLikeADog();
    }



}
