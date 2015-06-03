package com.example.user.loftmoneytraker.rest;

import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Post;
import org.androidannotations.annotations.rest.Rest;

/**
 * Created by user on 03.06.2015.
 */
@Rest(rootUrl = "http://62.109.17.114/", converters = MessageConverter.class, interceptors = AuthenticatorInterceptor.class)
public interface RestClient {

    @Get("/auth?login={login}&password={password}")
    AuthResult login(CharSequence login, CharSequence password);

    @Get("/transactions")
    TransactionsResult getTransactions();


    @Post("/transactions/add?sum={sum}&comment={comment}&tr_date={date}&category_id=1")
    Result addTransaction(int sum, String comment, String date);

    @Post("/categories/add?title={title}")
    Result addCategory(String title);


}
