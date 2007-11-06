package org.eclipse.swt.internal.cocoa;

public class NSOperation extends NSObject {

public NSOperation() {
	super();
}

public NSOperation(int id) {
	super(id);
}

public void addDependency(NSOperation op) {
	OS.objc_msgSend(this.id, OS.sel_addDependency_1, op != null ? op.id : 0);
}

public void cancel() {
	OS.objc_msgSend(this.id, OS.sel_cancel);
}

public NSArray dependencies() {
	int result = OS.objc_msgSend(this.id, OS.sel_dependencies);
	return result != 0 ? new NSArray(result) : null;
}

public id init() {
	int result = OS.objc_msgSend(this.id, OS.sel_init);
	return result != 0 ? new id(result) : null;
}

public boolean isCancelled() {
	return OS.objc_msgSend(this.id, OS.sel_isCancelled) != 0;
}

public boolean isConcurrent() {
	return OS.objc_msgSend(this.id, OS.sel_isConcurrent) != 0;
}

public boolean isExecuting() {
	return OS.objc_msgSend(this.id, OS.sel_isExecuting) != 0;
}

public boolean isFinished() {
	return OS.objc_msgSend(this.id, OS.sel_isFinished) != 0;
}

public boolean isReady() {
	return OS.objc_msgSend(this.id, OS.sel_isReady) != 0;
}

public void main() {
	OS.objc_msgSend(this.id, OS.sel_main);
}

public int queuePriority() {
	return OS.objc_msgSend(this.id, OS.sel_queuePriority);
}

public void removeDependency(NSOperation op) {
	OS.objc_msgSend(this.id, OS.sel_removeDependency_1, op != null ? op.id : 0);
}

public void setQueuePriority(int p) {
	OS.objc_msgSend(this.id, OS.sel_setQueuePriority_1, p);
}

public void start() {
	OS.objc_msgSend(this.id, OS.sel_start);
}

}
