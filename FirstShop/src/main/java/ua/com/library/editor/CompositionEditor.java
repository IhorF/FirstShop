package ua.com.library.editor;

import java.beans.PropertyEditorSupport;

import ua.com.library.service.CompositionService;

public class CompositionEditor extends PropertyEditorSupport {

	private final CompositionService compositionService;

	public CompositionEditor(CompositionService compositionService) {
		this.compositionService = compositionService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(compositionService.findOne(Integer.parseInt(text)));
	}

	


}
