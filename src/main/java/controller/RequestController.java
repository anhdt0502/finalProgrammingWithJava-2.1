package controller;

import request.Request;

import java.util.*;

public class RequestController {

    private Map<String, ActionHandler> handlers;

    public RequestController() {

        handlers = new HashMap<>();

        handlers.put("lookup", new LookupHandler());

        handlers.put("define", new DefineHandler());

        handlers.put("drop", new DropHandler());

        handlers.put("export", new ExportHandler());
    }

    public void execute(Request request) throws Exception {

        handlers.get(request.getAction()).execute(request);
    }
}