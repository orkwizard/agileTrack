package com.spheres.agiletrack.core.server;

import java.net.InetSocketAddress;
import java.nio.ByteOrder;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.Bootstrap;
import org.jboss.netty.bootstrap.ConnectionlessBootstrap;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.buffer.HeapChannelBufferFactory;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.group.ChannelGroup;
import org.jboss.netty.channel.group.ChannelGroupFuture;
import org.jboss.netty.channel.group.DefaultChannelGroup;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;



/* 
 	AgileTrack Server 
 	Usando Netty para manejo de Protocol StarLink
 *
 */


public abstract class AgileTrackServer {
	private final Bootstrap bootstrap;
	//private final ConnectionlessBootstrap bootstrap;
	private final String protocol;
	
	public AgileTrackServer(){
		bootstrap = null;
		protocol ="http";
	}
	
	 public void startServer() throws Exception{
		 ChannelFactory factory = 
				 new NioServerSocketChannelFactory(Executors.newCachedThreadPool(),Executors.newCachedThreadPool());
		 ServerBootstrap boot = 	new ServerBootstrap(factory);
		 
		 boot.setPipelineFactory(new BasePipelineFactory());
		 
		 
		 /*boot.setPipelineFactory(new ChannelPipelineFactory() {
			
		 boot.setPipelineFactory(new BasePipelineFactory(this,"tcp"){
			@Override
			public ChannelPipeline getPipeline() throws Exception {
				// TODO Auto-generated method stub
				return Channels.pipeline(new StarLinkHandler());
			}
		});*/
		//boot.setOption(key, value);
		boot.setOption("child.tcpNoDelay", true);
		boot.setOption("child.keepAlive",true);
		boot.bind(new InetSocketAddress(8888));
		System.out.println("Server Started");
		 
	 }
	
	 public AgileTrackServer(Bootstrap bootstrap, String protocol) {
		 this.bootstrap = bootstrap;
	     this.protocol = protocol;
	     //Set appropriate channel factory
	        if (bootstrap instanceof ServerBootstrap) {
	            bootstrap.setFactory(GlobalChannelFactory.getFactory());
	        } else if (bootstrap instanceof ConnectionlessBootstrap) {
	            bootstrap.setFactory(GlobalChannelFactory.getDatagramFactory());
	        }

	        address = Context.getConfig().getString(protocol + ".address");
	        port = Context.getConfig().getInteger(protocol + ".port");
	        
	        /*bootstrap.setPipelineFactory(new BasePipelineFactory() {
	            @Override
	            protected void addSpecificHandlers(ChannelPipeline pipeline) {
	                AgileTrackServer.this.addSpecificHandlers(pipeline);
	            }
	        });*/   
	 }
	 
	 protected abstract void addSpecificHandlers(ChannelPipeline pipeline);
	 
	  /**
	     * Server port
	     */
	    private Integer port;

	    public Integer getPort() {
	        return port;
	    }

	    public void setPort(Integer port) {
	        this.port = port;
	    }

	    /**
	     * Server listening interface
	     */
	    private String address;

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	    /**
	     * Set endianness
	     */
	    public void setEndianness(ByteOrder byteOrder) {
	        bootstrap.setOption("bufferFactory", new HeapChannelBufferFactory(byteOrder));
	        bootstrap.setOption("child.bufferFactory", new HeapChannelBufferFactory(byteOrder));
	    }

	    /**
	     * Opened channels
	     */
	    private final ChannelGroup allChannels = new DefaultChannelGroup();

	    public ChannelGroup getChannelGroup() {
	        return allChannels;
	    }

	    public void setPipelineFactory(ChannelPipelineFactory pipelineFactory) {
	        bootstrap.setPipelineFactory(pipelineFactory);
	    }

	    public ChannelPipelineFactory getPipelineFactory() {
	        return bootstrap.getPipelineFactory();
	    }

	    /**
	     * Start server
	     */
	    public void start() {
	       InetSocketAddress endpoint;
	        if (address == null) {
	            endpoint = new InetSocketAddress(port);
	        } else {
	            endpoint = new InetSocketAddress(address, port);
	        }

	        Channel channel = null;
	        if (bootstrap instanceof ServerBootstrap) {
	            channel = ((ServerBootstrap) bootstrap).bind(endpoint);
	        } else if (bootstrap instanceof ConnectionlessBootstrap) {
	            channel = ((ConnectionlessBootstrap) bootstrap).bind(endpoint);
	        }

	        if (channel != null) {
	            getChannelGroup().add(channel);
	        }
	    }

	    /**
	     * Stop server
	     */
	    public void stop() {
	        ChannelGroupFuture future = getChannelGroup().close();
	        future.awaitUninterruptibly();
	    }
}