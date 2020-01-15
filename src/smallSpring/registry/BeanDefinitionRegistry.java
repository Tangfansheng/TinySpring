package smallSpring.registry;

import smallSpring.beandefiniton.BeanDefinition;

public interface BeanDefinitionRegistry  {
    void removeBeanDefinition(String beanName);

    BeanDefinition getBeanDefinition(String beanName);

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
    String[] getBeanDefinitionNames();

    int getBeanDefinitionCount();

    void setBeanDefintionByType(String beanName, Class c);
}
