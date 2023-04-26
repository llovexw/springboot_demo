package com.kunag.demo;

import java.lang.reflect.Method;

/**
 * @author luorui
 * @company SCUT
 * @create 2022-05-07-18:12
 */
public class UseAnnotation {

    @SimpleAnnotation("testStringValue")
    public void testMethod(){
        //do something here
    }

    private static void annotationLogic() {

        Class useAnnotationClass = UseAnnotation.class;
        for(Method method : useAnnotationClass.getMethods()) {
            SimpleAnnotation simpleAnnotation = (SimpleAnnotation)method.getAnnotation(SimpleAnnotation.class);
            if(simpleAnnotation != null) {
                System.out.println(" Method Name : " + method.getName());
                System.out.println(" value : " + simpleAnnotation.value());
                System.out.println(" --------------------------- ");
            }
        }
    }

    public static void main(String[] args) {
        annotationLogic();
    }


}
