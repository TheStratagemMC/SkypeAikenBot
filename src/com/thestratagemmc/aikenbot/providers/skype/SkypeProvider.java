package com.thestratagemmc.aikenbot.providers.skype;

import com.skype.*;
import com.thestratagemmc.aikenbot.AikenBot;
import com.thestratagemmc.aikenbot.event.ChatGroupMessageEvent;
import com.thestratagemmc.aikenbot.event.ChatPersonalMessageEvent;
import com.thestratagemmc.aikenbot.provider.ServiceProvider;

import java.util.logging.Logger;

/**
 * Created by axel on 11/29/15.
 */
public class SkypeProvider implements ServiceProvider {
    @Override
    public void start() {
        Logger.getLogger("aiken").info("Starting...");

        Skype.setDaemon(false);
        AikenBot.callEvent(new ChatPersonalMessageEvent(null));

        try{
            Skype.addChatMessageListener(new ChatMessageListener() {
                @Override
                public void chatMessageReceived(ChatMessage chatMessage) throws SkypeException {
                    //System.out.println("Debug1");
                    if (chatMessage.getChat().getAllMembers().length == 2){
                        AikenBot.callEvent(new ChatPersonalMessageEvent(new SkypeChatMessage(chatMessage)));
                    }
                    else AikenBot.callEvent(new ChatGroupMessageEvent(new SkypeChatMessage(chatMessage), chatMessage.getChat().getId()));
                }

                @Override
                public void chatMessageSent(ChatMessage chatMessage) throws SkypeException {}
            });
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void disable() {
        Logger.getLogger("aiken").info("Disabling...");
    }
}
