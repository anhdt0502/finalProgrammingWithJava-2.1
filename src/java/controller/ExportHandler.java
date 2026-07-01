package controller;

import request.Request;
import service.*;

public class ExportHandler implements ActionHandler {

    @Override
    public void handle(Request request) throws Exception {


        ExportService
                .getInstance()
                .export(request.getKeyword());

        System.out.println("Done!");
    }
}