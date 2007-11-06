package org.eclipse.swt.internal.cocoa;

public class NSCachedImageRep extends NSImageRep {

public NSCachedImageRep() {
	super();
}

public NSCachedImageRep(int id) {
	super(id);
}

public id initWithSize(NSSize size, int depth, boolean flag, boolean alpha) {
	int result = OS.objc_msgSend(this.id, OS.sel_initWithSize_1depth_1separate_1alpha_1, size, depth, flag, alpha);
	return result != 0 ? new id(result) : null;
}

public id initWithWindow(NSWindow win, NSRect rect) {
	int result = OS.objc_msgSend(this.id, OS.sel_initWithWindow_1rect_1, win != null ? win.id : 0, rect);
	return result != 0 ? new id(result) : null;
}

public NSRect rect() {
	NSRect result = new NSRect();
	OS.objc_msgSend_stret(result, this.id, OS.sel_rect);
	return result;
}

public NSWindow window() {
	int result = OS.objc_msgSend(this.id, OS.sel_window);
	return result != 0 ? new NSWindow(result) : null;
}

}
