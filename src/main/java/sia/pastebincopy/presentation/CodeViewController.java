package sia.pastebincopy.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sia.pastebincopy.db.repository.CodeRepository;

@Controller
@RequestMapping("/code")
public class CodeViewController {

    private final CodeRepository codeRepo;

    CodeViewController(CodeRepository codeRepo) {
        this.codeRepo = codeRepo;
    }

    @GetMapping("/{uuid}")
    public String showCode(@PathVariable("uuid") String uuid, Model model){
        model.addAttribute("code", codeRepo.findByUuid(uuid));
        return "code";
    }
}
