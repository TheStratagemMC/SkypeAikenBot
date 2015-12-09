package com.thestratagemmc.aikenbot.providers.skype;

import com.skype.SkypeException;
import com.thestratagemmc.aikenbot.chat.ChatMessage;

/**
 * Created by axel on 11/29/15.
 */
public class SkypeChatMessage implements ChatMessage {
    com.skype.ChatMessage message;

    public SkypeChatMessage(com.skype.ChatMessage message){
        this.message = message;
    }
    @Override
    public String getSender() {
        try{
            return message.getSenderId();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getMessage(){
        try{
            return message.getContent();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void reply(String s) {
        try{
            message.getChat().send(s);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void replySender(String s) {
        try{
            message.getSender().chat().send(s);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
