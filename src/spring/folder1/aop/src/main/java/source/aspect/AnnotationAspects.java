package source.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author Serzh Nosov created on 06.02.2019.
 */
@Aspect
public class AnnotationAspects {

    @Before("@annotation(source.aspect.Loggable)")
    public void myAdvice() {
        System.out.println("Loggable aspect!");
    }
}
