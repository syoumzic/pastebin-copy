package sia.pastebincopy.domain.entity;

import lombok.Data;
import sia.pastebincopy.db.model.Code;
import sia.pastebincopy.db.model.User;

import java.util.UUID;

@Data
public class CodeForm {
    private String code;

    public Code toCode(User user){
        return new Code(UUID.randomUUID().toString(), code, user);
    }
}
