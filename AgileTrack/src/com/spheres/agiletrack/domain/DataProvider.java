package com.spheres.agiletrack.domain;

import com.spheres.agiletrack.entities.Client;

public interface DataProvider {
	 Client authenticate(String userName, String password);
}
