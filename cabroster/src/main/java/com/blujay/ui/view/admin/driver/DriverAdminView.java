package com.blujay.ui.view.admin.driver;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.BeanValidationBinder;
import com.vaadin.spring.annotation.SpringView;
import com.blujay.backend.data.entity.Driver;
import com.blujay.ui.views.admin.AbstractCrudView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Component.Focusable;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;

@SpringView
public class DriverAdminView extends AbstractCrudView<Driver> {

    private static final long serialVersionUID = 1L;

    private final DriverAdminPresenter presenter;

    private final DriverAdminViewDesign userAdminViewDesign;

    @Autowired
    public DriverAdminView(DriverAdminPresenter presenter) {
        this.presenter = presenter;
        userAdminViewDesign = new DriverAdminViewDesign();
    }

    @PostConstruct
    private void init() {
        presenter.init(this);
        getGrid().setColumns("name", "email", "licenseNumber", "contactNo", "status");
    }

    @Override
    public DriverAdminViewDesign getViewComponent() {
        return userAdminViewDesign;
    }

    @Override
    protected DriverAdminPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected Grid<Driver> getGrid() {
        return getViewComponent().list;
    }

    @Override
    protected void setGrid(Grid<Driver> grid) {
        getViewComponent().list = grid;
    }

    @Override
    protected Component getForm() {
        return getViewComponent().form;
    }

    @Override
    protected Button getAdd() {
        return getViewComponent().add;
    }

    @Override
    protected Button getCancel() {
        return getViewComponent().cancel;
    }

    @Override
    protected Button getDelete() {
        return getViewComponent().delete;
    }

    @Override
    protected Button getUpdate() {
        return getViewComponent().update;
    }

    @Override
    protected TextField getSearch() {
        return getViewComponent().search;
    }

    @Override
    protected Focusable getFirstFormField() {
        return getViewComponent().email;
    }

    @Override
    public void bindFormFields(BeanValidationBinder<Driver> binder) {
        binder.bindInstanceFields(getViewComponent());

    }

}
