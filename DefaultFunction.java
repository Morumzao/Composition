package br.gov.mpog.spu.servicos.portalservicos.controllers;

import java.util.function.BiFunction;

interface DefaultFunction<T> {

    BiFunction<T, T, T> getFunction();

}
