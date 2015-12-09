package com.thestratagemmc.aikenbot.providers.skype;

import com.thestratagemmc.aikenbot.AikenBot;

/**
 * Created by axel on 11/29/15.
 */
public class SkypeAikenBot {
    public static void main(String[] args){
        try{
            Class.forName("com.thestratagemmc.aikenbot.AikenBot");
        }catch(Exception e){ e.printStackTrace(); }
        AikenBot.setProvider(new SkypeProvider());
        AikenBot.start();
    }
}
