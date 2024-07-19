package web.model.dto;


import lombok.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString

public class DirectoryDto {
    private int pno;
    private String pname;
    private String pcontact;
    private String prank;
    private int dno;

}
