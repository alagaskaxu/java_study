package com.xzy.javase.collection.demo;

public class C<E> implements IA1<E>{
    //父类有泛型,子类也建议有泛型
    @Override
    public E print(E e) {
        return null;
    }
}
