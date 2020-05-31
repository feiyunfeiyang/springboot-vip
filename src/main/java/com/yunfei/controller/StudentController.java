package com.yunfei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {


    @GetMapping("/getStu")
    public String getStudents(Model model){

        String[] week = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
        List<String> weekList = Arrays.asList(week);

        List<Integer> dayList = new ArrayList<>();
        LocalDate now = LocalDate.now();
        LocalDate date = LocalDate.of(now.getYear(),now.getMonthValue(),1);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int value = dayOfWeek.getValue();

        for (int i = 0; i < value; i++) {
            dayList.add(0);
        }
        int totalDay = date.lengthOfMonth();
        for (int i = 1; i <= totalDay; i++) {
            dayList.add(i);
        }
        model.addAttribute("weekList",weekList);
        model.addAttribute("dayList",dayList);
        model.addAttribute("currentDay",now.getDayOfMonth());
        return "index2";
    }

    @GetMapping("/admin")
    public String admin(Model model){
        return "admin";
    }
}
