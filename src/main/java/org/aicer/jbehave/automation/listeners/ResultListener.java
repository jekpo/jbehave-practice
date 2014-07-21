package org.aicer.jbehave.automation.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

@SuppressWarnings("rawtypes")
public class ResultListener implements IAnnotationTransformer {

    public ResultListener() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void transform(ITestAnnotation annotation, Class testClass,
             Constructor testConstructor, Method testMethod) {
        // TODO Auto-generated method stub

    }

}
