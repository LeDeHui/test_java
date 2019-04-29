package Day14_3_Annotation;

//自定义注解
public @interface MyAnnotation {
	String value() default "hello";
}
