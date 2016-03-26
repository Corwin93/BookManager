package org.lance.bookmanager.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by Corwin on 15.03.2016.
 */
public class BookManagerWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected String[] getServletMappings() {
        return new String [] {"/"};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {SpringWebConfig.class};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {SpringAppConfig.class};
    }
}
