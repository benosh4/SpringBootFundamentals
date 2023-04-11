package ttl.larku.app.trickyness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author whynot
 */
interface Trick {
    public void doTrick();
}

@Component("t1")
@Qualifier("us-east")
//@Primary
//@Profile("one")
@Order(2)
class Trick1 implements Trick {
    @Override
    public void doTrick() {
        System.out.println("Handstand");
    }
}

@Component("t2")
//@Profile("two")
@Qualifier("us-west")
class Trick2 implements Trick {
    @Override
    public void doTrick() {
        System.out.println("Somersault");
    }
}

@Component
@Qualifier("us-east")
//@Profile("two")
@Order(1)
class Trick3 implements Trick {
    @Override
    public void doTrick() {
        System.out.println("Cart Wheel");
    }
}

@Component
class Circus
{
    @Autowired
    @Qualifier("us-west")
    private Trick trick;

    @Autowired
    @Qualifier("us-east")
    private List<Trick> allTricks;

    public void startShow() {
//        trick.doTrick();
        allTricks.forEach(Trick::doTrick);
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.getEnvironment().setActiveProfiles("two");
        context.scan("ttl.larku.app.trickyness");
        context.refresh();

        Circus circus = context.getBean("circus", Circus.class);
        circus.startShow();
    }
}
