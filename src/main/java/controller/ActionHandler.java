package controller;

import request.Request;

public interface ActionHandler {

    void execute(Request request)
            throws Exception;
}