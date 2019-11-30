package com.codegym.controller;

import com.codegym.model.Phone;
import com.codegym.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PhoneController {
    @Autowired
    private PhoneService phoneService;


    @GetMapping("/phones")
    public String phoneList(Model model, @PageableDefault(size = 10, sort = "price") Pageable pageable) {
        Page<Phone> phones = phoneService.findAll(pageable);
        model.addAttribute("phones", phones);
        return "phone/list";
    }

    @GetMapping("create-phone")
    public String createPhone(Model model) {
        model.addAttribute("phone", new Phone());
        return "phone/create";
    }
    @PostMapping("create-phone")
    public String saveNewPhone(Phone phone, Model model) {
        phoneService.save(phone);
        model.addAttribute("message", "Added new phone");
        model.addAttribute("phone", new Phone());
        return "phone/create";
}
    @GetMapping("/edit-phone/{id}")
    public String editPhone(@PathVariable Long id, Model model) {
        Phone phone = phoneService.findById(id);
        model.addAttribute("phone", phone);
        return "phone/edit";
    }

    @PostMapping("/edit-phone")
    public String saveEditPhone(Model model, Phone phone) {
        phoneService.save(phone);
        model.addAttribute("message", "Saved");
        return "phone/edit";
    }
    @GetMapping("/delete-phone/{id}")
    public String deletePhone(@PathVariable Long id, Model model) {
        Phone phone = phoneService.findById(id);
        model.addAttribute("phone", phone);
        return "phone/delete";
    }

    @PostMapping("/delete-phone")
    public String saveDeletePhone(Phone phone) {
        phoneService.remove(phone.getId());
        return "phone/delete";
    }
}