package designPattern.pattern6.case1;

//适配器模式的核心，适配器类
public class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedPlayer = new VLCPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedPlayer = new MP4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        // TODO Auto-generated method stub
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedPlayer.playVLC(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedPlayer.playMP4(fileName);
        }
    }

}
