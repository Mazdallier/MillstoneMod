package com.millstone.trees;

import java.util.List;

import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.millstone.MillstoneMod;
import com.millstone.lib.References;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class LogBlock extends BlockLog{
	
	public static final String[] logs = new String[] {"willow", "palm", "dreadwood", "redwood", "applewood", "cherry", "baobab"};
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tabs, List list){
		
		for (int i = 0; i < logs.length; i++){
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		this.field_150167_a = new IIcon[logs.length];
		this.field_150166_b = new IIcon[logs.length];
		
		for (int i = 0; i < this.field_150167_a.length; i++){
			this.field_150167_a[i] = iconRegister.registerIcon(References.MODID + ":" + this.getUnlocalizedName().substring(5) + "_" + logs[i]);
			this.field_150166_b[i] = iconRegister.registerIcon((References.MODID + ":" + this.getUnlocalizedName().substring(5) + "_" + logs[i] + "_top"));

		}
	}
}
