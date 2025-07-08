package sia.pastebincopy.presentation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sia.pastebincopy.db.model.Code;
import sia.pastebincopy.db.model.User;
import sia.pastebincopy.db.repository.CodeRepository;

@Slf4j
@Controller
@RequestMapping("/code")
public class CodeViewController {

    private final CodeRepository codeRepo;

    CodeViewController(CodeRepository codeRepo) {
        this.codeRepo = codeRepo;
    }

    @GetMapping("/{uuid}")
    public String showCode(@AuthenticationPrincipal User auth, @PathVariable("uuid") String uuid, Model model){
        Code code = codeRepo.findByUuid(uuid);

        if(code == null){
            return "notFound";
        }

        User user = code.getUser();

        model.addAttribute("isAuthor", user.equals(auth));
        model.addAttribute("code", code.getCode());
        return "code";
    }

    @DeleteMapping("/{uuid}")
    public String deleteCode(@AuthenticationPrincipal User user, @PathVariable("uuid") String uuid) {
        Code code = codeRepo.findByUuid(uuid);

        if(code == null || !code.getUser().equals(user)){
            return "code";
        }

        codeRepo.delete(code);
        return "redirect:/";
    }
}
