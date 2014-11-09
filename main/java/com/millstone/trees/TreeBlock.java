package com.millstone.trees;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.millstone.MillstoneMod;
import com.millstone.lib.References;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TreeBlock extends Block{

	public TreeBlock()
	{
	super(Material.wood);
	setBlockName("planks");
	setCreativeTab(MillstoneMod.tabMillstone);
	
	}
	 
	@Override
	public int damageDropped(int par1)
	{
	return par1;
	}
	 
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	 
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
	icons = new IIcon[8];
	 
	for (int i = 0; i < icons.length; i++)
	{
	icons[i] = par1IconRegister.registerIcon(References.MODID + ":" + this.getUnlocalizedName() + i);
	}
	}
	 
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int par1, int par2)
	{
	switch (par2)
	{
	case 0:
	return icons[0];
	case 1:
	{
	switch (par1)
	{
	case 0:
	return icons[1];
	case 1:
	return icons[2];
	case 2:
	return icons[3];
	case 3:
	return icons[4];
	case 4:
	return icons[5];
	case 5:
	return icons[6];
	default:
	return icons[7];
	}
	}
	default:
	{
	System.out.println("Invalid metadata for " + this.getUnlocalizedName());
	return icons[0];
	}
	}
	}
	 
	//@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
	for (int i = 0; i < 7; i++)
	{
	par3List.add(new ItemStack(par1, 1, i));
	}
	}


}
