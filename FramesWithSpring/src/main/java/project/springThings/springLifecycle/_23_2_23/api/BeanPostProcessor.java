package project.springThings.springLifecycle._23_2_23.api;

public interface BeanPostProcessor {
    void beforeInitialization(Object bean);
    void afterInitialization(Object bean);
}
