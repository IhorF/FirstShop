package ua.com.library.editor;

import java.beans.PropertyEditorSupport;

import ua.com.library.service.SizeService;

public class SizeEditor extends PropertyEditorSupport{
	
	private final SizeService sizeService;

	public SizeEditor(SizeService sizeService) {
		this.sizeService = sizeService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(sizeService.findOne(Integer.parseInt(text)));
	}

}