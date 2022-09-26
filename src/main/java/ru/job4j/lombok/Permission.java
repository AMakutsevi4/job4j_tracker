package ru.job4j.lombok;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Builder(builderMethodName = "on")
@Data
public class Permission {
    private int id;
    private String name;
    @Singular("rules")
    private List<String> rules;

    public static void main(String[] args) {
       var test = Permission.on()
                .id(1)
                .name("Alex")
                .rules("1")
                .rules("2")
                .rules("3");
        System.out.println(test);
    }
}
