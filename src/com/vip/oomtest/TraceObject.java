package com.vip.oomtest;

import static com.sun.btrace.BTraceUtils.*;

import com.sun.btrace.annotations.*;

@BTrace

public class TraceObject {

	@OnMethod(clazz = "StartObject", method = "work", location = @Location(value = Kind.CALL, clazz = "/.*/", method = "/.*/"))

	public static void checkWhoCallMe() {

		println("check who ActionObject.work method:");

		jstack();

	}

}
