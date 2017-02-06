package ua.com.library.editor;

import java.beans.PropertyEditorSupport;

import ua.com.library.service.ColorService;

public class ColorEditor extends PropertyEditorSupport {

	private final ColorService colorService;

	public ColorEditor(ColorService colorService) {
		this.colorService = colorService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(colorService.findOne(Integer.parseInt(text)));
	}

}
