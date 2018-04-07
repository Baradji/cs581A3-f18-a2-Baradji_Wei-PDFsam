package org.pdfsam.ui.selection.multiple;


public class Default extends Type {
	public boolean canMove(SelectionChangedEvent selectionChangedEvent) {
		return selectionChangedEvent.getTop() > 0;
	}
}