package com.millstone.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

import com.millstone.MillstoneMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SilverOre extends Block{

	public SilverOre(Material material) {
		super(material);
		
		this.setHardness(3F);
		this.setResistance(5F);
		this.setStepSound(soundTypeStone);
		this.setCreativeTab(MillstoneMod.tabMillstone);
	}
	
	public Block getDropped(int i, Random random, int j){
		return MillstoneMod.silverOre;
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		return this.blockIcon;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon(MillstoneMod.MODID + ":" + "firerack");
		
	}
}