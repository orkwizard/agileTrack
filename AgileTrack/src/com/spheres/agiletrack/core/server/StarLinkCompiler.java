package com.spheres.agiletrack.core.server;

import org.jboss.netty.channel.ChannelHandlerContext;

import com.spheres.agiletrack.core.server.commands.Commands;
import com.spheres.agiletrack.core.server.commands.Command;
import com.spheres.agiletrack.entities.json.JMessage;

public class StarLinkCompiler {

	public static boolean compile(JMessage m, ChannelHandlerContext ctx){
		
		//Process message
		int command = m.getCommand();
		Command com;
		if(command<10)
			 com = Commands.get("0"+command);
		else
			 com = Commands.get(""+command);
		
		if(com==null)		
			return false;
		
		ctx.getChannel().write(com.toString());
		return true;
	}
}
