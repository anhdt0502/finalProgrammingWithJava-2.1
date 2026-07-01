package controller;

import request.Request;

public interface ActionHandler {

    void handle(Request request) throws Exception;
}