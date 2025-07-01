package edu.icet.lms.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Course {
    private Long id;
    private String title;
    private String description;
    private String instructor;
}
