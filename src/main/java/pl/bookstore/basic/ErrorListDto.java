package pl.bookstore.basic;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
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

    public void buildMessage(String message) {
        if (isEmpty()) {
            addError("Successfully " + message);
        }
    }

}
