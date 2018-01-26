package soundutil;

import javax.sound.sampled.LineUnavailableException;

public class AudioPlayer implements Runnable{
	private int hz;
	private int msec;
	private double vol;
	
	public AudioPlayer(){}
	
	public AudioPlayer(double hz, int msec, double vol)
	{
		this.hz = (int)hz;
		this.msec = msec;
		this.vol = vol;
	}
	
	public AudioPlayer(AudioPlayer ap)
	{
		this.hz = (int)ap.hz;
		this.msec = ap.msec;
		this.vol = ap.vol;
	}
	
	public void set(double hz, int msec, double vol)
	{
		this.hz = (int)hz;
		this.msec = msec;
		this.vol = vol;
	}
	
	public void playHarmony(double hz, int msec, double vol)
	{
		new Thread(new AudioPlayer(hz,msec,vol)).start();
	}
	
	public void playHarmony()
	{
		new Thread(new AudioPlayer(this)).start();
	}
	
	public void play(){
		this.play(this.hz,this.msec,this.vol);
	}
	
	public void play(double hz, int msec, double vol)
	{
		try {
			SoundUtils.tone((int)hz,msec,vol);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		play(this.hz,this.msec,this.vol);
	}

}
