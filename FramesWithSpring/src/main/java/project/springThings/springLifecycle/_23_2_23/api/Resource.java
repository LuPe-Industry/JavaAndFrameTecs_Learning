package project.springThings.springLifecycle._23_2_23.api;

import java.io.InputStream;

public interface Resource {
    InputStream readXML(String config);
}
