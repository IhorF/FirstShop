package ua.com.library.editor;

import java.beans.PropertyEditorSupport;

import ua.com.library.service.CommodityService;

public class CommodityEditor extends PropertyEditorSupport {

	private final CommodityService commodityService;

	public CommodityEditor(CommodityService commodityService) {
		this.commodityService = commodityService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(commodityService.findOne(Integer.parseInt(text)));
	}

}
