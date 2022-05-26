package com.example.demowww;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class InfoController {

    @Autowired
    private InfoService service;

    @RequestMapping(value="/info")
    public String viewInfoPage(Model model){
        List<Info> infoList= service.listAll();
        List<String > category=new ArrayList<>();
        category.add("Zakupy");
        category.add("Rozrywka");
        model.addAttribute("category",category);

        model.addAttribute("infoList",infoList);

        return "info";
    }
    @RequestMapping(value="/newInfo")
    public String showNewInfoForm(Model model){
        Info info=new Info();
        model.addAttribute("info",info);

        return "new_info";
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String newInfo(@ModelAttribute("info") Info info){
        service.save(info);

        return "redirect:/info";
    }

    @RequestMapping(value="/edit/{id}")
    public ModelAndView showEditInfoPage(@PathVariable(name = "id") Long id) {
        ModelAndView edit = new ModelAndView("edit_info");
        Info info = service.get(id);
        edit.addObject("info", info);

        return edit;
    }
    @RequestMapping(value="/delete/{id}")
    public String deleteInfo(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/info";
    }
}
