package com.tj.spring.learn.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.Iterator;
import java.util.Objects;

/**
 * @author tangj
 * @description 此处监听spring 的启动事件，配置如下：
 * 1).在启动点，调用SpringApplication springApplication = new SpringApplication(Main.class); springApplication.addListeners(new ApplicationListenerCustomize());
    2).除1)这种方法，还可以用自动配置，在resources下新增META-INF 文件夹，并添加spring.factories 文件，在文件中，添加：org.springframework.context.ApplicationListener=com.tj.spring.learn.listener.ApplicationListenerCustomize
    进行自动配置
    g事件类型有以下几种：
        ApplicationStartingEvent：springboot启动开始的时候执行的事件，在该事件中可以获取到SpringApplication对象，可做一些执行前的设置。
        ApplicationEnvironmentPreparedEvent：spring boot 对应Enviroment已经准备完毕，但此时上下文context还没有创建。在该监听中获取到ConfigurableEnvironment后可以对配置信息做操作，例如：修改默认的配置信息，增加额外的配置信息等等。
        ApplicationPreparedEvent：spring boot上下文context创建完成，但此时spring中的bean是没有完全加载完成的。在获取完上下文后，可以将上下文传递出去做一些额外的操作。值得注意的是：在该监听器中是无法获取自定义bean并进行操作的。
        ApplicationReadyEvent：springboot 加载完成时候执行的事件
        ApplicationFailedEvent:spring boot启动异常时执行事件，在异常发生时，最好是添加虚拟机对应的钩子进行资源的回收与释放，能友善的处理异常信息
 * @since 2019/1/16 10:22
 */
@Slf4j
public class ApplicationListenerCustomize implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent applicationEnvironmentPreparedEvent) {
        ConfigurableEnvironment environment = applicationEnvironmentPreparedEvent.getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();

        if(Objects.nonNull(propertySources)){
            Iterator<PropertySource<?>> iterator = propertySources.iterator();
            while(iterator.hasNext()){
                PropertySource<?> next = iterator.next();
                log.info("Property Source:{}", next.getName());
            }
        }

        log.info("ApplicationListenerCustomize:");
    }
}
