package controller;

import request.Request;
import service.*;

public class ExportHandler
        implements ActionHandler {

    @Override
    public void execute(Request request) throws Exception {

        ExportService export = new ExportService();

        export.export(request.getKeyword(), DictionaryService.getInstance().getDictionary());

        System.out.println("Done!");
    }
}