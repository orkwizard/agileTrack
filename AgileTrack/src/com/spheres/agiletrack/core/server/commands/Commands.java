package com.spheres.agiletrack.core.server.commands;

import java.util.HashMap;

public class Commands {
	private static final HashMap<String,Command> commands;
	static{
		commands = new HashMap<String,Command>();
		commands.put("01",new Command("1","Wake up",0));
		commands.put("02",new Command("2","Confirmation",0));
		commands.put("03",new Command("3","Request parameter",0));
		commands.put("04",new Command("4","Set parameter",0));
		commands.put("05",new Command("5","Location request",0));
		commands.put("06",new Command("6","Event report",0));
		commands.put("07",new Command("7","Voltage information",0));
		commands.put("08",new Command("8","Request analog voltage threshold configuration",0));
		commands.put("09",new Command("9","Set analog voltage threshold configuration",0));
		commands.put("10",new Command("10","Request geo-zone configuration",0));
		commands.put("11",new Command("11","Set geo-zone configuration",0));
		commands.put("12",new Command("12","Request output state",0));
		commands.put("13",new Command("13","Set output state",0));
		commands.put("14",new Command("14","Request event configuration",0));
		commands.put("15",new Command("15","Set event configuration",0));
		commands.put("16",new Command("16","Request digital input states",0));
		commands.put("17",new Command("17","Request digital input configuration",0));
		commands.put("18",new Command("18","Set digital input configuration",0));
		commands.put("19",new Command("19","Request iButton state",0));
		commands.put("20",new Command("20","LCA Alarm status",0));
		commands.put("21",new Command("21","LCA Alarm command",0));
		commands.put("22",new Command("22","Tracking",0));
		commands.put("23",new Command("23","Request immobilizer rule",0));
		commands.put("24",new Command("24","Set immobilizer rule",0));
		commands.put("25",new Command("25","Disarm System",0));
		commands.put("26",new Command("26","Disarm motorcycle alarm",0));
		commands.put("27",new Command("27","Request speed limit configuration",0));
		commands.put("28",new Command("28","Set speed limit configuration",0));
		commands.put("29",new Command("29","Unit ID changed",0));
		commands.put("30",new Command("30","External device message",2.06));
		commands.put("31",new Command("31","Canalog data report",0));
		commands.put("32",new Command("32","Canalog accident",0));
		commands.put("33",new Command("33","Clear Canalog accident data",0));
		commands.put("34",new Command("34","Canalog status",0));
		commands.put("35",new Command("35","Update firmware for external device",0));
		commands.put("36",new Command("36","Request Canalog parameters",0));
		commands.put("37",new Command("37","Change Canalog parameters",0));
		commands.put("38",new Command("38","Send custom SMS",2.06));
		commands.put("39",new Command("39","Write data on iButton",2.08));
		commands.put("40",new Command("40","Start of raw data",2.08));
		commands.put("41",new Command("41","End of raw data",2.08));
		commands.put("42",new Command("42","Read connected iButton NVram",2.08));
		commands.put("43",new Command("43","Request pattern configuration",0));
		commands.put("44",new Command("44","Set pattern configuration",0));
		commands.put("45",new Command("45","Get multiple parameters",2.12));
		commands.put("46",new Command("46","Set multiple parameters",2.12));
		commands.put("47",new Command("47","Arm System",2.18));
		commands.put("48",new Command("48","Dynamic parameter request",2.18));
		commands.put("49",new Command("49","Request list of allowed codes",2.18));
		commands.put("50",new Command("50","Modify list of allowed drivers",2.18));
		commands.put("51",new Command("51","Request temperature configuration",2.18));
		commands.put("52",new Command("52","Set temperature configuration",2.18));
		commands.put("53",new Command("53","Request external device version",2.22));
		commands.put("54",new Command("54","Program CAN odometer",2.24));
		commands.put("55",new Command("55","Scan for Dallas iButtons",2.24));
		commands.put("96",new Command("96","Current location report",2.24));
		commands.put("98",new Command("98","Connect to configuration server",2.06));
		commands.put("99",new Command("99","Reset",0));
	}
	
	public static Command get(String code){
		 return commands.get(code);
		
	}
	
}
