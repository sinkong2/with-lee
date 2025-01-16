package phr_solution.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Patient {
    private Long id;
    private String name;
    private int age;
    private String gender;
}
