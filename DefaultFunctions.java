package br.gov.mpog.spu.servicos.portalservicos.controllers;

import java.util.function.BiFunction;

public class DefaultFunctions {

    private DefaultFunctions(){}

    public enum Integers implements DefaultFunction<Integer> {
        ADD((a, b) -> a + b),
        MULTIPLY((a, b) -> a * b),
        DIVIDE((a, b) -> a / b),
        SUBTRACT((a, b) -> a - b);

        final BiFunction<Integer, Integer, Integer> function;

        Integers(BiFunction<Integer, Integer, Integer> function){
            this.function = function;
        }

        @Override
        public BiFunction<Integer, Integer, Integer> getFunction(){
            return function;
        }

    }    
    
    public enum Longs implements DefaultFunction<Long> {
        ADD((a, b) -> a + b),
        MULTIPLY((a, b) -> a * b),
        DIVIDE((a, b) -> a / b),
        SUBTRACT((a, b) -> a - b);

        final BiFunction<Long, Long, Long> function;

        Longs(BiFunction<Long, Long, Long> function){
            this.function = function;
        }

        @Override
        public BiFunction<Long, Long, Long> getFunction(){
            return function;
        }

    }    
    
    public enum Doubles implements DefaultFunction<Double> {
        ADD((a, b) -> a + b),
        MULTIPLY((a, b) -> a * b),
        DIVIDE((a, b) -> a / b),
        SUBTRACT((a, b) -> a - b);

        final BiFunction<Double, Double, Double> function;

        Doubles(BiFunction<Double, Double, Double> function){
            this.function = function;
        }

        @Override
        public BiFunction<Double, Double, Double> getFunction(){
            return function;
        }

    }
    
    public enum Floats implements DefaultFunction<Float> {
        ADD((a, b) -> a + b),
        MULTIPLY((a, b) -> a * b),
        DIVIDE((a, b) -> a / b),
        SUBTRACT((a, b) -> a - b);

        final BiFunction<Float, Float, Float> function;

        Floats(BiFunction<Float, Float, Float> function){
            this.function = function;
        }

        @Override
        public BiFunction<Float, Float, Float> getFunction(){
            return function;
        }

    }
    
}