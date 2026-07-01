package request;

import java.util.ArrayList;
import java.util.List;

public class Request {

    private String action;

    private String keyword;

    private List<String> params;

    public Request() {

        params = new ArrayList<>();

    }
    public Request(String action,
                   String keyword,
                   List<String> params) {

        this.action = action;
        this.keyword = keyword;
        this.params = params;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }

    public void addParam(String param){

        params.add(param);

    }
    @Override
    public String toString() {

        return "Request{" +
                "action='" + action + '\'' +
                ", keyword='" + keyword + '\'' +
                ", params=" + params +
                '}';
    }

}