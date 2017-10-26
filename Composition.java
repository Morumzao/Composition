package br.gov.mpog.spu.servicos.portalservicos.controllers;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Composition<T>  {

    private T result;

    private BiFunction<T, T, T> groupFunction;

    private Map<Class, Function<?, T>> composers = new LinkedHashMap<>();

    private Composition(BiFunction<T, T, T> groupFunction, T startValue){
        this.groupFunction = groupFunction;
        result = startValue;
    }

    private Composition(BiFunction<T, T, T> groupFunction){
        this.groupFunction = groupFunction;
        result = null;
    }

    private Function<?, T> getFunction(Class typeClass){
        return composers.getOrDefault(typeClass, null);
    }

    public <P> Composer<P> run(Function<P, T> function){
        return new Composer<>(function);
    }

    public <R> Composition<T> compose(Composable<R> composable){
        Function<R, T> function = (Function<R, T>) getFunction(composable.compoundClass());
        T parcial = function.apply(composable.compound());
        result = result != null ? groupFunction.apply(result, parcial) : parcial;
        return this;
    }

    public T evaluate(){
        return result;
    }

    public static <T> Composition<T> get(BiFunction<T, T, T> groupFunction, T startValue){
        return new Composition<>(groupFunction, startValue);
    }

    public static <T> Composition<T> get(BiFunction<T, T, T> groupFunction){
        return new Composition<>(groupFunction);
    }

    public static <T> Composition<T> get(DefaultFunction<T> defaultFunction){
        return new Composition<>(defaultFunction.getFunction());
    }

    public static Composition<Integer> get(){
        return new Composition<>(DefaultFunctions.Integers.ADD.getFunction());
    }

    public class Composer<P> {

        private Function<P, T> function;

        private Composer(Function<P, T> function){
            this.function = function;
        }

        public void when(Class typeClass){
            composers.putIfAbsent(typeClass, function);
        }

    }

}
