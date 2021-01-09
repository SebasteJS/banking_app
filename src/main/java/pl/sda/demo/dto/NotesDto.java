package pl.sda.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotesDto {

    private Long id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date data;

    @NotEmpty
    private String note;

}
