package uj.edu.handgeometry.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import uj.edu.handgeometry.dao.GenericDao;

/**
 * Created by zaloguj on 08.04.2017.
 */
@Component
public class ApplicationContextHolder implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    private static ApplicationContext getContext() {
        if(context==null) {
            ClassPathXmlApplicationContext ctx =
                    new ClassPathXmlApplicationContext("classpath:/spring.xml");
        }

        return  context;
    }

    public static GenericDao getDbService() {
        return getContext().getBean(GenericDao.class);
    }

    public static Directory getDirectory() { return getContext().getBean(Directory.class); }

}
