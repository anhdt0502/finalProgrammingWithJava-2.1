package controller;

import request.Request;
import service.DictionaryService;

public class DropHandler
        implements ActionHandler {

    @Override
    public void execute(
            Request request) {

        DictionaryService
                .getInstance()
                .drop(
                        request.getKeyword());

        System.out.println(
                "@"
                        + request.getKeyword()
                        + " dropped!");
    }
}