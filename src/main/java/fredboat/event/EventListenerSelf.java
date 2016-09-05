/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fredboat.event;

import fredboat.commandmeta.Command;
import fredboat.commandmeta.CommandManager;
import fredboat.commandmeta.CommandRegistry;
import net.dv8tion.jda.entities.User;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import fredboat.FredBoat;
import fredboat.util.BotConstants;
import java.util.regex.Matcher;
import net.dv8tion.jda.events.ReadyEvent;

public class EventListenerSelf extends AbstractScopedEventListener {

    //public static HashMap<String, Message> messagesToDeleteIfIdDeleted = new HashMap<>();
    //public static HashMap<VoiceChannel, Runnable> toRunOnConnectingToVoice = new HashMap<>();
    public User lastUserToReceiveHelp;

    public EventListenerSelf(int scope, String defaultPrefix) {
        super(scope, defaultPrefix);
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (!event.getAuthor().getId().equals(BotConstants.OWNER_ID)) {
            return;
        }

        if (event.getMessage().getContent().length() < defaultPrefix.length()) {
            return;
        }

        if (event.getMessage().getContent().substring(0, defaultPrefix.length()).equals(defaultPrefix)) {
            String cmdName;
            Command invoked = null;
            try {
                System.out.println(event.getGuild().getName() + " \t " + event.getAuthor().getUsername() + " \t " + event.getMessage().getRawContent());
                Matcher matcher = commandNamePrefix.matcher(event.getMessage().getContent());
                matcher.find();

                invoked = CommandRegistry.getCommandFromScope(scope, matcher.group()).command;
            } catch (NullPointerException ex) {

            }

            if (invoked == null) {
                return;
            }

            CommandManager.prefixCalled(invoked, event.getGuild(), event.getTextChannel(), event.getAuthor(), event.getMessage());

            try {
                event.getMessage().deleteMessage();
            } catch (Exception ex) {
            }

        }
    }

}
