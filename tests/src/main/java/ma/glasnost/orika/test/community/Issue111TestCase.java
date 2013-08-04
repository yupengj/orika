package ma.glasnost.orika.test.community;

import java.io.File;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.generator.EclipseJdtCompiler;
import ma.glasnost.orika.test.MappingUtil;
import ma.glasnost.orika.test.MavenProjectUtil;

import org.junit.Test;

public class Issue111TestCase {
    
    @Test
    public void test() throws Exception {
        
        final ClassLoader tccl = Thread.currentThread().getContextClassLoader();
        
        File projectRoot = MavenProjectUtil.findProjectRoot();
        
        EclipseJdtCompiler complier = new EclipseJdtCompiler(tccl);
        final ClassLoader childLoader = complier.compile(new File(projectRoot, "src/main/java-hidden"),tccl);
        
        Class<?> postClass = childLoader.loadClass("issue111.Post");
        Class<?> postEntity = childLoader.loadClass("issue111.PostEntity");
        
        try {
            Thread.currentThread().setContextClassLoader(childLoader);
            
            MapperFactory factory = MappingUtil.getMapperFactory();
        
            factory.classMap(postClass, postEntity)
                .field("id", "id")
                .field("message", "content")
                .field("from.name", "fromUser")
                .field("createdTime", "creationTime")
                .field("link", "url")
                .field("from.id", "user:{getUser()|setUser(%s)|type=issue111.FacebookUserEntity}.id")
                .register();
            
        } finally {
            Thread.currentThread().setContextClassLoader(tccl);
        }
    }

}
