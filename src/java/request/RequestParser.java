package request;

public class RequestParser {

    public Request parse(String input){

        Request request = new Request();

        if(input == null || input.isBlank()){

            return request;

        }

        String[] tokens = input.trim().split("\\s+");

        request.setAction(tokens[0].toLowerCase());

        for(int i = 1; i < tokens.length; i++){

            if(tokens[i].startsWith("-")){

                request.addParam(tokens[i]);

            }else{

                request.setKeyword(tokens[i]);

            }

        }

        return request;

    }

}