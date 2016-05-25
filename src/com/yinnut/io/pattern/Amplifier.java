package com.yinnut.io.pattern;

public class Amplifier {
	private Voice voice;

	public Amplifier() {
	}

	public Amplifier(Voice voice) {
		this.voice = voice;
	}

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}

	public void say() {
		System.out.println(voice.getVolumn() * 1000);
	}
}
