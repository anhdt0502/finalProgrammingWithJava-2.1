package controller;

import request.Request;

import java.util.*;

public class ActionController {

    private final Map<String, ActionHandler> handlers;

    public ActionController() {

        handlers = new HashMap<>();

        registerHandlers();

    }

    public void registerHandlers() {

//        handlers = new HashMap<>();

        handlers.put("lookup", new LookupHandler());

        handlers.put("define", new DefineHandler());

        handlers.put("drop", new DropHandler());

        handlers.put("export", new ExportHandler());

//        handlers.put("upload-audio", new UploadAudioHandler());
    }

    public void execute(Request request) throws Exception {
        ActionHandler handler = handlers.get(request.getAction());

        if (handler == null) {
            System.out.println("Unknown action!");

            return;
        }

        handler.handle(request);

    }
}