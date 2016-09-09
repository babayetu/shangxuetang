package netty.demo;

import java.util.Date;

public class UnixTime {
	private final long value;

	public long getValue() {
		return value;
	}

	public UnixTime(long value) {
		this.value = value;
	}

	public UnixTime() {
		this(System.currentTimeMillis() / 1000L + 2208988800L);
	}

	@Override
	public String toString() {
		return new Date((getValue() - 2208988800L)*1000L).toString();
	}

}
