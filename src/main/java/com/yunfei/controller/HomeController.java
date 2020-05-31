package com.yunfei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/getHome")
    public String getHome(){

        return "home";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/Browse_Categories.html")
    public String browse_categories(){
        return "Browse_Categories";
    }

    @GetMapping("/Browse_Channels.html")
    public String browse_channels(){
        return "Browse_Channels";
    }

    @GetMapping("/History_Page.html")
    public String history_page(){
        return "History_Page";
    }

    @GetMapping("/Searched_Videos_Page.html")
    public String searched_videos_page(){
        return "Searched_Videos_Page";
    }

    @GetMapping("/signup.html")
    public String signup(){
        return "signup";
    }

    @GetMapping("/Single_Channel_About.html")
    public String single_channel_about(){
        return "Single_Channel_About";
    }

    @GetMapping("/Single_Channel_Channels.html")
    public String single_channel_channels(){
        return "Single_Channel_Channels";
    }

    @GetMapping("/Single_Channel_Home.html")
    public String single_channel_home(){
        return "Single_Channel_Home";
    }

    @GetMapping("/Single_Channel_Playlist.html")
    public String single_channel_playlist(){
        return "Single_Channel_Playlist";
    }

    @GetMapping("/Single_Channel_Products.html")
    public String single_channel_products(){
        return "Single_Channel_Products";
    }

    @GetMapping("/Single_Channel_Videos.html")
    public String single_channel_videos(){
        return "Single_Channel_Videos";
    }

    @GetMapping("/single_video_fullwidth_page.html")
    public String single_video_fullwidth_page(){
        return "single_video_fullwidth_page";
    }

    @GetMapping("/single_video_page.html")
    public String single_video_page(){
        return "single_video_page";
    }

    @GetMapping("/single_video_playlist.html")
    public String single_video_playlist(){
        return "single_video_playlist";
    }

    @GetMapping("/Single_Video_Simplified_Page.html")
    public String single_video_simplified_page(){
        return "Single_Video_Simplified_Page";
    }

    @GetMapping("/Updates_From_Subs.html")
    public String updates_from_subs(){
        return "Updates_From_Subs";
    }

    @GetMapping("/Upload_Edit.html")
    public String upload_edit(){
        return "Upload_Edit";
    }

    @GetMapping("/Upload_Video.html")
    public String upload_video(){
        return "Upload_Video";
    }

    @GetMapping("/User_Account_Page.html")
    public String user_account_page(){
        return "User_Account_Page";
    }

    @GetMapping("/getConsole")
    public String getConsole(){
        return "console";
    }

}
