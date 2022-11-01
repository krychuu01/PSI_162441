package pl.bookstore.basic;

import java.util.List;

public class ErrorListDto {

    public List<String> errors;

    public ErrorListDto(List<String> errors){
        this.errors = errors;
    }

    public boolean isEmpty(){
        return this.errors.isEmpty();
    }

    public void addError(String error){
        this.errors.add(error);
    }

}
