package br.gov.mpog.spu.servicos.portalservicos.controllers;

import java.util.function.Supplier;

@FunctionalInterface
public interface Composable<T> extends Supplier<T> {

    default T compound(){
        return this.get();
    }

    default Class compoundClass(){
        return compound().getClass();
    }

}
