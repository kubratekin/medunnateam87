package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class Messages {

    private Integer id;
    private String email;
    private String message;
    private String name;
    private String subject;

    /*
    {
  "email": "string",
  "id": 0,
  "message": "string",
  "name": "string",
  "subject": "string"
}
     */
}