package com.blujay.ui.view.admin.driver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.vaadin.artur.spring.dataprovider.FilterablePageableDataProvider;
import org.vaadin.spring.annotation.PrototypeScope;

import com.vaadin.data.provider.Query;
import com.vaadin.data.provider.QuerySortOrder;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.spring.annotation.SpringComponent;
import com.blujay.backend.data.entity.Driver;
import com.blujay.backend.service.DriverService;

@SpringComponent
@PrototypeScope
public class DriverAdminDataProvider extends FilterablePageableDataProvider<Driver, Object> {

    private static final long serialVersionUID = 1L;
    private final DriverService driverService;

    @Autowired
    public DriverAdminDataProvider(DriverService driverService) {
        this.driverService = driverService;
    }

    @Override
    protected Page<Driver> fetchFromBackEnd(Query<Driver, Object> query, Pageable pageable) {
        return driverService.findAnyMatching(getOptionalFilter(), pageable);
    }

    @Override
    protected int sizeInBackEnd(Query<Driver, Object> query) {
        return (int) driverService.countAnyMatching(getOptionalFilter());
    }

    @Override
    protected List<QuerySortOrder> getDefaultSortOrders() {
        List<QuerySortOrder> sortOrders = new ArrayList<>();
        sortOrders.add(new QuerySortOrder("email", SortDirection.ASCENDING));
        return sortOrders;
    }

}