package com.ebook.server;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

public class CustomerRestfulServer {

	public static void main(String args[]) throws Exception {
        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
        factoryBean.setResourceClasses(com.ebook.service.customer.resource.customerResource.class);
        factoryBean.setResourceProvider(new SingletonResourceProvider(new com.ebook.service.customer.resource.customerResource()));
        factoryBean.setAddress("http://localhost:8080/");
        Server server = factoryBean.create();

        System.out.println("Bookstore System Restful Server ready...............................");
	}

}
