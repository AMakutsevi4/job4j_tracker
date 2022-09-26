package ru.job4j.lombok;

import lombok.*;

@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Category {
    @NonNull
    @Getter
    private int id;
    @Getter
    @Setter
    @EqualsAndHashCode.Include
    private String name;
}
