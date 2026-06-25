package request;

import java.util.ArrayList;
import java.util.List;

public class Request {

    private String action;

    private List<String> params;

    private String keyword;

    public Request() {

        params = new ArrayList<>();
    }

    public Request(
            String action,
            List<String> params,
            String keyword) {

        this.action = action;
        this.params = params;
        this.keyword = keyword;
    }

    public String getAction() {
        return action;
    }

    public List<String> getParams() {
        return params;
    }

    public String getKeyword() {
        return keyword;
    }
}