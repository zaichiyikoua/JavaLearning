package designPattern.pattern6.case1;

//普通播放器实现类
public class AudioPlayer implements MediaPlayer {
    MediaAdapter adapter;

    @Override
    public void play(String audioType, String fileName) {
        // TODO Auto-generated method stub
        // 普通播放器支持mp3格式
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("play in normal mediaPlayer");
            // 下面的是高级播放器，进行兼容处理，让普通播放器可以使用
        } else if (audioType.equalsIgnoreCase("vlc")) {
            adapter = new MediaAdapter(audioType);
            adapter.play(audioType, fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            adapter = new MediaAdapter(audioType);
            adapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media");
        }
    }

}
