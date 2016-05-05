package com.spheres.agiletrack.data;

import java.util.Iterator;

import com.spheres.agiletrack.domain.DataProvider;
import com.spheres.agiletrack.entities.Client;
import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.data.Container.Filter;
import com.vaadin.data.Item;
import com.vaadin.data.util.filter.Compare;

public class JPADataProvider implements DataProvider {

	private final static String Persistence_UNIT ="Agile";
	JPAContainer<Client> clientes = JPAContainerFactory.makeReadOnly(Client.class,Persistence_UNIT);
	
	@Override
	public Client authenticate(String userName, String password) {
		// TODO Auto-generated method stub
		clientes.removeAllContainerFilters();
		Filter filter = new Compare.Equal("clientLogin",userName.trim());
		Filter filter2 = new Compare.Equal("clientPassword", password.trim());
		clientes.addContainerFilter(filter);
		clientes.addContainerFilter(filter2);
		if(clientes.size()>0){
			Iterator<Object> i = clientes.getItemIds().iterator();
			Client c = clientes.getItem(i.next()).getEntity();
			System.out.println("Usuario : " + c.getClientName());
			return c;
		}
		return null;
	}
}
