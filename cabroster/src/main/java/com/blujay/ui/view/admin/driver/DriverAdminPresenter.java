package com.blujay.ui.view.admin.driver;

import java.io.Serializable;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import com.blujay.backend.data.entity.Driver;
import com.blujay.backend.service.DriverService;
import com.blujay.ui.navigation.NavigationManager;
import com.blujay.ui.views.admin.AbstractCrudPresenter;

@SpringComponent
@ViewScope
public class DriverAdminPresenter extends AbstractCrudPresenter<Driver, DriverService, DriverAdminView> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    public DriverAdminPresenter(DriverAdminDataProvider driverAdminDataProvider, NavigationManager navigationManager, DriverService service, BeanFactory beanFactory) {
        super(navigationManager, service, Driver.class, driverAdminDataProvider, beanFactory);
    }

    @Override
    protected void editItem(Driver item) {
        super.editItem(item);
    }

}