package br.com.oliveira.silas.movies.domain

import io.reactivex.Maybe

abstract class InteractorMaybe<T, R> internal constructor(private val schedulers: Schedulers) {

    protected abstract fun create(request: R): Maybe<T>

    fun execute(request: R): Maybe<T> {
        return create(request)
                .subscribeOn(schedulers.subscribeOn)
                .observeOn(schedulers.observeOn)

    }

    abstract class Request
}
