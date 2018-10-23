package yehric2018.keyp.util;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class ClipboardManager {
	
	// Copies the given string onto the system clipboard
	public static void copyText(String text) {
		StringSelection selection = new StringSelection(text);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection, selection);
	}
	
	//  Clear passwords off of your clipboard
	public static void clearClipBoard() {
		copyText("");
	}
}
