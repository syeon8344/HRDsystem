package web.model.dto;

import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @Builder
public class PersonnelDto {
    private int pno;
    private String pname;
    private String pcontact;
    private String prank;
    private int dno;
}
