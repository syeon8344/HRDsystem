package web.model.dto;


import lombok.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString

public class DirectoryDto {
    private int pno;
    private String dname;
    private String dcontact;


}
