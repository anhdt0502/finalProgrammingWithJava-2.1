package controller;

import request.Request;

import java.util.ArrayList;
import java.util.List;

public class RequestParser {

    public Request parse(
            String input) {

        String[] arr =
                input.split("\\s+");

        Request request = new Request();

        request.getParams().clear();

        if (arr.length > 0)
            request =
                    new Request(arr[0], new ArrayList<>(), "");

        if (arr.length == 2) {

            request = new Request(arr[0], new ArrayList<>(), arr[1]);
        }

        if (arr.length == 3) {

            request = new Request(arr[0], List.of(arr[1]), arr[2]);
        }

        return request;
    }
}