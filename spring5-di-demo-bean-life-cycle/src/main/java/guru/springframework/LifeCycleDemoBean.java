package guru.springframework;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by jt on 6/5/17.
 */
@Component
public class LifeCycleDemoBean implements BeanNameAware,
                                          BeanFactoryAware,
                                          ApplicationContextAware,
                                          //beforeInit()
                                          //@PostConstruct
                                          InitializingBean, //afterPropertiesSet()
                                          //afterInit()
                                          //....
                                          //@PreDestroy
                                          DisposableBean //destroy()
                                          {


    public LifeCycleDemoBean() {
        System.out.println("## I'm in the LifeCycleBean Constructor");
    }

    @Override
    public void setBeanName(String name) {  //BeanNameAware
        System.out.println("## My Bean Name is: " + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {  //BeanFactoryAware
        System.out.println("## Bean Factory has been set");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {  //ApplicationContextAware
        System.out.println("## Application context has been set");
    }

    //magic
    public void beforeInit() {
        System.out.println("## - Before Init - Called by Bean Post Processor");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("## The Post Construct annotated method has been called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {  //InitializingBean
        System.out.println("## The LifeCycleBean has its properties set!");
    }

    //magic
    public void afterInit() {
        System.out.println("## - After init called by Bean Post Processor");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("## The Predestroy annotated method has been called");
    }

    @Override
    public void destroy() throws Exception {  //DisposableBean
        System.out.println("## The Lifecycle bean has been terminated");
    }
}
