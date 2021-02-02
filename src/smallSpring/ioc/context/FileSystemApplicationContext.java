package smallSpring.ioc.context;

import smallSpring.ioc.resource.FileSystemResource;
import smallSpring.ioc.resource.Resource;

public class FileSystemApplicationContext extends AbstractXmlApplicationContext {

    @Override
    protected Resource getResourceByPath(String path) {
        if (path != null && path.startsWith("/")) {
            path = path.substring(1);
        }
        return new FileSystemResource(path);
    }
    public FileSystemApplicationContext(String configLocations)
    {
        setConfigLocations(configLocations);
        refresh();
    }

}
