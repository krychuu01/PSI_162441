package pl.bookstore.basic.dto;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class MessageListDto {

    public List<String> errors = new ArrayList<>();

    public boolean isErrorListEmpty(){
        return this.errors.isEmpty();
    }

    public void addError(String error){
        this.errors.add(error);
    }

    public void buildMessage(String message) {
        if (isErrorListEmpty()) {
            addError("Successfully " + message);
        }
    }

}
