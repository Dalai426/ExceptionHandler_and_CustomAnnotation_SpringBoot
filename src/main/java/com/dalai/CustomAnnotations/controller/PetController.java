package com.dalai.CustomAnnotations.controller;


import com.dalai.CustomAnnotations.annotations.ImportantString;
import com.dalai.CustomAnnotations.annotations.RunImmediately;
import com.dalai.CustomAnnotations.exception.ApiRequestException;
import com.dalai.CustomAnnotations.model.Cat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


@RestController
public class PetController {
    @GetMapping("/cat")
    public String meow() throws InvocationTargetException, IllegalAccessException {
        Cat myCat=new Cat("Stella");
//        if(myCat.getClass().isAnnotationPresent(VeryImportant.class)){
//            return "This is important !!!";
//        }
//        return "gg";

        String res = "";
        for(Method method:myCat.getClass().getDeclaredMethods()){
            if(method.isAnnotationPresent(RunImmediately.class)){
                RunImmediately annotation=method.getAnnotation(RunImmediately.class);
                for(int i=0; i<annotation.times();i++) {
                    res += method.invoke(myCat);
                }
            }
        }

        for(Field field:myCat.getClass().getDeclaredFields()){
            if(field.isAnnotationPresent(ImportantString.class)){
                field.setAccessible(true);
                Object value=field.get(myCat);

                if(value instanceof String){
                    res+=value;
                }
            }
        }
        return res;
    }


    @GetMapping("/test-error")
    public String testError(){
        throw new ApiRequestException("Ohh it is error",400);
    }
}
