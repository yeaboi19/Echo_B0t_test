package Token.Commands;

import Token.MainThings.Constants;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GuildGets extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
//
//        String ChannelId = event.getChannel().getId();
//        String ChannelName = event.getChannel().getName();
//        String GuildId = event.getGuild().getId();
//        String GuildName = event.getGuild().getName();
//
//        String fullString = "Channel Id - " + ChannelId + "\n" +
//                "Channel Name - " + ChannelName + "\n" +
//                "Guild Id - " + GuildId + "\n" +
//                "GuildName - " + GuildName + "\n" +
//                "-----------------------------\n";
//        try {
//
//            String oldStrings="";
//
//            if(new File("D:\\serverGuilds_Channels.txt").exists()){
////                FileReader fileReader = new FileReader("D:\\serverGuilds_Channels.txt");
////                BufferedReader bufferedReader = new BufferedReader(fileReader);
////                while(bufferedReader.readLine()!=null){
////                    oldStrings+=bufferedReader.readLine();
////                    System.out.println(oldStrings);
////                }
////                System.out.println(oldStrings);
////                bufferedReader.close();
////                fileReader.close();
//                FileInputStream fileInputStream = new FileInputStream("D:\\serverGuilds_Channels.txt");
//
//                int content = -1;
//
//                while ((content = fileInputStream.read()) != -1) {
//
//                    oldStrings+=(char) content;
//                }
//            }
////            FileWriter fileWriter = new FileWriter("D:\\serverGuilds_Channels.txt");
////            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
////
////            bufferedWriter.write(oldStrings);
////            bufferedWriter.newLine();
////
////            bufferedWriter.write("Guild Name -"+GuildName);
////            bufferedWriter.newLine();
////
////            bufferedWriter.write("Guild Id -"+GuildId);
////            bufferedWriter.newLine();
////
////            bufferedWriter.write("Channel Name -"+ChannelName);
////            bufferedWriter.newLine();
////
////            bufferedWriter.write("Channel Id -"+ChannelId);
////            bufferedWriter.newLine();
////
////            bufferedWriter.close();
////            fileWriter.close();
//
//            String textToWrite =oldStrings+"Guild Name -"+GuildName+"\nGuild Id -"+GuildId+"\nChannel Name -"+ChannelName+"\nChannel Id -"+ChannelId+"\n\n";
//
//            FileOutputStream fileOutputStream = new FileOutputStream("D:\\serverGuilds_Channels.txt");
//
//            byte arr[] = textToWrite.getBytes();
//
//            fileOutputStream.write(arr);
//            fileOutputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//

        String msg = event.getMessage().getContentRaw();
        if (msg.equalsIgnoreCase(Constants.BotPrefix + "listChAll")) {
            List<GuildChannel> channelList = event.getGuild().getChannels();
            String mainMessage = "";
            for (int i = 0; i < channelList.size(); i++) {
                mainMessage += "------------------------------------\n" +
                        "channel Name - " + channelList.get(i).getName() +
                        "\nchannel Id" + channelList.get(i).getId() +
                        "\n----------------------------------";
                if (i % 5 == 0 && i != 0) {
                    event.getChannel().sendMessage(mainMessage).queue();
                    mainMessage = "";
                }
            }
            if (!mainMessage.isEmpty()) {
                event.getChannel().sendMessage(mainMessage).queue();
            }
        }
    }
}
