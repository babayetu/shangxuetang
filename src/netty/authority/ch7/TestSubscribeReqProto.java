package netty.authority.ch7;

import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.InvalidProtocolBufferException;

import netty.authority.ch7.SubscribeReqProto.SubscribeReq;
import netty.authority.ch7.SubscribeReqProto.SubscribeReq.Builder;

public class TestSubscribeReqProto {
	private static byte[] encode(SubscribeReqProto.SubscribeReq req) {
		return req.toByteArray();
	}
	
	private static SubscribeReqProto.SubscribeReq decode(byte[] body) throws InvalidProtocolBufferException {
		return SubscribeReqProto.SubscribeReq.parseFrom(body);
	}
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static SubscribeReqProto.SubscribeReq createSubscribeReq() {
		Builder builder = SubscribeReqProto.SubscribeReq.newBuilder();
		builder.setSubReqID(1);
		builder.setUserName("jingjing");
		builder.setProductName("iphone7");
		List address = new ArrayList<String>();
		address.add("nanpu bridge");
		address.add("daning international");
		builder.addAllAddress(address);
		return builder.build();
	}
	
	public static void main(String[] args) throws InvalidProtocolBufferException {
		SubscribeReqProto.SubscribeReq req = createSubscribeReq();
		System.out.println("before encoding : " + req.toString());
		
		SubscribeReqProto.SubscribeReq req2 = decode(encode(req));
		System.out.println("after decode:" + req2.toString());
		System.out.println("Assert equal:" + req2.equals(req));
		
	}
	
}
