package org.eclipse.swt.internal.cocoa;

public class NSProtocolChecker extends NSProxy {

public NSProtocolChecker() {
	super();
}

public NSProtocolChecker(int id) {
	super(id);
}

//public id initWithTarget(NSObject anObject, Protocol aProtocol) {
//	int result = OS.objc_msgSend(this.id, OS.sel_initWithTarget_1protocol_1, anObject != null ? anObject.id : 0, aProtocol != null ? aProtocol.id : 0);
//	return result != 0 ? new id(result) : null;
//}
//
//public Protocol protocol() {
//	int result = OS.objc_msgSend(this.id, OS.sel_protocol);
//	return result != 0 ? new Protocol(result) : null;
//}
//
//public static id protocolCheckerWithTarget(NSObject anObject, Protocol aProtocol) {
//	int result = OS.objc_msgSend(OS.class_NSProtocolChecker, OS.sel_protocolCheckerWithTarget_1protocol_1, anObject != null ? anObject.id : 0, aProtocol != null ? aProtocol.id : 0);
//	return result != 0 ? new id(result) : null;
//}

public NSObject target() {
	int result = OS.objc_msgSend(this.id, OS.sel_target);
	return result != 0 ? new NSObject(result) : null;
}

}
