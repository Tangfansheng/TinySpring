package smallSpring.ioc.factory;

import smallSpring.ioc.beandefiniton.BeanDefinition;
import smallSpring.ioc.beandefiniton.RootBeanDefinition;
import smallSpring.ioc.registry.BeanDefinitionRegistry;

import java.util.Map;
import java.util.Set;

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory
        implements ConfigurableListableBeanFactory,BeanDefinitionRegistry{
//    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>(256);

    @Override
    public void preInstantiateSingletons() {
                for(Map.Entry<String,RootBeanDefinition> entry:MergedBeanDefinitions.entrySet())
                {
                    if(entry.getValue().isSingleton())
                    {
                        getBean(entry.getKey());
                    }
                }
    }

    @Override
    public int getBeanDefinitionCount() {
        return getMergedLocalBeanDefintionCount();
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
         registerMergedLocalBeanDefintion(beanName,(RootBeanDefinition) beanDefinition);
    }

    @Override
    public void removeBeanDefinition(String beanName) {
        removeMergedLocalBeanDefintion(beanName);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) {
        return getMergedLocalBeanDefintion(beanName);
    }

    @Override
    public void setBeanDefintionByType(String beanName, Class c) {
        DosetBeanDefintionByType(beanName,c);
    }

    @Override
    public String[] getBeanDefinitionNames() {
       return getMergedLocalBeanName();
    }

    @Override
    public String[] getBeanNamesForType(Class<?> c) {
        Set<String> set=getBeanDefintionByType(c);
        String[]res=new String[set.size()];
               int i=0;
               for( String s:set)
               {
                   res[i]=s;
                   i++;
               }
        return res;

    }


    public DefaultListableBeanFactory() {

    }
}
