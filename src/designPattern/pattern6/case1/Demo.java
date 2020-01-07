package designPattern.pattern6.case1;

public class Demo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "hello");
        audioPlayer.play("vlc", "world");
        audioPlayer.play("mp4", "java");
        audioPlayer.play("avi", "best language");
        
//        play in normal mediaPlayer
//        VLC show
//        MP4 show
//        Invalid media
    }

}
