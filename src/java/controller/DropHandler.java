package controller;

import request.Request;
import service.DictionaryService;

public class DropHandler implements ActionHandler {

    @Override
    public void handle(
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