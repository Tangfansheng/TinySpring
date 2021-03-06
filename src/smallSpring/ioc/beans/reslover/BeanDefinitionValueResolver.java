package smallSpring.ioc.beans.reslover;

import smallSpring.ioc.beandefiniton.BeanDefinition;
import smallSpring.ioc.beans.springtype.Impl.RuntimeBeanReference;
import smallSpring.ioc.beans.springtype.Impl.TypedStringValue;
import smallSpring.ioc.beans.converter.TypeConverter;
import smallSpring.ioc.factory.AbstractBeanFactory;


public class BeanDefinitionValueResolver {
    private final AbstractBeanFactory beanFactory;

    private final String beanName;

    private final BeanDefinition beanDefinition;

    private final TypeConverter typeConverter;
    public BeanDefinitionValueResolver(
            AbstractBeanFactory beanFactory, String beanName, BeanDefinition beanDefinition, TypeConverter typeConverter) {

        this.beanFactory = beanFactory;
        this.beanName = beanName;
        this.beanDefinition = beanDefinition;
        this.typeConverter=typeConverter;

    }
    //解析value的实际类型
    public Object resolveValueIfNecessary(Object argName, Object value) {
        if (value instanceof RuntimeBeanReference) {
            RuntimeBeanReference ref = (RuntimeBeanReference) value;
            return resolveReference(argName, ref);
        }
        else if (value instanceof TypedStringValue) {
            TypedStringValue typedStringValue = (TypedStringValue) value;
           Object valueObject=((TypedStringValue) value).getValue();
            try {
                Class<?> resolvedTargetType = resolveTargetType(typedStringValue);
                if (resolvedTargetType != null) {
                    return this.typeConverter.convertIfNecessary(valueObject, resolvedTargetType);
                }
                else {
                    return valueObject;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
          return  value;
    }

    private Class<?> resolveTargetType(TypedStringValue typedStringValue) {
        return  typedStringValue.resloveTargetType(this.beanFactory.getBeanClassLoader());
    }

    private Object resolveReference(Object argName, RuntimeBeanReference ref) {
        String refName = ref.getBeanName();
        Object bean = null;
        try {
            bean = this.beanFactory.getBean(refName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  bean;

    }

}
