package smallSpring.test;

import smallSpring.ioc.context.FileSystemApplicationContext;

public class TestOfIoc {
    public static void main(String[] args) {
        FileSystemApplicationContext applicationContext = new FileSystemApplicationContext("classpath:application.xml");
        Object bean = applicationContext.getBean("1");
        System.out.println(bean);
    }
}
