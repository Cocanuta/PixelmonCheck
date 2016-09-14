package com.snatchybuckles.pixelmoncheck.gui;

import com.snatchybuckles.pixelmoncheck.PixelmonCheck;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiErrorScreen;
import net.minecraftforge.fml.client.CustomModLoadingErrorDisplayException;
import net.minecraftforge.fml.client.GuiCustomModLoadingErrorScreen;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class PixelmonMissingScreen extends CustomModLoadingErrorDisplayException
{

	@Override
	public void initGui(GuiErrorScreen errorScreen, FontRenderer fontRenderer)
	{

	}

	@Override
	public void drawScreen(GuiErrorScreen errorScreen, FontRenderer fontRenderer, int mouseRelX, int mouseRelY, float tickTime)
	{
		errorScreen.drawDefaultBackground();
		int offset = 50;
		errorScreen.drawCenteredString(fontRenderer, "Pixelmon Missing!", errorScreen.width/2, (errorScreen.height/2) - offset, 0xFFFFFF);
		offset -= 15;
		errorScreen.drawCenteredString(fontRenderer, "-----------------------------------------", errorScreen.width/2, (errorScreen.height/2) - offset, 0xFFFFFF);
		offset -= 15;
		errorScreen.drawCenteredString(fontRenderer, "The SnatchyBuckles modpack requires 'Pixelmon " + PixelmonCheck.PIXELMON_VERSION + "' to run.", errorScreen.width/2, (errorScreen.height/2) - offset, 0xFFFFFF);
		offset -= 15;
		errorScreen.drawCenteredString(fontRenderer, "Please install Pixelmon to continue.", errorScreen.width/2, (errorScreen.height/2) + offset, 0xFFFFFF);
	}

}
