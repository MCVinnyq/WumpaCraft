package com.vinny.wumpacraft;

import com.vinny.wumpacraft.init.WumpacraftItemGroup;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Wumpacraft.MOD_ID)
public class Wumpacraft {
	
	public static final String MOD_ID = "wumpacraft";
	
	public static final WumpacraftItemGroup WUMPACRAFT_CREATIVE_TAB = new WumpacraftItemGroup();
	
	public Wumpacraft() {
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
		
		MinecraftForge.EVENT_BUS.register(this);
		
	}
	
	public void setup(final FMLCommonSetupEvent event) {
		
	}
	
	public void clientSetup(final FMLClientSetupEvent event) {
		
	}
	
	public void enqueueIMC(final InterModEnqueueEvent event) {
		
	}
	
	public void processIMC(final InterModProcessEvent event) {
		
	}
	
	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event) {
		
	}

	
}
