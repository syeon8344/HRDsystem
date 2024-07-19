package web.model.dto;


import lombok.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString

public class DirectoryDto {
    private int dno;
    private String dname;
    private String dcontact;
}
