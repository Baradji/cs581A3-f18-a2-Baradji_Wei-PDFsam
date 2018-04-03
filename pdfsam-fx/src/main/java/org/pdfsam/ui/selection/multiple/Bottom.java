package org.pdfsam.ui.selection.multiple;


/**
 * @see org.pdfsam.ui.selection.multiple.move.MoveType#BOTTOM
 */
public class Bottom extends Type {
	public boolean canMove(SelectionChangedEvent selectionChangedEvent) {
		return selectionChangedEvent.isSingleSelection()
				&& selectionChangedEvent.getBottom() < selectionChangedEvent.getTotalRows() - 1;
	}
}