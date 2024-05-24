package member.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class CommentDto {
    private int commentId;
    private int memberNum;
    private String commentText;
    private Timestamp commentDate;
    private String commentUser;
}
