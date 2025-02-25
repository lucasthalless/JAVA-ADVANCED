package br.com.fiap.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//define ate quando a anotação estara presente
@Retention(RetentionPolicy.RUNTIME)
//define onde pode ser utilizada a anotacao
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface Coluna {
	String nome();
	int tamanho() default 0;
	boolean obrigatorio() default false;
}