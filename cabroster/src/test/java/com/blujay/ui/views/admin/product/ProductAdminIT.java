package com.blujay.ui.views.admin.product;

import org.junit.Assert;

import com.blujay.ui.views.admin.AbstractCrudIT;
import com.vaadin.testbench.elements.TextFieldElement;

public class ProductAdminIT extends AbstractCrudIT<ProductAdminViewElement> {

	@Override
	protected String getViewName() {
		return "Products";
	}

	@Override
	protected ProductAdminViewElement getViewElement() {
		return $(ProductAdminViewElement.class).first();
	}

	@Override
	protected void assertFormFieldsEmpty(ProductAdminViewElement view) {
		Assert.assertEquals("", view.getPrice().getText());
		Assert.assertEquals("", view.getPrice().getText());
	}

	@Override
	protected void populateNewEntity(ProductAdminViewElement view) {
		view.getName().setValue("New product");
		view.getPrice().setValue("$12.34");
	}

	@Override
	protected TextFieldElement getFirstFormTextField(ProductAdminViewElement view) {
		return view.getName();
	}

}
