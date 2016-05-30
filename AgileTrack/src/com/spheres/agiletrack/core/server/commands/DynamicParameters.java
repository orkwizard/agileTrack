package com.spheres.agiletrack.core.server.commands;

import java.util.HashMap;

import com.mysql.fabric.xmlrpc.base.Param;

public class DynamicParameters {

	/*
	* Unit parameters
	Parameter	Description	Example	Version
	#IMEI#	The modem's IMEI number	358281002705360	 
	#UID#	The unit's soft id (see Unit ID selection)	0004D2	 
	#FID#	The unit's factory serial number	0004D2	 
	#VER#	The unit's firmware version	2.11	2.12
	#ODO#	Odometer reading (see Odometer source)	012345	 
	#ODOD#	Odometer reading (see Odometer source)	012345.678	2.07
	#USER#	User defined dynamic field	hello world	2.18
	 */
	
	private HashMap<String,Parameter> unit_parameters;
	
	/*
	 * Event information
	 * The following fields exist only for Event report events:

		Parameter	Description	Example
		#EID#	Event number	01
		#EDSC#	Event description	Location

	 */
	private HashMap<String,Parameter> event_parameter;
	
	
	
	
}
