package sia.pastebincopy.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sia.pastebincopy.db.model.Code;
import sia.pastebincopy.db.repository.CodeRepository;
import sia.pastebincopy.domain.entity.CodeForm;

@Controller
@RequestMapping("/design")
public class DesignController {

    private final CodeRepository codeRepo;

    DesignController(CodeRepository codeRepo){
        this.codeRepo = codeRepo;
    }

    @GetMapping
    public String design(){
        return "design";
    }

    @PostMapping
    public String setCode(CodeForm codeForm) {
        Code code = codeForm.toCode();
        codeRepo.save(code);
        return "redirect:/code/%s".formatted(code.getUuid());
    }
}
