package de.tekup.jpademoa.ctrls;

import de.tekup.jpademoa.entities.VoitureEntity;
import de.tekup.jpademoa.services.VoitureService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/voitures/ui")
 @AllArgsConstructor
public class ViewVoitureCtrl {
    private VoitureService voitureService;
//    @GetMapping("/")
//    public String displayAllCars(Model model){
//        model.addAttribute("voitures",voitureService.getAllVoitures());
//        return "car";
//    }

    @GetMapping("/")
    public String displayAllCars(Model model,@RequestParam("page") Optional<Integer> page,
                                 @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(6);
        Page<VoitureEntity> voiturePage = voitureService.getPageVoitures(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("voiturePage", voiturePage);

        int totalPages = voiturePage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "car";
    }

    @GetMapping("/add")
    public String addClient(Model model){
        model.addAttribute("voiture",new VoitureEntity());
        return "voiture-add";
    }

    @PostMapping("/add")
    public String addClientPost(@ModelAttribute("voiture") @Valid VoitureEntity voiture, BindingResult result,@RequestParam("fileImage") MultipartFile multipartFile){
        if(result.hasErrors()){
            return "voiture-add";
        }
        voitureService.insertIntoDB(voiture);
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        String ext = fileName.substring(fileName.lastIndexOf("."));

        if(fileName!=null && fileName.length()>0) {
            String uploadDir = "src/main/resources/static/images/voitures/";
            String dir="/images/voitures/";
            fileName = "voiture-" + voiture.getId();
            voiture.setImagePath(dir+fileName+ext);
            try {
                FileUploadUtil.saveFile(uploadDir, fileName, ext, multipartFile);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        voitureService.insertIntoDB(voiture);
        return "redirect:/voitures/ui/";
    }
}
