package com.example.daopattern.callback;

import com.example.daopattern.repository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Getter
@Component
public class SpringJPAContext implements ApplicationContextAware {
    @Setter(onMethod = @__(@Autowired))
    private UserRepository userRepository;

    @Getter
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringJPAContext.applicationContext = applicationContext;
    }

}
