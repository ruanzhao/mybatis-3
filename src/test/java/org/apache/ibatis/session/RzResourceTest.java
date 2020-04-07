package org.apache.ibatis.session;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.submitted.permissions.Resource;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

public class RzResourceTest {

    @Test
    public void resourceLoadTest() throws IOException {
        final String resource = "org/apache/ibatis/builder/MapperConfig.xml";
        final Reader reader = Resources.getResourceAsReader(resource);
        char[] buffer = new char[1024];
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while ((count = reader.read(buffer)) != -1) {
            sb.append(buffer, 0, count);
        }

        System.out.println(sb.toString());
    }

    @Test
    public void resourcePathTest() throws IOException {
        String resource = "resources/nodelet_test.xml";
        URL url = ClassLoader.getSystemResource(resource);
        System.out.println(url);
        if (url != null) {
            Reader reader = new InputStreamReader(url.openStream());
            char[] buffer = new char[1024];
            int count = 0;
            StringBuilder sb = new StringBuilder();
            while( (count = reader.read(buffer)) != -1) {
                sb.append(buffer, 0, count);
            }
            System.out.println(sb.toString());
        }
    }
}
